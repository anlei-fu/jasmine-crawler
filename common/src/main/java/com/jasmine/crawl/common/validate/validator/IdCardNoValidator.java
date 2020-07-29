/*----------------------------------------------------------------------------
 * Jasmine code generator, a tool to build web crud application,with spring-
 * boot, mybatis, mysql,swagger,spring-security.
 * Generated at 2020-7-18 1:03:45 PM
 * All rights reserved by fuanlei(email:767550758@qq.com) since 2019
 *---------------------------------------------------------------------------*/
package com.jasmine.crawler.job.validate.validator;

import com.jasmine.crawl.common.validate.annotation.IdCardNo;
import jdk.internal.joptsimple.internal.Strings;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

/**
 * @Copyright (C) 四川千行你我科技有限公司 @Author: fuanlei @Date: @Description:
 */
public class IdCardNoValidator implements ConstraintValidator<IdCardNo, String> {
    private static final Pattern VALIDATOR =
            Pattern.compile("^\\d{8,18}|[0-9x]{8,18}|[0-9X]{8,18}?$");

    private boolean required;

    @Override
    public void initialize(IdCardNo constraintAnnotation) {
        this.required = constraintAnnotation.required();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (Strings.isNullOrEmpty(value)) return !this.required;

        return VALIDATOR.matcher(value).matches();
    }
}
