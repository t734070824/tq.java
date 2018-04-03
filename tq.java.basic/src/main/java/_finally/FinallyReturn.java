package _finally;

/**
 * finally块的语句在try或catch中的return语句执行之后返回之
 * 前执行且finally里的修改语句可能影响也可能不影响try或catch中 
 * return已经确定的返回值，若finally里也有return
 * 语句则覆盖try或catch中的return语句直接返回
 * @author tangqing
 *
 */
public class FinallyReturn {
	public static void main(String[] args) {
		System.err.println(returnBeforeFinallyWithReference().num);
	}
	
	public static int returnBeforeFinally(){
		int num  =1;
		try {
			num += 2;
			return num;
		} finally {
			num = num + 2;
		}

		// 3
	}

    public static int returnaAfterFinally(){
        int num  =1;
        try {
            num += 2;
            return num;
        } finally {
            num = num + 2;
            return  num;
        }

        // 5
    }

    public static Num returnBeforeFinallyWithReference(){
        Num num  = new Num();
        try {
            num.num = 2;
            return num;
        } finally {
            num.num = 5;
        }

        // 5
    }




	
	/**
	 * 在try块中有System.exit(0);这样的语句，System.exit(0);
	 * 是终止Java虚拟机JVM的，连JVM都停止了，
	 * 所有都结束了，当然finally语句也不会被执行到
	 */
	public static void exitInTry(){
		try {
			System.err.println("try");
			System.exit(0);
		} finally {
			System.err.println("finally");
		}
	}
	
	/**
	 * try语句没有被执行到，如在try语句之前就返回了，这样finally语句就不会执行，
	 * 这也说明了finally语句被执行的必要而非充分条件是：相应的try语句一定被执行到
	 */
	public static void returnBeforeTry(){
		int num = 1;
		if(num > 0){
			return;
		}
		try {
			System.err.println("try");
		} finally {
			System.err.println("finally");
		}
	}
}
