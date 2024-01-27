package com.example.projeto_tcp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class EditionController {

    @FXML
    private Button BackButton;

    @FXML
    private TextField myTextField;

    @FXML
    private Button nextButton;

    @FXML
    void btEditionBack(ActionEvent event) {
        HomeApplication.changeScreen(ScreenNavigation.HOME);
    }

    @FXML
    void btPersonalizeMusic(ActionEvent event) {
        HomeApplication.changeScreen(ScreenNavigation.PERSONALIZE);
    }

}

