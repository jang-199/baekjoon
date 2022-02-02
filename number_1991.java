import java.util.Scanner;

public class number_1991 {
    static class node{

        char data;
        node left;  node right;
        
        node(char data){
            this.data = data;
        }
    }
    static class tree{
        node root;
        void add_tree(char data, char left, char right){
            if(root == null){
                if(data != '.'){
                    root = new node(data);
                }
                if(left != '.'){
                    root.left = new node(left);
                }
                if(right != '.'){
                    root.right = new node(right);
                }
            }
            else{
                search_tree(root, data, left, right);
            }
        }

        void search_tree(node root,char data, char left, char right){
            if(root == null){
                return;
            }
            else if(root.data == data){
                if(left != '.'){
                    root.left = new node(left);
                }
                if(right != '.'){
                    root.right = new node(right);
                }
            }
            else{
                search_tree(root.left, data, left, right);
                search_tree(root.right, data, left, right);
            }
        }

        void preorder(node root){
            System.out.print(root.data);
            if(root.left != null){
                preorder(root.left);
            }
            if(root.right != null){
                preorder(root.right);
            }

        }
    
        void inorder(node root){
            if(root.left != null){
                inorder(root.left);
            }
            System.out.print(root.data);
            if(root.right != null){
                inorder(root.right);
            }
        }
    
        void postorder(node root){
            if(root.left != null){
                postorder(root.left);
            }
            if(root.right != null){
                postorder(root.right);
            }
            System.out.print(root.data);
        }

    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
      
        int n = sc.nextInt();
        sc.nextLine();
        tree Tree = new tree();
        for(int i=0;i<n;i++){

            String tmp[] = sc.nextLine().split(" ");
            char root = tmp[0].charAt(0);
            char left = tmp[1].charAt(0);
            char right = tmp[2].charAt(0);

            Tree.add_tree(root, left, right);
        }sc.close();
        Tree.preorder(Tree.root);
        System.out.println();
        Tree.inorder(Tree.root);
        System.out.println();
        Tree.postorder(Tree.root);
    }
}

