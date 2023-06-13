package character;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.KeyHandler;

public class Player extends Character {
  
  GamePanel panel;
  KeyHandler keyHandler;

  private boolean upPressed = keyHandler.UpPressed;
  private boolean downPressed = keyHandler.DownPressed;
  private boolean leftPressed = keyHandler.LeftPressed;
  private boolean rightPressed = keyHandler.RightPressed;


  public Player(GamePanel panel, KeyHandler keyHandler){
    this.panel = panel;
    this.keyHandler = keyHandler;
    setDefaultValues();
    getCharacterImage();
  }

  public void setDefaultValues() {
    x = 100;
    y = 100;
    speed = 4;
  }

  public void getCharacterImage() {
    try {
      up_sprite = ImageIO.read(getClass().getResourceAsStream("/player/"));
      up_sprite = ImageIO.read(getClass().getResourceAsStream("/player/"));
      up_sprite = ImageIO.read(getClass().getResourceAsStream("/player/"));
      up_sprite = ImageIO.read(getClass().getResourceAsStream("/player/"));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void update() {
    
    if (upPressed == true){
      y -= speed;
    } else if (leftPressed == true){
      x -= speed;
    } else if (downPressed == true){
      y += speed;
    } else if (rightPressed == true){
      x += speed;
    }

    spriteCounter++;
    if (spriteCounter > 10){
      if sprite_1
    }
  }

  private void changeSpriteFrame(int sprite){

    BufferedImage player_image;

    if (sprite == 1){
      player_image = up_sprite_1;
    } else if (sprite == 2){
      player_image = up_sprite_2;
    }

    // return player_image;
  }

  public void draw(Graphics2D g2) {
    g2.setColor(Color.CYAN);
    g2.fillRect(x, y, panel.tileSize, panel.tileSize);

    BufferedImage player_image = null;

    if (upPressed){
      if (spriteNumber == 1){
        player_image = up_sprite_1;
      } else if (spriteNumber == 2){
        player_image = up_sprite_2;
      }
    } else if(downPressed){
      if (spriteNumber == 1){
        player_image = up_sprite_1;
      } else if (spriteNumber == 2){
        player_image = up_sprite_2;
      }
    } else if(rightPressed){
      if (spriteNumber == 1){
        player_image = up_sprite_1;
      } else if (spriteNumber == 2){
        player_image = up_sprite_2;
      }
    } else if(leftPressed){
      if (spriteNumber == 1){
        player_image = left_sprite_1;
      } else if (spriteNumber == 2){
        player_image = left_sprite_2;
      }
    }

    g2.drawImage(player_image, x, y, panel.tileSize, panel.tileSize, null);
  }

}
