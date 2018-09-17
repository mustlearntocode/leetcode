package leetcode.q139;

import java.util.*;

public class Answer {
    public static void main(String[] args) {
        Answer test1 = new Answer();
//        String testingWord = "leetcode";
//        List<String> dictionary = new ArrayList<>();
//        dictionary.add("leet");
//        dictionary.add("code");

        String testingWord = "cars";
        List<String> dictionary = new ArrayList<>();
        dictionary.add("car");
        dictionary.add("ca");
        dictionary.add("rs");



        System.out.print(test1.wordBreak(testingWord, dictionary));


    }

    public boolean wordBreak(String s, List<String> wordDict) {

        if (wordDict == null || wordDict.size() == 0) return false;
        Map map = new HashMap<Character, List<String>>();
        // prepare the map
        for(String str: wordDict) {
            // get the first letter of the word in the dictionary
            char c = str.charAt(0);
            if (map.get(c)==null) {
                List newList = new ArrayList();
                newList.add(str);
                map.put(c, newList);
            } else {
                List currList = (ArrayList<String>)map.get(c);
                // you shouldn't need to update the map again.
                currList.add(str);
            }
        }

        return  checkDictionary(s, 0, map);

    }

    // sort the array and we will later use it backwards.
    private static void sortArrays(Map map) {
        Iterator it = map.entrySet().iterator();
        while(it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            Collections.sort((ArrayList<String>)pair.getValue());
        }
    }

    private boolean checkDictionary(String s, int index, Map map) {
        int len = s.length();
        if(index >= len) return true;

        char c = s.charAt(index);
        List<String> currList = (ArrayList<String>)map.get(c);
        if (currList == null) return false;
        else {
            int remainingLen = (len-1) - index + 1;
            for(int i=currList.size()-1; i >=0; i--)
            {
                String strInDictionary = currList.get(i);
                if(strInDictionary.length() > remainingLen) continue;
                else {
                    if(s.substring(index, index + strInDictionary.length()).equals(strInDictionary)) {
                        // cannot return this if it is false right away, because it does not go through this way
                        // does not mean it will not work with same starting letter word in the dictionary
                        boolean currResult =  checkDictionary(s, index + strInDictionary.length(), map) ? true : false;
                        if (currResult) return true;
                        else continue;
                    }
                    // else, it does not match, do nothing
                }
            }
        }
        return false;
    }

}

/*
I failed here, not because my algorithm is not efficient, but the dictionary is not efficient. You can see from the bottom example below,
"aa", "aaa",... can all be replaced with "a"
 */
//    Last executed input:
//        "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab"
//        ["a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"]
