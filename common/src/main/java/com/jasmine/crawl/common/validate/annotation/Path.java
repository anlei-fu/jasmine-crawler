/*----------------------------------------------------------------------------
 * Jasmine code generator, a tool to build web crud application,with spring-
 * boot, mybatis, mysql,swagger,spring-security.
 * Generated at 2020-7-18 1:03:45 PM
 * All rights reserved by fuanlei(email:767550758@qq.com) since 2019
 *---------------------------------------------------------------------------*/
package com.jasmine.crawl.common.validate.annotation;

import com.jasmine.crawl.common.validate.validator.PathValidator;

import javax.validation.Constraint;
import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.METHOD})
@Constraint(validatedBy = PathValidator.class)
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface Path {
    String message() default "Path incorrect";

    boolean required() default false;
}
