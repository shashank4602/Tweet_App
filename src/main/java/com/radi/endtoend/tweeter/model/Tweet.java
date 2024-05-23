package com.radi.endtoend.tweeter.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Tweet {
    @Id
    @GeneratedValue
    private Integer id;

    @Column
    private String message;

    public Integer getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
