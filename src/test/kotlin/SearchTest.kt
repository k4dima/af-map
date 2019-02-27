import com.fasterxml.jackson.databind.ObjectMapper
import org.apache.commons.io.IOUtils
import org.junit.Assert
import org.junit.Test
import java.nio.charset.Charset

class SearchTest {
    @Test
    fun test() = IOUtils.toString(javaClass.getResource("data.json"), Charset.defaultCharset())
            .run { ObjectMapper().readValue(this, Map::class.java) }
            .run { @Suppress("UNCHECKED_CAST") search(this as Map<String, Any>, "af") }
            .run { Assert.assertEquals("ahah", this) }
}