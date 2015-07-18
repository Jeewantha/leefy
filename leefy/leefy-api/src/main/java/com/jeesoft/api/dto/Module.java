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
import java.util.HashSet;
import java.util.Set;

/**
 * This class represents all properties of Module domain object.
 * 
 * @author Jeewantha Samaraweera
 * @since alpha
 */
public class Module extends BaseDomain {
    
    /** attribute for holding string. */
    private static final String NAME_STR = ", name=";
    
    /** attribute for holding string. */
    private static final String MODULE_ID = "moduleId=";
    
    /**
     * serialVersionUID- final.
     */
    private static final long serialVersionUID = 1L;
    
    /**
     * Represents the ID of a Module.
     */
    private int moduleId;
    
    /**
     * Represents the name of a Module.
     */
    private String name;
    
    /**
     * Represents the tabs of a Module.
     */
    private Set<Tab> tabs = new HashSet<Tab>(0);
    
    /**
     * Default constructor.
     */
    public Module() {

    }
    
    /**
     * Returns the ID of the Module object.
     * 
     * @return - the ID of the Module.
     */
    public int getModuleId() {

        return moduleId;
    }
    
    /**
     * Sets the ID for this Module with a given key.
     * 
     * @param moduleIdObj - the ID of the Module.
     */
    public void setModuleId(int moduleIdObj) {

        this.moduleId = moduleIdObj;
    }
    
    /**
     * Returns the name of the Module object.
     * 
     * @return - the name of the Module.
     */
    public String getName() {

        return name;
    }
    
    /**
     * Sets the name for this Module with a given name.
     * 
     * @param nameObj - the name of the Module.
     */
    public void setName(String nameObj) {

        this.name = nameObj;
    }
    
    /**
     * Returns the tabs of Module object.
     * 
     * @return - the tabs of this Module.
     */
    public Set<Tab> getTabs() {

        return tabs;
    }
    
    /**
     * Sets the tabs of this Module.
     * 
     * @param tabSet - the ID of the Module.
     */
    public void setTabs(Set<Tab> tabSet) {

        this.tabs = tabSet;
    }
    
    /**
     * Returns a string representation of the object.
     * 
     * @return - the current object details.
     */
    @Override
    public String toString() {

        return MODULE_ID + moduleId + NAME_STR + name;
    }
}
