package _demo;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

@ChannelHandler.Sharable
public class EchoClientHandler extends SimpleChannelInboundHandler<ByteBuf>{

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        String ss = "---GsLoginFirstDB:\n" +
                "gsloginfirst  kgjGJ998ghds\n" +
                "\n" +
                "---https://signin.aliyun.com/changtang/login.htm\n" +
                "账号：jiankong\n" +
                "密码：sdmFv$2;4h:3\n" +
                "\n" +
                "\n" +
                "---sonar的帐号每个人一个\n" +
                "帐号名是自己名字的缩写，密码都是123456789\n" +
                "\n" +
                "\n" +
                "---看板\n" +
                "http://192.168.1.216:5000/\n" +
                "tangqing\n" +
                "123123\n" +
                "\n" +
                "\n" +
                "--- 跳板机\n" +
                "http://192.168.101.1/users/first-login/\n" +
                "tangqing\n" +
                "123\n" +
                "\n" +
                "\n" +
                "\n" +
                "--http://dc.uc108.org:8989/work/apidocs\n" +
                "datacenter 123456789\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "--堡垒机\n" +
                "IP：192.168.101.1：2222\n" +
                "账号：tangqing\n" +
                "密码：BAQXRqCny3em\n" +
                "\n" +
                "\n" +
                "\n" +
                "--mongodb_DC_pc1:60001,mongodb_DC_pc2:60001\n" +
                "dcplaytogethermessages\n" +
                "kgkGl3KG0905\n" +
                "db:DcPlayTogetherMessagesDB\n" +
                "10.47.68.169            mongodb_dc_pc1\n" +
                "10.172.206.36           mongodb_dc_pc2\n" +
                "10.171.170.15           mongodb_DC\n" +
                "\n" +
                "查看账户\n" +
                "dcpc\n" +
                "ngJGi448gugd\n" +
                "\n" +
                "\n" +
                "--100.114.69.246:5672 光富\n" +
                "Playtogrecsvrcons\n" +
                "wpj6vry42fxn\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "---mongodb manager\n" +
                "http://120.26.119.75:8080\n" +
                "tangqing\n" +
                "pa7apxw2kc!a\n" +
                "tangqing@ct108.com\n" +
                "\n" +
                "--腾讯企业邮箱\n" +
                "tangqing@ct108.com  密码 M9gt7y4y\n" +
                "\n" +
                "--MQ 路由键创建规则\n" +
                "1. 前面主要是项目标识\n" +
                "2. 加入几个重要字段 作为参数,方便以后特殊的接受需求\n" +
                "3. 这就需要数据提供方 按照规则拼写路由建\n" +
                "\n" +
                "\n" +
                "-- 老的服务器\n" +
                "112.124.107.46, 120.26.5.156, 112.124.117.101, \n" +
                "112.124.107.126, 112.124.112.79, 112.124.118.179, 120.26.5.128\n" +
                "\n" +
                "【etl.happycoin】112.124.107.46\n" +
                "【etl.pt.game】120.26.5.156\n" +
                "【etl.pt.tcyapp】112.124.117.101\n" +
                "【orm.happycoin】112.124.107.126\n" +
                "【orm.happycoin】112.124.112.79\n" +
                "【orm.playtogether】112.124.118.179\n" +
                "【orm.playtogether】120.26.5.128\n" +
                "\n" +
                "112.124.107.46\ttangqing\toql(d6#cd1xc\t\t唐庆\t阿里云\n" +
                "120.26.5.156\ttangqing\tpa7apxw2kc!a\t\t唐庆\t阿里云\n" +
                "112.124.117.101\ttangqing\tx29s2kc$ka4m\t\t唐庆\t阿里云\n" +
                "112.124.107.126\ttangqing\tsxh3*k2#a21c\t\t唐庆\t阿里云\n" +
                "112.124.112.79\ttangqing\tcx2pzm7hjv#2\t\t唐庆\t阿里云\n" +
                "112.124.118.179\ttangqing\tmr*cfv6co6ab\t\t唐庆\t阿里云\n" +
                "120.26.5.128\ttangqing\toql(d2gcd1xc\t\t唐庆\t阿里云\n" +
                "\n" +
                "\n" +
                "--C#ETL\n" +
                "192.168.1.146:8080/r/gsapi.git         \n" +
                "\n" +
                "\n" +
                "--无线密码\n" +
                "7F-xitongyanfa\n" +
                "ctwl0007xt\n" +
                "\n" +
                "CTWL-7F-Public\n" +
                "ctwl0007\n" +
                "\n" +
                "--Score\n" +
                "ScoreDB    score  gmjGIKj39gk8\n" +
                "ScoreMsgDB  scoremsg  gjGNi04Ggi94\n" +
                "\n" +
                "--积分MQ\n" +
                "http://cluster.four.ct108.net:15672\n" +
                "\n" +
                "\n" +
                "\n" +
                "--VPN\n" +
                "账号 tangqing 密码 88jj57x3xv4m\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "--coupon补发\n" +
                "db.getCollection('consumeCash').find({'date':{$gte:20170905, $lte:20171005}}).count()\n" +
                "\n" +
                "db.getCollection('consumePoint').find({'date':{$gte:20170905, $lte:20171005}}).count()\n" +
                "\n" +
                "db.getCollection('acquireCash').find({'date':{$gte:20170905, $lte:20171005}}).count()\n" +
                "\n" +
                "db.getCollection('acquirePoint').find({'date':{$gte:20170905, $lte:20171005}}).count()\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "--语音大数据正式版MQ\n" +
                "管理后台：\n" +
                "http://120.26.2.149:15672 \n" +
                "账号： wangzs 密码： rmbcwt6zu5ax\n" +
                "\n" +
                "100.114.69.246：5672               这个是内网地址\n" +
                "118.178.176.126：5672             这个是外网地址\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "--房卡欢乐币MQ\n" +
                "mq 连接地址：slb\n" +
                "    100.114.144.18:5672(内网)\n" +
                "    101.37.102.204:5672\n" +
                "mq web管理地址：\n" +
                "    http://101.37.100.108:15672\n" +
                "    账号： cttest\n" +
                "    密码： cttest1586\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "--旧测试MQ\n" +
                "http://192.168.1.19:15672/#/\n" +
                "账号：root  密码：root321\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "--老的Consumer\n" +
                "192.168.1.102\n" +
                "tangq   j*b2hf6Jkp4m\n" +
                "\n" +
                "\n" +
                "\n" +
                "--mobile补充\n" +
                "etluser_tangq      j4dra6hnkczu\n" +
                "RabbitMQ集群\thttp://admin.rabbitmq.ct108.net:15672\n" +
                "ctbi.userext.mobile.supply\t\n" +
                "user.topic\t\n" +
                "alluser.mobile\n" +
                "\n" +
                "--测试版新MQ\n" +
                "http://192.168.101.167:15672  后台\n" +
                "账密   iom     123456   \n" +
                "\n" +
                "\n" +
                "\n" +
                "--ETL性能测试\n" +
                "wangry  89z3mrqw\n" +
                "192.168.101.22：3766\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "--新Mongodb\n" +
                "10.81.88.12  DC_scoredb12\n" +
                "10.81.87.192  DC_scoredb192\n" +
                "集群名：DC_scoredb\n" +
                "端口：60001\n" +
                "\n" +
                "admin  dcscoreread  gjnGj439ggk4\n" +
                "admin dcscore  ngJGjgjGL93t\n" +
                "MessageDB  message  kg59jgjJG84j\n" +
                "ScoreDB    score  gmjGIKj39gk8\n" +
                "admin  dcscore  ngJGjgjGL93t\n" +
                "SilverMsgDB  silvermsg  ej4u8=ejfe2*\n" +
                "SilverLogDB  silverlog  75j9yjdu49<d\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "--Q1\n" +
                "项目：\n" +
                "消息接收服务迁移\n" +
                "积分数据\n" +
                "欢乐币，房卡，注册ETL，房间登录 移交和重构\n" +
                "用户，银子，充值 重构\n" +
                "\n" +
                "重构内容：\n" +
                "统一的公共ORM服务器迁移，去掉所有的独立ORM\n" +
                "去掉所有的sourceapi\n" +
                "升级maven库到最新\n" +
                "缩写全部小写\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "--common_orm, ETL\n" +
                "\n" +
                "其中 etl用户的密码是 123\n" +
                "\n" +
                "\n" +
                "\n" +
                "--coupon队列\n" +
                "ctbi.coupon.acquire\n" +
                "\n" +
                "\n" +
                "\n" +
                "---\n" +
                "ctbi.coupon.consume\n" +
                "\n" +
                "账号密码:CtCouponSvrcons    SuTpac8w2sWI\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "--common_ormdb\n" +
                "数据库类型\tMySQL5.6\n" +
                "IP地址\trm-bp132y3ctf55woevt.mysql.rds.aliyuncs.com,3306\n" +
                "数据库\tcommon_ormdb\n" +
                "用户名\tcommon_orm\n" +
                "密码\tXWAuakvTtmr9\n" +
                "\n" +
                "\n" +
                "--etl服务器\n" +
                "47.97.10.104\tcrzngbqty\tEY3xBXGQ24TV\n" +
                "\n" +
                "--common orm 服务器\n" +
                "47.97.4.1   \tyqfxudcvn   8%T7Xazk52Rr\n" +
                "101.37.19.206   nfqwrypem  \tqtu+5GQJY-LD  \n" +
                "\n" +
                "\n" +
                "--GsCouponDB\n" +
                "mongodb://gsmongodb0:60001,iZ23dc5uwerZ:60001,aymongodrs3:60001\n" +
                "gscoupon\n" +
                "ngjG4i98dj8h\n" +
                "\n" +
                "\n" +
                "\n" +
                "--银子\n" +
                "120.26.5.179\n" +
                "账号：vm2ix9s\n" +
                "密码：k2d9z#kd*jec\n" +
                "\n" +
                "\n" +
                "\n" +
                "--HaProxy\n" +
                "http://116.62.7.226:1089/stats\n" +
                "admin\n" +
                "admin\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "--查看外网正式数据\n" +
                "114.55.33.82\n" +
                "winServer\n" +
                "账号：jfr3ci5\n" +
                "密码：hshq#o21z*ma\n" +
                "\n" +
                "--跳板机\n" +
                "192.168.1.134\n" +
                "账号：tangqing\n" +
                "密码： Lzni0aPMBPCMK54O\n" +
                "新密码： 123\n" +
                "\n" +
                "\n" +
                "--Mogondb\n" +
                "db.getCollection('thirddetails').ensureIndex({\"tuid\":1, \"utype\":1})\n" +
                "\n" +
                "\n" +
                "---SLB\n" +
                "你好 这边要做一下SLB, TCP连接\n" +
                "服务器和端口\n" +
                "47.97.8.14:7922\n" +
                "101.37.19.118:7922\n" +
                "绑定的域名为 user.dcorm.tcy365.net:7922\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "--- MogonDB\n" +
                "<config name=\"GsMessageDB\" address=\"mongodb://gscountsvr:!ee!37x866!g@gsmongodb0:60001,iZ23dc5uwerZ:60001,aymongodrs3:60001/?connect=replicaset;safe=true;connectTimeoutMS=20000000;socketTimeoutMS=20000000;replicaSet=mongoSet\" db=\"GsMessageDB\"></config>\n" +
                "\n" +
                "\n" +
                "10.46.65.186\tiZ23lvbv74bZ\n" +
                "10.47.52.112    logsdkdb3\n" +
                "\n" +
                "10.160.5.83\tiZ23sik43yxZ\n" +
                "10.117.179.205\tiZ23etew6t1Z\n" +
                "\n" +
                "\n" +
                "10.46.72.111 iZ23dc5uwerZ\n" +
                "10.160.51.147    gsmongodb1\n" +
                "10.132.12.251    aymongodrs3\n" +
                "10.160.11.51    gsmongodb2\n" +
                "10.174.32.227    gsmongodb3\n" +
                "10.173.164.14    gsmongodb0\n" +
                "\n" +
                "\n" +
                "127.0.0.1    gssvc.ct108.net\n" +
                "222.73.110.21    grsvc.uc108.net\n" +
                "10.173.140.109    ipas.tc108.net\n" +
                "127.0.0.1 gsapi.ct108.net\n" +
                "\n" +
                "127.0.0.1 bi.ct108.net\n" +
                "\n" +
                "\n" +
                "10.172.205.90   mongodb_DC_tcyapp1\n" +
                "10.172.206.32   mongodb_DC_tcyapp2\n" +
                "\n" +
                "10.25.169.76    mongodb_DC_GS_mobile1\n" +
                "10.26.92.176    mongodb_DC_GS_mobile2\n" +
                "  \n" +
                "10.47.68.169       mongodb_dc_pc1\n" +
                "10.172.206.36    mongodb_dc_pc2\n" +
                "\n" +
                "\n" +
                "\n" +
                "--赋予新用户文件权限\n" +
                "chown etl:etl etl.orm.user\n" +
                "\n" +
                "--外网正式MQ\n" +
                "http://admin.rabbitmq.ct108.net:15672/#/\n" +
                "hdyl\n" +
                "hdyl\n" +
                "\n" +
                "--Consumer ETL\n" +
                "数据库类型\tMySQL5.6\n" +
                "IP地址\trm-bp132y3ctf55woevt.mysql.rds.aliyuncs.com,3306\n" +
                "数据库\trabbitmq_consumerdb\n" +
                "用户名\trabbitmq\n" +
                "密码\tAzIw8QJsmYte\n" +
                "\n" +
                "\n" +
                "10.46.72.111   60001   GsUserDB \n" +
                "GsUserDB gsuser ngjhjGJ93jg8\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "--supervisor\n" +
                "\n" +
                "必须要python2的pip\n" +
                "\n" +
                "pip install supervisor\n" +
                "\n" +
                "\n" +
                "输出配置文件  echo_supervisord_conf  > /etc/supervisord.conf\n" +
                "\n" +
                "\n" +
                "更改配置文件    vi   /etc/supervisord.conf\n" +
                "--包含  files =  /etc/supervisor.conf.d/*.conf\n" +
                "\n" +
                "启动进程 supervisord -c /etc/supervisord.conf\n" +
                "\n" +
                "\n" +
                "\n" +
                "cd /etc\n" +
                "mkdir supervisor.conf.d\n" +
                "cd   supervisor.conf.d/\n" +
                "touch etl.conf\n" +
                "vi etl.conf\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "=========================================================\n" +
                "\n" +
                "\n" +
                "\n" +
                "--禅道\n" +
                "禅道系统登录的地址如下：\n" +
                "内网地址：http://192.168.1.15/zentao/my/\n" +
                "外网地址：http://122.224.230.90:45141/zentao/my/\n" +
                "第一次登录系统时，已有管理员创建好账户，用户名和公司邮箱前缀一致（如徐玉杰，禅道用户名为xuyj），初始密码为 111111 ，登录后请自行修改密码。\n" +
                "\n" +
                "\n" +
                "\n" +
                "--测试服务器\n" +
                "192.168.1.131 132 133\n" +
                "3766\n" +
                "账号： wangzs \n" +
                "密码： frg5ghf6\n" +
                "\n" +
                "--jenkins\n" +
                "192.168.1.27 zsj    qwe123\n" +
                "\n" +
                "--提测\n" +
                "每个服务或者网站的：\n" +
                "服务器IP\n" +
                "发布目录\n" +
                "mongodb 端口 （1，2是机械盘   45是ssd盘）\n" +
                "服务名称\n" +
                "\n" +
                "\n" +
                "发送人  相应测试\n" +
                "抄送  测试和数据中心的主管，项目成员\n" +
                "\n" +
                "\n" +
                "--第一天\n" +
                "用户名 tangqing@ct108.com  密码 m9gt7y4y\n" +
                "业务后台：https://admin.ct108.net:777/Syslogin.aspx? 用户名 tangqing 密码 m9gt7y4y\n" +
                "\n" +
                "无线网：7F-public ctwl0007\n" +
                "\n" +
                "\n" +
                "http://192.168.1.19:15672/#/   root/root\n" +
                "\n" +
                "GIT\n" +
                "\thttp://192.168.1.146:8080/\n" +
                "\thttp://192.168.101.244/users/sign_in\n" +
                "\ttangqing  dgjgi09f\n" +
                "\n" +
                "oa系统：http://oa.ct108.com/Login/Index 用户名 tangqing 密码 111\t\n" +
                "\n" +
                "http://192.168.1.27:8090/login?from=%2F Jenkins\n" +
                "zsj\n" +
                "qwe123\n" +
                "\n" +
                "\n" +
                "https://192.168.1.146/svn/dataResearch  账号密码和gitlab的一样\n" +
                "tangqing  dgjgi09f\n" +
                "\n" +
                "192.168.101.39  \n" +
                "shusf  \n" +
                "hwefkdcn\n" +
                "\n" +
                "\n";
        String ss1 = "TQ";
        ctx.writeAndFlush(Unpooled.copiedBuffer(ss1, CharsetUtil.UTF_8));
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, ByteBuf in) throws Exception {
        //从服务器接收到一条消息被调用
        System.err.println("Client received: " + in.toString(CharsetUtil.UTF_8));

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
