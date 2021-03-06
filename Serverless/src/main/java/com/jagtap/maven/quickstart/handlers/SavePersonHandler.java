package com.jagtap.maven.quickstart.handlers;

import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.PutItemOutcome;
import com.amazonaws.services.dynamodbv2.document.spec.PutItemSpec;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.jagtap.maven.quickstart.model.PersonRequest;
import com.jagtap.maven.quickstart.model.PersonResponse;

public class SavePersonHandler implements RequestHandler<PersonRequest, PersonResponse> {

    private DynamoDB dynamoDB;
    private static final String DYNAMODB_TABLE_NAME = "Person";
    private static final Regions REGION = Regions.US_WEST_2;
    private LambdaLogger logger;

    @Override
    public PersonResponse handleRequest(PersonRequest personRequest, Context context) {
        this.logger = context.getLogger();
        this.initDynamoDBClient();
        this.persistData(personRequest);

        return buildPersonResponse(personRequest);
    }

    private PersonResponse buildPersonResponse(PersonRequest personRequest) {
        PersonResponse response = new PersonResponse();
        response.setMessage("Successfully executed and added="+ personRequest.toString());
        return response;
    }

    private PutItemOutcome persistData(PersonRequest personRequest) {
        Item item = new Item()
                .withNumber("Id", personRequest.getId())
                .withString("firstName", personRequest.getFirstName())
                .withString("lastName", personRequest.getLastName());

        logger.log("Input request=" + item.toJSONPretty());
        return this.dynamoDB.getTable(DYNAMODB_TABLE_NAME)
                .putItem(new PutItemSpec().withItem(item));
    }

    private void initDynamoDBClient() {
        AmazonDynamoDBClient client = new AmazonDynamoDBClient();
        client.setRegion(Region.getRegion(REGION));
        this.dynamoDB = new DynamoDB(client);
    }

}
