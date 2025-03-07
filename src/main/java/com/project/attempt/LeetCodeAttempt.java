package com.project.attempt;

public class LeetCodeAttempt {

    public static void main(String[] args) {

        System.out.println(shortestCommonSupersequence("abac", "cab"));
        System.out.println(shortestCommonSupersequence("aaaaaaaa", "aaaaaaaa"));

    }

    public static String shortestCommonSupersequence(String str1, String str2) {

        if (contains(str1, str2)) { return str1; }
        if (contains(str2, str1)) { return str2; }

        String matchingSubsequence1 = "";
        String matchingSubsequence2 = "";
        int stringLength = str1.length();
        if (stringLength > str2.length()) { stringLength = str2.length(); }


        for (int i = 0; i < stringLength; i++) {

            if (str1.substring(0, i+1).equals(str2.substring(str2.length() - 1 - i))) {
                matchingSubsequence1 = str1.substring(0, i+1);
            }

            if (str2.substring(0, i+1).equals(str1.substring(str1.length() - 1 - i))) {
                matchingSubsequence2 = str2.substring(0, i+1);
            }

        }

        if (matchingSubsequence1.isEmpty() && matchingSubsequence2.isEmpty()) {
            return str1 + str2;
        } else if (matchingSubsequence1.isEmpty()) {
            return str1.substring(0, str1.length() - matchingSubsequence2.length()) + matchingSubsequence2 + str2.substring(matchingSubsequence2.length());
        } else if (matchingSubsequence2.isEmpty()) {
            return str2.substring(0, matchingSubsequence1.length() - 1) + matchingSubsequence1 + str1.substring(matchingSubsequence1.length());
        }

        String commonSupersequence1 = str2.substring(0, str2.length() - matchingSubsequence1.length()) + matchingSubsequence1 + str1.substring(matchingSubsequence1.length());
        String commonSupersequence2 = str1.substring(0, str1.length() - matchingSubsequence2.length()) + matchingSubsequence2 + str2.substring(matchingSubsequence2.length());

        if (commonSupersequence1.length() <= commonSupersequence2.length()) {
            return commonSupersequence1;
        } else {
            return commonSupersequence2;
        }

    }

    private static boolean contains(String str1, String str2) {

        for (int i = 0; i < str1.length(); i++) {

            if (str1.charAt(i) == str2.charAt(0) && str1.length() >= i + str2.length()) {

                if (str1.substring(i, i + str2.length()).equals(str2)) {
                    return true;
                }

            }

        }

        return false;

    }

}
