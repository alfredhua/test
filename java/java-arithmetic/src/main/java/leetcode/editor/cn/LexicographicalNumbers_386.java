//给你一个整数 n ，按字典序返回范围 [1, n] 内所有整数。 
//
// 你必须设计一个时间复杂度为 O(n) 且使用 O(1) 额外空间的算法。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 13
//输出：[1,10,11,12,13,2,3,4,5,6,7,8,9]
// 
//
// 示例 2： 
//
// 
//输入：n = 2
//输出：[1,2]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 5 * 10⁴ 
// 
// Related Topics 深度优先搜索 字典树 👍 367 👎 0

  
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class LexicographicalNumbers_386{

   public static void main(String[] args) {
       Solution solution = new LexicographicalNumbers_386().new Solution();
//       System.out.println(solution.lexicalOrder(2));
//       System.out.println(solution.lexicalOrder(10));
       System.out.println(solution.lexicalOrder(25));
   }
   //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

//       public List<Integer> lexicalOrder(int n) {
//           List<Integer> list=new ArrayList<>();
//           int number = 1;
//           for (int i=0;i<n;i++){
//               list.add(number);
//               if ( number * 10 <= n){
//                   number=number * 10;
//               }else{
//                   while (number % 10 == 9 || number + 1 > n) {
//                       number /= 10;
//                   }
//                   number++;
//               }
//           }
//           return list;
//       }

       ArrayList<Integer> list = new ArrayList<>();
       public List<Integer> lexicalOrder(int n) {
           if (n==0){
               list.add(0);
               return  list;
           }
           // 遍历从1-9
           for (int i =1; i<10;i++){
               addLexList(i,n);
           }
           return list;
       }

    public void addLexList(int i,int n){
        if (i>n){
            return;
        }
        //1. 先乘以10 进行遍历，遍历到没有了即可
        list.add(i);
        //2. 再进行加1遍历,
        for (int j=0;j<10;j++){
            addLexList(i*10+j,n);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

   
}