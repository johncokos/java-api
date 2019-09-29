package com.codefellows.People.Models;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import java.util.*;

@DynamoDBTable(tableName = "people")
public class Person {

    private String id;
    private String name;
    private String pic;
    private int age;
    private ArrayList<HistoryItem> history;

    public Person() {
        this.history = new ArrayList<>();
    }

    public Person(String name) {
        this.name = name;
        this.history = new ArrayList<>();
    }

    @DynamoDBHashKey
    @DynamoDBAutoGeneratedKey
    public String getId() {
        return id;
    }
    public void setId(String id) { this.id = id; }

    @DynamoDBAttribute
    public String getName() { return this.name; }
    public void setName(String name) { this.name = name; }

    @DynamoDBAttribute
    public String getPic() {
        return pic;
    }
    public void setPic(String pic) {
        this.pic = pic;
    }

    @DynamoDBAttribute
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    // HISTORY
    @DynamoDBAttribute
    public ArrayList<HistoryItem> getHistory() {
        return history;
    }

    public void setHistory(ArrayList<HistoryItem> history) {
        this.history = history;
    }

    public void addToHistory(String action, String activity) {
        HistoryItem historyItem = new HistoryItem(action, activity);
        this.history.add(historyItem);
    }

}
