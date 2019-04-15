2019-04-12

## 使用 Zookeeper

### 客户端脚本
1. 创建
    - create [-s] [-e] path set acl
        - -s -e 标识节点特性: 顺序或者临时节点, 默认是持久节点
        - acl: 权限控制, 缺省--不做任何权限控制
2. 读取
    - ls 
        - ls path [watch]
        - 列出指定节点下的所有子节点
    - get
        - 获取指定节点的数据内容和属性信息
        - get path [watch]
3. 更新
    - set 
        - 更新指定节点的数据内容
        - set path data [version]
4. 删除
    - delete
    - 删除指定节点
    - delete path [version]
    - 