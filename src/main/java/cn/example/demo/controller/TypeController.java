package cn.example.demo.controller;

import cn.example.demo.dao.Type;
import cn.example.demo.exception.StatusEnum;
import cn.example.demo.service.TypeService;
import cn.example.demo.utils.Excel;
import cn.example.demo.utils.ResponseManage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.*;

/**
 * @author liuwu4
 * 09:50
 * description:
 */
@RestController
@Api(tags = "操作类型")
public class TypeController {

    private static final Logger log = LoggerFactory.getLogger(TypeController.class);
    TypeService typeService;
    ResponseManage responseManage = new ResponseManage();

    @Autowired
    public void setTypeService(TypeService typeService) {
        this.typeService = typeService;
    }

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

    @PostMapping("/type/import")
    @ApiOperation(value = "批量导入")
    public Map<String, Object> importExcel(@RequestBody MultipartFile file) {
        Map<String, Object> map = new HashMap<>(16);
        log.info("开始批量导入");
        List<List<Type>> readExcel = new Excel().readExcel(file);
        log.info("读取批量导入结束:" + readExcel);
        int result = 0;
        Iterator<Type> iterator = readExcel.get(0).iterator();
        List<Type> types = new ArrayList<>();
        while (iterator.hasNext()) {
            Type type = iterator.next();
            if ((type.getTypeNum() == null || "".equals(type.getTypeNum())) && (type.getTypeName() == null || "".equals(type.getTypeName()))) {
                iterator.remove();
            } else {
                types.add(type);
            }
        }
        if (types.size() != 0) {
            result = typeService.excel(types);
            map.put("result", result);
        } else {
            map.put("result", result);
            map.put("warning", StatusEnum.EXCEL_NULL);
        }
        return responseManage.response(map);
    }

    @GetMapping("/type/download")
    @ApiOperation(value = "导出格式[.xls]")
    @ApiImplicitParam(value = "类型id", name = "typeId", required = false)
    public void download(HttpServletResponse response, @RequestParam(required = false) String typeId) {
        HSSFWorkbook hssfWorkbook = new Excel().generateExcel();
        try {
            OutputStream outputStream = response.getOutputStream();
            response.setContentType("application/vnd.ms-excel;charset=UTF-8");
            String fileName = URLEncoder.encode("类型模板", "utf-8");
            response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xls");//默认Excel名称
            hssfWorkbook.write(outputStream);
            outputStream.flush();
            outputStream.close();
        } catch (IOException e) {
            log.info("加载表格模板异常");
            e.printStackTrace();
        }

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
