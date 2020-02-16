package cn.example.demo.dao;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
public class Customer implements Serializable {
    private String id;
    private String account;
    private String nickname;
    @JsonIgnore
    private String password;
    private Integer sex;
    private String phone;
    private String address;
    private String email;
    private Integer status;
    private Date time;
}
