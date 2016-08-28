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
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.transaction.annotation.Transactional;

import com.jeesoft.api.dao.ModuleDao;
import com.jeesoft.api.dao.PrivilegeDependencyDao;
import com.jeesoft.api.dao.RolePrivilegeDao;
import com.jeesoft.api.dao.RoleTabDao;
import com.jeesoft.api.dao.SecurityQuestionsDao;
import com.jeesoft.api.dao.UserDao;
import com.jeesoft.api.dao.UserLoginDao;
import com.jeesoft.api.dao.UserRoleDao;
import com.jeesoft.api.dao.UserSecurityQuestionsDao;
import com.jeesoft.api.dto.AdminDetails;
import com.jeesoft.api.dto.Module;
import com.jeesoft.api.dto.Privilege;
import com.jeesoft.api.dto.RolePrivilege;
import com.jeesoft.api.dto.RoleTab;
import com.jeesoft.api.dto.SecurityQuestions;
import com.jeesoft.api.dto.Tab;
import com.jeesoft.api.dto.UserDefinedRoleDetails;
import com.jeesoft.api.dto.UserLogin;
import com.jeesoft.api.dto.UserRole;
import com.jeesoft.api.dto.UserSecurityQuestions;
import com.jeesoft.common.constants.LeefyConstants;
import com.jeesoft.common.exception.InvalidIdentificationNoException;
import com.jeesoft.common.exception.LeefyAppException;
import com.jeesoft.common.exception.NonUniqueEmailException;
import com.jeesoft.common.exception.NonUniqueUserNameException;
import com.jeesoft.common.exception.PastStaffException;
import com.jeesoft.web.util.PropertyReader;


/**
 * UserDetailService for user authentication.
 */
public class UserServiceImpl implements UserService {
    
    /** holds userdao. */
    private UserDao userDao;
    
    /** holds userRoledao. */
    private UserRoleDao userRoleDao;
    
    /** holds the passwordEncoder. */
    private PasswordEncoder passwordEncoder;
    
    /** holds the userLoginDao. */
    private UserLoginDao userLoginDao;
    
    /** holds the SecurityQuestions. */
    private SecurityQuestionsDao securityQuestionsDao;
    
    /** holds the User specific security questions. */
    private UserSecurityQuestionsDao userSecurityQuestionsDao;
    
    /** holds the role specific tabs. */
    private RoleTabDao roleTabDao;
    
    /** holds the modules. */
    private ModuleDao moduleDao;
    
    /** holds the role specific tabs. */
    private RolePrivilegeDao rolePrivilegeDao;
    
    /** holds the PrivilegeDependencyDao. */
    private PrivilegeDependencyDao privilegeDependencyDao;
    
    public PasswordEncoder getPasswordEncoder() {
        return passwordEncoder;
    }

    public UserRoleDao getUserRoleDao() {
        return userRoleDao;
    }

    public UserLoginDao getUserLoginDao() {
        return userLoginDao;
    }

    /**
     * return userDao of the Student.
     * 
     * @return the userdao
     */
    public UserDao getUserDao() {

        return userDao;
    }
    
    /**
     * set the userDao.
     * 
     * @param moduleDaoObj the moduleDao to set
     */
    public void setModuleDao(ModuleDao moduleDaoObj) {

        this.moduleDao = moduleDaoObj;
    }
    
    /**
     * set the userDao.
     * 
     * @param userDaoVal the userdao to set
     */
    public void setUserDao(UserDao userDaoVal) {

        this.userDao = userDaoVal;
    }
    
    /**
     * set the PrivilegeDependencyDao.
     * 
     * @param privilegeDependencyDaoObj the PrivilegeDependencyDao to set
     */
    public void setPrivilegeDependencyDao(PrivilegeDependencyDao privilegeDependencyDaoObj) {

        this.privilegeDependencyDao = privilegeDependencyDaoObj;
    }
    
    /**
     * Set the userLoginDao.
     * 
     * @param userLoginDaoValue the userLoginDao to set
     */
    public void setUserLoginDao(UserLoginDao userLoginDaoValue) {

        this.userLoginDao = userLoginDaoValue;
    }
    
