package com.study.swift.shared;

import com.facebook.swift.codec.*;
import com.facebook.swift.codec.ThriftField.Requiredness;
import com.facebook.swift.service.*;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.*;
import java.util.*;

@ThriftService("SharedService")
public interface SharedService
{
    @ThriftService("SharedService")
    public interface Async
    {
        @ThriftMethod(value = "getStruct")
        ListenableFuture<SharedStruct> getStruct(
            @ThriftField(value=1, name="key", requiredness=Requiredness.NONE) final int key
        );
    }
    @ThriftMethod(value = "getStruct")
    SharedStruct getStruct(
        @ThriftField(value=1, name="key", requiredness=Requiredness.NONE) final int key
    ) throws org.apache.thrift.TException;
}