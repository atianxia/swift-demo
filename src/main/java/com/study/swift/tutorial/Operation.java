package com.study.swift.tutorial;

import com.facebook.swift.codec.*;

public enum Operation
{
    ADD(1), SUBTRACT(2), MULTIPLY(3), DIVIDE(4);

    private final int value;

    Operation(int value)
    {
        this.value = value;
    }

    @ThriftEnumValue
    public int getValue()
    {
        return value;
    }
}
