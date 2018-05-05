2018-05-05

## StandardContext
1. Context实例表示一个 web 应用, 包含一个或者多个 Wrapper实例
2. 需要其他组件的支持: 加载器, Session管理器

### 总结
1. 将自身设置为 HttpConnector 的 容器, 
2. this.connector.getContainer().invoke(this.request, this.response);
3. StandardContextValve.invoke
4. wrapper = (Wrapper)context.map(request, true);
5. wrapper.invoke