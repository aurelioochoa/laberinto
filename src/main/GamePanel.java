package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import character.Player;

public class GamePanel extends JPanel implements Runnable{
    
  final int retroTileSize = 16;
  final int scaleFactor = 3;
  public final int tileSize = retroTileSize * scaleFactor;
  
  final int maxScreenCol = 16;
  final int maxScreenRow = 12;
  
  final int screenWidth = tileSize * maxScreenCol;
  final int screenHeight = tileSize * maxScreenRow;

  int FPS = 60;

  KeyHandler keyHandler = new KeyHandler();
  
  Thread gameThread;

  Player player = new Player(this, keyHandler);

  public GamePanel() {

    this.setPreferredSize(new Dimension(screenWidth, screenHeight));
    this.setBackground(Color.black);
    this.setDoubleBuffered(true);
    this.addKeyListener(keyHandler);
    this.setFocusable(true);
  }

  public void startGameThread(){

    gameThread = new Thread(this);
    gameThread.start();
  }

  @Override
  public void run() {

    double drawInterval = 1000000000/FPS;
    double nextDrawInterval = System.nanoTime() + drawInterval;

    while(gameThread != null){

      update();
      repaint();

      try {
        
        double remainingTime = nextDrawInterval - System.nanoTime();        
        remainingTime = remainingTime/1000000;

        if (remainingTime <= 0 ){
          remainingTime = 0;
        }
        
        Thread.sleep((long) remainingTime);
        
        nextDrawInterval += drawInterval;
      
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

  }

  public void update(){

    player.update();
  }

  public void paintComponent(Graphics g){
    
    super.paintComponent(g);
    
    Graphics2D g2 = (Graphics2D)g;
    
    player.draw(g2);

    g2.dispose();
  }

}




