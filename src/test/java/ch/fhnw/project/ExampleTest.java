package ch.fhnw.project;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ExampleTest {

    @Test
    public void helloWorld() {
        assertEquals("Hello World", String.format("Hello %s", "World"));
    }

}