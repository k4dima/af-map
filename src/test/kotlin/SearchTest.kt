import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.apache.commons.io.IOUtils
import org.junit.Assert
import org.junit.Test
import java.nio.charset.Charset

class SearchTest {
    @Test
    fun test() = IOUtils.toString(javaClass.getResource("data.json"), Charset.defaultCharset())
            .let { Gson().fromJson<Map<String, Any>>(it, object : TypeToken<Map<String, Any>>() {}.type) }
            .let { search(it, "af") }
            .let { Assert.assertEquals("ahah", it) }
}