package cn.example.demo.service;

import cn.example.demo.dao.Type;
import cn.example.demo.mapper.TypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author liuwu4
 * 09:49
 * description:
 */
@Service
public class TypeService {
    @Autowired
    TypeMapper typeMapper;

    /**
     * 查询类型
     *
     * @param typeId 类型id
     * @return list
     */
    public List<Type> type(Integer typeId) {

        return typeMapper.type(typeId);
    }

    /**
     * 新增
     *
     * @param type 新增信息
     * @return int
     */
    public int add(Type type) {
        return typeMapper.add(type);
    }

    public int excel(List<Type> type) {
        return typeMapper.excel(type);
    }

    /**
     * 修改
     *
     * @param type
     * @param typeId
     * @return
     */
    public int update(Type type, Integer typeId) {
        return typeMapper.update(type, typeId);
    }

    /**
     * 删除
     *
     * @param typeId
     * @return
     */
    public int delete(Integer typeId) {
        return typeMapper.delete(typeId);
    }


}
