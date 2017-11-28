package com.deserializwr;

import org.w3c.dom.Node;

public interface NodeTypeFactory<T extends NodeType> {
    T getFromNode(Node node);
}
