DROP USERS;
DROP STUDENT;
DROP FACULTY;
DROP COURSE;
DROP INVOICE;
DROP FINANCIAL;
DROP DEPARTMENT;
DROP TRANSCRIPTS;
DROP REGISTRATION;
DROP PROGRAM;


CREATE TABLE DEPARTMENT (
	DEPT_ID INT NOT NULL AUTO_INCREMENT,
	DEPT_TITLE VARCHAR(255) NOT NULL,
	DEPT_ABR VARCHAR(10) NOT NULL,
	PRIMARY KEY (DEPT_ID)
);

CREATE TABLE PROGRAM (
	PROGRAM_ID INT NOT NULL AUTO_INCREMENT,
	PROGRAM_TITLE VARCHAR(255) NOT NULL,
	DEPT_ID INT NOT NULL,
	PRIMARY KEY (PROGRAM_ID),
	FOREIGN KEY (DEPT_ID) REFERENCES DEPARTMENT(DEPT_ID)
);

CREATE TABLE FACULTY (
	FACULTY_ID INT NOT NULL AUTO_INCREMENT,
	DEPT_ID INT,
	PRIMARY KEY (FACULTY_ID),
	FOREIGN KEY (DEPT_ID) REFERENCES DEPARTMENT(DEPT_ID)
);

CREATE TABLE STUDENT (
	STU_ID INT NOT NULL AUTO_INCREMENT,
	PROGRAM_ID INT NOT NULL,
	PRIMARY KEY (STU_ID),
	FOREIGN KEY (PROGRAM_ID) REFERENCES PROGRAM(PROGRAM_ID)
);

CREATE TABLE USERS (
	USER_ID INT NOT NULL AUTO_INCREMENT,
	STU_ID INT,
	FACULTY_ID INT,
	USER_FIRST_NAME VARCHAR(255) NOT NULL,
	USER_LAST_NAME VARCHAR(255) NOT NULL,
	USER_ADDRESS VARCHAR(255) NOT NULL,
	USER_CITY VARCHAR(255) NOT NULL,
	USER_STATE VARCHAR(255) NOT NULL,
	USER_ZIP INT NOT NULL,
	USER_COUNTRY VARCHAR(255) NOT NULL,
	USER_PASSWORD VARCHAR(255) NOT NULL,
	USER_CREATION_DATE DATE NOT NULL,
	PRIMARY KEY (USER_ID),
	FOREIGN KEY (STU_ID) REFERENCES STUDENT(STU_ID),
	FOREIGN KEY (FACULTY_ID) REFERENCES FACULTY(STU_ID)
);

CREATE TABLE COURSE (
	COURSE_ID INT NOT NULL AUTO_INCREMENT,
	COURSE_TITLE VARCHAR(255) NOT NULL,
	COURSE_CREDITS INT NOT NULL,
	COURSE_COST INT NOT NULL,
	DEPT_ID INT NOT NULL,
	PRIMARY KEY (COURSE_ID),
	FOREIGN KEY (DEPT_ID) REFERENCES DEPARTMENT(DEPT_ID)
);

CREATE TABLE REGISTRATION (
	REG_CODE VARCHAR(255) NOT NULL,
	COURSE_ID INT NOT NULL,
	STU_ID INT NOT NULL,
	PRIMARY KEY (REG_CODE),
	FOREIGN KEY (COURSE_ID) REFERENCES COURSE(COURSE_ID),
	FOREIGN KEY (STU_ID) REFERENCES STUDENT(STU_ID)
);

CREATE TABLE TRANSCRIPTS (
	STU_ID INT NOT NULL,
	REG_CODE VARCHAR(255) NOT NULL,
	TRANSCRIPT_GPA INT,
	PRIMARY KEY (STU_ID, REG_CODE),
	FOREIGN KEY (STU_ID) REFERENCES STUDENT(STU_ID),
	FOREIGN KEY (REG_CODE) REFERENCES REGISTRATION(REG_CODE)
);

CREATE TABLE INVOICE (
	INVOICE_ID INT NOT NULL AUTO_INCREMENT,
	STU_ID INT NOT NULL,
	INVOICE_PAYMENT INT NOT NULL,
	INVOICE_DATE DATE NOT NULL,
	PRIMARY KEY (INVOICE_ID),
	FOREIGN KEY (STU_ID) REFERENCES STUDENT(STU_ID)
);

CREATE TABLE FINANCIAL (
	STU_ID INT NOT NULL,
	CREDITCARD_NUM LONG NOT NULL,
	EXP_DATE DATE NOT NULL,
	BILLING_ADDRESS VARCHAR(255) NOT NULL,
	BILLING_CITY VARCHAR(255) NOT NULL,
	BILLING_STATE VARCHAR(255) NOT NULL,
	BILLING_ZIP INT NOT NULL,
	BILLING_NAME VARCHAR(255) NOT NULL,
	BALANCE INT,
	PRIMARY KEY (STU_ID, CREDITCARD_NUM),
	FOREIGN KEY (STU_ID) REFERENCES STUDENT(STU_ID)
);