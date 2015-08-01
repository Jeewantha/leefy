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
package com.jeesoft.web.service;

import com.jeesoft.api.dto.Guest;
import com.jeesoft.common.exception.LeefyAppException;


/**
 * The Interface GuestUserServices.
 */
public interface GuestUserServices {

    /**
     * Checks if is valid registration no.
     *
     * @param registrationNo the registration no
     * @return true, if is valid registration no
     * @throws LeefyAppException the leefy app exception
     */
    boolean isValidRegistrationNo(String registrationNo) throws LeefyAppException;
    
    /**
     * Gets the key by identification no.
     *
     * @param identification the identification
     * @return the key by identification no
     * @throws LeefyAppException the leefy app exception
     */
    int getKeyByIdentificationNo(String identification) throws LeefyAppException;
    
    /**
     * Find guest.
     *
     * @param guestId the guest id
     * @return the guest
     * @throws LeefyAppException the leefy app exception
     */
    Guest findGuest(int guestId) throws LeefyAppException;
    
    /**
     * Checks for departure date.
     *
     * @param registrationNo the registration no
     * @return true, if successful
     * @throws LeefyAppException the leefy app exception
     */
    boolean hasDepartureDate(String registrationNo) throws LeefyAppException;
}
