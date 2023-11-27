package algorithms.arrays;

import java.util.*;
import java.util.stream.Collectors;

public class GroupAnagrams {

    // The sort and conquer approach to this problem is bot efficient, so instead use a HashMap
    // Appraoch 1: sort O(nlogn) for each of m elements , so O(m.nlogn)
    //Approach 2: Put all strings in a HashMap of HashMaps
    // key of the parent Hashmap is a child Hashmap indicating the char values and the counts
    // if the same key(child hashmap) exists in the parent hashmap , just append string to the end of the list(value)
    // corresponding to the key

    String sortCharacterArray(String s) {
        char[] charArray = s.toCharArray();
        Arrays.sort(charArray);
        return String.valueOf(charArray);
    }

    public List<List<String>> groupAnagrams(String[] strs) {
//        Input: strs = ["eat","tea","tan","ate","nat","bat"]
//        Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
        String[] sortedStrs = Arrays.stream(strs).map(this::sortCharacterArray).toArray(String[]::new);
        long distinctCount = Arrays.stream(sortedStrs).distinct().count();
        List<List<String>> resultList = new ArrayList<>();
        boolean[] visited = new boolean[sortedStrs.length];
        int L = 0;
        while (true) {
            boolean lFlag = false;
            List<String> stringList = new ArrayList<>();
            stringList.add(strs[L]);
            visited[L] = true;
            int startIndex = L;
            for (int j = L + 1; j < sortedStrs.length; j++) {

                if (Objects.equals(sortedStrs[startIndex], sortedStrs[j])) {
                    stringList.add(strs[j]);
                    visited[j] = true;
                } else {
                    if (!lFlag && !visited[j]) {
                        lFlag = true;
                        L = j;
                    }
                }
            }
            resultList.add(stringList);
            if (resultList.size() == distinctCount) {
                return resultList;
            }
        }

    }

    public List<List<String>> groupAnagramsV2(String[] strs) {
        HashMap<HashMap<Character, Integer>, List<String>> stringHashMapHashMap = new HashMap<>();
        for (String str : strs) {
            char[] charArray = str.toCharArray();
            HashMap<Character, Integer> characterIntegerHashMap = new HashMap<>();
            for (char c : charArray) {
                if (characterIntegerHashMap.containsKey(c)) {
                    characterIntegerHashMap.put(c, characterIntegerHashMap.get(c) + 1);
                } else {
                    characterIntegerHashMap.put(c, 1);
                }
            }
            if (stringHashMapHashMap.containsKey(characterIntegerHashMap)) {
                List<String> listofStrings = stringHashMapHashMap.get(characterIntegerHashMap);
                listofStrings.add(str);
                stringHashMapHashMap.put(characterIntegerHashMap, listofStrings);
            } else {
                List<String> listOfStringsInit = new ArrayList<>();
                listOfStringsInit.add(str);
                stringHashMapHashMap.put(characterIntegerHashMap, listOfStringsInit);
            }
        }
        return List.copyOf(stringHashMapHashMap.values());
    }


    public static void main(String[] args) {
        GroupAnagrams anagrams = new GroupAnagrams();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
//        String[] strs = {""};
        System.out.println(anagrams.groupAnagramsV2(strs));
    }
}
