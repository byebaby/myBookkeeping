package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table
public class AccountingView {
    @Id
    private int id;
    private int userId;
    private String username;
    private LocalDate createDate;
    private int assets;
    private int debt;
    private int netAssets;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public int getAssets() {
        return assets;
    }

    public void setAssets(int assets) {
        this.assets = assets;
    }

    public int getDebt() {
        return debt;
    }

    public void setDebt(int debt) {
        this.debt = debt;
    }

    public int getNetAssets() {
        return netAssets;
    }

    public void setNetAssets(int netAssets) {
        this.netAssets = netAssets;
    }
}
