package com.cosdoor;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWSVerifier;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jose.shaded.json.parser.ParseException;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

/**
 * @author: qxd
 * @date: 2024/4/8
 * @description:
 */

public class JwtParser {
    private static final String SECRET_KEY = "yoursecretkeyyoursecretkeyyoursecretkeyyoursecretkey";

    public static void main(String[] args) {
        String token = generateJwtToken();

        try {
            // 解析JWT
            SignedJWT signedJWT = SignedJWT.parse(token);

            // 验证JWT签名
            JWSVerifier verifier = new MACVerifier(SECRET_KEY);
            if (!signedJWT.verify(verifier)) {
                System.out.println("JWT signature verification failed.");
                return;
            }

            // 获取JWT的载荷
            JWTClaimsSet claimsSet = signedJWT.getJWTClaimsSet();

            // 获取过期时间
            Date expiration = claimsSet.getExpirationTime();

            // 检查过期时间是否在当前时间之前
            if (expiration.before(new Date())) {
                System.out.println("JWT has expired.");
            } else {
                System.out.println("JWT is still valid.");
            }
        } catch (JOSEException | java.text.ParseException e) {
            System.out.println("JWT parsing failed: " + e.getMessage());
        }
    }

    private static String generateJwtToken() {
        // 载荷（Payload），包含要在 JWT 中传输的信息
        return Jwts.builder()
                .setSubject("exampleuser")
                .claim("userid", "123456")
                .setExpiration(new Date(System.currentTimeMillis() + 86400000)) // 设置过期时间为当前时间后的一天
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }
}
