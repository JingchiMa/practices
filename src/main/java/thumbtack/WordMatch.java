package thumbtack;

import java.util.*;

public class WordMatch {

    static class StringParser {
        private String val;

        public StringParser(String s) {
            if (s == null) {
                s = "";
            }
            this.val = s;
        }

        public StringParser toUpperCase() {
            return new StringParser(this.val.toUpperCase());
        }

        public StringParser changeVowelsToRepre() {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < this.val.length(); i++) {
                if (vowels.contains(this.val.charAt(i))) {
                    sb.append(REPRE);
                } else {
                    sb.append(this.val.charAt(i));
                }
            }
            return new StringParser(sb.toString());
        }

        public StringParser removeDuplicates() {
            StringBuilder sb = new StringBuilder();
            int i = 0;
            while (i < this.val.length()) {
                sb.append(this.val.charAt(i));
                i++;
                while (i < this.val.length() && this.val.charAt(i) == this.val.charAt(i-1)) {
                    i++;
                }
            }
            return new StringParser(sb.toString());
        }

        public String value() {
            return this.val;
        }
    }

    // Question 1: case-insensitive
    public String findMatchWordI(String[] dict, String target) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < dict.length; i++) {
            map.put(dict[i].toUpperCase(), i);
        }
        int index = map.get(target.toUpperCase());
        if (index < 0) {
            return null;
        }
        return dict[index];
    }

    private static final Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o','u',
                                                                            'A', 'E', 'I', 'O', 'U'));
    private static final char REPRE = 'A';
    // Question 2: aeiou the same
    // 利用选代表的思想！！！
    public String findMatchWordII(String[] dict, String target) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < dict.length; i++) {
            map.put(parseWord(dict[i]), i);
        }
        int index = map.getOrDefault(parseWord(target), -1);
        if (index < 0) {
            return null;
        }
        return dict[index];
    }

    private String parseWord(String word) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            if (vowels.contains(word.charAt(i))) {
                sb.append(REPRE);
            } else {
                sb.append(word.charAt(i));
            }
        }
        return sb.toString().toUpperCase();
    }


    // Question 3: 不用管字符重复次数 比如 yyaallooowww也可以匹配YELLow
    public String findMatchWordIII(String[] dict, String target) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < dict.length; i++) {
            map.put(parseIII(dict[i]), i);
        }
        int index = map.getOrDefault(parseIII(target), -1);
        if (index < 0) {
            return null;
        }
        return dict[index];
    }

    private String parseIII(String s) {
        StringParser sp = new StringParser(s);
        return sp.toUpperCase().removeDuplicates().changeVowelsToRepre().value();
    }
}
