package application;

import java.util.Set;

import javafx.animation.TranslateTransition;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class Experiment {
	private static String[] reactions = new String[11];
	private static String[] experimentsInfo = new String[reactions.length];

	private Experiment() {}

	public static String printReactions() {
		StringBuilder list = new StringBuilder();
		reactionsInitializer();
		for (int i = 0; i < experimentsInfo.length; i++) {
			list.append(reactions[i]).append("\n");
		}
		return list.toString();
	}

	private static void experimentsInitializer() {
		experimentsInfo[0] = "Взаимодействие водорода и кислорода:\nH2 + O2 = H2O \nВ результате получается молекула воды.\nПроисходит взрыв\n";
		experimentsInfo[1] = "Взаимодействие оксида кальция и воды:\nCaO + H2O = Ca(OH)2 \nВ результате выделяется большое \nколичество тепла и получается щёлочь \n- гидроксид кальция, так же известный как \nгашёная известь\n";
		experimentsInfo[2] = "Взамодействие оксида углерода (II) и кислорода: \n2CO + 2O = 2CO2 \nВ результате получается углекислый газ\n";
		experimentsInfo[3] = "Взамодействие железа (II) и серы (II): \nFe + S = FeS \nВ результате получается сульфид железа \n- светло-жёлтые или тёмно-жёлтые кристаллы, \nне растворимые в воде\n";
		experimentsInfo[4] = "Взамодействие железа (III) и хлора (I): \n2Fe + 3Cl2 = 2FeCl3 \nРеакция идёт бурно, с разогревом. \nВ результате получается хлорид железа (III) \n- жёлто-коричневое твёрдое вещество\n";
		experimentsInfo[5] = "Взамодействие серы (IV) и кислорода: \nS + O2 = SO2 \nСера легко окисляется кислородом до оксида \n- сернистого газа, растворимого в воде, \nсерной кислоте, этиловом спирте.\nРеакция экзотермическая, но для инициализации \nтребуется нагревание\n";
		experimentsInfo[6] = "Взамодействие диоксида серы и кислорода: \n2SO2 + O2 = 2SO3 \nВ результате получается триоксид \nсеры - достаточно токсичный газ\n";
		experimentsInfo[7] = "Взамодействие водорода и серы: \nH2 + S = H2S \nВ результате получается газ сероводород \nс запахом тухлых яиц\n";
		experimentsInfo[8] = "Взамодействие триоксида серы и воды: \nSO3 + H2O = H2SO4 \nРеакция получения серной кислоты \n- сильной кислоты, являющейся хорошим \nрастворителем\n";
		experimentsInfo[9] = "Взамодействие гидроксида калия и серной кислоты: \nKOH + H2SO4 = KHSO4 \nВ результате получается гидросульфат калия\n";
		experimentsInfo[10] = "Взамодействие меди и кислорода: \nCu + O2 = CuO2 \nВ результате получается вещество \nоксид меди\n";
	}

	public static String makeDiscription(int index) {
		experimentsInitializer();
		return experimentsInfo[index];
	}

	private static void reactionsInitializer() {
		reactions[0] = "H2 + O2 = H2O";
		reactions[1] = "CaO + H2O = Ca(OH)2";
		reactions[2] = "2CO + 2O = 2CO2";
		reactions[3] = "Fe + S = FeS";
		reactions[4] = "2Fe + 3Cl2 = 2FeCl3";
		reactions[5] = "S + O2 = SO2";
		reactions[6] = "2SO2 + O2 = 2SO3";
		reactions[7] = "H2 + S = H2S";
		reactions[8] = "SO3 + H2O = H2SO4";
		reactions[9] = "KOH + H2SO4 = KHSO4";
		reactions[10] = "Cu + O2 = CuO2";
	}

	public static void visualize(Set<String> selectedReagents, HBox reagentPanel, Pane experimentPanel,
			TextArea experimentDescription, String[] reagents) {
		// Создаем радиальный градиент
		RadialGradient gradient = new RadialGradient(225, 20, // Прозрачность (0 - непрозрачный)
				0, // Центр градиента по оси X (от 0 до 1)
				1, // Центр градиента по оси Y (от 0 до 1)
				50, // Радиус градиента
				false, // пропорциональны ли координаты и размеры форме, которую заполняет этот
						// градиент
				CycleMethod.NO_CYCLE, // Не повторять градиент
				new Stop(0, Color.rgb(255, 255, 255, 0.8)), // Белый цвет в центре с прозрачностью
				new Stop(0.75, Color.rgb(100, 100, 255)) // Синий цвет по краям
		);

		// Создаем радиальный градиент
		RadialGradient gradient1 = new RadialGradient(225, 30, // Прозрачность (0 - непрозрачный)
				0, // Центр градиента по оси X (от 0 до 1)
				1, // Центр градиента по оси Y (от 0 до 1)
				70, // Радиус градиента
				false, // пропорциональны ли координаты и размеры форме, которую заполняет этот
						// градиент
				CycleMethod.NO_CYCLE, // Не повторять градиент
				new Stop(0, Color.rgb(255, 255, 255, 0.8)), // Белый цвет в центре с прозрачностью
				new Stop(0.75, Color.rgb(255, 0, 0)) // Синий цвет по краям
		);

		// Создаем радиальный градиент
		RadialGradient gradient2 = new RadialGradient(225, 30, // Прозрачность (0 - непрозрачный)
				0, // Центр градиента по оси X (от 0 до 1)
				1, // Центр градиента по оси Y (от 0 до 1)
				70, // Радиус градиента
				false, // пропорциональны ли координаты и размеры форме, которую заполняет этот
						// градиент
				CycleMethod.NO_CYCLE, // Не повторять градиент
				new Stop(0, Color.rgb(255, 255, 255, 0.8)), // Белый цвет в центре с прозрачностью
				new Stop(0.75, Color.GREY) // Синий цвет по краям
		);

		// Создаем радиальный градиент
		RadialGradient gradient3 = new RadialGradient(225, 30, // Прозрачность (0 - непрозрачный)
				0, // Центр градиента по оси X (от 0 до 1)
				1, // Центр градиента по оси Y (от 0 до 1)
				70, // Радиус градиента
				false, // пропорциональны ли координаты и размеры форме, которую заполняет этот
						// градиент
				CycleMethod.NO_CYCLE, // Не повторять градиент
				new Stop(0, Color.rgb(255, 255, 255, 0.8)), // Белый цвет в центре с прозрачностью
				new Stop(0.75, Color.GREEN) // Синий цвет по краям
		);

		// Создаем радиальный градиент
		RadialGradient gradient4 = new RadialGradient(225, 30, // Прозрачность (0 - непрозрачный)
				0, // Центр градиента по оси X (от 0 до 1)
				1, // Центр градиента по оси Y (от 0 до 1)
				70, // Радиус градиента
				false, // пропорциональны ли координаты и размеры форме, которую заполняет этот
						// градиент
				CycleMethod.NO_CYCLE, // Не повторять градиент
				new Stop(0, Color.rgb(255, 255, 255, 0.8)), // Белый цвет в центре с прозрачностью
				new Stop(0.75, Color.rgb(180, 180, 0)) // Синий цвет по краям
		);

		// O2 + H2 = H2O
		if (((selectedReagents.toArray()[0] == reagents[0]) || (selectedReagents.toArray()[1] == reagents[0]))
				&& (selectedReagents.toArray()[0] == reagents[1]) || (selectedReagents.toArray()[1] == reagents[1])) {
			experimentDescription.appendText(Experiment.makeDiscription(0));
			// Создаем атомы водорода (маленькие синие круги)
			Circle hydrogen1 = new Circle(50);
			Circle hydrogen2 = new Circle(50);

			// Создаем атом кислорода (большой красный круг)

			Circle oxygen = new Circle(70);// (300, 200, 25, Color.RED);

			// Устанавливаем градиент как заливку круга
			hydrogen1.setFill(gradient);
			hydrogen2.setFill(gradient);
			oxygen.setFill(gradient1);

			hydrogen1.setLayoutX(experimentPanel.getWidth() / 50);
			hydrogen1.setLayoutY(reagentPanel.getHeight() + experimentPanel.getHeight() / 6);
			oxygen.setLayoutX(experimentPanel.getWidth() - experimentPanel.getWidth() / 12);
			oxygen.setLayoutY(reagentPanel.getHeight() + experimentPanel.getHeight() / 3);
			hydrogen2.setLayoutX(experimentPanel.getWidth() / 50);
			hydrogen2.setLayoutY(reagentPanel.getHeight() + experimentPanel.getHeight() / 3);

			// Текстовые метки для обозначения атомов
			// Text h1Label = new Text("H");
			// Text h2Label = new Text("H");
			// Text oLabel = new Text("O");

			Text h1Label = new Text(hydrogen1.getCenterX() - 10,
					hydrogen1.getCenterY() + reagentPanel.getHeight() + experimentPanel.getHeight() / 6 + 20, "H");
			Text h2Label = new Text(hydrogen2.getCenterX() - 10,
					hydrogen2.getCenterY() + reagentPanel.getHeight() + experimentPanel.getHeight() / 6 + 90, "H");
			Text oLabel = new Text(
					oxygen.getCenterX() - 10 + experimentPanel.getWidth() - experimentPanel.getWidth() / 12,
					oxygen.getCenterY() + reagentPanel.getHeight() + experimentPanel.getHeight() / 3 - 40, "O");
			// Добавляем атомы в основной Pane
			experimentPanel.getChildren().addAll(hydrogen1, oxygen, hydrogen2, h1Label, h2Label, oLabel);

			// Анимация для первого атома водорода
			TranslateTransition hydrogen1Transition = new TranslateTransition(Duration.seconds(2), hydrogen1);
			hydrogen1Transition.setToX(experimentPanel.getWidth() / 2 - 90);
			hydrogen1Transition.setToY(reagentPanel.getHeight() / 2 + 50);

			// Анимация для второго атома водорода
			TranslateTransition hydrogen2Transition = new TranslateTransition(Duration.seconds(2), hydrogen2);
			hydrogen2Transition.setToX(experimentPanel.getWidth() / 2 + 50);
			hydrogen2Transition.setToY(reagentPanel.getHeight() / 2 - 20);

			// Анимация для текста первого атома водорода
			TranslateTransition h1LabelTransition = new TranslateTransition(Duration.seconds(2), h1Label);
			h1LabelTransition.setToX(experimentPanel.getWidth() / 2 - 70);
			h1LabelTransition.setToY(reagentPanel.getHeight() / 2 + 50);

			// Анимация для текста второго атома водорода
			TranslateTransition h2LabelTransition = new TranslateTransition(Duration.seconds(2), h2Label);
			h2LabelTransition.setToX(experimentPanel.getWidth() / 2 + 70);
			h2LabelTransition.setToY(reagentPanel.getHeight() / 2 - 20);

			// Анимация для атома кислорода
			TranslateTransition oxygenTransition = new TranslateTransition(Duration.seconds(2), oxygen);
			oxygenTransition.setToX(-experimentPanel.getWidth() / 2 + 95);
			oxygenTransition.setToY(-reagentPanel.getHeight() / 2);

			// Анимация для текста атома кислорода
			TranslateTransition oLabelTransition = new TranslateTransition(Duration.seconds(2), oLabel);
			oLabelTransition.setToX(-experimentPanel.getWidth() / 2 + 115);
			oLabelTransition.setToY(-reagentPanel.getHeight() / 2);

			// После завершения анимации — показать финальную молекулу воды
			// Timeline finalAnimation = new Timeline(
			// new KeyFrame(Duration.seconds(2), new KeyValue(oxygen.fillProperty(),
			// Color.PURPLE)));

			// Запускаем анимации
			hydrogen1Transition.play();
			hydrogen2Transition.play();
			oxygenTransition.play();
			h1LabelTransition.play();
			h2LabelTransition.play();
			oLabelTransition.play();

			// После завершения анимации запускаем финальный эффект
			oxygenTransition.setOnFinished(event -> {
				Line line1 = new Line();
				Line line2 = new Line(oxygen.getCenterX(), oxygen.getCenterY(), hydrogen2.getCenterX(),
						hydrogen2.getCenterY());

				// Вычисляем координаты границ кругов
				double angle1 = Math.atan2(oxygen.getCenterY() - hydrogen1.getCenterY(),
						oxygen.getCenterX() - hydrogen1.getCenterX());

				double x1 = hydrogen1.getCenterX() + hydrogen1.getRadius() * Math.cos(angle1);
				double y1 = hydrogen1.getCenterY() + hydrogen1.getRadius() * Math.sin(angle1);

				double angle2 = Math.atan2(hydrogen1.getCenterY() - oxygen.getCenterY(),
						hydrogen1.getCenterX() - oxygen.getCenterX());

				double x2 = oxygen.getCenterX() + oxygen.getRadius() * Math.cos(angle2);
				double y2 = oxygen.getCenterY() + oxygen.getRadius() * Math.sin(angle2);

				// Устанавливаем координаты линии
				line1.setStartX(x1);
				line1.setStartY(y1);
				line1.setEndX(x2);
				line1.setEndY(y2);
				experimentPanel.getChildren().addAll(line1, line2);
			});
		}
		// H2O + CaO = Ca(OH)2
		if (((selectedReagents.toArray()[0] == reagents[2]) || (selectedReagents.toArray()[1] == reagents[2]))
				&& (selectedReagents.toArray()[0] == reagents[3]) || (selectedReagents.toArray()[1] == reagents[3])) {
			experimentDescription.appendText(Experiment.makeDiscription(1));
			// Создаем атомы водорода (маленькие синие круги)
			Circle hydrogen1 = new Circle(50, Color.BLUE);
			Circle hydrogen2 = new Circle(50, Color.BLUE);
			Circle oxygen1 = new Circle(70, Color.RED);

			Circle calcium = new Circle(80, Color.GREY);
			Circle oxygen2 = new Circle(70, Color.RED);// (300, 200, 25, Color.RED);

			hydrogen1.setFill(gradient);
			hydrogen2.setFill(gradient);
			oxygen1.setFill(gradient1);
			oxygen2.setFill(gradient1);
			calcium.setFill(gradient2);

			hydrogen1.setLayoutX(experimentPanel.getWidth() / 50);
			hydrogen1.setLayoutY(reagentPanel.getHeight() + experimentPanel.getHeight() / 6);
			oxygen1.setLayoutX(experimentPanel.getWidth() / 50 + 40);
			oxygen1.setLayoutY(reagentPanel.getHeight() + experimentPanel.getHeight() / 4);
			hydrogen2.setLayoutX(experimentPanel.getWidth() / 50);
			hydrogen2.setLayoutY(reagentPanel.getHeight() + experimentPanel.getHeight() / 3);

			calcium.setLayoutX(experimentPanel.getWidth() - experimentPanel.getWidth() / 12);
			calcium.setLayoutY(reagentPanel.getHeight() + experimentPanel.getHeight() / 6);
			oxygen2.setLayoutX(experimentPanel.getWidth() - experimentPanel.getWidth() / 12);
			oxygen2.setLayoutY(reagentPanel.getHeight() + experimentPanel.getHeight() / 6 + 90);

			// Текстовые метки для обозначения атомов
			Text h1Label = new Text(hydrogen1.getCenterX() - 10,
					hydrogen1.getCenterY() + reagentPanel.getHeight() + experimentPanel.getHeight() / 6 + 20, "H");
			Text h2Label = new Text(hydrogen2.getCenterX() + 20,
					hydrogen2.getCenterY() + reagentPanel.getHeight() + experimentPanel.getHeight() / 6 + 100, "H");
			Text o1Label = new Text(oxygen1.getCenterX() + 40,
					oxygen1.getCenterY() + reagentPanel.getHeight() + experimentPanel.getHeight() / 4 + 50, "O");

			Text o2Label = new Text(oxygen2.getCenterX() - 10 + experimentPanel.getWidth() - experimentPanel.getWidth() / 12,
					oxygen2.getCenterY() + reagentPanel.getHeight() + experimentPanel.getHeight() / 6 + 110, "O");

			Text calciumLabel = new Text(calcium.getCenterX() - 10 + experimentPanel.getWidth() - experimentPanel.getWidth() / 12,
					calcium.getCenterY() + reagentPanel.getHeight() + experimentPanel.getHeight() / 6 + 20, "Ca");

			// Добавляем атомы в основной Pane
			experimentPanel.getChildren().addAll(hydrogen1, oxygen1, hydrogen2, h1Label, h2Label, o1Label, calcium,
					oxygen2, o2Label, calciumLabel);

			// Анимация для первого атома водорода
			TranslateTransition hydrogen1Transition = new TranslateTransition(Duration.seconds(2), hydrogen1);
			hydrogen1Transition.setToX(experimentPanel.getWidth() / 2 - 190);
			hydrogen1Transition.setToY(reagentPanel.getHeight() / 2 + 25);

			// Анимация для второго атома водорода
			TranslateTransition hydrogen2Transition = new TranslateTransition(Duration.seconds(2), hydrogen2);
			hydrogen2Transition.setToX(experimentPanel.getWidth() / 2 + 80);
			hydrogen2Transition.setToY(reagentPanel.getHeight() / 2 - 5);

			// Анимация для текста первого атома водорода
			TranslateTransition h1LabelTransition = new TranslateTransition(Duration.seconds(2), h1Label);
			h1LabelTransition.setToX(experimentPanel.getWidth() / 2 - 190);
			h1LabelTransition.setToY(reagentPanel.getHeight() / 2 + 25);

			// Анимация для текста второго атома водорода
			TranslateTransition h2LabelTransition = new TranslateTransition(Duration.seconds(2), h2Label);
			h2LabelTransition.setToX(experimentPanel.getWidth() / 2 + 80);
			h2LabelTransition.setToY(reagentPanel.getHeight() / 2 - 5);

			// Анимация для 1 атома кислорода
			TranslateTransition oxygen1Transition = new TranslateTransition(Duration.seconds(2), oxygen1);
			oxygen1Transition.setToX(experimentPanel.getWidth() / 2 - 40);
			oxygen1Transition.setToY(reagentPanel.getHeight() / 2 - 10);

			// Анимация для текста 1 атома кислорода
			TranslateTransition o1LabelTransition = new TranslateTransition(Duration.seconds(2), o1Label);
			o1LabelTransition.setToX(experimentPanel.getWidth() / 2 - 40);
			o1LabelTransition.setToY(reagentPanel.getHeight() / 2 - 10);

			// Анимация для 2 атома кислорода
			TranslateTransition oxygen2Transition = new TranslateTransition(Duration.seconds(2), oxygen2);
			oxygen2Transition.setToX(-experimentPanel.getWidth() / 2);
			oxygen2Transition.setToY(reagentPanel.getHeight() / 2 - 30);

			// Анимация для текста 2 атома кислорода
			TranslateTransition o2LabelTransition = new TranslateTransition(Duration.seconds(2), o2Label);
			o2LabelTransition.setToX(-experimentPanel.getWidth() / 2);
			o2LabelTransition.setToY(reagentPanel.getHeight() / 2 - 30);

			// Анимация для атома кальция
			TranslateTransition calciumTransition = new TranslateTransition(Duration.seconds(2), calcium);
			calciumTransition.setToX(-experimentPanel.getWidth() / 2 + 60);
			calciumTransition.setToY(reagentPanel.getHeight() / 2 - 30);

			// Анимация для текста атома кальция
			TranslateTransition calciumLabelTransition = new TranslateTransition(Duration.seconds(2), calciumLabel);
			calciumLabelTransition.setToX(-experimentPanel.getWidth() / 2 + 60);
			calciumLabelTransition.setToY(reagentPanel.getHeight() / 2 - 30);

			// После завершения анимации — показать финальную молекулу воды
			// Timeline finalAnimation = new Timeline(
			// new KeyFrame(Duration.seconds(2), new KeyValue(oxygen1.fillProperty(),
			// Color.PURPLE)));
			Line line1 = new Line(oxygen1.getCenterX(), oxygen1.getCenterY(), hydrogen1.getCenterX(),
					hydrogen1.getCenterY());
			Line line2 = new Line(oxygen1.getCenterX(), oxygen1.getCenterY(), hydrogen2.getCenterX(),
					hydrogen2.getCenterY());

			// Запускаем анимации
			hydrogen1Transition.play();
			hydrogen2Transition.play();
			oxygen1Transition.play();
			oxygen2Transition.play();
			h1LabelTransition.play();
			h2LabelTransition.play();
			o1LabelTransition.play();
			o2LabelTransition.play();
			calciumTransition.play();
			calciumLabelTransition.play();

			// После завершения анимации запускаем финальный эффект
			experimentPanel.getChildren().addAll(line1, line2);
			// oxygenTransition.setOnFinished(event -> finalAnimation.play());
		}
		// 2CO + O2 = 2CO2
		if (((selectedReagents.toArray()[0] == reagents[0]) || (selectedReagents.toArray()[1] == reagents[0]))
				&& (selectedReagents.toArray()[0] == reagents[4]) || (selectedReagents.toArray()[1] == reagents[4])) {
			experimentDescription.appendText(Experiment.makeDiscription(2));

		}
		// Fe + S = FeS
		if (((selectedReagents.toArray()[0] == reagents[5]) || (selectedReagents.toArray()[1] == reagents[5]))
				&& (selectedReagents.toArray()[0] == reagents[7]) || (selectedReagents.toArray()[1] == reagents[7])) {
			experimentDescription.appendText(Experiment.makeDiscription(3));
			// Создаем атомы водорода (маленькие синие круги)
			Circle sulfum = new Circle(50);

			// Создаем атом кислорода (большой красный круг)

			Circle ferrum = new Circle(70);// (300, 200, 25, Color.RED);

			// Устанавливаем градиент как заливку круга
			sulfum.setFill(gradient4);
			ferrum.setFill(gradient2);

			sulfum.setLayoutX(experimentPanel.getWidth() / 50);
			sulfum.setLayoutY(reagentPanel.getHeight() + experimentPanel.getHeight() / 6);
			ferrum.setLayoutX(experimentPanel.getWidth() - experimentPanel.getWidth() / 12);
			ferrum.setLayoutY(reagentPanel.getHeight() + experimentPanel.getHeight() / 3);

			// Текстовые метки для обозначения атомов
			// Text h1Label = new Text("H");
			// Text h2Label = new Text("H");
			// Text oLabel = new Text("O");

			Text sLabel = new Text(sulfum.getCenterX() - 10,
					sulfum.getCenterY() + reagentPanel.getHeight() + experimentPanel.getHeight() / 6 + 20, "S");
			Text feLabel = new Text(
					ferrum.getCenterX() - 10 + experimentPanel.getWidth() - experimentPanel.getWidth() / 12,
					ferrum.getCenterY() + reagentPanel.getHeight() + experimentPanel.getHeight() / 3 - 40, "Fe");
			// Добавляем атомы в основной Pane
			experimentPanel.getChildren().addAll(sulfum, ferrum, sLabel, feLabel);

			// Анимация для атома fe
			TranslateTransition sTransition = new TranslateTransition(Duration.seconds(2), sulfum);
			sTransition.setToX(experimentPanel.getWidth() / 2 - 90);
			sTransition.setToY(reagentPanel.getHeight() / 2 + 30);

			// Анимация для текста атома fe
			TranslateTransition sLabelTransition = new TranslateTransition(Duration.seconds(2), sLabel);
			sLabelTransition.setToX(experimentPanel.getWidth() / 2 - 70);
			sLabelTransition.setToY(reagentPanel.getHeight() / 2 + 30);

			// Анимация для атома s
			TranslateTransition feTransition = new TranslateTransition(Duration.seconds(2), ferrum);
			feTransition.setToX(-experimentPanel.getWidth() / 2 + 95);
			feTransition.setToY(-reagentPanel.getHeight() / 2);

			// Анимация для текста атома s
			TranslateTransition feLabelTransition = new TranslateTransition(Duration.seconds(2), feLabel);
			feLabelTransition.setToX(-experimentPanel.getWidth() / 2 + 115);
			feLabelTransition.setToY(-reagentPanel.getHeight() / 2);

			// После завершения анимации — показать финальную молекулу воды
			// Timeline finalAnimation = new Timeline(
			// new KeyFrame(Duration.seconds(2), new KeyValue(oxygen.fillProperty(),
			// Color.PURPLE)));

			// Запускаем анимации
			sTransition.play();
			feTransition.play();
			sLabelTransition.play();
			feLabelTransition.play();

			// После завершения анимации запускаем финальный эффект
			feTransition.setOnFinished(event -> {
				Line line1 = new Line();

				// Вычисляем координаты границ кругов
				double angle1 = Math.atan2(ferrum.getCenterY() - sulfum.getCenterY(),
						ferrum.getCenterX() - sulfum.getCenterX());

				double x1 = sulfum.getCenterX() + sulfum.getRadius() * Math.cos(angle1);
				double y1 = sulfum.getCenterY() + sulfum.getRadius() * Math.sin(angle1);

				double angle2 = Math.atan2(sulfum.getCenterY() - ferrum.getCenterY(),
						sulfum.getCenterX() - ferrum.getCenterX());

				double x2 = ferrum.getCenterX() + ferrum.getRadius() * Math.cos(angle2);
				double y2 = ferrum.getCenterY() + ferrum.getRadius() * Math.sin(angle2);

				// Устанавливаем координаты линии
				line1.setStartX(x1);
				line1.setStartY(y1);
				line1.setEndX(x2);
				line1.setEndY(y2);
				experimentPanel.getChildren().addAll(line1);
			});
		}
		// 2Fe + 3Cl2 = 2FeCl3
		if (((selectedReagents.toArray()[0] == reagents[5]) || (selectedReagents.toArray()[1] == reagents[5]))
				&& (selectedReagents.toArray()[0] == reagents[8]) || (selectedReagents.toArray()[1] == reagents[8])) {
			experimentDescription.appendText(Experiment.makeDiscription(4));

		}
		// S + O2 = SO2
		if (((selectedReagents.toArray()[0] == reagents[0]) || (selectedReagents.toArray()[1] == reagents[0]))
				&& (selectedReagents.toArray()[0] == reagents[7]) || (selectedReagents.toArray()[1] == reagents[7])) {
			experimentDescription.appendText(Experiment.makeDiscription(5));
			// Создаем атомы водорода (маленькие синие круги)
			Circle oxygen1 = new Circle(50);
			Circle oxygen2 = new Circle(50);

			// Создаем атом кислорода (большой красный круг)

			Circle sulfum = new Circle(70);

			// Устанавливаем градиент как заливку круга
			oxygen1.setFill(gradient);
			oxygen2.setFill(gradient);
			sulfum.setFill(gradient4);

			oxygen1.setLayoutX(experimentPanel.getWidth() / 50);
			oxygen1.setLayoutY(reagentPanel.getHeight() + experimentPanel.getHeight() / 6);
			sulfum.setLayoutX(experimentPanel.getWidth() - experimentPanel.getWidth() / 12);
			sulfum.setLayoutY(reagentPanel.getHeight() + experimentPanel.getHeight() / 3);
			oxygen2.setLayoutX(experimentPanel.getWidth() / 50);
			oxygen2.setLayoutY(reagentPanel.getHeight() + experimentPanel.getHeight() / 3);

			// Текстовые метки для обозначения атомов

			Text o1Label = new Text(oxygen1.getCenterX() - 10,
					oxygen1.getCenterY() + reagentPanel.getHeight() + experimentPanel.getHeight() / 6 + 20, "H");
			Text o2Label = new Text(oxygen2.getCenterX() - 10,
					oxygen2.getCenterY() + reagentPanel.getHeight() + experimentPanel.getHeight() / 6 + 90, "H");
			Text sLabel = new Text(
					sulfum.getCenterX() - 10 + experimentPanel.getWidth() - experimentPanel.getWidth() / 12,
					sulfum.getCenterY() + reagentPanel.getHeight() + experimentPanel.getHeight() / 3 - 40, "S");
			// Добавляем атомы в основной Pane
			experimentPanel.getChildren().addAll(oxygen1, sulfum, oxygen2, o1Label, o2Label, sLabel);

			// Анимация для первого атома кислорода
			TranslateTransition o1Transition = new TranslateTransition(Duration.seconds(2), oxygen1);
			o1Transition.setToX(experimentPanel.getWidth() / 2 - 90);
			o1Transition.setToY(reagentPanel.getHeight() / 2 + 50);

			// Анимация для второго атома кислорода
			TranslateTransition o2Transition = new TranslateTransition(Duration.seconds(2), oxygen2);
			o2Transition.setToX(experimentPanel.getWidth() / 2 + 50);
			o2Transition.setToY(reagentPanel.getHeight() / 2 - 20);

			// Анимация для текста первого атома кислорода
			TranslateTransition h1LabelTransition = new TranslateTransition(Duration.seconds(2), o1Label);
			h1LabelTransition.setToX(experimentPanel.getWidth() / 2 - 70);
			h1LabelTransition.setToY(reagentPanel.getHeight() / 2 + 50);

			// Анимация для текста второго атома кислорода
			TranslateTransition o2LabelTransition = new TranslateTransition(Duration.seconds(2), o2Label);
			o2LabelTransition.setToX(experimentPanel.getWidth() / 2 + 70);
			o2LabelTransition.setToY(reagentPanel.getHeight() / 2 - 20);

			// Анимация для атома серы
			TranslateTransition sTransition = new TranslateTransition(Duration.seconds(2), sulfum);
			sTransition.setToX(-experimentPanel.getWidth() / 2 + 95);
			sTransition.setToY(-reagentPanel.getHeight() / 2);

			// Анимация для текста атома серы
			TranslateTransition sLabelTransition = new TranslateTransition(Duration.seconds(2), sLabel);
			sLabelTransition.setToX(-experimentPanel.getWidth() / 2 + 115);
			sLabelTransition.setToY(-reagentPanel.getHeight() / 2);

			// После завершения анимации — показать финальную молекулу воды
			// Timeline finalAnimation = new Timeline(
			// new KeyFrame(Duration.seconds(2), new KeyValue(oxygen.fillProperty(),
			// Color.PURPLE)));

			// Запускаем анимации
			o1Transition.play();
			o2Transition.play();
			sTransition.play();
			h1LabelTransition.play();
			o2LabelTransition.play();
			sLabelTransition.play();

			// После завершения анимации запускаем финальный эффект
			sTransition.setOnFinished(event -> {
				Line line1 = new Line();
				Line line2 = new Line(sulfum.getCenterX(), sulfum.getCenterY(), oxygen2.getCenterX(),
						oxygen2.getCenterY());

				// Вычисляем координаты границ кругов
				double angle1 = Math.atan2(sulfum.getCenterY() - oxygen1.getCenterY(),
						sulfum.getCenterX() - oxygen1.getCenterX());

				double x1 = oxygen1.getCenterX() + oxygen1.getRadius() * Math.cos(angle1);
				double y1 = oxygen1.getCenterY() + oxygen1.getRadius() * Math.sin(angle1);

				double angle2 = Math.atan2(oxygen1.getCenterY() - sulfum.getCenterY(),
						oxygen1.getCenterX() - sulfum.getCenterX());

				double x2 = sulfum.getCenterX() + sulfum.getRadius() * Math.cos(angle2);
				double y2 = sulfum.getCenterY() + sulfum.getRadius() * Math.sin(angle2);

				// Устанавливаем координаты линии
				line1.setStartX(x1);
				line1.setStartY(y1);
				line1.setEndX(x2);
				line1.setEndY(y2);
				experimentPanel.getChildren().addAll(line1, line2);
			});

		}
		// 2SO2 + O2 = 2SO3
		if (((selectedReagents.toArray()[0] == reagents[0]) || (selectedReagents.toArray()[1] == reagents[0]))
				&& (selectedReagents.toArray()[0] == reagents[9]) || (selectedReagents.toArray()[1] == reagents[9])) {
			experimentDescription.appendText(Experiment.makeDiscription(6));

		}
		// H2 + S = H2S
		if (((selectedReagents.toArray()[0] == reagents[1]) || (selectedReagents.toArray()[1] == reagents[1]))
				&& (selectedReagents.toArray()[0] == reagents[7]) || (selectedReagents.toArray()[1] == reagents[7])) {
			experimentDescription.appendText(Experiment.makeDiscription(7));
			// Создаем атомы водорода (маленькие синие круги)
			Circle hydrogen1 = new Circle(50);
			Circle hydrogen2 = new Circle(50);

			// Создаем атом кислорода (большой красный круг)

			Circle sulfum = new Circle(70);

			// Устанавливаем градиент как заливку круга
			hydrogen1.setFill(gradient1);
			hydrogen2.setFill(gradient1);
			sulfum.setFill(gradient4);

			hydrogen1.setLayoutX(experimentPanel.getWidth() / 50);
			hydrogen1.setLayoutY(reagentPanel.getHeight() + experimentPanel.getHeight() / 6);
			sulfum.setLayoutX(experimentPanel.getWidth() - experimentPanel.getWidth() / 12);
			sulfum.setLayoutY(reagentPanel.getHeight() + experimentPanel.getHeight() / 3);
			hydrogen2.setLayoutX(experimentPanel.getWidth() / 50);
			hydrogen2.setLayoutY(reagentPanel.getHeight() + experimentPanel.getHeight() / 3);

			// Текстовые метки для обозначения атомов

			Text h1Label = new Text(hydrogen1.getCenterX() - 10,
					hydrogen1.getCenterY() + reagentPanel.getHeight() + experimentPanel.getHeight() / 6 + 20, "H");
			Text h2Label = new Text(hydrogen2.getCenterX() - 10,
					hydrogen2.getCenterY() + reagentPanel.getHeight() + experimentPanel.getHeight() / 6 + 90, "H");
			Text oLabel = new Text(
					sulfum.getCenterX() - 10 + experimentPanel.getWidth() - experimentPanel.getWidth() / 12,
					sulfum.getCenterY() + reagentPanel.getHeight() + experimentPanel.getHeight() / 3 - 40, "S");
			// Добавляем атомы в основной Pane
			experimentPanel.getChildren().addAll(hydrogen1, sulfum, hydrogen2, h1Label, h2Label, oLabel);

			// Анимация для первого атома водорода
			TranslateTransition hydrogen1Transition = new TranslateTransition(Duration.seconds(2), hydrogen1);
			hydrogen1Transition.setToX(experimentPanel.getWidth() / 2 - 90);
			hydrogen1Transition.setToY(reagentPanel.getHeight() / 2 + 70);

			// Анимация для второго атома водорода
			TranslateTransition hydrogen2Transition = new TranslateTransition(Duration.seconds(2), hydrogen2);
			hydrogen2Transition.setToX(experimentPanel.getWidth() / 2 + 50);
			hydrogen2Transition.setToY(reagentPanel.getHeight() / 2);

			// Анимация для текста первого атома водорода
			TranslateTransition h1LabelTransition = new TranslateTransition(Duration.seconds(2), h1Label);
			h1LabelTransition.setToX(experimentPanel.getWidth() / 2 - 70);
			h1LabelTransition.setToY(reagentPanel.getHeight() / 2 + 70);

			// Анимация для текста второго атома водорода
			TranslateTransition h2LabelTransition = new TranslateTransition(Duration.seconds(2), h2Label);
			h2LabelTransition.setToX(experimentPanel.getWidth() / 2 + 70);
			h2LabelTransition.setToY(reagentPanel.getHeight() / 2);

			// Анимация для атома кислорода
			TranslateTransition oxygenTransition = new TranslateTransition(Duration.seconds(2), sulfum);
			oxygenTransition.setToX(-experimentPanel.getWidth() / 2 + 95);
			oxygenTransition.setToY(-reagentPanel.getHeight() / 2);

			// Анимация для текста атома кислорода
			TranslateTransition oLabelTransition = new TranslateTransition(Duration.seconds(2), oLabel);
			oLabelTransition.setToX(-experimentPanel.getWidth() / 2 + 115);
			oLabelTransition.setToY(-reagentPanel.getHeight() / 2);

			// Запускаем анимации
			hydrogen1Transition.play();
			hydrogen2Transition.play();
			oxygenTransition.play();
			h1LabelTransition.play();
			h2LabelTransition.play();
			oLabelTransition.play();

			// После завершения анимации запускаем финальный эффект
			oxygenTransition.setOnFinished(event -> {
				Line line1 = new Line();
				Line line2 = new Line(sulfum.getCenterX(), sulfum.getCenterY(), hydrogen2.getCenterX(),
						hydrogen2.getCenterY());

				// Вычисляем координаты границ кругов
				double angle1 = Math.atan2(sulfum.getCenterY() - hydrogen1.getCenterY(),
						sulfum.getCenterX() - hydrogen1.getCenterX());

				double x1 = hydrogen1.getCenterX() + hydrogen1.getRadius() * Math.cos(angle1);
				double y1 = hydrogen1.getCenterY() + hydrogen1.getRadius() * Math.sin(angle1);

				double angle2 = Math.atan2(hydrogen1.getCenterY() - sulfum.getCenterY(),
						hydrogen1.getCenterX() - sulfum.getCenterX());

				double x2 = sulfum.getCenterX() + sulfum.getRadius() * Math.cos(angle2);
				double y2 = sulfum.getCenterY() + sulfum.getRadius() * Math.sin(angle2);

				// Устанавливаем координаты линии
				line1.setStartX(x1);
				line1.setStartY(y1);
				line1.setEndX(x2);
				line1.setEndY(y2);
				experimentPanel.getChildren().addAll(line1, line2);
			});
		}

		// SO3 + H2O = H2SO4";
		if (((selectedReagents.toArray()[0] == reagents[2]) || (selectedReagents.toArray()[1] == reagents[2]))
				&& (selectedReagents.toArray()[0] == reagents[10]) || (selectedReagents.toArray()[1] == reagents[10])) {
			experimentDescription.appendText(makeDiscription(8));

		}

		// 2KOH + H2SO4 = KHSO4
		if (((selectedReagents.toArray()[0] == reagents[11]) || (selectedReagents.toArray()[1] == reagents[11]))
				&& (selectedReagents.toArray()[0] == reagents[12]) || (selectedReagents.toArray()[1] == reagents[12])) {
			experimentDescription.appendText(makeDiscription(9));

		}

		// Cu + O2 = CuO2
		if (((selectedReagents.toArray()[0] == reagents[0]) || (selectedReagents.toArray()[1] == reagents[0]))
				&& (selectedReagents.toArray()[0] == reagents[6]) || (selectedReagents.toArray()[1] == reagents[6])) {
			experimentDescription.appendText(makeDiscription(10));
			// Создаем атомы 
			Circle oxygen1 = new Circle(50);
			Circle oxygen2 = new Circle(50);
			Circle cuprum = new Circle(70);

			// Устанавливаем градиент как заливку круга
			oxygen1.setFill(gradient);
			oxygen2.setFill(gradient);
			cuprum.setFill(gradient3);

			oxygen1.setLayoutX(experimentPanel.getWidth() / 50);
			oxygen1.setLayoutY(reagentPanel.getHeight() + experimentPanel.getHeight() / 6);
			cuprum.setLayoutX(experimentPanel.getWidth() - experimentPanel.getWidth() / 12);
			cuprum.setLayoutY(reagentPanel.getHeight() + experimentPanel.getHeight() / 3);
			oxygen2.setLayoutX(experimentPanel.getWidth() / 50);
			oxygen2.setLayoutY(reagentPanel.getHeight() + experimentPanel.getHeight() / 3);

			Text o1Label = new Text(oxygen1.getCenterX() - 10,
					oxygen1.getCenterY() + reagentPanel.getHeight() + experimentPanel.getHeight() / 6 + 20, "O");
			Text o2Label = new Text(oxygen2.getCenterX() - 10,
					oxygen2.getCenterY() + reagentPanel.getHeight() + experimentPanel.getHeight() / 6 + 90, "O");
			Text cuLabel = new Text(
					cuprum.getCenterX() - 10 + experimentPanel.getWidth() - experimentPanel.getWidth() / 12,
					cuprum.getCenterY() + reagentPanel.getHeight() + experimentPanel.getHeight() / 3 - 40, "Cu");
			// Добавляем атомы в основной Pane
			experimentPanel.getChildren().addAll(oxygen1, cuprum, oxygen2, o1Label, o2Label, cuLabel);

			// Анимация для первого атома кислорода
			TranslateTransition o1Transition = new TranslateTransition(Duration.seconds(2), oxygen1);
			o1Transition.setToX(experimentPanel.getWidth() / 2 - 90);
			o1Transition.setToY(reagentPanel.getHeight() / 2 + 70);

			// Анимация для второго атома кислорода
			TranslateTransition o2Transition = new TranslateTransition(Duration.seconds(2), oxygen2);
			o2Transition.setToX(experimentPanel.getWidth() / 2 + 50);
			o2Transition.setToY(reagentPanel.getHeight() / 2);

			// Анимация для текста первого атома кислорода
			TranslateTransition o1LabelTransition = new TranslateTransition(Duration.seconds(2), o1Label);
			o1LabelTransition.setToX(experimentPanel.getWidth() / 2 - 70);
			o1LabelTransition.setToY(reagentPanel.getHeight() / 2 + 70);

			// Анимация для текста второго атома водорода
			TranslateTransition o2LabelTransition = new TranslateTransition(Duration.seconds(2), o2Label);
			o2LabelTransition.setToX(experimentPanel.getWidth() / 2 + 70);
			o2LabelTransition.setToY(reagentPanel.getHeight() / 2);

			// Анимация для атома меди
			TranslateTransition cuTransition = new TranslateTransition(Duration.seconds(2), cuprum);
			cuTransition.setToX(-experimentPanel.getWidth() / 2 + 95);
			cuTransition.setToY(-reagentPanel.getHeight() / 2);

			// Анимация для текста атома меди
			TranslateTransition cuLabelTransition = new TranslateTransition(Duration.seconds(2), cuLabel);
			cuLabelTransition.setToX(-experimentPanel.getWidth() / 2 + 115);
			cuLabelTransition.setToY(-reagentPanel.getHeight() / 2);

			// Запускаем анимации
			o1Transition.play();
			o2Transition.play();
			cuTransition.play();
			o1LabelTransition.play();
			o2LabelTransition.play();
			cuLabelTransition.play();

		}
	}
}
