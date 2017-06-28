package com.hantianwei.generator.main;

import com.hantianwei.generator.util.PropUtil;

/**
 * Created by tianwei on 2017/6/27.
 */
public class RunGenerator {
    public static void main(String[] args){
        PropUtil.loadConf(args);
        System.out.println("****** OK ******");
    }
}
