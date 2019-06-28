package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AssetReportView {
    @Id
    private Long id;
    private String username;
    private String months;
    private Integer net_assets;
    private Integer net_income;
    private Integer income;
    private Integer expense;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMonths() {
        return months;
    }

    public void setMonths(String months) {
        this.months = months;
    }

    public int getNet_assets() {
        return net_assets;
    }

    public void setNet_assets(int net_assets) {
        this.net_assets = net_assets;
    }

    public int getNet_income() {
        return net_income;
    }

    public void setNet_income(int net_income) {
        this.net_income = net_income;
    }

    public int getIncome() {
        return income;
    }

    public void setIncome(int income) {
        this.income = income;
    }

    public int getExpense() {
        return expense;
    }

    public void setExpense(int expense) {
        this.expense = expense;
    }
}
