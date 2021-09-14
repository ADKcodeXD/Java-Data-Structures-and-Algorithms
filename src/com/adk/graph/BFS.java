package com.adk.graph;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 图的广度优先遍历
 */
public class BFS {
    public void BFSgraph(GraphMatrix graphMatrix,char startVertex){
        Deque<Integer> queue=new LinkedList<>();
        int k;
        for(k=0;graphMatrix.Vertex[k]!=startVertex&&k<graphMatrix.VertexNum;k++);
        if((k==graphMatrix.VertexNum-1)&&graphMatrix.Vertex[k]!=startVertex) return;
        //判断开始遍历的顶点是否存在，若不存在则直接结束函数

        queue.add(k);
        int [] visited=new int[graphMatrix.VertexNum];
        for (int i : visited) {
            i=0;
        }//初始化探访过的数组
        visited[k]=1;
        while (!queue.isEmpty()){
            int vertex = queue.poll();
            System.out.print(graphMatrix.Vertex[vertex]+" ");
            for (int i=vertex;i<graphMatrix.VertexNum;i++){
                for (int j=0;j<graphMatrix.VertexNum;j++){
                    if(graphMatrix.EdgeWeight[vertex][j]==1&&visited[j]!=1){
                        queue.add(j);
                        visited[j]=1;
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        GraphMatrix graphMatrix = new GraphMatrix(0, 3, 3);
        GraphMatrixUtils.create(graphMatrix);
        GraphMatrixUtils.outGraph(graphMatrix);
        BFS bfs = new BFS();
        bfs.BFSgraph(graphMatrix,'A');
    }
}
