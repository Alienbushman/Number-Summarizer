package com.numberRangeSummarizer;

import java.util.*;

/**
 *
 * A class which converts a string of numbers into a string with a summarised range
 *
 */
public class NumberSummarizerImpl implements NumberRangeSummarizer
{
    public static void main(String[] args)
    {
        NumberSummarizerImpl nr = new NumberSummarizerImpl();
        String input = "99,100,101,102,103,104,107,108,109,110,115,188,189,192,20";
        try {
            Collection<Integer> collectionInput = nr.collect(input);
            String range = nr.summarizeCollection(collectionInput);

            System.out.println(range);
        } catch (ClassCastException exc) {
            System.err.println("Invalid format for sting");
        }


    }

    /**
     *
     * Changes a string into a collection of integers

     * @param input A string which contains numbers
     * @return a collection of integers
     *
     */
    public Collection<Integer> collect(String input) {
        //Separate the numbers with ","
        String[] arrayOfString = input.split(",");
        int[] integers = new int[arrayOfString.length];
        for (int i = 0; i < arrayOfString.length; i++) {
            integers[i] = Integer.parseInt(arrayOfString[i]);
        }
        Arrays.sort(integers);
        List<Integer> list = new ArrayList<>();

        for (int integer : integers) {
            list.add(integer);
        }
        return list;

    }

    /**
     *
     * Summarises the numbers into ranges
     *
     * @param input a collection of integers that needs to be summarised
     * @return The string representation of the numbers
     *
     */
    public String summarizeCollection(Collection<Integer> input)
    {
        int count = 0;
        StringBuilder sb = new StringBuilder();
        ArrayList<Integer> inputList = new ArrayList<>(input);
        int length = inputList.size();
        int start;
        int next;
        for (int a = 0; a < length; a++)
        {
            if (a == length - 1)
            {
                if(!inputList.get(length-2).equals(inputList.get(length-1)))
                {
                    sb.append(inputList.get(a)).append(",");
                }
                break;
            }
            start = inputList.get(a);

            next = inputList.get(a + 1);
            if (next == start + 1)
            {
                count++;
                int lowestBound = start;

                for (int i = a + 1; ; i++)
                {
                    start = inputList.get(i);
                    next = inputList.get(i + 1);

                    if (next == start + 1)
                    {
                        count++;
                    }
                    else
                    {
                        a = i;
                        if (count != 0)
                        {
                            sb.append(lowestBound).append(" - ").append(inputList.get(i)).append(", ");
                        }
                        break;
                    }
                }
                count = 0;
            }
            else
            {
                sb.append(start).append(", ");
            }
        }
        String ranges = sb.toString();
        return ranges.substring(0, ranges.length() - 1);
    }


}
