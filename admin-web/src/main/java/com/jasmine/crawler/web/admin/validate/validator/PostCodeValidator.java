/*----------------------------------------------------------------------------
 * Jasmine code generator, a tool to build web crud application,with spring-
 * boot, mybatis, mysql,swagger,spring-security.
 * Generated at 2020-7-31 5:06:21 PM
 * All rights reserved by fuanlei(email:767550758@qq.com) since 2019
 *---------------------------------------------------------------------------*/
package com.jasmine.crawler.web.admin.validate.validator;

import com.jasmine.crawler.web.admin.validate.annotation.PostCode;
import java.util.regex.Pattern;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import jdk.internal.joptsimple.internal.Strings;

public class PostCodeValidator implements ConstraintValidator<PostCode, String> {

    private static final Pattern VALIDATOR = Pattern.compile("");

    private boolean required;

    @Override
    public void initialize(PostCode constraintAnnotation) {
        this.required = constraintAnnotation.required();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (Strings.isNullOrEmpty(value)) return !this.required;

        return VALIDATOR.matcher(value).matches();
    }
}
