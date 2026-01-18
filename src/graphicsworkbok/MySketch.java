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
import java.io.*;
import java.util.*;

/**
 * MySketch is a processing sketch for telling my cultural story
 * Includes menu, game, and zodiac finder
 * @author snail
 */
public class MySketch extends PApplet {
    private String birthYearInput = ""; // stores digits typed by user for zodiac finder
    private String zodiacResult =  ""; // store calculated zodiac animal
    private boolean inputActive = true; // whether or not user is allowed to type (zodiac finder)
    // game states to progress
    private int gameState = 0;
    // 0, main menu
    // 1, story
    // 2, zodiac finder
    //  storyStep allows for "sub-states" within the game for progression
    private int storyStep = 0;
    private boolean pigFinaleStarted = false; // flag for pig mini game
    // game assets for story
    private Asset plains;
    private Asset river;
    private Asset finishline;
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
    private Asset pig; // pig is-an Animal object for mini-game
    private Asset raft;
    
    // zodiac animal traits for zodiac finder
    private String[][] animalTraits = {
       {"Rat", "Smart"},
       {"Ox", "Strong"},
       {"Tiger", "Brave"},
       {"Rabbit", "Agile"},
       {"Dragon", "Honourable"},
       {"Snake", "Clever"},
       {"Horse", "Energetic"},
       {"Goat", "Kind"},
       {"Monkey", "Creative"},
       {"Rooster", "Leader"},
       {"Dog", "Loyal"},
       {"Pig", "Persistent"}
    };
  
  public void settings() {
    size(1200, 800); // frame dimensions
  }
  public void setup() {
    textAlign(CENTER); // all text will be centred horizontally
    // initializing assets
    dbox = new Asset(this, 90, 48, 99, "images/dbox.png"); // standard position for it
    jadeemperor = new Asset(this, 1050, 475, 99, "images/jadeemperor.png");
    plains = new Asset(this, 0, 0, 99, "images/plains.png");
    river = new Asset(this, 0, 0, 99, "images/river.png");
    finishline = new Asset(this, 0, 0, 99, "images/finishline.png");
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
    pig = new Animal(this, 880, 514, 99, "images/pig.png"); // calls Animal.draw(), polymorphism
    raft = new Asset(this, 0, 0, 99, "images/raft.png");
    
  }
  
  /**
   * main drawing loop, continously called by processing
   * handles drawing based on the game state
   */
  public void draw() {
    background(255); // white bg

    if (gameState == 0) { // main menu
      drawMenu(); // main menu for gameState 0
    } 
    else if (gameState == 1) { // game
        // plains/start scene, story logic
        if (storyStep <= 3) {
            drawPlainsScene();
            drawBackButton();
        }
        // river scene
        else if (storyStep <= 14) { // increase number in the future if needed, also the plan for creating multiple river parts
            drawRiverScene1();
        }
        // finishing order?
        else if (storyStep <= 24) { 
            drawFinishScene(); 
        } 
    }
    else if (gameState == 2) { // zodiac finder
      drawZodiac(); // zodiac finder for gameState 2
      drawBackButton();
    }
  } // end draw()

  /**
   * draws the main menu with start and zodiac finder button
   */
  public void drawMenu() {
    fill(0); // black text colour
    textSize(48); // text size
    text("KW - The Story of the Chinese Zodiac", width / 2, 200); // title drawn in center

    // Start Button
    drawButton(width / 2, 350, 300, 60, "START"); // start button

    // Zodiac Finder Button
    drawButton(width / 2, 450, 300, 60, "Find Your Zodiac"); // zodiac finder button
  }

  /**
   * draw a button at given coordinates and with label
   */
  public void drawButton(int x, int y, int w, int h, String label) {
    rectMode(CENTER); // this makes rectangles draw in the center
    fill(200); // gray colour for buttons
    rect(x, y, w, h); // draws the rectangle
    fill(0); // black colour for button text
    textSize(24); // text size in button
    text(label, x, y + 8); // draw button labels slightly lower
  }
  
  /**
   * dras back button to exit game states back to main meny
   */
  public void drawBackButton() {
      rectMode(CORNER); // align in corner
      fill(200); // button colour
      rect(10, 10, 60, 20); // button dimension in top left
      fill(0); // text colour
      textSize(16);
      text("< BACK", 40, 26); // back text
  }

