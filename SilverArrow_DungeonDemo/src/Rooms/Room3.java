/*
 * Author: Kaden Payne
 * Date: 12/09/2020
 * Room 3 of the dungeon
 */
package Rooms;

import Character.CharacterPane;
import Object.ObjectPane;
import javafx.animation.PathTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.util.Duration;

/**
 * This is the Third room of the dungeon with a locked door to the north.
 * The door is unlocked by completing the puzzle in the second room. The solution
 * to the puzzle is in this room
 * @author kjpay
 * @version 1.0
 */
public final class Room3 extends Pane implements Room {
    private CharacterPane character;
    private ObjectPane northWestWall;
    private ObjectPane southWall;
    private ObjectPane eastWall;
    private ObjectPane westDoor;
    private ObjectPane westDoorNorthBlock;
    private ObjectPane westDoorSouthBlock;
    private ObjectPane northDoor;
    private ObjectPane northDoorWestBlock;
    private ObjectPane northDoorEastBlock;
    private Image lock;
    private ImageView viewLock;
    private ObjectPane lockedDoor;
    private Line arrow;
    private PathTransition pt;
    private Image room;
    private ImageView viewRoom;
    private Image floor;
    private ImageView viewFloor;
    private ImageView viewHealth;
    private final Image full = new Image("HealthBars/FullHealthBar.png");
    private Image cursor;
    private ImageView viewCursor;
    
    /**
     * This constructs the third room where the hint to the second room puzzle is.
     */
    public Room3() {
        this.drawWalls();
        this.drawDoors();
        this.drawFloor();
        this.drawArrow();
        this.drawCharacter(225, 720);
        this.drawRoom();
        this.drawLockedDoor();
        this.drawHealth(full);
        this.drawCursor();
    }
    /**
     * This constructs the third room where the hint to the second room puzzle is.
     * @param health Image of health
     */
    public Room3(Image health) {
        this.drawWalls();
        this.drawDoors();
        this.drawFloor();
        this.drawArrow();
        this.drawCharacter(225, 720);
        this.drawRoom();
        this.drawLockedDoor();
        this.drawHealth(health);
        this.drawCursor();
    }
    
    /**
     * This method adds the room Image to the pane
     */
    @Override
    public void drawRoom() {
        room = new Image("RoomsGraphics/Room3TopLayer.png");
        viewRoom = new ImageView(room);
        viewRoom.setX(0);
        viewRoom.setY(0);
        
        this.getChildren().add(viewRoom);
    }
    
    
    /**
     * This method adds the floor to the room
     */
    @Override
    public void drawFloor() {
        floor = new Image("RoomsGraphics/Room3BottomLayer.png");
        viewFloor = new ImageView(floor);
        viewFloor.setX(0);
        viewFloor.setY(0);
        
        this.getChildren().add(viewFloor);
    }
    
    /**
     * This method displays the character's current health
     * @param health Image of character's current health
     */
    @Override
    public void drawHealth(Image health) {
        viewHealth = new ImageView(health);
        viewHealth.setX(400);
        viewHealth.setY(0);
        
        this.getChildren().add(viewHealth);
    }
    
    /**
     * This method replaces the health image to display character's current health
     * @param health Image of character's new health
     */
    @Override
    public void replaceHealth(Image health) {
        viewHealth.setImage(health);
    }
    
    /**
     * This method returns the character's current health image
     * @return Character's current health image
     */
    @Override
    public Image getHealth() {
        return this.viewHealth.getImage();
    }
    
    /**
     * This method adds collision to the walls of the room.
     */
    @Override
    public void drawWalls() {
        northWestWall = new ObjectPane(0, 0, 1520, 600);
        southWall = new ObjectPane(0, 900, 1920, 100);
        eastWall = new ObjectPane(1820, 0, 100, 1000);
        westDoorNorthBlock = new ObjectPane(100, 600, 100, 100);
        westDoorSouthBlock = new ObjectPane(100, 800, 100, 100);
        northDoorWestBlock = new ObjectPane(1520, 100, 100, 100);
        northDoorEastBlock = new ObjectPane(1720, 100, 100, 100);
    }
    
