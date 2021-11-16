package com.terabulk.seller.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "addresses")
public class Address {
	@Id
	private String id;
	private String addressLine1Delivery;
	private String addressLine2Delivery;
	private String cityTownDelivery;
	private String countyDelivery;
	private String countryDelivery;
	private String postCodeDelivery;
	private String addressLine1Billing;
	private String addressLine2Billing;
	private String cityTownBilling;
	private String countyBilling;
	private String countryBilling;
	private String postCodeBilling;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAddressLine1Delivery() {
		return addressLine1Delivery;
	}
	public void setAddressLine1Delivery(String addressLine1Delivery) {
		this.addressLine1Delivery = addressLine1Delivery;
	}
	public String getAddressLine2Delivery() {
		return addressLine2Delivery;
	}
	public void setAddressLine2Delivery(String addressLine2Delivery) {
		this.addressLine2Delivery = addressLine2Delivery;
	}
	public String getCityTownDelivery() {
		return cityTownDelivery;
	}
	public void setCityTownDelivery(String cityTownDelivery) {
		this.cityTownDelivery = cityTownDelivery;
	}
	public String getCountyDelivery() {
		return countyDelivery;
	}
	public void setCountyDelivery(String countyDelivery) {
		this.countyDelivery = countyDelivery;
	}
	public String getCountryDelivery() {
		return countryDelivery;
	}
	public void setCountryDelivery(String countryDelivery) {
		this.countryDelivery = countryDelivery;
	}
	public String getPostCodeDelivery() {
		return postCodeDelivery;
	}
	public void setPostCodeDelivery(String postCodeDelivery) {
		this.postCodeDelivery = postCodeDelivery;
	}
	public String getAddressLine1Billing() {
		return addressLine1Billing;
	}
	public void setAddressLine1Billing(String addressLine1Billing) {
		this.addressLine1Billing = addressLine1Billing;
	}
	public String getAddressLine2Billing() {
		return addressLine2Billing;
	}
	public void setAddressLine2Billing(String addressLine2Billing) {
		this.addressLine2Billing = addressLine2Billing;
	}
	public String getCityTownBilling() {
		return cityTownBilling;
	}
	public void setCityTownBilling(String cityTownBilling) {
		this.cityTownBilling = cityTownBilling;
	}
	public String getCountyBilling() {
		return countyBilling;
	}
	public void setCountyBilling(String countyBilling) {
		this.countyBilling = countyBilling;
	}
	public String getCountryBilling() {
		return countryBilling;
	}
	public void setCountryBilling(String countryBilling) {
		this.countryBilling = countryBilling;
	}
	public String getPostCodeBilling() {
		return postCodeBilling;
	}
	public void setPostCodeBilling(String postCodeBilling) {
		this.postCodeBilling = postCodeBilling;
	}
}
