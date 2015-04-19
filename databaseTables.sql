DELETE FROM REGISTRATION;
DELETE FROM SECTION;
DELETE FROM FACULTY;
DELETE FROM STUDENT;
DELETE FROM INVOICE;
DELETE FROM FINANCIAL;
DELETE FROM COURSE;
DELETE FROM USERS;
DELETE FROM PROGRAM;
DELETE FROM DEPARTMENT;

DROP TABLE IF EXISTS REGISTRATION;
DROP TABLE IF EXISTS SECTION;
DROP TABLE IF EXISTS COURSE;
DROP TABLE IF EXISTS FACULTY;
DROP TABLE IF EXISTS INVOICE;
DROP TABLE IF EXISTS FINANCIAL;
DROP TABLE IF EXISTS STUDENT;
DROP TABLE IF EXISTS PROGRAM;
DROP TABLE IF EXISTS DEPARTMENT;
DROP TABLE IF EXISTS USERS;

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

--default password 5ece6873250c932328313d034f2517a9 which is 'abc123'
CREATE TABLE USERS (
	USER_ID INT NOT NULL AUTO_INCREMENT,
	USER_FIRST_NAME VARCHAR(255) NOT NULL,
	USER_LAST_NAME VARCHAR(255) NOT NULL,
	USER_ADDRESS VARCHAR(255) NOT NULL,
	USER_CITY VARCHAR(255) NOT NULL,
	USER_STATE VARCHAR(255) NOT NULL,
	USER_ZIP INT NOT NULL,
	USER_COUNTRY VARCHAR(255) NOT NULL,
	USER_PASSWORD VARCHAR(255) NOT NULL DEFAULT '5ece6873250c932328313d034f2517a9',
	USER_CREATION_DATE TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	USERNAME VARCHAR(255) NOT NULL,
	USER_EMAIL VARCHAR(255) NOT NULL,
	USER_DOB DATE NOT NULL, 
	PRIMARY KEY (USER_ID)
);

CREATE TABLE FACULTY (
	FACULTY_ID INT NOT NULL AUTO_INCREMENT,
	USER_ID INT NOT NULL,
	DEPT_ID INT,
	PRIMARY KEY (FACULTY_ID),
	FOREIGN KEY (USER_ID) REFERENCES USERS(USER_ID),
	FOREIGN KEY (DEPT_ID) REFERENCES DEPARTMENT(DEPT_ID)
);

CREATE TABLE STUDENT (
	STU_ID INT NOT NULL AUTO_INCREMENT,
	USER_ID INT NOT NULL,
	PROGRAM_ID INT NOT NULL,
	PRIMARY KEY (STU_ID),
	FOREIGN KEY (USER_ID) REFERENCES USERS(USER_ID),
	FOREIGN KEY (PROGRAM_ID) REFERENCES PROGRAM(PROGRAM_ID)
);

CREATE TABLE COURSE (
	COURSE_ID INT NOT NULL AUTO_INCREMENT,
	COURSE_TITLE VARCHAR(255) NOT NULL,
	COURSE_DESCRIPT LONGTEXT,
	COURSE_CREDITS INT NOT NULL,
	COURSE_COST INT NOT NULL,
	DEPT_ID INT NOT NULL,
	PRIMARY KEY (COURSE_ID, DEPT_ID),
	FOREIGN KEY (DEPT_ID) REFERENCES DEPARTMENT(DEPT_ID)
);

CREATE TABLE SECTION (
	SECTION_NUM INT NOT NULL AUTO_INCREMENT,
	COURSE_ID INT NOT NULL,
	DEPT_ID INT NOT NULL,
	SECTION_DAY INT NOT NULL,
	SECTION_TIME_START TIME NOT NULL,
	SECTION_TIME_END TIME NOT NULL,
	SECTION_LOCATION VARCHAR(255) NOT NULL,
	FACULTY_ID INT,
	PRIMARY KEY (SECTION_NUM),
	FOREIGN KEY (COURSE_ID) REFERENCES COURSE(COURSE_ID),
	FOREIGN KEY (DEPT_ID) REFERENCES COURSE(DEPT_ID),
	FOREIGN KEY (FACULTY_ID) REFERENCES FACULTY(FACULTY_ID)
);

