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

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

import com.jeesoft.common.annotation.FieldMatch;


/**
 * The Class UserRegistrationForm.
 * 
 * @author Jeewantha Samaraweera
 * @since alpha
 */
@FieldMatch.List({
    @FieldMatch(first="password", second="confirmPassword", message="The password and confirm password fields must match"),
    @FieldMatch(first="email", second="confirmEmail", message="The email fields must match")
})
public class UserRegistrationForm implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The Constant INTEGER_FOURTY. */
	private static final int INTEGER_FOURTY = 40;

	/** The id. */
	private Long id;

	/** The name. */
	@NotNull
	@Size(min = 1, max = INTEGER_FOURTY)
	private String username;

	/** The password. */
	@NotNull
	@Size(min=6, max=12, message="The password should be 6 to 12 characters containing any character")
	private String password;
	
	/** The confirm password. */
	private String confirmPassword;

	/** The phone. */
	private String phone;

	/** The email. */
	@Email
	private String email;

	/** The confirm email. */
	private String confirmEmail;
	
	/** The birthday. */
	private Date birthday;
	
	/** The country. */
	private String country;
	
	/**
	 * Instantiates a new personal contact.
	 */
	public UserRegistrationForm() {
	}

	/**
	 * Instantiates a new personal contact.
	 *
	 * @param username the username
	 * @param phone the phone
	 * @param email the email
	 * @param password the password
	 * @param birthday the birthday
	 * @param country the country
	 */
	public UserRegistrationForm(String username, String phone, String email,
            String password, Date birthday, String country) {
        super();
        this.username = username;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.birthday = birthday;
        this.country = country;
    }

    /**
     * Gets the id.
     *
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the id.
     *
     * @param id the new id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the username.
     *
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username.
     *
     * @param username the new username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets the password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password.
     *
     * @param password the new password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets the confirm password.
     *
     * @return the confirm password
     */
    public String getConfirmPassword() {
        return confirmPassword;
    }

    /**
     * Sets the confirm password.
     *
     * @param confirmPassword the new confirm password
     */
    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    /**
     * Gets the phone.
     *
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Sets the phone.
     *
     * @param phone the new phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Gets the email.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email.
     *
     * @param email the new email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the confirm email.
     *
     * @return the confirm email
     */
    public String getConfirmEmail() {
        return confirmEmail;
    }

    /**
     * Sets the confirm email.
     *
     * @param confirmEmail the new confirm email
     */
    public void setConfirmEmail(String confirmEmail) {
        this.confirmEmail = confirmEmail;
    }

    /**
     * Gets the birthday.
     *
     * @return the birthday
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * Sets the birthday.
     *
     * @param birthday the new birthday
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * Gets the country.
     *
     * @return the country
     */
    public String getCountry() {
        return country;
    }

    /**
     * Sets the country.
     *
     * @param country the new country
     */
    public void setCountry(String country) {
        this.country = country;
    }

 }
