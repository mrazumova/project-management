package by.bsu.famcs.dto;

import by.bsu.famcs.entity.Post;

public class ManagerDto {

    private String id;

    private String surname;

    private String name;

    private Post post;

    private String cvLink;

    private int workload;

    private int salary;

    private UnitDto unit;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public String getCvLink() {
        return cvLink;
    }

    public void setCvLink(String cvLink) {
        this.cvLink = cvLink;
    }

    public int getWorkload() {
        return workload;
    }

    public void setWorkload(int workload) {
        this.workload = workload;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public UnitDto getUnit() {
        return unit;
    }

    public void setUnit(UnitDto unit) {
        this.unit = unit;
    }
}
