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

package com.jeesoft.common.messages;

import java.util.ResourceBundle;

/**
 * This is a utility class the handles the core functionality related to loading the application specific
 * error message bundles and related.
 *
 * @author Jeewantha Samaraweera
 * @since alpha
 */

public class ErrorMessageLoader {

    /**
     * Constant representing the error property file name.
     */
    private static final String PROP_FILE_NAME = "errormessages";

    /**
     * The resource bundle for the error properties.
     */
    private ResourceBundle propertyBundle;

    /**
     * Constructs a default ErrorMsgLoader object.
     */
    public ErrorMessageLoader() {

    }

    /**
     * Returns the error message for the given error key.
     *
     * @param errorKey - The error key for a specific error message.
     * @return - The error message for the given error key.
     */
    public final String getErrorMessage(final String errorKey) {

        getPropertiesBundle();
        if (this.propertyBundle.containsKey(errorKey)) {
            return this.propertyBundle.getString(errorKey);
        }
        return null;
    }

    /**
     * Returns the ResourceBundle containing the error properties for the application.
     *
     * @return - The resource bundle containing the error properties.
     */
    private ResourceBundle getPropertiesBundle() {

        this.propertyBundle = ResourceBundle.getBundle(PROP_FILE_NAME);
        return propertyBundle;
    }
}
