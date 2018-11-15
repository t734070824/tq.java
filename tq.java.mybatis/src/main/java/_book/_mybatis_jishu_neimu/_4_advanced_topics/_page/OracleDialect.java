package _book._mybatis_jishu_neimu._4_advanced_topics._page;

/**
 * @author 734070824@qq.com
 * @date 2018/11/15 16:11
 */
public class OracleDialect implements Dialect{
    @Override
    public boolean supportPage() {
        return true;
    }

    @Override
    public String getPagingSql(String sql, int offset, int limit) {
        return null;
    }
}
