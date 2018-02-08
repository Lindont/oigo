package com.aos.oigo.test.lambda;

/**
 * @Author : HuangHaoXin
 * @Description :
 * @Date : Create in 2018-02-08
 */
public class LambdaQs {
    public void eat(Eatable e) {
        e.taste(12345);
    }

    public static void main(String[] args) {
        LambdaQs lq = new LambdaQs();
        lq.eat((a) ->{
            System.out.println(a);
        });
    }
}
