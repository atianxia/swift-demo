package com.study.swift.tutorial;

import com.facebook.swift.codec.*;
import com.google.common.collect.*;
import java.util.*;

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
