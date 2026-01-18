/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package graphicsworkbok;
import processing.core.PApplet;
/**
 * represents an animal in the game, extends Asset class
 * inherits position, speed, image, scale, and drawing function from Asset
 * @author snail
 */
public class Animal extends Asset {
    /**
     * constructor for Animal
     * users superclass constructor to set position, speed, and image
     * @param p PApplet canvas
     * @param x initial x coordinate of animal
     * @param y initial y coordinate of animal
     * @param speed movement multiplier for animal
     * @param img file path of animals image
     */
    public Animal(PApplet p, int x, int y, int speed, String img) {
        super(p, x, y, speed, img); // call asset constructor to initialize the fields
    }
    
    /**
     * draws the animal on the canvas
     * calls assets draw method
     */
    @Override
    public void draw() {
        super.draw();
    }
}
