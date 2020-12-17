/*
 * Author: Kaden Payne
 * Date: 12/10/2020
 * Fourth Room of the dungeon
 */
package Rooms;

import Character.CharacterPane;
import Object.ObjectPane;
import static java.lang.Math.sqrt;
import javafx.animation.KeyFrame;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.util.Duration;

/**
 * This is the fourth room of the dungeon with saw blades as a hazard. When the 
 * character moves in front of a saw blade, the saw blade moves down or up towards 
 * the character. The character takes damage if hit.
 * @author kjpay
 * @version 1.0
 */
public final class Room4 extends Pane implements Room {
    private CharacterPane character;
    private final double characterXSouth = 1670;
    private final double characterYSouth = 740;
    private final double characterXWest = 200;
    private final double characterYWest = 470;
    private ObjectPane northWall;
    private ObjectPane westWallNorth;
    private ObjectPane westWallSouth;
    private ObjectPane southWall;
    private ObjectPane eastWall;
    private ObjectPane westDoor;
    private ObjectPane southDoor;
    private ObjectPane southDoorWestBlock;
    private ObjectPane southDoorEastBlock;
    private ObjectPane sawBladeSouthBlockA;
    private ObjectPane sawBladeSouthBlockB;
    private ObjectPane sawBladeSouthBlockC;
    private ObjectPane sawBladeSouthBlockD;
    private ObjectPane sawBladeSouthBlockE;
    private ObjectPane sawBladeNorthBlockA;
    private ObjectPane sawBladeNorthBlockB;
    private ObjectPane sawBladeNorthBlockC;
    private ObjectPane sawBladeNorthBlockD;
    private ObjectPane sawBladeNorthBlockE;
    private Line arrow;
    private PathTransition pt;
    private Image room;
    private ImageView viewRoom;
    private Image floor;
    private ImageView viewFloor;
    private final Image full = new Image("HealthBars/FullHealthBar.png");
    private ImageView viewHealth;
    private Image sawBladeA;
    private ImageView viewSawBladeA;
    private Image sawBladeB;
    private ImageView viewSawBladeB;
    private Image sawBladeC;
    private ImageView viewSawBladeC;
    private Image sawBladeD;
    private ImageView viewSawBladeD;
    private Circle sawBladeAHitbox;
    private Circle sawBladeBHitbox;
    private Circle sawBladeCHitbox;
    private Circle sawBladeDHitbox;
    private Timeline moveSawBladeA;
    private Timeline moveSawBladeB;
    private Timeline moveSawBladeC;
    private Timeline moveSawBladeD;
    private final double speed = 15;
    private boolean southA;
    private boolean southB;
    private boolean southC;
    private boolean southD;
    private Image cursor;
    private ImageView viewCursor;
    
    /**
     * This constructs the fourth room of the dungeon with saw blades
     */
    public Room4() {
        this.drawWalls();
        this.drawDoors();
        this.drawFloor();
        this.drawSawBlades();
        this.drawArrow();
        this.drawCharacter(characterXSouth, characterYSouth);
        this.drawRoom();
        this.drawHealth(full);
        this.movingSawBladeA();
        this.movingSawBladeB();
        this.movingSawBladeC();
        this.movingSawBladeD();
        this.drawCursor();
    }
    /**
     * This constructs the fourth room of the dungeon with saw blades
     * @param health Image of health
     */
    public Room4(Image health) {
        this.drawWalls();
        this.drawDoors();
        this.drawFloor();
        this.drawSawBlades();
        this.drawArrow();
        this.drawCharacter(characterXSouth, characterYSouth);
        this.drawRoom();
        this.drawHealth(health);
        this.movingSawBladeA();
        this.movingSawBladeB();
        this.movingSawBladeC();
        this.movingSawBladeD();
        this.drawCursor();
    }
    