    /**
     * set passwordEncoder.
     * 
     * @param passwordEncoderVal the passwordEncoder to set
     */
    public void setPasswordEncoder(PasswordEncoder passwordEncoderVal) {

        this.passwordEncoder = passwordEncoderVal;
    }
    
    /**
     * get available userRole list.
     * 
     * @throws LeefyAppException LeefyAppException
     * @return available userRoleList.
     */
    public List<UserRole> getUserRoleList() throws LeefyAppException {

        return userRoleDao.findAll(UserRole.class);
    }
    
    /**
     * set userRoleDao for the userService.
     * 
     * @param userRoleDaoVal the userRoleDao to set
     */
    public void setUserRoleDao(UserRoleDao userRoleDaoVal) {

        this.userRoleDao = userRoleDaoVal;
    }
    
    /**
     * Get the users Security Questions.
     * 
     * @return UserSecurityQuestionsDao
     */
    public UserSecurityQuestionsDao getUserSecurityQuestionsDao() {

        return userSecurityQuestionsDao;
    }
    
    /**
     * Set the UserSecurityQuestionsDao for User.
     * 
     * @param userSecurityQuestionDao user security question to be set.
     */
    public void setUserSecurityQuestionsDao(UserSecurityQuestionsDao userSecurityQuestionDao) {

        this.userSecurityQuestionsDao = userSecurityQuestionDao;
    }
    
    /**
     * Get the Security Questions.
     * 
     * @return securityQuestionsDao.
     */
    public SecurityQuestionsDao getSecurityQuestionsDao() {

        return securityQuestionsDao;
    }
    
    /**
     * set the SecurityQuestionsDao.
     * 
     * @param securityQuestionsDaoVal to be set.
     */
    public void setSecurityQuestionsDao(SecurityQuestionsDao securityQuestionsDaoVal) {

        this.securityQuestionsDao = securityQuestionsDaoVal;
    }
    
    /**
     * set the RoleTabDao.
     * 
     * @param roleTabDaoObj to be set.
     */
    public void setRoleTabDao(RoleTabDao roleTabDaoObj) {

        this.roleTabDao = roleTabDaoObj;
    }
    
    /**
     * set the RolePrivilegeDao.
     * 
     * @param rolePrivilegeDaoObj to be set.
     */
    public void setRolePrivilegeDao(RolePrivilegeDao rolePrivilegeDaoObj) {

        this.rolePrivilegeDao = rolePrivilegeDaoObj;
    }
    
    /**
     * create a system user.
     * 
     * @param userLogin - userLogin
     * @throws LeefyAppException LeefyAppException
     * @return flag indicates whether userLogin creation is succeeded.
     */
    public boolean createUser(UserLogin userLogin, final int identificationNo) throws LeefyAppException {

        boolean validityStatus = false;
        
        userLogin.setPassword(passwordEncoder.encodePassword(userLogin.getPassword(), userLogin.getUsername()));
        userLogin.setModifiedTime(new Date());
        UserLogin userLoginVal = userDao.save(userLogin);
        
        if (userLoginVal != null) {
            validityStatus = true;
        }
        
        return validityStatus;
    }

    /**
     * {@inheritDoc}
     */
    public UserLogin createSystemUser(UserLogin userLogin) throws LeefyAppException, NonUniqueEmailException, NonUniqueUserNameException {

        boolean isUserRoleNotAvailable = userLogin.getUserRoleId() == 0;
        
        if(isUserRoleNotAvailable){
            throw new LeefyAppException(PropertyReader.getPropertyValue(LeefyConstants.LEEFY_ERROR_MSG_PROPERTY,
                    LeefyConstants.USER_CREATE_USER_ROLE_NOT_AVAILABLE_ERROR,LocaleContextHolder.getLocale()));
        }

        boolean isUsernameExist = getAnyUser(userLogin.getUsername()) != null;
        
        if (isUsernameExist) {
            throw new NonUniqueUserNameException(PropertyReader.getPropertyValue(LeefyConstants.LEEFY_ERROR_MSG_PROPERTY,
                    LeefyConstants.ERROR_MESSAGE_UNIQUE_UNAME,LocaleContextHolder.getLocale()));
        }
        
        boolean isEmailExist = getAnyUserByEmail(userLogin.getEmail()) != null;
        
        if (isEmailExist) {
            throw new NonUniqueUserNameException(PropertyReader.getPropertyValue(LeefyConstants.LEEFY_ERROR_MSG_PROPERTY,
                    LeefyConstants.ERROR_MESSAGE_UNIQUE_EMAIL,LocaleContextHolder.getLocale()));
        }
        userLogin.setPassword(passwordEncoder.encodePassword(userLogin.getPassword(), userLogin.getUsername()));
        userLogin.setStatus(true);
        return userDao.save(userLogin);
    }
    
