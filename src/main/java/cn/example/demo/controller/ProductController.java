package cn.example.demo.controller;

import cn.example.demo.dao.Product;
import cn.example.demo.service.ProductService;
import cn.example.demo.utils.HttpUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author liuwu4
 * 17:11
 * description: 产品
 */
@Api(tags = "操作产品")
@RestController
public class ProductController {
    private ProductService productService;
    private final HttpUtils httpUtils = new HttpUtils();

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = {"/products"})
    @ApiOperation(value = "查询所有产品信息")
    public Map<String, Object> products() {
        return httpUtils.response(productService.products(null));
    }

    @GetMapping(value = {"/product/{no}"})
    @ApiOperation(value = "查询no产品信息")
    @ApiImplicitParam(name = "no", value = "查询no产品的具体信息", required = true)
    public Map<String, Object> product(@PathVariable(required = true) Integer no) {
        return httpUtils.response(productService.products(no));
    }

    @PostMapping("/product")
    @ApiOperation(value = "新增产品信息")
    public Map<String, Object> product(@RequestBody(required = true) Product product) {
        System.out.println(product);
        return httpUtils.response(productService.product(product));
    }

    @DeleteMapping("/product/{no}")
    @ApiOperation(value = "删除产品")
    @ApiImplicitParam(name = "no", value = "产品编号", required = true)
    public Map<String, Object> delete(@PathVariable(required = true) Integer no) {
        return httpUtils.response(productService.delete(no));
    }

    @PutMapping("product/{no}")
    @ApiOperation(value = "更新产品信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "no", value = "产品编号", required = false),
            @ApiImplicitParam(name = "type", value = "产品类型", required = false),
            @ApiImplicitParam(name = "name", value = "产品名称", required = false),
            @ApiImplicitParam(name = "price", value = "产品价格", required = false),
            @ApiImplicitParam(name = "number", value = "产品数量", required = false),
            @ApiImplicitParam(name = "picture", value = "产品图片", required = false),
            @ApiImplicitParam(name = "productionDate", value = "产品生产日期", required = false),
            @ApiImplicitParam(name = "productionAddress", value = "产品生产地址", required = false),
            @ApiImplicitParam(name = "expirationData", value = "产品过期时间", required = false),
            @ApiImplicitParam(name = "status", value = "1: 上架, 0: 下架", required = false),
            @ApiImplicitParam(name = "description", value = "产品描述", required = false),
            @ApiImplicitParam(name = "remark", value = "备注", required = false)
    })
    @ApiImplicitParam(name = "no", value = "产品编号", required = true)
    public Map<String, Object> update(@RequestBody(required = true) Product product, @PathVariable Integer no) {
        return httpUtils.response(productService.update(product, no));
    }
}
