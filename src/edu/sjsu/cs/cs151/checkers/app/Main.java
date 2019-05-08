package edu.sjsu.cs.cs151.checkers.app;

import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.JFrame;

import edu.sjsu.cs.cs151.checkers.controller.GameController;
import edu.sjsu.cs.cs151.checkers.view.Button;
import edu.sjsu.cs.cs151.checkers.view.Gameboard;
import edu.sjsu.cs.cs151.checkers.view.MainView;
import edu.sjsu.cs.cs151.checkers.view.Window;

/*
 * Handles main JFrame
 * */

public class Main {
	public static void main(String[] args) {
		Window window = new Window("Checkers");
		MainView view = new MainView();
		window.getContentPane().add(view);
		GameController gc = new GameController();
		//Gameboard gb = new Gameboard(gc.checkers);
		//.setMargin(new Insets(0, 0, 0, 0));
		/*Button b = new Button("Undo Move");
		window.getContentPane().add(b);
		window.setLayout(new GridLayout(3,3));*/
		window.setVisible(true);
	}
}