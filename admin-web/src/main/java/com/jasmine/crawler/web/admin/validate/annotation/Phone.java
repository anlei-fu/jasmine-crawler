/*----------------------------------------------------------------------------
 * Jasmine code generator, a tool to build web crud application,with spring-
 * boot, mybatis, mysql,swagger,spring-security.
 * Generated at 2020-7-31 5:06:21 PM
 * All rights reserved by fuanlei(email:767550758@qq.com) since 2019
 *---------------------------------------------------------------------------*/
package com.jasmine.crawler.web.admin.validate.annotation;

import com.jasmine.crawler.web.admin.validate.validator.PhoneValidator;
import java.lang.annotation.*;
import javax.validation.Constraint;

@Target({ElementType.FIELD, ElementType.METHOD})
@Constraint(validatedBy = PhoneValidator.class)
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface Phone {
    String message() default "Phone incorrect";

    boolean required() default false;
}
