package exercise.int_array_string;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.cn/problems/find-the-length-of-the-longest-common-prefix/?envType=daily-question&envId=2026-05-21
 */
public class LongestCommonPrefix {
	/**
	 * 暴力解法
	 * @param arr1
	 * @param arr2
	 * @return
	 */
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        int preLen = 0;
        for(int i=0 ;i < arr1.length; i++){
        	for(int j=0; j < arr2.length; j++){
        		preLen = Math.max(preLen,commonPrefix(arr1[i],arr2[j]));
        	}
        }
        return preLen;
    }

    /**
     * 计算两个数的公共前缀长度
     * @param a
     * @param b
     * @return
     */
    public int commonPrefix(int a,int b){
    	String aStr = String.valueOf(a);
    	String bStr = String.valueOf(b);
    	int len = aStr.length() > bStr.length()? bStr.length(): aStr.length();
    	int index = 0;
    	for(int i=0; i < len; i++){
    		if(aStr.charAt(i) != bStr.charAt(i)){
    			break;
    		}
    		index++;
			continue;
    	}
    	return index;
    }

    /**
     * 将 arr1 中每个数的所有前缀放入集合，再遍历 arr2 检查其前缀是否命中。
     * 每个数最多 9 位，总复杂度约 O((n + m) * log U)，U 为数值上界。
     */
    public int longestCommonPrefixV2(int[] arr1, int[] arr2) {
        Set<String> prefixes = new HashSet<>();
        for (int num : arr1) {
            addPrefixes(num, prefixes);
        }
        int maxLen = 0;
        for (int num : arr2) {
            String s = String.valueOf(num);
            for (int len = 1; len <= s.length(); len++) {
                if (prefixes.contains(s.substring(0, len))) {
                    maxLen = Math.max(maxLen, len);
                }
            }
        }
        return maxLen;
    }

    private void addPrefixes(int num, Set<String> prefixes) {
        String s = String.valueOf(num);
        for (int len = 1; len <= s.length(); len++) {
            prefixes.add(s.substring(0, len));
        }
    }

    /**
     * Trie：将 arr2 中每个数按位插入字典树，再遍历 arr1 沿树匹配最长前缀。
     * 复杂度约 O((n + m) * d)，d 为数字位数。
     */
    public int longestCommonPrefixV3(int[] arr1, int[] arr2) {
        DigitTrie trie = new DigitTrie();
        for (int num : arr2) {
            trie.insert(num);
        }
        int maxLen = 0;
        for (int num : arr1) {
            maxLen = Math.max(maxLen, trie.longestPrefixLen(num));
        }
        return maxLen;
    }

    private static class DigitTrie {
        private final TrieNode root = new TrieNode();

        void insert(int num) {
            TrieNode node = root;
            for (char c : String.valueOf(num).toCharArray()) {
                int d = c - '0';
                if (node.children[d] == null) {
                    node.children[d] = new TrieNode();
                }
                node = node.children[d];
            }
        }

        int longestPrefixLen(int num) {
            TrieNode node = root;
            int len = 0;
            for (char c : String.valueOf(num).toCharArray()) {
                int d = c - '0';
                if (node.children[d] == null) {
                    break;
                }
                node = node.children[d];
                len++;
            }
            return len;
        }
    }

    private static class TrieNode {
        TrieNode[] children = new TrieNode[10];
    }

    public static void main(String[] args) {
        LongestCommonPrefix solution = new LongestCommonPrefix();
        int[] arr1 = {1, 10, 100};
        int[] arr2 = {1000};
        System.out.println("v1=" + solution.longestCommonPrefix(arr1, arr2));
        System.out.println("v2=" + solution.longestCommonPrefixV2(arr1, arr2));
        System.out.println("v3=" + solution.longestCommonPrefixV3(arr1, arr2));
        int[] arr3 = {1, 2, 3};
        int[] arr4 = {4, 4, 4};
        System.out.println("v1=" + solution.longestCommonPrefix(arr3, arr4));
        System.out.println("v2=" + solution.longestCommonPrefixV2(arr3, arr4));
        System.out.println("v3=" + solution.longestCommonPrefixV3(arr3, arr4));
    }
}
