package startGame;


import java.awt.*;

public  abstract class GameObject {

//VARS:
private MapReader tileMap;
private double x;
private double y;
private double dx;
private double dy;
private boolean jumping;
private boolean falling;
private  boolean topLeft;
private  boolean topRight;
private  boolean bottomLeft;
private boolean bottomRight;
private int width;
private int height;



//CONSTRUCTOR
public GameObject(int w,int h){


    width = w;
    height = h;

}

//FUNCTIONS

    public void init(MapReader tileMap){
        this.tileMap = tileMap;
    }


    public void checkTileCollision(double tx , double ty, double dx, double dy,boolean j,boolean f){

    x = tx; y = ty;
    double tempx = x;
    double tempy = y;

    jumping = j;
    falling = f;

    this.dx = dx; this.dy = dy;


    double tox = x + dx;
    double toy = y + dy;


    int currCol = (int) tileMap.getColTile((int)x);
    int currRow = (int) tileMap.getRowTile((int)y);

    calculateCorners(x , toy);

    if(dy < 0){
        if(topLeft || topRight){
            this.dy = 0;
            tempy = currRow * tileMap.getTileSize() + height/2;
        }else { tempy += this.dy; }
    }

    if(dy > 0){


        if(bottomRight || bottomLeft){
            this.dy = 0; falling = false; tempy = (currRow + 1) * tileMap.getTileSize() - height/2;

        }else tempy += this.dy;

    }

    calculateCorners(tox , y);

    if(dx < 0){
        if(topLeft || bottomLeft){
            this.dx = 0; tempx = currCol * tileMap.getTileSize() + width/2;
        }else tempx += this.dx;

    }

    if(dx > 0){

        if(topRight || bottomRight){
            this.dx = 0;
            tempx = (currCol + 1) * tileMap.getTileSize() - width/2;

        }else tempx += this.dx;
    }

    if(!falling){
        calculateCorners(x,y + 1);
        if(!bottomLeft && !bottomRight) falling = true;
    }

    x = tempx;
    y = tempy;


}


public void calculateCorners(double x , double y){

    int leftTile = (int) tileMap.getColTile(x - width/2);
    int rightTile = (int) tileMap.getColTile(x + width/2 - 1);
    int topTile = (int) tileMap.getRowTile(y - height/2);
    int buttonTile = (int) tileMap.getRowTile(y + height /2 - 1);
    topLeft = tileMap.getTile(topTile , leftTile) == 0;
    topRight = tileMap.getTile(topTile , rightTile) == 0;
    bottomLeft = tileMap.getTile(buttonTile , leftTile) == 0; //!
    bottomRight = tileMap.getTile(buttonTile , rightTile) == 0; //!
}



public boolean getFalling(){ return falling; }
public boolean getJumping(){ return jumping; }
public double getNewX(){ return x; }
public double getNewY(){ return y; }
public double getNewDx(){ return this.dx; }
public double getNewDy(){ return this.dy; }

//ABSTRACT FUNCTIONS
abstract void draw(Graphics2D g);
abstract void update();

}
