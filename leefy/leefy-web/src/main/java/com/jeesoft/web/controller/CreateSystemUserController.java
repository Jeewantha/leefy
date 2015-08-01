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
package com.jeesoft.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.jeesoft.api.dto.UserLogin;
import com.jeesoft.api.dto.UserRole;
import com.jeesoft.common.exception.InvalidIdentificationNoException;
import com.jeesoft.common.exception.LeefyAppException;
import com.jeesoft.common.exception.NonCurrentStudentUserLoginCreationException;
import com.jeesoft.common.exception.PastStaffException;
import com.jeesoft.common.exception.UniqueUserNameEmailException;
import com.jeesoft.common.messages.ErrorMessageLoader;
import com.jeesoft.web.delegate.user.GuestSystemUserDelegate;
import com.jeesoft.web.services.user.UserService;

/**
 * The Class CreateSystemUserController.
 */
@Controller
public class CreateSystemUserController {


    
    /** String attribute for holding MESSAGE_TOPIC. */
    private static final String MESSAGE_TOPIC = "Login details for your referance.";
    
    /** String attribute for holding MAP_PASSWORD. */
    private static final String MAP_PASSWORD = "passWord";
    
    /** String attribute for holding MAP_UNAME. */
    private static final String MAP_UNAME = "uName";
    
    /** String attribute for holding MAP_LNAME. */
    private static final String MAP_LNAME = "lName";
    
    /** String attribute for holding MAP_FNAME. */
    private static final String MAP_FNAME = "fName";
    
    /** String attribute for holding MAIL_SUBJECT. */
    private static final String MAIL_SUBJECT = "User Name Password Confirmation mail";
    
    /** String attribute for holding MSG_SYSTEM_USER_MAIL. */
    private static final String MSG_SYSTEM_USER_MAIL = "REF.UI.SYSTEM.USER.MAIL";
  
    /** String attribute for holding MSG_SYSTEM_USER_EDITED_MAIL. */
    private static final String MSG_SYSTEM_USER_EDITED_MAIL = "REF.UI.SYSTEM.USER.EDITED.MAIL";
    
    /** String attribute for holding SESSION_USER. */
    private static final String SESSION_USER = "user";
    
    /** String attribute for holding ERROR_MSG_INVALID_IDENTIFICATION. */
    private static final String ERROR_MSG_INVALID_IDENTIFICATION = "REF.UI.USERLOGIN.INVALID.IDENTIFICATION";
    
    /** String attribute for holding USER_IDENTIFICATION_NO. */
    private static final String USER_IDENTIFICATION_NO = "userIdentificationNo";
    
    /** String attribute for holding SUCCESS message. */
    private static final String SUCCESS = "success";
    
    /** String attribute for holding SUCCESS_MSG_SYS_USER. */
    private static final String SUCCESS_MSG_SYS_USER = "REF.SYS.USER";
    
    /** String attribute for holding `REF.SYS.USER.EDITED`. */
    private static final String SUCCESS_MSG_SYS_USER_EDIT = "REF.SYS.USER.EDITED";
    
    /** String attribute for holding ERROR_MSG_PASSWORD_ERROR. */
    private static final String ERROR_MSG_PASSWORD_ERROR = "REF.UI.USERLOGIN.PASSWORD.ERROR";
    
    /** String attribute for holding ERROR_MSG_USERNAME_EXIST. */
    private static final String ERROR_MSG_USERNAME_EXIST = "REF.UI.USERLOGIN.USERNAME.EXIST";
    
    /** String attribute for holding ERROR_MSG_USERLOGIN_PAST_USER. */
    private static final String ERROR_MSG_USERLOGIN_PAST_USER = "REF.UI.USERLOGIN.PAST.USER";
    
    /** String attribute for holding ERROR_MSG_EMAIL_EXIST. */
    private static final String ERROR_MSG_EMAIL_EXIST = "REF.UI.USERLOGIN.EMAIL.EXIST";
    
