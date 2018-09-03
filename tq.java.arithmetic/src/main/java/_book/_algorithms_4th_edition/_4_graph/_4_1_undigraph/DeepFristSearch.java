package _book._algorithms_4th_edition._4_graph._4_1_undigraph;

/**
 * DFS 深度优先算法
 * @author 734070824@qq.com
 * @date 2018/9/3 11:30
 */
public class DeepFristSearch {

    private boolean[] markrd;
    private int count;

    /**
     * 找到所有和起点s连通的所有顶点
     * @param G
     * @param s
     */
    public DeepFristSearch(Graph G, int s) {
        markrd = new boolean[G.V()];
        dfs(G, s);
    }

    private void dfs(Graph G, int v) {
        markrd[v] = true;
        count++;
        for(int w : G.adj(v)){
            if(!markrd[w]){
                dfs(G, w);
            }
        }
    }


    /**
     * s 和 w 是否连通
     * @param w
     * @return
     */
    public boolean marked(int w){
        return markrd[w];
    }

    public int count(){
        return count;
    }

}
