//https://howtodoinjava.com/java/io/java-read-file-to-string-examples/

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

//Test to see if I can commit from ieng6

public class MarkdownParse {

    public static ArrayList<String> getLinks(String markdown) {
        ArrayList<String> toReturn = new ArrayList<>();
        int currentIndex = 0;
        while(currentIndex < markdown.length()) {
            String str = "";
            if(markdown.indexOf("http", currentIndex) >= 0){
                currentIndex = markdown.indexOf("http", currentIndex);
            }
            else if(markdown.indexOf("(", currentIndex) >= 0){
                currentIndex = markdown.indexOf("(", currentIndex) + 1;
            }

            int endline = markdown.indexOf("\n", currentIndex);
            if(endline < 0){
                endline = markdown.length();
            }
            for(int i = currentIndex; i < endline; i++){
                Character c = markdown.charAt(i);
                if(Character.isLetter(c)){
                    str += c;
                }
                else{
                    if(c == '-' || c == '(' || c == ')' || c == '.' || c == ':' || c == '/' || c == '_'){
                        if(currentIndex - 1 >= 0){
                            if(markdown.charAt(currentIndex - 1) == '(' && i == markdown.lastIndexOf(")", endline)){
                                continue;
                            }
                        }
                        str += c;
                    }
                    else{
                        str = "";
                    }
                }
            }
            if(!str.equals("")){
                toReturn.add(str);
            }
            currentIndex = endline + 1;
        }
        return toReturn;
    }


    public static void main(String[] args) throws IOException {
        Path fileName = Path.of(args[0]);
        String content = Files.readString(fileName);
        ArrayList<String> links = getLinks(content);
	    System.out.println(links);
    }
}
