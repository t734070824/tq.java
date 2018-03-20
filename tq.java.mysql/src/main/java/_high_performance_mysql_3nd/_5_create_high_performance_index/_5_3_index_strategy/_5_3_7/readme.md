2018-03-20

### 使用索引排序来做扫描
+ 查询为索引的第一列提供常量条件, 使用第二列排序

```text
EXPLAIN	SELECT rental_id, staff_id FROM rental WHERE rental_date= '2005-05-05' ORDER BY unventory_id, consumer_id;
    id  select_type  table   type    possible_keys  key          key_len  ref       rows  Extra
------  -----------  ------  ------  -------------  -----------  -------  ------  ------  ------------------------------------
     1  SIMPLE       rental  ref     rental_date    rental_date  152      const        1  Using index condition; Using where  

```
+ Order by 使用的列是索引的最左前缀

```text
EXPLAIN	SELECT rental_id, staff_id FROM rental WHERE  rental_date >  '2005-05-05' ORDER BY rental_date, unventory_id;
    id  select_type  table   type    possible_keys  key          key_len  ref       rows  Extra                  
------  -----------  ------  ------  -------------  -----------  -------  ------  ------  -----------------------
     1  SIMPLE       rental  range   rental_date    rental_date  152      (NULL)       1  Using index condition    

``` 

+ 在索引的第一列使用范围条件, 无法使用索引的其他列

```text
	EXPLAIN	SELECT rental_id, staff_id FROM rental WHERE rental_date> '2005-05-05'  ORDER BY unventory_id, consumer_id;
    id  select_type  table   type    possible_keys  key          key_len  ref       rows  Extra                                  
------  -----------  ------  ------  -------------  -----------  -------  ------  ------  ---------------------------------------
     1  SIMPLE       rental  range   rental_date    rental_date  152      (NULL)       1  Using index condition; Using filesort  
``` 


+ 在unventory_id使用范围查询, 无法使用索引

```text
EXPLAIN	SELECT rental_id, staff_id FROM rental WHERE rental_date= '2005-05-05' AND unventory_id IN ('1','2') ORDER BY  consumer_id;
    id  select_type  table   type    possible_keys                    key     key_len  ref       rows  Extra                        
------  -----------  ------  ------  -------------------------------  ------  -------  ------  ------  -----------------------------
     1  SIMPLE       rental  ALL     rental_date,idx_fk_unventory_id  (NULL)  (NULL)   (NULL)       1  Using where; Using filesort  
``` 


