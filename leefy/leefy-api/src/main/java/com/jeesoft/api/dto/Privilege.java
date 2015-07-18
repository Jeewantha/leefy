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

import java.util.Set;

/**
 * This class represents all properties of Privilege domain object.
 * 
 * @author Jeewantha Samaraweera
 * @since alpha
 */
public class Privilege extends BaseDomain implements Comparable<Privilege> {

	/** attribute for holding string. */
	private static final String NAME_STR = ", name=";

	/** attribute for holding string. */
	private static final String PRIVILEGE_ID = "privilegeId=";

	/**
	 * serialVersionUID- final.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Represents the ID of a Privilege.
	 */
	private int privilegeId;

	/**
	 * Represents the name of a Privilege.
	 */
	private String name;

	/**
	 * Represents the related page of a Privilege.
	 */
	private Page page;

	/**
	 * Represents the related RolePrivileges of this Privilege.
	 */
	private Set<RolePrivilege> rolePrivileges;

	/**
	 * Represents the related dependencies of this Privilege.
	 */
	private Set<PrivilegeDependency> privilegeDependencies;

	/**
	 * Default constructor.
	 */
	public Privilege() {

	}

	/**
	 * Returns the ID of the Privilege object.
	 * 
	 * @return - the ID of the Privilege.
	 */
	public final int getPrivilegeId() {

		return privilegeId;
	}

	/**
	 * Sets the ID for this Privilege with a given key.
	 * 
	 * @param privilegeIdObj
	 *            - the ID of the Privilege.
	 */
	public final void setPrivilegeId(final int privilegeIdObj) {

		this.privilegeId = privilegeIdObj;
	}

	/**
	 * Returns the name of the Privilege object.
	 * 
	 * @return - the name of the Privilege.
	 */
	public final String getName() {

		return name;
	}

	/**
	 * Sets the name for this Privilege.
	 * 
	 * @param nameObj
	 *            - the name of the Privilege.
	 */
	public final void setName(final String nameObj) {

		this.name = nameObj;
	}

	/**
	 * Returns the related page of the Privilege object.
	 * 
	 * @return - the related page of the Privilege.
	 */
	public final Page getPage() {

		return page;
	}

	/**
	 * Sets the related page for this Privilege.
	 * 
	 * @param pageObj
	 *            - the related page of the Privilege.
	 */
	public final void setPage(final Page pageObj) {

		this.page = pageObj;
	}

	/**
	 * Returns the related RolePriviles of the Privilege object.
	 * 
	 * @return - the related RolePriviles of the Privilege.
	 */
	public final Set<RolePrivilege> getRolePrivileges() {

		return rolePrivileges;
	}

	/**
	 * Sets the related RolePriviles for this Privilege.
	 * 
	 * @param rolePrivilegeSet
	 *            - the RolePriviles page of the Privilege.
	 */
	public final void setRolePrivileges(final Set<RolePrivilege> rolePrivilegeSet) {

		this.rolePrivileges = rolePrivilegeSet;
	}

	/**
	 * Returns the related dependencies of the Privilege object.
	 * 
	 * @return - the related dependencies of the Privilege.
	 */
	public final Set<PrivilegeDependency> getPrivilegeDependencies() {

		return privilegeDependencies;
	}

	/**
	 * Sets the related Dependencies for this Privilege.
	 * 
	 * @param privilegeDependenciesSet
	 *            - the PrivilegeDependencies of the Privilege.
	 */
	public final void setPrivilegeDependencies(final Set<PrivilegeDependency> privilegeDependenciesSet) {

		this.privilegeDependencies = privilegeDependenciesSet;
	}

	/**
	 * Returns a string representation of the object.
	 * 
	 * @return - the current object details.
	 */
	@Override
	public final String toString() {

		return PRIVILEGE_ID + privilegeId + NAME_STR + name;
	}

	/**
	 * Returns a string representation of the object.
	 * 
	 * @param o
	 *            - get the object to compare.
	 * @return - result .
	 */
	public final int compareTo(final Privilege o) {

		return (this.getPrivilegeId() < o.getPrivilegeId() ? -1 : (this.getPrivilegeId() == o.getPrivilegeId() ? 0 : 1));
	}

}
