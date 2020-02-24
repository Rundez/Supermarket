package Jframe;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;



public class JFX extends Application {
    private int height = 800;
    private int lenght = 800;
    @Override
    public void start(Stage stage) throws Exception {
        Rectangle kasse = new Rectangle();
        kasse.setX(250);
        kasse.setY(50);
        kasse.setWidth(200);
        kasse.setHeight(50);
        kasse.setFill(Color.BURLYWOOD);

        Rectangle kasApp = new Rectangle();
        kasApp.setHeight(25);
        kasApp.setWidth(30);
        kasApp.setX(300);
        kasApp.setY(50);
        kasApp.setFill(Color.GRAY);

        Rectangle hylle1 = new Rectangle();
        hylle1.setX(150);
        hylle1.setY(400);
        hylle1.setWidth(50);
        hylle1.setHeight(200);
        hylle1.setFill(Color.GRAY);

        Rectangle hylle2 = new Rectangle();
        hylle2.setX(150);
        hylle2.setY(150);
        hylle2.setWidth(50);
        hylle2.setHeight(200);
        hylle2.setFill(Color.GRAY);

        Rectangle hylle3 = new Rectangle();
        hylle3.setX(500);
        hylle3.setY(150);
        hylle3.setWidth(50);
        hylle3.setHeight(200);
        hylle3.setFill(Color.GRAY);

        Rectangle hylle4 = new Rectangle();
        hylle4.setX(500);
        hylle4.setY(400);
        hylle4.setWidth(50);
        hylle4.setHeight(200);
        hylle4.setFill(Color.GRAY);

        Group root = new Group();
        root.getChildren().addAll(kasse,kasApp,hylle1,hylle2,hylle3,hylle4);
        Scene scene = new Scene(root,height,lenght);
        stage.setTitle("Supermarket");
        stage.setScene(scene);
        stage.show();

    }
}
