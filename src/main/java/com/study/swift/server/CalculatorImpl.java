package com.study.swift.server;

import org.apache.thrift.TException;

import com.study.swift.shared.SharedStruct;
import com.study.swift.tutorial.Calculator;
import com.study.swift.tutorial.InvalidOperation;
import com.study.swift.tutorial.Work;

/**
 * Created by luoyong on 16-9-12.
 */
public class CalculatorImpl implements Calculator{

	@Override
	public SharedStruct getStruct(int key) throws TException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void ping() throws TException {
		System.out.println("---------------ping--------------");
	}

	@Override
	public int add(int num1, int num2) throws TException {
		System.out.println("---------------add--------------");
		System.out.println( num1 + " +" + num2 + "=" +  (num1 + num2));
		return num1 + num2;
	}

	@Override
	public int calculate(int logid, Work w) throws InvalidOperation, TException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void zip() throws TException {
		// TODO Auto-generated method stub
		
	}
}
