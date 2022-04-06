import processing.core.PApplet;
import processing.data.XML;


public class Main extends PApplet {
    XML xml;
    public SRect rects[] = new SRect[100];
    public SCirc circs[] = new SCirc[100];
    public SLine lines[] = new SLine[][100];
    public SEllip ellips[] = new SEllip[100];


    class SRect {
        private int x;
        private int y;
        private int w;
        private int h;
        public SRect(int x, int y, int w, int h) {
            this.x = x;
            this.y = y;
            this.w = w;
            this.h = h;
        }
    }

    class SCirc {
        private int cx;
        private int cy;
        private int r;
        public SCirc(int cx, int cy, int r) {
            this.cx = cx;
            this.cy = cy;
            this.r = r;
        }
    }

    class SEllip {
        private int cx;
        private int cy;
        private int rx;
        private int ry;

        public SEllip(int rx, int ry, int cx, int cy) {
            this.cx = cx;
            this.cy = cy;
            this.rx = rx;
            this.ry = ry;
        }
    }
    class SLine {
        private int x1;
        private int x2;
        private int y1;
        private int y2;

        public SLine(int x1, int y1, int x2, int y2) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }
    }


    public void setup(){
        xml = loadXML("test.svg");
        XML[] children = xml.getChildren("circle");
        println(children.length);

    }

    public static void main(String[] args) {
        PApplet.main("Main");

    }
}