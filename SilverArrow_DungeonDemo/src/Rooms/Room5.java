/*
 * Author: Kaden Payne
 * Date: 12/16/2020
 * Fifth room of the dungeon
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
 * This is the fifth room of the dungeon with another switch puzzle where you have 
 * to match the switches to the correct color
 * @author kjpay
 */
public final class Room5 extends Pane implements Room {
    private CharacterPane character;
    private ObjectPane northWall;
    private ObjectPane westWall;
    private ObjectPane southWall;
    private ObjectPane eastWall;
    private ObjectPane eastDoor;
    private ObjectPane eastDoorNorthBlock;
    private ObjectPane eastDoorSouthBlock;
    private ObjectPane northDoor;
    private ObjectPane northDoorWestBlock;
    private ObjectPane northDoorEastBlock;
    private Line arrow;
    private PathTransition pt;
    private Image room;
    private ImageView viewRoom;
    private Image floor;
    private ImageView viewFloor;
    private ImageView viewHealth;
    private final Image full = new Image("HealthBars/FullHealthBar.png");
    private Image switch1;
    private ImageView viewSwitch1;
    private Image switch2;
    private ImageView viewSwitch2;
    private Image switch3;
    private ImageView viewSwitch3;
    private Image switch4;
    private ImageView viewSwitch4;
    private ObjectPane switch1Hitbox;
    private ObjectPane switch2Hitbox;
    private ObjectPane switch3Hitbox;
    private ObjectPane switch4Hitbox;
    private Image cursor;
    private ImageView viewCursor;
    private Image lock;
    private ImageView viewLock;
    private ObjectPane lockedDoor;
    
    /**
     * This constructs the fifth room of the dungeon with other puzzle
     */
    public Room5() {
        this.drawWalls();
        this.drawDoors();
        this.drawFloor();
        this.drawArrow();
        this.drawCharacter(1690, 470);
        this.drawRoom();
        this.drawLockedDoor();
        this.drawHealth(full);
        this.drawSwitchs();
        this.drawCursor();
    }
    /**
     * This constructs the fifth room of the dungeon with other puzzle
     * @param health Image of health
     */
    public Room5(Image health) {
        this.drawWalls();
        this.drawDoors();
        this.drawFloor();
        this.drawArrow();
        this.drawCharacter(1690, 470);
        this.drawRoom();
        this.drawLockedDoor();
        this.drawHealth(health);
        this.drawSwitchs();
        this.drawCursor();
    }
    
    /**
     * This method adds an Image of the room to the class
     */
    @Override
    public void drawRoom() {
        room = new Image("RoomsGraphics/Room5TopLayer.png");
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
        floor = new Image("RoomsGraphics/Room5BottomLayer.png");
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
        northWall = new ObjectPane(0, 0, 1920, 100);
        westWall = new ObjectPane(0, 50, 100, 1000);
        southWall = new ObjectPane(0, 900, 1920, 100);
        eastWall = new ObjectPane(1820, 0, 100, 1000);
        eastDoorNorthBlock = new ObjectPane(1720, 350, 100, 100);
        eastDoorSouthBlock = new ObjectPane(1720, 550, 100, 100);
        northDoorWestBlock = new ObjectPane(810, 100, 100, 100);
        northDoorEastBlock = new ObjectPane(1010, 100, 100, 100);
    }
    
    /**
     * This method allows Room2 to use ObjectPane methods in RunGame
     * @return northWall
     */
    public ObjectPane getNorthWall() {
        return this.northWall;
    }
    /**
     * This method checks if the northWall is being collided with
     * @return True if colliding, false if not
     */
    public boolean isCollidingNorthWall() {
        return this.character.isCollidingBottom(this.northWall.getRectX(), this.northWall.getRectY(), + 
                this.northWall.getRectWidth(), this.northWall.getRectHeight());
    }
    
