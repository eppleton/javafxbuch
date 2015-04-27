/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.javafxbuch.tweetalot;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.OverrunStyle;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import twitter4j.Status;
import twitter4j.User;

/**
 *
 * @author antonepple
 */
public class StatusView extends HBox {

    private Status status;
    private final ImageView profileImage;
    private final VBox textBox;
    private final Label screenName;
    private final Label statusText;
    private VBox toolbar;

    public StatusView() {
        setPadding(new Insets(4));
        setSpacing(6);
        profileImage = new ImageView();
        screenName = new Label();
        screenName.getStyleClass().add("screen-name");
        statusText = new Label();
        statusText.setWrapText(true);
        statusText.setTextOverrun(OverrunStyle.WORD_ELLIPSIS);
        textBox = new VBox();
        textBox.getStyleClass().add("textbox");
        textBox.getChildren().addAll(screenName, statusText);
        HBox.setHgrow(textBox, Priority.ALWAYS);
        Text retweet = new Text("\uf079");
        retweet.setFont(Font.font("FontAwesome", 12));
        Text reply = new Text("\uf112");
        reply.setFont(Font.font("FontAwesome", 12));
        Text fav = new Text("\uf123");
        fav.setFont(Font.font("FontAwesome", 12));
        toolbar = new VBox(retweet, reply, fav);
        getChildren().addAll(profileImage, textBox, toolbar);
    }

    public void setStatus(Status status) {
        if (this.status == null || this.status != status) {
            User user = status.getUser();
            screenName.setText(user.getName());
            statusText.setText(status.getText());
            String miniProfileImageURL = user.getBiggerProfileImageURL();
            Image image = new Image(miniProfileImageURL);
            profileImage.setImage(image);
            this.status = status;
        }
    }

}
