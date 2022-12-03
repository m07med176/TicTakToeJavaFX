/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictaktoejavafx.controller;

import javafx.event.ActionEvent;
import tictaktoejavafx.view.ChooseDiffucultyScreenBase;

/**
 *
 * @author Elsawah
 */
public class ChooseDiffucultyController extends ChooseDiffucultyScreenBase{

    @Override
    protected void isEasyMode(ActionEvent actionEvent) {
        System.out.println("isEasyMode");
    }

    @Override
    protected void isMiddleMode(ActionEvent actionEvent) {
        System.out.println("isMiddleMode");
    }

    @Override
    protected void isHardMode(ActionEvent actionEvent) {
        System.out.println("isHardMode");
    }

    @Override
    protected void isStartGame(ActionEvent actionEvent) {
        System.out.println("isStartGame");
    }
    
}
