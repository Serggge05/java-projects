package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Runner extends Application {
	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Виртуальная химическая лаборатория");
		primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("icon.jpg")));
		primaryStage.setResizable(false);
		// Создание корневого контейнера
		StackPane root = new StackPane();

		// Загрузка изображения
		Image image0 = new Image("file:res/BackGround.jpg"); // Укажите путь к вашему изображению
		BackgroundImage backgroundImage = new BackgroundImage(image0, BackgroundRepeat.NO_REPEAT,
				BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
				new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, true, true, true, true));

		// Установка фона с изображением
		root.setBackground(new Background(backgroundImage));

		Image image = new Image("file:res/Title1.png"); // Укажите правильный путь к изображению
		ImageView imageView = new ImageView(image);

		// Настройка размера изображения (по желанию)
		// imageView.setFitWidth(200); // Ширина изображения
		imageView.setFitHeight(80); // Высота изображения
		imageView.setPreserveRatio(true); // Сохранять пропорции изображения

		Button startButton = new Button("Войти в лабораторию");
		Button exitButton = new Button("Выход");

		startButton.setFont(new Font("Comic Sans MS", 20));
		startButton.setStyle("-fx-background-color: #FF5733; -fx-text-fill: white;"); // Начальный цвет
		
		exitButton.setFont(new Font("Comic Sans MS", 14));
		exitButton.setStyle("-fx-background-color: #AA00AA; -fx-text-fill: white;"); // Начальный цвет #FF5733

		// Установка обработчиков событий для изменения цвета
		startButton
				.setOnMouseEntered(e -> startButton.setStyle("-fx-background-color: #33FF57; -fx-text-fill: white;"));
		// Цвет при наведении

		startButton.setOnMouseExited(e -> startButton.setStyle("-fx-background-color: #FF5733; -fx-text-fill: white;"));
		// Возврат к исходному цвету

		startButton.setOnAction(e -> {
			
			Controller experimentScene = new Controller();
			try {
				experimentScene.createScene(primaryStage);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		

		exitButton.setOnAction(e -> {
			exitButton.setStyle("-fx-background-color: #220022");
			primaryStage.close();
		});

		VBox layout = new VBox(10); // Отступ между кнопками
		layout.getChildren().addAll(imageView, startButton, exitButton);
		layout.setStyle("-fx-alignment: center;"); // Центрирование по горизонтали

		root.getChildren().add(layout);
		
		Scene mainScene = new Scene(root, 1200, 900);

		primaryStage.setScene(mainScene);
		primaryStage.show();
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
