package com.xxl.job.admin.service.impl;

import com.xxl.job.admin.core.model.XxlJobUser;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;

/**
 * R3 Support Service
 *
 * @author julian
 * @version 3.1.2
 */
@Service
public class R3SupportService {

    public static Map<String, Object> convertUserInfo(XxlJobUser user) {
        if (null == user) {
            return  null;
        }
        return new HashMap<>() {{
            put("username", user.getUsername());
            put("role", user.getRole());
        }};
    }
}
