##哈希索引
CREATE TABLE  testhash (
  fname VARCHAR(50) not null,
  lname VARCHAR(50) NOT NULL ,
  key USING HASH (fname)
)ENGINE=MEMORY