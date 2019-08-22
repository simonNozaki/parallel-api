package com.tm.filter;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

/**
 * 認可フィルタークラス
 */
public class JWTAuthorizationFilter extends BasicAuthenticationFilter {

    /**
     * デフォルトコンストラクタ
     * @param authenticationManager
     */
    public JWTAuthorizationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    
}
