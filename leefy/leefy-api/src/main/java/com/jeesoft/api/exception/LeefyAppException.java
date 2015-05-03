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

package com.jeesoft.api.exception;

/**
 * This represents a customized exception class for application specific exceptions.
 * 
 * @author Jeewantha Samaraweera
 * @since alpha
 */
public class LeefyAppException extends LeefyException {
    
    /**
     * Class serial id.
     */
    private static final long serialVersionUID = -1004771925657146922L;
    
    /**
	 * Constructs a default LeefyAppException object.
	 */
    public LeefyAppException() {
    
        super();
    }
    
    /**
     * Constructs a LeefyAppException object with the given error code.
     * 
     * @param strErrorCode - The error code.
     */
    public LeefyAppException(final String strErrorCode) {
    
        super(strErrorCode);
    }
    
    /**
     * Constructs a LeefyAppException object with the given error code and detailed cause.
     * 
     * @param strErrorCode - the error code.
     * @param cause - the cause of the error.
     */
    public LeefyAppException(final String strErrorCode, final Throwable cause) {
    
        super(strErrorCode, cause);
    }
    
    /**
     * Constructs a LeefyAppException object with the given error message, error code and detailed cause.
     * 
     * @param strErrorMsg - The error message.
     * @param strErrorCode - the error code.
     * @param cause - the cause of the error.
     */
    public LeefyAppException(final String strErrorMsg, final String strErrorCode, final Throwable cause) {
    
        super(strErrorMsg, strErrorCode, cause);
    }
    
}
