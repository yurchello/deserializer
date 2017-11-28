package com.deserializwr;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public  class DomUtils {
    /*keys*/
    public static final String BUILD_VERSION_KEY = "BuildVersion";
    public static final String OS_VERSION_KEY = "OSVersion";
    public static final String PRODUCT_NAME_KEY = "ProductName";
    public static final String SERIAL_NUMBER_KEY = "SerialNumber";
    public static final String MESSAGE_TYPE_KEY = "MessageType";
    public static final String TOPIC_KEY = "Topic";
    public static final String UDID_KEY = "UDID";

    /*tags*/
    public static final String KEY_TAG = "key";
    public static final String STRING_TAG = "string";
    public static final String DATA_TAG = "data";
    public static final String FALSE_TAG = "false";
    public static final String TRUE_TAG = "true";
    public static final String DICT_TAG = "dict";

    public List<Node> getElementNodes(Node rootNode){
        List<Node> elNode = new ArrayList<>();
        if (rootNode == null) return elNode;
        NodeList nodeList = rootNode.getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++) {
            if (nodeList.item(i) instanceof Element) elNode.add(nodeList.item(i));
        }
        return elNode;
    }

    public String getNodeText(Node node){
        if (node == null) return null;
        return node.getTextContent();
    }

    public String getValue(Node root, String key, String valueNodeType){
        List<Node> nodes = getElementNodes(root);
        Optional<Node> keyNodeResult = nodes.stream()
                .filter(node -> key.equals(node.getTextContent()))
                .findFirst();
        if (!keyNodeResult.isPresent()) return null;
        Node valNode = getNextSibling(keyNodeResult.get());
        if (valNode == null || !valueNodeType.equals(valNode.getNodeName())) return null;
        return valNode.getTextContent();
    }

    public String getValueFromStringTag(Node root, String key){
        return getValue(root,key,STRING_TAG);
    }

    public Node getNextSibling(Node node){
        if (node == null) throw new RuntimeException("Node is null.");
        while (true){
            node = node.getNextSibling();
            if (node instanceof Element || node == null) return node;
        }
    }

    public Node getNodeByKeyName(Element root, String keyName){
        List<Node> nodeList = getElementNodes(root);
        return  nodeList.stream()
                .filter(node -> keyName.equals(node.getTextContent()))
                .findFirst()
                .get();
    }

    public Node getDictTag(Node root){
        List<Node> list = getElementNodes(root);
        return list.stream().filter(node -> node.getNodeName().equals(DICT_TAG)).findFirst().get();
    }

}
