package startGame;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameListeners implements KeyListener{

    //VARS:
    GameState gameMenu;
    GameState lv1;
    GameState gs;

    //CONSTRUCTOR:
    public GameListeners(){
        gameMenu = GameLoader.loadArray.get(0);
        lv1 = GameLoader.loadArray.get(1);
    }



    @Override
    public void keyTyped(KeyEvent keyEvent) {
        //TODO nothing here!
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {

      gs = GameLoader.loadArray.get(GameLoader.LOADVAR);
      gs.keyPressed(keyEvent);

    //gameMenu.keyPressed(keyEvent);
   // lv1.keyPressed(keyEvent);

    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

     gs = GameLoader.loadArray.get(GameLoader.LOADVAR);
     gs.keyReleased(keyEvent);

    }
}
