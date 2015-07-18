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
 * This class is used to get and set fields of Security Question domain.
 * 
 * @author Jeewantha Samaraweera
 * @since alpha
 * 
 */
public class SecurityQuestions extends BaseDomain {

	/**
	 * Holds serial version id.
	 */
	private static final long serialVersionUID = 1L;

	/** The constant for string ", securityQuestion=". */
	private static final String SECURITY_QUESTION = ", securityQuestion=";

	/** The constant for string "SecurityQuestions securityQuestionsId=". */
	private static final String SECURITY_QUESTIONS_SECURITY_QUESTIONS_ID = "SecurityQuestions securityQuestionsId=";

	/**
	 * Property securityQuestionsId type integer.
	 */
	private int securityQuestionsId;

	/**
	 * Property securityQuestion type String.
	 */
	private String securityQuestion;

	/**
	 * Default constructor for SecurityQuestion.
	 */
	public SecurityQuestions() {

	}

	/**
	 * Get the securityQuestionsId.
	 * 
	 * @return securityQuestionsId
	 */
	public final int getSecurityQuestionsId() {
		return securityQuestionsId;
	}

	/**
	 * Set the securityQuestionsId.
	 * 
	 * @param securityQuestionsId
	 *            to be set.
	 */
	public final void setSecurityQuestionsId(final int securityQuestionsId) {
		this.securityQuestionsId = securityQuestionsId;
	}

	/**
	 * 
	 * Get the SecurityQuestion.
	 * 
	 * @return SecurityQuestion.
	 */
	public final String getSecurityQuestion() {
		return securityQuestion;
	}

	/**
	 * Set the SecurityQuestion.
	 * 
	 * @param securityQuestion
	 *            to be set.
	 */
	public final void setSecurityQuestion(final String securityQuestion) {
		this.securityQuestion = securityQuestion;
	}

	/**
	 * Returns the details for the current object.
	 * 
	 * @return - the current object details.
	 */
	public final String toString() {

		return SECURITY_QUESTIONS_SECURITY_QUESTIONS_ID + securityQuestionsId + SECURITY_QUESTION + securityQuestion;
	}

}
