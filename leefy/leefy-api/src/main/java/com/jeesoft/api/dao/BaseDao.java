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

import com.jeesoft.api.dto.BaseDomain;
import com.jeesoft.common.exception.LeefyAppException;


/**
 * Generic base interface for DAOs. This Helper class simplifies Hibernate data access by allowing a common
 * access point for all the entities in the application to execute various persistence related operations.
 * 
 * @author Jeewantha Samaraweera
 * @since alpha
 * @param <T> - the concrete class.
 */
public interface BaseDao<T extends BaseDomain> {
    
    /**
     * Method to save a new object to the database.
     * 
     * @param domainObj - The entity to be saved.
     * @return - The new entity that has been added to the system.
     * @throws LeefyAppException - the exception.
     */
    T save(T domainObj) throws LeefyAppException;
    
    /**
     * Updates and existing record for the given domain object.
     * 
     * @param domainObj - The domain object to be updated.
     * @throws LeefyAppException - the exception.
     */
    void update(T domainObj) throws LeefyAppException;
    
    /**
     * Deletes the given domain object from the database.
     * 
     * @param domainObj - the domain object to be deleted
     * @throws LeefyAppException - the exception.
     */
    void delete(T domainObj) throws LeefyAppException;
    
    /**
     * This method will create a collection of objects (if not already available in the db); else it will
     * update the existing records for the given collection in the db.
     * 
     * @param objList - The list of objects to be saved/updated.
     * @throws LeefyAppException - The detailed exception.
     */
    void saveOrUpdateAll(List<T> objList) throws LeefyAppException;
    
    /**
     * Finds a db record for a specific domain object and its id.
     * 
     * @param domainObj - The domain object to be retrieved.
     * @param id - the specific id/key of the domain object to be retrieved.
     * @return Object - The specific domain object.
     * @throws LeefyAppException - The detailed exception
     */
    Object findById(Class<T> domainObj, int id) throws LeefyAppException;
    
    /**
     * Retrieves the entire list of records for a given domain object.
     * 
     * @param domainClass - the entity/domain object class.
     * @return List - The list of records for the given domain class.
     * @throws LeefyAppException - The detailed exception.
     */
    List<T> findAll(Class<T> domainClass) throws LeefyAppException;
    
}
