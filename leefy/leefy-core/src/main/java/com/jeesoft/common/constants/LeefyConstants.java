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

package com.jeesoft.common.constants;

/**
 * All application related constants should be defined in this class.
 * 
 * @author Jeewantha Samaraweera
 * @since alpha
 */
public final class LeefyConstants {

	/**
	 * Private constructor to prevent instantiation of this class.
	 */
	private LeefyConstants() {

	}

	/** string constant for holding max login attempts. */
    public static final int MAX_LOGIN_COUNT = 3;
	
	/** The length of the generated password. */
    public static final int PASSWORDLENGTH = 10;
	
	/** A string use to generate a random password. */
    public static final String RANDOMSTRING = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	
	/** Holds the error message key. */
    public static final String ERROR_MESSAGE_UNIQUE_UNAME = "USER.CREATE.USER.UNIQUE.UNAME.ERROR";
    
    /** Holds the error message key. */
    public static final String ERROR_MESSAGE_UNIQUE_EMAIL = "USER.CREATE.USER.UNIQUE.EMAIL.ERROR";
    
    /** Holds the error message key. */
    public static final String USER_CREATE_USER_ROLE_NOT_AVAILABLE_ERROR = "USER.CREATE.USER.ROLE.NOT.AVAILABLE.ERROR";

	/** The Constant USER_LOGIN_FAILURE_ERROR. */
    public static final String USER_LOGIN_FAILURE_ERROR = "USER.LOGIN.FAILURE.ERROR";
    
    /** Holds the Leefy error messages property file name. */
    public static final String LEEFY_ERROR_MSG_PROPERTY = "errormessages";
	
	/**
	 * Key representing a DB Connection error.
	 */
	public static final String DB_CONNECTION_ERROR = "GEN.DB.CONN.ERROR";

	/**
	 * Key representing a error when searching.
	 */
	public static final String ERROR_OCCURED_WHILE_SEARCHING_THE_OBJECT = "error occured while searching the object-->";

	/**
	 * Key representing a error when deleting.
	 */
	public static final String ERROR_OCCURED_WHILE_DELETING_THE_OBJECT = "error occured while deleting the objects-->";

	/**
	 * Key representing a error when retrieving current sectional heads.
	 */
	public static final String ERROR_OCCURED_WHILE_RETRIEVING_THE_OBJECT = 
			"error occured while retrieving the object-->";

	/**
	 * Key representing an empty string.
	 */
	public static final String EMPTY_STRING = "";

	/**
	 * Key representing an subject.
	 */
	public static final String SUBJECT = "subject";

	/**
	 * Key representing an studentId.
	 */
	public static final String STUDENT_ID = "studentId";

	/**
	 * Key representing an unchecked string.
	 */
	public static final String UNCHECKED = "unchecked";

	/**
	 * Key representing a DB Connection error.
	 */
	public static final String EMAIL_ERROR = "EMAIL.ERROR";

	/**
	 * Key representing a message.
	 */
	public static final String MESSAGE = "message";

	/**
	 * Key representing invalid hibernate operation - add new record.
	 */
	public static final String HIBERNATE_INVALID_ADD_OPERATION = "GEN.DB.INVALID.OPERATION.ADD";

	/**
	 * Key representing error while converting a string into date format.
	 */
	public static final String DATE_CONVERSION_ERROR = "GEN.DB.INVALID.DATE.CONVERSION";

	/** Error message is to display when the field mismatch. */
	public static final String REPORTING_IO_EXCEPTION = "REPORTING.IO.EXCEPTION";

	/** Error message is to display when an error when the file is not found. */
	public static final String FILE_NOT_FOUND = "STU.UI.FILE.NOT.FOUND";

	/** index zero. */
	public static final int PARAM_INDEX_ZERO = 0;

	/** index ONE. */
	public static final int PARAM_INDEX_ONE = 1;

	/** index TWO. */
	public static final int PARAM_INDEX_TWO = 2;

	/** index THREE. */
	public static final int PARAM_INDEX_THREE = 3;

	/** index FOUR. */
	public static final int PARAM_INDEX_FOUR = 4;

	/** index FIVE. */
	public static final int PARAM_INDEX_FIVE = 5;

	/** index SIX. */
	public static final int PARAM_INDEX_SIX = 6;

	/** index TEN. */
	public static final int PARAM_INDEX_TEN = 10;

	/** attribute for holding maximum mark. */
	public static final int MAXIMUM_MARK = 100;

	/** attribute for holding minimum mark. */
	public static final int MINIMUM_MARK = 0;

	/** attribute for holding minus one. */
	public static final int MINUS_ONE = -1;

	/** The Constant TERM_GRADE. */
	public static final String TERM_GRADE = "TG";

	/** The Constant MONTHLY_GRADE. */
	public static final String MONTHLY_GRADE = "MG";

	/** The Constant ABSENT. */
	public static final String ABSENT = "AB";

	/**
	 * Represents the key for the error message when persist the attendance
	 * related data.
	 */
	public static final String ERROR_OCCURED_WHILE_LOADING = "Error while loading data -->.";

	/**
	 * Represents the key for the log message when began the transform of the
	 * scheduler.
	 */
	public static final String SCHEDULAR_TRANSFORM_BEGAN = "transform has began working.";

	/**
	 * Represents the key for the log message when working the transform of the
	 * scheduler.
	 */
	public static final Object SCHEDULAR_TRANSFORM_WORKING = "working...";

	/** Represents the key for the log message when error has occurred. */
	public static final String SCHEDULAR_TRANSFORM_ERROR = "I/O exception of some sort has occurred.";

	/**
	 * Represents the key for the log message when completed the transform of
	 * the scheduler.
	 */
	public static final String SCHEDULAR_TRANSFORM_COMPLETED = "transform has completed work.";

