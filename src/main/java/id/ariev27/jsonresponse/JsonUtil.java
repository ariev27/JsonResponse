package id.ariev27.jsonresponse;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

import java.io.IOException;

public class JsonUtil {
    private static ObjectMapper generateDefaultJsonMapper() {
        ObjectMapper om = new ObjectMapper();

        om.enable(SerializationFeature.INDENT_OUTPUT);
        om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        om.setSerializationInclusion(Include.NON_EMPTY);

        SimpleFilterProvider simpleFilter = new SimpleFilterProvider();
        simpleFilter.setFailOnUnknownId(false);

        om.setFilterProvider(simpleFilter);

        return om;
    }

    private static ObjectWriter generateDefaultJsonWriter() {
        return generateDefaultJsonMapper().writer();
    }

    public static String generateJson(Object obj) throws JsonProcessingException {
        ObjectWriter writer = generateDefaultJsonWriter();
        return writer.writeValueAsString(obj);
    }

    public static <T> T parseJson(String json, Class<T> cls)
            throws IOException {
        ObjectMapper om = generateDefaultJsonMapper();
        return om.readValue(json, cls);
    }
}