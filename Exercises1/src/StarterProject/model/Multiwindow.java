package StarterProject.model;
import java.util.ArrayList;
import java.util.List;

    public class Multiwindow {
        private boolean senderOpen = false;
        private boolean receiverOpen = false;
        private List<String> messages = new ArrayList<>();
        private String data;
        public boolean isSenderOpen() {
            return senderOpen;
        }

        public void setSenderOpen(boolean senderOpen) {
            this.senderOpen = senderOpen;
        }

        public boolean isReceiverOpen() {
            return receiverOpen;
        }

        public void setReceiverOpen(boolean receiverOpen) {
            this.receiverOpen = receiverOpen;
        }

        public List<String> getMessages() {
            return messages;
        }

        public void addMessage(String message) {
            messages.add(message);
        }
    }