package com.example.buoi1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;

@SpringBootApplication
public class Buoi1Application {

    public static void main(String[] args) {
        SpringApplication.run(Buoi1Application.class, args);
//        ArrayList<Integer> arrayList = new ArrayList<>(5);
//        LinkedList<Integer> linkedList = new LinkedList<>();
//        Map<String, Map<String, String>> map = new HashMap<>();
//        Integer a = 1000;
//        Integer b = 1000;
//        if(a == b) {
//            System.out.println("oke");
//        }
    }

    private List<Integer> insert() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(3);

        return new ArrayList<>(linkedList);
    }

    // Collection
    // Thread
    // Abstract Factory
    // String, String builder, String buffer

    // Schedule Dynamic
    // Message queue (RabbitMQ, Kafka, ...)
    // Cache (Redis, ...)

}
