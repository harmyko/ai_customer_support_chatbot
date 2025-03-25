package com.teiserskis.ai_customer_support_chatbot.services;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.dialogflow.v2.*;
import java.io.FileInputStream;
import java.io.IOException;

import org.springframework.stereotype.Service;

@Service
public class DialogflowService {
    private final String projectId = "erudite-bloom-454819-j4";
    private final String sessionId = "123456";

    public String detectIntentText(String text) throws IOException {
        String keyFilePath = "src/main/resources/erudite-bloom-454819-j4-f376d4666b41.json";

        @SuppressWarnings("resource")
		SessionsClient sessionsClient = SessionsClient.create(
                SessionsSettings.newBuilder()
                        .setCredentialsProvider(() -> GoogleCredentials.fromStream(new FileInputStream(keyFilePath)))
                        .build()
        );

        SessionName session = SessionName.of(projectId, sessionId);
        TextInput.Builder textInput = TextInput.newBuilder().setText(text).setLanguageCode("en");
        QueryInput queryInput = QueryInput.newBuilder().setText(textInput).build();

        DetectIntentResponse response = sessionsClient.detectIntent(session, queryInput);
        sessionsClient.close();

        return response.getQueryResult().getFulfillmentText();
    }
}

