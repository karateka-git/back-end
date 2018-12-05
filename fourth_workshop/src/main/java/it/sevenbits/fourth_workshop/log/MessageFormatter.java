package it.sevenbits.fourth_workshop.log;

// TODO: make Map
public class MessageFormatter {

    public String getStringFormatByType(final String type) {
        if (type.equals("MESSAGE")) {
            return "Part of message: %1$s";
        } else if (type.equals("TRASH")) {
            return "Trash received";
        } else if (type.equals("MESSAGE_START")) {
            return "Message creating started";
        } else if (type.equals("MESSAGE_FINISH")) {
            return "Message creating finished";
        }

        return "Unknown package type";
    }
}
