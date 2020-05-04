import java.util.Arrays;

/*Write a function that returns the number of distinct binary search trees 
  that can be constructed with n nodes.For the purpose of this exercise, do
  Example One
  Input: 2
  Output: 2
  Example two 
  Input: 3
  Output: 5
  Suppose the values are 1, 2, 3 then the possible trees are

       (3) 

      /

    (2)

   /

(1)



  


(1)

   \

    (2)

      \

       (3)



(1)

   \

    (3)

   /

(2)



   (2)

  /   \

(1)    (3)


  
*/
public class NoOfBinaryTree {
	static long how_many_BSTs(int n) {
        long[] arr = new long[36] ;
        Arrays.fill(arr, -1L);
        return how_many_BST_Eval(n, arr);
    }
    
    static long how_many_BST_Eval(int n , long[] arr) {
        if (n == 0) {
            return 1L;
        }
        
        if (arr[n] != -1L){
            return arr[n];
        }
        
        long result = 0;
        
        for(int nodes_in_left_subtree = 0; nodes_in_left_subtree < n; nodes_in_left_subtree++) {
            int nodes_in_right_subtree = n - 1 - nodes_in_left_subtree;
            result += how_many_BST_Eval(nodes_in_left_subtree, arr) * how_many_BST_Eval(nodes_in_right_subtree, arr);
        }
        arr[n] = result;
        return result;
    }




}
