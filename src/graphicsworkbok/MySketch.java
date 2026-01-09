/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package graphicsworkbok;
import processing.core.PApplet;

public class MySketch extends PApplet {
    // game states to progress
    private int gameState = 0;
    // 0, main menu
    // 1, story
    // 2, zodiac finder

  
  public void settings() {
    size(1200, 800);
  }
  public void setup() {
    textAlign(CENTER); // all text will be centred horizontally
  }
  
  public void draw() {
    background(255); // white bg

    if (gameState == 0) {
      drawMenu(); // main menu for gameState 0
    } 
    else if (gameState == 1) {
      drawStory(); // story for gameState 1
      drawBackButton();
    } 
    else if (gameState == 2) {
      drawZodiac(); // zodiac finder for gameState 2
      drawBackButton();
    }
  }

  // main menu
  public void drawMenu() {
    fill(0); // black text colour
    textSize(48); // text size
    text("KW - The Great Zodiac Race", width / 2, 200); // title drawn in center

    // Start Button
    drawButton(width / 2, 350, 300, 60, "START"); // start button

    // Zodiac Finder Button
    drawButton(width / 2, 450, 300, 60, "Find Your Zodiac"); // zodiac finder button
  }

  // method for drawing buttons
  public void drawButton(int x, int y, int w, int h, String label) {
    rectMode(CENTER); // this makes rectangles draw in the center
    fill(200); // gray colour for buttons
    rect(x, y, w, h); // draws the rectangle
    fill(0); // black colour for button text
    textSize(24); // text size in button
    text(label, x, y + 8); // draw button labels slightly lower
  }
  
  public void drawBackButton() {
      rectMode(CORNER); // align in corner
      fill(200); // button colour
      rect(10, 10, 60, 20); // button dimension in top left
      fill(0); // text colour
      textSize(16);
      text("< BACK", 40, 26);
  }

  // placeholders
  public void drawStory() {
    fill(0);
    textSize(32);
    text("Story here", width / 2, height / 2);
  }

  public void drawZodiac() {
    fill(0);
    textSize(32);
    text("Zodiac Finder here", width / 2, height / 2);
  }

  // inputs
  public void mousePressed() {

    // main menu buttons, check if program is current on menu
    if (gameState == 0) {
      // check if start story button was clicked
      if (mouseX > width/2 - 150 && mouseX < width/2 + 150 && mouseY > 320 && mouseY < 380) {
        gameState = 1; // if so, switch gameState for story
      }
      // check if zodiac finder button was clicked
      else if (mouseX > width/2 - 150 && mouseX < width/2 + 150 && mouseY > 420 && mouseY < 480) {
        gameState = 2; // if so, switch gameState for zodiac finder
      }
    } 
    // return to menu
    else { // if mouse clicks in back buttons bounds
        if (mouseX > 10 && mouseX < 70 && mouseY > 10 && mouseY < 38) {
            gameState = 0; 
        }
    }
  }
}