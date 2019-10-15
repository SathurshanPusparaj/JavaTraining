package com.cloudbox.models_service.models;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmpProjectTask that = (EmpProjectTask) o;
        return Objects.equals(empid, that.empid) &&
                Objects.equals(pid, that.pid) &&
                Objects.equals(tid, that.tid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(empid, pid, tid);
    }
}
