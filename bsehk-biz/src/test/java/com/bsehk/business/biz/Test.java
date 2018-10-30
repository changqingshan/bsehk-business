package com.bsehk.business.biz;

import com.bsehk.common.util.DateUtil;

import java.util.Date;

public class Test {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.print(DateUtil.date2Str(date,"HH:mm"));
    }
}
