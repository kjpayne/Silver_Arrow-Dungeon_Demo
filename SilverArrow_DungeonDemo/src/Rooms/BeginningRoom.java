/*
 * Author: Kaden Payne
 * Date: 11/20/2020
 * First room of the dungeon
 */
package Rooms;
import Character.CharacterPane;
import Object.ObjectPane;
import java.io.FileNotFoundException;
import javafx.animation.PathTransition;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Line;
import javafx.util.Duration;
/**
 * This is the first room of the dungeon. It's a simple entry room with no puzzles 
 * in it. There are doors to the left and to the right of the room. This is where 
 * the player begins.
 * @author kjpay
 * @version 1.0
 */
public final class BeginningRoom extends Pane implements Room {
    private CharacterPane character;
    private ObjectPane northWall;
    private ObjectPane westWall;
    private ObjectPane southWall;
    private ObjectPane eastWall;
    private ObjectPane westDoor;
    private ObjectPane westDoorNorthBlock;
    private ObjectPane westDoorSouthBlock;
    private ObjectPane eastDoor;
    private ObjectPane eastDoorNorthBlock;
    private ObjectPane eastDoorSouthBlock;
    private ObjectPane pillarA;
    private ObjectPane pillarB;
    private ObjectPane pillarC;
    private ObjectPane pillarD;
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
     * This constructs the first room of the dungeon with an image of the room and 
     * hit boxes for them along with the arrow, character, and the character's 
     * current health.
     * @throws java.io.FileNotFoundException
     */
    //Constructors
    public BeginningRoom() throws FileNotFoundException {
        this.drawWalls();
        this.drawDoors();
        this.drawPillars();
        this.drawFloor();
        this.drawArrow();
        this.drawCharacter(960, 830);
        this.drawRoom();
        this.drawHealth(full);
        this.drawCursor();
    }
    /**
     * This constructs the first room of the dungeon with an image of the room and 
     * hit boxes for them along with the arrow, character, and the character's 
     * current health. Character's position can be entered here along with the health.
     * @param health Current health of the character
     * @throws FileNotFoundException 
     */
    public BeginningRoom(Image health) throws FileNotFoundException {
        this.drawWalls();
        this.drawDoors();
        this.drawPillars();
        this.drawFloor();
        this.drawArrow();
        this.drawCharacter(960, 830);
        this.drawRoom();
        this.drawHealth(health);
        this.drawCursor();
    }
    
    /**
     * This method adds an image of the room and the health bar to the class.
     */
    @Override
    public void drawRoom() {
        room = new Image("RoomsGraphics/BeginningRoomTopLayer.png");
        viewRoom = new ImageView(room);
        viewRoom.setX(0);
        viewRoom.setY(0);
        
        this.getChildren().add(viewRoom);
    }
    
    /**
     * This method adds the floor of the room 
     */
    @Override
    public void drawFloor() {
        floor = new Image("RoomsGraphics/BeginningRoomBottomLayer.png");
        viewFloor = new ImageView(floor);
        viewFloor.setX(0);
        viewFloor.setY(0);
        
        this.getChildren().add(viewFloor);
    }
    
