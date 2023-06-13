package character;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.lang.reflect.Array;

import main.GamePanel;

public abstract class Character {

  GamePanel panel;
  
  public int x, y;
  public int speed;
  public int spriteCounter = 0;
  public int spriteNumber = 0;

  public BufferedImage 
    up_sprite_1, 
    up_sprite_2, 
    down_sprite_1, 
    down_sprite_2, 
    left_sprite_1, 
    left_sprite_2,
    right_sprite_1,
    right_sprite_2;

  public void setDefaultValues() {
  }

  public void update() {
  }
  
  public void draw(Graphics2D g2) {
  }
}