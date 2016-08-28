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

import java.util.List;

import org.springframework.security.core.userdetails.User;

import com.jeesoft.api.dto.Module;
import com.jeesoft.api.dto.Privilege;
import com.jeesoft.api.dto.RolePrivilege;
import com.jeesoft.api.dto.SecurityQuestions;
import com.jeesoft.api.dto.Tab;
import com.jeesoft.api.dto.UserLogin;
import com.jeesoft.api.dto.UserRegistrationForm;
import com.jeesoft.api.dto.UserRole;
import com.jeesoft.api.dto.UserSecurityQuestions;
import com.jeesoft.common.exception.InvalidIdentificationNoException;
import com.jeesoft.common.exception.LeefyAppException;
import com.jeesoft.common.exception.NonCurrentStudentUserLoginCreationException;
import com.jeesoft.common.exception.NonUniqueEmailException;
import com.jeesoft.common.exception.PastStaffException;
import com.jeesoft.common.exception.NonUniqueUserNameException;


/**
 * Declare userService functionality.
 * 
 * @author Jeewantha Samaraweera
 */
public interface UserService {
    
    /**
     * create a system user.
     * 
     * @param userLogin - userLogin
     * @throws LeefyAppException - {@link LeefyAppException}
     * @throws NonUniqueEmailException - {@link NonUniqueEmailException}
     * @throws NonUniqueUserNameException- {@link NonUniqueUserNameException}
     * @return returns the newly created {@link UserLogin}
     */
    UserLogin createSystemUser(UserLogin userLogin) throws LeefyAppException, NonUniqueEmailException, NonUniqueUserNameException;
    
    /**
     * edit a system user.
     * 
     * @param userLogin - userLogin
     * @throws LeefyAppException LeefyAppException
     */
    void editUser(UserLogin userLogin) throws LeefyAppException;
    
    /**
     * edit a system user.
     * 
     * @param userLogin - userLogin
     * @throws LeefyAppException LeefyAppException
     * @throws NonUniqueUserNameException - UniqueUserNameEmailException
     * @throws PastStaffException - PastStaffException
     * @throws InvalidIdentificationNoException - InvalidIdentificationNoException
     */
    void editSystemUser(UserLogin userLogin) throws LeefyAppException, NonUniqueUserNameException,
            PastStaffException, InvalidIdentificationNoException;
    
    /**
     * encode password.
     * 
     * @param userLogin - userLogin
     * @throws LeefyAppException LeefyAppException
     * @return encoded password.
     */
    String encodePassword(UserLogin userLogin) throws LeefyAppException;
    
    /**
     * Update a system user.
     * 
     * @param userLogin - userLogin
     * @throws LeefyAppException LeefyAppException
     */
    void updateUser(UserLogin userLogin) throws LeefyAppException;
    
    /**
     * Delete a system user.
     * 
     * @param userLogin - userLogin
     * @throws LeefyAppException LeefyAppException
     */
    void deleteUser(UserLogin userLogin) throws LeefyAppException;
    
    /**
     * get availiable userRole list.
     * 
     * @throws LeefyAppException LeefyAppException
     * @return availiable userRoleList.
     */
    List<UserRole> getUserRoleList() throws LeefyAppException;
    
    /**
     * Retrieve all the available list of UserLogin.
     * 
     * @return list of UserLogin.
     * @throws LeefyAppException - throw detailed exception.
     */
    List<UserLogin> getUserLoginList() throws LeefyAppException;
    
    /**
     * Retrieve all the available list of UserLogin by user role.
     * 
     * @param userRoleIdList - list of role id
     * @return list of UserLogin.
     * @throws LeefyAppException - throw detailed exception.
     */
    List<UserLogin> getUserLoginListByUserRole(List<Integer> userRoleIdList) throws LeefyAppException;
    
    /**
     * Get the any users UserLogin object by passing the user's username.
     * 
     * @param userName - String
     * @throws LeefyAppException LeefyAppException
     * @return returns the UserLogin object.
     */
    UserLogin getAnyUser(String userName) throws LeefyAppException;
    
