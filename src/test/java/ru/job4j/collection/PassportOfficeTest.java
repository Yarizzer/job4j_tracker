package ru.job4j.collection;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class PassportOfficeTest {

    @Test
    public void add() {
        Citizen citizen = new Citizen("2f44a", "Petr Arsentev");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        assertThat(office.get(citizen.getPassport()), is(citizen));
    }

    @Test
    public void whenAddSamePassCitizenThenFalse() {
        Citizen first = new Citizen("2f44a", "Petr Arsentev");
        Citizen second = new Citizen("2f44a", "foo");
        PassportOffice office = new PassportOffice();
        office.add(first);
        office.add(second);
        assertFalse(office.get(first.getPassport()) == second);
    }
}