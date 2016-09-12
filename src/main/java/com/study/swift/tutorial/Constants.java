package com.study.swift.tutorial;

import java.util.Map;

import com.google.common.collect.ImmutableMap;

public final class Constants
{
    private Constants() {
    }

    public static final int INT32CONSTANT = 9853;

    public static final Map<String, String> MAPCONSTANT = ImmutableMap.<String, String>builder()
        .put("goodnight", "moon")
        .put("hello", "world")
        .build();
}
