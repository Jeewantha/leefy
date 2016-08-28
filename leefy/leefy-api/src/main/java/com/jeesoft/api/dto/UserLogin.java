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

package com.jeesoft.api.dto;

/**
 * This class will hold the Properties of the UserLogin.
 * 
 * @author Jeewantha Samaraweera
 * @since alpha
 */
public class UserLogin extends BaseDomain {
    
    /** auto-serial no. */
    private static final long serialVersionUID = 1L;
    
    /**
     * represent the unique Id for the user.
     */
    private int userLoginId;
    
    /**
     * property loginAttempts type integer.
     */
    private int loginAttempts;
    
    /**
     * holds userRole id for the user.
     */
    private int userRoleId;
    
    /**
     * holds the user level of the user.
     */
    private String userLevel;
    
    /**
     * holds the username of the user.
     */
    private String username;
    
    /**
     * holds the password of the user.
     */
    private String password;
    
    /**
     * holds the email address for the user.
     */
    private String email;
    
    /**
     * holds firstName of the user.
     */
    private String firstName;
    
    /**
     * holds last name of the user.
     */
    private String lastName;
    
    /**
     * holds the active status of the user.
     */
    private boolean status;
    
    /**
     * holds the password status of the user, whether system generated or not.
     */
    private boolean generatedPassword;
    
    /**
     * holds the current status of the user, whether he departures or not.
     */
    private boolean deleted;
    
    /**
     * Default constructor.
     */
    public UserLogin() {

    }
    
    /**
     * return the userLoginId of the user.
     * 
     * @return the userLoginId
     */
    public final int getUserLoginId() {

        return userLoginId;
    }
    
    /**
     * set the userLoginId of the user.
     * 
     * @param intUserLoginId the userLoginId to set
     */
    public final void setUserLoginId(final int intUserLoginId) {

        this.userLoginId = intUserLoginId;
    }
    
    /**
     * return the username of the user.
     * 
     * @return the username.
     */
    public final String getUsername() {

        return username;
    }
    
    /**
     * set the username of the user.
     * 
     * @param strUsername the username to set
     */
    public final void setUsername(final String strUsername) {

        this.username = strUsername;
    }
    
    /**
     * return the password of the user.
     * 
     * @return the password
     */
    public final String getPassword() {

        return password;
    }
    
    /**
     * set the password of the user.
     * 
     * @param strPassword the password to set
     */
    public final void setPassword(final String strPassword) {

        this.password = strPassword;
    }
    
    /**
     * return the status of the user.
     * 
     * @return the status
     */
    public final boolean isStatus() {

        return status;
    }
    
    /**
     * set the the active status of the user.
     * 
     * @param checkStatus the status to set
     */
    public final void setStatus(final boolean checkStatus) {

        this.status = checkStatus;
    }
    
    /**
     * return the password status of the user.
     * 
     * @return the password status
     */
    public final Boolean getGeneratedPassword() {

        return generatedPassword;
    }
    
    /**
     * set the the status of the user password.
     * 
     * @param boolGeneratedPassword the password status to set
     */
    public final void setGeneratedPassword(final Boolean boolGeneratedPassword) {

        this.generatedPassword = boolGeneratedPassword;
    }
    
    /**
     * return the LoginAttempts of the user.
     * 
     * @return the loginAttempts
     */
    public final int getLoginAttempts() {

        return loginAttempts;
    }
    
    /**
     * set the the active status of the user.
     * 
     * @param intLoginAttempts the loginAttempts to set
     */
    public final void setLoginAttempts(final int intLoginAttempts) {

        this.loginAttempts = intLoginAttempts;
    }
    
    /**
     * return email address of the user.
     * 
     * @return the email
     */
    public final String getEmail() {

        return email;
    }
    
    /**
     * set the email address of the user.
     * 
     * @param emailVal the email to set
     */
    public final void setEmail(final String emailVal) {

        this.email = emailVal;
    }
    
    /**
     * return userLevel of the user.
     * 
     * @return the userLevel
     */
    public final String getUserLevel() {

        return userLevel;
    }
    
    /**
     * set the user level of the user.
     * 
     * @param userLevelVal the userLevel to set
     */
    public final void setUserLevel(final String userLevelVal) {

        this.userLevel = userLevelVal;
    }
    
    /**
     * return firstName of the user.
     * 
     * @return the firstName
     */
    public final String getFirstName() {

        return firstName;
    }
    
    /**
     * set the firstName of the User.
     * 
     * @param firstNameVal the firstName to set
     */
    public final void setFirstName(final String firstNameVal) {

        this.firstName = firstNameVal;
    }
    
    /**
     * return lastName of the user.
     * 
     * @return the lastName
     */
    public final String getLastName() {

        return lastName;
    }
    
    /**
     * set lastName of the user.
     * 
     * @param lastNameVal the lastName to set
     */
    public final void setLastName(final String lastNameVal) {

        this.lastName = lastNameVal;
    }
    
    /**
     * return userRoleId of the User.
     * 
     * @return the userRoleId
     */
    public final int getUserRoleId() {

        return userRoleId;
    }
    
    /**
     * set userRoleId for the user.
     * 
     * @param userRoleIdVal the userRoleId to set
     */
    public final void setUserRoleId(final int userRoleIdVal) {

        this.userRoleId = userRoleIdVal;
    }
    
    /**
     * return the deleted status of the staff.
     * 
     * @return the deleted status .
     */
    public final boolean getDeleted() {
    
        return deleted;
    }
    /**
     * set the the deleted status of the staff.
     * 
     * @param deletedVal the deleted status to set
     */
    
    public final void setDeleted(final boolean deletedVal) {
    
        this.deleted = deletedVal;
    }
    
    /**
     * overridden toString method to represent the UserLogin object.
     * 
     * @return String representation of the UserName.
     */
    @Override
	public final String toString() {

        return getUsername();
    }
    
}
