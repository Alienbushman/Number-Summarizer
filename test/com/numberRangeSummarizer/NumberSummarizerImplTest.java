package com.numberRangeSummarizer;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

class NumberSummarizerImplTest {

    @Test
    public void testCollectedNumbers(){
        NumberSummarizerImpl test = new NumberSummarizerImpl();
        String numbers = "1,3,4,6,7,103,104,107,108,109,110,115,188,189,192,20";
        Collection<Integer> result =test.collect(numbers);
        assertEquals(Arrays.asList(1, 3, 4, 6, 7, 20, 103, 104, 107, 108, 109, 110, 115, 188, 189, 192),result);
    }

    @Test
    public void testSummarizedCollection(){
        NumberSummarizerImpl test = new NumberSummarizerImpl();
        Collection<Integer> listCollected =  Arrays.asList(1,3,4,6,7,103,104,107,108,109,110,115,188,189,192,200);
        String summarizedstr = test.summarizeCollection(listCollected);
        assertEquals("1, 3 - 4, 6 - 7, 103 - 104, 107 - 110, 115, 188 - 189, 192, 200",summarizedstr);
    }

}