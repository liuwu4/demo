package cn.example.demo.mapper;

import cn.example.demo.dao.Product;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author liuwu4
 * 17:14
 * description:
 */
public interface ProductMapper {
    /**
     * 获取产品
     * @param no 搜索特定的产品
     * @return list
     */
    List<Product> products(@Param("no") Integer no);

    /**
     * 新增
     * @param product 产品信息
     * @return int
     */
    int product(@Param("product") Product product);

    /**
     * 删除产品
     * @param no 编号
     * @return int
     */
    int delete(@Param("no") Integer no);

    /**
     * 更新产品信息
     * @param product 产品内容
     * @return int
     */
    int update(@Param("product") Product product, @Param("no") Integer no);
}
