package com.aos.oigo.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.Date;

/**
 * @Author : HuangHaoXin
 * @Description :
 * @Date : Create in 2018-01-20
 */
@Data
public class Order {
    private int customerId;

    private String orderCode;

    /**
     * @DateTimeFormat 把页面传递过来的String类型的时间 'yyyy-MM-dd HH:mm:ss' 转换为 Date 类型, 如果定义了全局日期转换器则不用此注解
     * @JSONField      把Date 类型 转换为String类型的时间 'yyyy-MM-dd HH:mm:ss' 传递到页面
     */
    //@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date createtime;

    private String note;

    private Customer customer;
}
