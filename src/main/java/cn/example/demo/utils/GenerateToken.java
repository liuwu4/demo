package cn.example.demo.utils;

import cn.example.demo.dao.Customer;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

/**
 * @author liuwu4
 * 13:23
 * description: 生成, 解析[token]
 */
public class GenerateToken {
    /**
     *
     * @param customer 用户信息
     * @return string
     */
    public String generate(Customer customer){
        return JWT.create().withAudience(customer.getId()).sign(Algorithm.HMAC256(customer.getAccount()));
    }
}
