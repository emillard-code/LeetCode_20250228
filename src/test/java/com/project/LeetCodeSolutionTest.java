package com.project;

import com.project.solution.LeetCodeSolution;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class LeetCodeSolutionTest {

    @Test
    public void shortestCommonSupersequenceTest() {

        assertEquals("cabac", LeetCodeSolution.shortestCommonSupersequence("abac", "cab"));

        assertEquals("aaaaaaaa", LeetCodeSolution.shortestCommonSupersequence("aaaaaaaa", "aaaaaaaa"));

    }

}
