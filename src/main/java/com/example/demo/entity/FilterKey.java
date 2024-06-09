package com.example.demo.entity;


import jakarta.persistence.Embeddable;

@Embeddable
public class FilterKey {

    private String column;
    private String filterValue;

    public FilterKey(){}

    public FilterKey(String column, String filterValue) {
        this.column = column;
        this.filterValue = filterValue;
    }

    public String getColumn() {
        return column;
    }

    public void setColumn(String column) {
        this.column = column;
    }

    public String getFilterValue() {
        return filterValue;
    }

    public void setFilterValue(String value) {
        this.filterValue = value;
    }
}
