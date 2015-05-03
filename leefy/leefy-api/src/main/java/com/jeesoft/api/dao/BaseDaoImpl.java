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

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.jeesoft.api.constants.LeefyConstant;
import com.jeesoft.api.dto.BaseDomain;
import com.jeesoft.api.exception.LeefyAppException;


/**
 * This is the implementation class for the BaseDao. It provides the main CRUD operations for all the domain
 * objects in the system.
 * 
 * @author Jeewantha Samaraweera
 * @since alpha
 * @param <T> - the concrete class.
 * 
 */

public class BaseDaoImpl<T extends BaseDomain> extends HibernateDaoSupport implements BaseDao<T> {
    
    /**
     * Logger to log the exceptions.
     */
    private static final Logger LOG = Logger.getLogger(BaseDaoImpl.class);
    
    /**
     * Construct a new BaseDao object.
     */
    public BaseDaoImpl() {
    
    }
    
    /**
     * Saves the given object to the database.
     * 
     * @param domainObj - The domain object to save.
     * @throws LeefyAppException - the exception.
     * @return - The newly saved object.
     */
    public final T save(final T domainObj) throws LeefyAppException {
    
        try {
            LOG.debug(" BaseDaoImpl->save-> object details" + domainObj.toString());
            
            getHibernateTemplate().save(domainObj);
            return domainObj;
            
        } catch (DataAccessException ex) {
            LOG.error("BaseDaoImpl - error occured while saving object " + domainObj + "-->" + ex.toString());
            throw new LeefyAppException(LeefyConstant.HIBERNATE_INVALID_ADD_OPERATION, ex);
        }
    }
    
    /**
     * Method to update a record for the given domain object.
     * 
     * @param domainObj - The domain object to update.
     * @throws LeefyAppException - The exception.
     */
    public final void update(final T domainObj) throws LeefyAppException {
    
        try {
            getHibernateTemplate().update(domainObj);
        } catch (DataAccessException ex) {
            throw new LeefyAppException(LeefyConstant.HIBERNATE_INVALID_ADD_OPERATION, ex);
        }
    }
    
    /**
     * Method to delete the given domain object from the database.
     * 
     * @param domainObj - the domain object to be deleted from the db.
     * @throws LeefyAppException - the detailed exception.
     */
    public final void delete(final T domainObj) throws LeefyAppException {
    
        try {
            getHibernateTemplate().delete(domainObj);
        } catch (DataAccessException ex) {
            throw new LeefyAppException(LeefyConstant.HIBERNATE_INVALID_ADD_OPERATION, ex);
        }
    }
    
    /**
     * This method will create a collection of objects (if not already available in the db); else it will
     * update the existing records in the db for the given collection.
     * 
     * @param objList - The list of objects to be saved/updated.
     * @throws LeefyAppException - The detailed exception.
     */
    public void saveOrUpdateAll(List<T> objList) throws LeefyAppException {
    
        try {
            
            for(T t : objList){
            	getHibernateTemplate().saveOrUpdate(t);
            }
            
        } catch (DataAccessException ex) {
            throw new LeefyAppException(LeefyConstant.HIBERNATE_INVALID_ADD_OPERATION, ex);
        }
    }
    
    /**
     * Finds a db record for a specific domain object and its id.
     * 
     * @param domainObj - The domain object to be retrieved.
     * @param id - the specific id/key of the domain object to be retrieved.
     * @return Object - The specific domain object.
     * @throws LeefyAppException - The detailed exception.
     */
    public final Object findById(final Class<T> domainObj, final int id) throws LeefyAppException {
    
        try {
            return getHibernateTemplate().get(domainObj, id);
            
        } catch (DataAccessException e) {
            throw new LeefyAppException(LeefyConstant.HIBERNATE_INVALID_ADD_OPERATION, e);
        }
    }
    
    /**
     * Retrieves the entire list of records for a given domain object.
     * 
     * @param domainClass - the entity/domain object class.
     * @return List - The list of records for the given domain class.
     * @throws LeefyAppException - The detailed exception.
     */
    public final List<T> findAll(final Class<T> domainClass) throws LeefyAppException {
    
        try {
            return getHibernateTemplate().loadAll(domainClass);
        } catch (DataAccessException e) {
            throw new LeefyAppException(LeefyConstant.HIBERNATE_INVALID_ADD_OPERATION, e);
        }
    }
    
}
