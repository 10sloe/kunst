import javafx.application.Application;

import javafx.stage.Stage;
import javafx.scene.Scene;

import javafx.scene.layout.*;
import javafx.scene.control.*;

import javafx.geometry.Insets;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.geometry.Pos;

// Zum Speichern
import javax.imageio.ImageIO;
import java.io.*;
import javafx.scene.image.*;
import java.awt.image.BufferedImage;
import javafx.embed.swing.SwingFXUtils;

/**
 * Hauptanwendung
 */

public class App extends Application {

    public void start(Stage stage)
    {
        Canvas canvas = new Canvas(800, 600);         // Zeichenfläche
        GraphicsContext gc = canvas.getGraphicsContext2D(); // Graphikkontext der Zeichenfläche

        Skizze skizze = new Skizze(gc);     //Meine Zeichnung!

        // Oberfläche zusammenbauen
        Pane root = new Pane();  

        root.getChildren().addAll(canvas);
       
        
        // Fenster
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Meine Skizze");
        stage.show();

        // Bild speichern
        
        speichern(canvas);

    }
    public static void main(String[] args) {
        Application.launch(args);
    }
    
    public void speichern(Canvas zeichnung)
    {
        WritableImage wim = new WritableImage(800,600);
        zeichnung.snapshot(null,wim);
        String dateiname = "bild.png";   
          
        File file = new File(dateiname);
        try{
            ImageIO.write(SwingFXUtils.fromFXImage(wim,null), "png", file);}
        catch (Exception ex)
        {}
    }

}
