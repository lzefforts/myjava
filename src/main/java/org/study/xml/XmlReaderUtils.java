package org.study.xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * 读取xml文件转换为vo
 * Created by ArnoldLee on 17/9/11.
 */
public class XmlReaderUtils<T> {


    public List<T> parseXmlPojo(String filePath,Class clazz,String tagName) {
        List<T> xmlPojoList = null;
        //获得dom制造工厂
        DocumentBuilderFactory factory = DocumentBuilderFactory
                .newInstance();
        //获得dom解析器
        DocumentBuilder builder = null;
        try {
            builder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        //获得xml文件的输入流
        InputStream inStream = null;
        try {
            inStream = new FileInputStream(filePath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //通过解析器得到Document对象
        Document document = null;
        try {
            document = builder.parse(inStream);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //得到要获取的所有item 结点，通过每个结点，获取每个item的内容数据。
        NodeList list = document.getElementsByTagName(tagName);
        xmlPojoList = new ArrayList<T>();
        T bean = null;
        //遍历person集合，将数据封装于xmlPojo对象中
        for (int i = 0, size = list.getLength(); i < size; i++) {
            try {
                bean = (T) clazz.newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            //得到<person>结点
            Element e = (Element) list.item(i);
            //获取其id属性
            String id = e.getAttribute("id");
        }
        //返回最终得到的数据。
        return xmlPojoList;
    }

}
