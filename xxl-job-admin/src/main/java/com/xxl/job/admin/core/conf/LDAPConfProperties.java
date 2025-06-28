package com.xxl.job.admin.core.conf;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * LDAP Config Properties.
 *
 * @author julian
 * @version 1.0.0
 */
@ConfigurationProperties(prefix = "ldap")
public class LDAPConfProperties {
    /**
     * 是否启用LDAP认证
     * true 表示启用，false 表示禁用
     */
    private Boolean enabled;
    /**
     * LDAP服务器地址
     * 例如：ldap://192.168.31.139:389
     */
    private String url;
    /**
     * 管理员用户名
     * 例如：admin
     * 一般用于记录管理员登录名
     */
    private String adminUsername;
    /**
     * 管理员DN（Distinguished Name）
     * 例如：cn=admin,dc=mycompany,dc=com
     * 用于LDAP连接时的管理员身份认证
     */
    private String adminDn;
    /**
     * 用户DN模板（Pattern）
     * 例如：uid=%s,ou=users,dc=mycompany,dc=com
     * 用于根据用户名动态拼接用户的完整DN
     */
    private String userDnPattern;

    public LDAPConfProperties() {
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAdminUsername() {
        return adminUsername;
    }

    public void setAdminUsername(String adminUsername) {
        this.adminUsername = adminUsername;
    }

    public String getAdminDn() {
        return adminDn;
    }

    public void setAdminDn(String adminDn) {
        this.adminDn = adminDn;
    }

    public String getUserDnPattern() {
        return userDnPattern;
    }

    public void setUserDnPattern(String userDnPattern) {
        this.userDnPattern = userDnPattern;
    }
}
