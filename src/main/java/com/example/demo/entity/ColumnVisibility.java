package com.example.demo.entity;


import jakarta.persistence.Embeddable;

@Embeddable
public class ColumnVisibility {
    private String column;
    private boolean visible;
    public ColumnVisibility() {}
    public ColumnVisibility(String column, boolean visible) {
        this.column = column;
        this.visible = visible;
    }

    public String getColumn() {
        return column;
    }

    public void setColumn(String column) {
        this.column = column;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
}