    /** String attribute for holding ERROR_MSG_IDENTIFICATION_EXITS. */
    private static final String ERROR_MSG_IDENTIFICATION_EXITS = "REF.UI.USERLOGIN.IDENTIFICATIONNO.EXIST";
    
    /** String attribute for holding USERNAME. */
    private static final String USERNAME = "username";
    
    /** model attribute of message. */
    private static final String MODEL_ATT_MESSAGE = "message";
    
    /** model attribute of message. */
    private static final String MODEL_ATT_MESSAGE_SUCCESS = "successMessage";
    
    /** String attribute for holding EMAIL. */
    private static final String EMAIL = "email";
    
    /** String attribute for holding PASSWORD. */
    private static final String PASSWORD = "password";
    
    /** String attribute for holding USER_LOGIN_ID. */
    private static final String REQ_USER_LOGIN_ID = "userLoginId";
    
    /** String attribute for holding REQ_CONFIRM_PASSWORD. */
    private static final String REQ_CONFIRM_PASSWORD = "confirmPassword";
    
    /** String attribute for holding MODEL_ATT_USER_DETAIL. */
    private static final String MODEL_ATT_USER_DETAIL = "userDetail";
    
    /** String attribute for holding VIEW_CREATE_SYSTEM_USER. */
    private static final String VIEW_CREATE_SYSTEM_USER = "reference/createSystemUser";
    
    /** String attribute for holding USER_LEVEL_LIST. */
    private static final String USER_LEVEL_LIST = "userLevelList";
    
    /** String attribute for holding MODEL_ATT_USER_DETAIL. */
    private static final String MODEL_ATT_USER_IDENTIFICATION_NO = "identificationNo";

    /** String attribute for holding CREATE_OR_UPDATE_URL. */
    private static final String CREATE_OR_UPDATE_URL = "createSystemUser.htm";
    
    /** The Constant logger. */
    private static final Logger LOG = LoggerFactory.getLogger(CreateSystemUserController.class);
    
    /**
     * A constant serves as a key for storing path to email properties file.
     */
    public static final String EMAIL_PROPERTIES = EMAIL;
    
    /**
     * The constant for hold confirmation velocity file name.
     */
    public static final String VELOCITY_CONFIRMATION_TO_USER = "email.template.registrationConfirmation";
    
    /**
     * Represents an instance of SystemUserValidator.
     */
    /*private SystemUserValidator systemUserValidator;*/
    
    /**
     * Represents an instance of StudentSystemUserDelegate.
     */
    /*private SystemUserDelegate studentSystemUserDelegate;*/
    
    /**
     * Represents an instance of StaffSystemUserDelegate.
     */
    private GuestSystemUserDelegate guestSystemUserDelegate;
    
    /**
     * Represents an instance of ParentSystemUserDelegate.
     */
    /*private ParentSystemUserDelegate parentSystemUserDelegate;*/
    
    /**
     * Represents an instance of UserService.
     */
    private UserService userService;
    
    /** emailService attribute for holding EmailService. */
    /*private EmailService emailService;*/
    
    /**
     * Sets an instance of StudentSystemUserDelegate.
     * 
     * @param studentSystemUserDelegateVal - an instance of StudentSystemUserDelegate.
     */
/*    public final void setStudentSystemUserDelegate(SystemUserDelegate studentSystemUserDelegateVal) {

        this.studentSystemUserDelegate = studentSystemUserDelegateVal;
    }*/
    
    /**
     * Sets an instance of StaffSystemUserDelegate.
     * 
     * @param staffSystemUserDelegateVal - an instance of StaffSystemUserDelegate.
     */
/*    public final void setStaffSystemUserDelegate(SystemUserDelegate staffSystemUserDelegateVal) {

        this.staffSystemUserDelegate = staffSystemUserDelegateVal;
    }*/
    
    /**
     * Method is to return emergency relationships data.
     * 
     * @return relationshipList - relationship list.
     * @throws LeefyAppException - LeefyAppException
     */
    //@ModelAttribute(USER_LEVEL_LIST)
    public List<UserRole> populateUserLevelList() throws LeefyAppException {
        //SortUtil.sortUserRoleList(userService.getUserRoleList());
        return userService.getUserRoleList();
    }
    
