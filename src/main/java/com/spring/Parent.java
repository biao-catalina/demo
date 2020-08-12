package com.spring;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
public class Parent {
    protected String name;

    public static void sayHi(Parent parent) {
        System.out.println(parent.getClass());
        if (parent instanceof Child) {
            System.out.println(111);
        }
        System.out.println(parent.getName());
    }

    public static void main(String[] args) {
        Parent.sayHi(new Child("hkl"));
    }
}

@EqualsAndHashCode(callSuper = true)
@Data
class Child extends Parent{
    String id;

    public Child(String id) {
        this.id = id;
    }
}
