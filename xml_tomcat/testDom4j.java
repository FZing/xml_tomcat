package day07;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.util.List;

public class testDom4j {
    @Test
    public void test1() throws DocumentException {
        //获取第二本书的名字
        SAXReader reader = new SAXReader();
        Document document =  reader.read("src/day07/Book.xml");
        Element root = document.getRootElement();
        List list = root.elements();
        Element secondBook = (Element)list.get(1);
        String name = secondBook.element("书名").getText();
        System.out.println(name);
    }
    @Test
    public void test2() throws DocumentException {
        SAXReader reader = new SAXReader();
        Document document =  reader.read("src/day07/Book.xml");
        Element root = document.getRootElement();
        treeWalk(root);
    }

    private void treeWalk( Element ele) {
        System.out.println(ele.getName());
        for(int i = 0;i < ele.nodeCount(); i++){
            Node node = ele.node(i);
            if(node instanceof Element){
                treeWalk((Element) node);
            }
        }
    }
    @Test
    public void testXpath() throws DocumentException {
        SAXReader reader = new SAXReader();
        Document document =  reader.read("src/day07/Book.xml");
        Node node = document.selectSingleNode( "/书架/书[2]/书名");
        System.out.println(node.getText());
    }
    @Test
    public void test3() throws DocumentException {
        SAXReader reader = new SAXReader();
        Document document =  reader.read("src/day07/Book.xml");
        List list = document.selectNodes("//*");
        for(int i = 0; i < list.size();i++){
            Node node = (Node)list.get(i);
            System.out.println(node.getName()+ "\t" + node.getText());
        }
    }
}
