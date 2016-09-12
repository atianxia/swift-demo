package com.study.swift.shared;

import com.facebook.swift.codec.*;
import com.facebook.swift.codec.ThriftField.Requiredness;
import com.facebook.swift.codec.ThriftField.Recursiveness;
import java.util.*;

import static com.google.common.base.MoreObjects.toStringHelper;

@ThriftStruct("SharedStruct")
public final class SharedStruct
{
    public SharedStruct() {
    }

    private int key;

    @ThriftField(value=1, name="key", requiredness=Requiredness.NONE)
    public int getKey() { return key; }

    @ThriftField
    public void setKey(final int key) { this.key = key; }

    private String value;

    @ThriftField(value=2, name="value", requiredness=Requiredness.NONE)
    public String getValue() { return value; }

    @ThriftField
    public void setValue(final String value) { this.value = value; }

    @Override
    public String toString()
    {
        return toStringHelper(this)
            .add("key", key)
            .add("value", value)
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

        SharedStruct other = (SharedStruct)o;

        return
            Objects.equals(key, other.key) &&
            Objects.equals(value, other.value);
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(new Object[] {
            key,
            value
        });
    }
}
