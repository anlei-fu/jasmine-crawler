/*----------------------------------------------------------------------------
 * Jasmine code generator, a tool to build web crud application,with spring-
 * boot, mybatis, mysql,swagger,spring-security.
 * Generated at 2020-7-18 1:03:45 PM
 * All rights reserved by fuanlei(email:767550758@qq.com) since 2019
 *---------------------------------------------------------------------------*/
package com.jasmine.crawl.common.validate.annotation;

import com.jasmine.crawl.common.validate.validator.UrlValidator;

import javax.validation.Constraint;
import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.METHOD})
@Constraint(validatedBy = UrlValidator.class)
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface Url {
    String message() default "Url incorrect";

    boolean required() default false;
}
