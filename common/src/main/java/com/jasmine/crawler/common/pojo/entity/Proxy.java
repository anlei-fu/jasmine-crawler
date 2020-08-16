/*----------------------------------------------------------------------------
 * Jasmine code generator, a tool to build web crud application,with spring-
 * boot, mybatis, mysql,swagger,spring-security.
 * Generated at 2020-7-25 2:58:14 PM
 * All rights reserved by fuanlei(email:767550758@qq.com) since 2019
 *---------------------------------------------------------------------------*/
package com.jasmine.crawler.common.pojo.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Proxy extends EnableStatusFeature {

    /**
     * Unique id
     */
    private Integer id;

    /**
     * The ip of the proxy
     */
    private String ip;

    /**
     * The port of proxy
     */
    private Integer port;

    /**
     * The protocol of proxy see {@enum ProxyProtocol}
     */
    private Integer proxyProtocol;

    /**
     * The proxy type of proxy
     */
    private Integer proxyType;

    /**
     * The account of proxy
     */
    private String account;

    /**
     * The password of account
     */
    private String password;

    /**
     * The count that how many task can use the proxy conteousely
     */
    private Integer maxUseCount;

    /**
     * The count of task using the proxy
     */
    private Integer currentUseCount;

    /**
     * Max block count to determine that proxy is invalid
     */
    private Integer blockMaxCount;

    /**
     * Current blocked count
     */
    private Integer blockCurrentCount;

    /**
     * Proxy not available within in timeout time
     */
    private Date blockTimeoutTime;

    /**
     * Create time
     */
    private Date createTime;
}
