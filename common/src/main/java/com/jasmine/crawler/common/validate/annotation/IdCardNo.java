/*----------------------------------------------------------------------------
 * Jasmine code generator, a tool to build web crud application,with spring-
 * boot, mybatis, mysql,swagger,spring-security.
 * Generated at 2020-7-18 1:03:45 PM
 * All rights reserved by fuanlei(email:767550758@qq.com) since 2019
 *---------------------------------------------------------------------------*/
package com.jasmine.crawler.common.validate.annotation;

import com.jasmine.crawler.job.validate.validator.IdCardNoValidator;

import javax.validation.Constraint;
import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.METHOD})
@Constraint(validatedBy = IdCardNoValidator.class)
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface IdCardNo {
    String message() default "IdCardNo incorrect";

    boolean required() default false;
}
