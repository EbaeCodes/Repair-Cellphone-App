package com.example.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity(name = "Department") // best practice to specficy your table name
@Table(name = "Department")
public class Department {
    @Id
    // for auto-increment
    @SequenceGenerator(name = "repairOrder_sequence", sequenceName = "repairOrder_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "repairOrder_sequence")
    @Column(name = "OrderId", updatable = false)
    private Long dNumber;
    @Column(name = "dName", nullable = false)
    private String dName;
    @Column(name = "service", nullable = false)
    private String service;

    public Department() {
    }

    public Department(String dName, Long dNumber, String service) {
	super();
	this.dName = dName;
	this.dNumber = dNumber;
	this.service = service;
    }

    public String getdName() {
	return dName;
    }

    public void setdName(String dName) {
	this.dName = dName;
    }

    public Long getdNumber() {
	return dNumber;
    }

    public void setdNumber(Long dNumber) {
	this.dNumber = dNumber;
    }

    public String getService() {
	return service;
    }

    public void setService(String service) {
	this.service = service;
    }

}
