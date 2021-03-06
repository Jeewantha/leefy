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
package com.jeesoft.api.dao;

import java.util.Collections;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.jeesoft.api.dao.BaseDaoImpl;
import com.jeesoft.api.dto.UserLogin;
import com.jeesoft.common.constants.LeefyConstants;
import com.jeesoft.common.exception.LeefyAppException;

/**
 * Implementation for UserLoginDao.
 * 
 * @author Jeewantha Samaraweera
 */
public class UserLoginDaoImpl extends BaseDaoImpl<UserLogin> implements UserLoginDao {
    
    /**
     * Logger to log the exceptions.
     */
/*    private static final Logger LOG = Logger.getLogger(UserLoginDaoImpl.class);
*/    
    /** String Constant for holding respective query name. */
    private static final String SEARCH_SYSTEM_USER = "searchSystemUser";
    
    /** String Constant for holding respective query name. */
    private static final String SEARCH_SYSTEM_USER_BY_NAME_AND_ROLE = "searchSystemUserByNameAndRole";
    
    private static final String IS_USERNAME_OR_EMAIL_EXIST = "isUsernameOrEmailExist";
    
    /** String Constant for holding respective query name. */
    private static final String GET_USER_BY_NAME = "getUserByName";
    
    /** The constant for "%" character. */
    private static final String MODULO_STRING = "%";
    
    /** String constant for holding respective query name. */
    private static final String GET_ANY_USER_BY_NAME = "getAnyUserByName";
    
    /** String constant for holding respective query name `getAnyUserByEmail`. */
    private static final String GET_ANY_USER_BY_EMAIL = "getAnyUserByEmail";
    
    /** String constant for holding respective query name `getAnyUserByUsernameOrEmail`. */
    private static final String GET_ANY_USER_BY_USERNAME_OR_EMAIL = "getAnyUserByUsernameOrEmail";
    
    /** String constant for holding respective query name. */
    private static final String GET_USER_LOGIN_LIST_BY_USER_ROLE = "getUserLoginListByUserRole";
    
    /** key to hold the string userRoleIdList. */
    private static final String USER_ROLE_ID_LIST = "userRoleIdList";
    
    /**
     * Retrieve all the user's with the username.
     * 
     * @param userName The user name of the user.
     * @return userLogin the user with the user name "userName".
     * @throws LeefyAppException SMS Exceptions.
     */
    @SuppressWarnings("unchecked")
    public UserLogin getAnyUserByName(String userName) throws LeefyAppException {

        List<UserLogin> userLoginList = null;
        UserLogin userLogin = null;
        
        try {
            userLoginList = (List<UserLogin>) getHibernateTemplate().findByNamedQuery(GET_ANY_USER_BY_NAME, userName);
            if (userLoginList != null && !userLoginList.isEmpty()) {
                userLogin = userLoginList.get(0);
            }
        } catch (DataAccessException e) {
            throw new LeefyAppException(LeefyConstants.HIBERNATE_INVALID_ADD_OPERATION, e);
        }
        
        return userLogin;
    }
    
    /**
     * Retrieve the user login by passing the user's email. This returns any user with the given email.
     * 
     * @param email - String
     * @return UserLogin object.
     * @throws LeefyAppException throws if fails.
     */
    @SuppressWarnings("unchecked")
    public UserLogin getAnyUserByEmail(String email) throws LeefyAppException {

        try {
            List<UserLogin> userLoginList = (List<UserLogin>) getHibernateTemplate().findByNamedQuery(GET_ANY_USER_BY_EMAIL, email);
            if (userLoginList != null && !userLoginList.isEmpty()) {
                 return userLoginList.get(0);
            }
        } catch (DataAccessException e) {
            throw new LeefyAppException(LeefyConstants.HIBERNATE_INVALID_ADD_OPERATION, e);
        }
        
        return null;
    }
    
    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    public List<UserLogin> getAnyUsersByUsernameOrEmail(String username, String email) throws LeefyAppException {
        List<UserLogin> listOfUserLogins = Collections.emptyList();
        listOfUserLogins = (List<UserLogin>) getHibernateTemplate().findByNamedQuery(GET_ANY_USER_BY_USERNAME_OR_EMAIL, username, email);
        return listOfUserLogins;
    }

