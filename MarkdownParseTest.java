import static org.junit.Assert.*;
import org.junit.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }
    @Test
    public void testBreak1() throws IOException{
        ArrayList<String> a = new ArrayList<>();
        Path p = Path.of("/Users/hihowareu/Documents/markdown-parser/break-test.md");
        String content = Files.readString(p);
        a.add("https://en.wikipedia.org/wiki/Diego_(tortoise)");
        assertEquals(a, MarkdownParse.getLinks(content));
    }
}