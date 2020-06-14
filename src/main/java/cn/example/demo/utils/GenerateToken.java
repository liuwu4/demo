package cn.example.demo.utils;

import cn.example.demo.constant.FixedValue;
import cn.example.demo.dao.Customer;
import com.alibaba.druid.util.StringUtils;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liuwu4
 * 13:23
 * description: 生成, 解析[token]
 */
public class GenerateToken {
    /**
     * 生成用户对应的token
     * @param customer 用户信息
     * @return string
     */
    public String generate(Customer customer) {
        Map<String, Object> tokenHeader = new HashMap<>(16);
        tokenHeader.put("alg", FixedValue.TOKEN_ALG_SHA256);
        tokenHeader.put("type", FixedValue.TOKEN_TYPE);
        String token = JWT.create()
                .withHeader(tokenHeader)
                .withClaim("iss", "Service")
                .withClaim("aud", "APP")
                .withClaim("userToken", customer.getPhone())
                .sign(Algorithm.HMAC256(FixedValue.TOKEN_PRIVATE_KEY));
        return token;
    }

    /**
     * 解析token
     * @param token http中携带的token
     * @return 用户手机号
     */
    public String parseToken(String token) {
        DecodedJWT decodedJWT = null;
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(FixedValue.TOKEN_PRIVATE_KEY)).build();
        decodedJWT = verifier.verify(token);
        Map<String, Claim> claimMap = decodedJWT.getClaims();
        Claim claim = claimMap.get("userToken");
        if( claim.isNull() || StringUtils.isEmpty(claim.asString())){
            throw new NullPointerException("token---------------解析出错");
        }
        return claim.asString();
    }

}
