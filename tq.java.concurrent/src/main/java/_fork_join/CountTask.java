package _fork_join;

import java.util.concurrent.RecursiveTask;

/**
 * 计算1+2+3+4的结果
 *
 * 使用Fork／Join框架首先要考虑到的是如何分割任务，如果我们希望每个子任务最多执行两个数的相加，
 * 那么我们设置分割的阈值是2，由于是4个数字相加，所以Fork／Join框架会把这个任务fork成两个子任务，
 * 子任务一负责计算1+2，子任务二负责计算3+4，然后再join两个子任务的结果。
 * @author 734070824@qq.com
 * @date 2018/5/3 10:34
 */
public class CountTask extends RecursiveTask<Integer>{

    private static final int THRESHOLD = 2;// 阈值
    private int start;
    private int end;

    public CountTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {

        int sum = 0;
        //如果任务足够小 计算任务
        boolean canCompute = (end - start) <= THRESHOLD;
        if(canCompute){
            for (int i = start; i < end; i++) {
                sum += i;
            }
        } else {
            //任务大于阈值, 分裂任务
            int middle = (start + end) / 2;
            CountTask leftTask = new CountTask(start, middle);
            CountTask rightTask = new CountTask(middle, end);
            //执行子任务

            //这种方式是错误的, 因为 这样就形成了 当前线程等待, 另外启动两个线程来运行任务
//            leftTask.fork();
//            rightTask.fork();
            invokeAll(leftTask, rightTask);
            //等待任务完成 获取结果
            int leftResult = leftTask.join();
            int rightResult = rightTask.join();

            //合并结果
            sum = leftResult + rightResult;

        }

        return sum;
    }
}
