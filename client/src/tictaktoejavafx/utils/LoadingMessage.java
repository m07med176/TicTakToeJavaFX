package tictaktoejavafx.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class LoadingMessage {    
   Alert alert;//;=new Alert(Alert.AlertType.NONE);
    public void display(String text) throws FileNotFoundException{
        alert=new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Please Wait");
        alert.setHeaderText(null);
        alert.setContentText(text);
        setImage();
        alert.showAndWait();
    }
    
    public  void close(){
        alert.close(); 
    }
    
    public void setImage() throws FileNotFoundException{
        Image image=new Image(new FileInputStream("src/tictaktoejavafx/assets/images/loading-loading-forever.gif"));
        ImageView view=new ImageView(image);
        view.setFitWidth(50);
        view.setFitHeight(50);
        alert.setGraphic(view);
        
    }
    
    
}
