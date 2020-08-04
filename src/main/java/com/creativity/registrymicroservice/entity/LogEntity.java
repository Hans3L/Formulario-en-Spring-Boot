package com.creativity.registrymicroservice.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "TBL_LOG")
public class LogEntity implements Serializable {

    private static final long serialVersionUID = 7547858662102147427L;

    @Id
    @GeneratedValue
    @Column(name = "LogId")
    private Long id;

    @Column(name = "Date")
    private Date date;

    @Column(name = "Details")
    private String details;

    @Column(name = "UserName")
    private String username;

    @Column(name = "Url")
    private String url;

    public LogEntity(Date date, String details, String username, String url) {
        this.date = date;
        this.details = details;
        this.username = username;
        this.url = url;
    }

    public LogEntity(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
