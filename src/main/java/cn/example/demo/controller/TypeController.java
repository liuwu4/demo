package cn.example.demo.controller;

import cn.example.demo.dao.Type;
import cn.example.demo.service.TypeService;
import cn.example.demo.utils.Excel;
import cn.example.demo.utils.ResponseManage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author liuwu4
 * 09:50
 * description:
 */
@RestController
@Api(tags = "操作类型")
public class TypeController {

    @Autowired
    TypeService typeService;
    ResponseManage responseManage = new ResponseManage();
    private static final Logger log = LoggerFactory.getLogger(TypeController.class);

    @GetMapping("/types")
    @ApiOperation(value = "查询所有类型")
    public Map<String, Object> type() {
        return responseManage.response(typeService.type(null));
    }

    @GetMapping("/type/{typeId}")
    @ApiOperation(value = "查询指定类型")
    public Map<String, Object> search(@PathVariable(required = true) Integer typeId) {
        return responseManage.response(typeService.type(typeId));
    }

    @PostMapping("/type")
    @ApiOperation(value = "新增类型")
    public Map<String, Object> add(@RequestBody Type type) {
        return responseManage.response(typeService.add(type));
    }

    @PostMapping("/import")
    @ApiOperation(value = "批量导入")
    public Map<String, Object> importExcel(@RequestBody MultipartFile file) {
        log.info("开始批量导入");
        List<ArrayList<Type>> list = new Excel().readExcel(file);
        log.info("读取批量导入结束:" + list);
        int result = 0;
        for (ArrayList<Type> types : list) {
            log.info(types.toString());
            result = typeService.excel(types);
            log.info("导入结果:" + result);
        }
        return responseManage.response(result);
    }

    @PutMapping("/type/{typeId}")
    @ApiOperation(value = "修改")
    @ApiImplicitParam(name = "typeId", value = "类型Id", required = true)
    public Map<String, Object> update(@RequestBody Type type, @PathVariable(required = true) Integer typeId) {
        return responseManage.response(typeService.update(type, typeId));
    }

    @DeleteMapping("/type/{typeId}")
    @ApiOperation(value = "删除")
    @ApiImplicitParam(name = "typeId", value = "类型Id", required = true)
    public Map<String, Object> delete(@PathVariable(required = true) Integer typeId) {
        return responseManage.response(typeService.delete(typeId));
    }


}
