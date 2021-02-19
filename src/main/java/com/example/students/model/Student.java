package com.example.students.model;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.example.students.StudentsApplication;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@Entity
@Table(name="students")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"},
        allowGetters = true)
public class Student 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	

	  @NotBlank
    @Size(min=5,message="The name should have atleast 2 characters")
	private String name;
	
	
	
    @NotBlank
	private String city;
	

	@Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern="yyy-mm-dd  HH:mm:ss")

	private Date createdAt;
	
	
	
	@Column(nullable = false,updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
	
	@JsonFormat(pattern="yyy-mm-dd  HH:mm:ss")
   
	private Date ubdatedAt;
	
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}





	public String getCity() {
		return city;
	}





	public void setCity(String city) {
		this.city = city;
	}





	public Date getCreatedAt() {
		return createdAt;
	}





	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}





	public Date getUbdatedAt() {
		return ubdatedAt;
	}





	public void setUbdatedAt(Date ubdatedAt) {
		this.ubdatedAt = ubdatedAt;
	}

}
	
