package cn.example.demo.mapper;

import cn.example.demo.dao.Customer;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author liuwu4
 * 10:33
 * description:
 */
@Repository
public interface CustomerMapper {
    /**
     * 获取所用用户信息
     * @param customerId 用户id
     * @return list
     */
    List<Customer> customer(@Param("id") String customerId);

    /**
     * 注册用户信息
     * @param customer 用户信息
     * @return int
     */
    int inset(@Param("customer") Customer customer);

    /**
     * 删除用户
     * @param account 用户账号
     * @return int
     */
    int delete(String account);

    /**
     * 修改账号状态
     * @param account 用户账号
     * @param value 用户账号转台
     * @return int
     */
    int update(String account, int value);

    /**
     * 更新账号信息
     * @param customer 用户信息
     * @return int
     */
    int updateCustomer(@Param("customer") Customer customer);

    /**
     * 批量更新密码
     * @param customerList 用户信息
     * @return int
     */
    int batchUpdatePassword(@Param("customerList") List<Customer> customerList);
}
