package br.com.jj.service;

import br.com.jj.model.Person;
import br.com.jj.util.ValidateUtil;

public class PersonService {

    public String save(Person person) {
        try {
            ValidateUtil.validate(person);
            return "Successfully saved person";
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
