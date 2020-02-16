package cn.example.demo.dao;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author liuwu4
 * 10:27
 * description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({" hibernateLazyInitializer","handler"})
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel
public class Customer implements Serializable {
    @ApiModelProperty(value = "自动生成", required = false)
    private String id;
    @ApiModelProperty(value = "账号(可选)", required = false)
    private String account;
    @ApiModelProperty(value = "昵称", required = false)
    private String nickname;
    @ApiModelProperty(value = "密码", required =  true)
    private String password;
    @ApiModelProperty(value = "性别", required = false)
    private Integer sex;
    @ApiModelProperty(value = "手机号", required = true)
    private String phone;
    @ApiModelProperty(value = "地址", required = false)
    private String address;
    @ApiModelProperty(value = "邮箱", required = false)
    private String email;
    @ApiModelProperty(value = "账号状态", required = false)
    private Integer status;
    @ApiModelProperty(value = "创建时间)", required = false)
    private Date time;
}
