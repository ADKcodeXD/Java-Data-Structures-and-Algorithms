package com.adk.graph;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 图的深度优先遍历 邻接矩阵版
 * 入队一个图节点然后出队进行遍历
 * 设置一个探访数组
 * 如果出队后看到有出口 首先做回溯
 * 回溯到visit数组全部为1为止
 */
public class DFS {

    public static int DFSgraph(GraphMatrix graphMatrix,int startVertex,int[] visited){
        visited[startVertex]=1;
        System.out.print(graphMatrix.Vertex[startVertex]+" ");
        for(int i=0;i<graphMatrix.VertexNum;i++){
            if(graphMatrix.EdgeWeight[startVertex][i]!=0&&visited[i]!=1){
                System.out.print("("+graphMatrix.Vertex[startVertex]+"--->"+graphMatrix.Vertex[i]+") ");
                DFSgraph(graphMatrix, i, visited);
            }
        }
        return startVertex;
    }
    public static void main(String[] args) {
        GraphMatrix graphMatrix = new GraphMatrix(0, 4, 4);
        int [] visited=new int[graphMatrix.VertexNum];
        for (int i : visited) {
            i=0;
        }//初始化探访过的数组
        DFS dfs = new DFS();
        GraphMatrixUtils.create(graphMatrix);
        GraphMatrixUtils.outGraph(graphMatrix);
        DFSgraph(graphMatrix,1,visited);
    }
}
