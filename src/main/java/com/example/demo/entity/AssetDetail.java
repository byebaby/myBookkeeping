package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class AssetDetail extends BaseEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String type;
    private String message;
    private int amount;
    @ManyToOne
    @JsonIgnore
    private AssetMain accounting;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public AssetMain getAccounting() {
        return accounting;
    }

    public void setAccounting(AssetMain accounting) {
        this.accounting = accounting;
    }
}
