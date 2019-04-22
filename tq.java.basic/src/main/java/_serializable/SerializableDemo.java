package _serializable;

import java.io.*;

/**
 * @author 734070824@qq.com
 * @date 2019/4/22 10:05
 */
public class SerializableDemo {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        User user = new User();
        user.setName("ta");
        user.setAge(123);

        System.err.println(user);

        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("tmpFile"));
        out.writeObject(user);

        out.close();


        //Read Obj from File
//        File file = new File("tmpFile");
//        ObjectInputStream ois = null;
//        ois = new ObjectInputStream(new FileInputStream(file));
//        User newUser = (User) ois.readObject();
//        System.out.println(newUser);

        File file = new File("tmpFile");
        ObjectInputStream ois = null;
        ois = new ObjectInputStream(new FileInputStream(file));
        _java.User newUser = (_java.User) ois.readObject();
        System.out.println(newUser);



    }
}
