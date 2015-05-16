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
package com.jeesoft.web.dao;

import java.util.Date;
import java.util.List;

import com.jeesoft.api.dao.BaseDao;
import com.jeesoft.api.dto.UserLogin;
import com.jeesoft.common.exception.LeefyAppException;


/**
 * This interface provides persistence layer functionality for the UserLogin object.
 * 
 * @author Jeewantha Samaraweera
 */
public interface UserLoginDao extends BaseDao<UserLogin> {
    
    /**
     * Retrieve the user login by passing the user's username.This returns any user with the user name passed.
     * 
     * @param userName - String
     * @return UserLogin object.
     * @throws LeefyAppException SMS Exceptions.
     */
    UserLogin getAnyUserByName(String userName) throws LeefyAppException;
    
    /**
     * Retrieve the user login by passing the user's email. This returns any user with the email passed.
     * 
     * @param email - String
     * @return UserLogin object.
     * @throws LeefyAppException SMS Exceptions.
     */
    UserLogin getAnyUserByEmail(String email) throws LeefyAppException;
    
    /**
     * Retrieve the user login by passing the user's role_id. This returns any user with the role_id passed.
     * 
     * @param roleId - int
     * @param identificationNo - String
     * @return UserLogin object.
     * @throws LeefyAppException SMS Exceptions.
     */
    List<Integer> getStudentByUserRoleIdAndIdentificationNo(int roleId, String identificationNo)
            throws LeefyAppException;
    
    /**
     * Retrieve the user login by passing the user's username.
     * 
     * @param userName - String
     * @return UserLogin object.
     * @throws LeefyAppException SMS Exceptions.
     */
    UserLogin getUserLoginByName(String userName) throws LeefyAppException;
    
    /**
     * Retrieve the user login by using user identification no.
     * 
     * @param identificationNo - String
     * @return UserLogin object
     * @throws LeefyAppException - throw this
     */
    UserLogin getUserLoginByIdentificationNo(String identificationNo) throws LeefyAppException;
    
    /**
     * search system user by user name.
     * 
     * @param userLogin - UserLogin
     * @return {@link List} list of user login objects.
     * @throws LeefyAppException when fails.
     */
    List<UserLogin> searchSystemUserByUserName(UserLogin userLogin) throws LeefyAppException;
    
    /**
     * search system user by user name and role.
     * 
     * @param userLogin - UserLogin
     * @return {@link List} list of user login objects.
     * @throws LeefyAppException when fails.
     */
    List<UserLogin> searchSystemUserByUserNameAndRole(UserLogin userLogin) throws LeefyAppException;
    
    /**
     * Retrieve all the available list of UserLogin by user role.
     * 
     * @param userRoleIdList - list of role id
     * @return list of UserLogin.
     * @throws LeefyAppException - throw detailed exception.
     */
    List<UserLogin> getUserLoginListByUserRole(List<Integer> userRoleIdList) throws LeefyAppException;
    
    /**
     * Returns the staff key by the identification number.
     * 
     * @param roleId - the key of the role
     * @param identificationNo - the identification number.
     * @return - the list of staff key
     * @throws LeefyAppException - The exception details that occurred when processing.
     */
    List<Integer> getStaffByUserRoleIdAndIdentificationNo(int roleId, String identificationNo) throws LeefyAppException;
    
    /**
     * get any user by user role and identification no.
     * 
     * @param userRoleId - user role id.
     * @param identificationNo - user identification no.
     * @return list of user Login objects.
     * @throws LeefyAppException when fails.
     */
    UserLogin getUserLoginByUserRoleAndIdetificationNo(int userRoleId, String identificationNo)
            throws LeefyAppException;
    
    /**
     * Get the user login of staff members by passing the registration number.
     * 
     * @param registrationNo - the registration number of the staff member.
     * @return UserLogin of the staff mamber.
     * @throws LeefyAppException - throws detailed exception when fails to retrieve the user login of the
     *         staff member.
     */
    List<UserLogin> getUserLoginOfAnyStatusByRegistrationNo(String registrationNo) throws LeefyAppException;
    
    /**
     * check whether identification is valid or not.
     * 
     * @param query - query.
     * @param identificationNo - the identificationNo.
     * @return valid registration no.
     * @throws LeefyAppException - throws detailed exception when fails to retrieve the user login of the
     *         staff member.
     */
    int isValidationIdentificationNo(String query, String identificationNo) throws LeefyAppException;
    
    /**
     * check whether identification is existing or not.
     * 
     * @param query - query.
     * @param identificationNo - the identificationNo.
     * @param roleId - the roleId.
     * @return UserLogin of the staff member.
     * @throws LeefyAppException - throws detailed exception when fails to retrieve the user login of the
     *         staff member.
     */
    boolean isExistingIdentificationNo(String query, String identificationNo, int roleId) throws LeefyAppException;
    
    /**
     * check whether identification is existing or not.
     * 
     * @param query - query.
     * @param identificationNo - the identificationNo.
     * @return UserLogin of the staff member.
     * @throws LeefyAppException - throws detailed exception when fails to retrieve the user login of the
     *         staff member.
     */
    boolean isPastUser(String query, String identificationNo) throws LeefyAppException;

    /**
     * Returns true if this student is not a current student with status id of 1.
     * 
     * @param query - the query to get the student status.
     * @param identificationNo - the identification number of the student.
     * @return true if this student is non-current.
     * @throws LeefyAppException - throws detailed exception if fails.
     */
    boolean isNonCurrentStudent(String query, String identificationNo) throws LeefyAppException;
    
}
