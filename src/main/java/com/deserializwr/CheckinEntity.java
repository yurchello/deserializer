package com.deserializwr;

import org.w3c.dom.Node;

public class CheckinEntity extends NodeType {
    private String buildVersion;
    private String oSVersion;
    private String productName;
    private String serialNumber;
    private String messageType;
    private String topic;
    private String udid;

    public String getBuildVersion() {
        return buildVersion;
    }

    public void setBuildVersion(String buildVersion) {
        this.buildVersion = buildVersion;
    }

    public String getoSVersion() {
        return oSVersion;
    }

    public void setoSVersion(String oSVersion) {
        this.oSVersion = oSVersion;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getUdid() {
        return udid;
    }

    public void setUdid(String udid) {
        this.udid = udid;
    }

    public static NodeTypeFactory<CheckinEntity> factory = node -> {
        CheckinEntity entity = new CheckinEntity();
        DomUtils domUtils = new DomUtils();
        Node dictNode = domUtils.getDictTag(node);
        entity.buildVersion = domUtils.getValueFromStringTag(dictNode, DomUtils.BUILD_VERSION_KEY);
        entity.oSVersion = domUtils.getValueFromStringTag(dictNode, DomUtils.OS_VERSION_KEY);
        entity.productName = domUtils.getValueFromStringTag(dictNode, DomUtils.PRODUCT_NAME_KEY);
        entity.serialNumber = domUtils.getValueFromStringTag(dictNode, DomUtils.SERIAL_NUMBER_KEY);
        entity.messageType = domUtils.getValueFromStringTag(dictNode, DomUtils.MESSAGE_TYPE_KEY);
        entity.topic = domUtils.getValueFromStringTag(dictNode, DomUtils.TOPIC_KEY);
        entity.udid = domUtils.getValueFromStringTag(dictNode, DomUtils.UDID_KEY);
        return entity;
    };


}
