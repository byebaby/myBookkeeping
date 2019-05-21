package com.example.demo.entity;


import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Accounting {
    @Id
    @GeneratedValue
    private int id;
    private Long userId;
    private LocalDate createDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }
}