  /**
   * draws plains scene, first part of game story
   */
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
    // ensuring reset of all scales and positions when replaying
    rat.setScale(1.0f); 
    ox.setScale(1.0f);
    tiger.setScale(1.0f);
    rabbit.setScale(1.0f);
    dragon.setScale(1.0f);
    snake.setScale(1.0f);
    horse.setScale(1.0f);
    goat.setScale(1.0f);
    monkey.setScale(1.0f);
    rooster.setScale(1.0f);
    dog.setScale(1.0f);
    pig.setScale(1.0f);
    rat.setPosition(120, 541);
    ox.setPosition(170, 511);
    tiger.setPosition(300, 515);
    rabbit.setPosition(420, 509);
    dragon.setPosition(460, 560);
    snake.setPosition(600, 600);
    horse.setPosition(650, 511);
    goat.setPosition(750, 620);
    monkey.setPosition(750, 510);
    rooster.setPosition(790, 561);
    dog.setPosition(310, 600);
    pig.setPosition(880, 514);
    raft.setPosition(0, 0);
    
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
  
  /**
   * draws river scene, second and most significant part of game story
   * uses multiple story steps like others
   * changing positions for animals
   */
  public void drawRiverScene1() {
    river.draw();
    dbox.draw();
    fill(0);
    textSize(28);
    if (storyStep == 4) { // keep track, IMPORTANT
        rat.setPosition(24, 380);
        ox.setPosition(24, 400);
        rat.setScale(1.25f);
        ox.setScale(1.25f);
        ox.draw();
        rat.draw();
        text("At the rapid river...", width / 2, 96);
        text("The rat ccould not swim well, so it asked the ox to carry it across.", width / 2, 124);
    }
    else if (storyStep == 5) {
        rat.setPosition(660, 375);
        ox.setPosition(669, 395);
        tiger.setPosition(180, 395);
        tiger.setScale(1.25f);
        ox.draw();
        rat.draw();
        tiger.draw();
        text("While the ox and rat treaded through the rapid river,", width / 2, 96);
        text("the formidable tiger leapt in behind, swimming against the strong current", width / 2, 124);
    }
    else if (storyStep == 6) {
        rat.setPosition(1005, 600);
        ox.setPosition(1000, 580);
        tiger.setPosition(660, 548);
        rabbit.setPosition(170, 480);
        rabbit.setScale(1.25f);
        ox.draw();
        rat.draw();
        tiger.draw();
        rabbit.draw();
        text("The ox and rat made it across, as the tiger pushed through.", width / 2, 96);
        text("Next came the agile rabbit, hopping across the stones.", width / 2, 124);
    }
    else if (storyStep == 7) {
        tiger.setPosition(1000, 580);
        rabbit.setPosition(520, 560);
        tiger.draw();
        rabbit.draw();
        text("The tiger made it across, as the rabbit continued hopping from stone to stone.", width / 2, 96);
    }
    else if (storyStep == 8) {
        rabbit.setPosition(1000, 580);
        dragon.setPosition(400, 300);
        dragon.setScale(1.25f);
        rabbit.draw();
        dragon.draw();
        text("The rabbit managed to cross the river, as the dragon finally made its", width / 2, 96);
        text("appearance. The dragon was expected to come first as it could fly, but had", width / 2, 124);
        text("stopped along the way to help a farmer put out a fire.", width / 2, 152);
    }
    else if (storyStep == 9) {
        dragon.setPosition(1000, 580);
        horse.setPosition(420, 560);
        snake.setPosition(390, 545);
        horse.setScale(1.25f);
        snake.setScale(1.25f);
        dragon.draw();
        horse.draw();
        snake.draw();
        text("The dragon flew across, as the horse and scheming snake approached.", width / 2, 96);
        text("The horse powerfully treaded across, with the snake unknowingly hiding", width / 2, 124);
        text("around the horse's leg.", width / 2, 152);
    }
    else if (storyStep == 10) {
        horse.setPosition(1040, 560);
        snake.setPosition(1010, 545);
        goat.setPosition(290, 360);
        monkey.setPosition(349, 385);
        rooster.setPosition(395, 360);
        raft.setPosition(270, 390);
        goat.setScale(1.25f);
        monkey.setScale(1.25f);
        rooster.setScale(1.25f);
        raft.setScale(1.25f);
        horse.draw();
        snake.draw();
        raft.draw();
        goat.draw();
        rooster.draw();
        monkey.draw();
        text("The horse and sneaky snake made it across the river, as the next animals", width / 2, 96);
        text("approached. Now came the goat, monkey, and their rooster leader.", width / 2, 124);
        text("They had put together a raft to cross in together!", width / 2, 152);
    }
    else if (storyStep == 11) {
        goat.setPosition(1050, 580);
        monkey.setPosition(1020, 530);
        rooster.setPosition(1000, 470);
        raft.setPosition(770, 400);
        dog.setPosition(580, 430);
        raft.draw();
        rooster.draw();
        monkey.draw();
        goat.draw();
        dog.draw();
        text("The team of the monkey, goat, and rooster soon crossed the river", width / 2, 96);
        text("Next came the dog, getting distracted and playing in the river...", width / 2, 124);
    }
    else if (storyStep == 12) {
        dog.setPosition(1050, 580);
        dog.setScale(1.25f);
        dog.draw();
        text("The dog played and played, forgetting about the race, until finally crossing", width / 2, 96);
        text("the river.", width / 2, 124);
    }
    else if (storyStep == 13) {
        pig.setPosition(580, 430);
        pig.setScale(1.25f);
        pig.draw();
        text("And eventually, the pig had finally arrived after all the animals crossed.", width / 2, 96);
        text("Before starting, the pig had stopped for food on the way, and even took a nap.", width / 2, 124);
    }
    else if (storyStep == 14) {
        pig.setPosition(999, 600);
        pig.draw();
        text("The pig finally made its way across the river after lots of slack,", width / 2, 96);
        text("as the rest of the animals headed toward the finish line.", width / 2, 124);
    } 
  }
  
