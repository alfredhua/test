//给你一个由候选元素组成的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。 
//
//
// candidates 中的每个元素在每个组合中只能使用 一次 。 
//
// 注意：解集不能包含重复的组合。 
//
// 
//
// 示例 1: 
//
// 
//输入: candidates = [10,1,2,7,6,1,5], target = 8,
//输出:
//[
//[1,1,6],
//[1,2,5],
//[1,7],
//[2,6]
//] 
//
// 示例 2: 
//
// 
//输入: candidates = [2,5,2,1,2], target = 5,
//输出:
//[
//[1,2,2],
//[5]
//] 
//
// 
//
// 提示: 
//
// 
// 1 <= candidates.length <= 100 
// 1 <= candidates[i] <= 50 
// 1 <= target <= 30 
// 
// Related Topics 数组 回溯 👍 806 👎 0


package leetcode.editor.cn;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CombinationSumIi_40{

    public static void main(String[] args) {
        Solution solution = new CombinationSumIi_40().new Solution();
//        List<List<Integer>> lists = solution.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);
//        System.out.println(lists);

        List<List<Integer>> list2 = solution.combinationSum2(new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}, 27);
        System.out.println(list2);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            int len = candidates.length;
            List<List<Integer>> res = new ArrayList<>();
            if (len == 0) {
                return res;
            }
            // 关键步骤
            Arrays.sort(candidates);
            Deque<Integer> path = new ArrayDeque<>(len);
            dfs(candidates, len, 0, target, path, res);
            return res;
        }

        /**
         * @param candidates 候选数组
         * @param len        冗余变量
         * @param begin      从候选数组的 begin 位置开始搜索
         * @param target     表示剩余，这个值一开始等于 target，基于题目中说明的"所有数字（包括目标数）都是正整数"这个条件
         * @param path       从根结点到叶子结点的路径
         * @param res
         */
        private void dfs(int[] candidates, int len, int begin, int target, Deque<Integer> path, List<List<Integer>> res) {
            if (target == 0) {
                res.add(new ArrayList<>(path));
                return;
            }
            for (int i = begin; i < len; i++) {
                // 大剪枝：减去 candidates[i] 小于 0，减去后面的 candidates[i + 1]、candidates[i + 2] 肯定也小于 0，因此用 break
                if (target - candidates[i] < 0) {
                    break;
                }

                // 小剪枝：同一层相同数值的结点，从第 2 个开始，候选数更少，结果一定发生重复，因此跳过，用 continue
                if (i > begin && candidates[i] == candidates[i - 1]) {
                    continue;
                }

                path.addLast(candidates[i]);
                // 调试语句 ①
                // System.out.println("递归之前 => " + path + "，剩余 = " + (target - candidates[i]));

                // 因为元素不可以重复使用，这里递归传递下去的是 i + 1 而不是 i
                dfs(candidates, len, i + 1, target - candidates[i], path, res);

                path.removeLast();
                // 调试语句 ②
                // System.out.println("递归之后 => " + path + "，剩余 = " + (target - candidates[i]));
            }
        }



        List list=new ArrayList();

        public List<List<Integer>> combinationSum3(int[] candidates, int target) {
            if (candidates.length<1){
                return list;
            }
            Map<Integer,Integer> map=new HashMap<>();
            def(candidates,target,0,new ArrayDeque(),map);
            return list;
        }

        public void def(int[] candidates, int target, int begin, Deque deque,Map<Integer,Integer> map){
            if (target<0){
                return;
            }
            if (target==0){
                Stream sorted = new ArrayList<>(deque).stream().sorted();
                Object collect = sorted.collect(Collectors.toList());
                if (!list.contains(collect)){
                    list.add(collect);
                }
            }

            for (int i = begin;i<candidates.length;i++ ){
                if (map.get(i)!=null){
                    continue;
                }
                map.put(i,candidates[i]);
                deque.add(candidates[i]);
                System.out.println("-------------->"+deque+"-------"+candidates[i]);
                def(candidates,target-candidates[i],i,deque,map);
                deque.removeLast();
                map.remove(i);
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)


}