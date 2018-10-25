package _5_transaction._20_spring_transaction_manage;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author 734070824@qq.com
 * @date 2018/4/16 15:27
 */
public class QuoteService implements IQuoteService{

    private JdbcTemplate jdbcTemplate;

    @Override
    public Quote getQuote() {
        return getJdbcTemplate().queryForObject("SELECT  * FROM  student LIMIT 1", new RowMapper<Quote>() {
            @Override
            public Quote mapRow(ResultSet rs, int rowNum) throws SQLException {
                Quote quote = new Quote();
                //TODO


                return quote;
            }
        });
    }

    @Override
    public Quote getQuoteByDateTime(String time) {
        throw new NotImplementedException();
    }

    @Override
    public void saveQuote(Quote quote) {
        throw new NotImplementedException();
    }

    @Override
    public void updateQuote(Quote quote) {
        throw new NotImplementedException();
    }

    @Override
    public void deleteQuote(Quote quote) {
        throw new NotImplementedException();
    }


    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
