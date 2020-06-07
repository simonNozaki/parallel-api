package com.tm.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

/**
 * 認証ユーティリティ
 */
public class AuthenticationUtil {

    /**
     * トークンを発行します
     * @param mail
     * @return
     */
    public static String issueToken( String mail){
        return Jwts.builder()
                .setSubject(mail)
                // 有効期限30分（ミリ秒で指定）
                .setExpiration(new Date(System.currentTimeMillis() + 30 * 60 * 1000))
                .signWith(SignatureAlgorithm.HS512, "".getBytes()) // TODO 適切なハッシュ元ネタを設定する
                .compact();
    }
}
