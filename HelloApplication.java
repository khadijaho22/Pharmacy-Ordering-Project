package com.example.demo6;

import javafx.scene.control.Label;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Alert;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

import javafx.geometry.Insets;
import javafx.geometry.Pos;

import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.scene.control.TextField;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.Group;
import javafx.scene.shape.Rectangle;
import javafx.scene.layout.StackPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

import java.util.concurrent.atomic.AtomicReference;

public class HelloApplication extends Application {

    int id = 0, quantity=0;
    double price = 0.0;
    int cathadd= 0;
    char c;
    public String selectedOptionString = "other";
    boolean flag = true;

    @Override
    public void start(Stage stage) throws IOException {
        //create object from class pharmacy
        Pharmacy pharmacy = new Pharmacy();
       // FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));

        stage.setTitle("Hayaah Pharmacy");
        stage.getIcons().add(new Image("E:icon.jpg"));
        Group root = new Group();
        Scene scene = new Scene(root,600,450);
        Rectangle rectangle = new Rectangle();
        //Setting the properties of the rectangle
        rectangle.setX(0.0f);
        rectangle.setY(0.0f);
        rectangle.setWidth(230.0f);
        rectangle.setHeight(450.0f);
        rectangle.setFill(Color.STEELBLUE);

        StackPane r = new StackPane();
        stage.setScene(scene);
        Text text = new Text();
        text.setText("Hayaah Pharmacy");
        text.setX(45);
        text.setY(226);
        text.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
        text.setFill(Color.WHITESMOKE);
        Text setCapacity = new Text();
        setCapacity.setText("Enter capacity of the pharmacy");
        setCapacity.setX(250);
        setCapacity.setY(100);
        Text Enter = new Text();
        Enter.setText("Capacity");
        Enter.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 10));
        Enter.setX(250);
        Enter.setY(180);
        Button button = new Button();
        Button button1 = new Button();
        //Setting text to the button
        button.setText("Enter");
