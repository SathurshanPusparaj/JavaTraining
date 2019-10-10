package com.cloudbox.models_service.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;


@Entity
@Table(name="project_task")
public class ProjectTask {

    @EmbeddedId
    private EmpProjectTask empProjectTask = new EmpProjectTask();

    @ManyToOne
    @MapsId("empid")
    @JoinColumn(name = "empid", referencedColumnName = "empid")
    @JsonIgnore
    private Employee employee;

    @ManyToOne
    @MapsId("pid")
    @JsonIgnore
    @JoinColumn(name = "pid", referencedColumnName = "pid")
    private Projects projects;

    @ManyToOne
    @MapsId("tid")
    @JsonIgnore
    @JoinColumn(name = "tid", referencedColumnName = "tid")
    private Task task;

    public ProjectTask() {
    }

    public ProjectTask(Employee employee, Projects projects, Task task) {
        this.employee = employee;
        this.projects = projects;
        this.task = task;
    }

    public void setEmpProjectTask(EmpProjectTask empProjectTask) {
        this.empProjectTask = empProjectTask;
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
