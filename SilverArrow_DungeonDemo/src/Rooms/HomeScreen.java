/*
 * Author: Kaden Payne
 * Date: 12/17/2020
 * Home Screen of demo
 */
package Rooms;

import Object.ObjectPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

/**
 * This is the home screen of the demo
 * @author kjpay
 */
public class HomeScreen extends Pane {
    private Image home;
    private ImageView viewHome;
    private ObjectPane buttonBox;
    
    /**
     * This constructs the home screen of the demo
     */
    public HomeScreen() {
        home = new Image("RoomsGraphics/HomeScreen.jpg");
        viewHome = new ImageView(home);
        viewHome.setX(0);
        viewHome.setY(0);
        buttonBox = new ObjectPane(668, 519, 586, 102);
        
        this.getChildren().add(viewHome);
    }
    
    /**
     * This method allows button box to be clicked on
     * @return buttonBox
     */
    public ObjectPane getButtonBox() {
        return this.buttonBox;
    }
}
