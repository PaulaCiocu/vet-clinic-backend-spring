package com.example.demo.entity;

import jakarta.persistence.ElementCollection;

import java.util.List;

public class SavedSearchDTO {

    private Long id;
    private String name;
    private List<FilterKey> filterKeys;
    private List<SortCriteria> sortCriteria;
    private List<ColumnVisibility> columnVisibility;
    private Long userID;

    public Long getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Long pageNumber) {
        this.pageNumber = pageNumber;
    }

    private Long pageNumber;

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public SavedSearchDTO(Long id, String name, List<FilterKey> filterKeys, List<SortCriteria> sortCriteria, List<ColumnVisibility> columnVisibility, Long userID) {
        this.id = id;
        this.name = name;
        this.filterKeys = filterKeys;
        this.sortCriteria = sortCriteria;
        this.columnVisibility = columnVisibility;
        this.userID = userID;
    }
    public SavedSearchDTO() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
}
