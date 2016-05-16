package startGame;


import java.awt.*;
import java.awt.event.KeyEvent;

public interface GameState {

//FUNCTIONS:
void update();
void  draw(Graphics2D g);
void keyPressed(KeyEvent keyEvent);
void keyReleased(KeyEvent keyEvent);

}
