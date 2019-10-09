package com.cloudbox.models_service.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name="project_task")
public class ProjectTask implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn
    @JsonIgnore
    private Employee employee;

    @ManyToOne
    @JoinColumn
    @JsonIgnore
    private Projects projects;

    @ManyToOne
    @JoinColumn
    @JsonIgnore
    private Task task;

    public ProjectTask() {
    }

    public ProjectTask(Employee employee, Projects projects, Task task) {
        this.employee = employee;
        this.projects = projects;
        this.task = task;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Projects getProjects() {
        return projects;
    }

    public void setProjects(Projects projects) {
        this.projects = projects;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
