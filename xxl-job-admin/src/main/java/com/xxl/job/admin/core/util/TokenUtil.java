package com.xxl.job.admin.core.util;

import com.xxl.job.admin.core.model.XxlJobUser;
import java.math.BigInteger;

/**
 * TokenUtil - 生成 token.
 *
 * @author julian
 * @version 1.0.0
 * @date 2025/6/28 13:09
 */
public class TokenUtil {

    /**
     * 生成 token
     */
    public static String generateToken(XxlJobUser xxlJobUser) {
        String tokenJson = JacksonUtil.writeValueAsString(xxlJobUser);
        assert tokenJson != null;
        return new BigInteger(tokenJson.getBytes()).toString(16);
    }
}

