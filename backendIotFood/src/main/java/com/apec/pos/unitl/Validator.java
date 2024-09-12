package com.apec.pos.unitl;

import java.util.regex.*;

public class Validator {
    public static boolean validateStudentID(String studentID) {
        String pattern = "A\\d{5}";
        return Pattern.matches(pattern, studentID);
    }

    public static boolean validatePassword(String password) {
        String pattern = "^(?=.*[A-Z]).{6,32}$";
        return Pattern.matches(pattern, password);
    }
}
