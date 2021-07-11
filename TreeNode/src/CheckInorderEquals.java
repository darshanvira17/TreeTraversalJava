import java.util.ArrayList;
import java.util.List;

public class CheckInorderEquals {

	
	public static void main(String[] args) {
		TreeNode tree1 = new TreeNode(5);
		tree1.left = new TreeNode(3);
		tree1.left.left = new TreeNode(1);
		tree1.right = new TreeNode(7);
		tree1.right.left = new TreeNode(6);
		
		TreeNode tree2 = new TreeNode(3);
		tree2.left = new TreeNode(1);
		tree2.right = new TreeNode(6);
		tree2.right.left = new TreeNode(5);
		tree2.right.right = new TreeNode(7);
		List<Integer> a = new ArrayList<>();
		//List <Integer>b = new ArrayList<>();
		
		inorder(tree1, a);
		//inorder(tree2, b);
		//System.out.println(a.equals(b));
		
		System.out.println(inorderCheck2(tree2, a));
	}
	// Solution 1
	private static void inorder(TreeNode root, List<Integer> list) {
		if(root == null)return;
		inorder(root.left, list);
		list.add(root.val);
		inorder(root.right, list);
		
	}
	// Optimised Solution
	private static boolean inorderCheck2(TreeNode root, List<Integer> list) {
		return inorderCheck(root,list) && list.isEmpty();
	}
	private static boolean inorderCheck(TreeNode root, List<Integer> list) {
		if(root == null)return true;
		if(!inorderCheck(root.left, list)) {
			return false;
		}
		if(list.isEmpty() || list.get(0) != root.val) {
			return false;
		}
		list.remove(0);
		return inorderCheck(root.right, list);
		
	}
}
