package view;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import score.ScoreSet;
import statement.Statement;
import statement.StatementList;

//TODO: Add different background color for each question category
//TODO: Display the qualitative score as well as the guide to the qualitative score in the result
//TODO: Add sliding transition for each questions
//TODO: Fix result screen layout and general look
//TODO: Save score result as image functionality
//TODO: Fix the position to the input button
//TODO: Add welcome screen before first question
public class PeopleSmartSkillTestApp extends Application {
    
    Statement currentStatement = StatementList.getNextStatement();
    Label statementCategoryLabel = new Label(currentStatement.getStatementCategory());
    TextArea statementTextArea = new TextArea(currentStatement.getStatement());
    Label statementNumberLabel = new Label(String.valueOf(StatementList.getIndex()) + "/40");
    
    VBox root = new VBox(5);
    VBox savableScorePane;
    
    Stage mainWindow;
    
    @Override
    public void start(Stage primaryStage) {
        
        statementCategoryLabel.setFont(new Font("Corbel", 40));
        
        statementNumberLabel.setFont(new Font("Corbel", 40));
        
        statementTextArea.setFont(new Font("Rockwell", 30));
        statementTextArea.setWrapText(true);
        statementTextArea.setEditable(false);
        
        Button poorScoreButton = new Button("Poor");
        poorScoreButton.setOnAction(e -> givePoorAnswer());
        Button fairScoreButton = new Button("Fair");
        fairScoreButton.setOnAction(e -> giveFairAnswer());
        Button goodScoreButton = new Button("Good");
        goodScoreButton.setOnAction(e -> giveGoodAnswer());
        Button excellentScoreButton = new Button("Excellent");
        excellentScoreButton.setOnAction(e -> giveExcellentAnswer());
        
        ButtonBar scoreButtonBar = new ButtonBar();
        scoreButtonBar.getButtons().addAll(poorScoreButton, fairScoreButton, goodScoreButton, excellentScoreButton);
        
        AnchorPane headerAnchorPane = new AnchorPane();
        AnchorPane.setLeftAnchor(statementCategoryLabel, Double.valueOf(0));
        AnchorPane.setRightAnchor(statementNumberLabel, Double.valueOf(0));
        headerAnchorPane.getChildren().addAll(statementCategoryLabel, statementNumberLabel);
        
        VBox mainDisplay = new VBox(5);
        mainDisplay.setPrefSize(600, 400);
        mainDisplay.getChildren().addAll(headerAnchorPane, statementTextArea);
        
        root.getChildren().addAll(mainDisplay, scoreButtonBar);
        root.setPadding(new Insets(5));
        
        Scene scene = new Scene(root);
        
        mainWindow = primaryStage;
        mainWindow.setTitle("PeopleSmart Skill Quiz");
        mainWindow.setScene(scene);
        mainWindow.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
    public void givePoorAnswer() {
        this.currentStatement.setScore(1);
        moveToNextStatement();
    }
    
    public void giveFairAnswer() {
        this.currentStatement.setScore(2);
        moveToNextStatement();
    }
    
    public void giveGoodAnswer() {
        this.currentStatement.setScore(3);
        moveToNextStatement();
    }
    
    public void giveExcellentAnswer() {
        this.currentStatement.setScore(4);
        moveToNextStatement();
    }
    
    public void moveToNextStatement() {
        if (StatementList.hasNextStatement()) {
            this.currentStatement = StatementList.getNextStatement();
            statementCategoryLabel.setText(currentStatement.getStatementCategory());
            statementNumberLabel.setText(String.valueOf(StatementList.getIndex()) + "/40");
            statementTextArea.setText(currentStatement.getStatement());
        } else {
            root.getChildren().clear();
            root.getChildren().add(createScorePane());
        }
    }
    
    private VBox createScorePane() {
        ObservableList<ScoreSet> scoreSet = StatementList.getScoreSet();
        
        Label scoreTitleLabel = new Label("PeopleSmart's Skill Test Score - " + LocalDate.now());
        scoreTitleLabel.setFont(Font.font("Corbel", FontWeight.BOLD, 25));
        
        TableColumn categoryCol = new TableColumn("Category");
        categoryCol.setCellValueFactory(new PropertyValueFactory<>("category"));
        TableColumn questionOneCol = new TableColumn("Question 1");
        questionOneCol.setCellValueFactory(new PropertyValueFactory<>("questionOneScore"));
        TableColumn questionTwoCol = new TableColumn("Question 2");
        questionTwoCol.setCellValueFactory(new PropertyValueFactory<>("questionTwoScore"));
        TableColumn questionThreeCol = new TableColumn("Question 3");
        questionThreeCol.setCellValueFactory(new PropertyValueFactory<>("questionThreeScore"));
        TableColumn questionFourCol = new TableColumn("Question 4");
        questionFourCol.setCellValueFactory(new PropertyValueFactory<>("questionFourScore"));
        TableColumn questionFiveCol = new TableColumn("Question 5");
        questionFiveCol.setCellValueFactory(new PropertyValueFactory<>("questionFiveScore"));
        TableColumn totalCol = new TableColumn("Total");
        totalCol.setCellValueFactory(new PropertyValueFactory<>("totalScore"));
        
        TableView scoreTable = new TableView();
        scoreTable.setMinSize(500, 230);
        scoreTable.getColumns().addAll(
                categoryCol, questionOneCol, questionTwoCol, questionThreeCol, questionFourCol, questionFiveCol, totalCol);
        scoreTable.setItems(scoreSet);
        
        Label totalScoreLabel = new Label("Total Score: " + String.valueOf(StatementList.getTotalScore()));
        totalScoreLabel.setFont(Font.font("Corbel", FontWeight.BOLD, 25));
        
        Label perfectScoreReferenceLabel = new Label("Superior = 150");
        Label veryGoodScoreReferenceLabel = new Label("Very Good = 125-149");
        Label averageScoreReferenceLabel = new Label("Average = 100-124");
        Label needImprovementScoreReferenceLabel = new Label("Need Improvement = 40-99");
        
        Button saveScoreAsImageButton = new Button("Save Score as Image");
        saveScoreAsImageButton.setOnAction(e -> {
            try {
                saveScoreAsImage();
            } catch (IOException ex) {
                Logger.getLogger(PeopleSmartSkillTestApp.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        VBox savableScorePane = new VBox(5, 
                scoreTitleLabel,
                scoreTable,
                totalScoreLabel,
                new HBox(10, perfectScoreReferenceLabel,veryGoodScoreReferenceLabel),
                new HBox(10, averageScoreReferenceLabel, needImprovementScoreReferenceLabel));
        this.savableScorePane = savableScorePane;
        
        VBox rootScorePane = new VBox(5, savableScorePane, saveScoreAsImageButton);
        
        return rootScorePane;
    }
    
    private void saveScoreAsImage() throws IOException {
        WritableImage image = new WritableImage(500, 500);
        savableScorePane.snapshot(null, image);
        
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save Score Image");
        fileChooser.setInitialFileName("PeopleSmart Skill Test Score - " + LocalDate.now());
        
        File file = fileChooser.showSaveDialog(mainWindow);
        BufferedImage imageFile = SwingFXUtils.fromFXImage(image, null);
        ImageIO.write(imageFile, "png", file);
    }
}
