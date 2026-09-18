package com.learning.junit;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MyMathTest {

    private final MyMath myMath = new MyMath();

    @Test
    public void calculateSum_3MemberArray() {
        assertEquals(129, myMath.calculateSum(new int[]{21,10,98}));
    }

    @Test
    public void calculateSum_0LengthArray() {
        int result = myMath.calculateSum(new int[]{});
        int expectedResult = 0;
        assertEquals(expectedResult, result);
    }
}
