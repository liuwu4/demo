package cn.example.demo;

import cn.example.demo.utils.Excel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DemoApplicationTests {
    private String pathXls = "C:\\Users\\Administrator\\Desktop\\type.xls";

    private String pathXlsx = "C:\\Users\\Administrator\\Desktop\\type.xlsx";
    @Autowired
    Excel excel;

    @Test
    public void excel() {
        List listXls = excel.readExcel(pathXls, 0);
        List listXlsx = excel.readExcel(pathXlsx, 0);
        System.out.println("xls:"+ listXls);
        System.out.println("xlsx:"+ listXlsx);
    }

}
