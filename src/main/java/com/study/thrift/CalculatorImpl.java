package com.study.thrift;

import org.apache.thrift.TException;

import com.study.thrift.Calculator.Iface;

public class CalculatorImpl implements Iface {

	@Override
	public int add(int num1, int num2) throws TException {
		return num1+ num2;
	}

}
