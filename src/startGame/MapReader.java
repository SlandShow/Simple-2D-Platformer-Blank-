package startGame;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class MapReader {

//VARS:
private int tileSize;
private int[][] map;
private int mapWight;
private int mapHeight;
BufferedReader reader;
private int x;
private int y;


//CONSTRUCTOR:
public MapReader(String text,int tileSize){

 this.tileSize = tileSize;

    try {
        reader = new BufferedReader(new FileReader(text));//read from txt file

        mapWight = Integer.parseInt(reader.readLine());
        mapHeight = Integer.parseInt(reader.readLine());

        map = new int[mapHeight][mapWight];
        String delimiters = " ";

        for(int row = 0 ; row < mapHeight; row++ ){

            String line = reader.readLine();
            String[] tokens = line.split(delimiters);


            for (int col = 0; col < mapWight ; col++){
                map[row][col] = Integer.parseInt(tokens[col]);
            }


        }



    } catch (Exception e) { e.printStackTrace(); }




}

//FUNCTIONS:

public void draw(Graphics2D g){

    for(int row = 0 ; row < mapHeight ; row++){


        for(int col = 0 ; col < mapWight ; col++){

            int rc = map[row][col];

            if(rc == 0) g.setColor(new Color(20, 22, 46,160));
            if(rc == 1){ g.setColor(new Color(73, 78,255,160)); }

            g.fillRect(x + col * tileSize , y + row * tileSize ,tileSize + 1,tileSize + 1);

        }


    }



}


    public void setX(int x){ this.x = x; }
    public void setY(int y){ this.y = y; }


    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public double getColTile(double x) {

        return  (x / tileSize);

    }

    public double getRowTile(double y) {
        return  y/tileSize;
    }

    public int getTile(int row , int col){ return map[row][col]; }
    public int getTileSize(){ return tileSize; }




}
