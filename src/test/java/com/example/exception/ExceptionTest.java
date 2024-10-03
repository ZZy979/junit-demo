package com.example.exception;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ExceptionTest {
    @Test
    public void testExceptionAndState() {
        List<Object> list = new ArrayList<>();

        IndexOutOfBoundsException e = assertThrows(
                IndexOutOfBoundsException.class,
                () -> list.add(1, new Object()));

        // assertions on the thrown exception
        assertEquals("Index: 1, Size: 0", e.getMessage());
        // assertions on the state of a domain object after the exception has been thrown
        assertTrue(list.isEmpty());
    }

    @Test
    public void testExceptionMessage() {
        List<Object> list = new ArrayList<>();

        try {
            list.get(0);
            fail("Expected an IndexOutOfBoundsException to be thrown");
        } catch (IndexOutOfBoundsException e) {
            assertEquals("Index: 0, Size: 0", e.getMessage());
        }
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void empty() {
        new ArrayList<Object>().get(0);
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void shouldTestExceptionMessage() {
        List<Object> list = new ArrayList<>();

        thrown.expect(IndexOutOfBoundsException.class);
        thrown.expectMessage("Index: 0, Size: 0");
        list.get(0);
    }
}