    /**
     * This method allows Room3 to use ObjectPane methods in RunGame
     * @return northWestWall
     */
    public ObjectPane getNorthWestWall() {
        return this.northWestWall;
    }
    /**
     * This method checks if the northWestWall is being collided with at 
     * the bottom
     * @return True if colliding, false if not
     */
    public boolean isCollidingNorthWestWallBottom() {
        return this.character.isCollidingBottom(this.northWestWall.getRectX(), this.northWestWall.getRectY(), + 
                this.northWestWall.getRectWidth(), this.northWestWall.getRectHeight());
    }
    /**
     * This method checks if the northWestWall is being collided with at 
     * the right
     * @return True if colliding, false if not
     */
    public boolean isCollidingNorthWestWallRight() {
        return this.character.isCollidingRight(this.northWestWall.getRectX(), this.northWestWall.getRectY(), + 
                this.northWestWall.getRectWidth(), this.northWestWall.getRectHeight());
    }
    
     /**
     * This method allows Room3 to use ObjectPane methods in RunGame
     * @return southWall
     */
    public ObjectPane getSouthWall() {
        return this.southWall;
    }
    /**
     * This method checks if the southWall is being collided with
     * @return True if colliding, false if not
     */
    public boolean isCollidingSouthWall() {
        return this.character.isCollidingTop(this.southWall.getRectX(), this.southWall.getRectY(), + 
                this.southWall.getRectWidth(), this.southWall.getRectHeight());
    }
    
     /**
     * This method allows Room3 to use ObjectPane methods in RunGame
     * @return eastWall
     */
    public ObjectPane getEastWall() {
        return this.eastWall;
    }
    /**
     * This method checks if the eastWall is being collided with
     * @return True if colliding, false if not
     */
    public boolean isCollidingEastWall() {
        return this.character.isCollidingLeft(this.eastWall.getRectX(), this.eastWall.getRectY(), + 
                this.eastWall.getRectWidth(), this.eastWall.getRectHeight());
    }
    
    /**
     * This method allows Room3 to use ObjectPane methods in RunGame
     * @return westDoorNorthBlock
     */
    public ObjectPane getWestDoorNorthBlock() {
        return this.westDoorNorthBlock;
    }
    /**
     * This method checks if the westDoorNorthBlock is being collided with at 
     * the right
     * @return True if colliding, false if not
     */
    public boolean isCollidingWestDoorNorthBlockRight() {
        return this.character.isCollidingRight(this.westDoorNorthBlock.getRectX(), this.westDoorNorthBlock.getRectY(), + 
                this.westDoorNorthBlock.getRectWidth(), this.westDoorNorthBlock.getRectHeight());
    }
    /**
     * This method checks if the westDoorNorthBlock is being collided with at 
     * the bottom
     * @return True if colliding, false if not
     */
    public boolean isCollidingWestDoorNorthBlockBottom() {
        return this.character.isCollidingBottom(this.westDoorNorthBlock.getRectX(), this.westDoorNorthBlock.getRectY(), + 
                this.westDoorNorthBlock.getRectWidth(), this.westDoorNorthBlock.getRectHeight());
    }
    
