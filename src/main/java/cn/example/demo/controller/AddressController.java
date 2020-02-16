package cn.example.demo.controller;

import cn.example.demo.service.AddressService;
import cn.example.demo.utils.ResponseManage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author liuwu4
 * 20:51
 * description:
 *
 */
@RestController
@Api(tags = "地址")
public class AddressController {
    private static final Logger log = LoggerFactory.getLogger(AddressController.class);
    private ResponseManage responseManage = new ResponseManage();
    @Autowired
    private AddressService addressService;
    @GetMapping("/address")
    @ApiOperation("获取地址信息")
    @ApiImplicitParam(name = "loginId", value = "用户id", required = false)
    public Map<String, Object> address(@RequestParam(required = false) Integer loginId){
        log.info("loginId"+loginId);
        return responseManage.response(addressService.address(loginId));
    }
}
