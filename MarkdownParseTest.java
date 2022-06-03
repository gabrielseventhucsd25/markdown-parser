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
    /*
    @Test
    public void testBreak1() throws IOException{
        ArrayList<String> a = new ArrayList<>();
        Path p = Path.of("/Users/hihowareu/Documents/GitHub/markdown-parser/break-test.md");
        String content = Files.readString(p);
        a.add("https://en.wikipedia.org/wiki/Diego_(tortoise)");
        assertEquals(a, MarkdownParse.getLinks(content));
    }
    */
    @Test
    public void testSnippet1() throws IOException{
        ArrayList<String> a = new ArrayList<>();
        Path p = Path.of("/Users/hihowareu/Documents/GitHub/markdown-parser/snippet1.md");
        String content = Files.readString(p);
        a.add("url.com");
        a.add("google.com");
        a.add("google.com");
        a.add("ucsd.edu");
        assertEquals(a, MarkdownParse.getLinks(content));
    }
    @Test
    public void testSnippet2() throws IOException{
        ArrayList<String> a = new ArrayList<>();
        Path p = Path.of("/Users/hihowareu/Documents/GitHub/markdown-parser/snippet2.md");
        String content = Files.readString(p);
        a.add("a.com");
        a.add("b.com");
        a.add("a.com");
        a.add("example.com");
        assertEquals(a, MarkdownParse.getLinks(content));
    }
    @Test
    public void testSnippet3() throws IOException{
        ArrayList<String> a = new ArrayList<>();
        Path p = Path.of("/Users/hihowareu/Documents/GitHub/markdown-parser/snippet3.md");
        String content = Files.readString(p);
        a.add("https://www.twitter.com");
        a.add("https://sites.google.com/eng.ucsd.edu/cse-15l-spring-2022/schedule");
        a.add("github.com");
        a.add("https://cse.ucsd.edu/");
        assertEquals(a, MarkdownParse.getLinks(content));
    }
}