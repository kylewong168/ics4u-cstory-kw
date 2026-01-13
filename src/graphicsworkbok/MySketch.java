/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package graphicsworkbok;
import processing.core.PApplet;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class MySketch extends PApplet {
    // game states to progress
    private int gameState = 0;
    // 0, main menu
    // 1, story
    // 2, zodiac finder
    // add all assets here when made, or it wont work
    private Asset plains;
    private Asset river;
    private Asset dbox;
    private Asset rat;
    private Asset ox;
    private Asset tiger;
    private Asset rabbit;
    private Asset dragon;
    private Asset snake;
    private Asset horse;
    private Asset goat;
    private Asset monkey;
    private Asset rooster;
    private Asset dog;
    private Asset pig;
  
  public void settings() {
    size(1200, 800);
  }
  public void setup() {
    textAlign(CENTER); // all text will be centred horizontally
    dbox = new Asset(this, 90, 48, 99, "images/dbox.png"); // standard position for it
    plains = new Asset(this, 0, 0, 99, "images/plains.png");
    river = new Asset(this, 0, 0, 99, "images/river.png");
    rat = new Asset(this, 120, 541, 99, "images/rat.png");
    ox = new Asset(this, 170, 511, 99, "images/ox.png");
    tiger = new Asset(this, 300, 515, 99, "images/tiger.png");
    rabbit = new Asset(this, 420, 509, 99, "images/rabbit.png");
    dragon = new Asset(this, 460, 560, 99, "images/dragon.png");
    snake = new Asset(this, 600, 600, 99, "images/snake.png");
    horse = new Asset(this, 650, 511, 99, "images/horse.png");
    goat = new Asset(this, 750, 620, 99, "images/goat.png");
    monkey = new Asset(this, 750, 510, 99, "images/monkey.png");
    rooster = new Asset(this, 790, 561, 99, "images/rooster.png");
    dog = new Asset(this, 310, 600, 99, "images/dog.png");
    pig = new Asset(this, 880, 514, 99, "images/pig.png");
    
    
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
    text("KW - The Story of the Chinese Zodiac", width / 2, 200); // title drawn in center

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
      text("< BACK", 40, 26); // 
  }

  // placeholders for drawing gameState
  public void drawStory() {
    plains.draw();
    dbox.draw();
    rat.draw();
    ox.draw();
    tiger.draw();
    rabbit.draw();
    dragon.draw();
    snake.draw();
    horse.draw();
    goat.draw();
    monkey.draw();
    rooster.draw();
    dog.draw();
    pig.draw();
    fill(0); // white
    textSize(28); // below is the longest one line of dialogue should be before cut off
    text("Once upon a time in ancient China...", width / 2, 96);
    fill(0);
    textSize(28);
    text("The Jade Emperor announces a race to determine the order of Zodiac", width / 2, 124);
    fill(0);
    textSize(28);
    text("animals. The order the animals cross will earn a year named after them.", width / 2, 152);
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