     /**
     * This method allows Room2 to use ObjectPane methods in RunGame
     * @return westWall
     */
    public ObjectPane getWestWall() {
        return this.westWall;
    }
    /**
     * This method checks if the westWall is being collided with
     * @return True if colliding, false if not
     */
    public boolean isCollidingWestWall() {
        return this.character.isCollidingRight(this.westWall.getRectX(), this.westWall.getRectY(), + 
                this.westWall.getRectWidth(), this.westWall.getRectHeight());
    }
    
     /**
     * This method allows Room2 to use ObjectPane methods in RunGame
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
     * This method allows Room2 to use ObjectPane methods in RunGame
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
     * This method allows Room2 to use ObjectPane methods in RunGame
     * @return eastDoorNorthBlock
     */
    public ObjectPane getEastDoorNorthBlock() {
        return this.eastDoorNorthBlock;
    }
    /**
     * This method checks if the EastDoorNorthBlock is being collided with at 
     * the bottom
     * @return True if colliding, false if not
     */
    public boolean isCollidingEastDoorNorthBlockBottom() {
        return this.character.isCollidingBottom(this.eastDoorNorthBlock.getRectX(), this.eastDoorNorthBlock.getRectY(), + 
                this.eastDoorNorthBlock.getRectWidth(), this.eastDoorNorthBlock.getRectHeight());
    }
    /**
     * This method checks if the eastDoorNorthBlock is being collided with at 
     * the Top
     * @return True if colliding, false if not
     */
    public boolean isCollidingEastDoorNorthBlockTop() {
        return this.character.isCollidingTop(this.eastDoorNorthBlock.getRectX(), this.eastDoorNorthBlock.getRectY(), + 
                this.eastDoorNorthBlock.getRectWidth(), this.eastDoorNorthBlock.getRectHeight());
    }
    /**
     * This method checks if the eastDoorNorthBlock is being collided with at 
     * the bottom
     * @return True if colliding, false if not
     */
    public boolean isCollidingEastDoorNorthBlockLeft() {
        return this.character.isCollidingLeft(this.eastDoorNorthBlock.getRectX(), this.eastDoorNorthBlock.getRectY(), + 
                this.eastDoorNorthBlock.getRectWidth(), this.eastDoorNorthBlock.getRectHeight());
    }
    
    /**
     * This method allows Room2 to use ObjectPane methods in RunGame
     * @return eastDoorSouthBlock
     */
    public ObjectPane getEastDoorSouthBlock() {
        return this.eastDoorSouthBlock;
    }
    /**
     * This method checks if the EastDoorSouthBlock is being collided with at 
     * the bottom
     * @return True if colliding, false if not
     */
    public boolean isCollidingEastDoorSouthBlockBottom() {
        return this.character.isCollidingBottom(this.eastDoorSouthBlock.getRectX(), this.eastDoorSouthBlock.getRectY(), + 
                this.eastDoorSouthBlock.getRectWidth(), this.eastDoorSouthBlock.getRectHeight());
    }
    /**
     * This method checks if the eastDoorSouthBlock is being collided with at 
     * the Top
     * @return True if colliding, false if not
     */
    public boolean isCollidingEastDoorSouthBlockTop() {
        return this.character.isCollidingTop(this.eastDoorSouthBlock.getRectX(), this.eastDoorSouthBlock.getRectY(), + 
                this.eastDoorSouthBlock.getRectWidth(), this.eastDoorSouthBlock.getRectHeight());
    }
    /**
     * This method checks if the eastDoorSouthBlock is being collided with at 
     * the bottom
     * @return True if colliding, false if not
     */
    public boolean isCollidingEastDoorSouthBlockLeft() {
        return this.character.isCollidingLeft(this.eastDoorSouthBlock.getRectX(), this.eastDoorSouthBlock.getRectY(), + 
                this.eastDoorSouthBlock.getRectWidth(), this.eastDoorSouthBlock.getRectHeight());
    }
    
