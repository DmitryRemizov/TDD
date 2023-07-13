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
}