    /**
     * This method adds the room Image to the pane
     */
    @Override
    public void drawRoom() {
        room = new Image("RoomsGraphics/Room4TopLayer.png");
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
        floor = new Image("RoomsGraphics/Room4BottomLayer.png");
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
     * This method adds the walls to the room.
     */
    //add walls to room
    @Override
    public final void drawWalls() {
        northWall = new ObjectPane(0, 0, 1920, 100);
        westWallNorth = new ObjectPane(100, 200, 100, 250);
        westWallSouth = new ObjectPane(100, 550, 100, 250);
        southWall = new ObjectPane(0, 900, 1920, 100);
        eastWall = new ObjectPane(1820, 0, 100, 1000);
        southDoorWestBlock = new ObjectPane(1520, 700, 100, 200);
        southDoorEastBlock = new ObjectPane(1720, 700, 100, 200);
        sawBladeSouthBlockA = new ObjectPane(1420, 800, 100, 100);
        sawBladeSouthBlockB = new ObjectPane(1120, 800, 200, 100);
        sawBladeSouthBlockC = new ObjectPane(820, 800, 200, 100);
        sawBladeSouthBlockD = new ObjectPane(520, 800, 200, 100);
        sawBladeSouthBlockE = new ObjectPane(200, 800, 220, 100);
        sawBladeNorthBlockA = new ObjectPane(1420, 100, 400, 100);
        sawBladeNorthBlockB = new ObjectPane(1120, 100, 200, 100);
        sawBladeNorthBlockC = new ObjectPane(820, 100, 200, 100);
        sawBladeNorthBlockD = new ObjectPane(520, 100, 200, 100);
        sawBladeNorthBlockE = new ObjectPane(200, 100, 220, 100);
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
     * @return westWallNorth
     */
    public ObjectPane getWestWallNorth() {
        return this.westWallNorth;
    }
    /**
     * This method checks if the westWallNorth is being collided with
     * @return True if colliding, false if not
     */
    public boolean isCollidingWestWallNorth() {
        return this.character.isCollidingRight(this.westWallNorth.getRectX(), this.westWallNorth.getRectY(), + 
                this.westWallNorth.getRectWidth(), this.westWallNorth.getRectHeight());
    }
    /**
     * This method checks if the westWallNorth is being collided with at 
     * the bottom
     * @return True if colliding, false if not
     */
    public boolean isCollidingWestWallNorthBottom() {
        return this.character.isCollidingBottom(this.westWallNorth.getRectX(), this.westWallNorth.getRectY(), + 
                this.westWallNorth.getRectWidth(), this.westWallNorth.getRectHeight());
    }
    
    /**
     * This method allows BeginningRoom to use ObjectPane methods in RunGame
     * @return westWallNorth
     */
    public ObjectPane getWestWallSouth() {
        return this.westWallSouth;
    }
    /**
     * This method checks if the westWallSouth is being collided with
     * @return True if colliding, false if not
     */
    public boolean isCollidingWestWallSouth() {
        return this.character.isCollidingRight(this.westWallSouth.getRectX(), this.westWallSouth.getRectY(), + 
                this.westWallSouth.getRectWidth(), this.westWallSouth.getRectHeight());
    }
    /**
     * This method checks if the westWallSouth is being collided with at 
     * the top
     * @return True if colliding, false if not
     */
    public boolean isCollidingWestWallSouthTop() {
        return this.character.isCollidingTop(this.westWallSouth.getRectX(), this.westWallSouth.getRectY(), + 
                this.westWallSouth.getRectWidth(), this.westWallSouth.getRectHeight());
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
     * This method allows Room3 to use ObjectPane methods in RunGame
     * @return southDoorWestBlock
     */
    public ObjectPane getSouthDoorWestBlock() {
        return this.southDoorWestBlock;
    }
    /**
     * This method checks if the southDoorWestBlock is being collided with at 
     * the top
     * @return True if colliding, false if not
     */
    public boolean isCollidingSouthDoorWestBlockTop() {
        return this.character.isCollidingTop(this.southDoorWestBlock.getRectX(), this.southDoorWestBlock.getRectY(), + 
                this.southDoorWestBlock.getRectWidth(), this.southDoorWestBlock.getRectHeight());
    }
    /**
     * This method checks if the southDoorWestBlock is being collided with at 
     * the right
     * @return True if colliding, false if not
     */
    public boolean isCollidingSouthDoorWestBlockRight() {
        return this.character.isCollidingRight(this.southDoorWestBlock.getRectX(), this.southDoorWestBlock.getRectY(), + 
                this.southDoorWestBlock.getRectWidth(), this.southDoorWestBlock.getRectHeight());
    }
    /**
     * This method checks if the southDoorWestBlock is being collided with at 
     * the left
     * @return True if colliding, false if not
     */
    public boolean isCollidingSouthDoorWestBlockLeft() {
        return this.character.isCollidingLeft(this.southDoorWestBlock.getRectX(), this.southDoorWestBlock.getRectY(), + 
                this.southDoorWestBlock.getRectWidth(), this.southDoorWestBlock.getRectHeight());
    }
    
    /**
     * This method allows Room3 to use ObjectPane methods in RunGame
     * @return southDoorWestBlock
     */
    public ObjectPane getSouthDoorEastBlock() {
        return this.southDoorEastBlock;
    }
    /**
     * This method checks if the southDoorEastBlock is being collided with at 
     * the top
     * @return True if colliding, false if not
     */
    public boolean isCollidingSouthDoorEastBlockTop() {
        return this.character.isCollidingTop(this.southDoorEastBlock.getRectX(), this.southDoorEastBlock.getRectY(), + 
                this.southDoorEastBlock.getRectWidth(), this.southDoorEastBlock.getRectHeight());
    }
    /**
     * This method checks if the southDoorEastBlock is being collided with at 
     * the left
     * @return True if colliding, false if not
     */
    public boolean isCollidingSouthDoorEastBlockLeft() {
        return this.character.isCollidingLeft(this.southDoorEastBlock.getRectX(), this.southDoorEastBlock.getRectY(), + 
                this.southDoorEastBlock.getRectWidth(), this.southDoorEastBlock.getRectHeight());
    }
    
    /**
     * This method allows Room4 to use ObjectPane methods in RunGame
     * @return sawBladeSouthBlockA
     */
    public ObjectPane getSawBladeSouthBlockA() {
        return this.sawBladeSouthBlockA;
    }
    /**
     * This method checks if the sawBladeSouthBlockA is being collided with at 
     * the top
     * @return True if colliding, false if not 
     */
    public boolean isCollidingSawBladeSouthBlockATop() {
        return this.character.isCollidingTop(this.sawBladeSouthBlockA.getRectX(), this.sawBladeSouthBlockA.getRectY(), + 
                this.sawBladeSouthBlockA.getRectWidth(), this.sawBladeSouthBlockA.getRectHeight());
    }
    /**
     * This method checks if the sawBladeSouthBlockA is being collided with at 
     * the left
     * @return True if colliding, false if not 
     */
    public boolean isCollidingSawBladeSouthBlockALeft() {
        return this.character.isCollidingLeft(this.sawBladeSouthBlockA.getRectX(), this.sawBladeSouthBlockA.getRectY(), + 
                this.sawBladeSouthBlockA.getRectWidth(), this.sawBladeSouthBlockA.getRectHeight());
    }
    
    /**
     * This method allows Room4 to use ObjectPane methods in RunGame
     * @return sawBladeSouthBlockB
     */
    public ObjectPane getSawBladeSouthBlockB() {
        return this.sawBladeSouthBlockB;
    }
    /**
     * This method checks if the sawBladeSouthBlockB is being collided with at 
     * the top
     * @return True if colliding, false if not 
     */
    public boolean isCollidingSawBladeSouthBlockBTop() {
        return this.character.isCollidingTop(this.sawBladeSouthBlockB.getRectX(), this.sawBladeSouthBlockB.getRectY(), + 
                this.sawBladeSouthBlockB.getRectWidth(), this.sawBladeSouthBlockB.getRectHeight());
    }
    /**
     * This method checks if the sawBladeSouthBlockB is being collided with at 
     * the left
     * @return True if colliding, false if not 
     */
    public boolean isCollidingSawBladeSouthBlockBLeft() {
        return this.character.isCollidingLeft(this.sawBladeSouthBlockB.getRectX(), this.sawBladeSouthBlockB.getRectY(), + 
                this.sawBladeSouthBlockB.getRectWidth(), this.sawBladeSouthBlockB.getRectHeight());
    }
    /**
     * This method checks if the sawBladeSouthBlockB is being collided with at 
     * the right
     * @return True if colliding, false if not 
     */
    public boolean isCollidingSawBladeSouthBlockBRight() {
        return this.character.isCollidingRight(this.sawBladeSouthBlockB.getRectX(), this.sawBladeSouthBlockB.getRectY(), + 
                this.sawBladeSouthBlockB.getRectWidth(), this.sawBladeSouthBlockB.getRectHeight());
    }
    
    /**
     * This method allows Room4 to use ObjectPane methods in RunGame
     * @return sawBladeSouthBlockC
     */
    public ObjectPane getSawBladeSouthBlockC() {
        return this.sawBladeSouthBlockC;
    }
    /**
     * This method checks if the sawBladeSouthBlockC is being collided with at 
     * the top
     * @return True if colliding, false if not 
     */
    public boolean isCollidingSawBladeSouthBlockCTop() {
        return this.character.isCollidingTop(this.sawBladeSouthBlockC.getRectX(), this.sawBladeSouthBlockC.getRectY(), + 
                this.sawBladeSouthBlockC.getRectWidth(), this.sawBladeSouthBlockC.getRectHeight());
    }
    /**
     * This method checks if the sawBladeSouthBlockC is being collided with at 
     * the left
     * @return True if colliding, false if not 
     */
    public boolean isCollidingSawBladeSouthBlockCLeft() {
        return this.character.isCollidingLeft(this.sawBladeSouthBlockC.getRectX(), this.sawBladeSouthBlockC.getRectY(), + 
                this.sawBladeSouthBlockC.getRectWidth(), this.sawBladeSouthBlockC.getRectHeight());
    }
    /**
     * This method checks if the sawBladeSouthBlockC is being collided with at 
     * the right
     * @return True if colliding, false if not 
     */
    public boolean isCollidingSawBladeSouthBlockCRight() {
        return this.character.isCollidingRight(this.sawBladeSouthBlockC.getRectX(), this.sawBladeSouthBlockC.getRectY(), + 
                this.sawBladeSouthBlockC.getRectWidth(), this.sawBladeSouthBlockC.getRectHeight());
    }
    
    /**
     * This method allows Room4 to use ObjectPane methods in RunGame
     * @return sawBladeSouthBlockD
     */
    public ObjectPane getSawBladeSouthBlockD() {
        return this.sawBladeSouthBlockD;
    }
    /**
     * This method checks if the sawBladeSouthBlockD is being collided with at 
     * the top
     * @return True if colliding, false if not 
     */
    public boolean isCollidingSawBladeSouthBlockDTop() {
        return this.character.isCollidingTop(this.sawBladeSouthBlockD.getRectX(), this.sawBladeSouthBlockD.getRectY(), + 
                this.sawBladeSouthBlockD.getRectWidth(), this.sawBladeSouthBlockD.getRectHeight());
    }
    /**
     * This method checks if the sawBladeSouthBlockD is being collided with at 
     * the left
     * @return True if colliding, false if not 
     */
    public boolean isCollidingSawBladeSouthBlockDLeft() {
        return this.character.isCollidingLeft(this.sawBladeSouthBlockD.getRectX(), this.sawBladeSouthBlockD.getRectY(), + 
                this.sawBladeSouthBlockD.getRectWidth(), this.sawBladeSouthBlockD.getRectHeight());
    }
    /**
     * This method checks if the sawBladeSouthBlockD is being collided with at 
     * the right
     * @return True if colliding, false if not 
     */
    public boolean isCollidingSawBladeSouthBlockDRight() {
        return this.character.isCollidingRight(this.sawBladeSouthBlockD.getRectX(), this.sawBladeSouthBlockD.getRectY(), + 
                this.sawBladeSouthBlockD.getRectWidth(), this.sawBladeSouthBlockD.getRectHeight());
    }
    
    /**
     * This method allows Room4 to use ObjectPane methods in RunGame
     * @return sawBladeSouthBlockE
     */
    public ObjectPane getSawBladeSouthBlockE() {
        return this.sawBladeSouthBlockE;
    }
    /**
     * This method checks if the sawBladeSouthBlockE is being collided with at 
     * the top
     * @return True if colliding, false if not 
     */
    public boolean isCollidingSawBladeSouthBlockETop() {
        return this.character.isCollidingTop(this.sawBladeSouthBlockE.getRectX(), this.sawBladeSouthBlockE.getRectY(), + 
                this.sawBladeSouthBlockE.getRectWidth(), this.sawBladeSouthBlockE.getRectHeight());
    }
    /**
     * This method checks if the sawBladeSouthBlockE is being collided with at 
     * the right
     * @return True if colliding, false if not 
     */
    public boolean isCollidingSawBladeSouthBlockERight() {
        return this.character.isCollidingRight(this.sawBladeSouthBlockE.getRectX(), this.sawBladeSouthBlockE.getRectY(), + 
                this.sawBladeSouthBlockE.getRectWidth(), this.sawBladeSouthBlockE.getRectHeight());
    }
    
    /**
     * This method allows Room4 to use ObjectPane methods in RunGame
     * @return sawBladeNorthBlockA
     */
    public ObjectPane getSawBladeNorthBlockA() {
        return this.sawBladeNorthBlockA;
    }
    /**
     * This method checks if the sawBladeNorthBlockA is being collided with at 
     * the bottom
     * @return True if colliding, false if not 
     */
    public boolean isCollidingSawBladeNorthBlockABottom() {
        return this.character.isCollidingBottom(this.sawBladeNorthBlockA.getRectX(), this.sawBladeNorthBlockA.getRectY(), + 
                this.sawBladeNorthBlockA.getRectWidth(), this.sawBladeNorthBlockA.getRectHeight());
    }
    /**
     * This method checks if the sawBladeNorthBlockA is being collided with at 
     * the left
     * @return True if colliding, false if not 
     */
    public boolean isCollidingSawBladeNorthBlockALeft() {
        return this.character.isCollidingLeft(this.sawBladeNorthBlockA.getRectX(), this.sawBladeNorthBlockA.getRectY(), + 
                this.sawBladeNorthBlockA.getRectWidth(), this.sawBladeNorthBlockA.getRectHeight());
    }
    
    /**
     * This method allows Room4 to use ObjectPane methods in RunGame
     * @return sawBladeNorthBlockB
     */
    public ObjectPane getSawBladeNorthBlockB() {
        return this.sawBladeNorthBlockB;
    }
    /**
     * This method checks if the sawBladeNorthBlockB is being collided with at 
     * the bottom
     * @return True if colliding, false if not 
     */
    public boolean isCollidingSawBladeNorthBlockBBottom() {
        return this.character.isCollidingBottom(this.sawBladeNorthBlockB.getRectX(), this.sawBladeNorthBlockB.getRectY(), + 
                this.sawBladeNorthBlockB.getRectWidth(), this.sawBladeNorthBlockB.getRectHeight());
    }
    /**
     * This method checks if the sawBladeNorthBlockB is being collided with at 
     * the left
     * @return True if colliding, false if not 
     */
    public boolean isCollidingSawBladeNorthBlockBLeft() {
        return this.character.isCollidingLeft(this.sawBladeNorthBlockB.getRectX(), this.sawBladeNorthBlockB.getRectY(), + 
                this.sawBladeNorthBlockB.getRectWidth(), this.sawBladeNorthBlockB.getRectHeight());
    }
    /**
     * This method checks if the sawBladeNorthBlockB is being collided with at 
     * the right
     * @return True if colliding, false if not 
     */
    public boolean isCollidingSawBladeNorthBlockBRight() {
        return this.character.isCollidingRight(this.sawBladeNorthBlockB.getRectX(), this.sawBladeNorthBlockB.getRectY(), + 
                this.sawBladeNorthBlockB.getRectWidth(), this.sawBladeNorthBlockB.getRectHeight());
    }
    
    /**
     * This method allows Room4 to use ObjectPane methods in RunGame
     * @return sawBladeNorthBlockC
     */
    public ObjectPane getSawBladeNorthBlockC() {
        return this.sawBladeNorthBlockC;
    }
    /**
     * This method checks if the sawBladeNorthBlockC is being collided with at 
     * the bottom
     * @return True if colliding, false if not 
     */
    public boolean isCollidingSawBladeNorthBlockCBottom() {
        return this.character.isCollidingBottom(this.sawBladeNorthBlockC.getRectX(), this.sawBladeNorthBlockC.getRectY(), + 
                this.sawBladeNorthBlockC.getRectWidth(), this.sawBladeNorthBlockC.getRectHeight());
    }
    /**
     * This method checks if the sawBladeNorthBlockC is being collided with at 
     * the left
     * @return True if colliding, false if not 
     */
    public boolean isCollidingSawBladeNorthBlockCLeft() {
        return this.character.isCollidingLeft(this.sawBladeNorthBlockC.getRectX(), this.sawBladeNorthBlockC.getRectY(), + 
                this.sawBladeNorthBlockC.getRectWidth(), this.sawBladeNorthBlockC.getRectHeight());
    }
    /**
     * This method checks if the sawBladeNorthBlockC is being collided with at 
     * the right
     * @return True if colliding, false if not 
     */
    public boolean isCollidingSawBladeNorthBlockCRight() {
        return this.character.isCollidingRight(this.sawBladeNorthBlockC.getRectX(), this.sawBladeNorthBlockC.getRectY(), + 
                this.sawBladeNorthBlockC.getRectWidth(), this.sawBladeNorthBlockC.getRectHeight());
    }
    
    /**
     * This method allows Room4 to use ObjectPane methods in RunGame
     * @return sawBladeNorthBlockD
     */
    public ObjectPane getSawBladeNorthBlockD() {
        return this.sawBladeNorthBlockD;
    }
    /**
     * This method checks if the sawBladeNorthBlockD is being collided with at 
     * the bottom
     * @return True if colliding, false if not 
     */
    public boolean isCollidingSawBladeNorthBlockDBottom() {
        return this.character.isCollidingBottom(this.sawBladeNorthBlockD.getRectX(), this.sawBladeNorthBlockD.getRectY(), + 
                this.sawBladeNorthBlockD.getRectWidth(), this.sawBladeNorthBlockD.getRectHeight());
    }
    /**
     * This method checks if the sawBladeNorthBlockD is being collided with at 
     * the left
     * @return True if colliding, false if not 
     */
    public boolean isCollidingSawBladeNorthBlockDLeft() {
        return this.character.isCollidingLeft(this.sawBladeNorthBlockD.getRectX(), this.sawBladeNorthBlockD.getRectY(), + 
                this.sawBladeNorthBlockD.getRectWidth(), this.sawBladeNorthBlockD.getRectHeight());
    }
    /**
     * This method checks if the sawBladeNorthBlockD is being collided with at 
     * the right
     * @return True if colliding, false if not 
     */
    public boolean isCollidingSawBladeNorthBlockDRight() {
        return this.character.isCollidingRight(this.sawBladeNorthBlockD.getRectX(), this.sawBladeNorthBlockD.getRectY(), + 
                this.sawBladeNorthBlockD.getRectWidth(), this.sawBladeNorthBlockD.getRectHeight());
    }
    
    /**
     * This method allows Room4 to use ObjectPane methods in RunGame
     * @return sawBladeNorthBlockE
     */
    public ObjectPane getSawBladeNorthBlockE() {
        return this.sawBladeNorthBlockE;
    }
    /**
     * This method checks if the sawBladeNorthBlockE is being collided with at 
     * the bottom
     * @return True if colliding, false if not 
     */
    public boolean isCollidingSawBladeNorthBlockEBottom() {
        return this.character.isCollidingBottom(this.sawBladeNorthBlockE.getRectX(), this.sawBladeNorthBlockE.getRectY(), + 
                this.sawBladeNorthBlockE.getRectWidth(), this.sawBladeNorthBlockE.getRectHeight());
    }
    /**
     * This method checks if the sawBladeNorthBlockE is being collided with at 
     * the left
     * @return True if colliding, false if not 
     */
    public boolean isCollidingSawBladeNorthBlockELeft() {
        return this.character.isCollidingLeft(this.sawBladeNorthBlockE.getRectX(), this.sawBladeNorthBlockE.getRectY(), + 
                this.sawBladeNorthBlockE.getRectWidth(), this.sawBladeNorthBlockE.getRectHeight());
    }
    /**
     * This method checks if the sawBladeNorthBlockE is being collided with at 
     * the right
     * @return True if colliding, false if not 
     */
    public boolean isCollidingSawBladeNorthBlockERight() {
        return this.character.isCollidingRight(this.sawBladeNorthBlockE.getRectX(), this.sawBladeNorthBlockE.getRectY(), + 
                this.sawBladeNorthBlockE.getRectWidth(), this.sawBladeNorthBlockE.getRectHeight());
    }
    
    /**
     * This method adds the doors to the room. The east door brings the character 
     * back to the BeginningRoom.
     */
    //add doors to room
    @Override
    public final void drawDoors() {
        westDoor = new ObjectPane(100, 450, 40, 100);
        southDoor = new ObjectPane(1620, 800, 100, 40);
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
     * This method allows Room3 to use ObjectPane methods in RunGame
     * @return southDoor
     */
    public ObjectPane getSouthDoor() {
        return this.southDoor;
    }
    /**
     * This method checks if the southDoor is being collided with at 
     * the top
     * @return True if colliding, false if not
     */
    public boolean isCollidingSouthDoor() {
        return this.character.isCollidingTop(this.southDoor.getRectX(), this.southDoor.getRectY(), + 
                this.southDoor.getRectWidth(), this.southDoor.getRectHeight());
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
     * This method returns the X coordinate near the south door
     * @return characterXSouth
     */
    public double getXSouth() {
        return this.characterXSouth;
    }
    /**
     * This method returns the Y coordinate near the south door
     * @return characterXSouth
     */
    public double getYSouth() {
        return this.characterYSouth;
    }
    /**
     * This method returns the X coordinate near the west door
     * @return characterXWest
     */
    public double getXWest() {
        return this.characterXWest;
    }
    /**
     * This method returns the Y coordinate near the west door
     * @return characterYWest
     */
    public double getYWest() {
        return this.characterXWest;
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
     * This method adds the saw blades to the room awhile with their hit boxes.
     */
    public void drawSawBlades() {
        sawBladeA = new Image("RoomsGraphics/SawBlade.png");
        viewSawBladeA = new ImageView(sawBladeA);
        viewSawBladeA.setX(1320);
        viewSawBladeA.setY(100);
        sawBladeB = new Image("RoomsGraphics/SawBlade.png");
        viewSawBladeB = new ImageView(sawBladeB);
        viewSawBladeB.setX(1020);
        viewSawBladeB.setY(800);
        sawBladeC = new Image("RoomsGraphics/SawBlade.png");
        viewSawBladeC = new ImageView(sawBladeC);
        viewSawBladeC.setX(720);
        viewSawBladeC.setY(100);
        sawBladeD = new Image("RoomsGraphics/SawBlade.png");
        viewSawBladeD = new ImageView(sawBladeD);
        viewSawBladeD.setX(420);
        viewSawBladeD.setY(800);
        
        this.getChildren().addAll(viewSawBladeA, viewSawBladeB, viewSawBladeC, viewSawBladeD);
        
        sawBladeAHitbox = new Circle(1370, 150, 50);
        sawBladeBHitbox = new Circle(1070, 850, 50);
        sawBladeCHitbox = new Circle(770, 150, 50);
        sawBladeDHitbox = new Circle(470, 850, 50);
    }
    
    /**
     * This method checks if sawBladeA is colliding is colliding with 
     * the character
     * @return True if colliding, false if not
     */
    public boolean isCollidingSawBladeA() {
        double testX = this.sawBladeAHitbox.getCenterX();
        double testY = this.sawBladeAHitbox.getCenterY();
        
        if (testX < this.character.getHitboxX()) {
            testX = this.character.getHitboxX();
        }
        else if (testX > this.character.getHitboxX() + this.character.getHitboxWidth()) {
            testX = this.character.getHitboxX() + this.character.getHitboxWidth();
        }
        
        if (testY < this.character.getHitboxY()) {
            testY = this.character.getHitboxY();
        }
        else if (testY > this.character.getHitboxY() + this.character.getHitboxHeight()) {
            testY = this.character.getHitboxY() + this.character.getHitboxHeight();
        }
        
        double distX = this.sawBladeAHitbox.getCenterX() - testX;
        double distY = this.sawBladeAHitbox.getCenterY() - testY;
        double distance = sqrt((distX * distX) + (distY * distY));
        
        return distance <= this.sawBladeAHitbox.getRadius();
    }
    /**
     * This method moves the saw blade image up and down
     */
    public void moveSawBladeA() {
        if (this.viewSawBladeA.getY() >= 800) {
            southA = false;
        }
        else if (this.viewSawBladeA.getY() <= 100) {
            southA = true;
        }
        
        if (this.viewSawBladeA.getY() < 800 && southA) {
            this.viewSawBladeA.setY(this.viewSawBladeA.getY() + speed);
            this.sawBladeAHitbox.setCenterY(this.sawBladeAHitbox.getCenterY() + speed);
            this.viewSawBladeA.setRotate(this.viewSawBladeA.getRotate() + speed);
        }
        else {
            this.viewSawBladeA.setY(this.viewSawBladeA.getY() - speed);
            this.sawBladeAHitbox.setCenterY(this.sawBladeAHitbox.getCenterY() - speed);
            this.viewSawBladeA.setRotate(this.viewSawBladeA.getRotate() + speed);
        }
    }
    /**
     * This method triggers the saw blade movement
     */
    public void movingSawBladeA() {
        moveSawBladeA = new Timeline(new KeyFrame(Duration.millis(50), e -> moveSawBladeA()));
        moveSawBladeA.setCycleCount(Timeline.INDEFINITE);
        moveSawBladeA.play();
    }
    
    /**
     * This method checks if sawBladeB is colliding is colliding with 
     * the character
     * @return True if colliding, false if not
     */
    public boolean isCollidingSawBladeB() {
        double testX = this.sawBladeBHitbox.getCenterX();
        double testY = this.sawBladeBHitbox.getCenterY();
        
        if (testX < this.character.getHitboxX()) {
            testX = this.character.getHitboxX();
        }
        else if (testX > this.character.getHitboxX() + this.character.getHitboxWidth()) {
            testX = this.character.getHitboxX() + this.character.getHitboxWidth();
        }
        
        if (testY < this.character.getHitboxY()) {
            testY = this.character.getHitboxY();
        }
        else if (testY > this.character.getHitboxY() + this.character.getHitboxHeight()) {
            testY = this.character.getHitboxY() + this.character.getHitboxHeight();
        }
        
        double distX = this.sawBladeBHitbox.getCenterX() - testX;
        double distY = this.sawBladeBHitbox.getCenterY() - testY;
        double distance = sqrt((distX * distX) + (distY * distY));
        
        return distance <= this.sawBladeBHitbox.getRadius();
    }
    /**
     * This method moves the saw blade image up and down
     */
    public void moveSawBladeB() {
        if (this.viewSawBladeB.getY() >= 800) {
            southB = false;
        }
        else if (this.viewSawBladeB.getY() <= 100) {
            southB = true;
        }
        if (this.viewSawBladeB.getY() < 800 && southB) {
            this.viewSawBladeB.setY(this.viewSawBladeB.getY() + speed);
            this.sawBladeBHitbox.setCenterY(this.sawBladeBHitbox.getCenterY() + speed);
            this.viewSawBladeB.setRotate(this.viewSawBladeB.getRotate() + speed);
        }
        else {
            this.viewSawBladeB.setY(this.viewSawBladeB.getY() - speed);
            this.sawBladeBHitbox.setCenterY(this.sawBladeBHitbox.getCenterY() - speed);
            this.viewSawBladeB.setRotate(this.viewSawBladeB.getRotate() + speed);
        }
    }
    /**
     * This method triggers the saw blade movement
     */
    public void movingSawBladeB() {
        moveSawBladeB = new Timeline(new KeyFrame(Duration.millis(50), e -> moveSawBladeB()));
        moveSawBladeB.setCycleCount(Timeline.INDEFINITE);
        moveSawBladeB.play();
    }
    
    /**
     * This method checks if sawBladeC is colliding is colliding with 
     * the character
     * @return True if colliding, false if not
     */
    public boolean isCollidingSawBladeC() {
        double testX = this.sawBladeCHitbox.getCenterX();
        double testY = this.sawBladeCHitbox.getCenterY();
        
        if (testX < this.character.getHitboxX()) {
            testX = this.character.getHitboxX();
        }
        else if (testX > this.character.getHitboxX() + this.character.getHitboxWidth()) {
            testX = this.character.getHitboxX() + this.character.getHitboxWidth();
        }
        
        if (testY < this.character.getHitboxY()) {
            testY = this.character.getHitboxY();
        }
        else if (testY > this.character.getHitboxY() + this.character.getHitboxHeight()) {
            testY = this.character.getHitboxY() + this.character.getHitboxHeight();
        }
        
        double distX = this.sawBladeCHitbox.getCenterX() - testX;
        double distY = this.sawBladeCHitbox.getCenterY() - testY;
        double distance = sqrt((distX * distX) + (distY * distY));
        
        return distance <= this.sawBladeCHitbox.getRadius();
    }
    /**
     * This method moves the saw blade image up and down
     */
    public void moveSawBladeC() {
        if (this.viewSawBladeC.getY() >= 800) {
            southC = false;
        }
        else if (this.viewSawBladeC.getY() <= 100) {
            southC = true;
        }
        if (this.viewSawBladeC.getY() < 800 && southC) {
            this.viewSawBladeC.setY(this.viewSawBladeC.getY() + speed);
            this.sawBladeCHitbox.setCenterY(this.sawBladeCHitbox.getCenterY() + speed);
            this.viewSawBladeC.setRotate(this.viewSawBladeC.getRotate() + speed);
        }
        else {
            this.viewSawBladeC.setY(this.viewSawBladeC.getY() - speed);
            this.sawBladeCHitbox.setCenterY(this.sawBladeCHitbox.getCenterY() - speed);
            this.viewSawBladeC.setRotate(this.viewSawBladeC.getRotate() + speed);
        }
    }
    /**
     * This method triggers the saw blade movement
     */
    public void movingSawBladeC() {
        moveSawBladeC = new Timeline(new KeyFrame(Duration.millis(50), e -> moveSawBladeC()));
        moveSawBladeC.setCycleCount(Timeline.INDEFINITE);
        moveSawBladeC.play();
    }
    
    /**
     * This method checks if sawBladeD is colliding is colliding with
     * the character
     * @return True if colliding, false if not
     */
    public boolean isCollidingSawBladeD() {
        double testX = this.sawBladeDHitbox.getCenterX();
        double testY = this.sawBladeDHitbox.getCenterY();
        
        if (testX < this.character.getHitboxX()) {
            testX = this.character.getHitboxX();
        }
        else if (testX > this.character.getHitboxX() + this.character.getHitboxWidth()) {
            testX = this.character.getHitboxX() + this.character.getHitboxWidth();
        }
        
        if (testY < this.character.getHitboxY()) {
            testY = this.character.getHitboxY();
        }
        else if (testY > this.character.getHitboxY() + this.character.getHitboxHeight()) {
            testY = this.character.getHitboxY() + this.character.getHitboxHeight();
        }
        
        double distX = this.sawBladeDHitbox.getCenterX() - testX;
        double distY = this.sawBladeDHitbox.getCenterY() - testY;
        double distance = sqrt((distX * distX) + (distY * distY));
        
        return distance <= this.sawBladeDHitbox.getRadius();
    }
    /**
     * This method moves the saw blade image up and down
     */
    public void moveSawBladeD() {
        if (this.viewSawBladeD.getY() >= 800) {
            southD = false;
        }
        else if (this.viewSawBladeD.getY() <= 100) {
            southD = true;
        }
        if (this.viewSawBladeD.getY() < 800 && southD) {
            this.viewSawBladeD.setY(this.viewSawBladeD.getY() + speed);
            this.sawBladeDHitbox.setCenterY(this.sawBladeDHitbox.getCenterY() + speed);
            this.viewSawBladeD.setRotate(this.viewSawBladeD.getRotate() + speed);
        }
        else {
            this.viewSawBladeD.setY(this.viewSawBladeD.getY() - speed);
            this.sawBladeDHitbox.setCenterY(this.sawBladeDHitbox.getCenterY() - speed);
            this.viewSawBladeD.setRotate(this.viewSawBladeD.getRotate() + speed);
        }
    }
    /**
     * This method triggers the saw blade movement
     */
    public void movingSawBladeD() {
        moveSawBladeD = new Timeline(new KeyFrame(Duration.millis(50), e -> moveSawBladeD()));
        moveSawBladeD.setCycleCount(Timeline.INDEFINITE);
        moveSawBladeD.play();
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
