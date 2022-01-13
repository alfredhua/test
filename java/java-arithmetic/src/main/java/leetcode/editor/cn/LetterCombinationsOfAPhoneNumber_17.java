//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = "23"
//输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 
//
// 示例 2： 
//
// 
//输入：digits = ""
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：digits = "2"
//输出：["a","b","c"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= digits.length <= 4 
// digits[i] 是范围 ['2', '9'] 的一个数字。 
// 
// Related Topics 哈希表 字符串 回溯 👍 1679 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

public class LetterCombinationsOfAPhoneNumber_17{

    public static void main(String[] args) {
        Solution solution = new LetterCombinationsOfAPhoneNumber_17().new Solution();
        System.out.println(solution.letterCombinations("23"));
        System.out.println(solution.letterCombinations("2"));
        System.out.println(solution.letterCombinations("3456"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {


        /**
         * 递归
         * @param digits
         * @return
         */
        public List<String> letterCombinations(String digits) {
            String[] phone = {"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
            if (digits.length()<1 || digits.length()>4){
                return new ArrayList<>();
            }
            return backLetter(new ArrayList<>(), digits,phone);
        }

        /**
         *
         * @param list  a,b,c
         * @param digit abc  def
         * @return
         */
        public List<String> backLetter(List<String> list,String digit,String[] phone){
            if (digit==null){
                return list;
            }
            String dig = digit.substring(0, 1);
            String w=phone[Integer.parseInt(dig)-2];  // abc
            ArrayList<String> objects = new ArrayList<>();
            if (list.isEmpty()){
                for (int i=0;i<w.length();i++){
                    objects.add(w.substring(i,i+1));
                }
            }else{
                for (String a:list){
                    for (int i=0;i<w.length();i++){
                        objects.add(a+w.substring(i,i+1));
                    }
                }
            }
            return backLetter(objects,digit.length()==1?null:digit.substring(1),phone);
        }

        /**
         * 队列方式
         * @param digits
         * @return
         */
        public List<String> letterCombinations1(String digits) {
            String[] phone = {"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
            Queue<String> queue=new LinkedBlockingDeque<>();
            for (int i=0;i<digits.length();i++){ // 2, 3
                String phoneIndex = digits.substring(i, i+1);
                String eng=phone[Integer.parseInt(phoneIndex)-2]; //获取字符串
                // 给queue中的字符串，每个都增加eng
                int k=0,size=queue.size();
                if (size==0){
                    for (int j=0;j<eng.length();j++){
                        queue.add(eng.substring(j,j+1));
                    }
                }else {
                    while (k<size){
                        String poll = queue.poll();
                        for (int j=0;j<eng.length();j++){
                            queue.add(poll+eng.substring(j,j+1));
                        }
                        k++;
                    }
                }
            }
            List<String> list=new ArrayList<>();
            while (!queue.isEmpty()){
                list.add(queue.poll());
            }
            return list;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}