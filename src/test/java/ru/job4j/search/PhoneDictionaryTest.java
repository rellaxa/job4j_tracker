package ru.job4j.search;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

class PhoneDictionaryTest {

    @Test
    void whenFindByName() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Evgenii", "Nadeev", "+17789286692", "290 Newport Dr, Port Moody, BC V3H 5N2, Canada")
        );
        ArrayList<Person> persons = phones.find("Evgenii");
        assertThat(persons.get(0).getSurname()).isEqualTo("Nadeev");
    }

    void whenNotFindByAddress() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        ArrayList<Person> persons = phones.find("Moscow");
        assertThat(persons).isEmpty();
    }
}