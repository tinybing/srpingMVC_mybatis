package com.ww.model;

import java.io.Serializable;
import javax.persistence.*;

public class Dept implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String dept;

    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        return "Dept{" +
              "id=" + id +
              ", dept='" + dept + '\'' +
              '}';
    }

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return dept
     */
    public String getDept() {
        return dept;
    }

    /**
     * @param dept
     */
    public void setDept(String dept) {
        this.dept = dept;
    }
}