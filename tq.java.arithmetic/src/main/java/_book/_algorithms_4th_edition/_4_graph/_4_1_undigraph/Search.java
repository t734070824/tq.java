package _book._algorithms_4th_edition._4_graph._4_1_undigraph;

/**
 * 图处理算法
 * @author 734070824@qq.com
 * @date 2018/9/3 10:46
 */
public class Search {

    private Graph G;
    //起点
    private int source;

    public Search(Graph g, int s) {
        G = g;
        this.source = s;
    }

    /**
     * v 和 s是否连通
     * @param v
     * @return
     */
    public boolean marked(int v){
        //是能说明两个顶点是否直连
//        for(int w: G.adj(source)){
//            if(w == v) {
//                return true;
//            }
//        }
//        return false;
        DeepFristSearch dfs = new DeepFristSearch(G, source);
        return dfs.marked(v);

    }

    /**
     * 和 s 连通的顶点总数
     * @return
     */
    public  int count(){
        DeepFristSearch dfs = new DeepFristSearch(G, source);
        return dfs.count();
    }

}
