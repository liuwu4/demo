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
}
