2017-12-30

### StandardContext

#### start()
- 触发 BEFORE_START 事件
- availability = false
- configured = false;
- 配置资源
- 设置载入器
- 设置Session管理器
- 初始化字符集映射器
- 启动与该Context容器相关联的组件
- 启动子容器
- 启动管道对象
- 启动Session容器
- 触发START事件
- 检查 configured
- 触发 AFTER_START 事件

