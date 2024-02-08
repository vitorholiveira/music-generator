package com.example.projeto_tcp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class EditionController {

    @FXML
    private Button BackButton;

    @FXML
    private TextArea myTextArea;

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
        String text = myTextArea.getText();
        HomeApplication.setText(text);
        HomeApplication.changeScreen(ScreenNavigation.PERSONALIZE);
    }

}