//        button.setOnAction(e -> isInt(nameInput,nameInput.getText()));
        TextField userInput = new TextField();
        Label label = new Label();
        userInput.setPadding(new Insets(10, 10,10,10));
        //userInput.setMinSize(100,220);
        userInput.setAlignment( Pos.BASELINE_CENTER);
        userInput.setLayoutX(250);
        userInput.setLayoutY(190);
        button.setOnAction(event -> {

            try {

                int value = Integer.parseInt(userInput.getText());
                    if (value <= 0) {
                        //throw new NumberFormatException();
                        Alert alert = new Alert(Alert.AlertType.ERROR, "Please enter a valid number ");
                        alert.showAndWait();
                        flag = false;
                    }
                    else{
                        flag = true;
                    }
                    if(flag) {
                        pharmacy.setCapacity(value);
                        System.out.println(pharmacy.getCapacity());
                        if (value < 0) value = 0;
                        label.setText("Pharmacy capacity now " + value);
                        label.setLayoutX(250);
                        label.setLayoutY(300);
                        Stage newStage = new Stage();
                        VBox layout = new VBox(10);

                        //layout.getChildren().addAll(new Text("Capacity"));
                        Scene newScene = new Scene(layout, 600, 450);
                        newStage.setTitle("Hayaah pharmacy");
                        newStage.getIcons().add(new Image("E:icon.jpg"));

                        MenuBar menuBar = new MenuBar();
                        Menu optionsMenu = new Menu("Choose an option");

                        // Create MenuItems and add them to the Options Menu
                        MenuItem nameItem = new MenuItem("Add Drug");
                        MenuItem placeAnOrder = new MenuItem("Place an order");
                        MenuItem removeItem = new MenuItem("Remove Drug");
                        MenuItem totalSale = new MenuItem("get Total sale for one day");
                        MenuItem exitItem = new MenuItem("Exit");
                        optionsMenu.getItems().addAll(nameItem, removeItem, placeAnOrder, totalSale, exitItem);

                        // Add Options Menu to MenuBar
                        menuBar.getMenus().add(optionsMenu);
                        menuBar.setStyle("-fx-background-color: STEELBLUE;");

                        //gridpane


                        //Creating a Grid Pane
                        GridPane gridPane = new GridPane();


                        gridPane.setVisible(false);


                        // Add event handlers for the MenuItems
                        removeItem.setOnAction(even -> {
                            gridPane.getChildren().clear();
                            gridPane.setVisible(true);
                            // removeGrid.setVisible(true);


                            //gridPane.setVisible(false);

                            gridPane.setMinSize(500, 500);
                            gridPane.setStyle("-fx-background-color: BEIGE;");
                            Text IDl = new Text("Enter ID of item to be removed");
                            TextField IDt = new TextField();
                            Button b1remove = new Button("Remove");
                            gridPane.setPadding(new Insets(10, 10, 10, 10));
                            gridPane.setVgap(5);
                            gridPane.setHgap(5);
                            gridPane.add(IDl, 0, 0);
                            gridPane.add(IDt, 1, 0);
                            b1remove.setStyle(
                                    "-fx-background-color:STEELBLUE; -fx-textfill: white;");

                            IDl.setStyle("-fx-font: normal bold 15px 'serif' ");
                            gridPane.add(b1remove, 27, 30);
                            b1remove.setOnAction(eve -> {
                                try {
                                    int idre = Integer.parseInt(IDt.getText());
                                    if (pharmacy.removeDrug(idre)) {
                                        System.out.println("removeddddd");
                                        label.setText("removed successfully");
                                        label.setStyle("-fx-font: normal bold 15px 'serif'");
                                        gridPane.getChildren().remove(label);
                                    } else {
                                        label.setText("Drug ID is not found");
                                        label.setStyle("-fx-font: normal bold 15px 'serif'");
                                        gridPane.getChildren().remove(label);
                                    }
                                } catch (NumberFormatException e) {
                                    Alert alert = new Alert(Alert.AlertType.ERROR, "Please enter a valid ID ");
                                    alert.showAndWait();

                                    //return;
                                }

                                gridPane.add(label, 1, 25);
                            });


                        });
                        nameItem.setOnAction(even -> {
                            // removeGrid.setVisible(false);
                            gridPane.getChildren().clear();
                            gridPane.setVisible(true);


                            //Setting size for the pane
                            gridPane.setMinSize(500, 500);

                            //Setting the padding

                            gridPane.setStyle("-fx-background-color: BEIGE;");
                            Text nameLabel = new Text("Drug Name");
                            TextField nameText = new TextField();


                            Text PriceLabel = new Text("Drug Price");
                            TextField PriceText = new TextField();

                            Text quantityLabel = new Text("Drug quantity");
                            TextField quantityText = new TextField();

                            Text categoryLabel = new Text("category");

                            //Choice box for location
                            ChoiceBox locationchoiceBox = new ChoiceBox();
                            locationchoiceBox.getItems().addAll("cosmetics", "prescription drugs", "other");

                            Button buttonRegister = new Button("Add");
                            gridPane.setPadding(new Insets(10, 10, 10, 10));
                            gridPane.setVgap(5);
                            gridPane.setHgap(5);

                            //Setting the Grid alignment
                            //gridPane.setAlignment(Pos.CENTER);
                            gridPane.add(nameLabel, 0, 0);
                            gridPane.add(nameText, 1, 0);


                            gridPane.add(PriceLabel, 0, 11);
                            gridPane.add(PriceText, 1, 11);

                            gridPane.add(quantityLabel, 0, 15);
                            gridPane.add(quantityText, 1, 15);

                            gridPane.add(categoryLabel, 0, 18);
                            gridPane.add(locationchoiceBox, 1, 18);

                            buttonRegister.setStyle(
                                    "-fx-background-color:STEELBLUE; -fx-textfill: white;");

                            nameLabel.setStyle("-fx-font: normal bold 15px 'serif' ");

                            PriceLabel.setStyle("-fx-font: normal bold 15px 'serif'");
                            quantityLabel.setStyle("-fx-font: normal bold 15px 'serif'");
                            categoryLabel.setStyle("-fx-font: normal bold 15px 'serif' ");
                            gridPane.add(buttonRegister, 27, 30);

                            //store drug data
                            Label label1 = new Label("hiii");
                            Text IDlabel = new Text("Drug ID");
                            TextField IDText = new TextField();
                            gridPane.add(IDlabel, 0, 7);
                            IDlabel.setStyle("-fx-font: normal bold 15px 'serif'");
                            gridPane.add(IDText, 1, 7);


                            buttonRegister.setOnAction(eve -> {
                                String name = nameText.getText();
                                cathadd = 0;
                                try {
                                    id = Integer.parseInt(IDText.getText());
                                } catch (NumberFormatException e) {
                                    Alert alert = new Alert(Alert.AlertType.ERROR, "Please enter a valid ID ");
                                    alert.showAndWait();
                                    cathadd = 1;
                                    label.setText("can't add");
                                    label.setStyle("-fx-font: normal bold 15px 'serif'");
                                    gridPane.getChildren().remove(label);
                                    //return;
                                }
                                try {
                                    price = Double.parseDouble(PriceText.getText());
                                } catch (NumberFormatException e) {
                                    Alert alert = new Alert(Alert.AlertType.ERROR, "Please enter a valid Price ");
                                    alert.showAndWait();
                                    label.setText("can't add");
                                    label.setStyle("-fx-font: normal bold 15px 'serif'");
                                    gridPane.getChildren().remove(label);
                                    cathadd = 1;
                                    //return;
                                }
                                try {
                                    quantity = Integer.parseInt(quantityText.getText());
                                } catch (NumberFormatException e) {
                                    Alert alert = new Alert(Alert.AlertType.ERROR, "Please enter a valid quantity ");
                                    alert.showAndWait();
                                    label.setText("can't add");
                                    label.setStyle("-fx-font: normal bold 15px 'serif'");
                                    gridPane.getChildren().remove(label);
                                    cathadd = 1;
                                    //return;
                                }
                                locationchoiceBox.setOnAction(e -> {
                                    //String x = (String) locationchoiceBox.getValue();
                                    //selectedOptionString ="";
                                    if (locationchoiceBox.getValue() == "other") {
                                        selectedOptionString = "other";
                                    } else if (locationchoiceBox.getValue() == "prescription drugs") {
                                        selectedOptionString = "prescription drugs";
                                    } else {
                                        selectedOptionString = "cosmetics";
                                    }
                                });
                                System.out.println("hu" + selectedOptionString);


                                // String selectedOption = (String) locationchoiceBox.getValue();

                                if (cathadd == 0) {


                                    if (pharmacy.addDrug(name, id, price, selectedOptionString, quantity)) {
                                        System.out.println("added nehaw");
                                        label.setText("DRUG ADDED");
                                        label.setStyle("-fx-font: normal bold 15px 'serif'");
                                        gridPane.getChildren().remove(label);

                                    } else {
                                        System.out.println("cant add");

                                        label.setText("Capacity is Full, can't add");
                                        label.setStyle("-fx-font: normal bold 15px 'serif'");
                                        gridPane.getChildren().remove(label);
                                        cathadd = 0;
                                    }
                                }


                                gridPane.add(label, 0, 30);


                            });


                        });


                        placeAnOrder.setOnAction(even -> {
                            gridPane.getChildren().clear();
                            gridPane.setVisible(true);


                            gridPane.setMinSize(500, 500);
                            gridPane.setStyle("-fx-background-color: BEIGE;");
                            Text IDl = new Text("Enter ID to place an order");
                            TextField IDt = new TextField();
                            Button b1remove = new Button("place");
                            gridPane.setPadding(new Insets(10, 10, 10, 10));
                            gridPane.setVgap(5);
                            gridPane.setHgap(5);
                            gridPane.add(IDl, 0, 0);
                            gridPane.add(IDt, 1, 0);
                            b1remove.setStyle(
                                    "-fx-background-color:STEELBLUE; -fx-textfill: white;");

                            IDl.setStyle("-fx-font: normal bold 15px 'serif' ");
                            gridPane.add(b1remove, 27, 40);
                            b1remove.setOnAction(eve -> {
                                try {
                                    int idre = Integer.parseInt(IDt.getText());
                                    double p = pharmacy.placeAnorder(idre);

                                    if (p != 0) {
                                        //Text printPrice = new Text("item price: "+ p);
                                        //printPrice.setStyle();
                                        System.out.println("pricee" + p);
                                        label.setText("item price " + p);
                                        label.setStyle("-fx-font: normal bold 15px 'serif'");
                                        gridPane.getChildren().remove(label);

                                        //gridPane.getChildren().remove(printPrice);
                                    } else {
                                        gridPane.getChildren().remove(label);
                                        label.setText("Item is Not found now, SORRY");
                                        label.setStyle("-fx-font: normal bold 15px 'serif'");
                                        gridPane.getChildren().remove(label);


                                    }
                                    gridPane.add(label, 0, 10);

                                } catch (NumberFormatException e) {
                                    Alert alert = new Alert(Alert.AlertType.ERROR, "Please enter a valid ID ");


                                    alert.showAndWait();

                                    //return;
                                }


                            });
                        });
                        totalSale.setOnAction(eve -> {
                            gridPane.getChildren().clear();
                            gridPane.setVisible(true);
                            Text printPrice = new Text("total sale: " + pharmacy.getTotalSale());
                            printPrice.setStyle("-fx-font: normal bold 15px 'serif'");
                            gridPane.add(printPrice, 1, 10);
                        });
                        exitItem.setOnAction(even -> {
                            newStage.close();
                            stage.close();
                        });


                        layout.setPadding(new Insets(20));
                        layout.getChildren().add(menuBar);
                        //layout.getChildren().add(removeGrid);
                        layout.getChildren().add(gridPane);
                        //layout.getChildren().add(removeGrid);
                        // layout.getChildren().addAll(removeGrid,gridPane);
                        //layout.getChildren().addAll(gridPane,removeGrid);
                        newStage.setScene(newScene);
                        newStage.show();
                    }

            } catch (NumberFormatException ex) {
                label.setText("Invalid input");
                label.setLayoutX(250);
                label.setLayoutY(300);
            }

        });

        button1.setText("Cancel");
        //Setting the location of the button
        button.setTranslateX(260);
        button.setTranslateY(250);
        button1.setTranslateX(320);
        button1.setTranslateY(250);
        button.setTextFill(Color.BLACK);
        button.setStyle("-fx-background-color: STEELBLUE;");
        button1.setTextFill(Color.BLACK);
        button1.setStyle("-fx-background-color: STEELBLUE;");






        InputStream stream = new FileInputStream("E:R.png");
        Image image = new Image(stream);
        //Creating the image view
        ImageView imageView = new ImageView();
        //Setting image to the image view
        imageView.setImage(image);
        //Setting the image view parameters
        imageView.setX(80);
        imageView.setY(160);
        imageView.setFitWidth(40);
        imageView.setPreserveRatio(true);
        root.getChildren().add(rectangle);
        root.getChildren().add(imageView);
        root.getChildren().add(text);
        root.getChildren().add(setCapacity);
        root.getChildren().add(button);
        root.setStyle("-fx-background-color: #f2f2f2;");
        root.getChildren().add(userInput);
        root.getChildren().add(button1);
        root.getChildren().add(Enter);
        root.getChildren().add(label);



        stage.show();

    }

    public static void main(String[] args) {
        launch();


    }
}