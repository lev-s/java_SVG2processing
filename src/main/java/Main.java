import processing.core.*;
import processing.data.XML;


public class Main extends PApplet {
    XML xml;

    @Override
    public void settings(){
        size(500,900);
    }

    public void setup(){
        xml = loadXML("test.svg");
    }

    public int[] getColor(String color){
        int[] RGB = new int[3];
        if(color.equals("black")){
            RGB[0]=0;
            RGB[1]=0;
            RGB[2]=0;
        }
        else if(color.equals("white")){
            RGB[0]=255;
            RGB[1]=255;
            RGB[2]=255;
        }
        else if(color.equals("red")){
            RGB[0]=255;
            RGB[1]=0;
            RGB[2]=0;
        }
        else if(color.equals("blue")){
            RGB[0]=0;
            RGB[1]=0;
            RGB[2]=255;
        }
        else if(color.equals("yellow")){
            RGB[0]=255;
            RGB[1]=255;
            RGB[2]=0;
        }
        else if(color.equals("green")){
            RGB[0]=0;
            RGB[1]=255;
            RGB[2]=0;
        }
        return RGB;
    }

    public void draw(){
        background(206, 197, 240);
        strokeWeight(2);

        /* Circle */
        XML[] circ = xml.getChildren("circle");
        println("*********** Circle ***********");
        for(int i = 0; i<circ.length;i++){
            //coloring
            String circColor = circ[i].getString("stroke");
            int[] rgb = getColor(circColor);

            int cx = circ[i].getInt("cx");
            int cy = circ[i].getInt("cy");
            int r = circ[i].getInt("r");

            stroke(rgb[0], rgb[1], rgb[2]);
            noFill();
            ellipse(cx, cy, r+5, r+5);
            println(cx, cy, r);
        }


        /* Path */
        XML[] path = xml.getChildren("path");
        println("*********** Path ***********");
        for(int i = 0; i<path.length;i++) {
            //coloring
            String pathColor = path[i].getString("stroke");
            int[] rgb = getColor(pathColor);


            String d = path[i].getString("d");
            String[] dd = d.split("\\s");

            if (dd[3].equals("L")) {
                int x1 = Integer.parseInt(dd[1]);
                int y1 = Integer.parseInt(dd[2]);
                int x2 = Integer.parseInt(dd[4]);
                int y2 = Integer.parseInt(dd[5]);
                println(x1, y1, x2, y2);

                stroke(rgb[0], rgb[1], rgb[2]);
                line(x1, y1, x2, y2);
            }
            if (dd[3].equals("Q")) {
                int x1 = Integer.parseInt(dd[1]);
                int y1 = Integer.parseInt(dd[2]);
                int px = Integer.parseInt(dd[4]);
                int py = Integer.parseInt(dd[5]);
                int x2 = Integer.parseInt(dd[6]);
                int y2 = Integer.parseInt(dd[7]);
                println(x1, y1, px, py, x2, y2);
                noFill();
                stroke(rgb[0], rgb[1], rgb[2]);
                bezier(x2, y2, px, py, px, py, x1, y1);
            }
        }

            /* Text */
            XML[] textt = xml.getChildren("text");
            println("*********** Text ***********");
            for(int i = 0; i<textt.length;i++){
                int tx = textt[i].getInt("x");
                int ty = textt[i].getInt("y");
                String textContent = textt[i].getContent();
                println(tx, ty, textContent);
                fill(0, 0, 0);
                text(textContent, tx+15, ty);
            }




    }

    public static void main(String[] args) {
        PApplet.main("Main");

    }
}