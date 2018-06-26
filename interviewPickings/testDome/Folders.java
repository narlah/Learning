package interviewPickings.testDome;


import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Collection;

public class Folders {
    public static Collection<String> folderNames(String xml, char startingLetter) throws Exception {
        ArrayList<String> res = new ArrayList<>();
        int index = 0;
        int posS, posE;
        while (index < xml.length()) {
            String searchFor = "<folder name=\"" + startingLetter;
            posS = xml.indexOf(searchFor, index);
            if (posS < 0) break;
            posS += searchFor.length() - 1;
            posE = xml.indexOf("\"", posS + 1);
            index = posE;
            String possibleResult = xml.substring(posS, posE);
            if (possibleResult.startsWith(startingLetter + ""))
                res.add(possibleResult);
        }
        return res;
    }

    public static Collection<String> folderNamesDom(String xml, char startingLetter) throws Exception {
        ArrayList<String> res = new ArrayList<>();
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(new ByteArrayInputStream(xml.getBytes()));
        doc.getDocumentElement().normalize();
        NodeList nList = doc.getElementsByTagName("folder");
        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
            String folderName = nNode.getAttributes().item(0).getNodeValue();
            if (folderName.startsWith(startingLetter + ""))
                res.add(folderName);

        }
        return res;
    }

    public static void main(String[] args) throws Exception {
        String xml =
                "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                        "<folder name=\"c\">" +
                        "<folder name=\"program files\">" +
                        "<folder name=\"uninstall information\" />" +
                        "</folder>" +
                        "<folder name=\"users\" />" +
                        "</folder>";

        Collection<String> names = folderNamesDom(xml, 'u');
        for (String name : names)
            System.out.println(name);
        System.out.println("\n MINE : \n");
        names = folderNames(xml, 'u');
        for (String name : names)
            System.out.println(name);
    }
}


