package cn.example.demo.controller;

import cn.example.demo.dao.Customer;
import cn.example.demo.dao.Login;
import cn.example.demo.service.LoginService;
import cn.example.demo.utils.Encryption;
import cn.example.demo.utils.GenerateToken;
import cn.example.demo.utils.HttpUtils;
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
    LoginService loginService;

    @Autowired
    public void setLoginService(LoginService loginService) {
        this.loginService = loginService;
    }

    public Logger log = LoggerFactory.getLogger(LoginController.class);
    private final HttpUtils httpUtils = new HttpUtils();
    private final GenerateToken generateToken = new GenerateToken();
    private final Encryption encryption = new Encryption();

    @ApiOperation(value = "登录")
    @PostMapping("/login")
    public Map<String, Object> sing(@RequestBody(required = true) Login login) {
        login.setPassword(encryption.generatorEncryption(login.getPassword()));
        Customer customer = loginService.result(login);
        log.info("login:" + customer);
        String token = generateToken.generate(customer);
        log.info("token:" + token);
        return httpUtils.response(token);
    }

    @GetMapping("/user/check")
    @ApiOperation(nickname = "phone", value = "校验账号是否存在 phone")
    public Map<String, Object> check(@RequestParam(required = true) String phone) {
        return httpUtils.response(loginService.check(phone));
    }

    @ApiOperation(value = "重置密码")
    @PutMapping("/reset")
    public Map<String, Object> reset(@RequestBody Login customer) {
        if(customer.getPassword().isEmpty()){
            customer.setPassword(encryption.generatorEncryption(customer.getPassword()));
        }
        return httpUtils.response(loginService.reset(customer));
    }
}
