package com.adk.tree;

/**
 * 二叉搜索树 是一种小的放左边，大的放右边的树结构，
 * 搜索效率取决于数的深度
 */
public class SearchTree {


    /**
     * 递归进行增加元素，如果元素小于节点，则往左边插，元素大于节点，则往右边插
     * @param treeNode
     * @param val
     * @return
     */
    public TreeNode insert(TreeNode treeNode,int val){
        if(treeNode==null){
            treeNode = new TreeNode(val, null, null);
        }else {
            if(val<treeNode.val){
                treeNode.left=insert(treeNode.left,val);
            }else if (val>treeNode.val){
                treeNode.right=insert(treeNode.right,val);
            }
        }
        return treeNode;
    }

    /**
     * 二叉搜索树的搜索，非递归实现
     * @param treeNode
     * @return
     */
    public TreeNode find(TreeNode treeNode,int val){
        while (treeNode!=null){
            if(val<treeNode.val){
                treeNode=treeNode.left;
            }else if(val>treeNode.val){
                treeNode=treeNode.right;
            }else {
                return treeNode;
            }
        }
        return null;//为空证明没找到
    }

    /**
     * 寻找最小的节点
     * @param treeNode
     * @return
     */
    public TreeNode findMin(TreeNode treeNode){
        while (treeNode.left!=null){
            treeNode=treeNode.left;
        }
        return treeNode;
    }

    /**
     * 寻找最大的节点
     * @param treeNode
     * @return
     */
    public TreeNode findMax(TreeNode treeNode){
        while (treeNode.right!=null){
            treeNode=treeNode.right;
        }
        return treeNode;
    }

    /**
     * 二叉搜索树的删除，
     * @param treeNode
     * @param val
     * @return
     */
    public TreeNode delete(TreeNode treeNode,int val){
        if(treeNode==null){
            System.out.println("删除元素未找到");
            return null;
        }else if (val>treeNode.val){
            treeNode.right=delete(treeNode.right,val);
        }else if(val<treeNode.val){
            treeNode.left=delete(treeNode.left,val);
        }else {
            if(treeNode.left!=null&&treeNode.right!=null){
                //如果要删除的节点的左右节点都不为空 两种方法
                // 1、用右子树的最小节点代替
                // 2、用左子树的最大节点代替被删除节点
                TreeNode temp=findMin(treeNode.right);
                //用最小节点的值代替该节点 删除这个最小/大节点
                treeNode.val=temp.val;
                treeNode.right=delete(treeNode.right,temp.val);
            }
            else {
                //只有一个子节点或者没有子节点的情况
                if(treeNode.right!=null){
                    treeNode=treeNode.right;
                }else if(treeNode.left!=null){
                    treeNode=treeNode.left;
                }else {
                    treeNode=null;
                }
            }
        }
        return treeNode;
    }
    public static void main(String[] args) {
        SearchTree searchTree = new SearchTree();
        Traversal traversal = new Traversal();
        TreeNode treeNode=new TreeNode(5,null,null);
        //随机生成值并插入到搜索数当中
//        for (int i=0;i<5;i++){
//            int val = (int)(Math.random() * 10);
//            searchTree.insert(treeNode,val);
//        }
        searchTree.insert(treeNode,3);
        searchTree.insert(treeNode,2);
        searchTree.insert(treeNode,4);
        searchTree.insert(treeNode,6);
        searchTree.insert(treeNode,9);
        traversal.levelOrderTraversal(treeNode);
        searchTree.delete(treeNode,3);
        System.out.println("\n=========deleted=========");
        traversal.levelOrderTraversal(treeNode);
    }
}