  /**
   * draws finish line scene, third and final part of game story
   * handles pig minigame user movement control
   */
  public void drawFinishScene() {
    finishline.draw();
    dbox.draw();
    fill(0);
    textSize(28);
    if (storyStep == 15) { 
        rat.setPosition(740, 440);
        ox.setPosition(580, 500);
        rat.setScale(2.0f);
        ox.setScale(2.0f);
        
        ox.draw();
        rat.draw();
        text("At the finish line...", width / 2, 96);
        text("The rat leapt off of the ox's back showing smarts and finesse, stealing first place!", width / 2, 124);
        text("The ox came in second, after the rat, still proving its strength and endurance.", width / 2, 152);
    }
    else if (storyStep == 16) {
        tiger.setPosition(740, 438);
        tiger.setScale(2.0f);
        tiger.draw();
        
        text("The tiger came next, earning third place, showing brawn and bravery", width / 2, 96);
    }
    else if (storyStep == 17) {
        rabbit.setPosition(740, 440);
        rabbit.setScale(2.0f);
        rabbit.draw();
        
        text("Next came the rabbit, earning fourth place with agility and quick thinking.", width / 2, 96);
    }
    else if (storyStep == 18) {
        dragon.setPosition(740, 440);
        dragon.setScale(2.0f);
        dragon.draw();
        
        text("Then came the dragon, finishing in fifth. The dragon was able to fly easily, but", width / 2, 96);
        text("instead chose honour, helping along the way.", width / 2, 124);
    }
    else if (storyStep == 19) {
        snake.setPosition(740, 440);
        horse.setPosition(580, 500);
        snake.setScale(2.0f);
        horse.setScale(2.0f);
          
        horse.draw();
        snake.draw();
        text("As the horse was about to finish, it was startled by the snake, hiding on its leg!", width / 2, 96);
        text("The snake stole sixth place, as the horse took seventh place.", width / 2, 124);
    }
    else if (storyStep == 20) {
        goat.setPosition(740, 440);
        monkey.setPosition(580, 500);
        rooster.setPosition(520, 560);
        goat.setScale(2.0f);
        monkey.setScale(2.0f);
        rooster.setScale(2.0f);
          
        goat.draw();
        monkey.draw();
        rooster.draw();
        text("The goat finished eigth, the monkey finishing ninth, and the rooster finishing tenth,", width / 2, 96);
        text("all together showing cooperation, creativity, and teamwork.", width / 2, 124);
    }
    else if (storyStep == 21) {
        dog.setPosition(740, 440);
        dog.setScale(2.0f);
          
        dog.draw();
        text("Next came the dog, earning eleventh place, capable but distracted.", width / 2, 96);
    }
    else if (storyStep == 22) { // user control minigame for pig
        if (!pigFinaleStarted) {
            pig.setPosition(50, 640);
            pig.setScale(2.0f);
            pigFinaleStarted = true;
        }
        pig.setScale(2.0f);
        pig.draw();
        text("At last, the pig finally arrives at the finish.", width / 2, 96);
        text("Help move the pig to cross the finish line!", width / 2, 124);
        text("Hint, use arrow keys", width / 2, 152);
        
        if (pig.getX() > 1100) {
            storyStep = 23; // final scene
        }
    }
    else if (storyStep == 23) {
        pig.setPosition(740, 440);
        pig.setScale(2.0f);
        pig.draw();
        pigFinaleStarted = false; // reset for next playthrough
        
        text("Finally, the pig crosses the finish in twelfth place.", width / 2, 96);
        text("Slow but steady, the pig shows that persistence still leads to the finish.", width / 2, 152);
       
    }
  }
  
