/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package graphicsworkbok;
import processing.core.PApplet;
//test
public class MySketch extends PApplet {
  private Person person1; // declare a person object
  private Person person2; // declare a person object
  private boolean showInfo = false; // whether or not to display the person's info

  public void settings() {
    size(400, 400);
  }

  public void setup() {
    background(255); // set the background color to white
    // create a person object in the center of the screen
    person1 = new Person(this, 0, 0, "Mr. Lu", 16, "images/thefit.png");
    person2 = new Person(this, 100, 100, "Mr. Loo", 88, "images/fit.png");
  }

  public void draw() {
    background(255); // clear the screen
    person1.draw(); // draw the person on the screen
    person2.draw(); // draw the person on the screen
    drawCollisions();
  }

  public void drawCollisions() {
    if (person1.isCollidingWith(person2)) {
      fill(255, 0, 0); // set the stroke color to red
      this.text("honk honk", person2.x, person2.y); 
    }
  }

  public void keyPressed() {
    if (keyCode == LEFT) {
      person1.move(-10, 0); // move the person to the left when the left arrow key is pressed
    } else if (keyCode == RIGHT) {
      person1.move(10, 0); // move the person to the right when the right arrow key is pressed
    } else if (keyCode == UP) {
      person1.move(0, -10); // move the person up when the up arrow key is pressed
    } else if (keyCode == DOWN) {
      person1.move(0, 10); // move the person down when the down arrow key is pressed
    }
  }
}
