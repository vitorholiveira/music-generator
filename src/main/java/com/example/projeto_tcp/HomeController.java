package com.example.projeto_tcp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class HomeController {

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

    }

    @FXML
    void btSelectFile(ActionEvent event) {

    }

    @FXML
    void btWriteMusic(ActionEvent event) {
        HomeApplication.changeScreen(ScreenNavigation.EDITION);
    }
}