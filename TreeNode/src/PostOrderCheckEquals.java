import java.util.ArrayList;
import java.util.List;

public class PostOrderCheckEquals {
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
		
		postorder(tree1, a);
		//System.out.println(a.equals(b));
		System.out.println(postorderCheck2(tree2, a));
	}
	private static void postorder(TreeNode root, List<Integer> list) {
		if(root == null)return;
		postorder(root.left, list);
		postorder(root.right, list);
		list.add(root.val);
		System.out.println(list);
	}
	// Optimised Solution
		private static boolean postorderCheck2(TreeNode root, List<Integer> list) {
			return postorderCheck(root,list) && list.isEmpty();
		}
		private static boolean postorderCheck(TreeNode root, List<Integer> list) {
			if(root == null)return true;
			if(!postorderCheck(root.left, list)) {
				return false;
			}
			if(list.isEmpty() || list.get(0) != root.val) {
				return false;
			}
			list.remove(0);
			return postorderCheck(root.right, list);
			
		}
}
