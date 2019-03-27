2019-03-20

## me

### 安装
1. centos7 docker  SELinux is not supported
    - 要么启动一个新内核，
    - 要么就在docker里禁用selinux，--selinux-enabled=false

```javascript
vi /etc/sysconfig/docker
# /etc/sysconfig/docker
 
# Modify these options if you want to change the way the docker daemon runs
 
OPTIONS='--selinux-enabled=false  --log-driver=journald --signature-verification=false'
if [ -z "${DOCKER_CERT_PATH}" ]; then
    DOCKER_CERT_PATH=/etc/docker
fi
```

2. centos7
    - systemctl 的 bug


### 入门
1. https://zhuanlan.zhihu.com/p/23599229