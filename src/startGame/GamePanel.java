package startGame;


import javax.swing.*;
import java.awt.*;

public class GamePanel extends Component {
/*this class use swing and awt to draw all elements on frame*/


    //VARS:
    public static int WINDOW_W = 800;
    public static int WINDOW_H = 525;


    //OBJECT-VARS:
    GameLoader loadGame;
    public JFrame window;


    //CONSTRUCTOR:
    public GamePanel() {

        loadGame = new GameLoader();
        this.createWindow();
        this.go();

    }


//FUNCTIONS:

//todo create window:
public void createWindow(){

    window = new JFrame();
    window.setSize(WINDOW_W,WINDOW_H);
    window.setVisible(true);
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setResizable(false);
    window.add(this);
    window.addKeyListener(new GameListeners());

}

public void go(){ startGame(); }

public void startGame(){

while(true){


    try {

        update();
        Thread.sleep(36);
        repaint();

    } catch (Exception e){ e.printStackTrace(); }



 }


}



public  void update(){
    loadGame.update();
}



//todo draw game here:

public void paint(Graphics g) {

  //сглаживание: (make graphics more colorful) + Graphics -> Graphics2D
  Graphics2D g2 = (Graphics2D) g; //преобразуем Graphics в Graphics2D
  g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON); //сглаживание
  g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,RenderingHints.VALUE_TEXT_ANTIALIAS_ON);


loadGame.draw(g2);


}


}
