package com.example.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity(name = "Customer") // best practice to specficy your table name
@Table(name = "customer", uniqueConstraints = {
	@UniqueConstraint(name = "customer_email_unqiue", columnNames = "email") })

public class Customer {

    @Id
    // for auto-increment
    @SequenceGenerator(name = "customer_sequence", sequenceName = "customer_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_sequence")
    @Column(name = "id", updatable = false)
    private Long id;
    @Column(name = "fname", nullable = false, columnDefinition = "TEXT")
    private String fname;
    @Column(name = "lname", nullable = false, columnDefinition = "TEXT")
    private String lname;
    @Column(name = "email", nullable = false, columnDefinition = "TEXT", unique = true)
    private String email;
    @Column(name = "streetname", nullable = false, columnDefinition = "TEXT")
    private String streetname;
    @Column(name = "streetno", nullable = false)
    private int streetno;
    @Column(name = "postcode", nullable = false)
    private int postcode;
    @Column(name = "phonenumber", nullable = false)
    private int phonenumber;
    @Column(name = "sex", nullable = false, columnDefinition = "TEXT")
    private String sex;

    public Customer() {
    }

    /**
     * @param id
     * @param fname
     * @param lname
     * @param email_address
     * @param streetname
     * @param streetno
     * @param postcode
     * @param phonenumber
     * @param sex
     */
    public Customer(String fname, String lname, String email_address, String streetname, int streetno, int postcode,
	    int phonenumber, String sex) {
	super();
	this.id = id;
	this.fname = fname;
	this.lname = lname;
	this.email = email_address;
	this.streetname = streetname;
	this.streetno = streetno;
	this.postcode = postcode;
	this.phonenumber = phonenumber;
	this.sex = sex;
    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public String getFname() {
	return fname;
    }

    public void setFname(String fname) {
	this.fname = fname;
    }

    public String getLname() {
	return lname;
    }

    public void setLname(String lname) {
	this.lname = lname;
    }

    public String getEmail_address() {
	return email;
    }

    public void setEmail(String email_address) {
	this.email = email_address;
    }

    public String getStreetname() {
	return streetname;
    }

    public void setStreetname(String streetname) {
	this.streetname = streetname;
    }

    public int getStreetno() {
	return streetno;
    }

    public void setStreetno(int streetno) {
	this.streetno = streetno;
    }

    public int getPostcode() {
	return postcode;
    }

    public void setPostcode(int postcode) {
	this.postcode = postcode;
    }

    public int getPhonenumber() {
	return phonenumber;
    }

    public void setPhonenumber(int phonenumber) {
	this.phonenumber = phonenumber;
    }

    public String getSex() {
	return sex;
    }

    public void setSex(String sex) {
	this.sex = sex;
    }

    @Override
    public String toString() {
	return "Customer [id=" + id + ", fname=" + fname + ", lname=" + lname + ", email_address=" + email
		+ ", streetname=" + streetname + ", streetno=" + streetno + ", postcode=" + postcode + ", phonenumber="
		+ phonenumber + ", sex=" + sex + "]";
    }

}
