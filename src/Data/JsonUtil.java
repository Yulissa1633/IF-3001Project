package Data;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {
	
	
    private ObjectMapper mapper = new ObjectMapper();

    public <T> String asJson(T value) {
        try {
            return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(value);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }


    public <V> V asObject(URL path, Class<V> type) {
        try {
            return mapper.readValue(path, type);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public <V> V asObject(String json, Class<V> type) {
        try {
            return mapper.readValue(json, type);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String pretty(String json) {
        try {
            return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public <T> void toFile(File file,T value) {
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(file, value);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

