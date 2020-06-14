package cn.example.demo;

import cn.example.demo.dao.Customer;
import cn.example.demo.dao.Login;
import cn.example.demo.dao.Type;
import cn.example.demo.service.LoginService;
import cn.example.demo.service.TypeService;
import cn.example.demo.utils.Encryption;
import cn.example.demo.utils.Excel;
import cn.example.demo.utils.GenerateToken;
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
    private static final String JET_KEY = "JWT-key-123";
    @Autowired
    Excel excel;

    @Autowired
    TypeService typeService;
    @Autowired
    LoginService loginService;

    @Test
    public void excel() {
        List<ArrayList<Type>> readExcel = excel.readExcel(pathXls, 0);
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
        log.info("types:" + types);
        if (types.size() != 0) {
            result = typeService.excel(types);
        }

        log.info("插入结果" + result);
    }

    @Test
    public void generateToken() {
        Login login = new Login("15082000855", "123");
        Customer customer = loginService.result(login);
        String token = new GenerateToken().generate(customer);
        log.info("token:" + token);
    }

    @Test
    public void parseToken() {
        String testToken = "eyJ0eXBlIjoiSldUIiwiYWxnIjoiSFMyNTYiLCJ0eXAiOiJKV1QifQ.eyJhdWQiOiJBUFAiLCJ1c2VyVG9rZW4iOiIxNTA4MjAwMDg1NSIsImlzcyI6IlNlcnZpY2UifQ.PKJS_UHPcYmLTO3I5LJc_MUxOUtnMDGf1DaltG273Jo\n";
        System.out.println(new GenerateToken().parseToken(testToken));
    }
    @Test
    public  void encryption(){
        new Encryption().generatorEncryption("123434/'");
    }
}
