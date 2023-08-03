package com.internship.falcon.enums;

public enum MessagesEnum {

    successfullyAdded("Successfully Added!"),
    successfullyUpdated("Successfully Updated!"),
    successfullyDeleted("Successfully Deleted!");

    private final String value;

    private MessagesEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }


}
