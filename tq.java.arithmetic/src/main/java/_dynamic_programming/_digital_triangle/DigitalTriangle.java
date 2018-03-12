package _dynamic_programming._digital_triangle;

/**
 * 数字三角形
 * @author 734070824@qq.com
 * @date 2018/3/10 13:23
 */
public class DigitalTriangle {

    public static int ARRAY_LENGTH = 4;

    public static int[][] ARRAY = {{7},{3, 8}, {8,1,1},{2,7,4,4},{4,5,2,6,5}};

    public static int[][] maxSum = new int[5][5];

    public static void main(String[] args) {
        System.err.println(MaxSum_recursion_nocache(0,0));
        System.err.println(MaxSum_recursion_cache(0,0));


    }

    public static int MaxSum_recursion_nocache(int i, int j){
        if(i == ARRAY_LENGTH) return ARRAY[i][j];
        else {
            int x = MaxSum_recursion_nocache(i + 1, j);
            int y = MaxSum_recursion_nocache(i + 1, j + 1);
            return Math.max(x, y) + ARRAY[i][j];
        }
    }

    public static int MaxSum_recursion_cache(int i, int j){
        System.err.println(i + "--" + j);
        if(maxSum[i][j] != 0) return maxSum[i][j];
        if(i == ARRAY_LENGTH){
            maxSum[i][j] =  ARRAY[i][j];
        } else {
            int x = MaxSum_recursion_nocache(i + 1, j);
            int y = MaxSum_recursion_nocache(i + 1, j + 1);
            maxSum[i][j] = Math.max(x, y) + ARRAY[i][j];
        }
        return maxSum[i][j];
    }
}
