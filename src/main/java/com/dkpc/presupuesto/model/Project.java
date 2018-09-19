package com.dkpc.presupuesto.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "project")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 140)
    private String project_name;

    @NotBlank
    @Size(max = 140)
    private String project_type;

    @NotBlank
    @Size(max = 140)
    private int value;

    @NotBlank
    @Size(max = 140)
    private String createdby;

    @NotBlank
    @Size(max = 140)
    private String status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        id = id;
    }

    public String getProject_name() {
        return project_name;
    }

    public void setProject_name(String project_name) {
        this.project_name = project_name;
    }

    public String getProject_type() {
        return project_type;
    }

    public void setProject_type(String project_type) {
        this.project_type = project_type;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getCreated_by() {
        return createdby;
    }

    public void setCreated_by(String createdby) {
        this.createdby = createdby;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void addNewProject() {

    }

    public void removeProject() {

    }
}
