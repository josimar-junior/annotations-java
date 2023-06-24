package br.com.jj.util;

import br.com.jj.annotations.Email;
import br.com.jj.exceptions.InvalidEmailException;

import java.lang.reflect.Field;
import java.util.regex.Pattern;

public class ValidateUtil {

    public static void validate(Object object) throws IllegalAccessException {

        Class<?> clazz = object.getClass();
        for(Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);
            if(field.isAnnotationPresent(Email.class)) {
                patternMatcher(field, object);
            }
        }
    }

    private static void patternMatcher(Field field, Object object) throws IllegalAccessException {
        Pattern pattern = Pattern.compile("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
        String email = (String) field.get(object);
        if(!pattern.matcher(email).matches()) {
            throw new InvalidEmailException("Email " + email + " is invalid");
        }
    }
}
