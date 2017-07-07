package com.hantianwei.generator.main;

import com.hantianwei.generator.service.ICodeGenerator;
import com.hantianwei.generator.service.impl.CodeGenerator;
import com.hantianwei.generator.util.PropUtil;

/**
 * Created by tianwei on 2017/6/27.
 */
public class RunGenerator {
    public static void main(String[] args) {
        try {
            PropUtil.loadConf(args);

            ICodeGenerator cg = new CodeGenerator();
            cg.generatorAllTables();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("****** OK ******");
    }
}
