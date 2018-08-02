package _jdk7_new._autoclose_try;

/**
 * @author 734070824@qq.com
 * @date 2018/8/1 11:43
 */
public class App {

    public static void main(String[] args) {

        try(Resource resource = new Resource()){
            resource.get();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
