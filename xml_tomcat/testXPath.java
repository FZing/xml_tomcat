package day07;


import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.util.List;

public class testXPath {
    @Test
    public void test1()throws DocumentException {
        SAXReader reader = new SAXReader();
        Document document =  reader.read("src/day07/Dom4jTest.xml");
       List nodes =  document.selectNodes("/bookstore//book/title");
       for(int i = 0;i<nodes.size();i++){
           Node node = (Node) nodes.get(i);
           System.out.println(node.getText());
       }
    }
}
