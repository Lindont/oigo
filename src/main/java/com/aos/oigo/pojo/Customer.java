package com.aos.oigo.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author : HuangHaoXin
 * @Description :
 * @Date : Create in 2018-01-20
 */
@Data
public class Customer implements Serializable {
    private int customerId;

    private String customerName;

    private int age;

    //@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date birthday;
}
