package org.example.service.serializers;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.model.Statement;
import org.apache.kafka.common.serialization.Deserializer;

import java.io.IOException;
import java.util.Map;

public class StatementDeserializer implements Deserializer<Statement> {

    @Override
    public Statement deserialize(String topic, byte[] data) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            Statement statement = mapper.readValue(data, Statement.class);
            return statement;
        } catch (JsonParseException e) {

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void close() {

    }

    @Override
    public void configure(Map configs, boolean isKey) {
    }

}
