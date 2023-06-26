package br.com.jj.service;

import br.com.jj.model.Person;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PersonServiceTest {

    private PersonService service = new PersonService();

    @Test
    public void mustReturnSuccessfullySavedPerson() {
        var person = new Person("Josimar", "josimar@gmail.com");
        var message = service.save(person);
        assertEquals("Successfully saved person", message);
    }

    @Test
    public void mustThrowException() {
        var person = new Person("Josimar", "gmail.com");
        var exception = assertThrows(RuntimeException.class, () -> service.save(person));
        assertEquals("Email gmail.com is invalid", exception.getMessage());
    }
}
