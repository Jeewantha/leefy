/*******************************************************************************
 *  
 *  Leefy is a simple social network to narrow the gap between people speaking different
 *  languages and to aid the language learning process.
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

package com.jeesoft.web.delegate;

import com.jeesoft.common.exception.LeefyAppException;


/**
 * Delegates the method to relevant service.
 *
 * @author Jeewantha Samaraweera
 */
public interface SystemUserDelegate {

    /**
     * Checks whether given number is in the database.
     *
     * @param userIdentificationNo - admission number or the registration number.
     * @return - the status of existing of the admission or the registration number for the
     * student and the staff respectively.
     * @throws LeefyAppException - The exception details that occurred when processing.
     */
    boolean isExistRegistrationNo(String userIdentificationNo)throws LeefyAppException;

    /**
     * Returns the key of the staff or the student by the identification number.
     * 
     * @param identification - the identification number.
     * @return - the key for the relevant identification number.
     * @throws LeefyAppException - The exception details that occurred when processing.
     */
    int getKeyByIdentificationNo(String identification)throws LeefyAppException;

    /**
     * Returns the identification number of the staff or the student by the StudentID or StaffID.
     * 
     * @param key - StudentID or StaffID.
     * @return - the key for the relevant identification number.
     * @throws LeefyAppException - The exception details that occurred when processing.
     */
    String getIdentificationNoByKey(int key)throws LeefyAppException;

    /**
     * Checks whether given user is past user.
     *
     * @param userIdentificationNo - admission number or the registration number.
     * @return - the status of the admission or the registration number for the
     * student and the staff is a past user or not.
     * @throws LeefyAppException - The exception details that occurred when processing.
     */
    boolean isPastUser(String userIdentificationNo)throws LeefyAppException;
}
