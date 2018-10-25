package _5_transaction._20_spring_transaction_manage._proxyfactorybean_transactioninterceptor;

import _3_aop._10_spring_aop_process_two.Foo;
import _5_transaction._20_spring_transaction_manage.Quote;
import _5_transaction._20_spring_transaction_manage.QuoteServiceClient;
import org.springframework.beans.factory.config.PropertyResourceConfigurer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 734070824@qq.com
 * @date 2018/10/13 14:35
 */
public class ProxyfactorybeanTransactioninterceptorApp {

    public static void main(String[] args) {
//        ApplicationContext context = new ClassPathXmlApplicationContext("_3_aop/_10_spring_aop_process_two/aspect.xml");
        ApplicationContext context =
                new ClassPathXmlApplicationContext("" +
                        "_5_transaction/_20_spring_transaction_manage/_proxyfactorybean_transactioninterceptor/proxyfactorybeantransactioninterceptor.xml");
        QuoteServiceClient client = (QuoteServiceClient) context.getBean("client");
//        Quote quote = client.getQuoteService().getQuote();
//        System.err.println(quote);

        client.getQuoteService().saveQuote(new Quote());
    }

}
