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
package com.jeesoft.model;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

/**
 * The Class PersonalContact.
 */
public class PersonalContact implements Serializable {

	/** The Constant INTEGER_FOURTY. */
	private static final int INTEGER_FOURTY = 40;

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	private Long id;

	/** The name. */
	@NotNull
	@Size(min = 1, max = INTEGER_FOURTY)
	private String name;

	/** The phone. */
	private String phone;

	/** The email. */
	@Email
	private String email;

	/**
	 * Instantiates a new personal contact.
	 */
	public PersonalContact() {
	}

	/**
	 * Instantiates a new personal contact.
	 *
	 * @param id
	 *            the id
	 * @param name
	 *            the name
	 * @param phone
	 *            the phone
	 * @param email
	 *            the email
	 */
	public PersonalContact(final Long id, final String name, final String phone, final String email) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.email = email;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public final Long getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id
	 *            the new id
	 */
	public final void setId(final Long id) {
		this.id = id;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public final String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name
	 *            the new name
	 */
	public final void setName(final String name) {
		this.name = name;
	}

	/**
	 * Gets the phone.
	 *
	 * @return the phone
	 */
	public final String getPhone() {
		return phone;
	}

	/**
	 * Sets the phone.
	 *
	 * @param phone
	 *            the new phone
	 */
	public final void setPhone(final String phone) {
		this.phone = phone;
	}

	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public final String getEmail() {
		return email;
	}

	/**
	 * Sets the email.
	 *
	 * @param email
	 *            the new email
	 */
	public final void setEmail(final String email) {
		this.email = email;
	}
}
