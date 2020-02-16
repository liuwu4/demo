package cn.example.demo.service;

import cn.example.demo.dao.Customer;
import cn.example.demo.dao.Login;
import cn.example.demo.mapper.LoginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author liuwu4
 * 12:59
 * description:
 */
@Service
public class LoginService {
    @Autowired
    private LoginMapper loginMapper;

    /**
     * 登录
     * @param login
     * @return
     */
    public Customer result (Login login){
        return loginMapper.result(login);
    }

    /**
     * 重置密码
     * @param login
     * @return
     */
    public int reset(Login login){
        return loginMapper.reset(login);
    }

    /**
     * 校验账号是否存在
     * @param account
     * @return
     */
    public Customer check(String account){
        return loginMapper.check(account);
    }
}
