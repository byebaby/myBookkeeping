package com.example.demo.util.generate;

public class Attr {

    private String className;  //类名
    private String desc; //描述


    Attr(String className, String desc) {
        this.className = className;
        this.desc = desc;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

}