    /**
     * edit a system user.
     * 
     * @param userLogin - userLogin
     * @throws LeefyAppException LeefyAppException
     * @throws NonUniqueUserNameException - UniqueUserNameEmailException
     * @throws PastStaffException - PastStaffException
     * @throws InvalidIdentificationNoException - InvalidIdentificationNoException
     */
    public void editSystemUser(UserLogin userLogin) throws LeefyAppException, NonUniqueUserNameException,
            PastStaffException, InvalidIdentificationNoException {

        int identificationKey = 0;
        int roleId = userLogin.getUserRoleId();
        UserLogin existUser = null;
        
        /** validate email */
        if (!findUserLogin(userLogin.getUserLoginId()).getEmail().equals(userLogin.getEmail())) {
            if (getAnyUserByEmail(userLogin.getEmail()) != null) {
                throw new NonUniqueUserNameException(PropertyReader.getPropertyValue(LeefyConstants.LEEFY_ERROR_MSG_PROPERTY,
                        LeefyConstants.ERROR_MESSAGE_UNIQUE_EMAIL,LocaleContextHolder.getLocale()));
            }
        }
        
        /** Initialize the user object */
        // get the existing user
        existUser = findUserLogin(userLogin.getUserLoginId());
        userLogin.setLoginAttempts(existUser.getLoginAttempts());
        userLogin.setPassword(passwordEncoder.encodePassword(userLogin.getPassword(), userLogin.getUsername()));
        userLogin.setGeneratedPassword(true);
        userLogin.setStatus(true);
        
        /** Update User Object */
        userDao.update(userLogin);
    }
    
    /**
     * edit a system user.
     * 
     * @param userLogin - userLogin
     * @throws LeefyAppException LeefyAppException
     */
    public void editUser(UserLogin userLogin) throws LeefyAppException {

        userLogin.setPassword(passwordEncoder.encodePassword(userLogin.getPassword(), userLogin.getUsername()));
        userLogin.setModifiedTime(new Date());
        userDao.update(userLogin);
    }
    
    /**
     * encode password.
     * 
     * @param userLogin - userLogin
     * @throws LeefyAppException LeefyAppException
     * @return encoded password.
     */
    public String encodePassword(UserLogin userLogin) throws LeefyAppException {

        return passwordEncoder.encodePassword(userLogin.getPassword(), userLogin.getUsername());
    }
    
    /**
     * Retrieve all the available list of UserLogin.
     * 
     * @return list of UserLogin.
     * @throws LeefyAppException - throw detailed exception.
     */
    public List<UserLogin> getUserLoginList() throws LeefyAppException {

        return userLoginDao.findAll(UserLogin.class);
    }
    
    /**
     * {@inheritDoc}
     */
    public List<UserLogin> getUserLoginListByUserRole(List<Integer> userRoleIdList) throws LeefyAppException {

        return userLoginDao.getUserLoginListByUserRole(userRoleIdList);
    }
    
    /**
     * Retrieve the available UserLogin object.
     * 
     * @param userName - username.
     * @return UserLogin object.
     * @throws LeefyAppException - throw detailed exception.
     */
    public UserLogin getAnyUser(String userName) throws LeefyAppException {

        return userLoginDao.getAnyUserByName(userName);
    }
    
    /**
     * Retrieve the available UserRole object.
     * 
     * @param role - role.
     * @return UserRole object.
     * @throws LeefyAppException - throw detailed exception.
     */
    public UserRole getUserRoleByRoleName(String role) throws LeefyAppException {

        return userRoleDao.getUserRoleByRoleName(role);
    }
    
    /**
     * Retrieve the available UserLogin object.
     * 
     * @param userName - username.
     * @return UserLogin object.
     * @throws LeefyAppException - throw detailed exception.
     */
    public UserLogin getUser(String userName) throws LeefyAppException {

        return userLoginDao.getUserLoginByName(userName);
    }
    
