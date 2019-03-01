package com.jagtap.maven.quickstart.handlers;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class LambdaRequestHandler implements RequestHandler<String, String> {
    LambdaLogger logger;
    //ObjectMapper objectMapper;

    public String handleRequest(String input, Context context) {
        this.logger = context.getLogger();
        //this.objectMapper = new ObjectMapper();
        logger.log("Input: "+ input);
        return "Lambda Call Success: " + input;
    }

}
