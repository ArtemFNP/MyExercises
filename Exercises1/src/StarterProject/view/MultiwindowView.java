package StarterProject.view;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MultiwindowView {
    private Stage primaryStage;
    private Button openSenderButton;
    private Button openReceiverButton;
    private TextArea senderMessageArea;
    private TextArea receiverMessageArea;
    private TextField messageField;
    private Button sendButton;
    private Button getMessageButton;

    public MultiwindowView(Stage primaryStage) {
        this.primaryStage = primaryStage;
        initializePrimaryStage();
    }

    private void initializePrimaryStage() {
        VBox root = new VBox(20);
        root.setAlignment(Pos.CENTER);

        openSenderButton = new Button("Open Sender");
        openReceiverButton = new Button("Open Receiver");

        HBox buttonBox = new HBox(20, openSenderButton, openReceiverButton);
        buttonBox.setAlignment(Pos.CENTER);

        root.getChildren().add(buttonBox);

        Scene scene = new Scene(root, 400, 200);
        primaryStage.setTitle("Main Window");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void openSenderWindow() {
        Stage senderStage = new Stage();
        VBox senderLayout = new VBox(20);
        senderLayout.setAlignment(Pos.CENTER);

        Label senderLabel = new Label("Sender Window");
        senderMessageArea = new TextArea();
        senderMessageArea.setEditable(false);
        senderMessageArea.setPrefSize(300, 100);

        messageField = new TextField();
        messageField.setPromptText("Enter your message");

        sendButton = new Button("Send");

        senderLayout.getChildren().addAll(senderLabel, senderMessageArea, messageField, sendButton);

        Scene senderScene = new Scene(senderLayout, 400, 300);
        senderStage.setTitle("Sender Window");
        senderStage.setScene(senderScene);
        senderStage.show();
    }

    public void openReceiverWindow() {
        Stage receiverStage = new Stage();
        VBox receiverLayout = new VBox(20);
        receiverLayout.setAlignment(Pos.CENTER);

        Label receiverLabel = new Label("Receiver Window");
        receiverMessageArea = new TextArea();
        receiverMessageArea.setEditable(false);
        receiverMessageArea.setPrefSize(300, 100);

        getMessageButton = new Button("Get Message");

        receiverLayout.getChildren().addAll(receiverLabel, receiverMessageArea, getMessageButton);

        Scene receiverScene = new Scene(receiverLayout, 400, 300);
        receiverStage.setTitle("Receiver Window");
        receiverStage.setScene(receiverScene);
        receiverStage.show();
    }

    public Button getOpenSenderButton() {
        return openSenderButton;
    }

    public Button getOpenReceiverButton() {
        return openReceiverButton;
    }

    public TextArea getSenderMessageArea() {
        return senderMessageArea;
    }

    public TextArea getReceiverMessageArea() {
        return receiverMessageArea;
    }

    public TextField getMessageField() {
        return messageField;
    }

    public Button getSendButton() {
        return sendButton;
    }

    public Button getGetMessageButton() {
        return getMessageButton;
    }
}