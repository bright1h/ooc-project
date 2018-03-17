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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
