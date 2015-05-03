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

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;

import com.jeesoft.api.dao.BaseDaoImpl;
import com.jeesoft.api.dto.UserSecurityQuestions;
import com.jeesoft.common.constants.LeefyConstant;
import com.jeesoft.common.exception.LeefyAppException;

/**
 * @author Jeewantha Samaraweera.
 */
public class UserSecurityQuestionsDaoImpl extends BaseDaoImpl<UserSecurityQuestions> implements
        UserSecurityQuestionsDao {
    
    /**
     * Logger to log the exceptions.
     */
    private static final Logger LOG = Logger.getLogger(UserSecurityQuestionsDaoImpl.class);
    
    /**
     * Name of the Query to get security questions.
     */
    private static final String GET_USER_SECURITY_QUESTION = "getUserSecurityQuestionById";
    
    /** The Constant ERROR_WHILE_RETRIEVE_USER_SECURITY_QUESTIONS. */
    private static final String ERROR_WHILE_RETRIEVE_USER_SECURITY_QUESTIONS =
            "Error while retrieve UserSecurityQuestions--->";
    
    /**
     * Get the UserSecurityQuestions of this user.
     * 
     * @param userLoginId User's login Id.
     * @return The user specific security question.
     * @throws AkuraAppException when fail.
     */
    
    @SuppressWarnings("unchecked")
    public List<UserSecurityQuestions> getUserSecurityQuestionByUserLoginId(int userLoginId) throws LeefyAppException {

        try {
            return (List<UserSecurityQuestions>) getHibernateTemplate().findByNamedQuery(GET_USER_SECURITY_QUESTION, new Object[] { userLoginId });
        } catch (DataAccessException e) {
            LOG.error(ERROR_WHILE_RETRIEVE_USER_SECURITY_QUESTIONS + e.getMessage());
            throw new LeefyAppException(LeefyConstant.DB_CONNECTION_ERROR + e);
        }
        
    }
    
}
