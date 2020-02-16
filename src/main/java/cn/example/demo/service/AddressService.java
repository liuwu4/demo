package cn.example.demo.service;

import cn.example.demo.dao.Address;
import cn.example.demo.mapper.AddressMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author liuwu4
 * 20:54
 * description:
 */
@Service
public class AddressService {
    @Autowired
    private AddressMapper addressMapper;

    /**
     * 地址信息
     * @param loginId
     * @return
     */
    public List<Address> address(Integer loginId){
        System.out.println("login---server:\t"+loginId);
        return addressMapper.address(loginId);
    }
}
