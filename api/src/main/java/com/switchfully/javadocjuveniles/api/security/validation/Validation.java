package com.switchfully.javadocjuveniles.api.security.validation;

import com.switchfully.javadocjuveniles.domain.exceptions.EmailAlreadyRegisteredException;
import com.switchfully.javadocjuveniles.domain.exceptions.EmailNotValidException;
import com.switchfully.javadocjuveniles.domain.exceptions.InssNotValidException;
import com.switchfully.javadocjuveniles.service.users.MemberDto;
import com.switchfully.javadocjuveniles.service.users.MemberService;

public class Validation {
    public static void isValidEmailAddress(String email) {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        if (!m.matches()) {
            throw new EmailNotValidException(email);
        }
    }


    public static boolean isValidInss(String inss) {
        String ePattern = "^[0-9]{2}\\.[0-9]{2}\\.[0-9]{2}\\.[0-9]{3}\\.[0-9]{2}$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(inss);
        if (!m.matches()) {
            throw new InssNotValidException(inss);
        }
        return true;
    }
}
