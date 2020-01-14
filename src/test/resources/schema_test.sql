CREATE TABLE job
   ("JOB_ID" NUMBER auto_increment,  
	"JOB_COMPANY" VARCHAR2(50 CHAR), 
   	"JOB_TITLE" VARCHAR2(50 CHAR), 
	"JOB_DESCRIPTION" VARCHAR2(50 CHAR), 
	"JOB_LOCATION" VARCHAR2(50 CHAR), 
	"JOB_LEVEL" NUMBER(1,0), 
	PRIMARY KEY (JOB_ID)
   );
   
CREATE TABLE CANDIDATE
   ("CANDIDATE_ID" NUMBER auto_increment,  
	"CANDIDATE_NAME" VARCHAR2(50 CHAR), 
	"CANDIDATE_OCCUPATION" VARCHAR2(50 CHAR), 
	"CANDIDATE_LOCATION" VARCHAR2(50 CHAR), 
	"CANDIDATE_LEVEL" NUMBER(1,0),
	"CANDIDATE_APP_POSITION" VARCHAR2(50 CHAR),
	PRIMARY KEY (CANDIDATE_ID)
   );
   
CREATE TABLE RANKING
   ("CANDIDATE_ID" NUMBER,  
	"RANKING_LOCATION" VARCHAR2(50 CHAR), 
	"RANKING_LEVEL" NUMBER(1,0),
	"SCORE" NUMBER,
	PRIMARY KEY (CANDIDATE_ID)
   );

