/*
 * Copyright (c) 2002-2011, Mairie de Paris
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *  1. Redistributions of source code must retain the above copyright notice
 *     and the following disclaimer.
 *
 *  2. Redistributions in binary form must reproduce the above copyright notice
 *     and the following disclaimer in the documentation and/or other materials
 *     provided with the distribution.
 *
 *  3. Neither the name of 'Mairie de Paris' nor 'Lutece' nor the names of its
 *     contributors may be used to endorse or promote products derived from
 *     this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDERS OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 *
 * License 1.0
 */
package fr.paris.lutece.plugins.stock.business.attribute.utils;

import fr.paris.lutece.plugins.stock.business.attribute.AbstractAttributeNum;
import fr.paris.lutece.plugins.stock.business.attribute.AbstractAttributeNum_;

import java.math.BigDecimal;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;


/**
 * Utility class provided for dynamic attributes
 * 
 * @author abataille
 */
public final class AttributeNumUtils
{

    /**
     * Utility class
     */
    private AttributeNumUtils( )
    {

    }
    /**
     * Return predicate greaterThanOrEqualTo for dynamic attribute
     * @param builder criteria builder
     * @param join join with dyn attributes
     * @param key key of dyn attribute
     * @param value value
     * @return predicate
     */
    public static Predicate greaterThanOrEqualTo( CriteriaBuilder builder,
            Join<?, ? extends AbstractAttributeNum<?>> join, String key, BigDecimal value )
    {
        return builder.and( builder.equal( join.get( AbstractAttributeNum_.key ), key ),
                builder.greaterThanOrEqualTo( join.get( AbstractAttributeNum_.value ), value ) );
    }

    /**
     * Return predicate lessThanOrEqualTo for dynamic attribute
     * @param builder criteria builder
     * @param join join with dyn attributes
     * @param key key of dyn attribute
     * @param value value
     * @return predicate
     */
    public static Predicate lessThanOrEqualTo( CriteriaBuilder builder,
            Join<?, ? extends AbstractAttributeNum<?>> join,
            String key, BigDecimal value )
    {
        return builder.and( builder.equal( join.get( AbstractAttributeNum_.key ), key ),
                builder.lessThanOrEqualTo( join.get( AbstractAttributeNum_.value ), value ) );
    }

    /**
     * Return predicate equal for dynamic attribute
     * @param builder criteria builder
     * @param join join with dyn attributes
     * @param key key of dyn attribute
     * @param value value
     * @return predicate
     */
    public static Predicate equal( CriteriaBuilder builder, Join<?, ? extends AbstractAttributeNum<?>> join,
            String key,
            BigDecimal value )
    {
        return builder.and( builder.equal( join.get( AbstractAttributeNum_.key ), key ),
                builder.equal( join.get( AbstractAttributeNum_.value ), value ) );
    }

}