    /**
     * handle GET requests for Student_details view.
     * 
     * @param model - ModelMap
     * @return the name of the view.
     */
    //@RequestMapping(method = RequestMethod.GET)
    public String showSystemUserDetailForm(ModelMap model) {

        // UserLogin userLogin = new UserLogin();
        UserLogin userLogin = (UserLogin) model.get(MODEL_ATT_USER_DETAIL);
        
        if (userLogin == null) {
            userLogin = new UserLogin();
        }
        model.addAttribute(MODEL_ATT_USER_DETAIL, userLogin);
        
        return VIEW_CREATE_SYSTEM_USER;
    }
    
    /**
     * This method handles add new system user.
     * 
     * @param userLogin - UserLogin obj.
     * @param result - BindingResult.
     * @param model - {@link ModelMap}
     * @param session - {@link HttpSession}
     * @param request - {@link HttpServletRequest}
     * @throws LeefyAppException - LeefyAppException.
     * @return name of the view which is redirected to.
     */
    //@RequestMapping(method = RequestMethod.POST)
    public String onSubmit(@ModelAttribute(MODEL_ATT_USER_DETAIL) UserLogin userLogin, BindingResult result,
            ModelMap model, HttpSession session, HttpServletRequest request) throws LeefyAppException {

        String dispatchUrl = null;
        /*systemUserValidator.validate(userLogin, result);*/
        UserLogin existUser = null;
        
        try {
            
            if (result.hasErrors()) {
                dispatchUrl = VIEW_CREATE_SYSTEM_USER;
                
            } else {
                
                final int selectedUserLoginId = Integer.parseInt(request.getParameter(REQ_USER_LOGIN_ID));
                String confirmPassword = request.getParameter(REQ_CONFIRM_PASSWORD);
                existUser = (selectedUserLoginId > 0 ? userService.getUserByName(userLogin.getUsername()) : null);
                
                boolean isUserNameExist = false;
                boolean isEmailExist = false;
                boolean isConfirmedPassword = false;
                boolean isUserIdentificationNoExits = false;
                boolean isPastUser = false;
                int identificationNo = 0; // staff key or the student key.
                int userRoleId = userLogin.getUserRoleId();
                String userIdNo = userLogin.getUserIdentificationNo();
                
                int roleId = userLogin.getUserRoleId();
                String identification =
                        userLogin.getUserIdentificationNo() != null ? userLogin.getUserIdentificationNo().trim() : "";
                int userKey = 0; // the key of the user.
                
                // gets the student key and the staff key as the identification number with the
                // user role key and the admission number or the registration number
                /*userKey = getIdentificationNo(identification, roleId);*/
                
                // Validate whether the user name is already exist.
                // User name can not be duplicate for any user role.
                if (existUser == null) {
                    isUserNameExist = isUserNameExist(userLogin.getUsername().trim());
                }
                
                // Validate whether the email is already exist. Email can
                // not be duplicate for any user role.
                if (existUser == null || !userLogin.getEmail().equals(existUser.getEmail())) {
                    isEmailExist = isEmailExist(userLogin.getEmail());
                }
                
                // Check whether the password and confirmPassword are equal.
                isConfirmedPassword = isConfirmPassword(userLogin.getPassword(), confirmPassword);
                
                // check whether the user is past or not
                /*if (validateIdentificationNo(userRoleId, userIdNo)) {
                    userLogin.setUserIdentificationNo(userKey + "");
                    isPastUser = isPastUser(userLogin);
                }*/
                // Check whether the user Identification no is exists.
                if (identification != null && !identification.isEmpty() && existUser == null) {
                    
                    // gets the student key and the staff key as the identification number with the
                    // user role key and the admission number or the registration number if there is
                    // a user login for the user.
                    identificationNo = userService.getAnyUserByUserRoleIdAndIdentificationNo(roleId, identification);
                    
                    // checks the identification number is already exist or not.
                    isUserIdentificationNoExits = isUserIdentificationNoExist(identificationNo);
                }
                
                if (isUserNameExist || isEmailExist || isConfirmedPassword || 
                        isUserIdentificationNoExits || isPastUser) {
                    
                    if (isConfirmedPassword) {
                        result.rejectValue(PASSWORD, ERROR_MSG_PASSWORD_ERROR);
                    } else if (isEmailExist) {
                        result.rejectValue(EMAIL, ERROR_MSG_EMAIL_EXIST);
                    } else if (isUserNameExist) {
                        result.rejectValue(USERNAME, ERROR_MSG_USERNAME_EXIST);
                    } else if (isPastUser) {
                        result.rejectValue(USERNAME, ERROR_MSG_USERLOGIN_PAST_USER);
                    } else {
                        result.rejectValue(USER_IDENTIFICATION_NO, ERROR_MSG_IDENTIFICATION_EXITS);
                    }
                    dispatchUrl = VIEW_CREATE_SYSTEM_USER;
                    
                } else if (/*validateIdentificationNo(userRoleId, userIdNo) && existUser == null ||*/ existUser != null) {
                    // check valid admission no is entered
                    String psWord = userLogin.getPassword();
                    
                    // set user identification NO (replace RegNo with Primary key. E.g. RegNo with
                    // Student_id).
                    userLogin.setUserIdentificationNo(userKey + "");
                    
                    // set system generated password to true & status to true.
                    if (existUser == null || !existUser.getPassword().equals(userService.encodePassword(userLogin))) {
                        userLogin.setGeneratedPassword(true);
                    }
                    userLogin.setStatus(true);
                    
                    if (existUser != null) {
                        userService.editUser(userLogin);
                    } else {
                        userService.createUser(userLogin, userKey);
                    }
                    
                    /*String status = this.sendConfirmationMail(userLogin, psWord, session, model);
                    
                    if (status == SUCCESS && existUser == null) {
                        String message = new ErrorMessageLoader().getErrorMessage(SUCCESS_MSG_SYS_USER);
                        model.addAttribute(MODEL_ATT_MESSAGE, message);
                        dispatchUrl = showSystemUserDetailForm(model);
                    } else if (status == SUCCESS && existUser != null) {
                        String message = new ErrorMessageLoader().getErrorMessage(SUCCESS_MSG_SYS_USER_EDIT);
                        model.addAttribute(MODEL_ATT_MESSAGE, message);
                        dispatchUrl = showSystemUserDetailForm(model);
                    } else {
                        dispatchUrl = status;
                    }*/
                    
                } else {
                    result.rejectValue(USER_IDENTIFICATION_NO, ERROR_MSG_INVALID_IDENTIFICATION);
                    dispatchUrl = VIEW_CREATE_SYSTEM_USER;
                }
            }
        } catch (LeefyAppException e) {
            boolean errorMessage = false;
            if (e.getCause() instanceof IllegalArgumentException) {
                errorMessage = true;
            }
            else {
                throw e;
            }
            
            if (errorMessage) {
                
                LOG.error("Error Sending Mail ( onSubmit method )" + e);
                
                String message = new ErrorMessageLoader().getErrorMessage(MSG_SYSTEM_USER_MAIL);
                model.addAttribute(MODEL_ATT_MESSAGE, message);
                dispatchUrl = showSystemUserDetailForm(model);
            }
        }
        String identificationNo = getUserIdentificationNo(userLogin);
        model.addAttribute(MODEL_ATT_USER_IDENTIFICATION_NO, identificationNo);
        model.addAttribute(MODEL_ATT_USER_DETAIL, userLogin);
        
        return dispatchUrl;
    }
    
