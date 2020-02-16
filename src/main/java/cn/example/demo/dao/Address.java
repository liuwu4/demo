package cn.example.demo.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author liuwu4
 * 20:43
 * description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    private Integer addressId;
    private String addressName;
    private Integer loginId;
}
