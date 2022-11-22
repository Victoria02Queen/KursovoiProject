package com.example.vic8;

import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class UserCell extends ListCell<User> {
    @Override
    protected void updateItem(User user, boolean empty){
        super.updateItem(user, empty);

        if (user != null){
            try {
                FileInputStream fileInputStream = new FileInputStream("/Users/viktoriakoroleva/IdeaProjects/vic8/src/main/java/img/mor705.png");
                Image image = new Image(fileInputStream);
                ImageView imageView = new ImageView(image);
                imageView.setFitHeight(30);
                imageView.setFitWidth(30);

                HBox hBox = new HBox();
                Label loginLabel = new Label();
                loginLabel.setText(user.getLogin());
                hBox.getChildren().add(imageView);
                setGraphic(hBox);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
