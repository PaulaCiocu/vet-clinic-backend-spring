package com.example.demo.entity;


import jakarta.persistence.Embeddable;

@Embeddable
public class SortCriteria {
    private String column;
    private String direction;
    public SortCriteria(String column, String direction) {
        this.column = column;
        this.direction = direction;
    }
    public SortCriteria() {}

    public String getColumn() {
        return column;
    }

    public void setColumn(String column) {
        this.column = column;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }
}
