package cn.example.demo.controller;

import cn.example.demo.dao.Type;
import cn.example.demo.service.TypeService;
import cn.example.demo.utils.ResponseManage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/types")
    @ApiOperation(value = "查询所有类型")
    public Map<String, Object> type(){
        return responseManage.response(typeService.type(null));
    }

    @GetMapping("/type/{typeId}")
    @ApiOperation(value = "查询指定类型")
    public Map<String, Object> search(@PathVariable(required = true) Integer typeId){
        return responseManage.response(typeService.type(typeId));
    }

    @PostMapping("/type")
    @ApiOperation(value = "新增类型")
    public Map<String, Object> add(@RequestBody Type type){
        return responseManage.response(typeService.add(type));
    }

    @PutMapping("/type/{typeId}")
    @ApiOperation(value = "修改")
    @ApiImplicitParam(name = "typeId", value = "类型Id", required = true)
    public Map<String, Object> update(@RequestBody Type type, @PathVariable(required = true) Integer typeId){
        return responseManage.response(typeService.update(type, typeId
        ));
    }
    @DeleteMapping("/type/{typeId}")
    @ApiOperation(value = "删除")
    @ApiImplicitParam(name = "typeId", value = "类型Id", required = true)
    public Map<String, Object> delete( @PathVariable(required = true) Integer typeId){
        return responseManage.response(typeService.delete(typeId));
    }
}