	/**
	 * Represents the key for the log message when began the extract of the
	 * scheduler.
	 */
	public static final String SCHEDULAR_EXTRACT_BEGAN = "extract has began working.";

	/**
	 * Represents the key for the log message when working the extract of the
	 * scheduler.
	 */
	public static final Object SCHEDULAR_EXTRACT_WORKING = "extract working...";

	/** Represents the key for the log message when copying the file. */
	public static final Object SCHEDULAR_EXTRACT_COPIED = "File copied.";

	/** Represents the key for the log message when file not found. */
	public static final Object SCHEDULAR_EXTRACT_NOT_FOUND = " in the specified directory.";

	/** Represents the key for the log message when error occurred. */
	public static final Object SCHEDULAR_EXTRACT_ERROR = " Error while streaming out the data.";

	/**
	 * Represents the key for the log message when completed the extract of the
	 * scheduler.
	 */
	public static final Object SCHEDULAR_EXTRACT_COMPLETED = "extract has completed.";

	/**
	 * Represents the key for the log message when began the loading of the
	 * scheduler.
	 */
	public static final String SCHEDULAR_LOAD_BEGAN = "load has began working.";

	/**
	 * Represents the key for the log message when completed the load of the
	 * scheduler.
	 */
	public static final String SCHEDULAR_LOAD_COMPLETED = "load successfuly completed.";

	/**
	 * Represents the key for the log message when began the clean of the
	 * scheduler.
	 */
	public static final String SCHEDULAR_CLEAN_BEAGAN = "clean has began working.";

	/**
	 * Represents the key for the log message when completed the clean of the
	 * scheduler.
	 */
	public static final String SCHEDULAR_CLEAN_COMPLETED = "clean successfuly completed.";

	/** Represents the key for the log message when deletion the file. */
	public static final Object SCHEDULAR_CLEAN_DELETE_ERROR = "SpradSheet Deletion failed.";

	/** Represents the key for the log message when success the deletion. */
	public static final Object SCHEDULAR_CLEAN_DELETE_SUCCESS = "SpradSheet deleted.";

	/**
	 * Represents the key for the log message when fail the deletion of the
	 * copied file.
	 */
	public static final Object SCHEDULAR_CLEAN_COPID_DELETE = "Copied File Deletion failed.";

	/**
	 * Represents the key for the log message when success the deletion of the
	 * copied file.
	 */
	public static final Object SCHEDULAR_CLEAN_COPID_DELETE_SUCCESS = "Copied File deleted.";

	/**
	 * Represents the key for the log message when persist of the object of the
	 * student is failed.
	 */
	public static final Object SCHEDULAR_TRANSFORM_STU_ID = "No record found for this admission number. --->";

	/**
	 * Represents the key for the log message when persist of the object of the
	 * staff is failed.
	 */
	public static final String SCHEDULAR_TRANSFORM_STAFF_ID = "No record found for this registration number. --->";

	/** Represents the key for the log message when error has occurred. */
	public static final String ERROR_WHILE_PROCESSING = "Error while processing the data.";

	/** Represents the key for the log message when file hasn't deleted. */
	public static final String ROLBACK_FILE_ERROR = "Rollback has happened. File is not deleted --- > ";

	/** Represents the key for the log message when folder hasn't deleted. */
	public static final String FOLDER_DELETED = " folder is deleted. --- > ";

	/** Represents the key for the log message when issue in the loading data. */
	public static final String DATA_LOADED_ERROR = "Data are not successfully loaded on to the database.";

	/** Represents the key for the log message when directory doesn't exist. */
	public static final Object DIRECTORY_DOES_NOT_EXIST = "Directory doesn't exists.";

	/** Represents the key for enable add edit and delete. */
	public static final String ENABLE_ADD_EDIT_DELETE = "EnableAddEditDelete";

	/** Represents the id of role admin. */
	public static final int ROLE_ADMIN = 1;

	/** Represents the id of role teacher. */
	public static final int ROLE_TEACHER = 2;

	/** Represents the id of role clerical staff. */
	public static final int ROLE_CLERICAL_STAFF = 4;

	/**
	 * Constant for holding rank index used in class wise student marks sheet
	 * report.
	 */
	public static final int RANK_INDEX = 22;

	/** Represents the decimal pattern. */
	public static final String ROUND_PATTERN = "###.";

	/** Represents the rounded decimal. */
	public static final String ROUNDED_DECIMAL = "#";

	/** Represents the Percentage mark. */
	public static final String PERCENTAGE_MARK = " %";

	/** Represents hundred. */
	public static final int HUNDRED = 100;

	/** Represents two floating point. */
	public static final int FLOAT_POINT_TWO = 2;

	/** Represents Three. */
	public static final int THREE = 3;

	/** Represents the key for HALF_DAY. */
	public static final String HALF_DAY = "Half Day";

	/** Represents ZERO_POINT_FIVE. */
	public static final float ZERO_POINT_FIVE = 0.5f;

	/** Represents ten. */
	public static final int TEN = 10;

	/** Represents nine. */
	public static final int NINE = 9;

	/** Key representing a Phone number error. */
	public static final String PHONENUMBER_ERROR = "PHONENUMBER.ERROR";

	/** Represents EMPTY_STRING_SPACE. */
	public static final String EMPTY_STRING_SPACE = " ";

	/** Represents STRING_ZERO. */
	public static final String STRING_ZERO = "0";

	/** Represents PLUS_SIGN. */
	public static final String PLUS_SIGN = "+";

	/** Represents BR_TAG. */
	public static final String BR_TAG = "<br>";

	/** Represents EQUAL_SIGN. */
	public static final String EQUAL_SIGN = "=";

	/** Represents DASH_SIGN. */
	public static final String DASH_SIGN = "-";
}
