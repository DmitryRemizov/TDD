import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.*;


class PhoneBookTest {

    Map<String, Integer> expected = new TreeMap<>();

    @BeforeAll
    static void contactAdd() {
        PhoneBook.add("Александра", 234567891);
        PhoneBook.add("Влад", 234567899);
    }

    @Test
    void add() {
        int actualNumber = PhoneBook.add("Влад", 234567899);
        expected.put("Влад", 234567899);
        expected.put("Александра", 234567891);
        int expectedNumber = expected.size();
        Map<String, Integer> actual = PhoneBook.getPhoneBook();
        Assertions.assertEquals(expected, actual);
        Assertions.assertEquals(expectedNumber, actualNumber);
    }

    @Test
    void findByNumber() {
        String expected = "Александра";
        String actual = PhoneBook.findByNumber(234567891);
        String nonExpected = "Влад";
        Assertions.assertEquals(expected,actual);
        Assertions.assertNotEquals(nonExpected, actual);
        Assertions.assertNotNull(actual);
    }
    @Test
    void findByName() {
        int expected = 234567899;
        int actual = PhoneBook.findByName("Влад");
        int nonExpected = 234567891;

        Assertions.assertEquals(expected, actual);
        Assertions.assertNotEquals(nonExpected, actual);
        Assertions.assertNotNull(actual);
    }

    @Test
    void printAllNames() {
        Collection<String> actual = PhoneBook.printAllNames();
        Collection<String> expected = new ArrayList<>();
        expected.add("Александра");
        expected.add("Влад");
        Assertions.assertEquals(expected, actual);
        Assertions.assertNotNull(actual);
    }
}