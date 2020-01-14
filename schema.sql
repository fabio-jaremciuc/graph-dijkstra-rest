DROP SCHEMA IF EXISTS vacancy_matching;
CREATE SCHEMA vacancy_matching;
USE vacancy_matching;

CREATE TABLE job (
  job_id SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT,
  job_company VARCHAR(45) NOT NULL,
  job_title VARCHAR(45) NOT NULL,
  job_description VARCHAR(45) NOT NULL,
  job_location VARCHAR(45) NOT NULL,
  job_level SMALLINT UNSIGNED NOT NULL,
  PRIMARY KEY  (job_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE candidate (
  candidate_id SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT,
  candidate_name VARCHAR(45) NOT NULL,
  candidate_occupation VARCHAR(45) NOT NULL,
  candidate_location VARCHAR(45) NOT NULL,
  candidate_level SMALLINT UNSIGNED NOT NULL,
  candidate_app_position VARCHAR(45) NOT NULL,
  PRIMARY KEY  (candidate_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE ranking (
  candidate_id SMALLINT UNSIGNED NOT NULL,
  ranking_location VARCHAR(45) NOT NULL,
  ranking_level SMALLINT UNSIGNED NOT NULL,
  score VARCHAR(45) NOT NULL,
  PRIMARY KEY  (candidate_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
   

