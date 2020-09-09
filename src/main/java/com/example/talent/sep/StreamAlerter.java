package com.example.talent.sep;

import java.util.HashMap;

public class StreamAlerter {
//    private RingBuffer ring;
//    private Trie trie;
    private HashMap keysWords = new HashMap();
    private int keyLength;
    private int currentIndex;
    private String currentStr;


    public StreamAlerter(String[] strings) {
        for (String str:strings) {
            keysWords.put(str.charAt(0), str);
        }
    }
    public boolean query(char ch) {
        if (currentStr == null && keysWords.get(ch) != null) {
            currentStr = (String) keysWords.get(ch);
            keyLength = currentStr.length();
            currentIndex = 0;
        }
        if (currentStr == null) {
            return false;
        } else {
            if (ch == currentStr.charAt(currentIndex)) {
                if (currentIndex == keyLength - 1) {
                    currentStr = null;
                    return true;
                } else {
                    currentIndex++;
                    return false;
                }
            } else {
                currentStr = null;
            }
        }
        return false;
    }
}
