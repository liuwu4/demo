package cn.example.demo.service;

import cn.example.demo.dao.Customer;
import cn.example.demo.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author liuwu4
 * 11:29
 * description:
 */
@Service
public class CustomerService {
    @Autowired
    private CustomerMapper customerMapper;

    /**
     * 查询指定用户信息和所有用户
     * @param customerId 用户id
     * @return
     */
    public List<Customer> customer(String customerId){
        return customerMapper.customer(customerId);
    }

    /**
     * 添加账号
     * @param customer
     * @return
     */
    public int inset(Customer customer){
        return customerMapper.inset(customer);
    }

    /**
     * 修改账号状态
     * @param account
     * @param status
     * @param value
     * @return
     */
    public int modify(String account, Integer status, Integer value) {
        if(status == 0){
            return customerMapper.update(account, value);
        }
        return customerMapper.delete(account);
    }

    /**
     * 更新账号信息
     * @param customer
     * @return
     */
    public int updateCustomer(Customer customer){
        return customerMapper.updateCustomer(customer);
    }

}
