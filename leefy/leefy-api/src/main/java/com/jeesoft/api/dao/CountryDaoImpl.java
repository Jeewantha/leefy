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

package com.jeesoft.api.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.jeesoft.api.dao.BaseDaoImpl;
import com.jeesoft.api.dto.Country;
import com.jeesoft.common.constants.LeefyConstants;
import com.jeesoft.common.exception.LeefyAppException;

/**
 * This class provides persistence layer functionality for the Country object.
 * 
 * @author Jeewantha Samaraweera
 */
public class CountryDaoImpl extends BaseDaoImpl<Country> implements CountryDao {
    
    @SuppressWarnings("unchecked")
    public List<Country> loadAllCountries() throws LeefyAppException {
        List<Country> allCountries = null;
        try {
            allCountries = (List<Country>) getHibernateTemplate().findByNamedQuery("getAllCountries");
            
        } catch (DataAccessException e) {
            throw new LeefyAppException(LeefyConstants.HIBERNATE_INVALID_ADD_OPERATION, e);
        }
        return allCountries;
    }
    
    
    

}
