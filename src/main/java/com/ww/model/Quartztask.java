package com.ww.model;

import java.io.Serializable;
import javax.persistence.*;

public class Quartztask implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String name;

    private String groupname;

    private String expression;

    private String status;

    private String description;

    private String type;

    private String updateby;

    private String updateat;

    private static final long serialVersionUID = 1L;

    /**
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return groupname
     */
    public String getGroupname() {
        return groupname;
    }

    /**
     * @param groupname
     */
    public void setGroupname(String groupname) {
        this.groupname = groupname;
    }

    /**
     * @return expression
     */
    public String getExpression() {
        return expression;
    }

    /**
     * @param expression
     */
    public void setExpression(String expression) {
        this.expression = expression;
    }

    /**
     * @return status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return updateby
     */
    public String getUpdateby() {
        return updateby;
    }

    /**
     * @param updateby
     */
    public void setUpdateby(String updateby) {
        this.updateby = updateby;
    }

    /**
     * @return updateat
     */
    public String getUpdateat() {
        return updateat;
    }

    /**
     * @param updateat
     */
    public void setUpdateat(String updateat) {
        this.updateat = updateat;
    }
}