    /**
     * Get the any users UserLogin object by passing the user's email.
     * 
     * @param email - String
     * @throws LeefyAppException LeefyAppException
     * @return returns the UserLogin object.
     */
    public UserLogin getAnyUserByEmail(String email) throws LeefyAppException {

        return userLoginDao.getAnyUserByEmail(email);
    }
    
    /**
     * reset the System user password.
     * 
     * @param userLogin - userLogin
     * @throws LeefyAppException LeefyAppException
     * @return flag indicates whether the password has successfully changed or not.
     */
    public String resetPassword(UserLogin userLogin) throws LeefyAppException {

        String newPassword = generateRandomPassword();
        
        userLogin.setPassword(passwordEncoder.encodePassword(newPassword, userLogin.getUsername()));
        
        userLogin.setGeneratedPassword(Boolean.TRUE);
        
        userLogin.setModifiedTime(new Date());
        
        userDao.update(userLogin);
        
        return newPassword;
    }
    
    /**
     * Generate a random password.
     * 
     * @throws LeefyAppException LeefyAppException
     * @return Returns the randomly generated pasword.
     */
    public String generateRandomPassword() throws LeefyAppException {

        Random random = new Random();
        StringBuilder password = new StringBuilder(LeefyConstants.PASSWORDLENGTH);
        for (int i = 0; i < LeefyConstants.PASSWORDLENGTH; i++) {
            password.append(LeefyConstants.RANDOMSTRING.charAt(random.nextInt(LeefyConstants.RANDOMSTRING.length())));
            
        }
        
        return password.toString();
    }
    
    /**
     * Retrieve logged in user by userName.
     * 
     * @param strName - String
     * @return UserLogin Object.
     * @throws LeefyAppException - throw detailed exception.
     */
    public UserLogin getUserByName(String strName) throws LeefyAppException {

        return (UserLogin) userDao.getUserLoginByName(strName);
    }
    
    /**
     * Update a system user.
     * 
     * @param userLogin - userLogin
     * @throws LeefyAppException LeefyAppException
     */
    public void updateUser(UserLogin userLogin) throws LeefyAppException {

        userLoginDao.update(userLogin);
    }
    
    /**
     * Delete a system user.
     * 
     * @param userLogin - userLogin
     * @throws LeefyAppException LeefyAppException
     */
    public void deleteUser(UserLogin userLogin) throws LeefyAppException {

        userLoginDao.delete(userLogin);
    }
    
    /**
     * Get all the Security Questions available in the system.
     * 
     * @return UserSecurityQuestions object which has all the security questions.
     * @throws LeefyAppException -throws when failed.
     */
    public List<SecurityQuestions> getAllSecurityQuestions() throws LeefyAppException {

        return securityQuestionsDao.findAll(SecurityQuestions.class);
    }
    
    /**
     * Create a user Security Question for this user.The security questions and answers are updated security
     * questions and answers if it is already there.
     * 
     * @param userSecurityQuestions - a question to be asked form users.
     * @throws LeefyAppException throws when failed.
     */
    public void createSystemUserSecurityQuestion(UserSecurityQuestions userSecurityQuestions) throws LeefyAppException {

        userSecurityQuestionsDao.save(userSecurityQuestions);
    }
    
    /**
     * Get all the UserSecurityQuestions as a list.
     * 
     * @return list of user security questions.
     * @throws LeefyAppException when fails.
     */
    public List<UserSecurityQuestions> getAllUserSecurityQuestions() throws LeefyAppException {

        return userSecurityQuestionsDao.findAll(UserSecurityQuestions.class);
    }
    
    /**
     * Get all the Security questions of this user.
     * 
     * @param userLoginId Id of the User.
     * @return {@link List} list of security questions.(There should be two security questions.)
     * @throws LeefyAppException when fails.
     */
    public List<UserSecurityQuestions> getUserSecurityQuestionsById(int userLoginId) throws LeefyAppException {

        return userSecurityQuestionsDao.getUserSecurityQuestionByUserLoginId(userLoginId);
    }
    
