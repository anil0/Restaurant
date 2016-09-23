package Alerts;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Created by anil on 12/06/2016.
 */
public class Alert
{
    public static void display( String title, String message )
    {
        Stage window2 = new Stage();

        window2.initModality( Modality.APPLICATION_MODAL ); //focus on this window
        window2.setTitle( title );
        window2.setMinWidth( 250 );

        Label label = new Label();
        label.setText( message );

        Button closeButton = new Button( "close this window" );
        closeButton.setOnAction( e -> window2.close() ); //.close closes window.

        VBox layout = new VBox( 10 ); //need layout for button to sit on
        layout.getChildren().addAll( label, closeButton );
        layout.setAlignment( Pos.CENTER ); //center layout

        Scene scene = new Scene( layout, 200,100 );
        window2.setScene( scene );
        window2.showAndWait(); //display window and wait for it to be closed
    }
}
