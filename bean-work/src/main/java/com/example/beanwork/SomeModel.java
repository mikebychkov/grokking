package com.example.beanwork;

public class SomeModel {

    private String name;
    private MyBean myBean;

    public SomeModel(String name) {
        this.name = name;
    }

    public void setMyBean(MyBean myBean) {
        this.myBean = myBean;
    }

    @Override
    public String toString() {
        return "SomeModel{" +
                "name='" + name + '\'' +
                ", myBean=" + myBean +
                '}';
    }

    private void init() {
        name += " initialized";
    }
}
