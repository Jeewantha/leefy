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

import com.jeesoft.api.messages.ErrorMessageLoader;

/**
 * This represents a customized exception class for application specific exceptions. All
 * application exceptions will extend this {@link LeefyException} class.
 * 
 * @author Jeewantha Samaraweera
 * @since alpha
 */
public abstract class LeefyException extends Exception {
    
    /**
     * Class serial id.
     */
    private static final long serialVersionUID = -230773364309409472L;
    
    /**
     * Represents the error code for a specific error message.
     */
    private String errorCode;
    
    /**
     * Represents an instance of the ErrorMsgUtil class.
     */
    private ErrorMessageLoader errorMsgLoader = new ErrorMessageLoader();
    
    /**
     * Constructs a default LeefyException object.
     */
    public LeefyException() {
    
        super();
    }
    
    /**
     * Constructs a LeefyException object with the given error code.
     * 
     * @param errCode - the error code
     */
    public LeefyException(final String errCode) {
    
        super();
        this.errorCode = errCode;
    }
    
    /**
     * Constructs a LeefyException object with the specified error code and cause.
     * 
     * @param errCode - The specific error code.
     * @param cause - The cause of the exception.
     */
    public LeefyException(final String errCode, final Throwable cause) {
    
        super(cause);
        this.errorCode = errCode;
    }
    
    /**
     * Constructs a LeefyException object with the specified error message, code and cause.
     * 
     * @param cause - The cause of the exception.
     * @param strErrorMsg - the specific error message.
     * @param errCode - The specific error code
     */
    public LeefyException(final String strErrorMsg, final String errCode, final Throwable cause) {
    
        super(strErrorMsg, cause);
        this.errorCode = errCode;
    }
    
    /**
     * Returns the error code provided for this object.
     * 
     * @return - The error code.
     */
    public final String getErrorCode() {
    
        return errorCode;
    }
    
    /**
     * Sets the error code for this object.
     * 
     * @param errCode - The error code to be set.
     */
    public final void setErrorCode(final String errCode) {
    
        this.errorCode = errCode;
    }
    
    /**
     * This method overrides the java.lang.Throwable , getLocalizedMessage() method. If an error code has been
     * set for this object, it would return the error message for the corresponding error code together with
     * the detailed exception, else, it would only return the detailed exception.
     * 
     * @return - The exception details.
     */
    public final String getLocalizedMessage() {
    
        if (this.errorCode == null || this.errorCode.isEmpty()) {
            return getMessage();
        }
        
        return errorMsgLoader.getErrorMessage(errorCode) + getMessage();
        
    }
}