    /**
     * This method handles add new system user.
     * 
     * @param userLogin - UserLogin obj.
     * @param result - BindingResult.
     * @param model - {@link ModelMap}
     * @param session - {@link HttpSession}
     * @param request - {@link HttpServletRequest}
     * @throws LeefyAppException - LeefyAppException.
     * @return name of the view which is redirected to.
     */
    //@RequestMapping(value = CREATE_OR_UPDATE_URL, method = RequestMethod.POST)
    public String createOrUpdateSystemUser(@ModelAttribute(MODEL_ATT_USER_DETAIL) UserLogin userLogin,
            BindingResult result, ModelMap model, HttpSession session, HttpServletRequest request)
            throws LeefyAppException {

        /* initialize the variables */
        String dispatchUrl = VIEW_CREATE_SYSTEM_USER;
        String identificationNo = "";
        String message = "";
        String successMessage = "";
        String confirmPassword = request.getParameter(REQ_CONFIRM_PASSWORD);
        boolean isNewUser = true;
        
        /* get the user Identification no and replace with identification key */
        identificationNo = userLogin.getUserIdentificationNo();
        
        /* validate the userLogin */
        /*systemUserValidator.validate(userLogin, result);*/
        
        if (result.hasErrors() || !userLogin.getPassword().equals(confirmPassword)) {
            // validate the password
            if (!result.hasErrors() && !userLogin.getPassword().equals(confirmPassword)) {
                result.rejectValue(PASSWORD, ERROR_MSG_PASSWORD_ERROR);
            }
        } else {
            try {
                
                /* save or update user */
                if (userLogin.getUserLoginId() == 0) {
                    userService.createSystemUser(userLogin);
                } else {
                    isNewUser = false;
                    userService.editSystemUser(userLogin);
                }
                
                /* send the mail */
                /*boolean status = this.sendConfirmationMailNew(userLogin, userLogin.getPassword(), session, model);
                
                if (status && isNewUser) {
                    successMessage = new ErrorMessageLoader().getErrorMessage(SUCCESS_MSG_SYS_USER);
                    dispatchUrl = showSystemUserDetailForm(model);
                } else if (status && !isNewUser) {
                    successMessage = new ErrorMessageLoader().getErrorMessage(SUCCESS_MSG_SYS_USER_EDIT);
                    dispatchUrl = showSystemUserDetailForm(model);
                }*/
                
            }/* catch (MailException e) {
                LOG.error("Err or Sending Mail ( createOrUpdateSystemUser method )" + e);
                if(!isNewUser){
                     message = new ErrorMessageLoader().getErrorMessage( MSG_SYSTEM_USER_EDITED_MAIL);
                }else{
               message = new ErrorMessageLoader().getErrorMessage(MSG_SYSTEM_USER_MAIL);
               }
            }*/ catch (IllegalArgumentException e) {
                LOG.error("Error Sending Mail ( createOrUpdateSystemUser method )" + e);
              message = new ErrorMessageLoader().getErrorMessage(MSG_SYSTEM_USER_MAIL);
            } catch (UniqueUserNameEmailException e) {
                message = e.getErrorCode();
                dispatchUrl = showSystemUserDetailForm(model);
            } catch (InvalidIdentificationNoException e) {
                message = e.getErrorCode();
                dispatchUrl = showSystemUserDetailForm(model);
            } catch (PastStaffException e) {
                message = e.getErrorCode();
                dispatchUrl = showSystemUserDetailForm(model);
            }catch (NonCurrentStudentUserLoginCreationException e) {
                message = e.getErrorCode();
                dispatchUrl = showSystemUserDetailForm(model);
            } catch (LeefyAppException e) {
                message = e.getErrorCode();
                dispatchUrl = showSystemUserDetailForm(model);
            }
        }
        
        /* set model attributes */
        model.addAttribute(MODEL_ATT_MESSAGE, message);
        model.addAttribute(MODEL_ATT_MESSAGE_SUCCESS, successMessage);
        model.addAttribute(MODEL_ATT_USER_IDENTIFICATION_NO, identificationNo);
        
        return dispatchUrl;
    }
    
