package com.cloudbox.models_service.models;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class EmpProjectTask implements Serializable {

    private Integer empid;

    private Integer pid;

    private Integer tid;

    public EmpProjectTask() {
    }

    public EmpProjectTask(Integer empid, Integer pid, Integer tid) {
        this.empid = empid;
        this.pid = pid;
        this.tid = tid;
    }

    public Integer getEmpid() {
        return empid;
    }

    public void setEmpid(Integer empid) {
        this.empid = empid;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }
}
