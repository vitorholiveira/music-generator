package com.example.projeto_tcp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiUnavailableException;
import java.io.File;

public class ListenController {
    @FXML
    private Button buttonStart;
    @FXML
    // btGoEdition -> change the Screen from "Listen Screen" to "Edition Screen" when the "Generate New Music Button" is Pressed
    void btGoHome(ActionEvent event) {
        HomeApplication.changeScreen(ScreenNavigation.HOME);
    }

    @FXML
    // btListenBack -> change the Screen from "Listen Screen" to "Personalize Screen" when the "Back Button" is Pressed
    void btListenBack(ActionEvent event) {
        HomeApplication.changeScreen(ScreenNavigation.PERSONALIZE);
    }

    @FXML
    // btPlayMusic -> Play the music when the flag is 0, Pause the music when the flag is 1

    void btPlayMusic(ActionEvent event) throws InvalidMidiDataException, MidiUnavailableException {
        MusicPlayer player = HomeApplication.getMusicPlayer();

        buttonStart.setText("Stop");
        if (player.isFinished()){
            player.start();
            return;
        }

        if (!player.isPlay()) {
            player.start();
        } else if (player.isPause()) {
            player.resume();
        } else {
            buttonStart.setText("Play");
            player.pause();
        }
    }

    @FXML
    // btSaveMusic -> Save the music in a MIDI file
    void btSaveMusic(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Salvar Arquivo de Música");
        // Add filter to only show MIDI files
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Arquivos MIDI", "*.mid"));
        // Show the save dialog and get the selected file
        File selectedFile = fileChooser.showSaveDialog(null);

        // If a file is selected
        if (selectedFile == null) {
            return;
        }

        // Get the absolute path of the selected file
        String filePath = selectedFile.getAbsolutePath();
        // Check if the file path doesn't already end with .mid extension
        if (!filePath.toLowerCase().endsWith(".mid")) {
            filePath += ".mid";
        }
        // Call the save method of the music player passing the file path
        HomeApplication.getMusicPlayer().save(filePath);
    }


}
