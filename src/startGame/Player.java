package startGame;


import java.awt.*;

public class Player extends GameObject{

    //VARS:
    private double x;
    private double y;
    private double r;
    private double dx;
    private double dy;

    private int width;
    private int height;

    private boolean right;
    private boolean left;
    private boolean jumping;
    private boolean falling;

    private double moveSpeed;
    private double maxSpeed;
    private double maxFallingSpeed;
    private double stopSpeed;
    private double jumpStart;
    private double gravity;

    private  boolean topLeft;
    private  boolean topRight;
    private  boolean bottomLeft;
    private boolean bottomRight;
    private  boolean slipRight;
    private  boolean slipLeft;
    private  boolean splitRihtVar;
    private MapReader tileMaP;


    //CONSTRUCTOR:
    public Player(MapReader tm){


        super(20,20);

        tileMaP = tm;
        init(tm);

        width = 20;
        height = 20;

        moveSpeed = 0.6;
        maxSpeed = 2.2;
        maxFallingSpeed = 12;
        stopSpeed = 0.30;
        jumpStart = -11;
        gravity = 0.64;



    }


    //FUNCTIONS:
    public void update(){

        //player dx,dy,jumping,falling
        calculatePosition();

        //collision
        checkTileCollision(x,y,dx,dy,jumping,falling);

        //change vars
        falling = getFalling();
        jumping = getJumping();
        x = getNewX();
        y = getNewY();
        dx = getNewDx();
        dy = getNewDy();

    }



    public void calculatePosition(){

        if(left){

            dx -= moveSpeed;
            if(dx < -maxSpeed)dx = -maxSpeed;

        } else if(right){

            dx += maxSpeed;
            if(dx > maxSpeed) dx = maxSpeed;

        } else {

            if(dx > 0) {

                dx -= stopSpeed;
                if(dx < 0) dx = 0;

            } else if(dx < 0){

                dx += stopSpeed;
                if(dx > 0) dx = 0;

            }

        }

        if(jumping){

          //  System.out.println("ПРЫГАЮ");

            dy = jumpStart;

            falling = true;
            jumping = false;

        }

        if(falling){

            dy += gravity; //System.out.println(maxFallingSpeed + " maxfalspped  " + dy);
            if(dy > maxFallingSpeed) dy = maxFallingSpeed;

        } else dy = 0;

    }


    public void draw(Graphics2D g){

        int tx = tileMaP.getX();
        int ty = tileMaP.getY();

        g.setColor(Color.red);
        g.fillRect((int)(tx + x - width/2 ),(int) (ty + y - height / 2) , width , height);

    }


    public void setLeft(boolean left){ this.left = left; }
    public void setRight(boolean right){ this.right = right; }
    public void setJumping(boolean b){
        if(!falling){
            jumping = true;
        }
    }

    public  void setx(int i){ x = i; }
    public  void sety(int i){ y = i; }








}
