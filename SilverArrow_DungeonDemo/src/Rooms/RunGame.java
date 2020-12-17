/*
 * Author: Kaden Payne
 * Date: 11/20/2020
 * Program that will run the Dungeon
 */
package Rooms;
import java.io.FileNotFoundException;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.shape.Line;
import javafx.util.Duration;
/**
 * This is the main class that will run the dungeon. It will hold objects of the 
 * other classes to build the dungeon. This is were the rooms of the dungeon will 
 * be switched.
 * @author kjpay
 * @version 1.0
 */
public class RunGame extends Application {
        Point2D cursor;
        Line arrowPath;
        final int WIDTH = 1920, HEIGHT = 1000;
        Image full = new Image("HealthBars/FullHealthBar.png");
        Image two = new Image("HealthBars/TwoHealthBar.png");
        Image one = new Image("HealthBars/OneHealthBar.png");
        Image empty = new Image("HealthBars/EmptyHealthBar.png");
        boolean isRoom2PuzzleComplete = false;
        Image switchOff = new Image("RoomsGraphics/SwitchOff.png");
        Image switchOn = new Image("RoomsGraphics/SwitchOn.png");
        int[] room2PuzzleAnswer = {2, 3, 1};
        int[] room2PuzzleInput = new int[3];
        int room2PuzzleIndex = 0;
        Timeline checkHealth;
        boolean room4ToRoom5 = false;
        boolean isRoom5PuzzleComplete = false;
        Image yellow = new Image("RoomsGraphics/Yellow.png");
        Image blue = new Image("RoomsGraphics/Blue.png");
    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {
        HomeScreen home = new HomeScreen();
        BeginningRoom beginningRoom = new BeginningRoom(full);
        Room2 room2 = new Room2(full);
        Room3 room3 = new Room3(full);
        Room4 room4 = new Room4(full);
        Room5 room5 = new Room5(full);
        
        GameOver gameOver = new GameOver();
        UnderConstruction underCon = new UnderConstruction();
        
        
        //Creating scene and showing stage
        Scene homeScene = new Scene(home, WIDTH, HEIGHT);
        Scene beginningScene = new Scene(beginningRoom, WIDTH, HEIGHT);
        Scene room2Scene = new Scene(room2, WIDTH, HEIGHT);
        Scene room3Scene = new Scene(room3, WIDTH, HEIGHT);
        Scene room4Scene = new Scene(room4, WIDTH, HEIGHT);
        Scene room5Scene = new Scene(room5, WIDTH, HEIGHT);
        
        Scene gameOverScene = new Scene(gameOver, WIDTH, HEIGHT);
        Scene underConScene = new Scene(underCon, WIDTH, HEIGHT);
        primaryStage.setTitle("Silver Arrow: Dungeon Demo");
        //primaryStage.setScene(homeScene);
        //For testing purposes
        //primaryStage.setScene(beginningScene);
        //primaryStage.setScene(room2Scene);
        //primaryStage.setScene(room3Scene);
        primaryStage.setScene(room4Scene);
        //primaryStage.setScene(room5Scene);
        
        //primaryStage.setScene(gameOverScene);
        primaryStage.show();
        
        
        checkHealth = new Timeline(new KeyFrame(Duration.millis(50), e -> {
            if (room4.getHealth() == empty) {
                primaryStage.setScene(gameOverScene);
            }
        }));
        checkHealth.setCycleCount(Timeline.INDEFINITE);
        checkHealth.play();
        
        homeScene.setCursor(Cursor.CROSSHAIR);
        beginningScene.setCursor(Cursor.NONE);
        room2Scene.setCursor(Cursor.NONE);
        room3Scene.setCursor(Cursor.NONE);
        room4Scene.setCursor(Cursor.NONE);
        room5Scene.setCursor(Cursor.NONE);
        
        gameOverScene.setCursor(Cursor.NONE);
        underConScene.setCursor(Cursor.NONE);
        
        //BeginningRoom movement and arrow shooting
        beginningRoom.setOnKeyPressed(e -> {
            switch (e.getCode()) {
                case W:
                    if (!beginningRoom.isCollidingNorthWall() && !beginningRoom.isCollidingEastDoorNorthBlockBottom() && 
                            !beginningRoom.isCollidingEastDoorSouthBlockBottom() && !beginningRoom.isCollidingPillarABottom() && 
                            !beginningRoom.isCollidingPillarBBottom() && !beginningRoom.isCollidingPillarCBottom() && 
                            !beginningRoom.isCollidingPillarDBottom() && !beginningRoom.isCollidingWestDoorNorthBlockBottom() && 
                            !beginningRoom.isCollidingWestDoorSouthBlockBottom()) {
                        beginningRoom.getCharacter().setAllYUp();
                        beginningRoom.getCharacter().rotateTriangle(cursor.getX(), cursor.getY());
                        beginningRoom.setCursor(cursor.getX() - 30, cursor.getY() - 30);
                        break;
                    }
                    else if (beginningRoom.isCollidingNorthWall()) {
                        beginningRoom.getCharacter().repositionAllYDown(beginningRoom.getNorthWall().getRectY(), beginningRoom.getNorthWall().getRectHeight());
                        beginningRoom.getCharacter().rotateTriangle(cursor.getX(), cursor.getY());
                        beginningRoom.setCursor(cursor.getX() - 30, cursor.getY() - 30);
                        break;
                    }
                    else if (beginningRoom.isCollidingEastDoorNorthBlockBottom()) {
                        beginningRoom.getCharacter().repositionAllYDown(beginningRoom.getEastDoorNorthBlock().getRectY(), beginningRoom.getEastDoorNorthBlock().getRectHeight());
                        beginningRoom.getCharacter().rotateTriangle(cursor.getX(), cursor.getY());
                        beginningRoom.setCursor(cursor.getX() - 30, cursor.getY() - 30);
                        break;
                    }
                    else if (beginningRoom.isCollidingEastDoorSouthBlockBottom()) {
                        beginningRoom.getCharacter().repositionAllYDown(beginningRoom.getEastDoorSouthBlock().getRectY(), beginningRoom.getEastDoorSouthBlock().getRectHeight());
                        beginningRoom.getCharacter().rotateTriangle(cursor.getX(), cursor.getY());
                        beginningRoom.setCursor(cursor.getX() - 30, cursor.getY() - 30);
                        break;
                    }
                    else if (beginningRoom.isCollidingPillarABottom()) {
                        beginningRoom.getCharacter().repositionAllYDown(beginningRoom.getPillarA().getRectY(), beginningRoom.getPillarA().getRectHeight());
                        beginningRoom.getCharacter().rotateTriangle(cursor.getX(), cursor.getY());
                        beginningRoom.setCursor(cursor.getX() - 30, cursor.getY() - 30);
                        break;
                    }
                    else if (beginningRoom.isCollidingPillarBBottom()) {
                        beginningRoom.getCharacter().repositionAllYDown(beginningRoom.getPillarB().getRectY(), beginningRoom.getPillarB().getRectHeight());
                        beginningRoom.getCharacter().rotateTriangle(cursor.getX(), cursor.getY());
                        beginningRoom.setCursor(cursor.getX() - 30, cursor.getY() - 30);
                        break;
                    }
                    else if (beginningRoom.isCollidingPillarCBottom()) {
                        beginningRoom.getCharacter().repositionAllYDown(beginningRoom.getPillarC().getRectY(), beginningRoom.getPillarC().getRectHeight());
                        beginningRoom.getCharacter().rotateTriangle(cursor.getX(), cursor.getY());
                        beginningRoom.setCursor(cursor.getX() - 30, cursor.getY() - 30);
                        break;
                    }
                    else if (beginningRoom.isCollidingPillarDBottom()) {
                        beginningRoom.getCharacter().repositionAllYDown(beginningRoom.getPillarD().getRectY(), beginningRoom.getPillarD().getRectHeight());
                        beginningRoom.getCharacter().rotateTriangle(cursor.getX(), cursor.getY());
                        beginningRoom.setCursor(cursor.getX() - 30, cursor.getY() - 30);
                        break;
                    }
                    else if (beginningRoom.isCollidingWestDoorNorthBlockBottom()) {
                        beginningRoom.getCharacter().repositionAllYDown(beginningRoom.getWestDoorNorthBlock().getRectY(), beginningRoom.getWestDoorNorthBlock().getRectHeight());
                        beginningRoom.getCharacter().rotateTriangle(cursor.getX(), cursor.getY());
                        beginningRoom.setCursor(cursor.getX() - 30, cursor.getY() - 30);
                        break;
                    }
                    else if (beginningRoom.isCollidingWestDoorSouthBlockBottom()) {
                        beginningRoom.getCharacter().repositionAllYDown(beginningRoom.getWestDoorSouthBlock().getRectY(), beginningRoom.getWestDoorSouthBlock().getRectHeight());
                        beginningRoom.getCharacter().rotateTriangle(cursor.getX(), cursor.getY());
                        beginningRoom.setCursor(cursor.getX() - 30, cursor.getY() - 30);
                        break;
                    }
                case A:
                    if (!beginningRoom.isCollidingWesthWall() && !beginningRoom.isCollidingWestDoorNorthBlockRight() && 
                            !beginningRoom.isCollidingWestDoorSouthBlockRight() && !beginningRoom.isCollidingPillarARight() && 
                            !beginningRoom.isCollidingPillarBRight() && !beginningRoom.isCollidingPillarCRight() && 
                            !beginningRoom.isCollidingPillarDRight() && !beginningRoom.isCollidingWestDoor()) {
                        beginningRoom.getCharacter().setAllXLeft();
                        beginningRoom.getCharacter().rotateTriangle(cursor.getX(), cursor.getY());
                        beginningRoom.setCursor(cursor.getX() - 30, cursor.getY() - 30);
                        break;
                    }
                    else if (beginningRoom.isCollidingWesthWall()) {
                        beginningRoom.getCharacter().repositionAllXRight(beginningRoom.getWestWall().getRectX(), beginningRoom.getWestWall().getRectWidth());
                        beginningRoom.getCharacter().rotateTriangle(cursor.getX(), cursor.getY());
                        beginningRoom.setCursor(cursor.getX() - 30, cursor.getY() - 30);
                        break;
                    }
                    else if (beginningRoom.isCollidingWestDoorNorthBlockRight()) {
                        beginningRoom.getCharacter().repositionAllXRight(beginningRoom.getWestDoorNorthBlock().getRectX(), beginningRoom.getWestDoorNorthBlock().getRectWidth());
                        beginningRoom.getCharacter().rotateTriangle(cursor.getX(), cursor.getY());
                        beginningRoom.setCursor(cursor.getX() - 30, cursor.getY() - 30);
                        break;
                    }
                    else if (beginningRoom.isCollidingWestDoorSouthBlockRight()) {
                        beginningRoom.getCharacter().repositionAllXRight(beginningRoom.getWestDoorSouthBlock().getRectX(), beginningRoom.getWestDoorSouthBlock().getRectWidth());
                        beginningRoom.getCharacter().rotateTriangle(cursor.getX(), cursor.getY());
                        beginningRoom.setCursor(cursor.getX() - 30, cursor.getY() - 30);
                        break;
                    }
                    else if (beginningRoom.isCollidingPillarARight()) {
                        beginningRoom.getCharacter().repositionAllXRight(beginningRoom.getPillarA().getRectX(), beginningRoom.getPillarA().getRectWidth());
                        beginningRoom.getCharacter().rotateTriangle(cursor.getX(), cursor.getY());
                        beginningRoom.setCursor(cursor.getX() - 30, cursor.getY() - 30);
                        break;
                    }
                    else if (beginningRoom.isCollidingPillarBRight()) {
                        beginningRoom.getCharacter().repositionAllXRight(beginningRoom.getPillarB().getRectX(), beginningRoom.getPillarB().getRectWidth());
                        beginningRoom.getCharacter().rotateTriangle(cursor.getX(), cursor.getY());
                        beginningRoom.setCursor(cursor.getX() - 30, cursor.getY() - 30);
                        break;
                    }
                    else if (beginningRoom.isCollidingPillarCRight()) {
                        beginningRoom.getCharacter().repositionAllXRight(beginningRoom.getPillarC().getRectX(), beginningRoom.getPillarC().getRectWidth());
                        beginningRoom.getCharacter().rotateTriangle(cursor.getX(), cursor.getY());
                        beginningRoom.setCursor(cursor.getX() - 30, cursor.getY() - 30);
                        break;
                    }
                    else if (beginningRoom.isCollidingPillarDRight()) {
                        beginningRoom.getCharacter().repositionAllXRight(beginningRoom.getPillarD().getRectX(), beginningRoom.getPillarD().getRectWidth());
                        beginningRoom.getCharacter().rotateTriangle(cursor.getX(), cursor.getY());
                        beginningRoom.setCursor(cursor.getX() - 30, cursor.getY() - 30);
                        break;
                    }
                    else if (beginningRoom.isCollidingWestDoor()) {
                        room2.replaceHealth(beginningRoom.getHealth());
                        if (isRoom2PuzzleComplete) {
                            room2.replaceSwitch1(switchOn);
                            room2.replaceSwitch2(switchOn);
                            room2.replaceSwitch3(switchOn);
                        }
                        else {
                            room2.replaceSwitch1(switchOff);
                            room2.replaceSwitch2(switchOff);
                            room2.replaceSwitch3(switchOff);
                        }
                        
                        primaryStage.setScene(room2Scene);
                        break;
                    }
                case S:
                    if (!beginningRoom.isCollidingSouthWall() && !beginningRoom.isCollidingEastDoorNorthBlockTop() && 
                            !beginningRoom.isCollidingEastDoorSouthBlockTop() && !beginningRoom.isCollidingPillarATop() && 
                            !beginningRoom.isCollidingPillarBTop() && !beginningRoom.isCollidingPillarCTop() && 
                            !beginningRoom.isCollidingPillarDTop() && !beginningRoom.isCollidingWestDoorNorthBlockTop() && 
                            !beginningRoom.isCollidingWestDoorSouthBlockTop()) {
                        beginningRoom.getCharacter().setAllYDown();
                        beginningRoom.getCharacter().rotateTriangle(cursor.getX(), cursor.getY());
                        beginningRoom.setCursor(cursor.getX() - 30, cursor.getY() - 30);
                        break;
                    }
                    else if (beginningRoom.isCollidingSouthWall()) {
                        beginningRoom.getCharacter().repositionAllYUp(beginningRoom.getSouthWall().getRectY());
                        beginningRoom.getCharacter().rotateTriangle(cursor.getX(), cursor.getY());
                        beginningRoom.setCursor(cursor.getX() - 30, cursor.getY() - 30);
                        break;
                    }
                    else if (beginningRoom.isCollidingEastDoorNorthBlockTop()) {
                        beginningRoom.getCharacter().repositionAllYUp(beginningRoom.getEastDoorNorthBlock().getRectY());
                        beginningRoom.getCharacter().rotateTriangle(cursor.getX(), cursor.getY());
                        beginningRoom.setCursor(cursor.getX() - 30, cursor.getY() - 30);
                        break;
                    }
                    else if (beginningRoom.isCollidingEastDoorSouthBlockTop()) {
                        beginningRoom.getCharacter().repositionAllYUp(beginningRoom.getEastDoorSouthBlock().getRectY());
                        beginningRoom.getCharacter().rotateTriangle(cursor.getX(), cursor.getY());
                        beginningRoom.setCursor(cursor.getX() - 30, cursor.getY() - 30);
                        break;
                    }
                    else if (beginningRoom.isCollidingPillarATop()) {
                        beginningRoom.getCharacter().repositionAllYUp(beginningRoom.getPillarA().getRectY());
                        beginningRoom.getCharacter().rotateTriangle(cursor.getX(), cursor.getY());
                        beginningRoom.setCursor(cursor.getX() - 30, cursor.getY() - 30);
                        break;
                    }
                    else if (beginningRoom.isCollidingPillarBTop()) {
                        beginningRoom.getCharacter().repositionAllYUp(beginningRoom.getPillarB().getRectY());
                        beginningRoom.getCharacter().rotateTriangle(cursor.getX(), cursor.getY());
                        beginningRoom.setCursor(cursor.getX() - 30, cursor.getY() - 30);
                        break;
                    }
                    else if (beginningRoom.isCollidingPillarCTop()) {
                        beginningRoom.getCharacter().repositionAllYUp(beginningRoom.getPillarC().getRectY());
                        beginningRoom.getCharacter().rotateTriangle(cursor.getX(), cursor.getY());
                        beginningRoom.setCursor(cursor.getX() - 30, cursor.getY() - 30);
                        break;
                    }
                    else if (beginningRoom.isCollidingPillarDTop()) {
                        beginningRoom.getCharacter().repositionAllYUp(beginningRoom.getPillarD().getRectY());
                        beginningRoom.getCharacter().rotateTriangle(cursor.getX(), cursor.getY());
                        beginningRoom.setCursor(cursor.getX() - 30, cursor.getY() - 30);
                        break;
                    }
                    else if (beginningRoom.isCollidingWestDoorNorthBlockTop()) {
                        beginningRoom.getCharacter().repositionAllYUp(beginningRoom.getWestDoorNorthBlock().getRectY());
                        beginningRoom.getCharacter().rotateTriangle(cursor.getX(), cursor.getY());
                        beginningRoom.setCursor(cursor.getX() - 30, cursor.getY() - 30);
                        break;
                    }
                    else if (beginningRoom.isCollidingWestDoorSouthBlockTop()) {
                        beginningRoom.getCharacter().repositionAllYUp(beginningRoom.getWestDoorSouthBlock().getRectY());
                        beginningRoom.getCharacter().rotateTriangle(cursor.getX(), cursor.getY());
                        beginningRoom.setCursor(cursor.getX() - 30, cursor.getY() - 30);
                        break;
                    }
                case D:
                    if (!beginningRoom.isCollidingEastWall() && !beginningRoom.isCollidingEastDoorNorthBlockLeft() && 
                            !beginningRoom.isCollidingEastDoorSouthBlockLeft() && !beginningRoom.isCollidingPillarALeft() && 
                            !beginningRoom.isCollidingPillarBLeft() && !beginningRoom.isCollidingPillarCLeft() && 
                            !beginningRoom.isCollidingPillarDLeft() && !beginningRoom.isCollidingEastDoor()) {
                        beginningRoom.getCharacter().setAllXRight();
                        beginningRoom.getCharacter().rotateTriangle(cursor.getX(), cursor.getY());
                        beginningRoom.setCursor(cursor.getX() - 30, cursor.getY() - 30);
                        break;
                    }
                    else if (beginningRoom.isCollidingEastWall()) {
                        beginningRoom.getCharacter().repositionAllXLeft(beginningRoom.getEastWall().getRectX());
                        beginningRoom.getCharacter().rotateTriangle(cursor.getX(), cursor.getY());
                        beginningRoom.setCursor(cursor.getX() - 30, cursor.getY() - 30);
                        break;
                    }
                    else if (beginningRoom.isCollidingEastDoorNorthBlockLeft()) {
                        beginningRoom.getCharacter().repositionAllXLeft(beginningRoom.getEastDoorNorthBlock().getRectX());
                        beginningRoom.getCharacter().rotateTriangle(cursor.getX(), cursor.getY());
                        beginningRoom.setCursor(cursor.getX() - 30, cursor.getY() - 30);
                        break;
                    }
                    else if (beginningRoom.isCollidingEastDoorSouthBlockLeft()) {
                        beginningRoom.getCharacter().repositionAllXLeft(beginningRoom.getEastDoorSouthBlock().getRectX());
                        beginningRoom.getCharacter().rotateTriangle(cursor.getX(), cursor.getY());
                        beginningRoom.setCursor(cursor.getX() - 30, cursor.getY() - 30);
                        break;
                    }
                    else if (beginningRoom.isCollidingPillarALeft()) {
                        beginningRoom.getCharacter().repositionAllXLeft(beginningRoom.getPillarA().getRectX());
                        beginningRoom.getCharacter().rotateTriangle(cursor.getX(), cursor.getY());
                        beginningRoom.setCursor(cursor.getX() - 30, cursor.getY() - 30);
                        break;
                    }
                    else if (beginningRoom.isCollidingPillarBLeft()) {
                        beginningRoom.getCharacter().repositionAllXLeft(beginningRoom.getPillarB().getRectX());
                        beginningRoom.getCharacter().rotateTriangle(cursor.getX(), cursor.getY());
                        beginningRoom.setCursor(cursor.getX() - 30, cursor.getY() - 30);
                        break;
                    }
                    else if (beginningRoom.isCollidingPillarCLeft()) {
                        beginningRoom.getCharacter().repositionAllXLeft(beginningRoom.getPillarC().getRectX());
                        beginningRoom.getCharacter().rotateTriangle(cursor.getX(), cursor.getY());
                        beginningRoom.setCursor(cursor.getX() - 30, cursor.getY() - 30);
                        break;
                    }
                    else if (beginningRoom.isCollidingPillarDLeft()) {
                        beginningRoom.getCharacter().repositionAllXLeft(beginningRoom.getPillarD().getRectX());
                        beginningRoom.getCharacter().rotateTriangle(cursor.getX(), cursor.getY());
                        beginningRoom.setCursor(cursor.getX() - 30, cursor.getY() - 30);
                        break;
                    }
                    else if (beginningRoom.isCollidingEastDoor()) {
                        room3.replaceHealth(beginningRoom.getHealth());
                        room3.removeLockedDoor(isRoom2PuzzleComplete);
                        primaryStage.setScene(room3Scene);
                        break;
                    }
                /*case DIGIT4:
                    beginningRoom.replaceHealth(full);
                    break;
                case DIGIT3:
                    beginningRoom.replaceHealth(two);
                    break;
                case DIGIT2:
                    beginningRoom.replaceHealth(one);
                    break;
                case DIGIT1:
                    beginningRoom.replaceHealth(empty);
                    break;*/
                default:
                    break;
            }
        });
        
        beginningRoom.setOnMouseMoved(e -> {
            beginningRoom.getCharacter().rotateTriangle(e.getX(), e.getY());
            cursor = new Point2D(e.getX(), e.getY());
            beginningRoom.setCursor(e.getX() - 30, e.getY() - 30);
        });
        
        beginningRoom.setOnMouseClicked(e -> {
            arrowPath = new Line(beginningRoom.getCharacter().getP1X(), beginningRoom.getCharacter().getP1Y() + 30, cursor.getX(), cursor.getY());
            if (beginningRoom.getPillarA().isCollidingLineBottom(arrowPath.getEndX(), arrowPath.getEndY(), arrowPath.getStartX(), arrowPath.getStartY(), + 
                    beginningRoom.getPillarA().getRectX(), beginningRoom.getPillarA().getRectY(), beginningRoom.getPillarA().getRectWidth(), beginningRoom.getPillarA().getRectHeight())) {
                arrowPath.setEndY(beginningRoom.getPillarA().getRectY() + beginningRoom.getPillarA().getRectHeight());
            }
            else if (beginningRoom.getPillarA().isCollidingLineRight(arrowPath.getEndX(), arrowPath.getEndY(), arrowPath.getStartX(), arrowPath.getStartY(), + 
                    beginningRoom.getPillarA().getRectX(), beginningRoom.getPillarA().getRectY(), beginningRoom.getPillarA().getRectWidth(), beginningRoom.getPillarA().getRectHeight())) {
                arrowPath.setEndX(beginningRoom.getPillarA().getRectX() + beginningRoom.getPillarA().getRectWidth());
            }
            
            if (beginningRoom.getPillarA().isCollidingLineTop(arrowPath.getEndX(), arrowPath.getEndY(), arrowPath.getStartX(), arrowPath.getStartY(), + 
                    beginningRoom.getPillarA().getRectX(), beginningRoom.getPillarA().getRectY(), beginningRoom.getPillarA().getRectWidth(), beginningRoom.getPillarA().getRectHeight())) {
                arrowPath.setEndY(beginningRoom.getPillarA().getRectY());
            }
            else if (beginningRoom.getPillarA().isCollidingLineLeft(arrowPath.getEndX(), arrowPath.getEndY(), arrowPath.getStartX(), arrowPath.getStartY(), + 
                    beginningRoom.getPillarA().getRectX(), beginningRoom.getPillarA().getRectY(), beginningRoom.getPillarA().getRectWidth(), beginningRoom.getPillarA().getRectHeight())) {
                arrowPath.setEndX(beginningRoom.getPillarA().getRectX());
            }
            
            if (beginningRoom.getPillarB().isCollidingLineBottom(arrowPath.getEndX(), arrowPath.getEndY(), arrowPath.getStartX(), arrowPath.getStartY(), + 
                    beginningRoom.getPillarB().getRectX(), beginningRoom.getPillarB().getRectY(), beginningRoom.getPillarB().getRectWidth(), beginningRoom.getPillarB().getRectHeight())) {
                arrowPath.setEndY(beginningRoom.getPillarB().getRectY() + beginningRoom.getPillarB().getRectHeight());
            }
            else if (beginningRoom.getPillarB().isCollidingLineRight(arrowPath.getEndX(), arrowPath.getEndY(), arrowPath.getStartX(), arrowPath.getStartY(), + 
                    beginningRoom.getPillarB().getRectX(), beginningRoom.getPillarB().getRectY(), beginningRoom.getPillarB().getRectWidth(), beginningRoom.getPillarB().getRectHeight())) {
                arrowPath.setEndX(beginningRoom.getPillarB().getRectX() + beginningRoom.getPillarB().getRectWidth());
            }
            
            if (beginningRoom.getPillarB().isCollidingLineTop(arrowPath.getEndX(), arrowPath.getEndY(), arrowPath.getStartX(), arrowPath.getStartY(), + 
                    beginningRoom.getPillarB().getRectX(), beginningRoom.getPillarB().getRectY(), beginningRoom.getPillarB().getRectWidth(), beginningRoom.getPillarB().getRectHeight())) {
                arrowPath.setEndY(beginningRoom.getPillarB().getRectY());
            }
            else if (beginningRoom.getPillarB().isCollidingLineLeft(arrowPath.getEndX(), arrowPath.getEndY(), arrowPath.getStartX(), arrowPath.getStartY(), + 
                    beginningRoom.getPillarB().getRectX(), beginningRoom.getPillarB().getRectY(), beginningRoom.getPillarB().getRectWidth(), beginningRoom.getPillarB().getRectHeight())) {
                arrowPath.setEndX(beginningRoom.getPillarB().getRectX());
            }
            
            if (beginningRoom.getPillarC().isCollidingLineBottom(arrowPath.getEndX(), arrowPath.getEndY(), arrowPath.getStartX(), arrowPath.getStartY(), + 
                    beginningRoom.getPillarC().getRectX(), beginningRoom.getPillarC().getRectY(), beginningRoom.getPillarC().getRectWidth(), beginningRoom.getPillarC().getRectHeight())) {
                arrowPath.setEndY(beginningRoom.getPillarC().getRectY() + beginningRoom.getPillarC().getRectHeight());
            }
            else if (beginningRoom.getPillarC().isCollidingLineRight(arrowPath.getEndX(), arrowPath.getEndY(), arrowPath.getStartX(), arrowPath.getStartY(), + 
                    beginningRoom.getPillarC().getRectX(), beginningRoom.getPillarC().getRectY(), beginningRoom.getPillarC().getRectWidth(), beginningRoom.getPillarC().getRectHeight())) {
                arrowPath.setEndX(beginningRoom.getPillarC().getRectX() + beginningRoom.getPillarC().getRectWidth());
            }
            
            if (beginningRoom.getPillarC().isCollidingLineTop(arrowPath.getEndX(), arrowPath.getEndY(), arrowPath.getStartX(), arrowPath.getStartY(), + 
                    beginningRoom.getPillarC().getRectX(), beginningRoom.getPillarC().getRectY(), beginningRoom.getPillarC().getRectWidth(), beginningRoom.getPillarC().getRectHeight())) {
                arrowPath.setEndY(beginningRoom.getPillarC().getRectY());
            }
            else if (beginningRoom.getPillarC().isCollidingLineLeft(arrowPath.getEndX(), arrowPath.getEndY(), arrowPath.getStartX(), arrowPath.getStartY(), + 
                    beginningRoom.getPillarC().getRectX(), beginningRoom.getPillarC().getRectY(), beginningRoom.getPillarC().getRectWidth(), beginningRoom.getPillarC().getRectHeight())) {
                arrowPath.setEndX(beginningRoom.getPillarC().getRectX());
            }
            
            if (beginningRoom.getPillarD().isCollidingLineBottom(arrowPath.getEndX(), arrowPath.getEndY(), arrowPath.getStartX(), arrowPath.getStartY(), + 
                    beginningRoom.getPillarD().getRectX(), beginningRoom.getPillarD().getRectY(), beginningRoom.getPillarD().getRectWidth(), beginningRoom.getPillarD().getRectHeight())) {
                arrowPath.setEndY(beginningRoom.getPillarD().getRectY() + beginningRoom.getPillarD().getRectHeight());
            }
            else if (beginningRoom.getPillarD().isCollidingLineRight(arrowPath.getEndX(), arrowPath.getEndY(), arrowPath.getStartX(), arrowPath.getStartY(), + 
                    beginningRoom.getPillarD().getRectX(), beginningRoom.getPillarD().getRectY(), beginningRoom.getPillarD().getRectWidth(), beginningRoom.getPillarD().getRectHeight())) {
                arrowPath.setEndX(beginningRoom.getPillarD().getRectX() + beginningRoom.getPillarD().getRectWidth());
            }
            
            if (beginningRoom.getPillarD().isCollidingLineTop(arrowPath.getEndX(), arrowPath.getEndY(), arrowPath.getStartX(), arrowPath.getStartY(), + 
                    beginningRoom.getPillarD().getRectX(), beginningRoom.getPillarD().getRectY(), beginningRoom.getPillarD().getRectWidth(), beginningRoom.getPillarD().getRectHeight())) {
                arrowPath.setEndY(beginningRoom.getPillarD().getRectY());
            }
            else if (beginningRoom.getPillarD().isCollidingLineLeft(arrowPath.getEndX(), arrowPath.getEndY(), arrowPath.getStartX(), arrowPath.getStartY(), + 
                    beginningRoom.getPillarD().getRectX(), beginningRoom.getPillarD().getRectY(), beginningRoom.getPillarD().getRectWidth(), beginningRoom.getPillarD().getRectHeight())) {
                arrowPath.setEndX(beginningRoom.getPillarD().getRectX());
            }
            
            beginningRoom.shootArrow(arrowPath);
        });
        
        beginningRoom.requestFocus();
        
        //Room2 movement and arrow shooting
        room2.setOnKeyPressed(e -> {
            switch (e.getCode()) {
                case W:
                    if (!room2.isCollidingNorthWall() && !room2.isCollidingEastDoorNorthBlockBottom() && 
                            !room2.isCollidingEastDoorSouthBlockBottom() && !room2.isCollidingMessage231Bottom()) {
                        room2.getCharacter().setAllYUp();
                        room2.getCharacter().rotateTriangle(cursor.getX(), cursor.getY());
                        room2.setCursor(cursor.getX() - 30, cursor.getY() - 30);
                        break;
                    }
                    else if (room2.isCollidingNorthWall()) {
                        room2.getCharacter().repositionAllYDown(room2.getNorthWall().getRectY(), room2.getNorthWall().getRectHeight());
                        room2.getCharacter().rotateTriangle(cursor.getX(), cursor.getY());
                        room2.setCursor(cursor.getX() - 30, cursor.getY() - 30);
                        break;
                    }
                    else if (room2.isCollidingEastDoorNorthBlockBottom()) {
                        room2.getCharacter().repositionAllYDown(room2.getEastDoorNorthBlock().getRectY(), room2.getEastDoorNorthBlock().getRectHeight());
                        room2.getCharacter().rotateTriangle(cursor.getX(), cursor.getY());
                        room2.setCursor(cursor.getX() - 30, cursor.getY() - 30);
                        break;
                    }
                    else if (room2.isCollidingEastDoorSouthBlockBottom()) {
                        room2.getCharacter().repositionAllYDown(room2.getEastDoorSouthBlock().getRectY(), room2.getEastDoorSouthBlock().getRectHeight());
                        room2.getCharacter().rotateTriangle(cursor.getX(), cursor.getY());
                        room2.setCursor(cursor.getX() - 30, cursor.getY() - 30);
                        break;
                    }
                    else if (room2.isCollidingMessage231Bottom()) {
                        room2.getCharacter().repositionAllYDown(room2.getMessage231().getRectY(), room2.getMessage231().getRectHeight());
                        room2.getCharacter().rotateTriangle(cursor.getX(), cursor.getY());
                        room2.setCursor(cursor.getX() - 30, cursor.getY() - 30);
                        break;
                    }
                case A:
                    if (!room2.isCollidingMessage231Right() && !room2.isCollidingMessageAimRight() && !room2.isCollidingPit()) {
                        room2.getCharacter().setAllXLeft();
                        room2.getCharacter().rotateTriangle(cursor.getX(), cursor.getY());
                        room2.setCursor(cursor.getX() - 30, cursor.getY() - 30);
                        break;
                    }
                    else if (room2.isCollidingMessage231Right()) {
                        room2.getCharacter().repositionAllXRight(room2.getMessage231().getRectX(), room2.getMessage231().getRectWidth());
                        room2.getCharacter().rotateTriangle(cursor.getX(), cursor.getY());
                        room2.setCursor(cursor.getX() - 30, cursor.getY() - 30);
                        break;
                    }
                    else if (room2.isCollidingMessageAimRight()) {
                        room2.getCharacter().repositionAllXRight(room2.getMessageAim().getRectX(), room2.getMessageAim().getRectWidth());
                        room2.getCharacter().rotateTriangle(cursor.getX(), cursor.getY());
                        room2.setCursor(cursor.getX() - 30, cursor.getY() - 30);
                        break;
                    }
                    else if (room2.isCollidingPit()) {
                        room2.getCharacter().repositionAllXRight(room2.getPit().getRectX(), room2.getPit().getRectWidth());
                        room2.getCharacter().rotateTriangle(cursor.getX(), cursor.getY());
                        room2.setCursor(cursor.getX() - 30, cursor.getY() - 30);
                        break;
                    }
                case S:
                    if (!room2.isCollidingSouthWall() && !room2.isCollidingEastDoorNorthBlockTop() && 
                            !room2.isCollidingEastDoorSouthBlockTop() && !room2.isCollidingMessageAimTop()) {
                        room2.getCharacter().setAllYDown();
                        room2.getCharacter().rotateTriangle(cursor.getX(), cursor.getY());
                        room2.setCursor(cursor.getX() - 30, cursor.getY() - 30);
                        break;
                    }
                    else if (room2.isCollidingSouthWall()) {
                        room2.getCharacter().repositionAllYUp(room2.getSouthWall().getRectY());
                        room2.getCharacter().rotateTriangle(cursor.getX(), cursor.getY());
                        room2.setCursor(cursor.getX() - 30, cursor.getY() - 30);
                        break;
                    }
                    else if (room2.isCollidingEastDoorNorthBlockTop()) {
                        room2.getCharacter().repositionAllYUp(room2.getEastDoorNorthBlock().getRectY());
                        room2.getCharacter().rotateTriangle(cursor.getX(), cursor.getY());
                        room2.setCursor(cursor.getX() - 30, cursor.getY() - 30);
                        break;
                    }
                    else if (room2.isCollidingEastDoorSouthBlockTop()) {
                        room2.getCharacter().repositionAllYUp(room2.getEastDoorSouthBlock().getRectY());
                        room2.getCharacter().rotateTriangle(cursor.getX(), cursor.getY());
                        room2.setCursor(cursor.getX() - 30, cursor.getY() - 30);
                        break;
                    }
                    else if (room2.isCollidingMessageAimTop()) {
                        room2.getCharacter().repositionAllYUp(room2.getMessageAim().getRectY());
                        room2.getCharacter().rotateTriangle(cursor.getX(), cursor.getY());
                        room2.setCursor(cursor.getX() - 30, cursor.getY() - 30);
                        break;
                    }
                case D:
                    if (!room2.isCollidingEastWall() && !room2.isCollidingEastDoorNorthBlockLeft() && 
                            !room2.isCollidingEastDoorSouthBlockLeft() && !room2.isCollidingMessage231Left() && 
                            !room2.isCollidingMessageAimLeft() && !room2.isCollidingEastDoor()) {
                        room2.getCharacter().setAllXRight();
                        room2.getCharacter().rotateTriangle(cursor.getX(), cursor.getY());
                        room2.setCursor(cursor.getX() - 30, cursor.getY() - 30);
                        break;
                    }
                    else if (room2.isCollidingEastWall()) {
                        room2.getCharacter().repositionAllXLeft(room2.getEastWall().getRectX());
                        room2.getCharacter().rotateTriangle(cursor.getX(), cursor.getY());
                        room2.setCursor(cursor.getX() - 30, cursor.getY() - 30);
                        break;
                    }
                    else if (room2.isCollidingEastDoorNorthBlockLeft()) {
                        room2.getCharacter().repositionAllXLeft(room2.getEastDoorNorthBlock().getRectX());
                        room2.getCharacter().rotateTriangle(cursor.getX(), cursor.getY());
                        room2.setCursor(cursor.getX() - 30, cursor.getY() - 30);
                        break;
                    }
                    else if (room2.isCollidingEastDoorSouthBlockLeft()) {
                        room2.getCharacter().repositionAllXLeft(room2.getEastDoorSouthBlock().getRectX());
                        room2.getCharacter().rotateTriangle(cursor.getX(), cursor.getY());
                        room2.setCursor(cursor.getX() - 30, cursor.getY() - 30);
                        break;
                    }
                    else if (room2.isCollidingMessage231Left()) {
                        room2.getCharacter().repositionAllXLeft(room2.getMessage231().getRectX());
                        room2.getCharacter().rotateTriangle(cursor.getX(), cursor.getY());
                        room2.setCursor(cursor.getX() - 30, cursor.getY() - 30);
                        break;
                    }
                    else if (room2.isCollidingMessageAimLeft()) {
                        room2.getCharacter().repositionAllXLeft(room2.getMessageAim().getRectX());
                        room2.getCharacter().rotateTriangle(cursor.getX(), cursor.getY());
                        room2.setCursor(cursor.getX() - 30, cursor.getY() - 30);
                        break;
                    }
                    else if (room2.isCollidingEastDoor()) {
                        beginningRoom.replaceHealth(room2.getHealth());
                        primaryStage.setScene(beginningScene);
                        break;
                    }
                /*case DIGIT4:
                    room2.replaceHealth(full);
                    break;
                case DIGIT3:
                    room2.replaceHealth(two);
                    break;
                case DIGIT2:
                    room2.replaceHealth(one);
                    break;
                case DIGIT1:
                    room2.replaceHealth(empty);
                    break;*/
                default:
                    break;
            }
        });
        
        room2.setOnMouseMoved(e -> {
            room2.getCharacter().rotateTriangle(e.getX(), e.getY());
            cursor = new Point2D(e.getX(), e.getY());
            room2.setCursor(e.getX() - 30, e.getY() - 30);
        });
        
        room2.setOnMouseClicked(e -> {
            arrowPath = new Line(room2.getCharacter().getP1X(), room2.getCharacter().getP1Y() + 30, cursor.getX(), cursor.getY());
            if (room2.getMessage231().isCollidingLineBottom(arrowPath.getEndX(), arrowPath.getEndY(), arrowPath.getStartX(), arrowPath.getStartY(), + 
                    room2.getMessage231().getRectX(), room2.getMessage231().getRectY(), + 
                            room2.getMessage231().getRectWidth(), room2.getMessage231().getRectHeight())) {
                arrowPath.setEndY(room2.getMessage231().getRectY() + room2.getMessage231().getRectHeight());
            }
            else if (room2.getMessage231().isCollidingLineRight(arrowPath.getEndX(), arrowPath.getEndY(), arrowPath.getStartX(), arrowPath.getStartY(), + 
                    room2.getMessage231().getRectX(), room2.getMessage231().getRectY(), + 
                            room2.getMessage231().getRectWidth(), room2.getMessage231().getRectHeight())) {
                arrowPath.setEndX(room2.getMessage231().getRectX() + room2.getMessage231().getRectWidth());
            }
            else if (room2.getMessage231().isCollidingLineLeft(arrowPath.getEndX(), arrowPath.getEndY(), arrowPath.getStartX(), arrowPath.getStartY(), + 
                    room2.getMessage231().getRectX(), room2.getMessage231().getRectY(), + 
                            room2.getMessage231().getRectWidth(), room2.getMessage231().getRectHeight())) {
                arrowPath.setEndX(room2.getMessage231().getRectX());
            }
            
            if (room2.getMessageAim().isCollidingLineTop(arrowPath.getEndX(), arrowPath.getEndY(), arrowPath.getStartX(), arrowPath.getStartY(), + 
                    room2.getMessageAim().getRectX(), room2.getMessageAim().getRectY(), + 
                            room2.getMessageAim().getRectWidth(), room2.getMessageAim().getRectHeight())) {
                arrowPath.setEndY(room2.getMessageAim().getRectY());
            }
            else if (room2.getMessageAim().isCollidingLineRight(arrowPath.getEndX(), arrowPath.getEndY(), arrowPath.getStartX(), arrowPath.getStartY(), + 
                    room2.getMessageAim().getRectX(), room2.getMessageAim().getRectY(), + 
                            room2.getMessageAim().getRectWidth(), room2.getMessageAim().getRectHeight())) {
                arrowPath.setEndX(room2.getMessageAim().getRectX() + room2.getMessageAim().getRectWidth());
            }
            else if (room2.getMessageAim().isCollidingLineLeft(arrowPath.getEndX(), arrowPath.getEndY(), arrowPath.getStartX(), arrowPath.getStartY(), + 
                    room2.getMessageAim().getRectX(), room2.getMessageAim().getRectY(), + 
                            room2.getMessageAim().getRectWidth(), room2.getMessageAim().getRectHeight())) {
                arrowPath.setEndX(room2.getMessageAim().getRectX());
            }
            
            room2.shootArrow(arrowPath);
            
            if (!isRoom2PuzzleComplete) {
                if (room2.getSwitch1Hitbox().isColliding(cursor.getX(), cursor.getY())) {
                    if (room2.getSwitch1() != switchOn) {
                        room2.replaceSwitch1(switchOn);
                        room2PuzzleInput[room2PuzzleIndex] = 1;
                        room2PuzzleIndex++;
                    }
                }
                else if (room2.getSwitch2Hitbox().isColliding(cursor.getX(), cursor.getY())) {
                    if (room2.getSwitch2() != switchOn) {
                        room2.replaceSwitch2(switchOn);
                        room2PuzzleInput[room2PuzzleIndex] = 2;
                        room2PuzzleIndex++;
                    }
                }
                else if (room2.getSwitch3Hitbox().isColliding(cursor.getX(), cursor.getY())) {
                    if (room2.getSwitch3() != switchOn) {
                        room2.replaceSwitch3(switchOn);
                        room2PuzzleInput[room2PuzzleIndex] = 3;
                        room2PuzzleIndex++;
                    }
                }
                
                if (room2PuzzleIndex == 3) {
                    if (room2PuzzleAnswer[0] == room2PuzzleInput[0] && room2PuzzleAnswer[1] == room2PuzzleInput[1] && 
                            room2PuzzleAnswer[2] == room2PuzzleInput[2]) {
                        isRoom2PuzzleComplete = true;
                    }
                    else {
                        room2PuzzleInput = new int[3];
                        room2PuzzleIndex = 0;
                        room2.replaceSwitch1(switchOff);
                        room2.replaceSwitch2(switchOff);
                        room2.replaceSwitch3(switchOff);
                    }
                    
                }
            }
            //for testing purposes
            /*if (room2.getSwitch1Hitbox().isColliding(cursor.getX(), cursor.getY())) {
                if (room2.getSwitch1() == switchOn) {
                    room2.replaceSwitch1(switchOff);
                }
                else {
                    room2.replaceSwitch1(switchOn);
                }
                
            }
            else if (room2.getSwitch2Hitbox().isColliding(cursor.getX(), cursor.getY())) {
                if (room2.getSwitch2() == switchOn) {
                    room2.replaceSwitch2(switchOff);
                }
                else {
                    room2.replaceSwitch2(switchOn);
                }
            }
            else if (room2.getSwitch3Hitbox().isColliding(cursor.getX(), cursor.getY())) {
                if (room2.getSwitch3() == switchOn) {
                    room2.replaceSwitch3(switchOff);
                }
                else {
                    room2.replaceSwitch3(switchOn);
                }
            }*/
        });
        
        room2.requestFocus();
        
        //Room3 movement and arrow
        room3.setOnKeyPressed(e -> {
            switch (e.getCode()) {
                case W:
                    if (!room3.isCollidingNorthWestWallBottom() && !room3.isCollidingNorthDoorEastBlockBottom() && 
                            !room3.isCollidingNorthDoorWestBlockBottom() && !room3.isCollidingNorthDoor() && 
                            !room3.isCollidingLockedDoor() && !room3.isCollidingWestDoorNorthBlockBottom() &&
                            !room3.isCollidingNorthDoor()) {
                        room3.getCharacter().setAllYUp();
                        room3.getCharacter().rotateTriangle(cursor.getX(), cursor.getY());
                        room3.setCursor(cursor.getX() - 30, cursor.getY() - 30);
                        break;
                    }
                    else if (room3.isCollidingNorthWestWallBottom()) {
                        room3.getCharacter().repositionAllYDown(room3.getNorthWestWall().getRectY(), room3.getNorthWestWall().getRectHeight());
                        room3.getCharacter().rotateTriangle(cursor.getX(), cursor.getY());
                        room3.setCursor(cursor.getX() - 30, cursor.getY() - 30);
                        break;
                    }
                    else if (room3.isCollidingNorthDoorEastBlockBottom()) {
                        room3.getCharacter().repositionAllYDown(room3.getNorthDoorEastBlock().getRectY(), room3.getNorthDoorEastBlock().getRectHeight());
                        room3.getCharacter().rotateTriangle(cursor.getX(), cursor.getY());
                        room3.setCursor(cursor.getX() - 30, cursor.getY() - 30);
                        break;
                    }
                    else if (room3.isCollidingNorthDoorWestBlockBottom()) {
                        room3.getCharacter().repositionAllYDown(room3.getNorthDoorWestBlock().getRectY(), room3.getNorthDoorWestBlock().getRectHeight());
                        room3.getCharacter().rotateTriangle(cursor.getX(), cursor.getY());
                        room3.setCursor(cursor.getX() - 30, cursor.getY() - 30);
                        break;
                    }
                    else if (room3.isCollidingLockedDoor()) {
                        if (!isRoom2PuzzleComplete) {
                            room3.getCharacter().repositionAllYDown(room3.getLockedDoor().getRectY(), room3.getLockedDoor().getRectHeight());
                            room3.getCharacter().rotateTriangle(cursor.getX(), cursor.getY());
                            room3.setCursor(cursor.getX() - 30, cursor.getY() - 30);
                            break;
                        }
                    }
                    else if (room3.isCollidingWestDoorNorthBlockBottom()) {
                        room3.getCharacter().repositionAllYDown(room3.getWestDoorNorthBlock().getRectY(), room3.getWestDoorNorthBlock().getRectHeight());
                        room3.getCharacter().rotateTriangle(cursor.getX(), cursor.getY());
                        room3.setCursor(cursor.getX() - 30, cursor.getY() - 30);
                        break;
                    }
                    else if (room3.isCollidingNorthDoor()) {
                        room4ToRoom5 = false;
                        room4.replaceHealth(room3.getHealth());
                        primaryStage.setScene(room4Scene);
                        break;
                    }
                case A:
                    if (!room3.isCollidingNorthWestWallRight() && !room3.isCollidingWestDoorNorthBlockRight() && 
                            !room3.isCollidingWestDoorSouthBlockRight() && !room3.isCollidingWestDoor() && 
                            !room3.isCollidingNorthDoorWestBlockRight()) {
                        room3.getCharacter().setAllXLeft();
                        room3.getCharacter().rotateTriangle(cursor.getX(), cursor.getY());
                        room3.setCursor(cursor.getX() - 30, cursor.getY() - 30);
                        break;
                    }
                    else if (room3.isCollidingNorthWestWallRight()) {
                        room3.getCharacter().repositionAllXRight(room3.getNorthWestWall().getRectX(), room3.getNorthWestWall().getRectWidth());
                        room3.getCharacter().rotateTriangle(cursor.getX(), cursor.getY());
                        room3.setCursor(cursor.getX() - 30, cursor.getY() - 30);
                        break;
                    }
                    else if (room3.isCollidingWestDoorNorthBlockRight()) {
                        room3.getCharacter().repositionAllXRight(room3.getWestDoorNorthBlock().getRectX(), room3.getWestDoorNorthBlock().getRectWidth());
                        room3.getCharacter().rotateTriangle(cursor.getX(), cursor.getY());
                        room3.setCursor(cursor.getX() - 30, cursor.getY() - 30);
                        break;
                    }
                    else if (room3.isCollidingWestDoorSouthBlockRight()) {
                        room3.getCharacter().repositionAllXRight(room3.getWestDoorSouthBlock().getRectX(), room3.getWestDoorSouthBlock().getRectWidth());
                        room3.getCharacter().rotateTriangle(cursor.getX(), cursor.getY());
                        room3.setCursor(cursor.getX() - 30, cursor.getY() - 30);
                        break;
                    }
                    else if (room3.isCollidingWestDoor()) {
                        beginningRoom.replaceHealth(room3.getHealth());
                        primaryStage.setScene(beginningScene);
                        break;
                    }
                    else if (room3.isCollidingNorthDoorWestBlockRight()) {
                        room3.getCharacter().repositionAllXRight(room3.getNorthDoorWestBlock().getRectX(), room3.getNorthDoorWestBlock().getRectWidth());
                        room3.getCharacter().rotateTriangle(cursor.getX(), cursor.getY());
                        room3.setCursor(cursor.getX() - 30, cursor.getY() - 30);
                        break;
                    }
                case S:
                    if (!room3.isCollidingSouthWall() && !room3.isCollidingWestDoorSouthBlockTop()) {
                        room3.getCharacter().setAllYDown();
                        room3.getCharacter().rotateTriangle(cursor.getX(), cursor.getY());
                        room3.setCursor(cursor.getX() - 30, cursor.getY() - 30);
                        break;
                    }
                    else if (room3.isCollidingSouthWall()) {
                        room3.getCharacter().repositionAllYUp(room3.getSouthWall().getRectY());
                        room3.getCharacter().rotateTriangle(cursor.getX(), cursor.getY());
                        room3.setCursor(cursor.getX() - 30, cursor.getY() - 30);
                        break;
                    }
                    else if (room3.isCollidingWestDoorSouthBlockTop()) {
                        room3.getCharacter().repositionAllYUp(room3.getWestDoorSouthBlock().getRectY());
                        room3.getCharacter().rotateTriangle(cursor.getX(), cursor.getY());
                        room3.setCursor(cursor.getX() - 30, cursor.getY() - 30);
                        break;
                    }
                case D:
                    if (!room3.isCollidingEastWall() && !room3.isCollidingNorthDoorEastBlockLeft()) {
                        room3.getCharacter().setAllXRight();
                        room3.getCharacter().rotateTriangle(cursor.getX(), cursor.getY());
                        room3.setCursor(cursor.getX() - 30, cursor.getY() - 30);
                        break;
                    }
                    else if (room3.isCollidingEastWall()) {
                        room3.getCharacter().repositionAllXLeft(room3.getEastWall().getRectX());
                        room3.getCharacter().rotateTriangle(cursor.getX(), cursor.getY());
                        room3.setCursor(cursor.getX() - 30, cursor.getY() - 30);
                        break;
                    }
                    else if (room3.isCollidingNorthDoorEastBlockLeft()) {
                        room3.getCharacter().repositionAllXLeft(room3.getNorthDoorEastBlock().getRectX());
                        room3.getCharacter().rotateTriangle(cursor.getX(), cursor.getY());
                        room3.setCursor(cursor.getX() - 30, cursor.getY() - 30);
                        break;
                    }
                default:
                    break;
            }
        });
        
        room3.setOnMouseMoved(e -> {
            room3.getCharacter().rotateTriangle(e.getX(), e.getY());
            cursor = new Point2D(e.getX(), e.getY());
            room3.setCursor(e.getX() - 30, e.getY() - 30);
        });
        
        room3.setOnMouseClicked(e ->{
            arrowPath = new Line(room3.getCharacter().getP1X(), room3.getCharacter().getP1Y() + 30, cursor.getX(), cursor.getY());
            if (room3.getNorthWestWall().isCollidingLineBottom(arrowPath.getEndX(), arrowPath.getEndY(), arrowPath.getStartX(), arrowPath.getStartY(), + 
                    room3.getNorthWestWall().getRectX(), room3.getNorthWestWall().getRectY(), + 
                            room3.getNorthWestWall().getRectWidth(), room3.getNorthWestWall().getRectHeight())) {
                arrowPath.setEndY(room3.getNorthWestWall().getRectY() + room3.getNorthWestWall().getRectHeight());
            }
            else if (room3.getNorthWestWall().isCollidingLineRight(arrowPath.getEndX(), arrowPath.getEndY(), arrowPath.getStartX(), arrowPath.getStartY(), + 
                    room3.getNorthWestWall().getRectX(), room3.getNorthWestWall().getRectY(), + 
                            room3.getNorthWestWall().getRectWidth(), room3.getNorthWestWall().getRectHeight())) {
                arrowPath.setEndX(room3.getNorthWestWall().getRectX() + room3.getNorthWestWall().getRectWidth());
            }
            
            room3.shootArrow(arrowPath);
        });
        
        room3.requestFocus();
        
        //Room4 movement and arrow shooting
        room4.setOnKeyPressed(e -> {
            switch (e.getCode()) {
                case W:
                    if (!room4.isCollidingNorthWall() && !room4.isCollidingSawBladeNorthBlockABottom() &&
                            !room4.isCollidingSawBladeNorthBlockBBottom() && !room4.isCollidingSawBladeNorthBlockCBottom() &&
                            !room4.isCollidingSawBladeNorthBlockDBottom() && !room4.isCollidingSawBladeNorthBlockEBottom() &&
                            !room4.isCollidingWestWallNorthBottom()) {
                        room4.getCharacter().setAllYUp();
                        room4.getCharacter().rotateTriangle(cursor.getX(), cursor.getY());
                        room4.setCursor(cursor.getX() - 30, cursor.getY() - 30);
                        break;
                    }
                    else if (room4.isCollidingNorthWall()) {
                        room4.getCharacter().repositionAllYDown(room4.getNorthWall().getRectY(), room4.getNorthWall().getRectHeight());
                        room4.getCharacter().rotateTriangle(cursor.getX(), cursor.getY());
                        room4.setCursor(cursor.getX() - 30, cursor.getY() - 30);
                        break;
                    }
                    else if (room4.isCollidingSawBladeNorthBlockABottom()) {
                        room4.getCharacter().repositionAllYDown(room4.getSawBladeNorthBlockA().getRectY(), room4.getSawBladeNorthBlockA().getRectHeight());
                        room4.getCharacter().rotateTriangle(cursor.getX(), cursor.getY());
                        room4.setCursor(cursor.getX() - 30, cursor.getY() - 30);
                        break;
                    }
                    else if (room4.isCollidingSawBladeNorthBlockBBottom()) {
                        room4.getCharacter().repositionAllYDown(room4.getSawBladeNorthBlockB().getRectY(), room4.getSawBladeNorthBlockB().getRectHeight());
                        room4.getCharacter().rotateTriangle(cursor.getX(), cursor.getY());
                        room4.setCursor(cursor.getX() - 30, cursor.getY() - 30);
                        break;
                    }
                    else if (room4.isCollidingSawBladeNorthBlockCBottom()) {
                        room4.getCharacter().repositionAllYDown(room4.getSawBladeNorthBlockC().getRectY(), room4.getSawBladeNorthBlockC().getRectHeight());
                        room4.getCharacter().rotateTriangle(cursor.getX(), cursor.getY());
                        room4.setCursor(cursor.getX() - 30, cursor.getY() - 30);
                        break;
                    }
                    else if (room4.isCollidingSawBladeNorthBlockDBottom()) {
                        room4.getCharacter().repositionAllYDown(room4.getSawBladeNorthBlockD().getRectY(), room4.getSawBladeNorthBlockD().getRectHeight());
                        room4.getCharacter().rotateTriangle(cursor.getX(), cursor.getY());
                        room4.setCursor(cursor.getX() - 30, cursor.getY() - 30);
                        break;
                    }
                    else if (room4.isCollidingSawBladeNorthBlockEBottom()) {
                        room4.getCharacter().repositionAllYDown(room4.getSawBladeNorthBlockE().getRectY(), room4.getSawBladeNorthBlockE().getRectHeight());
                        room4.getCharacter().rotateTriangle(cursor.getX(), cursor.getY());
                        room4.setCursor(cursor.getX() - 30, cursor.getY() - 30);
                        break;
                    }
                    else if (room4.isCollidingWestWallNorthBottom()) {
                        room4.getCharacter().repositionAllYDown(room4.getWestWallNorth().getRectY(), room4.getWestWallNorth().getRectHeight());
                        room4.getCharacter().rotateTriangle(cursor.getX(), cursor.getY());
                        room4.setCursor(cursor.getX() - 30, cursor.getY() - 30);
                        break;
                    }
                case A:
                    if (!room4.isCollidingWestWallNorth() && !room4.isCollidingWestWallSouth() &&
                            !room4.isCollidingSawBladeNorthBlockBRight() && !room4.isCollidingSawBladeNorthBlockCRight() &&
                            !room4.isCollidingSawBladeNorthBlockDRight() && !room4.isCollidingSawBladeNorthBlockERight() &&
                            !room4.isCollidingSawBladeSouthBlockBRight() && !room4.isCollidingSawBladeSouthBlockCRight() &&
                            !room4.isCollidingSawBladeSouthBlockDRight() && !room4.isCollidingSawBladeSouthBlockERight() &&
                            !room4.isCollidingSouthDoorWestBlockRight() && !room4.isCollidingWestDoor()) {
                        room4.getCharacter().setAllXLeft();
                        room4.getCharacter().rotateTriangle(cursor.getX(), cursor.getY());
                        room4.setCursor(cursor.getX() - 30, cursor.getY() - 30);
                        break;
                    }
                    else if (room4.isCollidingWestWallNorth()) {
                        room4.getCharacter().repositionAllXRight(room4.getWestWallNorth().getRectX(), room4.getWestWallNorth().getRectWidth());
                        room4.getCharacter().rotateTriangle(cursor.getX(), cursor.getY());
                        room4.setCursor(cursor.getX() - 30, cursor.getY() - 30);
                        break;
                    }
                    else if (room4.isCollidingWestWallSouth()) {
                        room4.getCharacter().repositionAllXRight(room4.getWestWallSouth().getRectX(), room4.getWestWallSouth().getRectWidth());
                        room4.getCharacter().rotateTriangle(cursor.getX(), cursor.getY());
                        room4.setCursor(cursor.getX() - 30, cursor.getY() - 30);
                        break;
                    }
                    else if (room4.isCollidingSawBladeNorthBlockBRight()) {
                        room4.getCharacter().repositionAllXRight(room4.getSawBladeNorthBlockB().getRectX(), room4.getSawBladeNorthBlockB().getRectWidth());
                        room4.getCharacter().rotateTriangle(cursor.getX(), cursor.getY());
                        room4.setCursor(cursor.getX() - 30, cursor.getY() - 30);
                        break;
                    }
                    else if (room4.isCollidingSawBladeNorthBlockCRight()) {
                        room4.getCharacter().repositionAllXRight(room4.getSawBladeNorthBlockC().getRectX(), room4.getSawBladeNorthBlockC().getRectWidth());
                        room4.getCharacter().rotateTriangle(cursor.getX(), cursor.getY());
                        room4.setCursor(cursor.getX() - 30, cursor.getY() - 30);
                        break;
                    }
                    else if (room4.isCollidingSawBladeNorthBlockDRight()) {
                        room4.getCharacter().repositionAllXRight(room4.getSawBladeNorthBlockD().getRectX(), room4.getSawBladeNorthBlockD().getRectWidth());
                        room4.getCharacter().rotateTriangle(cursor.getX(), cursor.getY());
                        room4.setCursor(cursor.getX() - 30, cursor.getY() - 30);
                        break;
                    }
                    else if (room4.isCollidingSawBladeNorthBlockERight()) {
                        room4.getCharacter().repositionAllXRight(room4.getSawBladeNorthBlockE().getRectX(), room4.getSawBladeNorthBlockE().getRectWidth());
                        room4.getCharacter().rotateTriangle(cursor.getX(), cursor.getY());
                        room4.setCursor(cursor.getX() - 30, cursor.getY() - 30);
                        break;
                    }
                    else if (room4.isCollidingSawBladeSouthBlockBRight()) {
                        room4.getCharacter().repositionAllXRight(room4.getSawBladeSouthBlockB().getRectX(), room4.getSawBladeSouthBlockB().getRectWidth());
                        room4.getCharacter().rotateTriangle(cursor.getX(), cursor.getY());
                        room4.setCursor(cursor.getX() - 30, cursor.getY() - 30);
                        break;
                    }
                    else if (room4.isCollidingSawBladeSouthBlockCRight()) {
                        room4.getCharacter().repositionAllXRight(room4.getSawBladeSouthBlockC().getRectX(), room4.getSawBladeSouthBlockC().getRectWidth());
                        room4.getCharacter().rotateTriangle(cursor.getX(), cursor.getY());
                        room4.setCursor(cursor.getX() - 30, cursor.getY() - 30);
                        break;
                    }
                    else if (room4.isCollidingSawBladeSouthBlockDRight()) {
                        room4.getCharacter().repositionAllXRight(room4.getSawBladeSouthBlockD().getRectX(), room4.getSawBladeSouthBlockD().getRectWidth());
                        room4.getCharacter().rotateTriangle(cursor.getX(), cursor.getY());
                        room4.setCursor(cursor.getX() - 30, cursor.getY() - 30);
                        break;
                    }
                    else if (room4.isCollidingSawBladeSouthBlockERight()) {
                        room4.getCharacter().repositionAllXRight(room4.getSawBladeSouthBlockE().getRectX(), room4.getSawBladeSouthBlockE().getRectWidth());
                        room4.getCharacter().rotateTriangle(cursor.getX(), cursor.getY());
                        room4.setCursor(cursor.getX() - 30, cursor.getY() - 30);
                        break;
                    }
                    else if (room4.isCollidingSouthDoorWestBlockRight()) {
                        room4.getCharacter().repositionAllXRight(room4.getSouthDoorWestBlock().getRectX(), room4.getSouthDoorWestBlock().getRectWidth());
                        room4.getCharacter().rotateTriangle(cursor.getX(), cursor.getY());
                        room4.setCursor(cursor.getX() - 30, cursor.getY() - 30);
                        break;
                    }
                    else if (room4.isCollidingWestDoor()) {
                        room5.replaceHealth(room4.getHealth());
                        room5.removeLockedDoor(isRoom5PuzzleComplete);
                        if (isRoom5PuzzleComplete) {
                            room5.replaceSwitch1(blue);
                            room5.replaceSwitch2(blue);
                            room5.replaceSwitch3(blue);
                            room5.replaceSwitch4(blue);
                        }
                        else {
                            room5.replaceSwitch1(switchOff);
                            room5.replaceSwitch2(switchOn);
                            room5.replaceSwitch3(yellow);
                            room5.replaceSwitch4(blue);
                        }
                        primaryStage.setScene(room5Scene);
                        break;
                    }
                case S:
                    if (!room4.isCollidingSouthWall() && !room4.isCollidingSawBladeSouthBlockATop() &&
                            !room4.isCollidingSawBladeSouthBlockBTop() && !room4.isCollidingSawBladeSouthBlockCTop() &&
                            !room4.isCollidingSawBladeSouthBlockDTop() && !room4.isCollidingSawBladeSouthBlockETop() &&
                            !room4.isCollidingSouthDoorEastBlockTop() && !room4.isCollidingSouthDoorWestBlockTop() &&
                            !room4.isCollidingWestWallSouthTop() && !room4.isCollidingSouthDoor()) {
                        room4.getCharacter().setAllYDown();
                        room4.getCharacter().rotateTriangle(cursor.getX(), cursor.getY());
                        room4.setCursor(cursor.getX() - 30, cursor.getY() - 30);
                        break;
                    }
                    else if (room4.isCollidingSouthWall()) {
                        room4.getCharacter().repositionAllYUp(room4.getSouthWall().getRectY());
                        room4.getCharacter().rotateTriangle(cursor.getX(), cursor.getY());
                        room4.setCursor(cursor.getX() - 30, cursor.getY() - 30);
                        break;
                    }
                    else if (room4.isCollidingSawBladeSouthBlockATop()) {
                        room4.getCharacter().repositionAllYUp(room4.getSawBladeSouthBlockA().getRectY());
                        room4.getCharacter().rotateTriangle(cursor.getX(), cursor.getY());
                        room4.setCursor(cursor.getX() - 30, cursor.getY() - 30);
                        break;
                    }
                    else if (room4.isCollidingSawBladeSouthBlockBTop()) {
                        room4.getCharacter().repositionAllYUp(room4.getSawBladeSouthBlockB().getRectY());
                        room4.getCharacter().rotateTriangle(cursor.getX(), cursor.getY());
                        room4.setCursor(cursor.getX() - 30, cursor.getY() - 30);
                        break;
                    }
                    else if (room4.isCollidingSawBladeSouthBlockCTop()) {
                        room4.getCharacter().repositionAllYUp(room4.getSawBladeSouthBlockC().getRectY());
                        room4.getCharacter().rotateTriangle(cursor.getX(), cursor.getY());
                        room4.setCursor(cursor.getX() - 30, cursor.getY() - 30);
                        break;
                    }
                    else if (room4.isCollidingSawBladeSouthBlockDTop()) {
                        room4.getCharacter().repositionAllYUp(room4.getSawBladeSouthBlockD().getRectY());
                        room4.getCharacter().rotateTriangle(cursor.getX(), cursor.getY());
                        room4.setCursor(cursor.getX() - 30, cursor.getY() - 30);
                        break;
                    }
                    else if (room4.isCollidingSawBladeSouthBlockETop()) {
                        room4.getCharacter().repositionAllYUp(room4.getSawBladeSouthBlockE().getRectY());
                        room4.getCharacter().rotateTriangle(cursor.getX(), cursor.getY());
                        room4.setCursor(cursor.getX() - 30, cursor.getY() - 30);
                        break;
                    }
                    else if (room4.isCollidingSouthDoorEastBlockTop()) {
                        room4.getCharacter().repositionAllYUp(room4.getSouthDoorEastBlock().getRectY());
                        room4.getCharacter().rotateTriangle(cursor.getX(), cursor.getY());
                        room4.setCursor(cursor.getX() - 30, cursor.getY() - 30);
                        break;
                    }
                    else if (room4.isCollidingSouthDoorWestBlockTop()) {
                        room4.getCharacter().repositionAllYUp(room4.getSouthDoorWestBlock().getRectY());
                        room4.getCharacter().rotateTriangle(cursor.getX(), cursor.getY());
                        room4.setCursor(cursor.getX() - 30, cursor.getY() - 30);
                        break;
                    }
                    else if (room4.isCollidingWestWallSouthTop()) {
                        room4.getCharacter().repositionAllYUp(room4.getWestWallSouth().getRectY());
                        room4.getCharacter().rotateTriangle(cursor.getX(), cursor.getY());
                        room4.setCursor(cursor.getX() - 30, cursor.getY() - 30);
                        break;
                    }
                    else if (room4.isCollidingSouthDoor()) {
                        room3.replaceHealth(room4.getHealth());
                        room3.removeLockedDoor(isRoom2PuzzleComplete);
                        primaryStage.setScene(room3Scene);
                        break;
                    }
                case D:
                    if (!room4.isCollidingEastWall() && !room4.isCollidingSawBladeNorthBlockALeft() &&
                            !room4.isCollidingSawBladeNorthBlockBLeft() && !room4.isCollidingSawBladeNorthBlockCLeft() &&
                            !room4.isCollidingSawBladeNorthBlockDLeft() && !room4.isCollidingSawBladeNorthBlockELeft() &&
                            !room4.isCollidingSawBladeSouthBlockALeft() && !room4.isCollidingSawBladeSouthBlockBLeft() && 
                            !room4.isCollidingSawBladeSouthBlockCLeft() && !room4.isCollidingSawBladeSouthBlockDLeft() && 
                            !room4.isCollidingSouthDoorEastBlockLeft() && !room4.isCollidingSouthDoorWestBlockLeft()) {
                        room4.getCharacter().setAllXRight();
                        room4.getCharacter().rotateTriangle(cursor.getX(), cursor.getY());
                        room4.setCursor(cursor.getX() - 30, cursor.getY() - 30);
                        break;
                    }
                    else if (room4.isCollidingEastWall()) {
                        room4.getCharacter().repositionAllXLeft(room4.getEastWall().getRectX());
                        room4.getCharacter().rotateTriangle(cursor.getX(), cursor.getY());
                        room4.setCursor(cursor.getX() - 30, cursor.getY() - 30);
                        break;
                    }
                    else if (room4.isCollidingSawBladeNorthBlockALeft()) {
                        room4.getCharacter().repositionAllXLeft(room4.getSawBladeNorthBlockA().getRectX());
                        room4.getCharacter().rotateTriangle(cursor.getX(), cursor.getY());
                        room4.setCursor(cursor.getX() - 30, cursor.getY() - 30);
                        break;
                    }
                    else if (room4.isCollidingSawBladeNorthBlockBLeft()) {
                        room4.getCharacter().repositionAllXLeft(room4.getSawBladeNorthBlockB().getRectX());
                        room4.getCharacter().rotateTriangle(cursor.getX(), cursor.getY());
                        room4.setCursor(cursor.getX() - 30, cursor.getY() - 30);
                        break;
                    }
                    else if (room4.isCollidingSawBladeNorthBlockCLeft()) {
                        room4.getCharacter().repositionAllXLeft(room4.getSawBladeNorthBlockC().getRectX());
                        room4.getCharacter().rotateTriangle(cursor.getX(), cursor.getY());
                        room4.setCursor(cursor.getX() - 30, cursor.getY() - 30);
                        break;
                    }
                    else if (room4.isCollidingSawBladeNorthBlockDLeft()) {
                        room4.getCharacter().repositionAllXLeft(room4.getSawBladeNorthBlockD().getRectX());
                        room4.getCharacter().rotateTriangle(cursor.getX(), cursor.getY());
                        room4.setCursor(cursor.getX() - 30, cursor.getY() - 30);
                        break;
                    }
                    else if (room4.isCollidingSawBladeNorthBlockELeft()) {
                        room4.getCharacter().repositionAllXLeft(room4.getSawBladeNorthBlockE().getRectX());
                        room4.getCharacter().rotateTriangle(cursor.getX(), cursor.getY());
                        room4.setCursor(cursor.getX() - 30, cursor.getY() - 30);
                        break;
                    }
                    else if (room4.isCollidingSawBladeSouthBlockALeft()) {
                        room4.getCharacter().repositionAllXLeft(room4.getSawBladeSouthBlockA().getRectX());
                        room4.getCharacter().rotateTriangle(cursor.getX(), cursor.getY());
                        room4.setCursor(cursor.getX() - 30, cursor.getY() - 30);
                        break;
                    }
                    else if (room4.isCollidingSawBladeSouthBlockBLeft()) {
                        room4.getCharacter().repositionAllXLeft(room4.getSawBladeSouthBlockB().getRectX());
                        room4.getCharacter().rotateTriangle(cursor.getX(), cursor.getY());
                        room4.setCursor(cursor.getX() - 30, cursor.getY() - 30);
                        break;
                    }
                    else if (room4.isCollidingSawBladeSouthBlockCLeft()) {
                        room4.getCharacter().repositionAllXLeft(room4.getSawBladeSouthBlockC().getRectX());
                        room4.getCharacter().rotateTriangle(cursor.getX(), cursor.getY());
                        room4.setCursor(cursor.getX() - 30, cursor.getY() - 30);
                        break;
                    }
                    else if (room4.isCollidingSawBladeSouthBlockDLeft()) {
                        room4.getCharacter().repositionAllXLeft(room4.getSawBladeSouthBlockD().getRectX());
                        room4.getCharacter().rotateTriangle(cursor.getX(), cursor.getY());
                        room4.setCursor(cursor.getX() - 30, cursor.getY() - 30);
                        break;
                    }
                    else if (room4.isCollidingSouthDoorEastBlockLeft()) {
                        room4.getCharacter().repositionAllXLeft(room4.getSouthDoorEastBlock().getRectX());
                        room4.getCharacter().rotateTriangle(cursor.getX(), cursor.getY());
                        room4.setCursor(cursor.getX() - 30, cursor.getY() - 30);
                        break;
                    }
                    else if (room4.isCollidingSouthDoorWestBlockLeft()) {
                        room4.getCharacter().repositionAllXLeft(room4.getSouthDoorWestBlock().getRectX());
                        room4.getCharacter().rotateTriangle(cursor.getX(), cursor.getY());
                        room4.setCursor(cursor.getX() - 30, cursor.getY() - 30);
                        break;
                    }
                default:
                    break;
            }
        });
        
        room4.setOnMouseMoved(e -> {
            room4.getCharacter().rotateTriangle(e.getX(), e.getY());
            cursor = new Point2D(e.getX(), e.getY());
            room4.setCursor(e.getX() - 30, e.getY() - 30);
        });
        
        room4.setOnMouseClicked(e -> {
            arrowPath = new Line(room4.getCharacter().getP1X(), room4.getCharacter().getP1Y() + 30, cursor.getX(), cursor.getY());
            if (room4.getSouthDoorWestBlock().isCollidingLineRight(arrowPath.getEndX(), arrowPath.getEndY(), arrowPath.getStartX(), arrowPath.getStartY(), + 
                    room4.getSouthDoorWestBlock().getRectX(), room4.getSouthDoorWestBlock().getRectY(), + 
                            room4.getSouthDoorWestBlock().getRectWidth(), room4.getSouthDoorWestBlock().getRectHeight())) {
                arrowPath.setEndX(room4.getSouthDoorWestBlock().getRectX() + room4.getSouthDoorWestBlock().getRectWidth());
            }
            else if (room4.getSouthDoorWestBlock().isCollidingLineLeft(arrowPath.getEndX(), arrowPath.getEndY(), arrowPath.getStartX(), arrowPath.getStartY(), + 
                    room4.getSouthDoorWestBlock().getRectX(), room4.getSouthDoorWestBlock().getRectY(), + 
                            room4.getSouthDoorWestBlock().getRectWidth(), room4.getSouthDoorWestBlock().getRectHeight())) {
                arrowPath.setEndX(room4.getSouthDoorWestBlock().getRectX());
            }
            else if (room4.getSouthDoorWestBlock().isCollidingLineTop(arrowPath.getEndX(), arrowPath.getEndY(), arrowPath.getStartX(), arrowPath.getStartY(), + 
                    room4.getSouthDoorWestBlock().getRectX(), room4.getSouthDoorWestBlock().getRectY(), + 
                            room4.getSouthDoorWestBlock().getRectWidth(), room4.getSouthDoorWestBlock().getRectHeight())) {
                arrowPath.setEndY(room4.getSouthDoorWestBlock().getRectY());
            }
            
            room4.shootArrow(arrowPath);
        });
        
        room4.requestFocus();
        
        //SawBlade collision
        Timeline checkSawBladeA = new Timeline(new KeyFrame(Duration.millis(50), e -> {
            if (room4.isCollidingSawBladeA()) {
                if (room4ToRoom5) {
                    room4.getCharacter().resetPosition(room4.getXWest(), room4.getYWest());
                }
                else {
                    room4.getCharacter().resetPosition(room4.getXSouth(), room4.getYSouth());
                }
                
                if (room4.getHealth() == full) {
                    room4.replaceHealth(two);
                }
                else if (room4.getHealth() == two) {
                    room4.replaceHealth(one);
                }
                else if (room4.getHealth() == one) {
                    room4.replaceHealth(empty);
                }
            }
        }));
        checkSawBladeA.setCycleCount(Timeline.INDEFINITE);
        checkSawBladeA.play();
        Timeline checkSawBladeB = new Timeline(new KeyFrame(Duration.millis(50), e -> {
            if (room4.isCollidingSawBladeB()) {
                room4.getCharacter().resetPosition(room4.getXSouth(), room4.getYSouth());
                if (room4.getHealth() == full) {
                    room4.replaceHealth(two);
                }
                else if (room4.getHealth() == two) {
                    room4.replaceHealth(one);
                }
                else if (room4.getHealth() == one) {
                    room4.replaceHealth(empty);
                }
            }
        }));
        checkSawBladeB.setCycleCount(Timeline.INDEFINITE);
        checkSawBladeB.play();
        Timeline checkSawBladeC = new Timeline(new KeyFrame(Duration.millis(50), e -> {
            if (room4.isCollidingSawBladeC()) {
                room4.getCharacter().resetPosition(room4.getXSouth(), room4.getYSouth());
                if (room4.getHealth() == full) {
                    room4.replaceHealth(two);
                }
                else if (room4.getHealth() == two) {
                    room4.replaceHealth(one);
                }
                else if (room4.getHealth() == one) {
                    room4.replaceHealth(empty);
                }
            }
        }));
        checkSawBladeC.setCycleCount(Timeline.INDEFINITE);
        checkSawBladeC.play();
        Timeline checkSawBladeD = new Timeline(new KeyFrame(Duration.millis(50), e -> {
                if (room4.isCollidingSawBladeD()) {
                room4.getCharacter().resetPosition(room4.getXSouth(), room4.getYSouth());
                if (room4.getHealth() == full) {
                    room4.replaceHealth(two);
                }
                else if (room4.getHealth() == two) {
                    room4.replaceHealth(one);
                }
                else if (room4.getHealth() == one) {
                    room4.replaceHealth(empty);
                }
            }
        }));
        checkSawBladeD.setCycleCount(Timeline.INDEFINITE);
        checkSawBladeD.play();
        
        //Room5 movement and shooting
        room5.setOnKeyPressed(e -> {
            switch (e.getCode()) {
                case W:
                    if (!room5.isCollidingNorthWall() && !room5.isCollidingEastDoorNorthBlockBottom() && 
                            !room5.isCollidingEastDoorSouthBlockBottom() && !room5.isCollidingNorthDoorEastBlockBottom() && 
                            !room5.isCollidingNorthDoorWestBlockBottom() && !room5.isCollidingSwitch1Bottom() && 
                            !room5.isCollidingSwitch2Bottom() && !room5.isCollidingSwitch3Bottom() && 
                            !room5.isCollidingSwitch4Bottom() && !room5.isCollidingLockedDoor() && 
                            !room5.isCollidingNorthDoor()) {
                        room5.getCharacter().setAllYUp();
                        room5.getCharacter().rotateTriangle(cursor.getX(), cursor.getY());
                        room5.setCursor(cursor.getX() - 30, cursor.getY() - 30);
                        break;
                    }
                    else if (room5.isCollidingNorthWall()) {
                        room5.getCharacter().repositionAllYDown(room5.getNorthWall().getRectY(), room5.getNorthWall().getRectHeight());
                        room5.getCharacter().rotateTriangle(cursor.getX(), cursor.getY());
                        room5.setCursor(cursor.getX() - 30, cursor.getY() - 30);
                        break;
                    }
                    else if (room5.isCollidingEastDoorNorthBlockBottom()) {
                        room5.getCharacter().repositionAllYDown(room5.getEastDoorNorthBlock().getRectY(), room5.getEastDoorNorthBlock().getRectHeight());
                        room5.getCharacter().rotateTriangle(cursor.getX(), cursor.getY());
                        room5.setCursor(cursor.getX() - 30, cursor.getY() - 30);
                        break;
                    }
                    else if (room5.isCollidingEastDoorSouthBlockBottom()) {
                        room5.getCharacter().repositionAllYDown(room5.getEastDoorSouthBlock().getRectY(), room5.getEastDoorSouthBlock().getRectHeight());
                        room5.getCharacter().rotateTriangle(cursor.getX(), cursor.getY());
                        room5.setCursor(cursor.getX() - 30, cursor.getY() - 30);
                        break;
                    }
                    else if (room5.isCollidingNorthDoorEastBlockBottom()) {
                        room5.getCharacter().repositionAllYDown(room5.getNorthDoorEastBlock().getRectY(), room5.getNorthDoorEastBlock().getRectHeight());
                        room5.getCharacter().rotateTriangle(cursor.getX(), cursor.getY());
                        room5.setCursor(cursor.getX() - 30, cursor.getY() - 30);
                        break;
                    }
                    else if (room5.isCollidingNorthDoorWestBlockBottom()) {
                        room5.getCharacter().repositionAllYDown(room5.getNorthDoorWestBlock().getRectY(), room5.getNorthDoorWestBlock().getRectHeight());
                        room5.getCharacter().rotateTriangle(cursor.getX(), cursor.getY());
                        room5.setCursor(cursor.getX() - 30, cursor.getY() - 30);
                        break;
                    }
                    else if (room5.isCollidingSwitch1Bottom()) {
                        room5.getCharacter().repositionAllYDown(room5.getSwitch1Hitbox().getRectY(), room5.getSwitch1Hitbox().getRectHeight());
                        room5.getCharacter().rotateTriangle(cursor.getX(), cursor.getY());
                        room5.setCursor(cursor.getX() - 30, cursor.getY() - 30);
                        break;
                    }
                    else if (room5.isCollidingSwitch2Bottom()) {
                        room5.getCharacter().repositionAllYDown(room5.getSwitch2Hitbox().getRectY(), room5.getSwitch2Hitbox().getRectHeight());
                        room5.getCharacter().rotateTriangle(cursor.getX(), cursor.getY());
                        room5.setCursor(cursor.getX() - 30, cursor.getY() - 30);
                        break;
                    }
                    else if (room5.isCollidingSwitch3Bottom()) {
                        room5.getCharacter().repositionAllYDown(room5.getSwitch3Hitbox().getRectY(), room5.getSwitch3Hitbox().getRectHeight());
                        room5.getCharacter().rotateTriangle(cursor.getX(), cursor.getY());
                        room5.setCursor(cursor.getX() - 30, cursor.getY() - 30);
                        break;
                    }
                    else if (room5.isCollidingSwitch4Bottom()) {
                        room5.getCharacter().repositionAllYDown(room5.getSwitch4Hitbox().getRectY(), room5.getSwitch4Hitbox().getRectHeight());
                        room5.getCharacter().rotateTriangle(cursor.getX(), cursor.getY());
                        room5.setCursor(cursor.getX() - 30, cursor.getY() - 30);
                        break;
                    }
                    else if (room5.isCollidingLockedDoor()) {
                        if (!isRoom5PuzzleComplete) {
                            room5.getCharacter().repositionAllYDown(room5.getLockedDoor().getRectY(), room5.getLockedDoor().getRectHeight());
                            room5.getCharacter().rotateTriangle(cursor.getX(), cursor.getY());
                            room5.setCursor(cursor.getX() - 30, cursor.getY() - 30);
                            break;
                        }
                    }
                    else if (room5.isCollidingNorthDoor()) {
                        primaryStage.setScene(underConScene);
                    }
                case A:
                    if (!room5.isCollidingWestWall() && !room5.isCollidingNorthDoorEastBlockRight() && 
                            !room5.isCollidingNorthDoorWestBlockRight() && !room5.isCollidingSwitch1Right() &&
                            !room5.isCollidingSwitch2Right() && !room5.isCollidingSwitch3Right() &&
                            !room5.isCollidingSwitch4Right()) {
                        room5.getCharacter().setAllXLeft();
                        room5.getCharacter().rotateTriangle(cursor.getX(), cursor.getY());
                        room5.setCursor(cursor.getX() - 30, cursor.getY() - 30);
                        break;
                    }
                    else if (room5.isCollidingWestWall()) {
                        room5.getCharacter().repositionAllXRight(room5.getWestWall().getRectX(), room5.getWestWall().getRectWidth());
                        room5.getCharacter().rotateTriangle(cursor.getX(), cursor.getY());
                        room5.setCursor(cursor.getX() - 30, cursor.getY() - 30);
                        break;
                    }
                    else if (room5.isCollidingNorthDoorEastBlockRight()) {
                        room5.getCharacter().repositionAllXRight(room5.getNorthDoorEastBlock().getRectX(), room5.getNorthDoorEastBlock().getRectWidth());
                        room5.getCharacter().rotateTriangle(cursor.getX(), cursor.getY());
                        room5.setCursor(cursor.getX() - 30, cursor.getY() - 30);
                        break;
                    }
                    else if (room5.isCollidingNorthDoorWestBlockRight()) {
                        room5.getCharacter().repositionAllXRight(room5.getNorthDoorWestBlock().getRectX(), room5.getNorthDoorWestBlock().getRectWidth());
                        room5.getCharacter().rotateTriangle(cursor.getX(), cursor.getY());
                        room5.setCursor(cursor.getX() - 30, cursor.getY() - 30);
                        break;
                    }
                    else if (room5.isCollidingSwitch1Right()) {
                        room5.getCharacter().repositionAllXRight(room5.getSwitch1Hitbox().getRectX(), room5.getSwitch1Hitbox().getRectWidth());
                        room5.getCharacter().rotateTriangle(cursor.getX(), cursor.getY());
                        room5.setCursor(cursor.getX() - 30, cursor.getY() - 30);
                        break;
                    }
                    else if (room5.isCollidingSwitch2Right()) {
                        room5.getCharacter().repositionAllXRight(room5.getSwitch2Hitbox().getRectX(), room5.getSwitch2Hitbox().getRectWidth());
                        room5.getCharacter().rotateTriangle(cursor.getX(), cursor.getY());
                        room5.setCursor(cursor.getX() - 30, cursor.getY() - 30);
                        break;
                    }
                    else if (room5.isCollidingSwitch3Right()) {
                        room5.getCharacter().repositionAllXRight(room5.getSwitch3Hitbox().getRectX(), room5.getSwitch3Hitbox().getRectWidth());
                        room5.getCharacter().rotateTriangle(cursor.getX(), cursor.getY());
                        room5.setCursor(cursor.getX() - 30, cursor.getY() - 30);
                        break;
                    }
                    else if (room5.isCollidingSwitch4Right()) {
                        room5.getCharacter().repositionAllXRight(room5.getSwitch4Hitbox().getRectX(), room5.getSwitch4Hitbox().getRectWidth());
                        room5.getCharacter().rotateTriangle(cursor.getX(), cursor.getY());
                        room5.setCursor(cursor.getX() - 30, cursor.getY() - 30);
                        break;
                    }
                case S:
                    if (!room5.isCollidingSouthWall() && !room5.isCollidingEastDoorNorthBlockTop() && 
                            !room5.isCollidingEastDoorSouthBlockTop() && !room5.isCollidingSwitch1Top() && 
                            !room5.isCollidingSwitch2Top() && !room5.isCollidingSwitch3Top() &&
                            !room5.isCollidingSwitch4Top()) {
                        room5.getCharacter().setAllYDown();
                        room5.getCharacter().rotateTriangle(cursor.getX(), cursor.getY());
                        room5.setCursor(cursor.getX() - 30, cursor.getY() - 30);
                        break;
                    }
                    else if (room5.isCollidingSouthWall()) {
                        room5.getCharacter().repositionAllYUp(room5.getSouthWall().getRectY());
                        room5.getCharacter().rotateTriangle(cursor.getX(), cursor.getY());
                        room5.setCursor(cursor.getX() - 30, cursor.getY() - 30);
                        System.out.println("Hit SouthWall");
                        break;
                    }
                    else if (room5.isCollidingEastDoorNorthBlockTop()) {
                        room5.getCharacter().repositionAllYUp(room5.getEastDoorNorthBlock().getRectY());
                        room5.getCharacter().rotateTriangle(cursor.getX(), cursor.getY());
                        room5.setCursor(cursor.getX() - 30, cursor.getY() - 30);
                        break;
                    }
                    else if (room5.isCollidingEastDoorSouthBlockTop()) {
                        room5.getCharacter().repositionAllYUp(room5.getEastDoorSouthBlock().getRectY());
                        room5.getCharacter().rotateTriangle(cursor.getX(), cursor.getY());
                        room5.setCursor(cursor.getX() - 30, cursor.getY() - 30);
                        break;
                    }
                    else if (room5.isCollidingSwitch1Top()) {
                        room5.getCharacter().repositionAllYUp(room5.getSwitch1Hitbox().getRectY());
                        room5.getCharacter().rotateTriangle(cursor.getX(), cursor.getY());
                        room5.setCursor(cursor.getX() - 30, cursor.getY() - 30);
                        break;
                    }
                    else if (room5.isCollidingSwitch2Top()) {
                        room5.getCharacter().repositionAllYUp(room5.getSwitch2Hitbox().getRectY());
                        room5.getCharacter().rotateTriangle(cursor.getX(), cursor.getY());
                        room5.setCursor(cursor.getX() - 30, cursor.getY() - 30);
                        break;
                    }
                    else if (room5.isCollidingSwitch3Top()) {
                        room5.getCharacter().repositionAllYUp(room5.getSwitch3Hitbox().getRectY());
                        room5.getCharacter().rotateTriangle(cursor.getX(), cursor.getY());
                        room5.setCursor(cursor.getX() - 30, cursor.getY() - 30);
                        break;
                    }
                    else if (room5.isCollidingSwitch4Top()) {
                        room5.getCharacter().repositionAllYUp(room5.getSwitch4Hitbox().getRectY());
                        room5.getCharacter().rotateTriangle(cursor.getX(), cursor.getY());
                        room5.setCursor(cursor.getX() - 30, cursor.getY() - 30);
                        break;
                    }
                case D:
                    if (!room5.isCollidingEastWall() && !room5.isCollidingEastDoorNorthBlockLeft() && 
                            !room5.isCollidingEastDoorSouthBlockLeft() && !room5.isCollidingNorthDoorEastBlockLeft() &&
                            !room5.isCollidingNorthDoorWestBlockLeft() && !room5.isCollidingSwitch1Left() && 
                            !room5.isCollidingSwitch2Left() && !room5.isCollidingSwitch3Left() && 
                            !room5.isCollidingSwitch4Left() && !room5.isCollidingEastDoor()) {
                        room5.getCharacter().setAllXRight();
                        room5.getCharacter().rotateTriangle(cursor.getX(), cursor.getY());
                        room5.setCursor(cursor.getX() - 30, cursor.getY() - 30);
                        break;
                    }
                    else if (room5.isCollidingEastWall()) {
                        room5.getCharacter().repositionAllXLeft(room5.getEastWall().getRectX());
                        room5.getCharacter().rotateTriangle(cursor.getX(), cursor.getY());
                        room5.setCursor(cursor.getX() - 30, cursor.getY() - 30);
                        break;
                    }
                    else if (room5.isCollidingEastDoorNorthBlockLeft()) {
                        room5.getCharacter().repositionAllXLeft(room5.getEastDoorNorthBlock().getRectX());
                        room5.getCharacter().rotateTriangle(cursor.getX(), cursor.getY());
                        room5.setCursor(cursor.getX() - 30, cursor.getY() - 30);
                        break;
                    }
                    else if (room5.isCollidingEastDoorSouthBlockLeft()) {
                        room5.getCharacter().repositionAllXLeft(room5.getEastDoorSouthBlock().getRectX());
                        room5.getCharacter().rotateTriangle(cursor.getX(), cursor.getY());
                        room5.setCursor(cursor.getX() - 30, cursor.getY() - 30);
                        break;
                    }
                    else if (room5.isCollidingNorthDoorEastBlockLeft()) {
                        room5.getCharacter().repositionAllXLeft(room5.getNorthDoorEastBlock().getRectX());
                        room5.getCharacter().rotateTriangle(cursor.getX(), cursor.getY());
                        room5.setCursor(cursor.getX() - 30, cursor.getY() - 30);
                        break;
                    }
                    else if (room5.isCollidingNorthDoorWestBlockLeft()) {
                        room5.getCharacter().repositionAllXLeft(room5.getNorthDoorWestBlock().getRectX());
                        room5.getCharacter().rotateTriangle(cursor.getX(), cursor.getY());
                        room5.setCursor(cursor.getX() - 30, cursor.getY() - 30);
                        break;
                    }
                    else if (room5.isCollidingSwitch1Left()) {
                        room5.getCharacter().repositionAllXLeft(room5.getSwitch1Hitbox().getRectX());
                        room5.getCharacter().rotateTriangle(cursor.getX(), cursor.getY());
                        room5.setCursor(cursor.getX() - 30, cursor.getY() - 30);
                        break;
                    }
                    else if (room5.isCollidingSwitch2Left()) {
                        room5.getCharacter().repositionAllXLeft(room5.getSwitch2Hitbox().getRectX());
                        room5.getCharacter().rotateTriangle(cursor.getX(), cursor.getY());
                        room5.setCursor(cursor.getX() - 30, cursor.getY() - 30);
                        break;
                    }
                    else if (room5.isCollidingSwitch3Left()) {
                        room5.getCharacter().repositionAllXLeft(room5.getSwitch3Hitbox().getRectX());
                        room5.getCharacter().rotateTriangle(cursor.getX(), cursor.getY());
                        room5.setCursor(cursor.getX() - 30, cursor.getY() - 30);
                        break;
                    }
                    else if (room5.isCollidingSwitch4Left()) {
                        room5.getCharacter().repositionAllXLeft(room5.getSwitch4Hitbox().getRectX());
                        room5.getCharacter().rotateTriangle(cursor.getX(), cursor.getY());
                        room5.setCursor(cursor.getX() - 30, cursor.getY() - 30);
                        break;
                    }
                    else if (room5.isCollidingEastDoor()) {
                        room4ToRoom5 = true;
                        room4.replaceHealth(room5.getHealth());
                        primaryStage.setScene(room4Scene);
                    }
                default:
                    break;
            }
        });
        
        room5.setOnMouseMoved(e -> {
            room5.getCharacter().rotateTriangle(e.getX(), e.getY());
            cursor = new Point2D(e.getX(), e.getY());
            room5.setCursor(e.getX() - 30, e.getY() - 30);
        });
        
        room5.setOnMouseClicked(e -> {
            arrowPath = new Line(room5.getCharacter().getP1X(), room5.getCharacter().getP1Y() + 30, cursor.getX(), cursor.getY());
            if (!isRoom5PuzzleComplete) {
                if (room5.getSwitch1Hitbox().isColliding(cursor.getX(), cursor.getY())) {
                    if (room5.getSwitch1() == switchOff) {
                        room5.replaceSwitch1(switchOn);
                    }
                    else if (room5.getSwitch1() == switchOn) {
                        room5.replaceSwitch1(yellow);
                    }
                    else if (room5.getSwitch1() == yellow) {
                        room5.replaceSwitch1(blue);
                    }
                    else if (room5.getSwitch1() == blue) {
                        room5.replaceSwitch1(switchOff);
                    }
                }
                else if (room5.getSwitch2Hitbox().isColliding(cursor.getX(), cursor.getY())) {
                    if (room5.getSwitch2() == switchOff) {
                        room5.replaceSwitch2(switchOn);
                    }
                    else if (room5.getSwitch2() == switchOn) {
                        room5.replaceSwitch2(yellow);
                    }
                    else if (room5.getSwitch2() == yellow) {
                        room5.replaceSwitch2(blue);
                    }
                    else if (room5.getSwitch2() == blue) {
                        room5.replaceSwitch2(switchOff);
                    }
                }
                else if (room5.getSwitch3Hitbox().isColliding(cursor.getX(), cursor.getY())) {
                    if (room5.getSwitch3() == switchOff) {
                        room5.replaceSwitch3(switchOn);
                    }
                    else if (room5.getSwitch3() == switchOn) {
                        room5.replaceSwitch3(yellow);
                    }
                    else if (room5.getSwitch3() == yellow) {
                        room5.replaceSwitch3(blue);
                    }
                    else if (room5.getSwitch3() == blue) {
                        room5.replaceSwitch3(switchOff);
                    }
                }
                else if (room5.getSwitch4Hitbox().isColliding(cursor.getX(), cursor.getY())) {
                    if (room5.getSwitch4() == switchOff) {
                        room5.replaceSwitch4(switchOn);
                    }
                    else if (room5.getSwitch4() == switchOn) {
                        room5.replaceSwitch4(yellow);
                    }
                    else if (room5.getSwitch4() == yellow) {
                        room5.replaceSwitch4(blue);
                    }
                    else if (room5.getSwitch4() == blue) {
                        room5.replaceSwitch4(switchOff);
                    }
                }
                
                if (room5.getSwitch1() == blue && room5.getSwitch2() == blue && 
                        room5.getSwitch3() == blue && room5.getSwitch4() == blue) {
                    isRoom5PuzzleComplete = true;
                    room5.removeLockedDoor(isRoom5PuzzleComplete);
                }
            }
            
            room5.shootArrow(arrowPath);
        });
        
        room5.requestFocus();
        
        //Game Over screen
        gameOver.setOnMouseClicked(e -> {
            room4.replaceHealth(full);
            beginningRoom.getCharacter().resetPosition(960, 830);
            beginningRoom.setCursor(930, 470);
            beginningRoom.getCharacter().rotateTriangle(cursor.getX(), cursor.getY());
            beginningRoom.replaceHealth(full);
            room2.replaceHealth(full);
            room3.replaceHealth(full);
            primaryStage.setScene(beginningScene);
        });
        
        //UnderCon screen
        underCon.setOnMouseClicked(e -> {
            beginningRoom.getCharacter().resetPosition(960, 830);
            beginningRoom.setCursor(930, 470);
            beginningRoom.getCharacter().rotateTriangle(cursor.getX(), cursor.getY());
            beginningRoom.replaceHealth(full);
            room2.replaceHealth(full);
            room3.replaceHealth(full);
            room4.replaceHealth(full);
            room5.replaceHealth(full);
            isRoom2PuzzleComplete = false;
            isRoom5PuzzleComplete = false;
            room4ToRoom5 = false;
            primaryStage.setScene(homeScene);
        });
        
        //Home Screen
        home.setOnMouseClicked(e -> {
            if (home.getButtonBox().isColliding(cursor.getX(), cursor.getY())) {
                primaryStage.setScene(beginningScene);
            }
        });
        
        home.setOnMouseMoved(e -> {
            cursor = new Point2D(e.getX(), e.getY());
        });
    }
    
    /**
     * This method launches the primaryStage.
     * @param args What is launched
     */
    //To lanch the stage
    public static void main(String[] args) {
        launch(args);
    }
}
