/*----------------------------------------------------------------------------
 * Jasmine code generator, a tool to build web crud application,with spring-
 * boot, mybatis, mysql,swagger,spring-security.
 * Generated at 2020-7-31 5:06:21 PM
 * All rights reserved by fuanlei(email:767550758@qq.com) since 2019
 *---------------------------------------------------------------------------*/
package com.jasmine.crawler.web.admin.validate.annotation;

import com.jasmine.crawler.web.admin.validate.validator.PostCodeValidator;
import java.lang.annotation.*;
import javax.validation.Constraint;

@Target({ElementType.FIELD, ElementType.METHOD})
@Constraint(validatedBy = PostCodeValidator.class)
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface PostCode {
    String message() default "PostCode incorrect";

    boolean required() default false;
}
