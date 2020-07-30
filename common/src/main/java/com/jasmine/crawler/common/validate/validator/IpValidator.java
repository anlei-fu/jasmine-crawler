/*----------------------------------------------------------------------------
 * Jasmine code generator, a tool to build web crud application,with spring-
 * boot, mybatis, mysql,swagger,spring-security.
 * Generated at 2020-7-18 1:03:45 PM
 * All rights reserved by fuanlei(email:767550758@qq.com) since 2019
 *---------------------------------------------------------------------------*/
package com.jasmine.crawler.common.validate.validator;

import com.jasmine.crawler.common.validate.annotation.Ip;
import jdk.internal.joptsimple.internal.Strings;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

public class IpValidator implements ConstraintValidator<Ip, String> {

    private static final Pattern VALIDATOR =
            Pattern.compile(
                    "((2(5[0-5]|[0-4]\\d))|[0-1]?\\d{1,2})(\\.((2(5[0-5]|[0-4]\\d))|[0-1]?\\d{1,2})){3}");

    private boolean required;

    @Override
    public void initialize(Ip constraintAnnotation) {
        this.required = constraintAnnotation.required();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (Strings.isNullOrEmpty(value)) return !this.required;

        return VALIDATOR.matcher(value).matches();
    }
}
