package _help;

public class CodeHelp {

    public static void main(String[] args) {
        String ss = "    |uid|int|用户id||\n" +
                "    |game|int|游戏id||\n" +
                "    |opid|int|操作ID||\n" +
                "    |deposit|int|银子数量(正负值)||\n" +
                "    |balance|long|银子余数||\n" +
                "    |ip|String|操作IP||\n" +
                "    |date|int|创建日期||\n" +
                "    |time|int|创建日期||\n" +
                "    |desc|String|操作描述||\n" +
                "    |type|int|操作类型ID||\n" +
                "    |diff|int|游戏输赢||\n" +
                "    |guid|string|唯一标识||\n" +
                "    |provinceid|string|省份||\n" +
                "    |cityid|string|城市||\n" +
                "    |district|string|地区id||";

        String[] split = ss.split("    ");
        for(String str : split){
            if(!"".equals(str)){
                String[] split1 = str.split("\\|");
                String v = split1[1];
                String type = split1[2];

                //TODO

            }
        }
    }
}