    /**
     * Check the availability of security questions for this user.
     * 
     * @param user -User's user login
     * @return returns true if security questions available for this user.
     * @throws LeefyAppException when fails.
     */
    public boolean isSecurityQuestionsExist(UserLogin user) throws LeefyAppException {

        int userLoginId = user.getUserLoginId();
        boolean result = true;
        
        List<UserSecurityQuestions> userSecurityQuestions =
                userSecurityQuestionsDao.getUserSecurityQuestionByUserLoginId(userLoginId);
        if (userSecurityQuestions.isEmpty()) {
            result = false;
        }
        
        return result;
    }
    
    /**
     * {@inheritDoc}
     */
    public boolean changePassword(UserLogin userLogin, String newPassword) throws LeefyAppException {

        userLogin.setPassword(passwordEncoder.encodePassword(newPassword, userLogin.getUsername()));
        userLogin.setModifiedTime(new Date());
        userDao.update(userLogin);
        
        return validatePassword(newPassword, userLogin);
        
    }
    
    /**
     * {@inheritDoc}
     */
    public boolean validatePassword(String password, UserLogin userLogin) throws LeefyAppException {

        return passwordEncoder.isPasswordValid(userLogin.getPassword(), password, userLogin.getUsername());
    }
    
    /**
     * {@inheritDoc}
     */
    public List<UserLogin> searchUserLogin(UserLogin userLogin) throws LeefyAppException {

        return userLoginDao.searchSystemUserByUserName(userLogin);
    }
    
    /**
     * {@inheritDoc}
     */
    public List<UserLogin> searchUserLoginByUserNameAndRole(UserLogin userLogin) throws LeefyAppException {

        return userLoginDao.searchSystemUserByUserNameAndRole(userLogin);
    }
    
    /**
     * {@inheritDoc}
     */
    public UserLogin findUserLogin(int userLgoinId) throws LeefyAppException {

        return (UserLogin) userLoginDao.findById(UserLogin.class, userLgoinId);
    }
    
    /**
     * {@inheritDoc}
     */
    public UserRole findUserRole(int userRoleId) throws LeefyAppException {

        return (UserRole) userRoleDao.findById(UserRole.class, userRoleId);
    }
    
    /**
     * {@inheritDoc}
     */
    public UserRole createUserRole(UserRole userRole) throws LeefyAppException {

        return userRoleDao.save(userRole);
    }
    
    /**
     * {@inheritDoc}
     */
    public void updateUserRole(UserRole userRole) throws LeefyAppException {

        userRoleDao.update(userRole);
        
    }
    
    /**
     * {@inheritDoc}
     */
    public void deleteUserRole(UserRole userRole) throws LeefyAppException {

        userRoleDao.delete(userRole);
        
    }
    
    /**
     * {@inheritDoc}
     */
    @Transactional()
    public void grantOrRevokePrivileges(UserRole userRole, List<Privilege> privileges, List<Tab> tabs)
            throws LeefyAppException {

        List<RoleTab> roleTabsList = new ArrayList<RoleTab>();
        List<RolePrivilege> rolePrivilegesList = new ArrayList<RolePrivilege>();
        
        RoleTab roleTab = null;
        RolePrivilege rolePrivilege = null;
        
        /* delete all the RoleTab records related to the given user role. */
        roleTabDao.deleteRoleTabsByUserRole(userRole);
        
        /* delete all the RolePrivileges records related to the given user role. */
        rolePrivilegeDao.deleteRolePrivilegesByUserRole(userRole);
        
        /* Insert Privileges list of RolePrivilege records related to the given user role. */
        for (Privilege privilege : privileges) {
            rolePrivilege = new RolePrivilege();
            rolePrivilege.setRole(userRole);
            rolePrivilege.setPrivilege(privilege);
            rolePrivilegesList.add(rolePrivilege);
        }
        
        /* create a list of rolePrivileges and call saveList() */
        rolePrivilegeDao.saveOrUpdateAll(rolePrivilegesList);
        
        /* Insert Tab list of RoleTab records related to the given user role. */
        for (Tab tab : tabs) {
            roleTab = new RoleTab();
            roleTab.setRole(userRole);
            roleTab.setTab(tab);
            roleTabsList.add(roleTab);
        }
        
        /* create a list of roleTabs and call saveList() */
        roleTabDao.saveOrUpdateAll(roleTabsList);
        
    }
    
