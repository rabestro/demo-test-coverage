package com.epam.engx.bank;


import java.time.LocalDate;

public record User(String name, String surname, LocalDate birthday) {
}
