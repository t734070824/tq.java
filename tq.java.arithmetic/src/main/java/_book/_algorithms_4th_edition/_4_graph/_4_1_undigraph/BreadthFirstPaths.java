package _book._algorithms_4th_edition._4_graph._4_1_undigraph;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;

/**
 * 使用广度优先搜索查找图中的路径
 * @author 734070824@qq.com
 * @date 2018/9/3 19:59
 */
public class BreadthFirstPaths {
    //到达该顶点的最短路径已知吗?
    private boolean[] marked;

    //从起点到一个顶点已知路径上的最后一个顶点
    private int[] edgeTo;

    //起点
    private final  int s;

    public BreadthFirstPaths(Graph G, int s) {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.s = s;
        bfs(G, s);
    }

    private void bfs(Graph G, int s) {
        Queue<Integer> queue = new Queue<>();
        //标记起点
        marked[s] = true;
        //加入队列
        queue.enqueue(s);
        while (!queue.isEmpty()) {
            //删除并获取顶点
            Integer v = queue.dequeue();
            for (Integer w : G.adj(v)) {
                if(!marked[w]){
                    edgeTo[w] = v;
                    marked[w] = true;
                    queue.enqueue(w);
                }
            }
        }
    }

    public boolean hasPathTo(int v){
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v){
        if(!hasPathTo(v)){
            return null;
        }
        Stack<Integer> path = new Stack<>();
        for(int x = v; x != s; x = edgeTo[x]){
            path.push(x);
        }
        path.push(s);
        return path;
    }
}
