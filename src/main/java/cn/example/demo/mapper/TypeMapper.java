package cn.example.demo.mapper;

import cn.example.demo.dao.Type;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author liuwu4
 * 09:43
 * description:
 */
@Service
public interface TypeMapper {
    /**
     * 查询类型
     * @param typeId 类型id
     * @return
     */
    List<Type> type(@Param("typeId") Integer typeId);

    /**
     * 联合查询type
     * @param typeId
     * @return
     */
    Type selectType(@Param("TypeId") Integer typeId);
    /**
     * 新增
     * @param type 新增信息
     * @return int
     */
    int add(@Param("type") Type type);

    /**
     * 修改
     * @param type
     * @param typeId
     * @return
     */
    int update(@Param("type") Type type, Integer typeId);

    /**
     * 删除
     * @param typeId
     * @return
     */
    int delete(@Param("typeId") Integer typeId);
}
