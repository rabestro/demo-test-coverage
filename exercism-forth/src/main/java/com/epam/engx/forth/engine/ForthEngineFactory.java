package com.epam.engx.forth.engine;

import com.epam.engx.forth.word.Addition;
import com.epam.engx.forth.word.Division;
import com.epam.engx.forth.word.Dropping;
import com.epam.engx.forth.word.Duplicating;
import com.epam.engx.forth.word.Multiplication;
import com.epam.engx.forth.word.Overing;
import com.epam.engx.forth.word.Subtraction;
import com.epam.engx.forth.word.Swapping;

import java.util.Map;
import java.util.function.Supplier;

public final class ForthEngineFactory implements Supplier<ForthEngine> {

    @Override
    public ForthEngine get() {
        return new ForthEngine(Map.of(
            "+", new Addition(),
            "-", new Subtraction(),
            "*", new Multiplication(),
            "/", new Division(),
            "dup", new Duplicating(),
            "drop", new Dropping(),
            "swap", new Swapping(),
            "over", new Overing()
        ));
    }
}