    /**
     * Method to retrieve UserLogin for given userName.
     * 
     * @param userName - userName
     * @return userLogin for respective userName.
     * @throws LeefyAppException SMS Exceptions.
     */
    @SuppressWarnings({ "unchecked", "deprecation" })
    public UserLogin getUserLoginByName(String userName) throws LeefyAppException {

        UserLogin userLogin = null;
        try {
            @SuppressWarnings("unchecked")
			List<UserLogin> userLoginList =
                    (List<UserLogin>) getHibernateTemplate().findByNamedQuery(GET_USER_BY_NAME, new Object[] { userName });
            
            if (!userLoginList.isEmpty()) {
                userLogin = userLoginList.get(0);
                //getSession().update(userLogin);
            }
        } catch (DataAccessException e) {
            /*LOG.error(ERROR_WHILE_SEARCHING_USER_LOGIN + e.toString());*/
            throw new LeefyAppException(LeefyConstants.DB_CONNECTION_ERROR, e);
        }
        return userLogin;
    }
    
    /**
     * search system user by user name.
     * 
     * @param userLogin - UserLogin object.
     * @return {@link List} list of user login objects.
     * @throws LeefyAppException when fails.
     */
    @SuppressWarnings("unchecked")
    public List<UserLogin> searchSystemUserByUserName(UserLogin userLogin) throws LeefyAppException {

        List<UserLogin> userLoginList = null;
        String username = MODULO_STRING + userLogin.getUsername() + MODULO_STRING;
        try {
            userLoginList = (List<UserLogin>) getHibernateTemplate().findByNamedQuery(SEARCH_SYSTEM_USER, username, username);
        } catch (DataAccessException e) {
            /*LOG.error(ERROR_WHILE_SEARCHING_USER_LOGIN + e.toString());*/
            throw new LeefyAppException(LeefyConstants.DB_CONNECTION_ERROR, e);
        }
        
        return userLoginList;
    }
    
    /**
     * search system user by user name and role.
     * 
     * @param userLogin - UserLogin object.
     * @return {@link List} list of user login objects.
     * @throws LeefyAppException when fails.
     */
    @SuppressWarnings("unchecked")
    public List<UserLogin> searchSystemUserByUserNameAndRole(UserLogin userLogin) throws LeefyAppException {

        List<UserLogin> userLoginList = null;
        String username = MODULO_STRING + userLogin.getUsername() + MODULO_STRING;
        int roleId = userLogin.getUserRoleId();
        
        try {
            userLoginList =
                    (List<UserLogin>) getHibernateTemplate().findByNamedQuery(SEARCH_SYSTEM_USER_BY_NAME_AND_ROLE, username, username,
                            roleId, roleId);
        } catch (DataAccessException e) {
            /*LOG.error(ERROR_WHILE_SEARCHING_USER_LOGIN + e.toString());*/
            throw new LeefyAppException(LeefyConstants.DB_CONNECTION_ERROR, e);
        }
        
        return userLoginList;
    }
    
    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    public List<UserLogin> getUserLoginListByUserRole(List<Integer> userRoleIdList) throws LeefyAppException {

        try {
            return (List<UserLogin>) getHibernateTemplate().findByNamedQueryAndNamedParam(
                    GET_USER_LOGIN_LIST_BY_USER_ROLE, new String[] { USER_ROLE_ID_LIST },
                    new Object[] { userRoleIdList });
        } catch (DataAccessException e) {
            /*LOG.error(ERROR_WHILE_SEARCHING_USER_LOGIN + e.toString());*/
            throw new LeefyAppException(LeefyConstants.DB_CONNECTION_ERROR, e);
        }
        
    }
    
    public Boolean isUsernameOrEmailExist(String username, String email) throws LeefyAppException {
        try {
            return (getHibernateTemplate().findByNamedQuery(IS_USERNAME_OR_EMAIL_EXIST, username, email).isEmpty()) ? Boolean.FALSE : Boolean.TRUE;
        } catch (DataAccessException e) {
            throw new LeefyAppException(LeefyConstants.DB_CONNECTION_ERROR, e);
        }
    }
}