  /**
   * zodiac animal and the associated trait
   * @param animal
   * @return trait associated with zodiac animal
   */
  private String getTrait(String animal) {
      for (int i = 0; i < animalTraits.length; i++) {
          if (animalTraits[i][0].equalsIgnoreCase(animal)) {
              return animalTraits[i][1];
          }
      }
      return "unknown"; // if nothing found
  }
  
  /**
   * draws zodiac finder game state, user input and results
   */
  public void drawZodiac() {
    background(255); // white bg
    fill(0);
    textSize(32);
    text("Enter your birth year and press ENTER", width / 2, 200);
    
    textSize(32);
    text(birthYearInput, width / 2, 300);
    
    if (!zodiacResult.equals("")) {
        String trait = getTrait(zodiacResult); 
        textSize(36);
        text("Your Chinese Zodiac Animal: " + zodiacResult, width / 2, 400);
        textSize(28);
        text("Trait: " + trait, width / 2, 450);
    }
  }
  
  /**
   * handles keyboard input for pig movement and zodiac finder input
   */
  public void keyPressed() {

    if (gameState == 1 && storyStep == 22) { // movement for the semifinal pig scene only
        if (keyCode == LEFT)  pig.move(-1, 0);
        if (keyCode == RIGHT) pig.move(1, 0);
        if (keyCode == UP)    pig.move(0, -1);
        if (keyCode == DOWN)  pig.move(0, 1);
    }

    // RESET the result and user input when backspace pressed
    if (gameState == 2 && !inputActive && keyCode == BACKSPACE) {
        birthYearInput = "";
        zodiacResult = "";
        inputActive = true;
    }

    // INPUT MODE for zodiac, only active during zodiac finder game state
    if (gameState == 2 && inputActive) {
        if (key >= '0' && key <= '9') { // only allow digits
            birthYearInput += key;
        } 
        else if (keyCode == BACKSPACE && birthYearInput.length() > 0) {
            birthYearInput = birthYearInput.substring(0, birthYearInput.length() - 1);
        } 
        else if (keyCode == ENTER || keyCode == RETURN) {
            if (!birthYearInput.equals("")) {
                int year = Integer.parseInt(birthYearInput);
                zodiacResult = getZodiac(year);
                writeResult(year, zodiacResult);
                inputActive = false; // stops any typing until reset
            }
        }
    }
  }
  
  /**
   * gives zodiac animal for a given year with zodiac.txt
   * @param year input from user
   * @return the zodiac animal after calculated given year, reading from zodiac.txt
   */
  private String getZodiac(int year) {
    ArrayList<String> animals = new ArrayList<>();
    try {
        BufferedReader br = new BufferedReader(
            new FileReader(dataPath("zodiac.txt"))
        );
        String line;
        while ((line = br.readLine()) != null) {
            animals.add(line.trim());
        }
        br.close();
    } catch (IOException e) {
        e.printStackTrace();
        return "Error reading zodiac.txt";
    }

    if (animals.size() < 12) {
        return "zodiac.txt must have 12 lines";
    }

    int index = (year - 4) % 12;
    if (index < 0) index += 12;
    return animals.get(index);
  }
  
  /**
   * write the users birthyear and zodiac animal to results.txt
   * @param year user input
   * @param animal calculated zodiac animal
   */
  private void writeResult(int year, String animal) {
    try {
        BufferedWriter bw = new BufferedWriter(new FileWriter(sketchPath("results.txt"), true));
        bw.write("Year " + year + ": " + animal);
        bw.newLine();
        bw.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
  }

  /**
   * handles mouse input for buttons, dialogue, back buttons
   */
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
          if (storyStep == 23) { 
              gameState =  0;
              storyStep = 0;
          }
          else if (storyStep != 22) { // for pig's final movement scene, must move pig
              storyStep++; // progress as usual
          }

      }
    }

    // BACK BUTTON
    else {
      if (mouseX > 10 && mouseX < 70 && mouseY > 10 && mouseY < 38) {
        gameState = 0;
      }
    }
  }
}