import com.fasterxml.jackson.databind.ObjectMapper
import org.apache.commons.io.IOUtils
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import java.nio.charset.Charset

@RunWith(JUnit4::class)
class SearchTest {
    @Suppress("UNCHECKED_CAST")
    @Test
    fun test() = with(
        AppsFlyer.rollPushNotificationPayload(
            ObjectMapper().readValue<Map<*, *>>(
                IOUtils.toString(
                    javaClass.getResource("data.json"),
                    Charset.defaultCharset()
                ),
                Map::class.java
            ) as Map<String, Any>,
            "af"
        )
    ) { Assert.assertEquals("ahah", this) }
}