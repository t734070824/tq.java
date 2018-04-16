package _spring_jie_mi._5_transaction_management._5_20_transaction_manager._xml._proxyfactorybean_transactiointerceptor;

/**
 * @author 734070824@qq.com
 * @date 2018/4/16 15:25
 */
public interface IQuoteService {
    Quote getQuote();

    Quote getQuoteByDateTime(String time);

    void saveQuote(Quote quote);

    void updateQuote(Quote quote);

    void deleteQuote(Quote quote);

}