    /**
     * Get all the Modules as a list.
     * 
     * @return list of modules.
     * @throws LeefyAppException when fails.
     */
    public List<Module> getAllModules() throws LeefyAppException {

        return moduleDao.findAll(Module.class);
    }
    
    /**
     * {@inheritDoc}
     */
    public List<Privilege> getPrivilegesByUserRole(UserRole userRole) throws LeefyAppException {

        return rolePrivilegeDao.getPrivilegesByUserRole(userRole);
    }
    
    /**
     * {@inheritDoc}
     */
    public List<Tab> getTabsByUserRole(UserRole userRole) throws LeefyAppException {

        return roleTabDao.getTabsByUserRole(userRole);
    }
    
    /**
     * {@inheritDoc}
     */
    public List<RolePrivilege> getRolePrivilegesByUserRole(UserRole userRole) throws LeefyAppException {

        return rolePrivilegeDao.getRolePrivilegesByUserRole(userRole);
    }
    
    /**
     * {@inheritDoc}
     */
    public List<Privilege> getDependenciesList(List<Integer> privilegeIdList) throws LeefyAppException {

        return privilegeDependencyDao.getDependenciesList(privilegeIdList);
    }
    
    /**
     * {@inheritDoc}
     */
    public List<Tab> getDependenciesTabIdList(List<Integer> privilegeIdList) throws LeefyAppException {

        return privilegeDependencyDao.getDependenciesTabIdList(privilegeIdList);
        
    }


    /**
     * {@inheritDoc}
     */
    public void validateUserLoginBeforeCreate(UserLogin userLogin) throws LeefyAppException, NonUniqueUserNameException, NonUniqueEmailException {
        boolean isUsernameExist = getAnyUser(userLogin.getUsername()) != null;
        
        if (isUsernameExist) {
            throw new NonUniqueUserNameException(PropertyReader.getPropertyValue(LeefyConstants.LEEFY_ERROR_MSG_PROPERTY,
                    LeefyConstants.ERROR_MESSAGE_UNIQUE_UNAME,LocaleContextHolder.getLocale()));
        }
        boolean isEmailExist = getAnyUserByEmail(userLogin.getEmail()) != null;
        
        if (isEmailExist) {
            throw new NonUniqueEmailException(PropertyReader.getPropertyValue(LeefyConstants.LEEFY_ERROR_MSG_PROPERTY,
                    LeefyConstants.ERROR_MESSAGE_UNIQUE_EMAIL,LocaleContextHolder.getLocale()));
        }
    }
    
    /**
     * {@inheritDoc}
     */
    @Transactional(readOnly = true)
   public User buildUserFromUserEntity(UserLogin userLogin) throws LeefyAppException {

        User systemUser = null;
        
        String username = userLogin.getUsername();
        int userRoleId = userLogin.getUserRoleId();
        String password = userLogin.getPassword();
        boolean enabled = userLogin.isStatus();
        boolean accountNonLocked = true;
        String userRole = "";
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        
        /* set user login attempts */
        if (userLogin.getLoginAttempts() >= LeefyConstants.MAX_LOGIN_COUNT) {
            accountNonLocked = false;
        }
        
        /* load role privileges */
        com.jeesoft.api.dto.UserRole userRoleObj = null;
        
        try {
            userRoleObj = findUserRole(userLogin.getUserRoleId());
            List<Privilege> privileges = getPrivilegesByUserRole(userRoleObj);
            
            for (Privilege privilege : privileges) {
                authorities.add(new GrantedAuthorityImpl(privilege.getName()));
            }
            
        } catch (LeefyAppException e) {
            
        }
        
        if (userLogin.getUserRoleId() == com.jeesoft.api.enums.UserRole.ROLE_ADMIN.getUserRoleId()) {
            userRole = com.jeesoft.api.enums.UserRole.ROLE_ADMIN.toString();
            
            systemUser = new AdminDetails(username, password, userRole, userRoleId,
                            enabled, accountNonLocked, authorities);
            
        } else {
            
            userRole = userRoleObj.getRole();
            systemUser = new UserDefinedRoleDetails(username, password, userRole, userRoleId, enabled, accountNonLocked,
                            authorities);
        }
        
        return systemUser;
    }
}
