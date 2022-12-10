package com.garry.io.xml;

import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;

/**
 * @author guyu06
 * @date 2022/12/10 18:19
 */
public class Main {
    public static void main(String[] args) throws Exception {
        InputStream is = Main.class.getResourceAsStream("tutorial.xml");
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = builderFactory.newDocumentBuilder();
        Document xmlDocument = builder.parse(is);
        Element documentElement = xmlDocument.getDocumentElement();
        NodeList childNodes = documentElement.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node child = childNodes.item(i);
            System.out.println(child.getNodeName());
            System.out.println();
            NodeList childNodes1 = child.getChildNodes();
            for (int j = 0; j < childNodes1.getLength(); j++) {
                Node node = childNodes1.item(j);
                if (node instanceof Element) {
                    System.out.println(node.getNodeName() + ":" + node.getTextContent());
                } else if (node instanceof Text){
                    System.out.println(((Text)node).getNodeValue());
                }
            }
        }
    }
}
