/*
 * Author: Kaden Payne
 * Date: 12/3/2020
 * Second Room of the dungeon
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
 * This is the second room of the dungeon with the first puzzle of the dungeon. 
 * The puzzle is three switches that the player as to hit in order to unlock 
 * a door in Room3
 * @author kjpay
 * @version 1.0
 */
public final class Room2 extends Pane implements Room {
    private CharacterPane character;
    private ObjectPane northWall;
    private ObjectPane westWall;
    private ObjectPane southWall;
    private ObjectPane eastWall;
    private ObjectPane eastDoor;
    private ObjectPane eastDoorNorthBlock;
    private ObjectPane eastDoorSouthBlock;
    private ObjectPane message231;
    private ObjectPane messageAim;
    private ObjectPane pit;
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
    private ObjectPane switch1Hitbox;
    private ObjectPane switch2Hitbox;
    private ObjectPane switch3Hitbox;
    private Image cursor;
    private ImageView viewCursor;
    
    /**
     * This constructs the second room with a puzzle of three switches to hit.
     */
    //Constructors
    public Room2() {
        this.drawWalls();
        this.drawDoors();
        this.drawFloor();
        this.drawArrow();
        this.drawCharacter(1690, 470);
        this.drawRoom();
        this.drawHealth(full);
        this.drawSwitchs();
        this.drawCursor();
    }
    /**
     * This constructs the second room with a puzzle of three switches to hit. The characters
     * position can be entered along with health.
     * @param health Image of health
     */
    public Room2(Image health) {
        this.drawWalls();
        this.drawDoors();
        this.drawFloor();
        this.drawArrow();
        this.drawCharacter(1690, 470);
        this.drawRoom();
        this.drawHealth(health);
        this.drawSwitchs();
        this.drawCursor();
    }
    
    /**
     * This method adds an Image of the room to the class
     */
    @Override
    public void drawRoom() {
        room = new Image("RoomsGraphics/Room2TopLayer.png");
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
        floor = new Image("RoomsGraphics/Room2BottomLayer.png");
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
        message231 = new ObjectPane(1110, 100, 500, 200);
        messageAim = new ObjectPane(1110, 700, 500, 200);
        pit = new ObjectPane(0, 0, 880, 1000);
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
     * This method allows Room2 to use ObjectPane methods in RunGame
     * @return message231
     */
    public ObjectPane getMessage231() {
        return this.message231;
    }
    /**
     * This method checks if the message231 is being collided with at 
     * the bottom
     * @return True if colliding, false if not
     */
    public boolean isCollidingMessage231Bottom() {
        return this.character.isCollidingBottom(this.message231.getRectX(), this.message231.getRectY(), + 
                this.message231.getRectWidth(), this.message231.getRectHeight());
    }
    /**
     * This method checks if the message231 is being collided with at 
     * the left
     * @return True if colliding, false if not
     */
    public boolean isCollidingMessage231Left() {
        return this.character.isCollidingLeft(this.message231.getRectX(), this.message231.getRectY(), + 
                this.message231.getRectWidth(), this.message231.getRectHeight());
    }
    /**
     * This method checks if the message231 is being collided with at 
     * the right
     * @return True if colliding, false if not
     */
    public boolean isCollidingMessage231Right() {
        return this.character.isCollidingRight(this.message231.getRectX(), this.message231.getRectY(), + 
                this.message231.getRectWidth(), this.message231.getRectHeight());
    }
    
    /**
     * This method allows Room2 to use ObjectPane methods in RunGame
     * @return messageAim
     */
    public ObjectPane getMessageAim() {
        return this.messageAim;
    }
    /**
     * This method checks if the messageAim is being collided with at 
     * the top
     * @return True if colliding, false if not
     */
    public boolean isCollidingMessageAimTop() {
        return this.character.isCollidingTop(this.messageAim.getRectX(), this.messageAim.getRectY(), + 
                this.messageAim.getRectWidth(), this.messageAim.getRectHeight());
    }
    /**
     * This method checks if the messageAim is being collided with at 
     * the left
     * @return True if colliding, false if not
     */
    public boolean isCollidingMessageAimLeft() {
        return this.character.isCollidingLeft(this.messageAim.getRectX(), this.messageAim.getRectY(), + 
                this.messageAim.getRectWidth(), this.messageAim.getRectHeight());
    }
    /**
     * This method checks if the messageAim is being collided with at 
     * the right
     * @return True if colliding, false if not
     */
    public boolean isCollidingMessageAimRight() {
        return this.character.isCollidingRight(this.messageAim.getRectX(), this.messageAim.getRectY(), + 
                this.messageAim.getRectWidth(), this.messageAim.getRectHeight());
    }
    
    /**
     * This method allow Room2 to use pit in RunGame
     * @return 
     */
    public ObjectPane getPit() {
        return this.pit;
    }
    /**
     * This method checks if the pit is being collided with
     * @return True if colliding, false if not
     */
    public boolean isCollidingPit() {
        return this.character.isCollidingRight(this.pit.getRectX(), this.pit.getRectY(), this.pit.getRectWidth(), this.pit.getRectHeight());
    }
    
    /**
     * This method adds the doors to the room. The east door brings the character 
     * back to the BeginningRoom.
     */
    //add doors to room
    @Override
    public final void drawDoors() {
        eastDoor = new ObjectPane(1780, 450, 40, 100);
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
     * This method adds three switch images for the puzzle
     */
    public void drawSwitchs() {
        switch1 = new Image("RoomsGraphics/SwitchOff.png");
        viewSwitch1 = new ImageView(switch1);
        viewSwitch1.setX(425);
        viewSwitch1.setY(100);
        switch2 = new Image("RoomsGraphics/SwitchOff.png");
        viewSwitch2 = new ImageView(switch2);
        viewSwitch2.setX(100);
        viewSwitch2.setY(450);
        switch3 = new Image("RoomsGraphics/SwitchOff.png");
        viewSwitch3 = new ImageView(switch3);
        viewSwitch3.setX(425);
        viewSwitch3.setY(800);
        
        this.getChildren().addAll(viewSwitch1, viewSwitch2, viewSwitch3);
        
        switch1Hitbox = new ObjectPane(425, 100, 100, 100);
        switch2Hitbox = new ObjectPane(100, 450, 100, 100);
        switch3Hitbox = new ObjectPane(425, 800, 100, 100);
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
     * This method allows Room2 to use switch1Hitbox
     * @return switch1Hitbox
     */
    public ObjectPane getSwitch1Hitbox() {
        return this.switch1Hitbox;
    }
    /**
     * This method allows Room2 to use switch2Hitbox
     * @return switch2Hitbox
     */
    public ObjectPane getSwitch2Hitbox() {
        return this.switch2Hitbox;
    }
    /**
     * This method allows Room2 to use switch3Hitbox
     * @return switch3Hitbox
     */
    public ObjectPane getSwitch3Hitbox() {
        return this.switch3Hitbox;
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