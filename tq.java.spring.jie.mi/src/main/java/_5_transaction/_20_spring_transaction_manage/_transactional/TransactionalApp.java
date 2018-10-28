package _5_transaction._20_spring_transaction_manage._transactional;

import _5_transaction._20_spring_transaction_manage.Quote;
import _5_transaction._20_spring_transaction_manage.QuoteServiceClient;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * TransactionProxyFactoryBea 事务管理
 * @author 734070824@qq.com
 * @date 2018/10/13 14:35
 */
public class TransactionalApp {

    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("" +
                        "_5_transaction/_20_spring_transaction_manage/_transactional/transactional.xml");
        QuoteServiceClient client = (QuoteServiceClient) context.getBean("client");
//        Quote quote = client.getQuoteService().getQuote();
//        System.err.println(quote);

        client.getQuoteService().saveQuote(new Quote());
    }

}
