package com.example.inflearnspringcorebasic;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class HelloLombok {
    private String name;
    private int age;

    public static void main(String[] args) {
        final HelloLombok helloLombok = new HelloLombok();
        helloLombok.setName("asdf");

        System.out.println("helloLombok = " + helloLombok);
    }

}
