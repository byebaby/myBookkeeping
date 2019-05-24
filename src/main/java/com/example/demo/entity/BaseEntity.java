package com.example.demo.entity;

import org.hibernate.annotations.GenerationTime;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.annotation.Generated;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
abstract class BaseEntity {
    //    @CreatedBy
//    private User createdBy;// 创建人
//    @LastModifiedBy
//    private User lastModifiedBy;  // 修改人
    @CreatedDate
    private LocalDateTime createdDate;   // 创建时间
    @LastModifiedDate
    private LocalDateTime lastModifiedDate;   // 修改时间

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDateTime getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(LocalDateTime lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }
}