    /**
     * Get the UserRole object by passing the userrole rolename.
     * 
     * @param role - String
     * @throws LeefyAppException LeefyAppException
     * @return returns the UserRole object.
     */
    UserRole getUserRoleByRoleName(String role) throws LeefyAppException;
    
    /**
     * Get the any users UserLogin object by passing the user's email.
     * 
     * @param email - String
     * @throws LeefyAppException LeefyAppException
     * @return returns the UserLogin object.
     */
    UserLogin getAnyUserByEmail(String email) throws LeefyAppException;
    
    /**
     * Get the users UserLogin object by passing the user's username.
     * 
     * @param userName - String
     * @throws LeefyAppException LeefyAppException
     * @return returns the UserLogin object.
     */
    UserLogin getUser(String userName) throws LeefyAppException;
    
    /**
     * Reset the user password.
     * 
     * @param userLogin - userLogin
     * @throws LeefyAppException LeefyAppException
     * @return flag indicates whether the password has changed for this user.
     */
    String resetPassword(UserLogin userLogin) throws LeefyAppException;
    
    /**
     * Generate a random password string.
     * 
     * @throws LeefyAppException LeefyAppException
     * @return Random string which is used as a password.
     */
    String generateRandomPassword() throws LeefyAppException;
    
    /**
     * Retrieve logged in user by userName.
     * 
     * @param strName - String
     * @return UserLogin Object.
     * @throws LeefyAppException - throw detailed exception.
     */
    UserLogin getUserByName(String strName) throws LeefyAppException;
    
    /**
     * Get all the Security Questions available in the system.
     * 
     * @return UserSecurityQuestions object which has all the security questions.
     * @throws LeefyAppException -throws when failed.
     */
    List<SecurityQuestions> getAllSecurityQuestions() throws LeefyAppException;
    
    /**
     * Create a user Security Question.
     * 
     * @param userSecurityQuestions - a question to be asked form users.
     * @throws LeefyAppException throws when failed.
     */
    void createSystemUserSecurityQuestion(UserSecurityQuestions userSecurityQuestions) throws LeefyAppException;
    
    /**
     * Get all the UserSecurityQuestions.
     * 
     * @return returns true if retrieval is successful.
     * @throws LeefyAppException throws when fail.
     */
    List<UserSecurityQuestions> getAllUserSecurityQuestions() throws LeefyAppException;
    
    /**
     * Get all the Security questions of this user.
     * 
     * @param userLoginId Id of the User.
     * @return {@link List} list of security questions.(There should be two security questions.)
     * @throws LeefyAppException when fails.
     */
    List<UserSecurityQuestions> getUserSecurityQuestionsById(int userLoginId) throws LeefyAppException;
    
    /**
     * Check the availability of security questions for this user.
     * 
     * @param user -User's user login
     * @return returns true if security questions available for this user.
     * @throws LeefyAppException throws when fails.
     */
    boolean isSecurityQuestionsExist(UserLogin user) throws LeefyAppException;
    
    /**
     * Change the password of this user to the new password pass into the method as a parameter.
     * 
     * @return true if password has successfuly changed.
     * @param userLogin The details of user logged in.
     * @param newPassword the new password provide by the user.
     * @throws LeefyAppException when fails in operation.
     */
    boolean changePassword(UserLogin userLogin, String newPassword) throws LeefyAppException;
    
    /**
     * Validate the row password with the encoded password.
     * 
     * @param password the row password entered by the user.
     * @param userLogin the user login.
     * @return {@link Boolean} true if the passwords are matched.
     * @throws LeefyAppException when fails in operation.
     */
    boolean validatePassword(String password, UserLogin userLogin) throws LeefyAppException;
    
    /**
     * search system user by user name.
     * 
     * @param userLogin the user login.
     * @return {@link List} list of user login objects.
     * @throws LeefyAppException when fails.
     */
    List<UserLogin> searchUserLogin(UserLogin userLogin) throws LeefyAppException;
    
    /**
     * search system user by user name and role.
     * 
     * @param userLogin the user login.
     * @return {@link List} list of user login objects.
     * @throws LeefyAppException when fails.
     */
    List<UserLogin> searchUserLoginByUserNameAndRole(UserLogin userLogin) throws LeefyAppException;
    
