DROP FINANCIAL;
DROP INVOICE;
DROP REGISTRATION;
DROP SECTION;
DROP COURSE;
DROP USERS;
DROP STUDENT;
DROP FACULTY;
DROP PROGRAM;
DROP DEPARTMENT;


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
	USERNAME VARCHAR(255) NOT NULL,
	PRIMARY KEY (USER_ID),
	FOREIGN KEY (STU_ID) REFERENCES STUDENT(STU_ID),
	FOREIGN KEY (FACULTY_ID) REFERENCES FACULTY(STU_ID)
);

CREATE TABLE COURSE (
	COURSE_ID INT NOT NULL AUTO_INCREMENT,
	COURSE_TITLE VARCHAR(255) NOT NULL,
	COURSE_DESCRIPT VARCHAR(MAX),
	COURSE_CREDITS INT NOT NULL,
	COURSE_COST INT NOT NULL,
	DEPT_ID INT NOT NULL,
	PRIMARY KEY (COURSE_ID, DEPT_ID),
	FOREIGN KEY (DEPT_ID) REFERENCES DEPARTMENT(DEPT_ID)
);

CREATE TABLE SECTION {
	SECTION_NUM INT NOT NULL AUTO_INCREMENT,
	COURSE_ID INT NOT NULL,
	DEPT_ID INT NOT NULL,,
	SECTION_DAY INT NOT NULL,
	SECTION_TIME INT NOT NULL,
	SECTION_LOCATION VARCHAR(255) NOT NULL,
	FACULTY_ID INT,
	PRIMARY KEY (SECTION_NUM),
	FOREIGN KEY (COURSE_ID) REFERENCES COURSE(COURSE_ID),
	FOREGIN KEY (DEPT_ID) REFERENCES COURSE(DEPT_ID),
	FOREIGN KEY (FACULTY_ID) REFERENCES FACULTY(FACULTY_ID)
}

CREATE TABLE REGISTRATION (
	STU_ID INT NOT NULL,
	SECTION_NUM INT NOT NULL,
	GPA INT,
	GRADE VARCHAR(2),
	PRIMARY KEY (STU_ID, SECTION_NUM),
	FOREIGN KEY (STU_ID) REFERENCES STUDENT(STU_ID),
	FOREIGN KEY (SECTION_NUM) REFERENCES SECTION(SECTION_NUM)
);

CREATE TABLE INVOICE (
	INVOICE_ID INT NOT NULL AUTO_INCREMENT,
	CREDITCARD_NUM INT,
	STU_ID INT NOT NULL,
	INVOICE_PAYMENT INT NOT NULL,
	INVOICE_DATE DATE NOT NULL,
	PRIMARY KEY (INVOICE_ID),
	FOREIGN KEY (STU_ID) REFERENCES FINANCIAL(STU_ID),
	FOREIGN KEY (CREDITCARD_NUM) REFERENCES FINANCIAL(CREDITCARD_NUM)
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

INSERT INTO DEPARTMENT ( DEPT_TITLE, DEPT_ABR )
VALUES 
	( 'ACC', 'Accounting' ),
	( 'BIO', 'Biology' ),
	( 'CIS', 'Computer Information Systems'),
	( 'ENG', 'English'),
	( 'GEO', 'Geography'),
	( 'GSC', 'General Science'),
	( 'MAT', 'Mathematics' ),
	( 'PHY', 'Physics' ),
	( 'POL', 'Political Science');

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

	(9,1510,'American Government','This course focuses on the structure and functioning of American government; introductory analysis of the process of decision-making, the relationship of the state and the individual, and the degree and nature of popular control.',3);