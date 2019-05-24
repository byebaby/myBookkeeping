package com.example.demo.util.generate;

import freemarker.template.TemplateException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Generate {

    public static void main(String[] args) throws IOException, TemplateException, ParserConfigurationException, SAXException {
        String ftlPath = ""; //模板路径

        //model参数
        String ModelftlName = "";  //model模板名称
        String ModelfilePath = ""; //模板路径
        String ModelpackgeName = "";//模板包名
        List<Attr> modellist = new ArrayList<>(); //需要生成的实体对象集合

        // dao参数
        String DaoftlName = ""; //dao模板名称
        String DaofilePath = ""; //dao路径
        String DaopackgeName = ""; //dao包名
        //service参数
        String ServiceftlName = ""; //Service模板名称
        String ServicefilePath = ""; //service路径
        String ServicepackgeName = "";//service包名

        //配置文件位置
        File xmlFile = new File(System.getProperty("user.dir"), "\\src\\main\\resources\\generate.xml");
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = builderFactory.newDocumentBuilder();
        Document doc = builder.parse(xmlFile);

        Element rootElement = doc.getDocumentElement(); //获取根元素
        Node ftlnode = rootElement.getElementsByTagName("ftl").item(0);
        ftlPath = ((Element) ftlnode).getAttribute("path");
        NodeList params = ftlnode.getChildNodes();
        for (int i = 0; i < params.getLength(); i++) {//获取对应模板名称
            Node node = params.item(i);
            if (node.getNodeType() != Node.ELEMENT_NODE) continue;
            Element e = (Element) node;
//            if (e.getAttribute("name").trim().equals("model")) ModelftlName = node.getFirstChild().getNodeValue();
            if (e.getAttribute("name").trim().equals("dao")) DaoftlName = node.getFirstChild().getNodeValue();
            if (e.getAttribute("name").trim().equals("service")) ServiceftlName = node.getFirstChild().getNodeValue();
        }
        //获取对应service参数
        Node servicenode = rootElement.getElementsByTagName("service").item(0);
        ServicefilePath = ((Element) servicenode).getAttribute("path");
        ServicepackgeName = servicenode.getChildNodes().item(1).getFirstChild().getNodeValue();
        //获取对应dao参数
        Node daonode = rootElement.getElementsByTagName("dao").item(0);
        DaofilePath = ((Element) daonode).getAttribute("path");
        DaopackgeName = daonode.getChildNodes().item(1).getFirstChild().getNodeValue();
        //获取对应model参数
        Node modelnode = rootElement.getElementsByTagName("models").item(0);
        ModelfilePath = ((Element) modelnode).getAttribute("path");
        params = modelnode.getChildNodes();
        ModelpackgeName = modelnode.getChildNodes().item(1).getFirstChild().getNodeValue();

        for (String entityName : GenerateUtil.getFileList(System.getProperty("user.dir") + ModelfilePath)) {
            Attr attr1 = new Attr(entityName, "Generate");
            if (!attr1.getClassName().contains("Base")) {
                modellist.add(attr1);
            }

        }
//        for (int i = 0; i < params.getLength(); i++) {
//            Node node = params.item(i);
//            if (node.getNodeType() != Node.ELEMENT_NODE) continue;
//            Element e = (Element) node;
//            if (e.getNodeName().trim().equals("packageName")) ModelpackgeName = node.getFirstChild().getNodeValue();
//            if (e.getNodeName().trim().equals("model")) {
//                Attr attr = new Attr();
//                NodeList attrnode = node.getChildNodes();
//                for (int j = 0; j < attrnode.getLength(); j++) {
//                    Node anode = attrnode.item(j);
//                    if (anode.getNodeType() != Node.ELEMENT_NODE) continue;
//                    Element ae = (Element) anode;
//                    if (ae.getTagName().trim().equals("className"))
//                        attr.setClassName(anode.getFirstChild().getNodeValue());
//                    if (ae.getTagName().trim().equals("desc")) attr.setDesc(anode.getFirstChild().getNodeValue());
//                }
//                modellist.add(attr);
//            }
//        }
        GenerateUtil gt = new GenerateUtil("cyb", ftlPath);

        gt.GenerateDao(DaoftlName, DaofilePath, DaopackgeName, ModelpackgeName, modellist);
        gt.GenerateService(ServiceftlName, ServicefilePath, ServicepackgeName, DaopackgeName, ModelpackgeName, modellist);
//        gt.GenerateModel(ModelftlName, ModelfilePath, ModelpackgeName, modellist);
    }
}