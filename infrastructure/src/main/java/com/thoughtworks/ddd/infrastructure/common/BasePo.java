package com.thoughtworks.ddd.infrastructure.common;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public abstract class BasePo {
    @Id
    @GeneratedValue(generator = "jpa-uuid")
    private String id;
}
