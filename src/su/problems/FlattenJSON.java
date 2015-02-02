package su.problems;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.type.TypeFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Akshat on 2/1/2015.
 */
public class FlattenJSON {
    public String compute(String str) throws IOException
    {
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, JsonNode> rootMap = objectMapper.readValue(
                str, TypeFactory.mapType(HashMap.class, String.class, JsonNode.class));
        for (Map.Entry<String, JsonNode> entry : rootMap.entrySet()) {
            substitute(entry.getKey(), entry.getValue().toString(), rootMap);
        }

        return objectMapper.writeValueAsString(rootMap);
    }

    private void substitute(String key, String str, Map<String, JsonNode> rootMap) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, JsonNode> map = objectMapper.readValue(
                str, TypeFactory.mapType(HashMap.class, String.class, JsonNode.class));

        for(Map.Entry<String, JsonNode> entry : map.entrySet())
        {
            // if value is again a composite object
            if(entry.getValue().isContainerNode()) {
                substitute(entry.getKey(), entry.getValue().toString(), rootMap);
            }else {
                JsonNode jsonNode = rootMap.get(entry.getValue().getValueAsText());
                if (jsonNode != null) {
                    entry.setValue(jsonNode);
                }
            }
        }
        String subStr = objectMapper.writeValueAsString(map);
        rootMap.put(key, objectMapper.readValue(subStr, TypeFactory.type(JsonNode.class)));
    }
}
