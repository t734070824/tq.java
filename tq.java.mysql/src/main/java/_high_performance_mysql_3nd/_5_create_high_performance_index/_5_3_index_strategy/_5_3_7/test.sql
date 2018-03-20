##使用索引扫描来做排序
CREATE TABLE  rental (
  rental_id VARCHAR(50) not null,
  rental_date VARCHAR(50) not null,
  unventory_id VARCHAR(50) NOT NULL ,
  consumer_id VARCHAR(50) NOT NULL ,
  staff_id VARCHAR(50) NOT NULL ,
  PRIMARY KEY (rental_id),
  UNIQUE KEY rental_date (rental_date, unventory_id, consumer_id),
  KEY idx_fk_unventory_id(unventory_id),
  KEY idx_fk_consumer_id(consumer_id),
  KEY idx_fk_staff_id(staff_id)
);

#######
