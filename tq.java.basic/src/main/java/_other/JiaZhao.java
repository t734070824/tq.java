package _other;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.concurrent.TimeUnit;

/**
 * @author 734070824@qq.com
 * @date 2019/2/13 15:25
 */
public class JiaZhao {

    public static void main(String[] args) throws AWTException, InterruptedException {

        Robot rb=new Robot();
        Color pixelColor = rb.getPixelColor(-705, 189);

        while (true){
            Color _pixelColor =  rb.getPixelColor(-705, 189);
            if(!_pixelColor.equals(pixelColor)){
                JOptionPane.showMessageDialog(null, "You input is "+1, "验证码", JOptionPane.PLAIN_MESSAGE);
                TimeUnit.SECONDS.sleep(60);
            }
            TimeUnit.SECONDS.sleep(5);
        }
    }


}
