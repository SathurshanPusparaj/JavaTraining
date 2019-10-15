package com.cloudbox.models_service.models;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tid;

    private String taskName;

    private String taskCatogary;

    private Date created;

    @OneToMany(mappedBy = "task",cascade = CascadeType.ALL)
    private List<ProjectTask> tasks;

    public Task() {
    }

    public Task(Integer tid){
        this.tid=tid;
    }

    public List<ProjectTask> getTasks() {
        return tasks;
    }

    public void setTasks(List<ProjectTask> tasks) {
        this.tasks = tasks;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskCatogary() {
        return taskCatogary;
    }

    public void setTaskCatogary(String taskCatogary) {
        this.taskCatogary = taskCatogary;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    @Override
    public String toString() {
        return "Task{" +
                "tid=" + tid +
                ", taskName='" + taskName + '\'' +
                ", taskCatogary='" + taskCatogary + '\'' +
                ", created=" + created +
                ", tasks=" + tasks +
                '}';
    }
}
