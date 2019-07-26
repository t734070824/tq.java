2019-07-24

## 第一步

### 清理已停止的所有容器
1. docker rm -v $(docker ps -aq -f status=exited)