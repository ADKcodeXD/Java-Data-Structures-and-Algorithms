package com.adk.tree;

import com.adk.util.CreateNums;
import com.adk.util.Util;

/**
 * 最大堆，一种根节点为最大数值的完全二叉树
 * 可以使用数组来代替表示
 * 0号位为空节点
 * 从一号位开始计算
 * 2i 以及2i+1节点为i节点的左右子树
 */
public class MaxHeap {
    public MaxHeapNode maxHeapNode;

    public MaxHeap(MaxHeapNode maxHeapNode) {
        this.maxHeapNode = maxHeapNode;
    }

    public MaxHeap() {

    }

    /**
     * 最大堆的初始化。
     * @param data
     */
    public void init(int[] data){
        if(data.length>maxHeapNode.maxSize){
            System.out.println("初始化失败");
            return;
        }
        for(int i=0;i<data.length;i++)
            maxHeapNode.data[i+1]=data[i];
        maxHeapNode.size=data.length;
        initData(maxHeapNode.data,1);
    }

    /**
     * 递归构建最大堆
     * @param data
     * @param parent
     */
    private void initData(int[] data,int parent){
        int child=parent*2;
        if(child>maxHeapNode.size){
            //说明是叶子节点了 直接返回
            return;
        }

        initData(data,child);
        if(data[child]>data[parent]||data[child+1]>data[parent]){
            //采用中序的遍历，先构建左边后构建右边
            if(data[child]>data[child+1]){
                int temp=data[parent];
                data[parent]=data[child];
                data[child]=temp;
            }else {
                int temp=data[parent];
                data[parent]=data[child+1];
                data[child+1]=temp;
            }
        }
        initData(data,child+1);
        //
    }
    /**
     * 最大堆的删除 只会删掉最大的节点
     * 并且让最后一个节点替换为根节点 ，然后比较两个子节点哪个大
     * 让大的那个进行交换。
     * @return
     */
    public int deleteMax(){
        if(maxHeapNode.size==0){
            System.out.println("当前最大堆为空");
            return -1;
        }
        int maxItem=maxHeapNode.data[1];
        int temp=maxHeapNode.data[maxHeapNode.size];
        maxHeapNode.data[maxHeapNode.size--]=0;
        int parent,child;
        for (parent=1;parent*2<=maxHeapNode.size;parent=child){
            child=parent*2;
            if(child!=maxHeapNode.size && maxHeapNode.data[child]<maxHeapNode.data[child+1]){
                //如果子节点不为最后一个节点 是最后一个节点的话 无法进行++了
                child++;
            }
            if(maxHeapNode.data[child]>=temp){
                //如果子节点大于temp值，说明temp值不应该放在这里
                maxHeapNode.data[parent]=maxHeapNode.data[child];
                //就要继续往下过滤
            }else break;//否则 说明这个位置的根节点应该放上temp值
        }
        maxHeapNode.data[parent]=temp;
        return maxItem;
    }

    public void insert(int num){
        if(maxHeapNode.size==maxHeapNode.maxSize){
            System.out.println("最大堆已满");
            return;
        }
        int i=++maxHeapNode.size;//size+1赋值给i 代表最后一个元素所在位置
        for(;maxHeapNode.data[i/2]<num;i/=2){
            maxHeapNode.data[i]=maxHeapNode.data[i/2];
        }
        maxHeapNode.data[i]=num;
    }

    public static void main(String[] args) {
        MaxHeapNode maxHeapNode = new MaxHeapNode(200);
        MaxHeap maxHeap = new MaxHeap(maxHeapNode);
        int[] list = CreateNums.CreateList(100,1,250);
        Util.printNums(list);
        maxHeap.init(list);
        Util.printNums(maxHeap.maxHeapNode.data);

    }
}
