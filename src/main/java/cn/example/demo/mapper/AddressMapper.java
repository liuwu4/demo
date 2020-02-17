package cn.example.demo.mapper;

import cn.example.demo.dao.Address;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author liuwu4
 * 20:53
 * description:
 */
@Service
public interface AddressMapper {
    /**
     * 获取地址
     * @param loginId
     * @return
     */
    List<Address> address(@Param("loginId")Integer loginId);

    /**
     * 根据用户id 查询地址
     * @param id 用户id
     * @return
     */
    List<Address> collectionLogin(@Param("id") Integer id);

    /**
     * 添加地址
     * @param address 地址信息
     * @return
     */
    int insert(@Param("address") Address address);

    /**
     * 修改地址
     * @param address 地址信息
     * @return
     */
    int update(@Param("address") Address address);

    /**
     * 删除用户地址
     * @param loginId
     * @param addressId
     * @return
     */
    int delete(@Param("loginId") Integer loginId, @Param("addressId") Integer addressId);
}
