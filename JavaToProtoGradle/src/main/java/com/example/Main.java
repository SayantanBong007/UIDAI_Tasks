package com.example;

import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        // Create Person object
        PersonProto.Person person = PersonProto.Person.newBuilder()
                .setName("Alice")
                .setAge(30)
                .setBalanceAmount(10000.50)
                .addInterests("Traveling")
                .addInterests("Music")
                .build();

        // Serialize to a Protobuf file
        try (FileOutputStream fos = new FileOutputStream("person.protobuf")) {
            person.writeTo(fos);
            System.out.println("Person object serialized to person.protobuf");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Deserialize back
        try (FileInputStream fis = new FileInputStream("person.protobuf")) {
            PersonProto.Person deserialized = PersonProto.Person.parseFrom(fis);
            System.out.println("Deserialized Person:");
            System.out.println("Name: " + deserialized.getName());
            System.out.println("Age: " + deserialized.getAge());
            System.out.println("Balance: " + deserialized.getBalanceAmount());
            System.out.println("Interests: " + deserialized.getInterestsList());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
} 