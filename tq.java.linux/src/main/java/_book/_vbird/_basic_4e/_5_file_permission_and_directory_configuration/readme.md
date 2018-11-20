2018-11-13

## 文件权限和目录配置

### 权限分类
1. User
2. Group
3. Others
4. read/write/execute

### 文件的权限

```text
drwx------. 4 1000 tangqing   205 9月  21 09:54 .
drwxr-xr-x. 9 root root       116 6月  15 15:17 ..
-rw-------. 1 1000 tangqing 23207 11月 19 09:55 .bash_history
-rw-r--r--. 1 1000 tangqing    18 8月   3 2016 .bash_logout
-rw-r--r--. 1 1000 tangqing   193 8月   3 2016 .bash_profile
-rw-r--r--. 1 1000 tangqing   231 8月   3 2016 .bashrc
-rw-r--r--. 1 root root        18 5月   8 2018 dump.rdb
-rw-r--r--. 1 root root       370 6月   6 15:42 elasticsearch_tq_es_test.conf
-rw-r--r--. 1 root root      8899 6月   6 13:33 installer.sh
drwxr-----. 3 root root        19 3月  29 2018 .pki
-rw-r--r--. 1 root root        56 6月  25 14:47 .rediscli_history
drwxr-xr-x. 2 root root        29 3月   2 2018 .ssh
[      1  ][2] [3] [4]        [5]  [    6    ] [7]
[ 权限 ][链接][拥有者][群组][文件大小][ 修改日期 ] [ 文件名 ]
```

### 文件属性
1. 文件的类型和权限
    - -rwxrwx---
        - 第一个字符代表这个文件是“目录、文件或链接文件等等
            - [d]--文件
            - [-]--文件
            - [l]--链接文件
            - [b]--设备文件里面的可供储存的周边设备（可随机存取设备）
            - [c]-- 设备文件里面的序列埠设备，例如键盘、鼠标（一次性读取设备） 
    - drwxr-xr-- 1 test1 testgroup 5238 Jun 19 10:25 groups/
        - testgroup这个群组的成员与其他人 (other) 是否可以进入本目录？
            - **testgroup下的账号可以进入 本目录, 然无法进行写入**
            - **other 权限有 [r--], 但是没有 x 权限, 不能进入本目录**
    - 为什么对每一个文件增加那么多属性, 尤其群组的概念
        - 数据安全性
            - 系统保护
            - 数据共享
            - 防止 未将全向设置妥当的危害

### 改变文件属性和群组
1. 命令
    - chgrp(change group)
        - -R: 递归 
    - chown(change owner) 
        - 复制文件给其他账号
        - cp 将会复制执行者的属性和权限
    - chmod: 改变文件权限
        - r:4, w:2, x:1
        - chmod -R xyz 文件或目录
        - | chmod | u g o a | +（加入） -（除去） =（设置） | r w x | 文件或目录 |
2. 目录权限
    - 目录: 记录文件名清单
    - 权限
        - r
            - 读取目录结构清单的权限
        - w
            - 改变该目录清单的权限
                 - 创建新的文档和目录
                 - **删除已经存在的文件和目录(不管该文件的权限如何)**
                 - 重命名已经存在的文件或目录
                 - 移动
                 - **对文件内容的修改依然受到权限限制**
        - x
            - 使用者能否进入该目录成为工作目录的用途
            - 进入这个目录的钥匙
3. 文件扩展名
    - 没有具体的差别, 只是为了表示不同的用途
    - 常用的扩展名
        - .sh 
            - 脚本或者是批处理文件
        - Z, .tar, .tar.gz, .zip, *.tgz
            - 经过打包的文件
        - .html, .php
4. 文件名
    - 长度限制
        - Ext2/Ext3/Ext4, xfs
            - 255Bytes, 255个字符长度
            - 中文2Byte, 128 中文

### Linux 目录配置
1. 重点在于 规范每个特定的目录下应该要放置什么样子的数据