package com.example.projeto_tcp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import org.jfugue.midi.MidiFileManager;
import org.jfugue.player.Player;

import java.io.File;
import java.io.IOException;
import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequence;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException, InvalidMidiDataException, MidiUnavailableException {
        System.out.println(MusicPlayer.getRandomText());
        Player player = new Player();
        String text = "\nM+FGR+BBPM+AABPM-FDddBPM-r-CEDDC";
        Music mainMusic = new Music(new MusicSettings(140, 0, "Trombone", 40, 5), text);
        mainMusic.generate();
        javax.sound.midi.Sequence sequence = player.getSequence(mainMusic.getPattern());
        player.getManagedPlayer().start(sequence);
        System.in.read();
        player.getManagedPlayer().pause();
        System.in.read();
        player.getManagedPlayer().resume();

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1080, 720);
        stage.setTitle("Music Generator");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}

//NÃO MEXE NO MEU PC