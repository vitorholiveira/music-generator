package com.example.projeto_tcp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HomeApplication extends Application {

    // CONSTANTS
    public static final String HOME_PATH = "home-view.fxml";
    public static final String EDITION_PATH = "edition-view.fxml";
    public static final String PERSONALIZE_PATH = "personalize-view.fxml";
    public static final String LISTEN_PATH = "listen-view.fxml";

    public static final String WINDOW_TITLE = "Music Generator";

    public static final int WINDOW_WIDTH = 1280;
    public static final int WINDOW_HEIGHT = 720;

    // CURRENTLY STAGE AND SCENES DECLARATION
    private static Stage stage;
    private static Scene homeScene;
    private static Scene personalizeScene;
    private static Scene editionScene;
    private static Scene listenScene;

    private static String text;

    private static MusicSettings defaultSettings;
    private static Music music;
    private static MusicPlayer player;

    public static void createMusic() {
        if (text!=null && defaultSettings!=null){
            music = new Music(defaultSettings, text);
        }
    }

    public static Music getMusic() {
        return music;
    }

    public static MusicPlayer getMusicPlayer() {
        return player;
    }

    public static void createPlayer() {
        if (music!=null) {
            HomeApplication.player = new MusicPlayer(music);
        }
    }

    public static MusicSettings getMusicSettings() {
        return defaultSettings;
    }

    public static void setMusicSettings(int bpm, String firstInstrument, int volume) {
        HomeApplication.defaultSettings = new MusicSettings(bpm, firstInstrument, volume, 5);
    }

    // INITIALIZATION
    @Override
    public void start(Stage primaryStage) throws IOException {

        stage = primaryStage;

        // LOAD THE HOME PAGE

        FXMLLoader fxmlLoaderHome = new FXMLLoader(HomeApplication.class.getResource(HOME_PATH));
        homeScene = new Scene(fxmlLoaderHome.load(), WINDOW_WIDTH, WINDOW_HEIGHT);

        // LOAD THE EDITION PAGE

        FXMLLoader fxmlLoaderEdition = new FXMLLoader(HomeApplication.class.getResource(EDITION_PATH));
        editionScene = new Scene(fxmlLoaderEdition.load(), WINDOW_WIDTH, WINDOW_HEIGHT);

        // LOAD THE PERSONALIZE PAGE

        FXMLLoader fxmlLoaderPersonalize = new FXMLLoader(HomeApplication.class.getResource(PERSONALIZE_PATH));
        personalizeScene = new Scene(fxmlLoaderPersonalize.load(), WINDOW_WIDTH, WINDOW_HEIGHT);

        // LOAD THE LISTEN PAGE

        FXMLLoader fxmlListenPersonalize = new FXMLLoader(HomeApplication.class.getResource(LISTEN_PATH));
        listenScene = new Scene(fxmlListenPersonalize.load(), WINDOW_WIDTH, WINDOW_HEIGHT);

        primaryStage.setTitle(WINDOW_TITLE);
        primaryStage.setScene(homeScene);
        primaryStage.show();
    }

    // changeScreen() -> It changes the Screen's Stages
    public static void changeScreen(ScreenNavigation screen){
        switch (screen){
            case ScreenNavigation.HOME:
                stage.setScene(homeScene);
                break;
            case ScreenNavigation.EDITION:
                stage.setScene(editionScene);
                break;
            case ScreenNavigation.PERSONALIZE:
                stage.setScene(personalizeScene);
                break;
            case ScreenNavigation.LISTEN:
                stage.setScene(listenScene);
        }
    }

    public static void setText(String txt){
        text = txt;
    }

    public static String getText(){
        return text;
    }

    public static void main(String[] args) {
        launch();
    }
}
