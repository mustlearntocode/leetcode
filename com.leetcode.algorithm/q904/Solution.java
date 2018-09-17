package leetcode.q904;

import java.util.*;
class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] myTest = {1,2,1};
        int[] myTest2 = {3,3,3,3,3,3};
        int[] myTest3 = {0,1,2,2};
        System.out.print(solution.totalFruit(myTest3));
    }
    public int totalFruit(int[] tree) {
        List<Integer> n = new ArrayList();
        List<Integer> counts = new ArrayList();

        if(tree==null||tree.length==0) return 0;
        if(tree.length<=2) return tree.length;
        int i = 0;

        while(i < tree.length) {
            int count = 1;
            n.add(tree[i]);
            while(i+1< tree.length && tree[i]==tree[i+1]) {
                count++;
                i++;
            }
            counts.add(count);
            i++;
        }
        if(n.size()<=1) return counts.get(0);
        int max = 1;

        int j=0;
        while(j< n.size()-1) {

            int k = j+1;
            int bucket1 = n.get(j);
            int bucket2 = n.get(k);
            int tempMax = counts.get(j) + counts.get(k);
            k++;
            while(k<n.size()&&(n.get(k)==bucket1 || n.get(k)== bucket2)) {
                tempMax += counts.get(k++);
            }
            max = tempMax  > max? tempMax: max;
            j = k-1;
        }

        return max;



    }
}