    /**
     * This method adds the characters health into the room.
     * @param health Image of character's current health
     */
    @Override
    public void drawHealth(Image health) {
        //health = new Image("HealthBars/FullHealthBar.png");
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
     * This method adds the walls to the room.
     */
    //add walls to room
    @Override
    public final void drawWalls() {
        northWall = new ObjectPane(0, 0, 1930, 100);
        westWall = new ObjectPane(0, 0, 100, 1000);
        southWall = new ObjectPane(0, 900, 1920, 100);
        eastWall = new ObjectPane(1820, 0, 100, 1000);
        westDoorNorthBlock = new ObjectPane(100, 350, 100, 100);
        westDoorSouthBlock = new ObjectPane(100, 550, 100, 100);
        eastDoorNorthBlock = new ObjectPane(1720, 350, 100, 100);
        eastDoorSouthBlock = new ObjectPane(1720, 550, 100, 100);
    }
    
    /**
     * This method allows BeginningRoom to use ObjectPane methods in RunGame
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
     * This method allows BeginningRoom to use ObjectPane methods in RunGame
     * @return westWall
     */
    public ObjectPane getWestWall() {
        return this.westWall;
    }
    /**
     * This method checks if the westWall is being collided with
     * @return True if colliding, false if not
     */
    public boolean isCollidingWesthWall() {
        return this.character.isCollidingRight(this.westWall.getRectX(), this.westWall.getRectY(), + 
                this.westWall.getRectWidth(), this.westWall.getRectHeight());
    }
    
    /**
     * This method allows BeginningRoom to use ObjectPane methods in RunGame
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
     * This method allows BeginningRoom to use ObjectPane methods in RunGame
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
     * This method allows BeginningRoom to use ObjectPane methods in RunGame
     * @return westDoorNorthBlock
     */
    public ObjectPane getWestDoorNorthBlock() {
        return this.westDoorNorthBlock;
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
     * This method checks if the westDoorNorthBlock is being collided with at 
     * the Top
     * @return True if colliding, false if not
     */
    public boolean isCollidingWestDoorNorthBlockTop() {
        return this.character.isCollidingTop(this.westDoorNorthBlock.getRectX(), this.westDoorNorthBlock.getRectY(), + 
                this.westDoorNorthBlock.getRectWidth(), this.westDoorNorthBlock.getRectHeight());
    }
    /**
     * This method checks if the westDoorNorthBlock is being collided with at 
     * the bottom
     * @return True if colliding, false if not
     */
    public boolean isCollidingWestDoorNorthBlockRight() {
        return this.character.isCollidingRight(this.westDoorNorthBlock.getRectX(), this.westDoorNorthBlock.getRectY(), + 
                this.westDoorNorthBlock.getRectWidth(), this.westDoorNorthBlock.getRectHeight());
    }
    
    /**
     * This method allows BeginningRoom to use ObjectPane methods in RunGame
     * @return westDoorSouthBlock
     */
    public ObjectPane getWestDoorSouthBlock() {
        return this.westDoorSouthBlock;
    }
    /**
     * This method checks if the westDoorSouthBlock is being collided with at 
     * the bottom
     * @return True if colliding, false if not
     */
    public boolean isCollidingWestDoorSouthBlockBottom() {
        return this.character.isCollidingBottom(this.westDoorSouthBlock.getRectX(), this.westDoorSouthBlock.getRectY(), + 
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
     * This method checks if the westDoorSouthBlock is being collided with at 
     * the left
     * @return True if colliding, false if not
     */
    public boolean isCollidingWestDoorSouthBlockRight() {
        return this.character.isCollidingRight(this.westDoorSouthBlock.getRectX(), this.westDoorSouthBlock.getRectY(), + 
                this.westDoorSouthBlock.getRectWidth(), this.westDoorSouthBlock.getRectHeight());
    }
    
    /**
     * This method allows BeginningRoom to use ObjectPane methods in RunGame
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
     * This method allows BeginningRoom to use ObjectPane methods in RunGame
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
     * This method adds the doors to the room. The west door moves the character 
     * to the second room and the east door moves the character to the third room.
     */
    //add doors to room
    @Override
    public final void drawDoors() {
        westDoor = new ObjectPane(100, 450, 40, 100);
        eastDoor = new ObjectPane(1780, 450, 40, 100);
    }
    
    /**
     * This method allows BeginningRoom to use ObjectPane methods in RunGame
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
     * This method allows BeginningRoom to use ObjectPane methods in RunGame
     * @return eastDoor
     */
    public ObjectPane getEastDoor() {
        return this.eastDoor;
    }
    /**
     * This method checks if the eastDoor is being collided with at 
     * the left
     * @return True if colliding, false if not
     */
    public boolean isCollidingEastDoor() {
        return this.character.isCollidingLeft(this.eastDoor.getRectX(), this.eastDoor.getRectY(), + 
                this.eastDoor.getRectWidth(), this.eastDoor.getRectHeight());
    }
    
    /**
     * This method draws pillars for the layout of the room
     */
    public final void drawPillars() {
        pillarA = new ObjectPane(430, 200, 200, 200);
        pillarB = new ObjectPane(430, 600, 200, 200);
        pillarC = new ObjectPane(1290, 200, 200, 200);
        pillarD = new ObjectPane(1290, 600, 200, 200);
    }
    
    /**
     * This method allows BeginningRoom to use ObjectPane methods in RunGame
     * @return pillarA
     */
    public ObjectPane getPillarA() {
        return this.pillarA;
    }
    /**
     * This method checks if the pillarA is being collided with at 
     * the bottom
     * @return True if colliding, false if not
     */
    public boolean isCollidingPillarABottom() {
        return this.character.isCollidingBottom(this.pillarA.getRectX(), this.pillarA.getRectY(), + 
                this.pillarA.getRectWidth(), this.pillarA.getRectHeight());
    }
    /**
     * This method checks if the pillarA is being collided with at 
     * the right
     * @return True if colliding, false if not
     */
    public boolean isCollidingPillarARight() {
        return this.character.isCollidingRight(this.pillarA.getRectX(), this.pillarA.getRectY(), + 
                this.pillarA.getRectWidth(), this.pillarA.getRectHeight());
    }
    /**
     * This method checks if the pillarA is being collided with at 
     * the top
     * @return True if colliding, false if not
     */
    public boolean isCollidingPillarATop() {
        return this.character.isCollidingTop(this.pillarA.getRectX(), this.pillarA.getRectY(), + 
                this.pillarA.getRectWidth(), this.pillarA.getRectHeight());
    }
    /**
     * This method checks if the pillarA is being collided with at 
     * the left
     * @return True if colliding, false if not
     */
    public boolean isCollidingPillarALeft() {
        return this.character.isCollidingLeft(this.pillarA.getRectX(), this.pillarA.getRectY(), + 
                this.pillarA.getRectWidth(), this.pillarA.getRectHeight());
    }
    
    /**
     * This method allows BeginningRoom to use ObjectPane methods in RunGame
     * @return pillarB
     */
    public ObjectPane getPillarB() {
        return this.pillarB;
    }
    /**
     * This method checks if the pillarB is being collided with at 
     * the bottom
     * @return True if colliding, false if not
     */
    public boolean isCollidingPillarBBottom() {
        return this.character.isCollidingBottom(this.pillarB.getRectX(), this.pillarB.getRectY(), + 
                this.pillarB.getRectWidth(), this.pillarB.getRectHeight());
    }
    /**
     * This method checks if the pillarB is being collided with at 
     * the right
     * @return True if colliding, false if not
     */
    public boolean isCollidingPillarBRight() {
        return this.character.isCollidingRight(this.pillarB.getRectX(), this.pillarB.getRectY(), + 
                this.pillarB.getRectWidth(), this.pillarB.getRectHeight());
    }
    /**
     * This method checks if the pillarB is being collided with at 
     * the top
     * @return True if colliding, false if not
     */
    public boolean isCollidingPillarBTop() {
        return this.character.isCollidingTop(this.pillarB.getRectX(), this.pillarB.getRectY(), + 
                this.pillarB.getRectWidth(), this.pillarB.getRectHeight());
    }
    /**
     * This method checks if the pillarB is being collided with at 
     * the left
     * @return True if colliding, false if not
     */
    public boolean isCollidingPillarBLeft() {
        return this.character.isCollidingLeft(this.pillarB.getRectX(), this.pillarB.getRectY(), + 
                this.pillarB.getRectWidth(), this.pillarB.getRectHeight());
    }
    
    /**
     * This method allows BeginningRoom to use ObjectPane methods in RunGame
     * @return pillarC
     */
    public ObjectPane getPillarC() {
        return this.pillarC;
    }
    /**
     * This method checks if the pillarC is being collided with at 
     * the bottom
     * @return True if colliding, false if not
     */
    public boolean isCollidingPillarCBottom() {
        return this.character.isCollidingBottom(this.pillarC.getRectX(), this.pillarC.getRectY(), + 
                this.pillarC.getRectWidth(), this.pillarC.getRectHeight());
    }
    /**
     * This method checks if the pillarC is being collided with at 
     * the right
     * @return True if colliding, false if not
     */
    public boolean isCollidingPillarCRight() {
        return this.character.isCollidingRight(this.pillarC.getRectX(), this.pillarC.getRectY(), + 
                this.pillarC.getRectWidth(), this.pillarC.getRectHeight());
    }
    /**
     * This method checks if the pillarC is being collided with at 
     * the top
     * @return True if colliding, false if not
     */
    public boolean isCollidingPillarCTop() {
        return this.character.isCollidingTop(this.pillarC.getRectX(), this.pillarC.getRectY(), + 
                this.pillarC.getRectWidth(), this.pillarC.getRectHeight());
    }
    /**
     * This method checks if the pillarC is being collided with at 
     * the left
     * @return True if colliding, false if not
     */
    public boolean isCollidingPillarCLeft() {
        return this.character.isCollidingLeft(this.pillarC.getRectX(), this.pillarC.getRectY(), + 
                this.pillarC.getRectWidth(), this.pillarC.getRectHeight());
    }
    
    /**
     * This method allows BeginningRoom to use ObjectPane methods in RunGame
     * @return pillarD;
     */
    public ObjectPane getPillarD() {
        return this.pillarD;
    }
    /**
     * This method checks if the pillarD is being collided with at 
     * the bottom
     * @return True if colliding, false if not
     */
    public boolean isCollidingPillarDBottom() {
        return this.character.isCollidingBottom(this.pillarD.getRectX(), this.pillarD.getRectY(), + 
                this.pillarD.getRectWidth(), this.pillarD.getRectHeight());
    }
    /**
     * This method checks if the pillarD is being collided with at 
     * the right
     * @return True if colliding, false if not
     */
    public boolean isCollidingPillarDRight() {
        return this.character.isCollidingRight(this.pillarD.getRectX(), this.pillarD.getRectY(), + 
                this.pillarD.getRectWidth(), this.pillarD.getRectHeight());
    }
    /**
     * This method checks if the pillarD is being collided with at 
     * the top
     * @return True if colliding, false if not
     */
    public boolean isCollidingPillarDTop() {
        return this.character.isCollidingTop(this.pillarD.getRectX(), this.pillarD.getRectY(), + 
                this.pillarD.getRectWidth(), this.pillarD.getRectHeight());
    }
    /**
     * This method checks if the pillarD is being collided with at 
     * the left
     * @return True if colliding, false if not
     */
    public boolean isCollidingPillarDLeft() {
        return this.character.isCollidingLeft(this.pillarD.getRectX(), this.pillarD.getRectY(), + 
                this.pillarD.getRectWidth(), this.pillarD.getRectHeight());
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
     * This method allows BeginningRoom to use pt in RunGame
     * @return pt
     */
    public PathTransition getPT() {
        return this.pt;
    }
    
    /**
     * This method adds the cursor that the character aims with
     */
    @Override
    public void drawCursor() {
        cursor = new Image("RoomsGraphics/CursorWhite.png");
        viewCursor = new ImageView(cursor);
        viewCursor.setX(930);
        viewCursor.setY(470);
        
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
