package com.aos.oigo.service.Impl;

import com.aos.oigo.service.AopService;
import org.springframework.stereotype.Service;

/**
 * @Author : HuangHaoXin
 * @Description :
 * @Date : Create in 2018-01-10
 */
@Service
public class AopServiceImpl implements AopService {
    @Override
    public int add(int a, int b) {
        return a + b;
    }

    @Override
    public int sub(int a, int b) {
        return a - b;
    }
}