    /**
     * get user Identification No.
     * 
     * @param userLogin - user Login object
     * @throws LeefyAppException - Throw detailed exception.
     * @return identification no.
     */
    private String getUserIdentificationNo(UserLogin userLogin) throws LeefyAppException {

        // get user's registration No or admission No
        String identificationNo = "";
        
        if (userLogin.getUserIdentificationNo() != null && !userLogin.getUserIdentificationNo().equals("")) {
            if (userLogin.getUserRoleId() == com.jeesoft.api.enums.UserRole.ROLE_GUEST.getUserRoleId()) {
                identificationNo =
                        guestSystemUserDelegate.getIdentificationNoByKey(Integer.parseInt(userLogin
                                .getUserIdentificationNo()));
            }
        } else {
            identificationNo = userLogin.getUserIdentificationNo();
        }
        return identificationNo;
    }
    
    /**
     * get user Identification key.
     * 
     * @param identification - identification
     * @param roleId - roleId
     * @throws LeefyAppException - Throw detailed exception.
     * @return identification no.
     */
/*    private int getIdentificationNo(String identification, int roleId) throws LeefyAppException {

        int primaryKey = 0;
        if (roleId == com.jeesoft.api.enums.UserRole.ROLE_ADMIN.getUserRoleId()
                || roleId == com.jeesoft.api.enums.UserRole.ROLE_ADMIN.getUserRoleId()) {
            primaryKey = guestSystemUserDelegate.getKeyByIdentificationNo(identification);
        } else if (roleId == com.jeesoft.api.enums.UserRole.ROLE_GUEST.getUserRoleId()) {
            primaryKey = studentSystemUserDelegate.getKeyByIdentificationNo(identification);
        }
        return primaryKey;
    }*/
    
