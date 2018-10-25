package _5_transaction._20_spring_transaction_manage;

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
