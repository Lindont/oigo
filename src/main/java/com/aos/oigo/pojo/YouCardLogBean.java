package com.aos.oigo.pojo;

import lombok.Data;

/**
 * @Author : HuangHaoXin
 * @Description :
 * @Date : Create in 2018-01-26
 */
@Data
public class YouCardLogBean {
    private String resInfo;
    private String resInfoNo;
    private String status;
    private String code;
    private String desc;
    private int amount;
    private String bizOrderId;
    //商城order_code
    private String serialno;
}
