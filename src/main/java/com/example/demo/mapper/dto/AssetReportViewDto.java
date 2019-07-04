package com.example.demo.mapper.dto;

import java.util.ArrayList;
import java.util.List;

public class AssetReportViewDto {
    private String name;
    private List<Object> data = new ArrayList<>();

    public AssetReportViewDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Object> getData() {
        return data;
    }

    public void setData(List<Object> data) {
        this.data = data;
    }

    public void add(String name, Double y, Boolean drilldown) {
        data.add(new Data(name, y, drilldown));
    }

    class Data {
        private String name;
        private Double y;
        private Boolean drilldown;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Double getY() {
            return y;
        }

        public void setY(Double y) {
            this.y = y;
        }

        public Boolean getDrilldown() {
            return drilldown;
        }

        public void setDrilldown(Boolean drilldown) {
            this.drilldown = drilldown;
        }

        Data(String name, Double y, Boolean drilldown) {
            this.name = name;
            this.y = y;
            this.drilldown = drilldown;
        }
    }
}
