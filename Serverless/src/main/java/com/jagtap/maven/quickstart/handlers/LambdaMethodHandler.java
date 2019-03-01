package com.jagtap.maven.quickstart.handlers;

import com.amazonaws.services.lambda.runtime.Context;

public class LambdaMethodHandler {

    public String handleRequest(String input, Context context) {
        context.getLogger().log("Input: "+ input);
        return "Lambda Call Success: " + input;
    }
}
