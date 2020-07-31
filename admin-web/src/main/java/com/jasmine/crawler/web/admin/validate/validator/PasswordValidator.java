/*----------------------------------------------------------------------------
 * Jasmine code generator, a tool to build web crud application,with spring-
 * boot, mybatis, mysql,swagger,spring-security.
 * Generated at 2020-7-31 5:06:21 PM
 * All rights reserved by fuanlei(email:767550758@qq.com) since 2019
 *---------------------------------------------------------------------------*/
package com.jasmine.crawler.web.admin.validate.validator;

import com.jasmine.crawler.web.admin.validate.annotation.Password;
import java.util.regex.Pattern;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import jdk.internal.joptsimple.internal.Strings;

public class PasswordValidator implements ConstraintValidator<Password, String> {

    private static final Pattern VALIDATOR = Pattern.compile("");

    private static final Pattern NUMBER_VALIDATOR = Pattern.compile("");

    private static final Pattern ALPHA_VALIDATOR = Pattern.compile("");

    private static final Pattern SYMBOL_VALIDATOR = Pattern.compile("");

    private static final Pattern UPPER_VALIDATOR = Pattern.compile("");

    private static final Pattern LOWER_VALIDATOR = Pattern.compile("");

    private boolean required;

    private int level;

    @Override
    public void initialize(Password constraintAnnotation) {
        this.required = constraintAnnotation.required();
        this.level = constraintAnnotation.level();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (Strings.isNullOrEmpty(value)) return !this.required;

        if (!VALIDATOR.matcher(value).matches()) return false;

        // 2 number alpha
        // 3 number alpha symbol
        // 4 number symbol upper and lower alpha
        if (this.level == 2) {
            if (!(NUMBER_VALIDATOR.matcher(value).matches()
                    && ALPHA_VALIDATOR.matcher(value).matches())) {
                context.buildConstraintViolationWithTemplate("");
                return false;
            }
        } else if (this.level == 3) {
            if (!(NUMBER_VALIDATOR.matcher(value).matches()
                    && ALPHA_VALIDATOR.matcher(value).matches()
                    && SYMBOL_VALIDATOR.matcher(value).matches())) {
                context.buildConstraintViolationWithTemplate("");
                return false;
            }
        } else if (this.level == 4) {
            if (!(NUMBER_VALIDATOR.matcher(value).matches()
                    && SYMBOL_VALIDATOR.matcher(value).matches()
                    && UPPER_VALIDATOR.matcher(value).matches()
                    && LOWER_VALIDATOR.matcher(value).matches())) {
                context.buildConstraintViolationWithTemplate("");
                return false;
            }
        }

        return true;
    }
}
