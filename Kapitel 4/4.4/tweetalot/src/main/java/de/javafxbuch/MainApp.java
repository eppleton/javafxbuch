package de.javafxbuch;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;
import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

public class MainApp extends Application {

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        ListView<Status> listView = new ListView<>();
        listView.setCellFactory(new Callback<ListView<Status>, ListCell<Status>>() {
            @Override
            public ListCell<Status> call(ListView<Status> param) {
                ListCell<Status> statusCell = new ListCell<Status>() {

                    Text text = new Text();
                    {
                        text.wrappingWidthProperty().bind(param.widthProperty().subtract(30));
                        prefWidthProperty().bind(param.widthProperty().subtract(30));
                    }

                    @Override
                    protected void updateItem(Status item, boolean empty
                    ) {
                        super.updateItem(item, empty);
                        setText("");
                        setGraphic(text);
                        if (!empty) {
                            text.setText(item.getText());
                        }
                    }
                };
                return statusCell;
            }
        }
        );
        try {
            Twitter twitter = TwitterFactory.getSingleton();
            ResponseList<Status> homeTimeline = twitter.getHomeTimeline();
            homeTimeline.stream().forEach((status) -> {
                listView.getItems().add(status);
            });
        } catch (TwitterException ex) {
            Logger.getLogger(MainApp.class.getName())
                    .log(Level.SEVERE, null, ex);
        }

        

        stage.setScene(
                new Scene(listView));
        stage.setTitle(
                "Tweetalot");
        stage.show();
    }

}
