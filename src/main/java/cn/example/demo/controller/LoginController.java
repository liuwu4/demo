package cn.example.demo.controller;

import cn.example.demo.dao.Customer;
import cn.example.demo.dao.Login;
import cn.example.demo.service.LoginService;
import cn.example.demo.utils.GenerateToken;
import cn.example.demo.utils.ResponseManage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author liuwu4
 * 12:53
 * description:
 */
@RestController
@Api(tags = "登录, 修改密码, 找回密码")
public class LoginController {
    @Autowired
    LoginService loginService;

   private ResponseManage responseManage = new ResponseManage();
   private GenerateToken generateToken = new GenerateToken();

    @ApiOperation(value = "登录")
    @PostMapping("/login")
    public Map<String, Object> sing(@RequestBody Login login){
        Customer customer = loginService.result(login);
        String token = generateToken.generate(customer);
        return responseManage.response(token);
    }


    @ApiOperation(value = "重置密码")
    @PutMapping("/reset")
    public Map<String, Object> reset(@RequestBody Login customer){
        return responseManage.response(loginService.reset(customer));
    }
}
