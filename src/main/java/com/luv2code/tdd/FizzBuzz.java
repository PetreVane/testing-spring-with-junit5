package com.luv2code.tdd;

public class FizzBuzz {

    public String compute(int value) {
        StringBuilder result = new StringBuilder();

        if (value % 3 == 0 && value % 5 == 0) {
            result.append("FizzBuzz");
        } else if (value % 3 == 0 ) {
            result.append("Fizz");
        } else if (value % 5 == 0) {
            result.append("Buzz");
        } else {
            result.append(value);
        }

        return result.toString();
    }

}
