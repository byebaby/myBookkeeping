package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
    private double amount;
    @ManyToOne
    @JsonIgnoreProperties("assetDetail")
    private AssetMain assetMain;

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


    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public AssetMain getAssetMain() {
        return assetMain;
    }

    public void setAssetMain(AssetMain assetMain) {
        this.assetMain = assetMain;
    }
}
