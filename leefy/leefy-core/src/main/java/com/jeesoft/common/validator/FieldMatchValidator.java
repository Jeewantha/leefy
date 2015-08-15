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
package com.jeesoft.common.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.beanutils.PropertyUtils;

import com.jeesoft.common.annotation.FieldMatch;

/**
 * The Class FieldMatchValidator.
 * 
 * @author Jeewantha Samaraweera
 * @since alpha
 */
public class FieldMatchValidator implements ConstraintValidator<FieldMatch, Object>
{
    
    /** The first field name. */
    private String firstFieldName;
    
    /** The second field name. */
    private String secondFieldName;
    
    /** The error message. */
    private String errorMessage;
    
    /* (non-Javadoc)
     * @see javax.validation.ConstraintValidator#initialize(java.lang.annotation.Annotation)
     */
    public void initialize(final FieldMatch constraintAnnotation)
    {
        firstFieldName = constraintAnnotation.first();
        secondFieldName = constraintAnnotation.second();
        errorMessage = constraintAnnotation.message();
    }

    /* (non-Javadoc)
     * @see javax.validation.ConstraintValidator#isValid(java.lang.Object, javax.validation.ConstraintValidatorContext)
     */
    public boolean isValid(final Object value, final ConstraintValidatorContext context)
    {
        boolean isFirstEqualSecond = false;
        
        try
        {
            final Object firstObj = PropertyUtils.getProperty(value, firstFieldName);
            final Object secondObj = PropertyUtils.getProperty(value, secondFieldName);

            isFirstEqualSecond = firstObj == null && secondObj == null || firstObj != null && firstObj.equals(secondObj);
        }
        catch (final Exception exception)
        {
            // TODO set the logger to log this error.
            System.out.println("Error occoured in com.jeesoft.common.validator.FieldMatchValidator :"+exception);
        }
        
        if(!isFirstEqualSecond){
            context.buildConstraintViolationWithTemplate(errorMessage).addNode(secondFieldName).addConstraintViolation();
        }
        
        return isFirstEqualSecond;
    }
}