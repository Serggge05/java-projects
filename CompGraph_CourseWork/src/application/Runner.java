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
		primaryStage.setTitle("����������� ���������� �����������");
		primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("icon.jpg")));
		primaryStage.setResizable(false);
		// �������� ��������� ����������
		StackPane root = new StackPane();

		// �������� �����������
		Image image0 = new Image("file:res/BackGround.jpg"); // ������� ���� � ������ �����������
		BackgroundImage backgroundImage = new BackgroundImage(image0, BackgroundRepeat.NO_REPEAT,
				BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
				new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, true, true, true, true));

		// ��������� ���� � ������������
		root.setBackground(new Background(backgroundImage));

		Image image = new Image("file:res/Title1.png"); // ������� ���������� ���� � �����������
		ImageView imageView = new ImageView(image);

		// ��������� ������� ����������� (�� �������)
		// imageView.setFitWidth(200); // ������ �����������
		imageView.setFitHeight(80); // ������ �����������
		imageView.setPreserveRatio(true); // ��������� ��������� �����������

		Button startButton = new Button("����� � �����������");
		Button exitButton = new Button("�����");

		startButton.setFont(new Font("Comic Sans MS", 20));
		startButton.setStyle("-fx-background-color: #FF5733; -fx-text-fill: white;"); // ��������� ����
		
		exitButton.setFont(new Font("Comic Sans MS", 14));
		exitButton.setStyle("-fx-background-color: #AA00AA; -fx-text-fill: white;"); // ��������� ���� #FF5733

		// ��������� ������������ ������� ��� ��������� �����
		startButton
				.setOnMouseEntered(e -> startButton.setStyle("-fx-background-color: #33FF57; -fx-text-fill: white;"));
		// ���� ��� ���������

		startButton.setOnMouseExited(e -> startButton.setStyle("-fx-background-color: #FF5733; -fx-text-fill: white;"));
		// ������� � ��������� �����

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

		VBox layout = new VBox(10); // ������ ����� ��������
		layout.getChildren().addAll(imageView, startButton, exitButton);
		layout.setStyle("-fx-alignment: center;"); // ������������� �� �����������

		root.getChildren().add(layout);
		
		Scene mainScene = new Scene(root, 1200, 900);

		primaryStage.setScene(mainScene);
		primaryStage.show();
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
