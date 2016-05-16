package startGame;


import java.awt.*;
import java.awt.event.KeyEvent;

public class GameMenu implements GameState{

    //VARS:
    static public String[] choice = {"Start","Help","Quit"};
    static public int correntchoice = 0;
    static public int drawLenght = 15;
    static public Color choiceColor;
    static public boolean choiceVar = false;
    static private Font font = new Font("Century Gothics",Font.PLAIN,35);
    FirstLevel fL = new FirstLevel() ;


    @Override
    public void update() {

    fL.init();

    }

    @Override
    public void draw(Graphics2D g) {

        g.setFont(font);

        for(int i = 0; i < choice.length ; i++){
            if(i == correntchoice) choiceColor = Color.red;
            else  choiceColor = Color.BLACK;

            g.setColor(choiceColor);
            g.drawString(choice[i] , 365 , 300 + i * 40);
        }

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {


        int key = keyEvent.getKeyCode();

        if(key == KeyEvent.VK_UP){
            if(correntchoice > 0) correntchoice--;
            else correntchoice = 2;
        }

        if(key == KeyEvent.VK_DOWN){
            if(correntchoice < 2) correntchoice++;
            else correntchoice = 0;
        }

        if(key == KeyEvent.VK_ENTER){
           choiceVar = true;
            makeChoice();
        }


    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {


    }

    public void makeChoice(){


            if(correntchoice == 2) System.exit(0);
            if(correntchoice == 0) GameLoader.LOADVAR = GameLoader.GAMESTATE; //1


           choiceVar = false;
    }


}
