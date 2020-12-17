/*
 * Author: Kaden Payne
 * Date: 12/17/2020
 * Because I didn't finish all the rooms
 */
package Rooms;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

/**
 * This is because I didn't finish all the rooms
 * @author kjpay
 */
public class UnderConstruction extends Pane {
    private Image underCon;
    private ImageView viewUnderCon;
    
    /**
     * This constructs the fact that I didn't finish the dungeon
     */
    public UnderConstruction() {
        underCon = new Image("RoomsGraphics/UnderConstruction.jpg");
        viewUnderCon = new ImageView(underCon);
        viewUnderCon.setX(0);
        viewUnderCon.setY(0);
        
        this.getChildren().add(viewUnderCon);
    }
}
