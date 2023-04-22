package com.sambit.utils;

/**
 * @Project : Assessment22
 * @Auther : Sambit Kumar Pradhan
 * @Created On : 22/04/2023 - 12:44 PM
 */
public class CalculateGrade {
    public static String calculateGrade(int mark) {
        if (mark < 60) {
            return "F";
        } else if (mark >= 60 && mark <= 79) {
            return "A";
        } else if (mark >= 80 && mark <= 89) {
            return "E";
        } else if (mark >= 90 && mark <= 100) {
            return "O";
        } else {
            return "Invalid Mark";
        }
    }
}
