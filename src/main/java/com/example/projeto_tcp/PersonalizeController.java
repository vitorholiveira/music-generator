package com.example.projeto_tcp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class PersonalizeController implements Initializable {

    private String[] rhythms_list = {"A","B","C"};
    private String[] instruments_list = {"A","B","C"};
    private String[] timbre_list = {"A","B","C"};



    @FXML
    private ChoiceBox<String> instrument;

    @FXML
    private ChoiceBox<String> rhythm;

    @FXML
    private ChoiceBox<String> timbre;

    @FXML
    void getPersonalized(MouseEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        rhythm.getItems().addAll(rhythms_list);
        timbre.getItems().addAll(instruments_list);
        instrument.getItems().addAll(timbre_list);

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
