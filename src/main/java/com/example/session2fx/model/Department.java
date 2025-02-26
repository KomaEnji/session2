package com.example.session2fx.model;

public class Department {
    private final int departmet_id;
    private final String department;
    private final String description;
    private final int enclose_code;
    private final String director;

    public Department(int departmet_id, String department, String description, int enclose_code, String director) {
        this.departmet_id = departmet_id;
        this.department = department;
        this.description = description;
        this.enclose_code = enclose_code;
        this.director = director;
    }

    @Override
    public String toString(){
        return getDepartment();
    }

    public String getDirector() {
        return director;
    }

    public int getEnclose_code() {
        return enclose_code;
    }

    public String getDescription() {
        return description;
    }

    public String getDepartment() {
        return department;
    }

    public int getDepartmet_id() {
        return departmet_id;
    }

}
