package com.example.projeto_tcp;

import javafx.stage.FileChooser;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.UUID;

public class HomeController {

    private static int MAX_CHARACTERS = 200;

    FileChooser fileChooser = new FileChooser();

    @FXML
    private Button exitButton;

    @FXML
    private Button randomButton;

    @FXML
    private Button selectTextButton;

    @FXML
    private Button writeButton;

    @FXML
    void btExit(ActionEvent event) {
    }

    @FXML
    void btRandomText(ActionEvent event) {
        String randomText = UUID.randomUUID().toString();
        HomeApplication.setText(randomText);
        HomeApplication.changeScreen(ScreenNavigation.PERSONALIZE);
    }
    @FXML
    void btSelectFile(ActionEvent event) {
        // Sets the filter to accept only .txt files
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Text Files (*.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(extFilter);

        // Opens the file chooser to select a file
        File selectedFile = fileChooser.showOpenDialog(((Button) event.getSource()).getScene().getWindow());

        // If no file was selected, abort
        if (selectedFile == null) {
            return;
        }

        try {
            // Creates a FileReader to read the selected file
            FileReader fileReader = new FileReader(selectedFile);
            // Creates a BufferedReader to read lines from the file
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            // Variable to store the read line from the file
            StringBuilder content = new StringBuilder();
            // Variable to store the total characters read
            int totalCharacters = 0;

            // Reads each line from the file and adds it to the content until reaching 200 characters
            String line;
            int remainingCharacters;
            while ((line = bufferedReader.readLine()) != null && totalCharacters < MAX_CHARACTERS) {
                remainingCharacters = MAX_CHARACTERS - totalCharacters;
                if (line.length() <= remainingCharacters) {
                    content.append(line);
                    totalCharacters += line.length();
                } else {
                    content.append(line.substring(0, remainingCharacters));
                    totalCharacters += remainingCharacters;
                }
            }

            // Closes the BufferedReader and FileReader after reading the file
            bufferedReader.close();
            fileReader.close();

            // Stores the file content and switches to the next screen
            HomeApplication.setText(content.toString());
            HomeApplication.changeScreen(ScreenNavigation.PERSONALIZE);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void btWriteMusic(ActionEvent event) {
        HomeApplication.changeScreen(ScreenNavigation.EDITION);
    }
}