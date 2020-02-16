package cn.example.demo.dao;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author liuwu4
 * 12:57
 * description: 登录
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel
public class Login {
    @ApiModelProperty(value = "用户账号[phone, email]", required = true)
    private  String account;
    @ApiModelProperty(value = "用户密码[password]", required = true)
    private  String password;
}
