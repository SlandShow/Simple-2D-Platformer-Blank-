package startGame;


import java.awt.*;
import java.util.ArrayList;

public class GameLoader {

//LOAD-VARS:
public static int MENUSTATE = 0;
public static int GAMESTATE = 1;
public static int LOADVAR ;

//OBJECT-VARS:
public static ArrayList<GameState> loadArray;

//CONSTRUCTOR:
 public GameLoader(){
   LOADVAR = MENUSTATE;
   loadArray = new ArrayList<GameState>();
   loadArray.add(new GameMenu());
   loadArray.add(new FirstLevel());
 }

//FUNCTIONS:
public void update(){

loadArray.get(LOADVAR).update();
}

public void draw(Graphics2D g){
    loadArray.get(LOADVAR).draw(g);

}


}
