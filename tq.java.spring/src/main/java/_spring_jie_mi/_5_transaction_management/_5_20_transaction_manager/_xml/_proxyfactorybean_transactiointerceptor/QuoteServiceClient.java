package _spring_jie_mi._5_transaction_management._5_20_transaction_manager._xml._proxyfactorybean_transactiointerceptor;

/**
 * @author 734070824@qq.com
 * @date 2018/4/16 16:13
 */
public class QuoteServiceClient {
    private IQuoteService quoteService;



    public IQuoteService getQuoteService() {
        return quoteService;
    }

    public void setQuoteService(IQuoteService quoteService) {
        this.quoteService = quoteService;
    }
}
