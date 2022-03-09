package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> first = v -> v.getName().contains(key);
        Predicate<Person> second = v -> v.getSurname().contains(key);
        Predicate<Person> third = v -> v.getPhone().contains(key);
        Predicate<Person> fourth = v -> v.getAddress().contains(key);
        Predicate<Person> combine = first.or(second).or(third).or(fourth);
        ArrayList<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}
