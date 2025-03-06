package StarterProject.presenter;

import StarterProject.model.Multiwindow;
import StarterProject.view.MultiwindowView;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class MultiwindowPresenter {
    private Multiwindow model;
    private MultiwindowView view;

    public MultiwindowPresenter(Multiwindow model, MultiwindowView view) {
        this.model = model;
        this.view = view;

        attachEvents();
    }

    private void attachEvents() {
        // Open Sender Window
        view.getOpenSenderButton().setOnAction(e -> {
            view.openSenderWindow();
            model.setSenderOpen(true);
            attachSenderEvents(); // Attach events after sender window is opened
        });

        // Open Receiver Window
        view.getOpenReceiverButton().setOnAction(e -> {
            view.openReceiverWindow();
            model.setReceiverOpen(true);
            attachReceiverEvents(); // Attach events after receiver window is opened
        });
    }

    private void attachSenderEvents() {
        TextArea senderMessageArea = view.getSenderMessageArea();
        if (senderMessageArea != null) {
            // Event handler for sending messages
            Button sendButton = view.getSendButton();
            if (sendButton != null) {
                sendButton.setOnAction(e -> {
                    String message = view.getMessageField().getText();
                    if (!message.isEmpty()) {
                        model.addMessage(message); // Add message to the model
                        senderMessageArea.appendText("You: " + message + "\n"); // Display in sender window
                        view.getMessageField().clear(); // Clear the text field
                    }
                });
            }
        }
    }

    private void attachReceiverEvents() {
        TextArea receiverMessageArea = view.getReceiverMessageArea();
        if (receiverMessageArea != null) {
            // Event handler for getting messages
            Button getMessageButton = view.getGetMessageButton();
            if (getMessageButton != null) {
                getMessageButton.setOnAction(e -> {
                    StringBuilder messages = new StringBuilder();
                    for (String msg : model.getMessages()) {
                        messages.append("Sender: ").append(msg).append("\n"); // Display messages in receiver window
                    }
                    receiverMessageArea.setText(messages.toString());
                });
            }
        }
    }
}