package com.example.projeto_tcp;

import javafx.stage.FileChooser;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class HomeController {
    FileChooser fileChooser = new FileChooser();
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
        // Configura o filtro para aceitar apenas arquivos .txt
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Arquivos de Texto (*.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(extFilter);

        // Abre o seletor de arquivos para selecionar um arquivo
        File selectedFile = fileChooser.showOpenDialog(((Button) event.getSource()).getScene().getWindow());

        // Verifica se um arquivo foi selecionado
        if (selectedFile != null) {
            try {
                // Cria um FileReader para ler o arquivo selecionado
                FileReader fileReader = new FileReader(selectedFile);

                // Cria um BufferedReader para ler linhas do arquivo
                BufferedReader bufferedReader = new BufferedReader(fileReader);

                // Variável para armazenar a linha lida do arquivo
                StringBuilder content = new StringBuilder();

                // Variável para armazenar o total de caracteres lidos
                int totalCharacters = 0;

                // Lê cada linha do arquivo e adiciona ao conteúdo até atingir 200 caracteres
                String line;
                while ((line = bufferedReader.readLine()) != null && totalCharacters < 200) {
                    int remainingCharacters = 200 - totalCharacters;
                    if (line.length() <= remainingCharacters) {
                        content.append(line);
                        totalCharacters += line.length();
                    } else {
                        content.append(line.substring(0, remainingCharacters));
                        totalCharacters += remainingCharacters;
                    }
                }

                // Fecha o BufferedReader e o FileReader após a leitura do arquivo
                bufferedReader.close();
                fileReader.close();

                HomeApplication.setText(content.toString());
                HomeApplication.changeScreen(ScreenNavigation.EDITION);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    void btWriteMusic(ActionEvent event) {
        HomeApplication.changeScreen(ScreenNavigation.EDITION);
    }
}