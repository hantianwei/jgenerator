package com.hantianwei.generator.util;

import java.io.*;
import java.util.Map;

import freemarker.ext.beans.BeansWrapper;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateHashModel;

/**
 * Created by tianwei on 2017/6/29.
 */
public class FreeMakerUtil {
    /**
     * 获取模板文件
     *
     * @param name
     * @return
     */
    public Template getTemplate(String name) {
        try {
            Configuration cfg = new Configuration();
            cfg.setDefaultEncoding("UTF-8");
            cfg.setClassForTemplateLoading(this.getClass(), "/template");
            Template template = cfg.getTemplate(name);
            return template;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 生成文件
     *
     * @param templateName:模板名
     * @param root：数据原型
     * @param outFilePath：输出路径(全路径名)
     */
    public void generateFile(String templateName, Map<String, Object> root, String outFilePath) {

        Writer out = null;
        try {
            outFilePath = FileUtil.getCurrentDirParent() + outFilePath;
            FileUtil.createDirectory(new File(outFilePath).getParent());
            // 通过一个文件输出流，就可以写到相应的文件中，此处用的是绝对路径
            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(outFilePath)), "UTF-8"));
            Template temp = this.getTemplate(templateName);
            temp.process(root, out);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null)
                    out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // 指定要在ftl页面使用的静态包名
    public static TemplateHashModel useStaticPackage(String packageName)
    {
        try
        {
            BeansWrapper wrapper = BeansWrapper.getDefaultInstance();
            TemplateHashModel staticModels = wrapper.getStaticModels();
            TemplateHashModel fileStatics = (TemplateHashModel) staticModels.get(packageName);
            return fileStatics;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
}

