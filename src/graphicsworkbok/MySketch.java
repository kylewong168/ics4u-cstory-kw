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
    // allows for "sub-states" within the game for progression
    private int storyStep = 0;
    // 0 intro
    // 1 wip
    // 2 wip
    // 3 wip
    // x 
    // add all assets here when made, or it wont work
    private Asset plains;
    private Asset river;
    private Asset dbox;
    private Asset jadeemperor;
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
    jadeemperor = new Asset(this, 1050, 475, 99, "images/jadeemperor.png");
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
        // plains/start scene
        if (storyStep <= 3) {
            drawPlainsScene();
            drawBackButton();
        }
        // river scene
        else if (storyStep <= 6) { // increase number in the future if needed, also the plan for creating multiple river parts
            drawRiverScene1();
        }
        // finishing order?
        else if (storyStep <= 100) { // for Use of user input controls for graphics, maybe have one where you control the slow pig to the finish
            drawPlainsScene(); // placeholder, create new one
        } 
    else if (gameState == 2) {
      drawZodiac(); // zodiac finder for gameState 2
      drawBackButton();
    }
  }
  } // end draw()

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
      text("< BACK", 40, 26); // back text
  }

  // placeholders for drawing gameState
  public void drawPlainsScene() {
    plains.draw();
    dbox.draw();
    jadeemperor.draw();
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
    fill(0); // black
    textSize(28); // below is the longest one line of dialogue should be before cut off
    if (storyStep == 0) {
        text("Once upon a time in ancient China...", width / 2, 96);
        text("The Jade Emperor announced a race between all animals.", width / 2, 124);
    }
    else if (storyStep == 1) {
        text("The Jade emperor needed to choose an animal for each year in the twelve", width / 2, 96);
        text("year cycle. All will race across a river, and the first twelve to finish each", width / 2, 124);
        text("got to represent a year.", width / 2, 152);
    }
    else if (storyStep == 2) {
        text("All the animals soon gathered in the plains to start. There came the pig,", width / 2, 96);
        text("rooster, monkey, goat, horse, snake, rabbit, dog, tiger, ox, rat, and dragon.", width / 2, 124);
    }
    else if (storyStep == 3) {
        text("The animals strategized with each other. The rat asked the ox, its friend to", width / 2, 96);
        text("work together and ride to the finish, and the monkey, goat, and the leading", width / 2, 124);
        text("rooster chose to team up. And now, the race was about to begin.", width / 2, 152);
        text("Click to begin race", width / 2, 180);
    }
  }
  
  // make multiple parts?
  public void drawRiverScene1() {
      river.draw();
      dbox.draw();
      fill(0);
      textSize(28);
      if (storyStep == 4) { // keep track, IMPORTANT
          rat.setPosition(275, 500);
          ox.setPosition(300, 520);
          
          ox.draw();
          rat.draw();
          text("The rat rode on the ox's back..........................................", width / 2, 96);
      }

      
  }
  // placeholder for the additional feature
  public void drawZodiac() {
    fill(0);
    textSize(32);
    text("Zodiac Finder here", width / 2, height / 2);
  }
  

  // inputs
  public void mousePressed() {

    // MAIN MENU
    if (gameState == 0) {
      if (mouseX > width/2 - 150 && mouseX < width/2 + 150 &&
          mouseY > 320 && mouseY < 380) {
        gameState = 1;
        storyStep = 0;
      }
      else if (mouseX > width/2 - 150 && mouseX < width/2 + 150 &&
               mouseY > 420 && mouseY < 480) {
        gameState = 2;
      }
    }

    // STORY
    else if (gameState == 1) {

      // BACK BUTTON
      if (mouseX > 10 && mouseX < 70 && mouseY > 10 && mouseY < 38) {
        gameState = 0;
        storyStep = 0;
        return;
      }

      // DIALOGUE BOX
      if (mouseX > 90 && mouseX < 90 + 1020 &&
          mouseY > 48 && mouseY < 48 + 160) {

        storyStep++;  // always move forward
      }
    }

    // OTHER STATES
    else {
      if (mouseX > 10 && mouseX < 70 && mouseY > 10 && mouseY < 38) {
        gameState = 0;
      }
    }
  }
}