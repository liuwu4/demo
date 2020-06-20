package cn.example.demo.controller;

import cn.example.demo.dao.Address;
import cn.example.demo.service.AddressService;
import cn.example.demo.utils.HttpUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author liuwu4
 * 20:51
 * description:
 */
@RestController
@Api(tags = "地址")
public class AddressController {

    private static final Logger log = LoggerFactory.getLogger(AddressController.class);
    private final HttpUtils httpUtils = new HttpUtils();
    private AddressService addressService;

    @Autowired
    public void setAddressService(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("/address")
    @ApiOperation("获取地址信息")
    @ApiImplicitParam(name = "loginId", value = "用户id", required = false)
    public Map<String, Object> address(@RequestParam(required = false) Integer loginId) {
        log.info("loginId" + loginId);
        return httpUtils.response(addressService.address(loginId));
    }

    @PostMapping("/address")
    @ApiOperation(value = "新增地址")
    public Map<String, Object> insert(@RequestBody(required = true) Address address) {
        return httpUtils.response(addressService.insert(address));
    }

    @PutMapping("/address")
    @ApiOperation(value = "修改地址")
    public Map<String, Object> update(@RequestBody(required = true) Address address) {
        return httpUtils.response(addressService.update(address));
    }

    @DeleteMapping("/address/{loginId}")
    @ApiOperation(value = "删除用户地址")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "loginId", value = "用户id", required = true),
            @ApiImplicitParam(name = "addressId", value = "地址id", required = true)
    })
    public Map<String, Object> delete(@PathVariable(required = true) Integer loginId, @RequestParam(required = true) Integer addressId) {
        return httpUtils.response(addressService.delete(loginId, addressId));
    }
}
