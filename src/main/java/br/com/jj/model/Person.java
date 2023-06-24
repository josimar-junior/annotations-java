package br.com.jj.model;

import br.com.jj.annotations.Email;

public class Person {
    private String name;

    @Email
    private String email;

    public Person(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
