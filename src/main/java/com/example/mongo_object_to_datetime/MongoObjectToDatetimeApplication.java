package com.example.mongo_object_to_datetime;

import org.bson.types.ObjectId;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class MongoObjectToDatetimeApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(MongoObjectToDatetimeApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        ObjectId objectId = new ObjectId("65ae0eec0000000000000000"); // Replace with your ObjectId
        Date date = getDateTimeFromObjectId(objectId);
        ObjectId objectId1 = convertDateToObjectId(date);
        System.out.println("Initial ObjectId: " + objectId);
        System.out.println("Date from  ObjectId: " + date);
        System.out.println("ObjectId from Extracted Date: " + objectId1);
        Date dateTimeFromObjectId1 = getDateTimeFromObjectId(objectId1);
        System.out.println("Date from ObjectId1: " + dateTimeFromObjectId1);
    }

    public static Date getDateTimeFromObjectId(ObjectId objectId) {
        // Extract the timestamp from the ObjectId
        long timestamp = objectId.getTimestamp();

        // Convert timestamp to milliseconds
        long milliseconds = timestamp * 1000L;

        // Create a Date object from milliseconds
        return new Date(milliseconds);
    }

    public static ObjectId convertDateToObjectId(Date date) {
        // Extract timestamp in seconds
        long timestampInSeconds = date.getTime() / 1000;
        return new ObjectId(date);
    }
}
