2018-01-09
### 获取输入输出流
1. Request:不可以将 getReader() 与 getInputStream() 同时使用
```javascript
    public BufferedReader getReader() throws IOException {

        if (usingInputStream) {
            throw new IllegalStateException
                (sm.getString("coyoteRequest.getReader.ise"));
        }

        usingReader = true;
        inputBuffer.checkConverter();
        if (reader == null) {
            reader = new CoyoteReader(inputBuffer);
        }
        return reader;

    }
    
    --------------------------------------
    @Override
    public ServletInputStream getInputStream() throws IOException {

        if (usingReader) {
            throw new IllegalStateException
                (sm.getString("coyoteRequest.getInputStream.ise"));
        }

        usingInputStream = true;
        if (inputStream == null) {
            inputStream = new CoyoteInputStream(inputBuffer);
        }
        return inputStream;

    }
```

2. Response: getWriter() 和 getOutputStream() 不可以同时使用

### 设置内容类型 以及 编码格式
![](1.png) 

### 注解 和 web.xml同时配置形同的内容
1. **xml 会覆盖 注解**

### 使用注解的局限
1. 无法确定过滤器的顺序
2. 无法创建单个 servlet 的多个实例
3. 无法定义 错误,欢迎 界面