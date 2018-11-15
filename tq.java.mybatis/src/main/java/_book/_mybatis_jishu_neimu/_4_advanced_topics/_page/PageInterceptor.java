package _book._mybatis_jishu_neimu._4_advanced_topics._page;

import org.apache.ibatis.cache.CacheKey;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author 734070824@qq.com
 * @date 2018/11/15 15:24
 */
@Intercepts({@Signature(type = Executor.class, method = "query",
        args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class})})
public class PageInterceptor implements Interceptor{

    //记录 Executor . query （）方法中，指定类型的参数在参数列表中的索引位置
    //MappedStatement 对象在参数列表中的索引位置
    private static int MAPPEDSTATEMENT_INDEX = 0;
    //用户传入的实参对象在参数列表中的索引位置
    private static int PARAMETEROBJECT_INDEX= 1 ;
    //MappedStatement 类型的参数在参数列表中的索引位置
    private static int ROWBOUNDS_INDEX = 2 ;

    //Dialect 对象。 每种数据库产品对
    private Dialect dialect ;

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        Object[] queryArgs = invocation.getArgs();
        //获取 MappedStatement 对象
        MappedStatement ms = (MappedStatement) queryArgs[MAPPEDSTATEMENT_INDEX];

        //用户的实参对象
        Object parameter = queryArgs[PARAMETEROBJECT_INDEX];

        RowBounds rowBounds = (RowBounds) queryArgs[ROWBOUNDS_INDEX];

        //获取 RowBounds 对象中记录的 offset值，也就是查询的起始位置
        int offset= rowBounds.getOffset();
        //获取 RowBounds 对象中记录的 limit 值，也就是查询返回的记录条数
        int limit= rowBounds.getLimit();

        //获取 BoundSql 对象 ，其中记录了包含"?"占位符的 SQL t吾句
        BoundSql boundSql = ms.getBoundSql(parameter);
        //获取 BoundSql 中记录的 SQL 语句
        final StringBuffer bufferSql = new StringBuffer (boundSql.getSql().trim()) ;
        //对 SQL 语句进行格式化 。 在映射配置文件中编写 SQL 语句时，或是经过动态 SQL 解析之后， SQL
        //语句的格式会比较凌乱，这里可以对 SQL 语句进行格式化
        String sql = getFommatSql(bufferSql.toString().trim());
        //通过 Dialect 策略，检测当前使用的数据库产品是否支持分页功能
        if(dialect.supportPage()) {
            //Dialect 策略根据具体的数据块产品 、 SQL 语句以及 offset 值和 limit 值，生成包含分页功能的 SQL 语句
            sql = dialect.getPagingSql(sql, offset, limit);
            //当前拦截的 Executor. query （）方法中的 RowBounds 参数不再控制查找结果集的范围，所以要进行重置
            queryArgs[ROWBOUNDS_INDEX] = new RowBounds(RowBounds.NO_ROW_OFFSET, RowBounds.NO_ROW_LIMIT);
        }
        //根据当前的 SQL 语句创建新的 MappedStaternent 对象，并更新到 Invocation 对象记录的参数列表中
        queryArgs[MAPPEDSTATEMENT_INDEX] = createMappedStaternent(ms, boundSql , sql) ;
        //通过 Invocation . proceed （）方法调用被拦截的 Executor.query()方法
        return invocation.proceed();
    }

    private String getFommatSql(String trim) {
        //TODO
        return trim;
    }


    private MappedStatement createMappedStaternent(MappedStatement ms, BoundSql boundSql, String sql) {
        //为处理后的sql语句创建新的 BoundSql对象,
        //TODO
//        BoundSql newBoundSql = createBoundSql(ms, boundSql, sql);
//        return createMappedStaternent(ms, new BoundSqlSqlSource(newBoundSql));

        return ms;
    }



    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {
        //查找名称为 dbName 的配置项
        String dbname = properties.getProperty("dbName");
        //查找 以 dialect. 开头的配置项
        String prefix = "dialect.";
        Map<String , String> result = new HashMap<String, String>();
        for (Map.Entry<Object , Object> entry : properties.entrySet()) {
            String key = (String) entry.getKey();
            if (key != null && key.startsWith(prefix)) {
                result.put(key.substring(prefix.length()), (String) entry.getValue());
            }
        }
        String dialectClass = result.get(dbname);
        try {
        //通过反射的方式创建 Dialect 接 口的具体实现
            Dialect dialect = (Dialect) Class.forName(dialectClass).newInstance();
        //设置当前使用的 Dialect 策略
            this.setDialect(dialect) ;
        } catch (Exception e) {
            throw new RuntimeException("Cann't find Dialect for " + dbname +"!", e);
        }
    }

    public void setDialect(Dialect dialect) {
        this.dialect = dialect;
    }
}
