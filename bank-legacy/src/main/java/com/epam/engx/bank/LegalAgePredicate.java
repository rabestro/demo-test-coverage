package com.epam.engx.bank;

import java.time.LocalDate;
import java.util.function.Predicate;

public class LegalAgePredicate implements Predicate<User> {

    @Override
    public boolean test(User user) {
        int yearOfBirth = user.birthday().getYear();
        int yearNow = LocalDate.now().getYear();
        return yearNow - yearOfBirth >= 18;
    }
}
