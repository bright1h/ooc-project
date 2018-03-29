package com.mapringg.bab.models;

import javax.persistence.*;

/**
 * @author mapring
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class MenuType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(insertable = false, updatable = false)
    private String dtype;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDtype() {
        return dtype;
    }

    public void setDtype(String dtype) {
        this.dtype = dtype;
    }
}
