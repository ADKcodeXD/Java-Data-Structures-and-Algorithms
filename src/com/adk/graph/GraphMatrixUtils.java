package com.adk.graph;


import java.util.Scanner;

/**
 * 邻接矩阵工具类
 * 用于创建和打印邻接矩阵
 */
public class GraphMatrixUtils {

    static void create(GraphMatrix GraphMatrix){
        int i,j,k;
        char startV,endV;
        int weight;
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入顶点序列 大于顶点数的顶点将作废");
        String input = scanner.next();
        for (i=0; i< GraphMatrix.VertexNum; i++){
            GraphMatrix.Vertex[i]=input.charAt(i);
        }
        for(k=0; k< GraphMatrix.EdgeNum; k++){
            System.out.println("第"+(k+1)+"条边");
            System.out.println("边的起点为：");
            startV=scanner.next().charAt(0);
            System.out.println("边的终点为：");
            endV=scanner.next().charAt(0);
            System.out.println("边的权值为：");
            weight=scanner.nextInt();
            for(i=0; GraphMatrix.Vertex[i]!=startV; i++);  //在顶点数组中查找起点位置
            for(j=0; GraphMatrix.Vertex[j]!=endV; j++);    //在顶点数组中查找终点位置
            GraphMatrix.EdgeWeight[i][j]=weight;
            if(GraphMatrix.GType==0){
                GraphMatrix.EdgeWeight[j][i]=weight;
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
