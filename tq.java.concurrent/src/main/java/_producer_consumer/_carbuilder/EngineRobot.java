package _producer_consumer._carbuilder;

/**
 * 引擎制造机器人
 * @author 734070824@qq.com
 * @date 2018/3/10 10:42
 */
public class EngineRobot extends Robot{
    public EngineRobot(RobotPool pool) {
        super(pool);
    }

    @Override
    public void performService() {
        System.out.println(this + " install engine");
        assembler.car().addEngine();
    }
}
