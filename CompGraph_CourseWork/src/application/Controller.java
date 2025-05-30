package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;

import javafx.scene.input.TransferMode;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Controller {

	private static Set<String> selectedReagents = new HashSet<>();
	private HBox reagentPanel;
	private static Pane experimentPanel;
	private static TextArea experimentDescription;
	//private Slider temperatureSlider;
	private String[] reagents = { "O2", "H2", "H2O", "CaO", "CO", "Fe", "Cu", "S", "Cl", "SO2", "SO3", "KOH", "H2SO4" };
	//private String[] reagentsNames = { "��������", "�������", "����", "����� �������", "������", "����", "�������" };

	private Font titleFont = new Font("Comic Sans MS", 20);
	
	
	public void createScene(Stage primaryStage) throws IOException {
		primaryStage.setTitle("����������� ���������� �����������");
		primaryStage.setResizable(false);
		primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("icon.jpg")));

		// ���� ���
		MenuBar menuBar = new MenuBar();
		// creating menu for adding menu items
		Menu fileMenu = new Menu("����");
		// creating menu items
		MenuItem availableReactions = new MenuItem("��������� �������");
		//MenuItem courses = new MenuItem("��� ���-��");
		//MenuItem aboutEDUCBA = new MenuItem("���-�� ������");
		MenuItem exit = new MenuItem("�����");
		// adding menu items to the menu
		fileMenu.getItems().add(availableReactions);
		//fileMenu.getItems().add(courses);
		//fileMenu.getItems().add(aboutEDUCBA);
		fileMenu.getItems().add(exit);
		// adding menu to the menu bar
		menuBar.getMenus().add(fileMenu);

		Menu infoMenu = new Menu("�������");
		// infoMenu.setStyle(STYLESHEET_MODENA);
		MenuItem aboutProgram = new MenuItem("� ���������");
		infoMenu.getItems().add(aboutProgram);
		menuBar.getMenus().add(infoMenu);

		availableReactions.setOnAction(e -> {
			// ������� ���������� ����
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("��������� �������");
			alert.setHeaderText(Experiment.printReactions());
			alert.showAndWait();
		});
		exit.setOnAction(e -> primaryStage.close());
		infoMenu.setOnAction(e -> showInfo());

		// �������� ������ ��� ���������
		reagentPanel = new HBox(20);
		HBox.setHgrow(reagentPanel, Priority.ALWAYS);
		reagentPanel.setStyle("-fx-background-color: lightgray; -fx-padding: 20;");
		
		Reagent.addedReagentInitializer(reagentPanel);

		// ������ ��� ������������
		experimentPanel = new Pane();
		HBox.setHgrow(experimentPanel, Priority.ALWAYS);
		experimentPanel.setStyle("-fx-background-color: white; -fx-padding: 20;");
		experimentPanel.setPrefHeight(400);
		experimentPanel.setOnDragOver(this::handleDragOver);
		experimentPanel.setOnDragDropped(this::handleDragDropped);

		// ��������� ���� ��� �������� ������������
		experimentDescription = new TextArea();
		HBox.setHgrow(experimentDescription, Priority.ALWAYS);
		experimentDescription.setEditable(false);
		experimentDescription.setPrefHeight(200);

		// ������ ScrollPane ��� ����������� TextArea � �������� ���������
		ScrollPane scrollPane = new ScrollPane(experimentDescription);

		// ������������� �������� ���������, ����� ��� ������������� ����������
		// �������������� � ������������ ������ ���������
		scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
		scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);

		// ������ StackPane ��� ��������� ScrollPane
		StackPane root = new StackPane();
		root.getChildren().add(scrollPane);
		

		// ������ ScrollPane1 ��� ����������� � �������� ���������
		ScrollPane scrollPane1 = new ScrollPane(experimentPanel);
		//scrollPane1.setContent(experimentPanel);

		// ������������� �������� ���������, ����� ��� ������������� ����������
		// �������������� � ������������ ������ ���������
		scrollPane1.setHbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
		scrollPane1.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);

		// ������ StackPane ��� ��������� ScrollPane
		StackPane root1 = new StackPane();
		root1.getChildren().add(scrollPane1);

		// �������� �����������
//		temperatureSlider = new Slider(0, 100, 40);
//		temperatureSlider.setShowTickLabels(true);
//		temperatureSlider.setShowTickMarks(true);

		// ������ ������������ ������������
		Button visualizeButton = new Button("��������������� �����������");
		visualizeButton.setFont(titleFont);
		visualizeButton.setOnAction(e -> visualizeExperiment(primaryStage));

		// ������ ������������ ������������
		Button clearButton = new Button("������ �������");
		clearButton.setFont(titleFont);
		clearButton.setOnAction(e -> {
			try {
				clearSelectedReagents();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});

		// Button exitButton = new Button("�����");
		// exitButton.setOnAction(e -> primaryStage.close());

		// ������ ������
		HBox bottomPanel = new HBox(20);
		HBox.setHgrow(bottomPanel, Priority.ALWAYS);
		// this.add(bottomPanel, BorderLayout.SOUTH);
		bottomPanel.getChildren().addAll(visualizeButton, clearButton);
		bottomPanel.setStyle("-fx-background-color: lightgrey; -fx-padding: 30;");
		// exitButton.setOnAction(e -> primaryStage.close());

		// VBox exitButtonPanel = new VBox(10);
		// exitButtonPanel.getChildren().addAll(exitButton);

		/*
		 * GridPane grid = new GridPane(); grid.add(reagentPanel, 1, 1);
		 * grid.add(experimentPanel, 1, 10); grid.add(experimentDescription, 1, 20);
		 * grid.add(bottomPanel, 1, 35);
		 */
		// �������� ������
		// Font titleFont = new Font("Comic Sans MS", 20);

		VBox spacer0 = new VBox();
		Label l0 = new Label("��������");
		l0.setFont(titleFont);
		spacer0.getChildren().add(l0);
		spacer0.setStyle("-fx-background-color: lightblue; -fx-padding: 15;");

		VBox spacer1 = new VBox();
		Label l1 = new Label("���� ������������");
		l1.setFont(titleFont);
		spacer1.getChildren().add(l1);
		spacer1.setStyle("-fx-background-color: lightblue; -fx-padding: 15;");

		VBox spacer2 = new VBox();
		Label l2 = new Label("�������� ������������");
		l2.setFont(titleFont);
		spacer2.getChildren().add(l2);
		spacer2.setStyle("-fx-background-color: lightblue; -fx-padding: 15;");

		VBox spacer3 = new VBox();
		Label l3 = new Label("�����������");
		l3.setFont(titleFont);
		spacer3.getChildren().add(l3);
		spacer3.setStyle("-fx-background-color: lightblue; -fx-padding: 15;");

		VBox rightLayout = new VBox(spacer0, reagentPanel, spacer1, experimentPanel, spacer2, experimentDescription,
				bottomPanel);
		// leftLayout.getChildren().addAll(grid);
		HBox.setHgrow(rightLayout, Priority.ALWAYS);

		HBox mainLayout = new HBox(rightLayout);
		HBox.setHgrow(mainLayout, Priority.ALWAYS);

		VBox endLayout = new VBox(10, menuBar, mainLayout);
		HBox.setHgrow(endLayout, Priority.ALWAYS);

		Scene scene = new Scene(endLayout, 1200, 900);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	private static void clearSelectedReagents() throws FileNotFoundException {
		selectedReagents = new HashSet<>();
		experimentDescription.clear();
		experimentPanel.getChildren().clear();

	}

	private void handleDragOver(DragEvent event) {
		if (event.getGestureSource() != experimentPanel && event.getDragboard().hasString()) {
			event.acceptTransferModes(TransferMode.COPY);
		}
		event.consume();
	}

	private void handleDragDropped(DragEvent event) {
		Dragboard db = event.getDragboard();
		boolean success = false;

		if (db.hasString()) {
			String reagentName = db.getString();
			if (selectedReagents.size() < 2 && selectedReagents.add(reagentName)) {
				// ���������� �������� � ������� ������������
				Label label = new Label(reagentName);
				if (selectedReagents.size() == 2) {

					label.setLayoutX(experimentPanel.getWidth() / 50);
					label.setLayoutY(reagentPanel.getHeight() + experimentPanel.getHeight() / 6);
					experimentPanel.getChildren().add(label);

				} else {
					label.setLayoutX(experimentPanel.getWidth() / 50 * 48);
					label.setLayoutY(reagentPanel.getHeight() + experimentPanel.getHeight() / 6);
					experimentPanel.getChildren().add(label);
					success = true;
				}
			} else {
				experimentDescription.appendText("������������ ���������� ��������� �������.");
			}
		}

		event.setDropCompleted(success);
		event.consume();
	}

	private void visualizeExperiment(Stage primaryStage) {
		experimentDescription.clear();

		// �������������� ���������
		experimentPanel.getChildren().clear();
		if (!selectedReagents.isEmpty() && selectedReagents.size() == 2) {
			experimentDescription.appendText("����������� ����� � ����������: " + selectedReagents.toArray()[0] + " � "
					+ selectedReagents.toArray()[1] + "\n");

			Experiment.visualize(selectedReagents, reagentPanel, experimentPanel, experimentDescription, reagents);
		} else {
			experimentDescription.appendText("�������� �������� ��� �������!");
		}

	}

	@FXML
	private void showInfo() {
		try {
			Alert helpAlert = new Alert(Alert.AlertType.INFORMATION);
			helpAlert.setTitle("� ���������");
			helpAlert.setContentText("� ���������");
			helpAlert.setHeaderText("� ��������� \"��������� ���������� �����������\"");

			// ��������� ������
			Stage stage = (Stage) helpAlert.getDialogPane().getScene().getWindow();
			stage.getIcons().add(new Image(getClass().getResourceAsStream("icon.jpg")));
			// ����������� ������ ��� ���������� ����
			if (true) {
				// ����������� ������ ��� ���������� ����
				helpAlert.getDialogPane().getStylesheets()
						.add(getClass().getResource("/resources/light_theme.css").toExternalForm());
			}

			// �������� DialogPane �� Alert
			DialogPane dialogPane = helpAlert.getDialogPane();
			// ��������� FXML ��� ����-�������
			dialogPane.setContent(FXMLLoader.load(getClass().getResource("show_info.fxml")));
			// ������������� ������ "��"
			helpAlert.getButtonTypes().setAll(ButtonType.OK);

			// ������� ������� ������ "��"
			helpAlert.showAndWait();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
