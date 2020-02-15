package cn.example.demo.controller;

import cn.example.demo.dao.Customer;
import cn.example.demo.service.CustomerService;
import cn.example.demo.utils.ResponseManage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author liuwu4
 * 13:49
 * description:
 */
@RestController
@RequestMapping("/customer")
@Api(tags = "所有的用户信息")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    private ResponseManage responseManage = new ResponseManage();

    @GetMapping("/users")
    @ApiOperation(value = "查询用户信息")
    @ApiImplicitParam(name = "customerId", value = "检查用户是否存在[id]", required = false)
    public Map<String, Object> users(@RequestParam(required = false) String customerId){
        System.out.println("查询"+ customerId);
        return responseManage.response(customerService.customer(customerId));
    }

    @PostMapping("/users")
    @ApiOperation(value = "新增用户")
    public Map<String, Object> users(@RequestBody(required = true) Customer customer){
        return responseManage.response(customerService.inset(customer));
    }

    @DeleteMapping("/users/{account}")
    @ApiOperation(value = "禁用账号|删除账号")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "account", value = "用户account", required = true),
            @ApiImplicitParam(name = "status", value = "[1]删除账号,[0]禁用账号", required = true),
            @ApiImplicitParam(name = "enable", value = "status = 0时, enable = [1]启用 or [0]禁用 必须", required = false)
    })
    public Map<String, Object> users(@PathVariable String account,
                                     @RequestParam int status,
                                     @RequestParam int enable){
        return responseManage.response(customerService.modify(account, status, enable));
    }


}
