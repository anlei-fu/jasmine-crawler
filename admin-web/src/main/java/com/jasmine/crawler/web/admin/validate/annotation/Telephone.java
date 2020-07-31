/*----------------------------------------------------------------------------
 * Jasmine code generator, a tool to build web crud application,with spring-
 * boot, mybatis, mysql,swagger,spring-security.
 * Generated at 2020-7-31 5:06:21 PM
 * All rights reserved by fuanlei(email:767550758@qq.com) since 2019
 *---------------------------------------------------------------------------*/
package com.jasmine.crawler.web.admin.validate.annotation;

import com.jasmine.crawler.web.admin.validate.validator.TelephoneValidator;
import java.lang.annotation.*;
import javax.validation.Constraint;

@Target({ElementType.FIELD, ElementType.METHOD})
@Constraint(validatedBy = TelephoneValidator.class)
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface Telephone {
    String message() default "Telephone incorrect";

    boolean required() default false;
}
