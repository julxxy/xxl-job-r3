package com.xxl.job.admin.service.impl;

import com.xxl.job.admin.core.conf.LDAPConfProperties;
import com.xxl.job.admin.core.model.XxlJobUser;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Objects;
import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.InitialDirContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;

/**
 * R3 Support Service
 *
 * @author julian
 * @version 3.1.2
 */
@Service
@EnableConfigurationProperties(LDAPConfProperties.class)
public class R3SupportService {
    private final Logger log = LoggerFactory.getLogger(R3SupportService.class);
    @Autowired
    private LDAPConfProperties ldapConfProperties;

    /**
     * 转换用户信息为 Map
     */
    public static Map<String, Object> convertUserInfo(XxlJobUser user) {
        Map<String, Object> map = new HashMap<>();
        if (user == null) {
            return map;
        }
        map.put("username", user.getUsername());
        map.put("role", user.getRole());
        return map;
    }

    /**
     * LDAP 用户名密码认证
     *
     * @param username 登录用户名
     * @param password 登录密码
     * @return 是否认证成功
     */
    public boolean authenticateByLDAP(String username, String password) {
        if (Objects.equals(ldapConfProperties.getEnabled(), false)) {
            return false;
        }
        Hashtable<String, String> env = new Hashtable<>();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL, ldapConfProperties.getUrl());
        env.put(Context.SECURITY_AUTHENTICATION, "simple");

        String principal;
        if (ldapConfProperties.getAdminUsername().equals(username)) {
            principal = ldapConfProperties.getAdminDn(); // 管理员账号
        } else {
            principal = String.format(ldapConfProperties.getUserDnPattern(), username); // 普通用户
        }

        env.put(Context.SECURITY_PRINCIPAL, principal);
        env.put(Context.SECURITY_CREDENTIALS, password);

        try {
            new InitialDirContext(env);
            return true;
        } catch (NamingException e) {
            log.error("LDAP 用户名密码认证异常: {}", e.getMessage(), e);
            return false;
        }
    }

}

