package mate.academy.wikibot.util;

import java.io.InputStream;
import java.io.OutputStream;

public interface BaseSerializer {
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
    public <T> T deserialize(Class<T> clazz, InputStream in) throws Exception;

    /**
     * Serializes the specified object into stream.
     *
     * @param serialiedObj object to serialize
     * @param out output stream to serialize to.
     * @throws Exception when IO error occurs.
     */
    public void serialize(Object serialiedObj, OutputStream out) throws Exception;
}
