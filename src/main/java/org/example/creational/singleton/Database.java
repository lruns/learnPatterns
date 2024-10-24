package org.example.creational.singleton;

public class Database {
    private static Database instance;
    public String testValue;

    private Database(String testValue) {
        this.testValue = testValue;
    }

    public static Database getInstance(String testValue) {
        if (instance != null) {
            return instance;
        }
        synchronized (Database.class) {
            if (instance == null) {
                instance = new Database(testValue);
            }
            return instance;
        }
    }

    public String query(String sql) {
        return "Will complete next request: " + sql;
    }
}
