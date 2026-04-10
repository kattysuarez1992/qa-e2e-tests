package utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.PurchaseData;

import java.io.InputStream;

public class JsonDataReader {

    public static PurchaseData getPurchaseData(String scenarioName) {
        try {
            ObjectMapper mapper = new ObjectMapper();

            InputStream inputStream = JsonDataReader.class
                    .getClassLoader()
                    .getResourceAsStream("data/purchase-data.json");

            JsonNode root = mapper.readTree(inputStream);
            JsonNode scenarioNode = root.get(scenarioName);

            return mapper.treeToValue(scenarioNode, PurchaseData.class);

        } catch (Exception e) {
            throw new RuntimeException("Error reading JSON test data", e);
        }
    }
}