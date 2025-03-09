package com.project;

import com.project.attempt.LeetCodeAttempt;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class LeetCodeAttemptTest {

    @Test
    public void shortestCommonSupersequenceTest() {

        assertEquals("cabac", LeetCodeAttempt.shortestCommonSupersequence("abac", "cab"));

        assertEquals("aaaaaaaa", LeetCodeAttempt.shortestCommonSupersequence("aaaaaaaa", "aaaaaaaa"));

    }

}
