package com.epam.engx.forth;

import com.epam.engx.forth.word.Addition;
import com.epam.engx.forth.word.Division;
import com.epam.engx.forth.word.Dropping;
import com.epam.engx.forth.word.Duplicating;
import com.epam.engx.forth.word.Multiplication;
import com.epam.engx.forth.word.Overing;
import com.epam.engx.forth.word.Subtraction;
import com.epam.engx.forth.word.Swapping;

import java.util.List;
import java.util.Map;

class ForthEvaluator {

    public List<Integer> evaluateProgram(Iterable<String> commands) {
        var forthEngine = new ForthEngine(Map.of(
            "+", new Addition(),
            "-", new Subtraction(),
            "*", new Multiplication(),
            "/", new Division(),
            "dup", new Duplicating(),
            "drop", new Dropping(),
            "swap", new Swapping(),
            "over", new Overing()
        ));
        commands.forEach(forthEngine);
        return forthEngine.get();
    }
}
