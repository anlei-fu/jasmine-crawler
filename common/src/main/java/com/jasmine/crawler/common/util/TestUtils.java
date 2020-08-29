/*----------------------------------------------------------------------------
 * Jasmine code generator, a tool to build web crud application,with spring-
 * boot, mybatis, mysql,swagger,spring-security.
 * Generated at 2020-7-31 5:06:21 PM
 * All rights reserved by fuanlei(email:767550758@qq.com) since 2019
 *---------------------------------------------------------------------------*/
package com.jasmine.crawler.common.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.util.Objects;

/**
 * @Copyright (C) 四川千行你我科技有限公司 @Author: fuanlei @Date: @Description:
 */
public class TestUtils {

    public static void printQuery(Object dto, Object result) {
        print(dto, "dto");
        print(result, "result");
    }

    public static void print(Object obj) {
        print(obj, null);
    }

    public static void print(Object obj, String name) {
        if (!Objects.isNull((name)))
            System.out.println(String.format("%s:", name));

        String json =
                JSON.toJSONString(
                        obj,
                        SerializerFeature.PrettyFormat,
                        SerializerFeature.WriteNullStringAsEmpty);
        System.out.println(json);
    }

    public static void checkUpdate(Object dto, Object updated) {
    }
}
