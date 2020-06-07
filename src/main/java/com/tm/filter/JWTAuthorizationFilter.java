package com.tm.filter;

import com.tm.util.ObjectUtil;
import io.jsonwebtoken.Jwts;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

/**
 * 認可フィルタークラス
 * JWTを検証し、有効期限を延長する
 */
public class JWTAuthorizationFilter extends BasicAuthenticationFilter {

    /**
     * デフォルトコンストラクタ
     * @param authenticationManager
     */
    public JWTAuthorizationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {

        // 検証済みトークンを取得
        UsernamePasswordAuthenticationToken verifiedToken = Optional.ofNullable(verifyAuthentication(req)).get();

        SecurityContextHolder.getContext().setAuthentication(verifiedToken);

        chain.doFilter(req, res);
    }

    /**
     * トークンを検証し、必要に応じてトークンを再発行します。
     * @param req HttpServletRequestインスタンス
     * @return usernamePasswordAuthenticationToken
     */
    private UsernamePasswordAuthenticationToken verifyAuthentication(HttpServletRequest req){
        String user = Jwts.parser()
                .setSigningKey("".getBytes()) //TODO: このキーは、JWTヘッダーで見つかった署名アルゴリズムの有効なキーでなければなりません
                .parseClaimsJws("")
                .getBody()
                .getSubject();

        if(ObjectUtil.isNullOrEmpty(user)) return new UsernamePasswordAuthenticationToken(user, null, new ArrayList<>());

        return null;
    }


    
}
