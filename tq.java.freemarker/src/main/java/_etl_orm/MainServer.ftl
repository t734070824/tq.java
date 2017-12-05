package dc.orm.${project_name}.server;

import ct.dc.libinfrastructure.CommonUtils;
import ct.dc.libinfrastructure.ConfigUtils;
import ct.dc.libinfrastructure.ConvertUtils;
import ct.dc.liblogs.ICtDataLogger;
import ct.dc.liblogs.impl.CtDataLoggerImpl;
import ct.dc.liblogs.model.LogContent;
<#list service_list as service_list>  
import dc.orm.${project_name}.libprotocol.service.${service_list.name}; 
</#list>  
import org.apache.thrift.TMultiplexedProcessor;
import org.apache.thrift.server.THsHaServer;
import org.apache.thrift.server.TServer;
import org.apache.thrift.transport.TNonblockingServerSocket;
import org.apache.thrift.transport.TTransportException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Author:      ${email}
 * CreateDate:   ${date?string("yyyy-MM-dd")}
 */
public class MainServer {
    private final static ICtDataLogger LOGGER = new CtDataLoggerImpl(MainServer.class);
    private final static String SERVER_CONFIG_NAME = "thrift";
    private final static String SPRING_CONFIG_NAME = "springContext.xml";
    private final static Integer PORT_DEFAULT = 9000;
    private static Integer port;
    private static ApplicationContext ctx;

<#list service_list as service_list>  
    private static final String ${service_list.finalname} = "${service_list.name}";
</#list> 


    // 程序的入口
    public static void main(String args[]) {
        LOGGER.info("正在初始化信息...");
        initConfig();
        initSpring();
        start();
    }

    /**
     * 初始化Sping
     */
    private static void initSpring() {
        ctx = new ClassPathXmlApplicationContext(SPRING_CONFIG_NAME);
    }

    private static void initConfig() {
        ConfigUtils util = new ConfigUtils(SERVER_CONFIG_NAME);
        String portStr = util.getConfig("thrift.port", PORT_DEFAULT.toString());
        port = ConvertUtils.str2int(portStr, PORT_DEFAULT);
    }

    private static UserRegDetailService.Iface getUserRegDetailService() {
        return ctx.getBean(USER_REG_DETAIL_SERVICE, UserRegDetailService.Iface.class);
    }
    private static ThirdUserRegDetailService.Iface getThirdUserRegDetailService() {
        return ctx.getBean(THIRDUSER_REG_DETAIL_SERVICE, ThirdUserRegDetailService.Iface.class);
    }

    /**
     * 启动服务
     */
    private static void start() {
        LOGGER.info(String.format("监听端口：%d, 服务准备启动中...", port));
        try {
            TNonblockingServerSocket serverTransport = new TNonblockingServerSocket(port);
            THsHaServer.Args arg = new THsHaServer.Args(serverTransport);
            TMultiplexedProcessor processor = new TMultiplexedProcessor();
            processor.registerProcessor(USER_REG_DETAIL_SERVICE,
                    new UserRegDetailService.Processor<>(getUserRegDetailService()));
            processor.registerProcessor(THIRDUSER_REG_DETAIL_SERVICE,
                    new ThirdUserRegDetailService.Processor<>(getThirdUserRegDetailService()));
            arg.processor(processor);
            TServer server = new THsHaServer(arg);
            server.setServerEventHandler(new ServerEventHandler());
            server.serve();
        } catch (TTransportException e) {
            LogContent content = new LogContent();
            content.setEvent("Thrift_Start_Error");
            content.setContent(CommonUtils.getStackErrors(e));
            LOGGER.error(content);
        }
    }
}
