package com.course;

public class Model {

    private StringBuilder builder = new StringBuilder();

    public void setBuilder(String string) {
        this.builder.append(string);
    }

    public StringBuilder getBuilder() {
        return this.builder;
    }
}
