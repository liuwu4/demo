package cn.example.demo.mapper;

import cn.example.demo.dao.Customer;
import cn.example.demo.dao.Login;
import org.apache.ibatis.annotations.Param;

/**
 * @author liuwu4
 * 13:00
 * description:
 */
public interface LoginMapper {

    /**
     * 登录
     * @param login 登录信息
     * @return Customer
     */
    Customer result(@Param("login") Login login);

    /**
     * 重置密码
     * @param customer 新密码
     * @return int
     */
    int reset(@Param("customer") Login customer);
}
