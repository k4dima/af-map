import com.fasterxml.jackson.databind.ObjectMapper
import org.apache.commons.io.IOUtils
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import java.nio.charset.Charset

@RunWith(JUnit4::class)
class SearchTest {
    @Test
    fun test() = IOUtils.toString(javaClass.getResource("data.json"), Charset.defaultCharset())
        .run { ObjectMapper().readValue(this, Map::class.java) }
        .run { @Suppress("UNCHECKED_CAST") Apps.search(this as Map<String, Any>, "af") }
        .run { Assert.assertEquals("ahah", this) }
}