package com.cosdoor;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.json.JSONObject;

import java.util.Date;

/**
 * @author: qxd
 * @date: 2024/4/8
 * @description:
 */
public class Main {
    // 用于签名的密钥
    private static final String SECRET_KEY = "yoursecretkeyyoursecretkeyyoursecretkeyyoursecretkey";  // key 必须大于 256 bits

    public static void main(String[] args) {
        String token = generateJwtToken();
        // eyJhbGciOiJIUzI1NiJ9
        // .eyJzdWIiOiJleGFtcGxldXNlciIsInVzZXJpZCI6IjEyMzQ1NiIsImV4cCI6MTcxMjY2NDQ3NH0
        // .g_ytEkyRAOJeTSb-Ecl908Y5jUxcBZ369gErHHZiA-k
        System.out.println("加密后：");
        System.out.println(token);

        System.out.println("解析后：");
        try {
            Jws<Claims> claimsJws = Jwts.parser()
                    .setSigningKey(SECRET_KEY)
                    .parseClaimsJws(token);

            Claims body = claimsJws.getBody();

            // 将头部、载荷和签名解码为JSON对象
            JSONObject headerJson = new JSONObject(claimsJws.getHeader());
            JSONObject payloadJson = new JSONObject(body);
            String signature = claimsJws.getSignature();

            // 打印头部、载荷和签名
            System.out.println("Header: " + headerJson.toString());
            System.out.println("Payload: " + payloadJson.toString());
            System.out.println("Signature: " + signature);
        } catch (Exception e) {
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