CREATE TABLE REGISTRATION (
	STU_ID INT NOT NULL,
	SECTION_NUM INT NOT NULL,
	GPA DOUBLE,
	GRADE VARCHAR(2),
	PRIMARY KEY (STU_ID, SECTION_NUM),
	FOREIGN KEY (STU_ID) REFERENCES STUDENT(STU_ID),
	FOREIGN KEY (SECTION_NUM) REFERENCES SECTION(SECTION_NUM)
);

CREATE TABLE FINANCIAL (
	STU_ID INT NOT NULL,
	CREDITCARD_NUM BIGINT NOT NULL,
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

CREATE TABLE INVOICE (
	INVOICE_ID INT NOT NULL AUTO_INCREMENT,
	CREDITCARD_NUM BIGINT,
	STU_ID INT NOT NULL,
	INVOICE_PAYMENT INT NOT NULL,
	INVOICE_DATE TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY (INVOICE_ID),
	FOREIGN KEY (STU_ID, CREDITCARD_NUM) REFERENCES FINANCIAL(STU_ID, CREDITCARD_NUM)
);


INSERT INTO DEPARTMENT ( DEPT_ABR, DEPT_TITLE )
VALUES 
	( 'ACC', 'Accounting' ),
	( 'BIO', 'Biology' ),
	( 'CIS', 'Computer Information Systems'),
	( 'ENG', 'English'),
	( 'GEO', 'Geography'),
	( 'GSC', 'General Science'),
	( 'MAT', 'Mathematics' ),
	( 'PHY', 'Physics' );

INSERT INTO PROGRAM ( PROGRAM_TITLE, DEPT_ID )
VALUES
	( 'Accounting', 1),
	( 'Biology', 2),
	( 'Software Engineering', 3),
	( 'Information Technologies', 3),
	( 'Computer Support', 3),
	( 'Systems Analysis', 3),
	( 'English', 4),
	( 'Geography', 5),
	( 'General Sciences', 6),
	( 'Mathematics', 7),
	( 'Physics', 8);

INSERT INTO USERS (USER_LAST_NAME, USER_FIRST_NAME, USER_ADDRESS, USER_CITY, USER_STATE, USER_ZIP, USER_COUNTRY, USERNAME, USER_EMAIL, USER_DOB)
VALUES
	('Ingram','Laura','3043 Perry St','Westland','MI',48185,'USA','ingram.laura','ingram.laura@fsu.edu','1970-11-19'),
	('Vallejos','Donnie','1390 Twin Oaks Ave','Grand Rapids','MI',49503,'USA','vallejos.donnie','vallejos.donnie@fsu.edu','1963-08-25'),
	('Schanerberger','William','10101 Binary Blvd','Blob','MI',10101,'USA','schanerberger.william','schanerberger.william@fsu.edu','1975-10-10'),
	('Emmons','Lee','21 Robinson Ct','Saginaw','MI',48607,'USA','emmons.lee','emmons.lee@fsu.edu','1981-07-17'),
	('Taliaferro','Jessica','844 Rubaiyat Rd','Muskegon','MI',49440,'USA','taliaferro.jessica','taliaferro.jessica@fsu.edu','1980-01-21'),
	('Turner','Henry','4998 Cottonwood Ln','Grand Rapids','MI',49505,'USA','turner.henry','turner.henry@fsu.edu','1961-04-24'),
	('Zwilling','Ema','1622 Bombardier Way','Romulus','MI',48174,'USA','zwilling.ema','zwilling.ema@fsu.edu','1982-06-27'),
	('Sawyer','Travis','3671 John Ave','Jonesville','MI',49250,'USA','sawyer.travis','sawyer.travis@fsu.edu','1982-08-30'),

	('Booth', 'Jesse', '947 Bartlett Ave', 'Southfield', 'MI', 48075, 'USA','booth.jesse', 'booth.jesse@fsu.edu', '1992-02-29'),
	('Avila', 'Patricia', '1049 D St', 'Roseville', 'MI', 48066, 'USA', 'avila.patricia', 'avila.patricia@fsu.edu', '1992-02-29'),
	('Sanner','Joseph','348 Nash St','Detroit','MI',48227,'USA','sanner.joseph','sanner.jospeh@fsu.edu', '1992-02-29'),
	('Timmons','Julia','1945 Eagle Dr','Southfield','MI',48235,'USA','timmons.julia','timmons.julia@fsu.edu', '1992-02-29'),
	('Kestner','Ralph','4185 Robinson Ct','Saginaw','MI',48607,'USA','kestner.ralph','kestner.ralph@fsu.edu', '1992-02-29'),
	('Fredericks','Joan','1476 Wetzel Ln','Grand Rapids','MI',49503,'USA','fredericks.joan','fredericks.joan@fsu.edu', '1992-02-29'),
	('Tyson','Sheila','3327 Cherry Ridge Dr','Bloomfield Township','MI',48302,'USA','tyson.sheila','tyson.sheila@fsu.edu', '1992-02-29'),
	('Bramblett','Albert','1758 Goff Ave','Three Rivers','MI',49093,'USA','bramblett.albert','bramblett.albert@fsu.edu', '1992-02-29'),
	('Gill','Elizabeth','2621 Haven Ln','Grand Rapids','MI',49508,'USA','gill.elizabeth','gill.elizabeth@fsu.edu', '1992-02-29'),
	('Thomas','Jose','4638 Prudence St','Southfield','MI',48075,'USA','thomas.jose','thomas.jose@fsu.edu', '1992-02-29'),
	('Jones','Justin','3734 Hart Ridge Rd','Saginaw','MI',48607,'USA','jones.justin','justin.jones@fsu.edu', '1992-02-29'),
	('Swanson','Frances','324 Wetzel Ln','Grand Rapids','MI',49503,'USA','swanson.frances','swanson.frances@fsu.edu', '1992-02-29'),
	('Flower','Barbara','4643 Bobcat Dr','Bloomfield Township','MI',48302,'USA','flower.barbara','flower.barbara@fsu.edu', '1992-02-29'),
	('Richardson','Robert','1778 Veltri Dr','Marquette','MI',49855,'USA','richardson.robert','richardson.robert@fsu.edu', '1992-02-29'),
	('Watts','Joseph','2854 Prudence St','Farmington Hills','MI',48335,'USA','watts.joseph','watts.joseph@fsu.edu', '1992-02-29'),
	('Aguilar','Kathryn','4658 Ben St','East Lansing','MI',48823,'USA','aguilar.kathryn','aguilar.kathryn@fsu.edu', '1992-02-29'),
	('Tate','Michelle','209 D Street','Southfield','MI',48075,'USA','tate.michelle','tate.michelle@fsu.edu', '1992-02-29'),
	('Watson','Janice','3650 Eagle Dr','Monroe','MI',48162,'USA','watson.janice','watson.janice@fsu.edu', '1992-02-29'),
	('Long','Edward','2689 Lakeland Terrace','Detroit','MI',48226,'USA','long.edward','long.edward@fsu.edu', '1992-02-29'),
	('Stocks','Vernon','598 Mount St','Alma','MI',48801,'USA','stocks.vernon','stocks.vernon@fsu.edu', '1992-02-29'),
	('Cordova','Raymonds','182 Echo Ln','Grands Rapids','MI',49508,'USA','cordova.raymonds','cordova.raymonds@fsu.edu', '1992-02-29'),
	('Robertson','Russell','2573 Ripple St','Kingston','MI',48741,'USA','robertson.russell','robertson.russell@fsu.edu', '1992-02-29'),
	('Moreno','Brandon','2855 John Ave','Lansing','MI',48912,'USA','moreno.brandon','moreno.brandon@fsu.edu', '1992-02-29'),
	('Slaughter','Michele','2697 Ritter Ave','Southfield','MI',48034,'USA','slaughter.michele','slaughter.michele@fsu.edu', '1992-02-29'),
	('Gill','Kathleen','1338 Tully St','Detroit','MI',48219,'USA','gill.kathleen','gill.kathleen@fsu.edu', '1992-02-29'),
	('Mercuri','Jessica','209 Hayhurst Ln','Detroit','MI',48219,'USA','mercuri.jessica','mercuri.jessica@fsu.edu', '1992-02-29'),
	('Raphael','Walter','1909 Front St','Southfield','MI',48075,'USA','raphael.walter','raphael.walter@fsu.edu', '1992-02-29'),
	('Stecker','Iva','1619 Pinewood Ave','Crystal Falls','MI',49920,'USA','stecker.iva','stecker.iva@fsu.edu', '1992-02-29'),
	('Mallory','Elizabeth','4464 State St','Detroit','MI',48219,'USA','mallory.elizabeth','mallory.elizabeth@fsu.edu','1992-02-29'),
	('Case','Leslie','1674 Summit Park Ave','Plymouth','MI',48170,'USA','case.leslie','case.leslie@fsu.edu','1992-02-29');

INSERT INTO FACULTY (USER_ID, DEPT_ID)
VALUES
	(1,1),
	(2,2),
	(3,3),
	(4,4),
	(5,5),
	(6,6),
	(7,7),
	(8,8);

INSERT INTO STUDENT (USER_ID, PROGRAM_ID)
VALUES
	(9,3),
	(10,8),
	(11,5),
	(12,5),
	(13,2),
	(14,9),
	(15,4),
	(16,2),
	(17,3),
	(18,7),
	(19,4),
	(20,10),
	(21,6),
	(22,10),
	(23,8),
	(24,9),
	(25,10),
	(26,1),
	(27,3),
	(28,10),
	(29,4),
	(30,7),
	(31,4),
	(32,3),
	(33,1),
	(34,7),
	(35,10),
	(36,10),
	(37,6),
	(38,11);

INSERT INTO COURSE (DEPT_ID, COURSE_ID, COURSE_TITLE, COURSE_DESCRIPT, COURSE_CREDITS, COURSE_CREDITS, DEPT_ID)
VALUES 
	(1,1500,'Accounting for the Small Business Owner','This course is designed for the non-accountant business owner. The student will study accounting procedures and applications for small businesses. Topics include bookkeeping for the small business, accounting systems for the small business, understanding of financial statements, overview of inventory management, survey of small business owner tax concerns and accounting concepts relating to financing the small business.',3),
	(1,1800,'Accounting Procedures','This course presents general accounting procedures. Students will study the accounting equation, emphasizing the process of analyzing and recording financial information using the double-entry accounting system. Coverage includes the recording of basic transactions and adjustments for both service and merchandising concerns.',2),
	(1,1810,'Principles of Financial Accounting','This course reviews basic financial accounting principles covering the accounting cycle. Topics include: cash, investments, receivables and payables, inventory valuation, fixed and intangible assets valuation, current and long term liabilities, and owner\'s equity. Internal control and financial statement analysis is also considered. Emphasis is placed on the corporate form of ownership.',4),
	(1,1820,'Principles of Managerial Accounting','This course emphasizes the managerial aspects of cost accounting for manufacturing and service entities. Managerial topics will include: cost terms and behavior, determination of the cost of goods manufactured and sold, job order and process cost accounting, cost-volume-profit analysis, variable costing, profit planning and budgeting, standard costs and variance analysis, capital budgeting, and the Statement of Cash Flows.',4),
	(2,1500,'Environmental Science','A laboratory science course which will focus through an interdisciplinary investigation on (a) developing an awareness of one\'s total environment (social, physical, and biological), (b) identifying the cause and perspective of our environmental concerns and, (c) exploring the possible and preferred solutions and strategies to those environmental issues. Course/lab fees.',4),
	(2,1510,'Life Science','The course will cover the basic concepts of biology. These include: the cellular basis of life, metabolic processes, genetics, diversity, evolution and ecology, with human applications. This is a laboratory course intended for non-science majors. Course/lab fees.',4),
	(2,1520,'Biology of Global Health','This course will introduce students to the main concepts of the public health field and the critical links between global health and environmental, sociocultural, and political-economic forces. Course topics include an overview of the factors affecting global health, a study of how health status is measured, and a review of key measures used to reduce the incidence of disease. The course will focus on the biological concepts underlying major diseases and issues in global health. This is a non-laboratory course.',4),
	(2,1530,'Biology I: Molecular and Cellular','The course will cover the molecular and cellular basis of biological processes including metabolism, reproduction, genetics and evolution along with relevant applications of biotechnology. This is a laboratory course intended for science majors. It is expected that students have successfully completed both high school biology and chemistry within the previous five years or the college equivalents. Course/lab fees',4),
	(2,2540,'General Zoology','	The course will explore representative protozoa and members of the animal kingdom, emphasizing their metabolism, anatomical structure and function, reproduction and development, evolution, diversity and ecology. Course/lab fees.',4),
	(3,1050,'Personal Computer Productivity Tools','Students will be introduced to the essentials of personal computer usage. Students will explore and utilize software products such as business graphics, Internet usage, spreadsheets, databases, and word processing. Material in this course will assist students in the use of common desktop productivity tools used by most other disciplines. Consult the footnotes in the Schedule of Classes for information on the software package being used in specific sections. Students will be required to complete computer-based assignments inside/outside of class. Course/lab fees.',4),
	(3,1100,'Fundamentals of Information Systems','This course provides an overview of business information systems and aims to present the central information systems principles, and demonstrate how they form an integral part of modern organizations. Topics include computer hardware and software fundamentals, use of software packages, an introduction to the Internet, systems analysis, the design of management information systems, as well as the impact of computers on business and society. The students will be required to complete computer-based assignments inside/outside of class. Course/lab fees.',4),
	(3,1200,'Introduction to Database Systems','This course will focus on the fundamentals of database systems. Students will study the basics of database vs. file management systems; functions, components, and personnel involved in a database; database, client-server, and transaction processing architectures; and relational data models and operations. Students will also study business requirements analysis, perform data definition, manipulation, and queries using basic SQL, create forms and reports; and analyze macros, procedures and triggers. Concepts of database planning, design, and administration fundamentals, data warehousing, and data mining will be covered. Students will be required to complete computer-based assignments inside/outside of class. Course/lab fees.',4),
	(3,1300,'Networking Concepts','Students will explore the components of networks and network designs. Communications hardware and the interconnection of servers and clients within LANs and WANs will be presented. Network architectures, standards, protocols and access methods used within intranets and the Internet will be described. The functions of network operating systems such as Windows Server, Unix, and Novell NetWare will be explored. Centralized computing, client/server and peer-to-peer environments, their services and their program-to-program communication protocols will be presented. Data security and system component protection will be studied. Students will be required to complete computer-based assignments inside/outside of class. Course/lab fees.',4),
	(3,1400,'Web Design I','This course focuses on the fundamentals of web site content development. Students will be introduced to the fundamental HTML5 structure of a webpage and then proceed to creating pages using a professional web editing tool. Students will create a fully functional original website using the web design editing tool that has elements such as images, hyperlinks, cascading style sheets for formatting, tables and integration of certain multimedia elements such as sound files, videos and Flash objects. Discussions will include accessibility of the design, overall site maintenance and publishing using FTP technologies. Students taking this course should have working knowledge of Windows and basic knowledge of the Internet. Course / lab fees.',4),
	(3,1500,'Introduction to Software Engineering','Students should have elementary Algebra skills and be familiar with both elementary word processing and Windows file management techniques prior to enrolling in this class. Students will be introduced to the fundamental techniques and syntax for understanding, designing, constructing, and testing object-oriented programs by studying the Java programming language. The structured programming basics of process, selection and iteration will be covered as well as primitive and complex data typing, methods, parameters and input/output. The basics of graphical user interface (GUI) programming such as event handling, windows and widgets will be introduced. Fundamental object-oriented concepts of classes, methods, abstraction, encapsulation and inheritance and incorporating an existing applet onto a web page will also be introduced. Students will be required to complete computer-based assignments inside/outside of class. Course/lab fees.',4),
	(4,1510,'Composition I','Focusing on the multi-stage writing process, students will read, analyze, and write expository essays. Course/lab fees.',3),
	(4,1520,'Composition II','Students will write persuasive and argumentative papers. They will acquire skills in library research and use a process that includes critical thinking, logical reasoning, and the investigation of primary and/or secondary sources. Students will write a documented, academic research paper.',3),
	(4,2300,'Science Fiction and Fantasy','Students will distinguish between science fiction and fantasy. In addition to reading a variety of texts from each genre, students will consider the history of science fiction and fantasy, their cultural role and impact, and critical approaches by which they can be interpreted. Selected trends and schools of thought, such as hard and soft science fiction, anthropological, speculative, cyberpunk, quest fantasy, dark fantasy, and alternative history will be considered within the context of global environment.',3),
	(4,2800,'Creative Writing','Students will develop a personal writing style by analyzing various genres, such as fiction, poetry, and drama, and by responding critically to the work of other students.',3),
	(5,1510,'Physical Geography','The course will explain the spatial dimensions of Earth’s dynamic system - its energy, air, water, weather, climate, tectonics, landforms, rocks, plants, ecosystems, and biomes. The course examines human-Earth relationships using maps to create a holistic view of the planet and its inhabitants.',3),
	(5,1520,'World Geography','The course will explain the modern geographic realms and their physical and human contents through a spatial approach. Contents of the course will include study of human societies and natural environments from environmental determinism to expansion and diffusion from decolonization to devolution.',3),
	(6,1530,'Introduction to Geology','This laboratory science course examines the processes that shape the Earth. Topics addressed include plate tectonic theory; rock and mineral formation and identification, igneous, metamorphic and sedimentary rock forming processes; weathering and soils; mass wasting; groundwater and stream processes; deserts and glaciers; global change; rock deformation, and energy and mineral resources. Two field trips, one half-day and one full-day are required.',4),
	(6,1580,'Astronomy','This is a science lecture demonstration course with accompanying lab experiences and field trips. This course involves the study of the earth, the moon, the planets, the solar system, the sun, the stars, the galaxy, galaxies, the universe, and related topics of special interest. Course/lab fees.',4),
	(6,1590,'Cosmology','The student will be able to apply basic astronomical concepts and relevant mathematics to acquire more in-depth knowledge about some of the following topics: the solar system, stellar formation and evolution, galactic evolution extraterrestrial intelligence and cosmology. Course/lab fees.',4),
	(6,1620,'Introduction to Environmental Geology','This laboratory science course introduces the student to how geological processes affect people and their physical environment. Topics covered include the hazards associated with earthquakes, volcanic eruptions, floods and landslides, the effect of volcanism on local and global climates, the formation and exploitation of water, soil, mineral and energy resources, the disposal of wastes and accompanying pollution; the link between geology and human health, and land use planning.. Course/lab fees.',4),
	(7,1100,'Elementary Algebra','Properties of real numbers; first degree equations and inequalities; word problems; integer exponents; polynomials and factoring; rational expressions; graphing linear equations and inequalities; solving systems by graphing, addition and substitution; radicals; quadratic equations and the quadratic formula.',4),
	(7,1150,'Intermediate Algebra','Review of basics from elementary algebra; absolute value equations and inequalities; radical and rational exponents; complex numbers; completing the square; the discriminant; quadratic inequalities; equations of lines; systems of equations; conic sections; functions, inverses and their graphs; word problems; exponential and logarithmic functions.',4),
	(7,1560,'Trigonometry','Definition of the trigonometric functions as circular functions; graphs of the trigonometric functions; development and use of identities; solution of equations; inverse functions; applications; definition of the functions in a right triangle; solution of right triangles; solution of non-right triangles by use of Law of Sines and Law of Cosines; vectors; polar coordinates.',4),
	(7,1730,'Calculus I','Limits; continuity; concept of the derivative; differentiation of algebraic and transcendental functions; applications of the derivative; antidifferentiation; the indefinite integral; the definite integral; the Fundamental Theorem of Calculus; numerical integration; integration involving logarithmic functions; some applications of the integral. Some of the course concepts will be explored and/or enhanced with current technology.',4),
	(7,1740,'Calculus II','Integrals involving inverse trigonometric functions; hyperbolic functions; an introduction to differential equations; applications of the definite integral; techniques of integration; limits of indeterminate forms; improper integrals; two-dimensional analytic geometry using polar coordinates and parametric equations; infinite series. Some of the course concepts will be explored and/or enhanced with current technology.',4),
	(8,1610,'College Physics I','The student will investigate the physical aspects of mechanics, sound, and heat. The student will perform measurements and experiments in mechanics and thermodynamics. Course/lab fees.',4),
	(8,1620,'College Physics II','The student will study electricity, magnetism, optics, and selected topics in atomic physics. The student will perform measurements and experiments in electricity, magnetism, and optics. Course/lab fees.',4),
	(8,2400,'Engineering Physics I','Prior physics in high school or college, or consent of instructor, is recommended. The student will define basic terms, explain theories, and apply them to the solution of problems in mechanics and thermodynamics using calculus where required. The student will obtain various types of data, reduce this data, express the reliability of the results, and write technical reports. Course/lab fees.',4),
	(8,2500,'Engineering Physics II','The student will define basic terms, explain theories, and apply them to the solution of problems in electricity and magnetism using calculus and elementary differential equations where required. The student will obtain various types of data, reduce this data, express the reliability of the results, and write technical reports. Course/lab fees.',4),

INSERT INTO SECTION (DEPT_ID, COURSE_ID, SECTION_DAY, SECTION_TIME_START, SECTION_TIME_END, SECTION_LOCATION, FACULTY_ID)
VALUES
	(1, 1500, 20,'16:00:00','18:00:00','B108',1),
	(1, 1800, 32,'9:00:00','11:00:00','A316',1),
	(1, 1800, 10,'8:00:00','10:00:00','A306',1),
	(2, 1500, 4,'19:00:00','21:00:00','A119',2),
	(2, 1500, 16,'10:00:00','12:00:00','G101',2),
	(2, 1510, 40,'9:00:00','11:00:00','C224',2),
	(2, 1510, 10,'16:00:00','18:00:00','B304',2),
	(2, 2540, 16,'12:00:00','14:00:00','G111',2),
	(2, 2540, 16,'9:00:00','11:00:00','A306',2),
	(3, 1050, 40,'13:00:00','15:00:00','A110',3),
	(3, 1050, 4,'12:00:00','14:00:00','E225',3),
	(3, 1200, 20,'10:00:00','12:00:00','B118',3),
	(3, 1400, 32,'19:00:00','21:00:00','C210',3),
	(3, 1500, 16,'13:00:00','15:00:00','D114',3),
	(4, 1510, 32,'17:00:00','19:00:00','D224',4),
	(4, 1510, 40,'18:00:00','20:00:00','G204',4),
	(4, 1520, 8,'14:00:00','16:00:00','F119',4),
	(4, 1520, 8,'16:00:00','18:00:00','D125',4),
	(4, 2300, 10,'17:00:00','19:00:00','F314',4),
	(5, 1520, 10,'19:00:00','21:00:00','B308',5),
	(5, 1520, 40,'18:00:00','20:00:00','A309',5),
	(6, 1530, 32,'9:00:00','11:00:00','A107',6),
	(6, 1590, 20,'14:00:00','16:00:00','G221',6),
	(7, 1100, 16,'9:00:00','11:00:00','B323',7),
	(7, 1100, 40,'15:00:00','17:00:00','G321',7),
	(7, 1560, 40,'13:00:00','15:00:00','B324',7),
	(7, 1740, 32,'17:00:00','19:00:00','A124',7),
	(7, 1740, 40,'16:00:00','18:00:00','A120',7),
	(8, 1610, 20,'13:00:00','15:00:00','D103',8),
	(8, 1610, 10,'12:00:00','14:00:00','F322',8),
	(8, 2400, 40,'11:00:00','13:00:00','G302',8),
	(8, 2400, 2,'8:00:00','10:00:00','F312',8);

INSERT INTO REGISTRATION (STU_ID, SECTION_NUM, GPA, GRADE)
VALUES
	(9,10,'D',1.0),
	(9,3,'B',3.0),
	(9,6,'B',3.0),
	(10,15),
	(10,10),
	(10,13,'B-',2.7),
	(10,4,'A',4.0),
	(11,4,'A-',3.7),
	(11,14,'B+',3.3),
	(11,10,'A',4.0),
	(11,8),
	(11,5,'C',2.0),
	(12,9,'C+',2.3),
	(12,0,'A-',3.7),
	(12,14,'A-',3.7),
	(13,6),
	(13,18),
	(13,0),
	(13,19,'D',1.0),
	(14,17),
	(14,13,'B-',2.7),
	(14,6,'C+',2.3),
	(14,5),
	(14,3,'C+',2.3),
	(15,7,'C+',2.3),
	(15,12,'D',1.0),
	(15,11,'A-',3.7),
	(16,1,'B+',3.3),
	(16,16,'F',0.0),
	(16,6,'C+',2.3),
	(16,9,'A-',3.7),
	(17,14,'B+',3.3),
	(17,0,'B+',3.3),
	(17,10,'B',3.0),
	(17,6),
	(17,11,'C+',2.3),
	(18,13,'D',1.0),
	(18,17,'C',2.0),
	(18,14),
	(18,4,'C',2.0),
	(18,16,'F',0.0),
	(19,10),
	(19,16,'B+',3.3),
	(19,1,'A',4.0),
	(19,7,'B-',2.7),
	(20,5,'D',1.0),
	(20,7,'C+',2.3),
	(20,0),
	(20,4,'F',0.0),
	(21,1,'B',3.0),
	(21,10,'D',1.0),
	(21,8),
	(21,3,'C-',1.7),
	(22,1),
	(22,7,'A-',3.7),
	(22,17,'C-',1.7),
	(23,5),
	(23,2,'A-',3.7),
	(23,15),
	(23,6,'F',0.0),
	(23,17),
	(24,15,'B+',3.3),
	(24,18,'B+',3.3),
	(24,11,'B',3.0),
	(24,4),
	(25,6),
	(25,0,'A',4.0),
	(25,7,'C-',1.7),
	(26,2,'A-',3.7),
	(26,3,'B+',3.3),
	(26,13,'D',1.0),
	(27,17,'A-',3.7),
	(27,14,'D',1.0),
	(27,12,'B-',2.7),
	(28,17,'C-',1.7),
	(28,7,'F',0.0),
	(28,10,'C-',1.7),
	(28,18,'A',4.0),
	(29,0,'A',4.0),
	(29,3,'B-',2.7),
	(29,9,'C+',2.3),
	(29,16),
	(30,17),
	(30,2,'B-',2.7),
	(30,13,'B-',2.7),
	(31,15,'A-',3.7),
	(31,11,'B',3.0),
	(31,16,'C-',1.7),
	(31,4),
	(31,9,'B+',3.3),
	(32,7,'B',3.0),
	(32,16,'B+',3.3),
	(32,15,'C',2.0),
	(32,0,'B',3.0),
	(33,2),
	(33,8),
	(33,16,'D',1.0),
	(33,4,'B',3.0),
	(33,14,'B',3.0),
	(34,7,'A',4.0),
	(34,18,'D',1.0),
	(34,4,'C+',2.3),
	(35,3,'D',1.0),
	(35,13),
	(35,2,'B',3.0),
	(35,0),
	(35,16,'A',4.0),
	(36,16,'C-',1.7),
	(36,9,'B-',2.7),
	(36,8,'C+',2.3),
	(36,7,'D',1.0),
	(36,3,'F',0.0),
	(37,17,'F',0.0),
	(37,16),
	(37,19,'F',0.0),
	(38,17),
	(38,18,'B+',3.3),
	(38,4,'B-',2.7),
	(38,13,'C-',1.7);

INSERT INTO FINANCIAL (BILLING_NAME, BILLING_ADDRESS, BILLING_CITY, BILLING_STATE, BILLING_ZIP, )