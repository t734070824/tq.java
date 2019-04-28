package _private_protect_public_friendly;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author 734070824@qq.com
 * @date 2019/4/26 16:59
 */
public class PrivateCon {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> aClass = Class.forName("_private_protect_public_friendly.Bank");
        Constructor<?> declaredConstructor = aClass.getDeclaredConstructor();
        declaredConstructor.setAccessible(true);
        Bank o = (Bank)declaredConstructor.newInstance();


    }
}
