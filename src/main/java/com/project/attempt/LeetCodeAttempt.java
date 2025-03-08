package com.project.attempt;

public class LeetCodeAttempt {

    public static void main(String[] args) {

        System.out.println(shortestCommonSupersequence("abac", "cab"));
        System.out.println(shortestCommonSupersequence("aaaaaaaa", "aaaaaaaa"));

    }

    // This method will generate the shortest common supersequence between the two strings.
    public static String shortestCommonSupersequence(String str1, String str2) {

        // First we call a helper method to check whether one string is entirely
        // contained in the other string as a subsequence. In which case, we will
        // return the longer of the two strings as it is automatically a supersequence.
        if (contains(str1, str2)) { return str1; }
        if (contains(str2, str1)) { return str2; }

        // We will first search for common subsequences between the two strings.
        // We only care about subsequences at the beginning or the end of the strings,
        // as that is the only way we could link up the strings for a supersequence that
        // is shorter than simply putting the two whole strings together.

        // We will search for matching subsequences between the front of string str1 and the
        // end of string str2, and if there are any we store it in string matchingSubsequence1.
        // We will also search for matching subsequences between the front of string str2 and the
        // end of string str1, and if there are any we store it in string matchingSubsequence2.
        String matchingSubsequence1 = "";
        String matchingSubsequence2 = "";

        // We want to get the shorter length of the two strings as we want to use only one
        // for-loop to iterate through both of them at the same time to save on time complexity,
        // and we want to avoid going out of bounds while looping through the shorter string.
        // We also have no need to loop through an entire string if the other happens to be shorter,
        // as we are only looking for subsequence matches between the two strings, and any such
        // match cannot surpass the length of the shorter string.
        int stringLength = str1.length();
        if (stringLength > str2.length()) { stringLength = str2.length(); }


        for (int i = 0; i < stringLength; i++) {

            // We will check the subsequences at the front of str1 and end of str2 here,
            // and record down the largest match that we managed to obtain if any.
            if (str1.substring(0, i+1).equals(str2.substring(str2.length() - 1 - i))) {
                matchingSubsequence1 = str1.substring(0, i+1);
            }

            // We will check the subsequences at the front of str2 and end of str1 here,
            // and record down the largest match that we managed to obtain if any.
            if (str2.substring(0, i+1).equals(str1.substring(str1.length() - 1 - i))) {
                matchingSubsequence2 = str2.substring(0, i+1);
            }

        }

        // If no subsequence matches are found in either string, the shortest supersequence between
        // them can only be the simple addition of both strings together.

        // Otherwise, if only the front of str2 and end of str1 are a match, we will form a new string
        // that contains the rest of the front of str1, the matching portion in the middle, and the
        // rest of the end of str2, to form our supersequence that has both strings as a subsequence.

        // If only the front of str1 and end of str2 are a match, we will form a new string
        // that contains the rest of the front of str2, the matching portion in the middle, and the
        // rest of the end of str1, to form our supersequence that has both strings as a subsequence.
        if (matchingSubsequence1.isEmpty() && matchingSubsequence2.isEmpty()) {
            return str1 + str2;
        } else if (matchingSubsequence1.isEmpty()) {
            return str1.substring(0, str1.length() - matchingSubsequence2.length()) + matchingSubsequence2 + str2.substring(matchingSubsequence2.length());
        } else if (matchingSubsequence2.isEmpty()) {
            return str2.substring(0, matchingSubsequence1.length() - 1) + matchingSubsequence1 + str1.substring(matchingSubsequence1.length());
        }

        // If subsequence matches are found for both string matchingSubsequence1 and
        // string matchingSubsequence2, we will create supersequences from both of them,
        // and then compare which of the two resultant supersequence string is shorter.
        String commonSupersequence1 = str2.substring(0, str2.length() - matchingSubsequence1.length()) + matchingSubsequence1 + str1.substring(matchingSubsequence1.length());
        String commonSupersequence2 = str1.substring(0, str1.length() - matchingSubsequence2.length()) + matchingSubsequence2 + str2.substring(matchingSubsequence2.length());

        // We will return the shorter of the two supersequences. If they are the
        // same length, then we can return either as per challenge specifications.
        if (commonSupersequence1.length() <= commonSupersequence2.length()) {
            return commonSupersequence1;
        } else {
            return commonSupersequence2;
        }

    }

    // A helper method that checks whether string str2 is contained within string str1
    // as a subsequence or not.
    private static boolean contains(String str1, String str2) {

        for (int i = 0; i < str1.length(); i++) {

            // If at any index of string str1 we detect the same character as the starting
            // character of string str2, we perform a check to see there is a matching
            // subsequence between the two strings at that point. We return true if any
            // are found at any point.
            if (str1.charAt(i) == str2.charAt(0) && str1.length() >= i + str2.length()) {

                if (str1.substring(i, i + str2.length()).equals(str2)) {
                    return true;
                }

            }

        }

        // If no match is ever found, we return false at the end.
        return false;

    }

}
