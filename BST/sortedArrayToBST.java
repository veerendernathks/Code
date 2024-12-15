package BST;

import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class sortedArrayToBST {
    public TreeNode sortedArrayToBSTFun(int[] nums, int start, int end)
    {
        if(start>end)
        {
            return null;
        }
        int mid = (start+end)/2;
        TreeNode tn = new TreeNode(nums[mid]);
        tn.left = sortedArrayToBSTFun(nums,start, mid-1);
        tn.right = sortedArrayToBSTFun(nums,mid+1, end);
        return tn;
    }
    public TreeNode sortedArrayToBST(int[] nums)
    {
        return sortedArrayToBSTFun(nums,0,nums.length-1);
    }
    public static void inorderTraversal(TreeNode root)
    {
        if (root != null) {
            inorderTraversal(root.left);
            System.out.print(root.val + " ");
            inorderTraversal(root.right);
        }
    }
    public static void printLevelOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.val + " ");

            // Add left and right children to the queue if they exist
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }
    public static void main(String[] args) {
        int[] nums = {-3, -2, 1, 0, 1, 2, 3};
        sortedArrayToBST solution = new sortedArrayToBST();
        TreeNode root = solution.sortedArrayToBST(nums);
        printLevelOrder(root);
    }
}
