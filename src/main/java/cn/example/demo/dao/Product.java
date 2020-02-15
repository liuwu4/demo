package cn.example.demo.dao;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author liuwu4
 * 16:26
 * description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel
@JsonIgnoreProperties({" hibernateLazyInitializer","handler"})
public class Product implements Serializable {
    @ApiModelProperty(value = "产品编号", required = true)
    private Integer no;
    @ApiModelProperty(value = "产品类型", required = true)
    private Integer type;
    @ApiModelProperty(value = "产品名称", required = true)
    private String name;
    @ApiModelProperty(value = "产品价格")
    private Double price;
    @ApiModelProperty(value = "产品库存")
    private Integer number;
    @ApiModelProperty(value = "产品图片")
    private String picture;
    @ApiModelProperty(value = "生产日期", required = true)
    private Date productionDate;
    @ApiModelProperty(value = "生产地址")
    private String productionAddress;
    @ApiModelProperty(value = "过期时间")
    private Date expirationDate;
    @ApiModelProperty(value = "1: 上架, 0: 下架")
    private Integer status;
    @ApiModelProperty(value = "产品描述")
    private String description;
    @ApiModelProperty(value = "备注")
    private String remark;


}
