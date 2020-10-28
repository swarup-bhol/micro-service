package com.ms.model;

import java.sql.Date;
import java.sql.Timestamp;




import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class User {
	
	private long userId;

	private String fullName;

	private String userEmail;

	private String userMobile;

	private Date dateOfBirth;


	private String userPassword;

	private String mobVerifficationCode;

	private String emailVerifficationCode;

	private boolean isMobileVerrified;

	private boolean isEmailVerrified;

	private Timestamp profileCreationTime;

	private Timestamp profileUpdationTime;

	private String instituteName;

	private String profilePicPath;

	private String userDocumentPath;

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
