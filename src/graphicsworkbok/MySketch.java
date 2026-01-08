/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package graphicsworkbok;
import processing.core.PApplet;

public class MySketch extends PApplet {
  private Car car1; // declare a car object
  private Car car2;
  private Car selectedCar = null; // which car is currently controlled
  private boolean showInfoCar1 = false; // whether or not to display the car's info
  private boolean showInfoCar2 = false; // whether or not to display the car's info

  
  public void settings() {
    size(400, 400);
  }
  public void setup() {
    background(255); // set the background color to white
    // create a person object in the center of the screen
    car1 = new Car(this, 100, 100, 2, "images/monkey.png"); 
    car2 = new Car(this, 200, 200, 2, "images/thefit.png"); 
  }
  
  public void draw() {
    background(255); // clear the screen
    car1.draw(); // draw the person on the screen
    car2.draw();
   if (showInfoCar1) {
      // display the person's info if the showInfo flag is true
      car1.displayInfo(this); 
   } if (showInfoCar2) {
      car2.displayInfo(this);
   }

    if (keyPressed && selectedCar != null) {
  if (keyCode == LEFT) {
    selectedCar.move(-5, 0);
  } else if (keyCode == RIGHT) {
    selectedCar.move(5, 0);
  } else if (keyCode == UP) {
    selectedCar.move(0, -5);
  } else if (keyCode == DOWN) {
    selectedCar.move(0, 5);
  }
}
  }
  
  public void mousePressed() {
  if (car1.isClicked(mouseX, mouseY)) {
    selectedCar = car1;
    showInfoCar1 = true;
    showInfoCar2 = false;
  } 
  else if (car2.isClicked(mouseX, mouseY)) {
    selectedCar = car2;
    showInfoCar2 = true;
    showInfoCar1 = false;
  } 
  else {
    selectedCar = null;
    showInfoCar1 = false;
    showInfoCar2 = false;
  }
}

}