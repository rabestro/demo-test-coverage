package com.epam.engx.forth;

import com.epam.engx.forth.engine.ForthEngine;
import com.epam.engx.forth.engine.ForthEngineFactory;

import java.util.List;

public final class ForthEvaluator {
    private final ForthEngine forthEngine;

    public ForthEvaluator() {
        forthEngine = new ForthEngineFactory().get();
    }

    public List<Integer> evaluateProgram(Iterable<String> commands) {
        commands.forEach(forthEngine);
        return forthEngine.get();
    }
}
