package startGame;


import java.awt.*;
import java.awt.event.KeyEvent;

public class FirstLevel implements GameState{

    MapReader level1Reader;
    Player player;

    @Override
    public void update() {
    init();
    player.update();
    }

    @Override
    public void draw(Graphics2D g) {
    try {
      level1Reader.draw(g);
      player.draw(g);
    }catch (Exception e){ e.printStackTrace(); }

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {

        int key = keyEvent.getKeyCode();

        //exit action
        if(key == KeyEvent.VK_ESCAPE) GameLoader.LOADVAR = GameLoader.MENUSTATE; //0
       //gameplay action
        if(key == KeyEvent.VK_LEFT)  player.setLeft(true);
        if(key == KeyEvent.VK_RIGHT) player.setRight(true);
        if(key == KeyEvent.VK_SPACE) player.setJumping(true);
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

        int key = keyEvent.getKeyCode();

        if(key == KeyEvent.VK_ESCAPE) GameLoader.LOADVAR = GameLoader.MENUSTATE; //0

        if(key == KeyEvent.VK_LEFT) player.setLeft(false);
        if(key == KeyEvent.VK_RIGHT)player.setRight(false);

    }

    public void init(){

    if(level1Reader == null){
       level1Reader = new MapReader("C:/Users/Admin/IdeaProjects/PlatformerGame/src/res/gamemap.txt",32);
     }

    if(player == null){ player = new Player(level1Reader); player.setx(50); player.sety(50);}


    }


}
