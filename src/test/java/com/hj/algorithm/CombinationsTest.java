package com.hj.algorithm;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class CombinationsTest {

    @Test
    void combinations() {
        Combinations comb = new Combinations();

        System.out.println("Testing normal data.");
        comb.combinations(
                new ArrayList<>(), Arrays.asList(1, 2, 3, 4), 2);
        System.out.println("==========");

        System.out.println("Testing empty source data.");
        comb.combinations(
                new ArrayList<>(), new ArrayList<>(), 2);
        System.out.println("==========");
        comb.combinations(
                new ArrayList<>(), new ArrayList<>(), 0);
        System.out.println("==========");

        System.out.println("Selecting 1 and 0 elements.");
        comb.combinations(
                new ArrayList<>(), Arrays.asList(1, 2, 3, 4), 1);
        System.out.println("==========");
        comb.combinations(
                new ArrayList<>(), Arrays.asList(1, 2, 3, 4), 0);
        System.out.println("==========");

        System.out.println("Testing large data");
        comb.combinations(
                new ArrayList<>(),
                Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), 4);
    }
}