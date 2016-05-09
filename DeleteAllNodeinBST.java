
import LeetCode.TreeNode;

public class DeleteAllNodeinBST {
	//Google Phone II
	
	//O(n) space, O(n) time 
	public void recursiveDel(TreeNode r){
		if(r!=null){
			recursiveDel(r.left);
			recursiveDel(r.right);
			r.val=0;
			r=null;
		}
	}

	public void inorderMorrisTraversal(TreeNode r){
		TreeNode cur=r, pre=null;
		while(cur!=null){
			if(cur.left==null){
				System.out.println(cur.val);
				cur.val=0;
				cur=cur.right;
			}
			else{
				
				pre=cur.left;
				while(pre.right!=null && pre.right!=cur){
					pre=pre.right;
				}
				if(pre.right==null) 
				{
					pre.right=cur;
					cur=cur.left;
				}
				else{
					pre.right=null;
					System.out.println(cur.val);
					cur.val=0;
					cur=cur.right;
				}
			}
		}
	}
	
	
	
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(6);
		TreeNode a = new TreeNode(2);
		TreeNode b = new TreeNode(1);
		TreeNode c = new TreeNode(4);
		TreeNode d = new TreeNode(3);
		TreeNode e = new TreeNode(7);
		root.left=a;
		root.right=e;
		root.left.left=b;
		root.left.right=c;
		root.left.right.left=d;
		
		DeleteAllNodeinBST del = new DeleteAllNodeinBST();
		del.inorderMorrisTraversal(root);
		del.inorderMorrisTraversal(root);

	}

}
