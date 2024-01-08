package com.example.webshopapi.service;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;

public class StringArrayDeserializer extends StdDeserializer<String[]> {

    public StringArrayDeserializer() {
        super(String[].class);
    }

    @Override
    public String[] deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        JsonNode node = p.getCodec().readTree(p);
        String stringValue = node.textValue();

        if (stringValue == null || stringValue.isEmpty()) {
            return new String[0];
        }

        return stringValue.split(",");
    }
}


