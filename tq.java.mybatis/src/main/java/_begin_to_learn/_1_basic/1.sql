CREATE TABLE student
(
  studentId          INT                        PRIMARY KEY     AUTO_INCREMENT    NOT NULL,
  studentName        VARCHAR(20)                                                  NOT NULL,
  studentAge         INT                                                          NOT NULL,
  studentPhone       VARCHAR(20)                                                  NOT NULL
);

#################
INSERT INTO student VALUES(NULL, 'Jack', 20, '000000');
INSERT INTO student VALUES(NULL, 'Mark', 21, '111111');
INSERT INTO student VALUES(NULL, 'Lily', 22, '222222');
INSERT INTO student VALUES(NULL, 'Lucy', 23, '333333');