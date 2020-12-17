/*
 * Author: Kaden Payne
 * Date: 11/23/2020
 * Interface with methods that all the rooms should use
 */
package Rooms;

import Character.CharacterPane;
import javafx.scene.image.Image;
import javafx.scene.shape.Line;

/**
 *
 * @author kjpay
 */
public interface Room {
    //add walls to room
    public void drawWalls();
    
    //add doors to room
    public void drawDoors();
    
    //add room to class
    public void drawRoom();
    
    //add floor to room
    public void drawFloor();
    
    //add health to room
    public void drawHealth(Image health);
    
    //replaces health in room
    public void replaceHealth(Image health);
    
    //gets Image of health
    public Image getHealth();
    
    //add CharacterPane to room
    public void drawCharacter(double x, double y);
    
    //gets CharacterPane object
    public CharacterPane getCharacter();
    
    //add arrow to room
    public void drawArrow();
    
    //shoots arrow in room
    public void shootArrow(Line path);
    
    //add cursor image into room
    public void drawCursor();
    
    //set X and Y of cursor
    public void setCursor(double x, double y);
}
