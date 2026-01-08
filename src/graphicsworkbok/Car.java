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

public class Car {
  private int x, y; // position of the person
  private int speed; // age of the person
  private PImage image; // image of the person
  private PApplet app; // the canvas used to display
 
  public Car(PApplet p, int x, int y, int speed, String imagePath) {
    this.app = p;
    this.x = x;
    this.y = y;
    this.speed = speed;
    this.image = app.loadImage(imagePath);
  }
  
  public void move(int dx, int dy) {
    if (dx != 0){
        x += (dx * speed);
    } if (dy != 0){
        y += (dy * speed);
    }
  }
  
  public void draw() {
    // draw the image at the person's position
    app.image(image, x, y); 
  }
  
  public boolean isClicked(int mouseX, int mouseY) {
    float d = PApplet.dist(mouseX, mouseY, x, y);
    // return true if  mouse is within 25px of the person's position
    return d < 60; 
  }

  public void displayInfo(PApplet p) {
    app.fill(0); // set the fill color to black
    // display the name and age above the person's position
    app.text("X and Y: " + x + ", " + y, x, y - 50);
    app.text("Speed: " + speed * 5, x, y - 30); 
  }
}