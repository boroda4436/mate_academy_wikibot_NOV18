package mate.academy.wikibot.util;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.InputStream;
import java.io.OutputStream;

import org.springframework.stereotype.Component;

@Component
public class JsonSerializer implements BaseSerializer {
    private ObjectMapper jsonSerializer = new ObjectMapper();

    public JsonSerializer() {
        jsonSerializer.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    /**
     * Deserializes specified object from specified input stream.
     *
     * @param clazz objects class type to deserialize.
     * @param in buffered input reader.
     *
     * @return deserialized object.
     *
     * @throws Exception when IO error occurs.
     */
    public <T> T deserialize(Class<T> clazz, InputStream in) throws Exception {
        return jsonSerializer.readValue(in, clazz);
    }

    /**
     * Serializes the specified object into stream in JSON format.
     *
     * @param serialiedObj object to serialize
     * @param out output stream to serialize to.
     * @throws Exception when IO error occurs.
     */
    public void serialize(Object serialiedObj, OutputStream out) throws Exception {
        jsonSerializer.writeValue(out, serialiedObj);
    }
}
