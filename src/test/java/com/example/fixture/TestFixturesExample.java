package com.example.fixture;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.Closeable;
import java.io.IOException;

public class TestFixturesExample {
    static class ExpensiveManagedResource implements Closeable {
        @Override
        public void close() throws IOException {}
    }

    static class ManagedResource implements Closeable {
        @Override
        public void close() throws IOException {}
    }

    private ManagedResource myManagedResource;
    private static ExpensiveManagedResource myExpensiveManagedResource;

    @BeforeClass
    public static void setUpClass() {
        System.out.println("@BeforeClass setUpClass");
        myExpensiveManagedResource = new ExpensiveManagedResource();
    }

    @AfterClass
    public static void tearDownClass() throws IOException {
        System.out.println("@AfterClass tearDownClass");
        myExpensiveManagedResource.close();
        myExpensiveManagedResource = null;
    }

    @Before
    public void setUp() {
        System.out.println("@Before setUp");
        this.myManagedResource = new ManagedResource();
    }

    @After
    public void tearDown() throws IOException {
        System.out.println("@After tearDown");
        this.myManagedResource.close();
        this.myManagedResource = null;
    }

    @Test
    public void test1() {
        System.out.println("@Test test1()");
    }

    @Test
    public void test2() {
        System.out.println("@Test test2()");
    }
}
