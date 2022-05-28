package org.example;

import annotations.Test;

public class TestClass {

    @Test
    public static void firstMethod() {
        throw new RuntimeException("Here comes a crash!");
    }

    public static void secondMethod() {
    }

    @Test
    public static void thirdMethod() {
        throw new RuntimeException("Another crash?");
    }

    public static void forthMethod() {
    }

    @Test
    public static void fifthMethod() {

    }

    public static void sixthMethod() {
    }

    @Test
    public static void sevenMethod() {

    }

    public static void eighthMethod() {
        throw new RuntimeException("You've done it again! -.-'");
    }
}
