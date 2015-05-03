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
 * This class is used to get and set fields of user Security Question domain.
 * 
 * @author Jeewantha Samaraweera
 * @since alpha
 */
public class UserSecurityQuestions extends BaseDomain {
    
    /**
     * Holds serial version id.
     */
    private static final long serialVersionUID = 1L;
    
    /** The constant for user Security Question id string. */
    private static final String USER_SECURITY_QUESTION_ID = "UserSecurityQuestions userSecurityQuestionId=";
    
    /** The user Security Question id value. */
    private int userSecurityQuestionId;
    
    /** The user's UserLoginId . */
    private UserLogin userLogin;
    
    /** The user's securityQuestionsId. */
    private SecurityQuestions securityQuestions;
    
    /** User's security question answer. */
    private String answer;
    
    /**
     * Get the user securityQuestionId.
     * 
     * @return userSecurityQuestionId
     */
    public final int getUserSecurityQuestionId() {
    
        return userSecurityQuestionId;
    }
    
    /**
     * Set the user securityQuestionId.
     * 
     * @param userSecurityQuestionIdVlaue user security question id to set
     */
    public final void setUserSecurityQuestionId(final int userSecurityQuestionIdVlaue) {
    
        this.userSecurityQuestionId = userSecurityQuestionIdVlaue;
    }
    
    /**
     * Get the user UserLogin.
     * 
     * @return userSecurityQuestionId
     */
    public final String getAnswer() {
    
        return answer;
    }
    
    /**
     * Set the answer.
     * 
     * @param answerVlaue returns.
     */
    public final void setAnswer(final String answerVlaue) {
    
        this.answer = answerVlaue;
    }
    
    /**
     * Get the userLogin.
     * 
     * @return userLogin.
     */
    public final UserLogin getUserLogin() {
    
        return userLogin;
    }
    
    /**
     * Set the user Login.
     * 
     * @param userLoginVlaue be set.
     */
    public final void setUserLogin(final UserLogin userLoginVlaue) {
    
        this.userLogin = userLoginVlaue;
    }
    
    /**
     * Get the security questions.
     * 
     * @return securityQuestions returns.
     */
    public final SecurityQuestions getSecurityQuestions() {
    
        return securityQuestions;
    }
    
    /**
     * Set the security questions.
     * 
     * @param securityQuestionsValue the user security question to be set.
     */
    public final void setSecurityQuestions(final SecurityQuestions securityQuestionsValue) {
    
        this.securityQuestions = securityQuestionsValue;
    }
    
    /**
     * Returns the details for the current object.
     * 
     * @return - the current object details.
     */
    public final String toString() {
    
        return USER_SECURITY_QUESTION_ID + userSecurityQuestionId;
    }
    
}
