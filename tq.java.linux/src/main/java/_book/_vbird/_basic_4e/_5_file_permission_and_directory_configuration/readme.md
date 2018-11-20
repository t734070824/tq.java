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
            - 

    