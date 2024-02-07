package com.example.projeto_tcp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class ListenController {

    @FXML
    // btGoEdition -> change the Screen from "Listen Screen" to "Edition Screen" when the "Generate New Music Button" is Pressed
    void btGoEdition(ActionEvent event) {
        HomeApplication.changeScreen(ScreenNavigation.EDITION);
    }

    @FXML
    // btListenBack -> change the Screen from "Listen Screen" to "Personalize Screen" when the "Back Button" is Pressed
    void btListenBack(ActionEvent event) {
        HomeApplication.changeScreen(ScreenNavigation.PERSONALIZE);
    }

    @FXML
    // btPlayMusic -> Play the music when the flag is 0, Pause the music when the flag is 1

    void btPlayMusic(ActionEvent event) {

    }

    @FXML
    // btSaveMusic -> Save the music in a MIDI file
    void btSaveMusic(ActionEvent event) {

    }

}
