package com.study.swift.tutorial;

import com.facebook.swift.codec.*;
import com.facebook.swift.codec.ThriftField.Requiredness;
import com.facebook.swift.codec.ThriftField.Recursiveness;
import java.util.*;

import static com.google.common.base.MoreObjects.toStringHelper;

@ThriftStruct("Work")
public final class Work
{
    public Work() {
    }

    private int num1;

    @ThriftField(value=1, name="num1", requiredness=Requiredness.NONE)
    public int getNum1() { return num1; }

    @ThriftField
    public void setNum1(final int num1) { this.num1 = num1; }

    private int num2;

    @ThriftField(value=2, name="num2", requiredness=Requiredness.NONE)
    public int getNum2() { return num2; }

    @ThriftField
    public void setNum2(final int num2) { this.num2 = num2; }

    private Operation op;

    @ThriftField(value=3, name="op", requiredness=Requiredness.NONE)
    public Operation getOp() { return op; }

    @ThriftField
    public void setOp(final Operation op) { this.op = op; }

    private String comment;

    @ThriftField(value=4, name="comment", requiredness=Requiredness.OPTIONAL)
    public String getComment() { return comment; }

    @ThriftField
    public void setComment(final String comment) { this.comment = comment; }

    @Override
    public String toString()
    {
        return toStringHelper(this)
            .add("num1", num1)
            .add("num2", num2)
            .add("op", op)
            .add("comment", comment)
            .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Work other = (Work)o;

        return
            Objects.equals(num1, other.num1) &&
            Objects.equals(num2, other.num2) &&
            Objects.equals(op, other.op) &&
            Objects.equals(comment, other.comment);
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(new Object[] {
            num1,
            num2,
            op,
            comment
        });
    }
}
