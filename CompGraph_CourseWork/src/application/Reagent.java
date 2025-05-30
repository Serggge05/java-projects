package application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javafx.scene.control.Alert;
import javafx.scene.control.Tooltip;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;

public class Reagent extends StackPane {
	private static String[] reagentsInfo = new String[13];
	private static String[] imageInfoPaths = { "res/reagentImagesInfo/O2Info.png", "res/reagentImagesInfo/H2Info.png",
			"res/reagentImagesInfo/H2O.png", "res/reagentImagesInfo/CaOInfo.png", "res/reagentImagesInfo/COInfo.png",
			"res/reagentImagesInfo/FeInfo.png", "res/reagentImagesInfo/CuInfo.png", "res/reagentImagesInfo/SInfo.png",
			"res/reagentImagesInfo/ClInfo.png", "res/reagentImagesInfo/SO2Info.png",
			"res/reagentImagesInfo/SO3Info.jpg", "res/reagentImagesInfo/KOHInfo.jpg",
			"res/reagentImagesInfo/H2SO4Info.png" };

	private static String[] imageMainPaths = { "res/reagentImagesMain/O2Main.png", "res/reagentImagesMain/H2Main.png",
			"res/reagentImagesMain/H2OMain.png", "res/reagentImagesMain/CaOMain.png",
			"res/reagentImagesMain/COMain.png", "res/reagentImagesMain/FeMain.png", "res/reagentImagesMain/CuMain.png",
			"res/reagentImagesMain/SMain.png", "res/reagentImagesMain/ClMain.png", "res/reagentImagesMain/SO2Main.png",
			"res/reagentImagesMain/SO3Main.png", "res/reagentImagesMain/KOHMain.png",
			"res/reagentImagesMain/H2SO4Main.png" };

	private static Image[] images;
	private static String[] reagents = { "O2", "H2", "H2O", "CaO", "CO", "Fe", "Cu", "S", "Cl", "SO2", "SO3", "KOH", "H2SO4" };

	public Reagent() {	}

	private static void setImages() throws FileNotFoundException {
		images = new Image[imageInfoPaths.length];
		for (int i = 0; i < imageInfoPaths.length; i++) {
			images[i] = new Image(new FileInputStream(imageInfoPaths[i]));
		}
	}

	private static void addReagent(String name, String imagePath, HBox reagentPanel) throws IOException {
		ImageView imageView = new ImageView(new Image(new FileInputStream(imagePath)));
		imageView.setFitWidth(60);
		imageView.setFitHeight(60);
		imageView.setUserData(name); // Сохраняем название реагента
		imageView.setOnMouseEntered(e -> showTooltip(e, name));
		setImages();
		// Обработчик события двойного клика
		imageView.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
			if (event.getClickCount() == 2) {
				for (int i = 0; i < reagents.length; i++) {
					if (name == reagents[i]) {
						showImageDialog(images[i]);
					}
				}
			}
		});
		imageView.setOnDragDetected(e -> {
			Dragboard db = imageView.startDragAndDrop(TransferMode.COPY);
			ClipboardContent content = new ClipboardContent();
			// db = startDragAndDrop(TransferMode.COPY);
			// content.put(CLIPBOARD_DATAFORMAT, true);
			content.putString(name);
			db.setContent(content);
			e.consume();
		});

		//return imageView;
		reagentPanel.getChildren().add(imageView);
	}

	private static void showTooltip(MouseEvent event, String text) {
		Tooltip tooltip = new Tooltip(text);
		Tooltip.install((javafx.scene.Node) event.getSource(), tooltip);
	}

	private static void showImageDialog(Image image) {
		// Создаем диалоговое окно
		Alert alert = new Alert(AlertType.INFORMATION);

		alert.setTitle("Информация о веществе");
		for (int i = 0; i < reagents.length; i++) {
			if (image == images[i]) {
				alert.setHeaderText(Reagent.getReagentsInfo(i));
			}
		}

		// Устанавливаем изображение в диалог
		ImageView imageView = new ImageView(image);
		imageView.setFitWidth(200);
		imageView.setFitHeight(200);
		imageView.setPreserveRatio(true);
		// alert.initStyle(StageStyle.TRANSPARENT);

		alert.setGraphic(imageView);

		alert.showAndWait();
	}
	
	public static void addedReagentInitializer(HBox reagentPanel) throws IOException {
		for (int i = 0; i < reagents.length; i++) {
			addReagent(reagents[i], imageMainPaths[i], reagentPanel);
		}
	}

	private static void reagentsInitializer() {
		reagentsInfo[0] = "Кислород. Бесцветный газ. \nОсновной компонент воздуха";
		reagentsInfo[1] = "Водород. Бесцветный газ. \nСамый лёгкий газ";
		reagentsInfo[2] = "Вода. Прозрачная жидкость. \nКлючевое условие жизни. \nХороший растворитель";
		reagentsInfo[3] = "Оксид кальция. Вещество в виде \nкристаллов белого цвета";
		reagentsInfo[4] = "Оксид углерода (II). Углекислый газ, \nкоторый выделяют все живые существа";
		reagentsInfo[5] = "Железо. Металл серого блестящего цвета. \nВ чистом виде в природе не встречается";
		reagentsInfo[6] = "Медь. Металл блестяще-коричневого цвета. \nАктивно используется в электронике \nдля производства проводов";
		reagentsInfo[7] = "Сера. Жёлтое порошкообразное вещество";
		reagentsInfo[8] = "Хлор. Жёлто-зелёный газ";
		reagentsInfo[9] = "Оксид серы (IV). Жидкость с большой летучестью";
		reagentsInfo[10] = "Оксид серы (VI). Достаточно токсичный газ";
		reagentsInfo[11] = "Гидроксид кальция. Вещество в виде белых кристаллов";
		reagentsInfo[12] = "Серная кислота. Сильная кислота, \nявляется хорошим растворителем";
	}

	public static String getReagentsInfo(int index) {
		reagentsInitializer();
		return reagentsInfo[index];
	}

	public String getImagePaths(int index) {
		return imageInfoPaths[index];
	}
}
