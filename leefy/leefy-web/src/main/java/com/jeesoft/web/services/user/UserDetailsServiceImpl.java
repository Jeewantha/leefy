/*******************************************************************************
 * 	
 * 	Leefy is a simple social network to narrow the gap between people speaking different
 * 	languages and to aid the language learning process.
 *     Copyright (C) 2015  Jeewantha Samaraweera
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *     
 *******************************************************************************/

package com.jeesoft.web.services.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import com.jeesoft.api.dto.AdminDetails;
import com.jeesoft.api.dto.ParentDetails;
import com.jeesoft.api.dto.Privilege;
import com.jeesoft.api.dto.StudentDetails;
import com.jeesoft.api.dto.UserDefinedRoleDetails;
import com.jeesoft.api.dto.UserLogin;
import com.jeesoft.api.enums.UserRole;
import com.jeesoft.api.exception.LeefyAppException;
import com.jeesoft.web.dao.UserDao;


/**
 * UserDetailService implementation for user authentication.
 */
public class UserDetailsServiceImpl implements UserDetailsService {
    
    /** string constant for holding max login attempts. */
    private static final int MAX_LOGIN_COUNT = 3;
    
    /** string constant for holding error massage user not found. */
    private static final String USER_NOT_FOUND = "user not found";
    
    /** holds userDao for the UserDetailService. */
    private UserDao userDao;
    
    /** holds userService for the UserDetailService. */
    private UserService userService;
    
    /**
     * Sets an instance of setUserService.
     * 
     * @param userServiceObj object to set
     */
    public void setUserService(UserService userServiceObj) {

        this.userService = userServiceObj;
    }
    
    /**
     * Method is to load the user by name.
     * 
     * @param userName - userName.
     * @return UserDetail for respective userName.
     * @see org.springframework.security.core.userdetails.UserDetailsService#loadUserByUsername(java.lang.String)
     */
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String userName) {

        UserLogin userLogin = userDao.getAnyUserLoginByName(userName);
        if (userLogin == null) {
            throw new UsernameNotFoundException(USER_NOT_FOUND);
        }
        return buildUserFromUserEntity(userLogin);
    }
    
    /**
     * Helper method is to assemble UserLogin Details into UserDetails.
     * 
     * @param userLogin - UserLogin.
     * @return User - implementation of UserDetails interface.
     */
    @Transactional(readOnly = true)
    User buildUserFromUserEntity(UserLogin userLogin) {

        User systemUser = null;
        
        String username = userLogin.getUsername();
        int userRoleId = userLogin.getUserRoleId();
        String password = userLogin.getPassword();
        boolean enabled = userLogin.isStatus();
        boolean accountNonLocked = true;
        String userRole = "";
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        
        /* set user login attempts */
        if (userLogin.getLoginAttempts() >= MAX_LOGIN_COUNT) {
            accountNonLocked = false;
        }
        
        /* load role privileges */
        com.jeesoft.api.dto.UserRole userRoleObj = null;
        
        try {
            userRoleObj = userService.findUserRole(userLogin.getUserRoleId());
            List<Privilege> privileges = userService.getPrivilegesByUserRole(userRoleObj);
            
            for (Privilege privilege : privileges) {
                authorities.add(new GrantedAuthorityImpl(privilege.getName()));
            }
            
        } catch (LeefyAppException e) {
            e.printStackTrace();
        }
        
        if (userLogin.getUserRoleId() == UserRole.ROLE_ADMIN.getUserRoleId()) {
            userRole = UserRole.ROLE_ADMIN.toString();
            
            systemUser =
                    new AdminDetails(username, password, userRole, userRoleId, userLogin.getUserIdentificationNo(),
                            enabled, accountNonLocked, authorities);
            
        } else if (userLogin.getUserRoleId() == UserRole.ROLE_TEACHER.getUserRoleId()) {
            userRole = UserRole.ROLE_TEACHER.toString();
            systemUser =
                    new AdminDetails(username, password, userRole, userRoleId, userLogin.getUserIdentificationNo(),
                            enabled, accountNonLocked, authorities);
            
        } else if (userLogin.getUserRoleId() == UserRole.ROLE_STUDENT.getUserRoleId()) {
            userRole = UserRole.ROLE_STUDENT.toString();
            systemUser =
                    new StudentDetails(username, password, userRole, userRoleId, userLogin.getUserIdentificationNo(),
                            enabled, accountNonLocked, authorities);
        } else if (userLogin.getUserRoleId() == UserRole.ROLE_CLERICALSTAFF.getUserRoleId()) {
            userRole = UserRole.ROLE_CLERICALSTAFF.toString();
            systemUser =
                    new AdminDetails(username, password, userRole, userRoleId, userLogin.getUserIdentificationNo(),
                            enabled, accountNonLocked, authorities);
        } else if (userLogin.getUserRoleId() == UserRole.ROLE_PARENT.getUserRoleId()) {
            userRole = UserRole.ROLE_PARENT.toString();
            systemUser =
                    new ParentDetails(username, password, userRole, userRoleId, userLogin.getUserIdentificationNo(),
                            enabled, accountNonLocked, authorities);
        } else {
            
            userRole = userRoleObj.getRole();
            systemUser =
                    new UserDefinedRoleDetails(username, password, userRole, userRoleId, enabled, accountNonLocked,
                            authorities);
        }
        
        return systemUser;
    }
    
    /**
     * set User Dao for the UserDetailsService.
     * 
     * @param userDaoVal the userDao to set
     */
    public void setUserDao(UserDao userDaoVal) {

        this.userDao = userDaoVal;
    }
    
}
