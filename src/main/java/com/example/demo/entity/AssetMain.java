package com.example.demo.entity;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class AssetMain extends BaseEntity {
    @Id
    @GeneratedValue
    private Long id;
    private Long userId;
    private LocalDate createDate;
    @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinColumn(name = "asset_main_id")
    private List<AssetDetail> assetDetail;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public List<AssetDetail> getAssetDetail() {
        return assetDetail;
    }

    public void setAssetDetail(List<AssetDetail> assetDetail) {
        this.assetDetail = assetDetail;
    }
}
