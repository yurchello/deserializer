package com.deserializwr;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class App {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        File fXmlFile = new File(App.class.getClassLoader().getResource("com/deserializwr/source.xml").getFile());
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(fXmlFile);
        CheckinEntity checkinEntity = NodeType.getFromDocument(doc, CheckinEntity.factory);
    }
}
