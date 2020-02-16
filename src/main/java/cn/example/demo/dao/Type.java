package cn.example.demo.dao;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author liuwu4
 * 09:44
 * description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel
public class Type {
    @ApiModelProperty(value = "类型编号", required = false)
    private Integer typeId;
    @ApiModelProperty(value = "类型名称", required = true)
    private String typeName;
}
