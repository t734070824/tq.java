package _book._algorithms_4th_edition._4_graph._4_1_undigraph;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.io.File;

/**
 * @author 734070824@qq.com
 * @date 2018/9/3 11:00
 */
public class TestSearch {

    static String file = "src/main/java/_book/_algorithms_4th_edition/_4_graph/_4_1_undigraph/tinyCG.txt";

    public static void main(String[] args) {
        Graph G = new Graph(new In(new File(file)));
        int s = 0;
        Search search = new Search(G, s);
        for (int v = 0; v < G.V(); v++) {
            if(search.marked(v)){
                StdOut.print(v + "");
            }
            StdOut.println();
        }
        if(search.count() != G.V()){
            StdOut.print("Not ");
        }
        StdOut.print("connnected");

    }
}
