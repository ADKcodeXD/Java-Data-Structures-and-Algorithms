package com.adk.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 平衡二叉树 是一种任意节点的左右子树的高度差都小于1的树形结构
 * 能够有效的降低树的高度
 * 完全二叉树的树高度为log2n
 * 其最小节点数为 Nh=Nh-1 + Nh-2 +1
 * 平衡二叉树要保证自身为搜索树，满足左小右大的特性同时满足平衡二叉树的性质
 * 因此插入时，需要RR RL等算法来进行调整
 */
public class AVLTree {
    /**
     * 当破坏平衡性的节点出现在被破坏的节点的右子树的右子树上，就要执行RR旋转
     * RR旋转的思路，让被破坏节点的右子树代替被破坏节点
     * 将右子树的左子树 挂在被破坏节点的右子树上
     * 然后让右子树作为根 原本的根作为左子树
     * @param avlTreeNode
     */
    public AVLTreeNode AVL_RR(AVLTreeNode avlTreeNode){
        AVLTreeNode T=avlTreeNode;
        AVLTreeNode Right=T.right;
        T.right = Right.left;
        Right.left=T;
        return Right;
    }

    /**
     * 当破坏平衡的节点出现在被破坏节点的左子树的左子树上，即执行LL旋转
     * 思路大致为 左子树代替被破坏的节点
     * 左子树的右子树 挂在被破坏节点的左子树上
     * 左子树作为跟 原本的根作为右子树
     * @param avlTreeNode
     * @return
     */
    public AVLTreeNode AVL_LL(AVLTreeNode avlTreeNode){
        AVLTreeNode T=avlTreeNode;
        AVLTreeNode Left=T.left;
        T.left=Left.right;
        Left.right=T;
        return Left;
    }

    /**
     * RL双旋 本质上是先进行右单旋再进行左旋
     * 思路为：
     * 1、定位到被破坏的节点的右子树(Right)和左子树(RightLeft)
     * 2、RightLeft的左右节点 左节点赋值给根节点的右节点（由于在右边 因此总会比根节点大） 右节点赋值给Right的左节点
     * 3、RightLeft会代替被破坏的节点 成为根节点
     * @param avlTreeNode
     * @return
     */
    public AVLTreeNode AVL_RL(AVLTreeNode avlTreeNode){
        AVLTreeNode T=avlTreeNode;
        AVLTreeNode Right=T.right;
        AVLTreeNode RightLeft=Right.left;
        T.right=RightLeft.left;
        Right.left=RightLeft.right;
        RightLeft.right=Right;
        RightLeft.left=T;
        return RightLeft;
    }

    /**
     * LR双旋， 先进行左单旋，再进行右单旋
     * 思路大体和RL大差不差
     * 1、定位到被破坏的节点的左子树(Left)和右子树(LeftRight)
     * 2、LeftRight左右节点 右节点赋值给根节点的左节点  左节点赋值给Left的右节点
     * 3、LeftRight会代替被破坏的节点 成为根节点
     * @param avlTreeNode
     * @return
     */
    public AVLTreeNode AVL_LR(AVLTreeNode avlTreeNode){
        AVLTreeNode T=avlTreeNode;
        AVLTreeNode Left=T.left;
        AVLTreeNode LeftRight=Left.right;
        T.left=LeftRight.right;
        Left.right=LeftRight.left;
        LeftRight.right=T;
        LeftRight.left=Left;
        return LeftRight;
    }
    public int getHeight(AVLTreeNode avlTreeNode){
        int h1,h2=0;
        if (avlTreeNode==null) return 0;
        else {
            h1=getHeight(avlTreeNode.left);
            h2=getHeight(avlTreeNode.right);
            return h1>h2? ++h1:++h2;
        }
    }

    /**
     * 插入构建AVL平衡二叉树 如果出现不平衡的现象则执行以上的各种不同的旋转策略
     * @param avlTreeNode
     * @return
     */
    public AVLTreeNode insert(AVLTreeNode avlTreeNode,int val){
        if(avlTreeNode==null){
            return new AVLTreeNode(0,null,null,val);
        }else if (val>avlTreeNode.val){
            avlTreeNode.right=insert(avlTreeNode.right,val);
            //增加完成 如果高度差发现等于2
            if(getHeight(avlTreeNode.right)-getHeight(avlTreeNode.left)==2){
                //比较val值和right节点的val值，如果比right节点的val值大，证明插在最右边 使用RR调整
                if(val>avlTreeNode.right.val){
                    avlTreeNode=AVL_RR(avlTreeNode);
                }else {
                    //说明值小 执行RL调整
                    avlTreeNode=AVL_RL(avlTreeNode);
                }
            }
        }else if ((val<avlTreeNode.val)){
            avlTreeNode.left=insert(avlTreeNode.left, val);
            if (getHeight(avlTreeNode.left)-getHeight(avlTreeNode.right)==2){
                //比较val值和left节点的val值，如果比left节点的val值小，证明插在最左边 使用LL调整
                if(val<avlTreeNode.left.val){
                    avlTreeNode=AVL_LL(avlTreeNode);
                }else{
                    avlTreeNode=AVL_LR(avlTreeNode);
                }
            }
        }
        return avlTreeNode;
    }
    public void levelOrderTraversal(AVLTreeNode treeNode){
        if(treeNode==null) return;
        AVLTreeNode T=treeNode;
        Queue<AVLTreeNode> queue=new LinkedList<>();
        queue.add(T);
        while (!queue.isEmpty()){
            T=queue.poll();
            System.out.print(T.val+" ");
            if (T.left!=null) queue.add(T.left);
            if (T.right!=null) queue.add(T.right);
        }
    }
    public static void main(String[] args) {
        AVLTreeNode avlTreeNode = new AVLTreeNode(0,null,null,6);
        AVLTree avlTree = new AVLTree();
        //随机生成值并插入到搜索数当中
        for (int i=0;i<10;i++){
            int val = (int)(Math.random() * 20);
            avlTreeNode=avlTree.insert(avlTreeNode,val);
        }
        avlTree.levelOrderTraversal(avlTreeNode);
    }
}
