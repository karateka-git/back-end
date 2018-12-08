package it.sevenbits.fourth_workshop.log;

import java.util.HashMap;
import java.util.Map;

// TODO: make Map
public class MessageFormatter {
    private final Map<String, String> strings;

    public MessageFormatter() {
        strings = new HashMap<>();
        strings.put("MESSAGE", "Part of message: %1$s");
        strings.put("TRASH", "Trash received");
        strings.put("MESSAGE_START", "Message creating started");
        strings.put("MESSAGE_FINISH", "Message creating finished");
    }

    public String getStringFormatByType(final String type) {

//        if (type.equals("MESSAGE")) {
//            return "Part of message: %1$s";
//        } else if (type.equals("TRASH")) {
//            return "Trash received";
//        } else if (type.equals("MESSAGE_START")) {
//            return "Message creating started";
//        } else if (type.equals("MESSAGE_FINISH")) {
//            return "Message creating finished";
//        }
//
//        return "Unknown package type";
        String defaultString =  "Unknown package type";
        return strings.getOrDefault(type, defaultString);

    }
}
