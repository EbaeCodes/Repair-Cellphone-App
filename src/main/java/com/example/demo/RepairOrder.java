package com.example.demo;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity(name = "RepairOrder") // best practice to specficy your table name
@Table(name = "RepairOrder")

public class RepairOrder {
    @Id
    // for auto-increment
    @SequenceGenerator(name = "repairOrder_sequence", sequenceName = "repairOrder_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "repairOrder_sequence")
    @Column(name = "OrderId", updatable = false)
    private long orderId;
    @Column(name = "repairStatus", nullable = false)
    private String repairStatus;
    @Column(name = "ProblemDescription", nullable = false)
    private String problemDescription;
    @Column(name = "repairDueDate")
    private Date repairDueDate;
    @Column(name = "dateRegister")
    private Date dateRegister;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Dnumber", referencedColumnName = "DNumber")
    private Department department;

    public RepairOrder() {
    }

    public RepairOrder(long orderId, String repairStatus, String problemDescription, int dnumber, Date repairDueDate,
	    Date dateRegister) {
	super();
	this.orderId = orderId;
	this.repairStatus = repairStatus;
	this.problemDescription = problemDescription;
	this.repairDueDate = repairDueDate;
	this.dateRegister = dateRegister;
    }

    public long getOrderId() {
	return orderId;
    }

    public void setOrderId(long orderId) {
	this.orderId = orderId;
    }

    public String getRepairStatus() {
	return repairStatus;
    }

    public void setRepairStatus(String repairStatus) {
	this.repairStatus = repairStatus;
    }

    public String getProblemDescription() {
	return problemDescription;
    }

    public void setProblemDescription(String problemDescription) {
	this.problemDescription = problemDescription;
    }

    public void setDnumber(int dnumber) {
	dnumber = dnumber;
    }

    public Date getRepairDueDate() {
	return repairDueDate;
    }

    public void setRepairDueDate(Date repairDueDate) {
	this.repairDueDate = repairDueDate;
    }

    public Date getDateRegister() {
	return dateRegister;
    }

    public void setDateRegister(Date dateRegister) {
	this.dateRegister = dateRegister;
    }

}
