package com.tm.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tm.config.AppLogger;
import com.tm.consts.log.LogCode;
import com.tm.dto.bean.user.UserAuthenticationRequestDto;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * JWT認証フィルタークラス
 */
public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private AuthenticationManager authenticationManager;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    /**
     * デフォルトコンストラクタ
     * @param authenticationManager
     * @param bCryptPasswordEncoder
     */
    public JWTAuthenticationFilter(AuthenticationManager authenticationManager, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.authenticationManager = authenticationManager;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;

        // ログイン用のpath
        setRequiresAuthenticationRequestMatcher(new AntPathRequestMatcher("/api/v1/user/signin", "POST"));

        // ログイン用のID/PWのパラメータ名
        setUsernameParameter("email");
        setPasswordParameter("password");
    }

    // 認証の処理
    @Override
    public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res) throws AuthenticationException {
        try{
            UserAuthenticationRequestDto request = new ObjectMapper().readValue(req.getInputStream(), UserAuthenticationRequestDto.class);
            return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    request.getEmail(),
                    request.getPassword(),
                    new ArrayList()
            ));
        }catch (Exception e) {
            AppLogger.error(LogCode.TMFWCM90000, e, this.getClass().getCanonicalName(), "attemptAuthentication");
        }finally {
            return null;
        }
    }

    // 認証に成功した場合の処理
    @Override
    protected void successfulAuthentication(HttpServletRequest req, HttpServletResponse res, FilterChain chain, Authentication auth) throws IOException, ServletException {
        // loginIdからtokenを設定してヘッダにセットする
        // String token = TokenCreater.createToken(((LoginUserDemo) auth.getPrincipal()).getUsername());
        // res.addHeader(CommonConstant.AUTHORIZATION_HEADER_NAME, CommonConstant.JWT_PREFIX + token);
    }


}
