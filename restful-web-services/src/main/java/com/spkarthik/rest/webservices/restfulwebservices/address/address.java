package com.spkarthik.rest.webservices.restfulwebservices.address;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class address {

	@Id
	@GeneratedValue
	private Long id;
	
	private String username;
	private String fname;
	private String apartment;
	private String street;
	private int contact;
	private String city;
	private int zip;
	
	protected address() {
		
	}
	
	
	public address(Long id, String username, String fname,String apartment, String street, int contact, String city, int zip) {
		super();
		this.id = id;
		this.username = username;
		this.fname = fname;
		this.apartment = apartment;
		this.street = street;
		this.contact = contact;
		this.city = city;
		this.zip = zip;
	}


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getContact() {
		return contact;
	}
	public void setContact(int contact) {
		this.contact = contact;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getApartment() {
		return apartment;
	}
	public void setApartment( String apartment) {
		this.apartment = apartment;
	}
	public String getstreet() {
		return street;
	}
	public void setstreet(String street) {
		this.street = street;
	}
	public int getZip() {
		return zip;
	}
	public void setZip(int zip) {
		this.zip = zip;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		address other = (address) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
	
}
	

	
	