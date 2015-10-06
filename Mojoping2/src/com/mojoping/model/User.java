package com.mojoping.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity(name="user")
@Table(name="user")
public class User {
	
	@Id
	@Column(name="user_id")
	@GeneratedValue
	private Integer user_id;
	
	@Column(name="username")
	@Size(min=4, max=20)
	private String username;
	
	@Column(name="firstname")
	@Size(min=2, max=30)
	private String firstname;
	
	@Column(name="lastname")
	@Size(min=2, max=30)
	private String lastname;
	
	@Column(name="gender")
	@NotEmpty
	private String gender;
	
	@Column(name="email")
	@NotEmpty @Email
	private String email;
	
	@Column(name="password")
	@Size(min=6, max=30)
	private String password;
	
	@Column(name="contact_number")
	@Size(min=10, max=15)
	private String contact_number;
	
	@Column(name="date_of_birth")
	@DateTimeFormat(pattern="MM/dd/yyyy")
	@NotNull @Past
	private Date date_of_birth;
	
	@Column(name="skills")
	private String skills;
	
	@Column(name="occupation")
	@NotEmpty
	private String occupation;
	
	@Column(name="address_1")
	@NotEmpty
	private String address_1;
	
	@Column(name="address_2")
	private String address_2;
	
	@Column(name="city")
	@NotEmpty
	private String city;
	
	@Column(name="state")
	@NotEmpty
	private String state;
	
	@Column(name="zipcode")
	@Size(min=5,max=5)
	private String zipcode;
	
	@Column(name="country")
	@NotEmpty
	private String country;
	
	@Column(name="twitter_url")
	private String twitter_url;
	
	@Column(name="facebook_url")
	private String facebook_url;
	
	@Column(name="profile_pic_path")
	private String profile_pic_path;
	
	@Column(name="user_bought")
	private String user_bought;
	
	@Column(name="enabled")
	private boolean enabled;
	
	
	@Column(name="user_money")
	private Double user_money;

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getContact_number() {
		return contact_number;
	}

	public void setContact_number(String contact_number) {
		this.contact_number = contact_number;
	}

	public Date getDate_of_birth() {
		return date_of_birth;
	}

	public void setDate_of_birth(Date date_of_birth) {
		this.date_of_birth = date_of_birth;
	}
	
	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getAddress_1() {
		return address_1;
	}

	public void setAddress_1(String address_1) {
		this.address_1 = address_1;
	}

	public String getAddress_2() {
		return address_2;
	}

	public void setAddress_2(String address_2) {
		this.address_2 = address_2;
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

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getTwitter_url() {
		return twitter_url;
	}

	public void setTwitter_url(String twitter_url) {
		this.twitter_url = twitter_url;
	}

	public String getFacebook_url() {
		return facebook_url;
	}

	public void setFacebook_url(String facebook_url) {
		this.facebook_url = facebook_url;
	}

	public String getProfile_pic_path() {
		return profile_pic_path;
	}

	public void setProfile_pic_path(String profile_pic_path) {
		this.profile_pic_path = profile_pic_path;
	}

	public Double getUser_money() {
		return user_money;
	}

	public void setUser_money(Double user_money) {
		this.user_money = user_money;
	}

	public String getUser_bought() {
		return user_bought;
	}

	public void setUser_bought(String user_bought) {
		this.user_bought = user_bought;
	}
	
	
	
}
