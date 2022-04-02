import processing.core.PApplet;
import processing.data.XML;


public class Main extends PApplet {
    XML xml;

    public void setup(){
        xml = loadXML("test.svg");
        XML[] children = xml.getChildren("path");
        println(children.length);
        for (int i = 0; i < children.length; i++) {
            String name = children[i].getString("d");

            println(name);
        }

    }


    public static void main(String[] args) {
        PApplet.main("Main");

    }
}