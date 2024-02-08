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

    private static int MAX_VOLUME = 200;

    private static int MAX_RYTHM = 500;

    private static int SPINNER_STEP = 10;

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
        RythmSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, MAX_RYTHM, 0, SPINNER_STEP));
        VolumeSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, MAX_VOLUME, 0, SPINNER_STEP));
    }

    @FXML
    void btListenMusic(ActionEvent event) {
        int rythmValue = RythmSpinner.getValue();
        int volumeValue = VolumeSpinner.getValue();
        String firstInstrument = instrument.getValue();

        if(firstInstrument == null || rythmValue == 0 || volumeValue == 0) {
            return;
        }

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
