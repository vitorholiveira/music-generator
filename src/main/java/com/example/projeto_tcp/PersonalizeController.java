package com.example.projeto_tcp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class PersonalizeController implements Initializable {

    @FXML
    private ChoiceBox<String> instrument;

    @FXML
    private ChoiceBox<String> rhythm;

    @FXML
    void getPersonalized(MouseEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        instrument.getItems().addAll(Instruments.getInstrumentsList());
    }

    @FXML
    void btListenMusic(ActionEvent event) {
        HomeApplication.changeScreen(ScreenNavigation.LISTEN);
    }
    @FXML
    void btPersonalizeBack(ActionEvent event) {
        HomeApplication.changeScreen(ScreenNavigation.EDITION);
    }
}