    /**
     * find system userLogin by userLgoinId.
     * 
     * @param userLgoinId the id of the user.
     * @return {@link List} list of user login objects.
     * @throws LeefyAppException when fails.
     */
    UserLogin findUserLogin(int userLgoinId) throws LeefyAppException;
    
    /**
     * find userRole by userRoleId.
     * 
     * @param userRoleId the id of the userRole.
     * @return userRole object.
     * @throws LeefyAppException when fails.
     */
    UserRole findUserRole(int userRoleId) throws LeefyAppException;
    
    /**
     * create a user role.
     * 
     * @param userRole - userRole
     * @throws LeefyAppException LeefyAppException
     * @return user role.
     */
    UserRole createUserRole(UserRole userRole) throws LeefyAppException;
    
    /**
     * update a system user.
     * 
     * @param userRole - userRole
     * @throws LeefyAppException LeefyAppException
     */
    void updateUserRole(UserRole userRole) throws LeefyAppException;
    
    /**
     * Delete a user role.
     * 
     * @param userRole - userRole
     * @throws LeefyAppException LeefyAppException
     */
    void deleteUserRole(UserRole userRole) throws LeefyAppException;
    
    /**
     * Grant or revoke privileges to user roles.
     * 
     * @param userRole - userRole
     * @param privileges - List of privileges
     * @param tabs - List of tabs
     * @throws LeefyAppException LeefyAppException
     */
    void grantOrRevokePrivileges(UserRole userRole, List<Privilege> privileges, List<Tab> tabs)
            throws LeefyAppException;
    
    /**
     * Get all the Modules as a list.
     * 
     * @return list of modules.
     * @throws LeefyAppException when fails.
     */
    List<Module> getAllModules() throws LeefyAppException;
    
    /**
     * Get Privileges by user role.
     * 
     * @param userRole - userRole
     * @return list of privileges.
     * @throws LeefyAppException when fails.
     */
    List<Privilege> getPrivilegesByUserRole(UserRole userRole) throws LeefyAppException;
    
    /**
     * Get Tabs by user role.
     * 
     * @param userRole - userRole
     * @return list of privileges.
     * @throws LeefyAppException when fails.
     */
    List<Tab> getTabsByUserRole(UserRole userRole) throws LeefyAppException;
    
    /**
     * Get RolePrivileges by user role.
     * 
     * @param userRole - userRole
     * @return list of privileges.
     * @throws LeefyAppException when fails.
     */
    List<RolePrivilege> getRolePrivilegesByUserRole(UserRole userRole) throws LeefyAppException;
    
    /**
     * Get Dependencies privilege ID list.
     * 
     * @param privilegeIdList - privilege IDs list.
     * @return list of dependencies IDs.
     * @throws LeefyAppException when fails.
     */
    List<Privilege> getDependenciesList(List<Integer> privilegeIdList) throws LeefyAppException;
    
    /**
     * Get Dependencies tab ID list.
     * 
     * @param privilegeIdList - privilege IDs list.
     * @return list of dependencies IDs.
     * @throws LeefyAppException when fails.
     */
    List<Tab> getDependenciesTabIdList(List<Integer> privilegeIdList) throws LeefyAppException;

    /**
     * Validates the {@link UserLogin} before creating a user from it.
     * 
     * @param userLogin the {@link UserLogin} to be validated.
     * @throws LeefyAppException when fails.
     * @throws NonUniqueUserNameException when user name is already exist in the system.
     * @throws NonUniqueEmailException when email is already exist in the system.
     */
    public void validateUserLoginBeforeCreate(UserLogin userLogin) throws LeefyAppException, NonUniqueUserNameException, NonUniqueEmailException;
        
    /**
     * Builds the {@link User} from the {@link UserLogin}
     * 
     * @param userLogin the {@link UserLogin} to be converted the {@link User} object.
     * @return the {@link User}
     */
    public User buildUserFromUserEntity(UserLogin userLogin) throws LeefyAppException;
}
