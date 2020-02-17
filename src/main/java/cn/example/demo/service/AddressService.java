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
        return addressMapper.address(loginId);
    }

    /**
     * 新增地址
     * @param address 地址信息
     * @return
     */
    public int insert(Address address){
        return addressMapper.insert(address);
    }

    /**
     * 修改地址
     * @param address 地址信息
     * @return
     */
    public int update(Address address){
        return addressMapper.update(address);
    }

    /**
     * 删除地址
     * @param addressId
     * @return
     */
    public int delete(Integer loginId, Integer addressId){
        return addressMapper.delete(loginId, addressId);
    }


}
