package cn.example.demo.service;

import cn.example.demo.dao.Product;
import cn.example.demo.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author liuwu4
 * 17:15
 * description:
 */
@Service
public class ProductService {
    @Autowired
    ProductMapper productMapper;

    /**
     * 获取产品信息
     * @param no 产品货号
     * @return list
     */
    public List<Product> products(Integer no) {
        return productMapper.products(no);
    }

    /**
     * 新增
     * @param product 产品信息
     * @return int
     */
    public int product(Product product){
        return productMapper.product(product);
    }

    /**
     * 删除产品
     * @param no 产品编号
     * @return int
     */
    public int delete(Integer no){
        return productMapper.delete(no);
    }

    /**
     * 更新产品信息
     * @param product 产品信息
     * @param no 产品编号
     * @return int
     */
    public int update(Product product, Integer no){
        return productMapper.update(product, no);
    }
}
