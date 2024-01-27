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
    // btEditionBack() ->  change the Screen from "Edition Screen" to "Home Screen" when the "Back Button" is Pressed
    void btEditionBack(ActionEvent event) {
        HomeApplication.changeScreen(ScreenNavigation.HOME);
    }

    @FXML
    // btPersonalizedMusic() -> change the Screen from "Edition Screen" to "Personalize Screen" when the "Next Button" is Pressed
    void btPersonalizeMusic(ActionEvent event) {
        HomeApplication.changeScreen(ScreenNavigation.PERSONALIZE);
    }

}

