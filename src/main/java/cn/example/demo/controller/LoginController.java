package cn.example.demo.controller;

import cn.example.demo.dao.Customer;
import cn.example.demo.dao.Login;
import cn.example.demo.service.LoginService;
import cn.example.demo.utils.GenerateToken;
import cn.example.demo.utils.ResponseManage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public Logger log = LoggerFactory.getLogger(LoginController.class);
    private ResponseManage responseManage = new ResponseManage();
    private GenerateToken generateToken = new GenerateToken();

    @ApiOperation(value = "登录")
    @PostMapping("/login")
    public Map<String, Object> sing(@RequestBody(required = true) Login login){
        Customer customer = loginService.result(login);
//        log.info("login:"+ login);
//        String token = generateToken.generate(customer);
//        log.info("token:"+ token);
        return responseManage.response(customer);
    }

    @GetMapping("/user/check")
    @ApiOperation(nickname = "phone", value = "校验账号是否存在 phone")
    public Map<String, Object> check(@RequestParam(required = true) String phone){
        return responseManage.response(loginService.check(phone));
    }


    @ApiOperation(value = "重置密码")
    @PutMapping("/reset")
    public Map<String, Object> reset(@RequestBody Login customer){
        return responseManage.response(loginService.reset(customer));
    }
}
