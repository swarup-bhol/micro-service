package com.ms.model;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long userId;

	@NotEmpty
	private String fullName;

	@Column(unique = true)
	@Email
	@NotEmpty
	private String userEmail;


	private String userMobile;

	private Date dateOfBirth;


	@NotEmpty
	private String userPassword;

	@JsonIgnore
	private String mobVerifficationCode;

	@JsonIgnore
	private String emailVerifficationCode;

	private boolean isMobileVerrified;

	private boolean isEmailVerrified;

	@JsonIgnore
	@CreationTimestamp
	private Timestamp profileCreationTime;

	@JsonIgnore
	@UpdateTimestamp
	private Timestamp profileUpdationTime;

	private String instituteName;

	private String profilePicPath;

	private String userDocumentPath;

	@UpdateTimestamp
	private Timestamp docUploadTime;

	private boolean isDocUploaded;

	private long grade;

	private long professionId;

	private long specializationId;

	private long detailsSpecializationId;

	private String profilePicId;

	private String documentId;

	private boolean recordStatus;

}
