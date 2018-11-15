package _book._mybatis_jishu_neimu._4_advanced_topics._page;

/**
 * @author 734070824@qq.com
 * @date 2018/11/15 15:33
 */
public interface Dialect {

    //检测当前使用的数据库产品是否支持分页
    boolean supportPage();

    String getPagingSql(String sql, int offset, int limit);
}
