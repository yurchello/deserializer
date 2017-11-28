package com.deserializwr;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

public class NodeType {

    static <T extends NodeType> T getFromDocument(Document document, NodeTypeFactory<T> factory){
        if (document == null || factory == null) throw new DocumentParseException();
        Node rootNode = document.getDocumentElement();
        return factory.getFromNode(rootNode);
    }

}
