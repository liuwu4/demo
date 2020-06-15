package cn.example.demo.controller;

import cn.example.demo.dao.Customer;
import cn.example.demo.service.CustomerService;
import cn.example.demo.utils.Encryption;
import cn.example.demo.utils.ResponseManage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author liuwu4
 * 13:49
 * description:
 */
@RestController
@Api(tags = "所有的用户信息")
public class CustomerController {
    private static final Logger LOG = LoggerFactory.getLogger(CustomerController.class);
    private final ResponseManage responseManage = new ResponseManage();
    private final Encryption encryption = new Encryption();
    private CustomerService customerService;

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/users")
    @ApiOperation(value = "查询用户信息")
    @ApiImplicitParam(name = "customerId", value = "检查用户是否存在[id]", required = false)
    public Map<String, Object> users(@RequestParam(required = false) String customerId) {
        LOG.info("查询用户" + customerId);
        return responseManage.response(customerService.customer(customerId));
    }

    @PostMapping("/user")
    @ApiOperation(value = "新增用户")
    public Map<String, Object> users(@RequestBody(required = true) Customer customer) {
        LOG.info("新增" + customer);
        if (customer.getPassword() != null) {
            customer.setPassword(encryption.generatorEncryption(customer.getPassword()));
        }
        return responseManage.response(customerService.inset(customer));
    }

    @DeleteMapping("/user/{account}")
    @ApiOperation(value = "禁用账号|删除账号")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "account", value = "用户account", required = true),
            @ApiImplicitParam(name = "status", value = "[1]删除账号,[0]禁用账号", required = true),
            @ApiImplicitParam(name = "enable", value = "status = 0时, enable = [1]启用 or [0]禁用 必须", required = false)
    })
    public Map<String, Object> users(@PathVariable String account,
                                     @RequestParam Integer status,
                                     @RequestParam(required = false) Integer enable) {
        LOG.info("禁用账号|删除账号" + account + "\t" + status + "\t" + enable);
        return responseManage.response(customerService.modify(account, status, enable));
    }

    @PutMapping("/user")
    @ApiOperation(value = "修改账号信息[id原样返回]")
    public Map<String, Object> update(@RequestBody Customer customer) {
        LOG.info("修改账号信息:" + customer);
        if (customer.getPassword() != null) {
            customer.setPassword(encryption.generatorEncryption(customer.getPassword()));
        }
        return responseManage.response(customerService.updateCustomer(customer));
    }

//    @PutMapping("/batchUpdatePassword")
//    @ApiOperation(value = "批量更新密码")
    public Map<String, Object> batchUpdatePassword(@RequestBody(required = true) List<Customer> customerList) {
        LOG.info("批量修改密码:--------" + customerList);
        for (int i = 0; i < customerList.size(); i++) {
            Customer customer = customerList.get(i);
            customer.setPhone(customerList.get(i).getPhone());
            customer.setPassword(encryption.generatorEncryption(customerList.get(i).getPassword()));
            customerList.set(i, customer);
        }
        LOG.info("转换后批量修改密码:--------" + customerList);
        return responseManage.response(customerService.batchUpdatePassword(customerList));
    }


}
