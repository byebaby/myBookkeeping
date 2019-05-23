package com.example.demo.entity;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Accounting extends BaseEntity {
    @Id
    @GeneratedValue
    private Long id;
    private Long userId;
    private LocalDate createDate;
    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "accounting",fetch = FetchType.EAGER)
    private List<AccountingDetail> accountingDetail;

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

    public List<AccountingDetail> getAccountingDetail() {
        return accountingDetail;
    }

    public void setAccountingDetail(List<AccountingDetail> accountingDetail) {
        this.accountingDetail = accountingDetail;
    }
}
