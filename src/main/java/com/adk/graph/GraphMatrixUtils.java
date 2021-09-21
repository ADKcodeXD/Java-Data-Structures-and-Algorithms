package com.adk.graph;


import java.util.Scanner;

/**
 * 邻接矩阵工具类
 * 用于创建和打印邻接矩阵
 */
public class GraphMatrixUtils {

    static void create(GraphMatrix graphMatrix){
        int i,j,k;
        char startV,endV;
        int weight;
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入顶点序列 大于顶点数的顶点将作废");
        String input = scanner.next();
        for (i=0; i< graphMatrix.VertexNum; i++){
            graphMatrix.Vertex[i]=input.charAt(i);
        }
        for(k=0; k< graphMatrix.EdgeNum; k++){
            System.out.println("第"+(k+1)+"条边");
            System.out.println("边的起点为：");
            startV=scanner.next().charAt(0);
            System.out.println("边的终点为：");
            endV=scanner.next().charAt(0);
            if (graphMatrix.HasWeight){
                System.out.println("边的权值为：");
                weight=scanner.nextInt();
            }else weight=1;
            for(i=0; graphMatrix.Vertex[i]!=startV; i++);  //在顶点数组中查找起点位置
            for(j=0; graphMatrix.Vertex[j]!=endV; j++);    //在顶点数组中查找终点位置
            graphMatrix.EdgeWeight[i][j]=weight;
            if(graphMatrix.GType==0) {
                graphMatrix.EdgeWeight[j][i] = weight;
            }
        }
    }
    static void outGraph(GraphMatrix gm){
        for(int i=0;i<gm.VertexNum;i++){
            System.out.printf("\t%c",gm.Vertex[i]); //第一行输出顶点信息
        }
        System.out.println();
        for(int i=0;i<gm.VertexNum;i++){
            System.out.printf("%c",gm.Vertex[i]);
            for(int j=0;j<gm.VertexNum;j++){
                if(gm.EdgeWeight[i][j]==gm.MAXVALUE){
                    System.out.printf("\tZ");
                }else{
                    System.out.printf("\t"+gm.EdgeWeight[i][j]);
                }
            }
            System.out.println();
        }
    }
}
