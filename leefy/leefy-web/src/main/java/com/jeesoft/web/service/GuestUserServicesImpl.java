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
package com.jeesoft.web.service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.jeesoft.api.dto.UserLogin;
import com.jeesoft.api.dto.UserRole;
import com.jeesoft.common.constants.LeefyConstants;
import com.jeesoft.common.exception.LeefyAppException;
import com.jeesoft.common.exception.NonUniqueEmailException;
import com.jeesoft.common.exception.NonUniqueUserNameException;
import com.jeesoft.web.services.user.UserServiceImpl;

/**
 * The Interface GuestUserServices.
 * 
 * @author Jeewantha Samaraweera
 */
public class GuestUserServicesImpl extends UserServiceImpl implements GuestUserServices {
    
    @Override
    public boolean isUsernameExist(String username) throws LeefyAppException {
        return (getUserLoginDao().getAnyUserByName(username) == null ? false : true);
    }

    @Override
    public boolean isEmailExist(String email) throws LeefyAppException {
        return (getUserLoginDao().getAnyUserByEmail(email) == null ? false : true);
    }
    
    @Override
    @Transactional(propagation=Propagation.REQUIRES_NEW, rollbackFor=Exception.class)
    public UserLogin createSystemUser(UserLogin userLogin) throws LeefyAppException, NonUniqueEmailException, NonUniqueUserNameException {
        validateUserLoginBeforeCreate(userLogin);
        UserRole guestUserRole = getUserRoleDao().getUserRoleByRoleName("Guest");
        userLogin.setUserRoleId(guestUserRole != null ? guestUserRole.getUserRoleId() : 0);
        userLogin.setPassword(getPasswordEncoder().encodePassword(userLogin.getPassword(), userLogin.getUsername()));
        userLogin.setStatus(true);
        userLogin.setFirstName(LeefyConstants.EMPTY_STRING);
        userLogin.setLastName(LeefyConstants.EMPTY_STRING);
        return getUserLoginDao().save(userLogin);
    }
}