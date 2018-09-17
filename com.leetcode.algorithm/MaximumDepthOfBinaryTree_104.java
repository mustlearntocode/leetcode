package com.leetcode.algorithm;

/**
 * Created by xiye on 7/24/16.
 */
public class MaximumDepthOfBinaryTree_104 {

    class  TreeNode {
        TreeNode left;
        TreeNode right;
    }
    public int maxDepth(TreeNode root) {
        if(root==null)return 0;
        else if(root.left!=null&&root.right!=null){
            //this also contains the situation that root!=null&&root.left==null&&root.right==null
            return Math.max(maxDepth(root.left), maxDepth(root.right)) +1;
        }else if(root.left!=null){
            return maxDepth(root.left) +1;
        }else{
            return maxDepth(root.right) +1;
        }
    }
}
