package com.adk.graph;

import com.adk.sort.ShellSort;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Kruskal最小生成树算法
 * 思想:1、对图的所有边的权值进行排序
 * 2、由小到大加入图中，如果边构成回路则不加入
 * 3、当边数达到Vertex-1时，最小生成树生成
 *
 * 判断:1、图中是否存在环？
 * 使用parent[Vertex]来记录
 * 例如A-B  B-C C-D D-A
 * 可知parent[A]=B
 * parent[B]=C
 * parent[C]=D
 * D-A加入时 parent[D]=D
 * parent[A]=B -> parent[B]=C parent[C]=D parent[D]=D 返回D
 * 因此两个节点同源 可以判断其存在环路
 */
public class Kruskal {
    /**
     * kruskal实现最小生成树算法
     * 返回一个图 存放一个最小生成树路径 由最小的顶点出发进行遍历 。
     * @param graphMatrix
     * @return
     */
    public static GraphMatrix kruskalMst(GraphMatrix graphMatrix){
        int[] parent=new int[graphMatrix.VertexNum];
        int WeightTotal=0;
        for(int i=0;i<parent.length;i++) parent[i]=i;
        List<List<Integer>> Edge=new ArrayList<>();
        //[0,1,5]代表一个边  从0开始 到1结束 权值为5
        for (int i=0;i<graphMatrix.VertexNum;i++) {
            for (int j = 0; j < graphMatrix.VertexNum; j++) {
                if (graphMatrix.EdgeWeight[i][j] != 0) {
                    //默认是无向图 因此可以将j,i的位置置为0
                    //也就是add一条边即可
                    graphMatrix.EdgeWeight[j][i] = 0;
                    List<Integer> EdgeNode = new ArrayList<>();
                    EdgeNode.add(i);
                    EdgeNode.add(j);
                    EdgeNode.add(graphMatrix.EdgeWeight[i][j]);
                    Edge.add(EdgeNode);
                }
            }
        }
        //对边的权值进行排序 使用冒泡排序（考虑到结点较小
        edgeSort(Edge);
        //新建一个邻接矩阵存放最小生成树
        GraphMatrix gm = new GraphMatrix(graphMatrix.GType,graphMatrix.HasWeight,graphMatrix.VertexNum,graphMatrix.EdgeNum,graphMatrix.Vertex,new int[graphMatrix.VertexNum][graphMatrix.VertexNum]);
        for(int i=0;i<Edge.size();i++){
            //如果 边数已经到达顶点数-1 说明已经到达了最小生成树的最大边数 因此不需要遍历后面的边了
            if (gm.EdgeNum==gm.VertexNum-1) break;
            int EdgePoint1=Edge.get(i).get(0);
            int EdgePoint2=Edge.get(i).get(1);
            //获取开始点和结束点
            int a=getRoot(parent,EdgePoint1);
            int b=getRoot(parent,EdgePoint2);
            //通过并查集 追溯源点
            if (a!=b) parent[a]=b;
            else continue;
            //如果追溯到的源点不相同 说明图中无环 可以将其加入最小生成树中
            //新生成的邻接矩阵将边放入
            gm.EdgeWeight[EdgePoint1][EdgePoint2]=Edge.get(i).get(2);
            gm.EdgeWeight[EdgePoint2][EdgePoint1]=Edge.get(i).get(2);
            //总权值相加
            WeightTotal+=Edge.get(i).get(2);
        }
        System.out.println("\n最小生成树总路径为:"+WeightTotal);
        return gm;
    }
    public static int getRoot(int[] parent,int x){
        while(parent[x]!=x){
            x=parent[x];
        }
        return x;
    }
    public  static List<List<Integer>> edgeSort(List<List<Integer>> Edge){
        //冒泡排序
        for (int i=0;i<Edge.size()-1;i++){
            for (int j=0;j<Edge.size()-i-1;j++){
                if(Edge.get(j).get(2)>Edge.get(j+1).get(2)){
                    Collections.swap(Edge,j,j+1);
                }
            }
        }
        return Edge;
    }

    public static void main(String[] args) {
        char[] vertex={'A','B','C','D','E','F'};
        int[][] weight={{0,6,1,5,0,0},{6,0,5,0,3,0},{1,5,0,5,6,4},{5,0,5,0,0,2},{0,3,6,0,0,6},{0,0,4,2,6,0}};
        GraphMatrix graphMatrix = new GraphMatrix(0,true,6,10,vertex,weight);
        int [] visited=new int[graphMatrix.VertexNum];

        for (int i : visited) {
            i=0;
        }//初始化探访过的数组
        DFS.DFSgraph(graphMatrix,0,visited);


        for (int i=0 ;i< visited.length;i++) {
            visited[i]=0;
        }//初始化探访过的数组
        GraphMatrix kruskalMst = kruskalMst(graphMatrix);

        System.out.println("===============最小生成树====================");
        DFS.DFSgraph(kruskalMst,0,visited);
    }
}
