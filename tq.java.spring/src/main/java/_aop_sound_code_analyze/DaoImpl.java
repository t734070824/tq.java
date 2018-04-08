package _aop_sound_code_analyze;

/**
 * @author 734070824@qq.com
 * @date 2018/4/8 16:42
 */
public class DaoImpl implements Dao {

    @Override
    public void select() {
        System.out.println("Enter DaoImpl.select()");
    }

    @Override
    public void insert() {
        System.out.println("Enter DaoImpl.insert()");
    }

}
