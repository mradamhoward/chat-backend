package com.terabulk.seller.models;

import java.util.Objects;

public class Test {
    private String id;
    private String name;
    private String description;
    private int count;

    public Test(String id) {
        this.id = id;
    }

    public Test(String id, String name, String description, int count) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.count = count;
    }

    @Override
    public String toString() {
        return "Test{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", count=" + count +
                '}';
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Test test = (Test) o;
        return count == test.count && Objects.equals(id, test.id) && Objects.equals(name, test.name) && Objects.equals(description, test.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, count);
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
