package com.example.projeto_tcp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class PersonalizeController implements Initializable {

    @FXML
    private ChoiceBox<String> instrument;

    @FXML
    private Spinner<Integer> RythmSpinner;

    @FXML
    private Spinner<Integer> VolumeSpinner;

    @FXML
    void getPersonalized(MouseEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        instrument.getItems().addAll(Instrument.getInstrumentsList());
        RythmSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 200, 0, 1));
        VolumeSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100, 0, 1));
    }

    @FXML
    void btListenMusic(ActionEvent event) {
        int rythmValue = RythmSpinner.getValue();
        int volumeValue = VolumeSpinner.getValue();
        String firstInstrument = instrument.getValue();
        HomeApplication.setMusicSettings(rythmValue, firstInstrument, volumeValue);
        HomeApplication.createMusic();
        HomeApplication.getMusic().generate();
        HomeApplication.createPlayer();
        HomeApplication.changeScreen(ScreenNavigation.LISTEN);
    }
    @FXML
    void btPersonalizeBack(ActionEvent event) {
        HomeApplication.changeScreen(ScreenNavigation.EDITION);
    }
}
