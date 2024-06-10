package com.example.demo.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="savedSearch")
public class SavedSearch {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ElementCollection
    private List<FilterKey> filterKeys;

    @ElementCollection
    private List<SortCriteria> sortCriteria;


    @ElementCollection
    private List<ColumnVisibility> columnVisibility;

    private Long userID;

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public SavedSearch(String name, List<FilterKey> filterKeys, List<SortCriteria> sortCriteria, List<ColumnVisibility> columnVisibility, Long userID) {
        this.name = name;
        this.filterKeys = filterKeys;
        this.sortCriteria = sortCriteria;
        this.columnVisibility = columnVisibility;
        this.userID = userID;
    }

    public SavedSearch() {}


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<FilterKey> getFilterKeys() {
        return filterKeys;
    }

    public void setFilterKeys(List<FilterKey> filterKeys) {
        this.filterKeys = filterKeys;
    }

    public List<SortCriteria> getSortCriteria() {
        return sortCriteria;
    }

    public void setSortCriteria(List<SortCriteria> sortCriteria) {
        this.sortCriteria = sortCriteria;
    }

    public List<ColumnVisibility> getColumnVisibility() {
        return columnVisibility;
    }

    public void setColumnVisibility(List<ColumnVisibility> columnVisibility) {
        this.columnVisibility = columnVisibility;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