    /**
     * This method allows Room3 to use ObjectPane methods in RunGame
     * @return westDoorSouthBlock
     */
    public ObjectPane getWestDoorSouthBlock() {
        return this.westDoorSouthBlock;
    }
    /**
     * This method checks if the westDoorSouthBlock is being collided with at 
     * the left
     * @return True if colliding, false if not
     */
    public boolean isCollidingWestDoorSouthBlockRight() {
        return this.character.isCollidingRight(this.westDoorSouthBlock.getRectX(), this.westDoorSouthBlock.getRectY(), + 
                this.westDoorSouthBlock.getRectWidth(), this.westDoorSouthBlock.getRectHeight());
    }
    /**
     * This method checks if the westDoorSouthBlock is being collided with at 
     * the Top
     * @return True if colliding, false if not
     */
    public boolean isCollidingWestDoorSouthBlockTop() {
        return this.character.isCollidingTop(this.westDoorSouthBlock.getRectX(), this.westDoorSouthBlock.getRectY(), + 
                this.westDoorSouthBlock.getRectWidth(), this.westDoorSouthBlock.getRectHeight());
    }
    
    /**
     * This method allows Room3 to use ObjectPane methods in RunGame
     * @return northDoorWestBlock
     */
    public ObjectPane getNorthDoorWestBlock() {
        return this.northDoorWestBlock;
    }
    /**
     * This method checks if the northDoorWestBlock is being collided with at 
     * the bottom
     * @return True if colliding, false if not
     */
    public boolean isCollidingNorthDoorWestBlockBottom() {
        return this.character.isCollidingBottom(this.northDoorWestBlock.getRectX(), this.northDoorWestBlock.getRectY(), + 
                this.northDoorWestBlock.getRectWidth(), this.northDoorWestBlock.getRectHeight());
    }
    /**
     * This method checks if the northDoorWestBlock is being collided with at 
     * the right
     * @return True if colliding, false if not
     */
    public boolean isCollidingNorthDoorWestBlockRight() {
        return this.character.isCollidingRight(this.northDoorWestBlock.getRectX(), this.northDoorWestBlock.getRectY(), + 
                this.northDoorWestBlock.getRectWidth(), this.northDoorWestBlock.getRectHeight());
    }
    
    /**
     * This method allows Room3 to use ObjectPane methods in RunGame
     * @return northDoorWestBlock
     */
    public ObjectPane getNorthDoorEastBlock() {
        return this.northDoorEastBlock;
    }
    /**
     * This method checks if the northDoorEastBlock is being collided with at 
     * the bottom
     * @return True if colliding, false if not
     */
    public boolean isCollidingNorthDoorEastBlockBottom() {
        return this.character.isCollidingBottom(this.northDoorEastBlock.getRectX(), this.northDoorEastBlock.getRectY(), + 
                this.northDoorEastBlock.getRectWidth(), this.northDoorEastBlock.getRectHeight());
    }
    /**
     * This method checks if the northDoorEastBlock is being collided with at 
     * the left
     * @return True if colliding, false if not
     */
    public boolean isCollidingNorthDoorEastBlockLeft() {
        return this.character.isCollidingLeft(this.northDoorEastBlock.getRectX(), this.northDoorEastBlock.getRectY(), + 
                this.northDoorEastBlock.getRectWidth(), this.northDoorEastBlock.getRectHeight());
    }
    
    /**
     * This method adds the doors to the room. The east door brings the character 
     * back to the BeginningRoom.
     */
    //add doors to room
    @Override
    public final void drawDoors() {
        westDoor = new ObjectPane(100, 700, 40, 100);
        northDoor = new ObjectPane(1620, 100, 100, 40);
    }
    
    /**
     * This method allows Room3 to use ObjectPane methods in RunGame
     * @return westDoor
     */
    public ObjectPane getWestDoor() {
        return this.westDoor;
    }
    /**
     * This method checks if the westDoor is being collided with at 
     * the right
     * @return True if colliding, false if not
     */
    public boolean isCollidingWestDoor() {
        return this.character.isCollidingRight(this.westDoor.getRectX(), this.westDoor.getRectY(), + 
                this.westDoor.getRectWidth(), this.westDoor.getRectHeight());
    }
    
