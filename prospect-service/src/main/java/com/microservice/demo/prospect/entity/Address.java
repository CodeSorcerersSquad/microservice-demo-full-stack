package com.microservice.demo.prospect.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import io.swagger.annotations.ApiModel;

@ApiModel
@Entity
public class Address {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	/**
     * The number.
     * This will be the flat, house number or house name.
     */
	private int number;
	
	/**
	 * The name of the street
	 */
	private String street;
	
	/**
	 * The zip code of the address
	 */
	private String zipcode;
	
	/**
	 * Complement address information, Ex: apartment.
	 */
	private String complement;
	
	/**
	 * The name of the city
	 */
	private String city;
	
	/**
	 * The name of the statye
	 */
	private String state;
	
	
	/**
	 * The name of the country
	 */
	private String country;

	
	public Address() {
		super();
	}

	public Address(int number, String street, String zipcode, String complement, String city, String state,
			String country) {
		super();
		this.number = number;
		this.street = street;
		this.zipcode = zipcode;
		this.complement = complement;
		this.city = city;
		this.state = state;
		this.country = country;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getNumber() {
		return number;
	}


	public void setNumber(int number) {
		this.number = number;
	}


	public String getStreet() {
		return street;
	}


	public void setStreet(String street) {
		this.street = street;
	}


	public String getZipcode() {
		return zipcode;
	}


	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}


	public String getComplement() {
		return complement;
	}


	public void setComplement(String complement) {
		this.complement = complement;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", number=" + number + ", street=" + street + ", zipcode=" + zipcode
				+ ", complement=" + complement + ", city=" + city + ", state=" + state + ", country=" + country + "]";
	}
	
}
