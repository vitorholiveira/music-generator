package com.example.projeto_tcp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class ListenController {

    @FXML
    void btGoEdition(ActionEvent event) {
        HomeApplication.changeScreen(ScreenNavigation.EDITION);
    }

    @FXML
    void btListenBack(ActionEvent event) {
        HomeApplication.changeScreen(ScreenNavigation.PERSONALIZE);
    }

    @FXML
    void btPlayMusic(ActionEvent event) {

    }

    @FXML
    void btSaveMusic(ActionEvent event) {

    }

}
