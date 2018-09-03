package _book._algorithms_4th_edition._4_graph._4_1_undigraph;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.io.File;

/**
 * @author 734070824@qq.com
 * @date 2018/9/3 19:12
 */
public class TestPath {

    static String file = "src/main/java/_book/_algorithms_4th_edition/_4_graph/_4_1_undigraph/tinyCG.txt";

    public static void main(String[] args) {
        Graph G = new Graph(new In(new File("file")));
        int s= 0;
        Paths search = new Paths(G, s);
        for (int v = 0; v < G.V(); v++) {
            StdOut.print(s + "TO" + v + ": ");
            if(search.hasPathTo(v)){
                for (Integer x : search.pathTo(v)) {
                    if(x == v){
                        StdOut.print(x);
                    }else {
                        StdOut.print("-" +x);
                    }

                }
                    
            }
            StdOut.println();

        }

    }
}
