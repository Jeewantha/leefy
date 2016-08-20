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

package com.jeesoft.api.dto;

import java.io.Serializable;
import java.sql.Blob;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;

/**
 * The Class Country.
 * 
 * @author Jeewantha Samaraweera
 */
@XmlRootElement(name = "country")
@JsonPropertyOrder({ "countryId", "name", "isoCode", "capitalCity" })
public class Country extends BaseDomain implements Serializable {
    
    /** Holds serial version id. */
    private static final long serialVersionUID = 1L;
    
    /** Holds the id of the country. */
    private int countryId;
    
    /** Holds the country name. */
    private String name;
    
    /** Holds the country ISO code. */
    private String isoCode;
    
    /** Holds the capital city of the country. */
    private String capitalCity;
    
    /** Holds the country flag image. */
    private Blob countryFlag;
    
    /**
     * Default constructor.
     */
    public Country() {

    }

    @JsonProperty("countryId")
    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("isoCode")
    public String getIsoCode() {
        return isoCode;
    }

    public void setIsoCode(String isoCode) {
        this.isoCode = isoCode;
    }

    @JsonProperty("capitalCity")
    public String getCapitalCity() {
        return capitalCity;
    }

    public void setCapitalCity(String capitalCity) {
        this.capitalCity = capitalCity;
    }

    public Blob getCountryFlag() {
        return countryFlag;
    }

    public void setCountryFlag(Blob countryFlag) {
        this.countryFlag = countryFlag;
    }
}