    /**
     * Validate Identification No.
     * 
     * @param userRoleId - int
     * @param userIdNo - String
     * @throws LeefyAppException - Throw detailed exception.
     * @return true for valid identification no and false for invalid one.
     */
/*    private boolean validateIdentificationNo(int userRoleId, String userIdNo) throws LeefyAppException {

        return (userRoleId == com.virtusa.akura.api.enums.UserRole.ROLE_STUDENT.getUserRoleId() && 
                studentSystemUserDelegate.isExistRegistrationNo(userIdNo))
                || ((userRoleId == com.virtusa.akura.api.enums.UserRole.ROLE_TEACHER.getUserRoleId()
                        || userRoleId == com.virtusa.akura.api.enums.UserRole.ROLE_CLERICALSTAFF
                        .getUserRoleId()) && guestSystemUserDelegate.isExistRegistrationNo(userIdNo))
                || (userRoleId == com.virtusa.akura.api.enums.UserRole.ROLE_PARENT.getUserRoleId() && 
                        parentSystemUserDelegate.isExistRegistrationNo(userIdNo))
                || (userRoleId != 0 && userRoleId != com.virtusa.akura.api.enums.UserRole.ROLE_STUDENT.getUserRoleId()
                        && userRoleId != com.virtusa.akura.api.enums.UserRole.ROLE_CLERICALSTAFF.getUserRoleId()
                        && userRoleId != com.virtusa.akura.api.enums.UserRole.ROLE_PARENT.getUserRoleId() 
                        && userRoleId != com.virtusa.akura.api.enums.UserRole.ROLE_TEACHER
                        .getUserRoleId());
    }*/
    
