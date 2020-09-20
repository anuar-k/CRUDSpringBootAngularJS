package org.crudapp.SpringBootAngularJS.model;

public class UserForm {
    private Long id;
    private String no;
    private String name;
    private String position;

    public UserForm() {
    }

    public UserForm(Long id, String no, String name, String position) {
        this.id = id;
        this.no = no;
        this.name = name;
        this.position = position;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}