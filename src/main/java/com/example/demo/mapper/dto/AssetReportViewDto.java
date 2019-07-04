package com.example.demo.mapper.dto;

public class AssetReportViewDto {
    private String name;
    private Double[] data = new Double[12];

    public AssetReportViewDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double[] getData() {
        return data;
    }

    public void setData(Double[] data) {
        this.data = data;
    }
}
