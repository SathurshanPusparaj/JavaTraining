package com.cloudbox.models_service.models;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
public class Projects {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pid;

    private String projectName;

    private String projectDescription;

    private Date startDate;

    private Date endDate;

    private String status;

    @OneToMany(mappedBy = "projects",cascade = CascadeType.ALL)
    private List<ProjectTask> projectTasks;

    public Projects() {
    }

    public Projects(Integer pid){
        this.pid = pid;
    }

    public List<ProjectTask> getProjectTasks() {
        return projectTasks;
    }

    public void setProjectTasks(List<ProjectTask> projectTasks) {
        this.projectTasks = projectTasks;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Projects{" +
                "pid=" + pid +
                ", projectName='" + projectName + '\'' +
                ", projectDescription='" + projectDescription + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", status='" + status + '\'' +
                ", projectTasks=" + projectTasks +
                '}';
    }
}
