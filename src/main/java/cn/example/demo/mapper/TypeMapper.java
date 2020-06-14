package cn.example.demo.mapper;

import cn.example.demo.dao.Type;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author liuwu4
 * 09:43
 * description:
 */
public interface TypeMapper {
    /**
     * 查询类型
     * @param typeId 类型id
     * @return list<type>
     */
    List<Type> type(@Param("typeId") Integer typeId);

    /**
     * 联合查询type
     * @param typeId 类型唯一标识
     * @return type
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
     * @param type 对象
     * @param typeId id
     * @return int
     */
    int update(@Param("type") Type type, Integer typeId);

    /**
     * 删除
     * @param typeId id
     * @return int
     */
    int delete(@Param("typeId") Integer typeId);

    /**
     * 批量导入
     * @param type list
     * @return int
     */
    int excel(@Param("type")List<Type> type);
}