    /**
     * This method allows Room3 to use ObjectPane methods in RunGame
     * @return northDoor
     */
    public ObjectPane getNorthDoor() {
        return this.northDoor;
    }
    /**
     * This method checks if the northDoor is being collided with at 
     * the bottom
     * @return True if colliding, false if not
     */
    public boolean isCollidingNorthDoor() {
        return this.character.isCollidingBottom(this.northDoor.getRectX(), this.northDoor.getRectY(), + 
                this.northDoor.getRectWidth(), this.northDoor.getRectHeight());
    }
    
    /**
     * This method adds a locked door that unlocks when the Room2 puzzle is complete
     */
    public void drawLockedDoor() {
        lock = new Image("RoomsGraphics/LockedDoor.jpg");
        viewLock = new ImageView(lock);
        viewLock.setX(1620);
        viewLock.setY(100);
        
        this.getChildren().add(viewLock);
        
        lockedDoor = new ObjectPane(1620, 100, 100, 100);
    }
    
    /**
     * This method allows Room3 to use ObjectPane methods in RunGame
     * @return westDoor
     */
    public ObjectPane getLockedDoor() {
        return this.lockedDoor;
    }
    /**
     * This method checks if the lockedDoor is being collided with at 
     * the bottom
     * @return True if colliding, false if not
     */
    public boolean isCollidingLockedDoor() {
        return this.character.isCollidingBottom(this.lockedDoor.getRectX(), this.lockedDoor.getRectY(), + 
                this.lockedDoor.getRectWidth(), this.lockedDoor.getRectHeight());
    }
    
    
    public void removeLockedDoor(boolean key) {
        if (key) {
            this.getChildren().remove(viewLock);
            lockedDoor.setRectX(0);
            lockedDoor.setRectY(0);
        }
    }
    
    /**
     * This method adds the character into the room at set coordinates
     * @param x X coordinate for the character
     * @param y Y coordinate for the character
     */
    //add character to room
    @Override
    public final void drawCharacter(double x, double y) {
        character = new CharacterPane(x, y);
        this.getChildren().add(character);
    }
    
    /**
     * This method allows BeginningRoom to use CharacterPane methods in RunGame
     * @return character
     */
    @Override
    public CharacterPane getCharacter() {
        return this.character;
    }
    
    /**
     * This method adds a Line into the pane. This Line is the place holder for 
     * an arrow
     */
    @Override
    public final void drawArrow() {
        arrow = new Line(2000, 0 ,2000 , 40);
        arrow.setStroke(Color.SILVER);
        arrow.setStrokeWidth(4);
        
        this.getChildren().add(arrow);
    }
    
    /**
     * This method allows BeginningRoom to use Line methods for the arrow
     * @return arrow
     */
    public Line getArrow() {
        return this.arrow;
    }
    
    /**
     * This method plays the animation of the arrow being "shot". The path starts 
     * from the center of the character and ends at the cursor.
     * @param path Line from RunGame that arrow follows
     */
    @Override
    public void shootArrow(Line path) {
        arrow.setRotate(character.getDegrees());
        pt = new PathTransition(Duration.millis(500), path, arrow);
        pt.setCycleCount(1);
        pt.play();
    }
    
    /**
     * This method adds the cursor that the character aims with
     */
    @Override
    public void drawCursor() {
        cursor = new Image("RoomsGraphics/CursorWhite.png");
        viewCursor = new ImageView(cursor);
        viewCursor.setX(0);
        viewCursor.setY(0);
        
        this.getChildren().add(viewCursor);
    }
    /**
     * This method sets the X and Y coordinates of the cursor to match the mouse
     * cursor
     * @param x mouse X coordinate
     * @param y mouse Y coordinate
     */
    @Override
    public void setCursor(double x, double y) {
        viewCursor.setX(x);
        viewCursor.setY(y);
        viewCursor.setRotate(this.character.getDegrees());
    }
    /**
     * This method set the rotation of the cursor image
     * @param degrees 
     */
    public void setCursorRotation(double degrees) {
        viewCursor.setRotate(degrees);
    }
}
