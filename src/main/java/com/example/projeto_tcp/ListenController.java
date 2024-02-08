package com.example.projeto_tcp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;
import org.jfugue.player.ManagedPlayer;
import org.jfugue.player.Player;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequence;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ListenController {

    @FXML
    // btGoEdition -> change the Screen from "Listen Screen" to "Edition Screen" when the "Generate New Music Button" is Pressed
    void btGoEdition(ActionEvent event) {
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

        Player mainPlayer = HomeApplication.getMusicPlayer().getPlayer();
        Sequence sequence = HomeApplication.getMusicPlayer().getSequence();
        mainPlayer.getManagedPlayer().start(sequence);
    }

    @FXML
    // btSaveMusic -> Save the music in a MIDI file
    void btSaveMusic(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Salvar Arquivo de Música");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Arquivos MIDI", "*.mid"));
        File selectedFile = fileChooser.showSaveDialog(null);
        if (selectedFile != null) {
            String filePath = selectedFile.getAbsolutePath();
            if (!filePath.toLowerCase().endsWith(".mid")) {
                filePath += ".mid"; // Adiciona a extensão .mid se não estiver presente
            }
            HomeApplication.getMusicPlayer().save(filePath);
        }

    }

}
