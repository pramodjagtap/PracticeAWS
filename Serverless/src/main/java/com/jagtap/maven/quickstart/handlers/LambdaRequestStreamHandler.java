package com.jagtap.maven.quickstart.handlers;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.IOUtils;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestStreamHandler;

public class LambdaRequestStreamHandler implements RequestStreamHandler {
    LambdaLogger logger;

    public void handleRequest(InputStream inputStream, OutputStream outputStream, Context context) throws IOException {

        this.logger = context.getLogger();
        final String input = IOUtils.toString(inputStream, StandardCharsets.UTF_8.name());
        outputStream.write(("Lambda request success:" + input).getBytes());
    }

}
