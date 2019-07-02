package com.example.demo.util.generate;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wjw
 * @desc 生成工具类
 * @date 2016年12月21日下午4:31:29
 */
public class GenerateUtil {

    public String author = "cyb";//设置默认作者

    public String ftlPath;//模板所在路径

    public GenerateUtil() {
    }

    public GenerateUtil(String author, String ftlPath) {
        this.author = author;
        this.ftlPath = ftlPath;
        path_Judge_Exist(ftlPath);
    }

    /**
     * @param ftlName     模板名
     * @param filePath    model层的路径
     * @param packageName model包名
     * @param list        model参数集合
     * @desc model生成方法
     */
    public void GenerateModel(String ftlName, String filePath, String packageName, List<Attr> list) throws IOException, TemplateException {
        path_Judge_Exist(filePath);
        //实体类需要其他参数
        Map<String, Object> root = new HashMap<>();
        root.put("packageName", packageName);
        root.put("author", author);

        for (Attr a : list) {
            String className = a.getClassName();
            root.put("desc", a.getDesc());
            root.put("createDate", LocalDate.now());
            root.put("className", className);
            Configuration cfg = new Configuration(Configuration.VERSION_2_3_28);
            String path = System.getProperty("user.dir") + ftlPath;

            cfg.setDirectoryForTemplateLoading(new File(path));
            Template template = cfg.getTemplate(ftlName);

            printFile(root, template, filePath, className);
        }
    }

    /**
     * @param ftlName
     * @param filePath
     * @param packageName
     * @param modelPackageName
     * @param list
     * @throws IOException
     * @throws TemplateException
     * @desc dao生成方法
     */
    public void GenerateDao(String ftlName, String filePath, String packageName, String modelPackageName, List<Attr> list) throws IOException, TemplateException {
        path_Judge_Exist(filePath);
        //实体类需要其他参数
        Map<String, Object> root = new HashMap<>();
        root.put("packageName", packageName);
        root.put("author", author);
        root.put("modelPackageName", modelPackageName);

        for (Attr a : list) {
            String modelClassName = a.getClassName();
            root.put("modelClassName", modelClassName);
            root.put("desc", a.getDesc());
            root.put("createDate", LocalDate.now());
            Configuration cfg = new Configuration(Configuration.VERSION_2_3_28);
            String path = System.getProperty("user.dir") + ftlPath;
            cfg.setDirectoryForTemplateLoading(new File(path));
            Template template = cfg.getTemplate(ftlName);

            printFile(root, template, filePath, modelClassName + "Dao");
        }
    }

    /**
     * @param ftlName
     * @param filePath
     * @param packageName
     * @param daoPackageName
     * @param modelPackageName
     * @param list
     * @throws IOException
     * @throws TemplateException
     * @desc servic接口和实现的生成方法
     */
    public void GenerateService(String ftlName, String filePath, String packageName, String daoPackageName, String modelPackageName, List<Attr> list) throws IOException, TemplateException {
        String ImplFilePath = filePath + "\\impl";
        path_Judge_Exist(filePath);
        path_Judge_Exist(ImplFilePath);

        Map<String, Object> root = new HashMap<String, Object>();
        root.put("author", author);
        root.put("daoPackageName", daoPackageName);
        root.put("packageName", packageName);
        root.put("implPackageName", packageName + ".impl");
        root.put("modelPackageName", modelPackageName);
        for (Attr a : list) {
            String className = a.getClassName();//类名
            root.put("desc", a.getDesc());
            root.put("createDate", LocalDate.now());
            root.put("className", className);
            root.put("implflag", false);//接口

            Configuration cfg = new Configuration(Configuration.VERSION_2_3_28);
            String path = System.getProperty("user.dir") + ftlPath;

            cfg.setDirectoryForTemplateLoading(new File(path));
            Template template = cfg.getTemplate(ftlName);

            printFile(root, template, filePath, className + "Service");//生成service接口
            root.put("implflag", true);//实现
            printFile(root, template, ImplFilePath, className + "ServiceImpl");//生成service实现
        }
    }

    //判断包路径是否存在
    public static void path_Judge_Exist(String path) {
        File file = new File(System.getProperty("user.dir"), path);
        if (!file.exists()) file.mkdirs();
    }

    /*
     * 读取指定路径下的文件名
     */
    public static List<String> getFileList(String path) {
        File file = new File(path);
        List<String> list = new ArrayList<>();
        File[] fileList = file.listFiles();

        assert fileList != null;
        for (int i = 0; i < fileList.length; i++) {
            if (fileList[i].isFile()) {
                String fileName = fileList[i].getName();
                list.add(fileName.substring(0, fileName.lastIndexOf('.')));
            }
        }
        return list;
    }

    //输出到文件
    public static void printFile(Map<String, Object> root, Template template, String filePath, String fileName) throws IOException, TemplateException {
        String path = System.getProperty("user.dir") + filePath;
        File file = new File(path, fileName + ".java");
        if (!file.exists()) {
            file.createNewFile();
            FileWriter fw = new FileWriter(file);
            template.process(root, fw);
            fw.close();
            System.out.println("生成" + fileName + ".java");
        }else {
            System.out.println("跳过" + fileName + ".java");
        }
    }


    //输出到控制台
    public static void printConsole(Map<String, Object> root, Template template)
            throws TemplateException, IOException {
        StringWriter out = new StringWriter();
        template.process(root, out);

        System.out.println(out.toString());
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getFtlPath() {
        return ftlPath;
    }

    public void setFtlPath(String ftlPath) {
        this.ftlPath = ftlPath;
    }
}