package com.aos.oigo.test;

import org.junit.Test;

/**
 * @Author : HuangHaoXin
 * @Description :
 * @Date : Create in 2018-01-02
 */
public class Split {
    @Test
    public void test1(){
        String str = "1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28";
        String[] arrayStr = str.split("\\,");

        if(arrayStr.length >1){
            str = "";
            for(int i = 0; i < arrayStr.length; i++ ){
                if(arrayStr.length-1 >i){
                    str += arrayStr[i] + "|";
                }else{
                    str += arrayStr[i];
                }
            }
        }

        for (String s : arrayStr) {
            System.out.println(s);
        }

        System.out.println(str);
    }
}
