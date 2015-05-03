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

import java.io.Serializable;
import java.util.Date;

/**
 * This represents that base entity for all POJOs and DTO objects. It contains common attributes and get/set
 * methods that can be reused across all objects. All DTOs and POJOs in the application should extend this
 * class.
 * 
 * @author Jeewantha Samaraweera
 * @since alpha
 */

public class BaseDomain implements Serializable {
    
    /**
     * Generated serial id.
     */
    private static final long serialVersionUID = -5875802756035670138L;
    
    /**
     * The latest time that the object was modified.
     */
    private Date modifiedTime;
    
    /**
     * Constructs a default BaseDomain object.
     */
    public BaseDomain() {
    
    }
    
    /**
     * Returns the last modified time for this object.
     * 
     * @return - The last updated time.
     */
    public final Date getModifiedTime() {
    
        if (modifiedTime != null) {
            
            return (Date) this.modifiedTime.clone();
        }
        return null;
    }
    
    /**
     * Sets the latest time at which the object was updated.
     * 
     * @param modTime - the latest time that the object was modified (systime).
     */
    public final void setModifiedTime(final Date modTime) {
    
        if (modTime != null) {
            this.modifiedTime = (Date) modTime.clone();
        }
    }

    
}
