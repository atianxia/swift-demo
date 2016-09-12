package com.study.swift.tutorial;

import com.facebook.swift.codec.*;
import com.facebook.swift.codec.ThriftField.Requiredness;
import com.facebook.swift.service.*;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.*;
import java.util.*;

@ThriftService("Calculator")
public interface Calculator extends com.study.swift.shared.SharedService
{
    @ThriftService("Calculator")
    public interface Async extends com.study.swift.shared.SharedService.Async
    {
        @ThriftMethod(value = "ping")
        ListenableFuture<Void> ping();

        @ThriftMethod(value = "add")
        ListenableFuture<Integer> add(
            @ThriftField(value=1, name="num1", requiredness=Requiredness.NONE) final int num1,
            @ThriftField(value=2, name="num2", requiredness=Requiredness.NONE) final int num2
        );

        @ThriftMethod(value = "calculate",
                      exception = {
                          @ThriftException(type=InvalidOperation.class, id=1)
                      })
        ListenableFuture<Integer> calculate(
            @ThriftField(value=1, name="logid", requiredness=Requiredness.NONE) final int logid,
            @ThriftField(value=2, name="w", requiredness=Requiredness.NONE) final Work w
        );

        @ThriftMethod(value = "zip",
                      oneway = true)
        ListenableFuture<Void> zip();
    }
    @ThriftMethod(value = "ping")
    void ping() throws org.apache.thrift.TException;

    @ThriftMethod(value = "add")
    int add(
        @ThriftField(value=1, name="num1", requiredness=Requiredness.NONE) final int num1,
        @ThriftField(value=2, name="num2", requiredness=Requiredness.NONE) final int num2
    ) throws org.apache.thrift.TException;

    @ThriftMethod(value = "calculate",
                  exception = {
                      @ThriftException(type=InvalidOperation.class, id=1)
                  })
    int calculate(
        @ThriftField(value=1, name="logid", requiredness=Requiredness.NONE) final int logid,
        @ThriftField(value=2, name="w", requiredness=Requiredness.NONE) final Work w
    ) throws InvalidOperation, org.apache.thrift.TException;

    @ThriftMethod(value = "zip",
                  oneway = true)
    void zip() throws org.apache.thrift.TException;
}