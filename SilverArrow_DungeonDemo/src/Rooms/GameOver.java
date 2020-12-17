/*
 * Author: Kaden Payne
 * Date: 12/16/2020
 * Game Over screen
 */
package Rooms;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

/**
 * This is the game over screen for when you lose all of your health
 * @author kjpay
 */
public final class GameOver extends Pane {
    private Image gameOver;
    private ImageView viewGameOver;
    
    /**
     * This constructs the game over screen
     */
    public GameOver() {
        this.drawGameOver();
    }
    
    /**
     * This method shows the game over screen
     */
    public void drawGameOver() {
        gameOver = new Image("RoomsGraphics/GameOver.jpg");
        viewGameOver = new ImageView(gameOver);
        viewGameOver.setX(0);
        viewGameOver.setY(0);
        
        this.getChildren().add(viewGameOver);
    }
}
