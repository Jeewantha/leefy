
package com.jeesoft.web.delegate.user;

import com.jeesoft.api.dto.Guest;
import com.jeesoft.common.exception.LeefyAppException;
import com.jeesoft.web.delegate.SystemUserDelegate;
import com.jeesoft.web.service.GuestUserServices;

/**
 * Delegates the method to guest user service.
 * 
 * @author Jeewanth Samaraweera
 */
public class GuestSystemUserDelegate implements SystemUserDelegate {
    
    /**
     * Represents an instance of GuestUserServices.
     */
    private GuestUserServices guestUserServices;
    
    public GuestUserServices getGuestUserServices() {
        return guestUserServices;
    }

    public void setGuestUserServices(GuestUserServices guestUserServices) {
        this.guestUserServices = guestUserServices;
    }

    /** {@inheritDoc} */
    public boolean isExistRegistrationNo(String registrationNo) throws LeefyAppException {

        return guestUserServices.isValidRegistrationNo(registrationNo);
    }
    
    /** {@inheritDoc} */
    public int getKeyByIdentificationNo(final String identification) throws LeefyAppException {

        return guestUserServices.getKeyByIdentificationNo(identification);
    }
    
    /** {@inheritDoc} */
    public String getIdentificationNoByKey(final int guestId) throws LeefyAppException {

        Guest guest = guestUserServices.findGuest(guestId);
        return guest != null ? guest.getRegistrationNo() : "";
    }
    
    /** {@inheritDoc} */
    public boolean isPastUser(String userIdentificationNo) throws LeefyAppException {

        return guestUserServices.hasDepartureDate(userIdentificationNo);
    }
    
}
