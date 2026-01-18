/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package graphicsworkbok;

/**
 *
 * @author 342883410
 */
import processing.core.PApplet;
import processing.core.PImage;
import java.io.*;
import java.util.*;

/**
 * represents a visual asset in the game
 * handles position, speed, image, and drawing on PApplet
 * @author snail
 */
public class Asset {
  private int x, y; // current position of asset
  private int speed; // movement multiplier
  private PImage image; // image representing the asset
  private PApplet app; // the canvas
  private float scale = 1.0f; // scale factor when drawing image (base 1.0)
  public static int assetCount = 0; // static counter for tracking how many asset objects exist
 
  /**
   * main constructor for Asset
   * @param p PApplet canvas for drawing asset on
   * @param x initial x coordinate
   * @param y initial y coordinate
   * @param speed movement multiplier for asset
   * @param imagePath file path of image representing an asset
   */
  public Asset(PApplet p, int x, int y, int speed, String imagePath) {
    this.app = p;
    this.x = x;
    this.y = y;
    this.speed = speed;
    this.image = app.loadImage(imagePath);
    assetCount++;
  }
  
  /**
   * overloaded constructor for asset with default position and speed 1
   * @param p PApplet canvas
   * @param imagePath file path of image representing asset
   */
  public Asset(PApplet p, String imagePath) { 
    this(p, 0, 0, 1, imagePath);
  }
  
  /**
   * moves the asset by a certain amount
   * movement is multiplied by the speed field
   * @param dx change in x direction
   * @param dy change in y direction
   */
  public void move(int dx, int dy) {
    if (dx != 0){
        x += (dx * speed);
    } if (dy != 0){
        y += (dy * speed);
    }
  }
  
  /**
   * return current x coordinate of an asset
   * @return current x coordinate
   */
  public int getX() {
      return x;
  }
  
  /**
   * draws the asset image on the PApplet canvas
   * takes position and scale for use
   */
  public void draw() {
    // draw the image at the asset position
    app.image(image, x, y, image.width * scale, image.height * scale); // for set position and scale methods
  }
  
  /**
   * sets a new position for an asset
   * used for resetting or moving assets for a scene before drawing
   * @param x new x coordinate
   * @param y new y coordinate
   */
  public void setPosition(int x, int y) {
      this.x = x;
      this.y = y;
  }
  
  /**
   * sets scale for asset image
   * used for visual clarity, when assets are better smaller or larger in
   * certain scenes
   * @param s scale factor, 1.0 base
   */
  public void setScale(float s) {
      this.scale = s;
  }
}
