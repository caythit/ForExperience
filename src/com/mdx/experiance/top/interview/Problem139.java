package com.mdx.experiance.top.interview;

import com.mdx.experiance.annotation.Info;
import com.mdx.experiance.enums.StatusEnum;
import com.mdx.experiance.problem.ProblemConstructBuilder;

import java.util.*;

/**
 * 实现描述：Given a non-empty string s and a dictionary wordDict containing a list of non-empty words,
 * determine if s can be segmented into a space-separated sequence of one or more dictionary words.
 * <p>
 * Note:
 * <p>
 * The same word in the dictionary may be reused multiple times in the segmentation.
 * You may assume the dictionary does not contain duplicate words.
 * Example 1:
 * <p>
 * Input: s = "leetcode", wordDict = ["leet", "code"]
 * Output: true
 * Explanation: Return true because "leetcode" can be segmented as "leet code".
 * Example 2:
 * <p>
 * Input: s = "applepenapple", wordDict = ["apple", "pen"]
 * Output: true
 * Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
 * Note that you are allowed to reuse a dictionary word.
 * Example 3:
 * <p>
 * Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * Output: false
 *
 * @author liuweikai
 * @version v1.0.0
 * @see
 * @since 2019/12/17
 */
@Info(status = StatusEnum.WRONG_ANSWER)
public class Problem139 {
    /**
     * 字符串s是否能被分割成若干子字符串，使得这些子字符串都在给定的字典中
     * 字典的字符串可以重复出现
     *
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        if (wordDict.isEmpty() || s.isEmpty()) {
            return false;
        }
        // 去除重复 的 以及不在s中的字符串
        Set<String> containWordDict = new HashSet<>();
        for (String word : wordDict) {
            if (s.contains(word)) {
                containWordDict.add(word);
            }
        }
        return canBreak(s, 0, new ArrayList<>(containWordDict));
    }

    private boolean canBreak(String s, Integer pos, ArrayList<String> containWordDict) {
        if (pos >= containWordDict.size()) {
            return false;
        }
        if (s.isEmpty()) {
            return true;
        }
        for (int i = pos; i < containWordDict.size(); i++) {
            String word = containWordDict.get(i);
            if (s.contains(word)) {
                Integer idx;
                String sub;
                if (s.startsWith(word)) {
                    idx = s.indexOf(word);
                    sub = s.substring(0, idx) + s.substring(idx + word.length(), s.length());
                } else if (s.endsWith(word)) {
                    idx = s.lastIndexOf(word);
                    sub = s.substring(0, idx) + s.substring(idx + word.length(), s.length());
                } else {
                    idx = s.indexOf(word);
                    sub = s.substring(0, idx) + "$" + s.substring(idx + word.length(), s.length());
                }
                return canBreak(sub, pos, containWordDict);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Problem139 problem = new ProblemConstructBuilder<Problem139>(Problem139.class.getName()).build();
//        System.out.println(problem.wordBreak("bb", Arrays.asList("a", "b", "bbb", "bbbb")));
//        System.out.println(problem.wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat"))); // false
//        System.out.println(problem.wordBreak("ccbb", Arrays.asList("bc", "cb"))); // false
//        System.out.println(problem.wordBreak("ccaccc", Arrays.asList("cc", "ac")));//true
//        System.out.println(problem.wordBreak("cacccc", Arrays.asList("cc", "ac")));//false
        System.out.println(problem.wordBreak("aaaaaaa", Arrays.asList("aaaa", "aaa")));//true


    }
}