    /**
     * method to Send Email.
     * 
     * @param userNewObj - UserLogin
     * @param psword - String
     * @param session - HttpSession
     * @param model - {@link ModelMap}
     * @throws LeefyAppException - Throw detailed exception.
     * @return name of the view which is redirected to.
     */
/*    private String sendConfirmationMail(UserLogin userNewObj, String psword, HttpSession session, ModelMap model)
            throws LeefyAppException {

        String strMessage = null;
        try {
            // newly created user details.
            String strToemail = userNewObj.getEmail();
            String firstName = userNewObj.getFirstName();
            String lastName = userNewObj.getLastName();
            String password = psword;
            String userName = userNewObj.getUsername();
            
            CommonEmailBean commonEmailBean = new CommonEmailBean();
            // from mail address
            if (session.getAttribute(SESSION_USER) != null) {
                UserInfo userInfo = (UserInfo) session.getAttribute(SESSION_USER);
                String logginUserName = userInfo.getUsername();
                UserLogin userLogin = userService.getUserByName(logginUserName);
                String strFromAddress = userLogin.getEmail();
                commonEmailBean.setFromAddress(strFromAddress);
            }
            String templateName = PropertyReader.getPropertyValue(EMAIL_PROPERTIES, VELOCITY_CONFIRMATION_TO_USER);
            
            Map<String, Object> mapObjectMap = new HashMap<String, Object>();
            mapObjectMap.put(MODEL_ATT_MESSAGE, MESSAGE_TOPIC);
            mapObjectMap.put(MAP_FNAME, firstName);
            mapObjectMap.put(MAP_LNAME, lastName);
            mapObjectMap.put(MAP_UNAME, userName);
            mapObjectMap.put(MAP_PASSWORD, password);
            
            // Include email header information
            EmailUtil.addHeaderForEmail(mapObjectMap);
            
            commonEmailBean.setToAddress(strToemail);
            commonEmailBean.setMailTemplate(templateName);
            commonEmailBean.setObjectMap(mapObjectMap);
            commonEmailBean.setSubject(MAIL_SUBJECT);
            emailService.sendMail(commonEmailBean);
            
            return SUCCESS;
            
        } catch (MailException e) {
            
            LOG.error("Error Sending Mail ( sendConfirmationMail method )" + e);
            
            strMessage = new ErrorMessageLoader().getErrorMessage(MSG_SYSTEM_USER_MAIL);
            model.addAttribute(MODEL_ATT_MESSAGE, strMessage);
            UserLogin userLogin = new UserLogin();
            model.addAttribute(MODEL_ATT_USER_DETAIL, userLogin);
            
            return VIEW_CREATE_SYSTEM_USER;
        }
        
    }*/
    
    /**
     * method to Send Email.
     * 
     * @param userNewObj - UserLogin
     * @param psword - String
     * @param session - HttpSession
     * @param model - {@link ModelMap}
     * @throws LeefyAppException - Throw detailed exception.
     * @return the mail successfully sent or not.
     */
/*    private boolean sendConfirmationMailNew(UserLogin userNewObj, String psword, HttpSession session, ModelMap model)
            throws LeefyAppException {

        try {
            // newly created user details.
            String strToemail = userNewObj.getEmail();
            String firstName = userNewObj.getFirstName();
            String lastName = userNewObj.getLastName();
            String password = psword;
            String userName = userNewObj.getUsername();
            
            CommonEmailBean commonEmailBean = new CommonEmailBean();
            // from mail address
            if (session.getAttribute(SESSION_USER) != null) {
                UserInfo userInfo = (UserInfo) session.getAttribute(SESSION_USER);
                String logginUserName = userInfo.getUsername();
                UserLogin userLogin = userService.getUserByName(logginUserName);
                String strFromAddress = userLogin.getEmail();
                commonEmailBean.setFromAddress(strFromAddress);
            }
            String templateName = PropertyReader.getPropertyValue(EMAIL_PROPERTIES, VELOCITY_CONFIRMATION_TO_USER);
            
            Map<String, Object> mapObjectMap = new HashMap<String, Object>();
            mapObjectMap.put(MODEL_ATT_MESSAGE, MESSAGE_TOPIC);
            mapObjectMap.put(MAP_FNAME, firstName);
            mapObjectMap.put(MAP_LNAME, lastName);
            mapObjectMap.put(MAP_UNAME, userName);
            mapObjectMap.put(MAP_PASSWORD, password);
            
            // Include email header information
            EmailUtil.addHeaderForEmail(mapObjectMap);
            
            commonEmailBean.setToAddress(strToemail);
            commonEmailBean.setMailTemplate(templateName);
            commonEmailBean.setObjectMap(mapObjectMap);
            commonEmailBean.setSubject(MAIL_SUBJECT);
            emailService.sendMail(commonEmailBean);
            
            return true;
            
        } catch (MailException e) {
            
            throw e;
        }
        
    }*/
    