    /**
     * This method returns the northDoorWestBlock object
     * @return northDoorWestWall
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
     * This method checks if the northDoorWestBlock is being collided with at 
     * the left
     * @return True if colliding, false if not
     */
    public boolean isCollidingNorthDoorWestBlockLeft() {
        return this.character.isCollidingLeft(this.northDoorWestBlock.getRectX(), this.northDoorWestBlock.getRectY(), + 
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
     * This method checks if the northDoorEastBlock is being collided with at 
     * the right
     * @return True if colliding, false if not
     */
    public boolean isCollidingNorthDoorEastBlockRight() {
        return this.character.isCollidingRight(this.northDoorEastBlock.getRectX(), this.northDoorEastBlock.getRectY(), + 
                this.northDoorEastBlock.getRectWidth(), this.northDoorEastBlock.getRectHeight());
    }
    
    /**
     * This method adds the doors to the room. The east door brings the character 
     * back to the BeginningRoom.
     */
    //add doors to room
    @Override
    public final void drawDoors() {
        eastDoor = new ObjectPane(1780, 450, 40, 100);
        northDoor = new ObjectPane(910, 100, 100, 40);
    }
    
    /**
     * This method allows Room2 to use ObjectPane methods in RunGame
     * @return eastDoor
     */
    public ObjectPane getEastDoor() {
        return this.eastDoor;
    }
    /**
     * This method checks if the eastDoor is being collided with
     * @return True if colliding, false if not
     */
    public boolean isCollidingEastDoor() {
        return this.character.isCollidingLeft(this.eastDoor.getRectX(), this.eastDoor.getRectY(), + 
                this.eastDoor.getRectWidth(), this.eastDoor.getRectHeight());
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
    
    /**
     * This method adds three switch images for the puzzle
     */
    public void drawSwitchs() {
        switch1 = new Image("RoomsGraphics/SwitchOff.png");
        viewSwitch1 = new ImageView(switch1);
        viewSwitch1.setX(480);
        viewSwitch1.setY(250);
        switch2 = new Image("RoomsGraphics/SwitchOn.png");
        viewSwitch2 = new ImageView(switch2);
        viewSwitch2.setX(480);
        viewSwitch2.setY(650);
        switch3 = new Image("RoomsGraphics/Yellow.png");
        viewSwitch3 = new ImageView(switch3);
        viewSwitch3.setX(1340);
        viewSwitch3.setY(250);
        switch4 = new Image("RoomsGraphics/Blue.png");
        viewSwitch4 = new ImageView(switch4);
        viewSwitch4.setX(1340);
        viewSwitch4.setY(650);
        
        this.getChildren().addAll(viewSwitch1, viewSwitch2, viewSwitch3, viewSwitch4);
        
        switch1Hitbox = new ObjectPane(480, 250, 100, 100);
        switch2Hitbox = new ObjectPane(480, 650, 100, 100);
        switch3Hitbox = new ObjectPane(1340, 250, 100, 100);
        switch4Hitbox = new ObjectPane(1340, 650, 100, 100);
    }
    
    /**
     * This method swaps the off switch to the on switch
     * @param swapSwitch Image of on switch
     */
    public void replaceSwitch1(Image swapSwitch) {
        viewSwitch1.setImage(swapSwitch);
    }
    /**
     * This method swaps the off switch to the on switch
     * @param swapSwitch Image of on switch
     */
    public void replaceSwitch2(Image swapSwitch) {
        viewSwitch2.setImage(swapSwitch);
    }
    /**
     * This method swaps the off switch to the on switch
     * @param swapSwitch Image of on switch
     */
    public void replaceSwitch3(Image swapSwitch) {
        viewSwitch3.setImage(swapSwitch);
    }
    /**
     * This method swaps the off switch to the on switch
     * @param swapSwitch Image of on switch
     */
    public void replaceSwitch4(Image swapSwitch) {
        viewSwitch4.setImage(swapSwitch);
    }
    
    /**
     * This method returns the viewSwitch1 Image
     * @return Image of viewSwitch1
     */
    public Image getSwitch1() {
        return this.viewSwitch1.getImage();
    }
    /**
     * This method returns the viewSwitch2 Image
     * @return Image of viewSwitch2
     */
    public Image getSwitch2() {
        return this.viewSwitch2.getImage();
    }
    /**
     * This method returns the viewSwitch3 Image
     * @return Image of viewSwitch3
     */
    public Image getSwitch3() {
        return this.viewSwitch3.getImage();
    }
    /**
     * This method returns the viewSwitch4 Image
     * @return Image of viewSwitch4
     */
    public Image getSwitch4() {
        return this.viewSwitch4.getImage();
    }
    
    /**
     * This method allows Room2 to use switch1Hitbox
     * @return switch1Hitbox
     */
    public ObjectPane getSwitch1Hitbox() {
        return this.switch1Hitbox;
    }
    /**
     * This method checks if switch1 is being collided with at the bottom
     * @return True if colliding, false if not
     */
    public boolean isCollidingSwitch1Bottom() {
        return this.character.isCollidingBottom(this.switch1Hitbox.getRectX(), this.switch1Hitbox.getRectY(), + 
                this.switch1Hitbox.getRectWidth(), this.switch1Hitbox.getRectHeight());
    }
    /**
     * This method checks if switch1 is being collided with at the left
     * @return True if colliding, false if not
     */
    public boolean isCollidingSwitch1Left() {
        return this.character.isCollidingLeft(this.switch1Hitbox.getRectX(), this.switch1Hitbox.getRectY(), + 
                this.switch1Hitbox.getRectWidth(), this.switch1Hitbox.getRectHeight());
    }
    /**
     * This method checks if switch1 is being collided with at the top
     * @return True if colliding, false if not
     */
    public boolean isCollidingSwitch1Top() {
        return this.character.isCollidingTop(this.switch1Hitbox.getRectX(), this.switch1Hitbox.getRectY(), + 
                this.switch1Hitbox.getRectWidth(), this.switch1Hitbox.getRectHeight());
    }
    /**
     * This method checks if switch1 is being collided with at the right
     * @return True if colliding, false if not
     */
    public boolean isCollidingSwitch1Right() {
        return this.character.isCollidingRight(this.switch1Hitbox.getRectX(), this.switch1Hitbox.getRectY(), + 
                this.switch1Hitbox.getRectWidth(), this.switch1Hitbox.getRectHeight());
    }
    
    /**
     * This method allows Room2 to use switch2Hitbox
     * @return switch2Hitbox
     */
    public ObjectPane getSwitch2Hitbox() {
        return this.switch2Hitbox;
    }
    /**
     * This method checks if switch2 is being collided with at the bottom
     * @return True if colliding, false if not
     */
    public boolean isCollidingSwitch2Bottom() {
        return this.character.isCollidingBottom(this.switch2Hitbox.getRectX(), this.switch2Hitbox.getRectY(), + 
                this.switch2Hitbox.getRectWidth(), this.switch2Hitbox.getRectHeight());
    }
    /**
     * This method checks if switch2 is being collided with at the left
     * @return True if colliding, false if not
     */
    public boolean isCollidingSwitch2Left() {
        return this.character.isCollidingLeft(this.switch2Hitbox.getRectX(), this.switch2Hitbox.getRectY(), + 
                this.switch2Hitbox.getRectWidth(), this.switch2Hitbox.getRectHeight());
    }
    /**
     * This method checks if switch2 is being collided with at the top
     * @return True if colliding, false if not
     */
    public boolean isCollidingSwitch2Top() {
        return this.character.isCollidingTop(this.switch2Hitbox.getRectX(), this.switch2Hitbox.getRectY(), + 
                this.switch2Hitbox.getRectWidth(), this.switch2Hitbox.getRectHeight());
    }
    /**
     * This method checks if switch2 is being collided with at the right
     * @return True if colliding, false if not
     */
    public boolean isCollidingSwitch2Right() {
        return this.character.isCollidingRight(this.switch2Hitbox.getRectX(), this.switch2Hitbox.getRectY(), + 
                this.switch2Hitbox.getRectWidth(), this.switch2Hitbox.getRectHeight());
    }
    
    /**
     * This method allows Room2 to use switch3Hitbox
     * @return switch3Hitbox
     */
    public ObjectPane getSwitch3Hitbox() {
        return this.switch3Hitbox;
    }
    /**
     * This method checks if switch3 is being collided with at the bottom
     * @return True if colliding, false if not
     */
    public boolean isCollidingSwitch3Bottom() {
        return this.character.isCollidingBottom(this.switch3Hitbox.getRectX(), this.switch3Hitbox.getRectY(), + 
                this.switch3Hitbox.getRectWidth(), this.switch3Hitbox.getRectHeight());
    }
    /**
     * This method checks if switch3 is being collided with at the left
     * @return True if colliding, false if not
     */
    public boolean isCollidingSwitch3Left() {
        return this.character.isCollidingLeft(this.switch3Hitbox.getRectX(), this.switch3Hitbox.getRectY(), + 
                this.switch3Hitbox.getRectWidth(), this.switch3Hitbox.getRectHeight());
    }
    /**
     * This method checks if switch3 is being collided with at the top
     * @return True if colliding, false if not
     */
    public boolean isCollidingSwitch3Top() {
        return this.character.isCollidingTop(this.switch3Hitbox.getRectX(), this.switch3Hitbox.getRectY(), + 
                this.switch3Hitbox.getRectWidth(), this.switch3Hitbox.getRectHeight());
    }
    /**
     * This method checks if switch3 is being collided with at the right
     * @return True if colliding, false if not
     */
    public boolean isCollidingSwitch3Right() {
        return this.character.isCollidingRight(this.switch3Hitbox.getRectX(), this.switch3Hitbox.getRectY(), + 
                this.switch3Hitbox.getRectWidth(), this.switch3Hitbox.getRectHeight());
    }
    
    /**
     * This method allows Room2 to use switch4Hitbox
     * @return switch4Hitbox
     */
    public ObjectPane getSwitch4Hitbox() {
        return this.switch4Hitbox;
    }
    /**
     * This method checks if switch4 is being collided with at the bottom
     * @return True if colliding, false if not
     */
    public boolean isCollidingSwitch4Bottom() {
        return this.character.isCollidingBottom(this.switch4Hitbox.getRectX(), this.switch4Hitbox.getRectY(), + 
                this.switch4Hitbox.getRectWidth(), this.switch4Hitbox.getRectHeight());
    }
    /**
     * This method checks if switch4 is being collided with at the left
     * @return True if colliding, false if not
     */
    public boolean isCollidingSwitch4Left() {
        return this.character.isCollidingLeft(this.switch4Hitbox.getRectX(), this.switch4Hitbox.getRectY(), + 
                this.switch4Hitbox.getRectWidth(), this.switch4Hitbox.getRectHeight());
    }
    /**
     * This method checks if switch4 is being collided with at the top
     * @return True if colliding, false if not
     */
    public boolean isCollidingSwitch4Top() {
        return this.character.isCollidingTop(this.switch4Hitbox.getRectX(), this.switch4Hitbox.getRectY(), + 
                this.switch4Hitbox.getRectWidth(), this.switch4Hitbox.getRectHeight());
    }
    /**
     * This method checks if switch4 is being collided with at the right
     * @return True if colliding, false if not
     */
    public boolean isCollidingSwitch4Right() {
        return this.character.isCollidingRight(this.switch4Hitbox.getRectX(), this.switch4Hitbox.getRectY(), + 
                this.switch4Hitbox.getRectWidth(), this.switch4Hitbox.getRectHeight());
    }
    
    /**
     * This method adds a locked door that unlocks when the Room2 puzzle is complete
     */
    public void drawLockedDoor() {
        lock = new Image("RoomsGraphics/LockedDoorBlue.jpg");
        viewLock = new ImageView(lock);
        viewLock.setX(910);
        viewLock.setY(100);
        
        this.getChildren().add(viewLock);
        
        lockedDoor = new ObjectPane(910, 100, 100, 100);
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
}
