package com.study.swift.tutorial;

import com.facebook.swift.codec.*;
import com.facebook.swift.codec.ThriftField.Requiredness;
import com.facebook.swift.codec.ThriftField.Recursiveness;
import java.util.*;

@ThriftStruct("InvalidOperation")
public final class InvalidOperation extends RuntimeException
{
    private static final long serialVersionUID = 1L;

    public InvalidOperation() {
    }

    private int whatOp;

    @ThriftField(value=1, name="whatOp", requiredness=Requiredness.NONE)
    public int getWhatOp() { return whatOp; }

    @ThriftField
    public void setWhatOp(final int whatOp) { this.whatOp = whatOp; }

    private String why;

    @ThriftField(value=2, name="why", requiredness=Requiredness.NONE)
    public String getWhy() { return why; }

    @ThriftField
    public void setWhy(final String why) { this.why = why; }
}
