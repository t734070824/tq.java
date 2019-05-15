2018-11-18

## 案列学习


### 构建一个对列表
1. first
    - 一个表包含多种类型的数据: 未处理, 已处理, 正在处理
    - 随着队列表 越来越大, 索引深度的增加, 找打未处理记录的速度越来越慢
        - 分成两部分: 已处理记录归档/历史表
2. 处理过程
    - 找到未处理记录 加锁
    - 如何做数据到通知
        - 不要轮询
        - get_lock, release_locak
        - 数据库外实现
    - 如何让消费者者标记正在处理的记录

        - select ... for update
        ```sql
        create table unsent_msg {
          id int not null PREPARE key auto_increment,
          status enum('unsent', 'claimed', 'sent'),
          owner int Unsigned not null default 0,
          ts TIMEStamp,
          key (owner, status, ts)
        }
        ```
        - owner 标识当前正在处理这个记录的ID, Connection_id
        - 一次处理 10 条
        ```sql
        BEGIN ;
        select id from unsent_msg where owner=0 and status='unsent' limit 10 from update;
        --- result xxx,xxxx,xxx
        update unsent_msg set status='claimed' , owner = Connection_id where id in (xxx,xxxx,xxx); 
        COMMIT ;
        ```
        - 这个锁会让其他查询全被阻塞
        - 修改
        ```sql
        set autocommit=1;
        commit;
        update unsent_msg set status = 'claimed', owner = Connection_id where owner = 0 and status = 'unsent' limit 10;
        set AUTOCOMMIT =0;
        select id from unsent_msg where owner = Connection_id and status = 'claimed'
        ```
        - **所有的 select .. for update 都可以这么修改**
        - 哪些正在被进程处理的数据, 而进程本身由于某种原因退出
            - 定期运 update 语句将正在处理状态的数据还原为原始状态
            - 超时时间
            - 数据处理做好幂等性
3. 总结
    - 尽量少做事, 可以的话不做任何事
        - 不要轮询
    - 尽可能快的完成需要做的事情
        - update 代替 select ... from update
        - 降低阻塞时间
    - 有些 sql 无法优化, 想一想 修改查询 或者 其他策略

