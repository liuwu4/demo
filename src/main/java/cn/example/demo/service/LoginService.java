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

    public Customer result (Login login){
        return loginMapper.result(login);
    }
    public int reset(Login login){
        return loginMapper.reset(login);
    }
}
