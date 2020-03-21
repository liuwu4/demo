package cn.example.demo;

import cn.example.demo.dao.Type;
import cn.example.demo.service.TypeService;
import cn.example.demo.utils.Excel;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@SpringBootTest
class DemoApplicationTests {
    private Logger log = LoggerFactory.getLogger(DemoApplicationTests.class);
    private String pathXls = "C:\\Users\\Administrator\\Desktop\\type.xls";

    private String pathXlsx = "C:\\Users\\Administrator\\Desktop\\type.xlsx";
    @Autowired
    Excel excel;

    @Autowired
    TypeService typeService;
    @Test
    public void excel() {
        List<ArrayList<Type>> readExcel =  excel.readExcel(pathXls, 0);
        int result = 0;
        Iterator<Type> iterator =readExcel.get(0).iterator();
        List<Type> types = new ArrayList<>();
        while (iterator.hasNext()){
            Type type = iterator.next();
            if((type.getTypeNum() == null || "".equals(type.getTypeNum())) && (type.getTypeName() == null || "".equals(type.getTypeName()))){
                iterator.remove();
            } else {
                types.add(type);
            }
        }
        log.info("types:"+types);
        if(types.size() !=0){
            result = typeService.excel(types);
        }

        log.info("插入结果"+ result);
    }
}