    /**
     * Check whether user name already exist.
     * 
     * @param userName - type string
     * @return true if the user name exist else false.
     * @throws LeefyAppException - Throw detailed exception.
     */
    private boolean isUserNameExist(String userName) throws LeefyAppException {

        UserLogin userLogin = userService.getAnyUser(userName);
        boolean isExists = false;
        
        if (userLogin != null) {
            isExists = true;
        }
        
        return isExists;
    }
    
    /**
     * Check whether email already exist.
     * 
     * @param email - type string
     * @return true if the email exist else false.
     * @throws LeefyAppException - Throw detailed exception.
     */
    private boolean isEmailExist(String email) throws LeefyAppException {

        UserLogin userLogin = userService.getAnyUserByEmail(email);
        boolean isExists = false;
        
        if (userLogin != null) {
            isExists = true;
        }
        
        return isExists;
    }
    
    /**
     * Check whether user identification no already exist.
     * 
     * @param identificationNo - identificationNo
     * @return true if the identification no exist else false.
     * @throws LeefyAppException - Throw detailed exception.
     */
    private boolean isUserIdentificationNoExist(int identificationNo) throws LeefyAppException {

        boolean isExists = false;
        
        if (identificationNo > 0) {
            isExists = true;
        }
        
        return isExists;
    }
    
    /**
     * Check whether the password and confirmPassword are equal.
     * 
     * @param password - type String
     * @param confirmPassword - type String
     * @return true if password and confirmPassword are equal otherwise false.
     * @throws LeefyAppException - throw this
     */
    private boolean isConfirmPassword(String password, String confirmPassword) throws LeefyAppException {

        return !password.equals(confirmPassword);
    }
    
    /**
     * Check whether the user is past user or not.
     * 
     * @param userLogin - User login object
     * @return true if password and confirmPassword are equal otherwise false.
     * @throws LeefyAppException - throw this
     */
/*    private boolean isPastUser(UserLogin userLogin) throws LeefyAppException {

        boolean isPastUser = false;
        
        if (userLogin.getUserRoleId() == com.virtusa.akura.api.enums.UserRole.ROLE_TEACHER.getUserRoleId()
                || userLogin.getUserRoleId() == 
                    com.virtusa.akura.api.enums.UserRole.ROLE_CLERICALSTAFF.getUserRoleId()) {
            isPastUser = guestSystemUserDelegate.isPastUser(userLogin.getUserIdentificationNo());
        }
        return isPastUser;
    }*/
    
    /**
     * Return userService of the Student.
     * 
     * @return the userService
     */
    public UserService getUserService() {

        return userService;
    }
    
    public GuestSystemUserDelegate getGuestSystemUserDelegate() {
        return guestSystemUserDelegate;
    }

    public void setGuestSystemUserDelegate(
            GuestSystemUserDelegate guestSystemUserDelegate) {
        this.guestSystemUserDelegate = guestSystemUserDelegate;
    }

    /**
     * Set userService.
     * 
     * @param userServiceVal the userService to set
     */
    public void setUserService(UserService userServiceVal) {

        this.userService = userServiceVal;
    }
    
/*    *//**
     * Set the service instance to inject the service.
     * 
     * @param emailServiceValue the EmailService to set
     *//*
    public void setEmailService(EmailService emailServiceValue) {

        this.emailService = emailServiceValue;
    }
    
    *//**
     * Set the service instance to inject the service.
     * 
     * @param parentSystemUserDelegateArg the parentSystemUserDelegate to set
     *//*
    public void setParentSystemUserDelegate(ParentSystemUserDelegate parentSystemUserDelegateArg) {

        this.parentSystemUserDelegate = parentSystemUserDelegateArg;
    }
*/
    
}
