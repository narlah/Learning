package interviewPickings.testDome;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Collection;

public class LogParser {
    public static Collection<Integer> getIdsByMessage(String xml, String message) throws Exception {
        ArrayList<Integer> result = new ArrayList<>();
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document document = dBuilder.parse(new ByteArrayInputStream(xml.getBytes()));
        document.getDocumentElement().normalize();
        Element rootElement = document.getDocumentElement();
        check(rootElement, result, message);
        return result;
    }

    public static void check(Node node, ArrayList<Integer> result, String message) {
        NodeList nodeList = node.getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node currentNode = nodeList.item(i);
            String name = currentNode.getNodeName();
            if (currentNode.getNodeType() == Node.ELEMENT_NODE && currentNode.getNodeName().equals("entry") && currentNode.getTextContent().contains(message)) {
                System.out.println(currentNode.getNodeName() + " " + currentNode.getAttributes().getNamedItem("id").getNodeValue() + " " + currentNode.getTextContent());
                result.add(Integer.valueOf(currentNode.getAttributes().getNamedItem("id").getNodeValue()));
                check(currentNode, result, message);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        String xml =
                "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                        "<log>\n" +
                        "    <entry id=\"1\">\n" +
                        "        <message>Application started</message>\n" +
                        "    </entry>\n" +
                        "    <entry id=\"2\">\n" +
                        "        <message>Application ended</message>\n" +
                        "    </entry>\n" +
                        "</log>";

        Collection<Integer> ids = getIdsByMessage(xml, "Application ended");
        for (int id : ids)
            System.out.println(id);
    }
}