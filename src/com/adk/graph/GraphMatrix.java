package com.adk.graph;

public class GraphMatrix {
    public GraphMatrix(int GType, int vertexNum, int edgeNum) {
        this.GType = GType;
        VertexNum = vertexNum;
        EdgeNum = edgeNum;
    }

    public GraphMatrix(int GType, boolean hasWeight, int vertexNum, int edgeNum, char[] vertex) {
        this.GType = GType;
        HasWeight = hasWeight;
        VertexNum = vertexNum;
        EdgeNum = edgeNum;
        Vertex = vertex;
    }

    public GraphMatrix(int GType, boolean hasWeight, int vertexNum, int edgeNum, char[] vertex, int[][] edgeWeight) {
        this.GType = GType;
        HasWeight = hasWeight;
        VertexNum = vertexNum;
        EdgeNum = edgeNum;
        Vertex = vertex;
        EdgeWeight = edgeWeight;
    }

    public GraphMatrix(int GType, boolean hasWeight, int vertexNum, int edgeNum) {
        this.GType = GType;
        HasWeight = hasWeight;
        VertexNum = vertexNum;
        EdgeNum = edgeNum;
    }

    static final int MAXNUM=20;         //图的最大顶点数
    static final int MAXVALUE=65535;    //最大值
    int GType;//表示类型 有向图还是无向图 1是有向图 0无向图
    boolean HasWeight=false;
    int VertexNum;//顶点数量
    int EdgeNum;   //边的数量
    char[] Vertex=new char[MAXNUM]; //保存顶点信息
    int[][] EdgeWeight=new int[MAXNUM][MAXNUM];
}
