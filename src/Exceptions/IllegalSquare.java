package Exceptions;

import Exceptions.TacticalChaosGameException;

public class IllegalSquare extends TacticalChaosGameException {
    public IllegalSquare(String s) {
        super(s);
    }
}
