package _5_transaction._20_spring_transaction_manage;

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
