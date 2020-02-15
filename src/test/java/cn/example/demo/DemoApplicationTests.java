package cn.example.demo;

import cn.example.demo.dao.Customer;
import cn.example.demo.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
class DemoApplicationTests {
    @Autowired
    CustomerService customerService;
    @Test
    void contextLoads() {
        Date date = new Date();
        Customer customer = new Customer();
        customer.setAccount("1222234222");
        customer.setNickname("123413");
        customer.setPassword("13424");
        customer.setSex(1);
        customer.setPhone("12343214321");
        customer.setAddress("1341");
        customer.setEmail("@.com");
        customer.setStatus(2);
        customer.setTime(date);
      int result = customerService.inset(customer);
      System.out.println("插入结果:"+result);
    }

}
