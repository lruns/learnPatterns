package org.example.behavioral.mediator;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public interface Chat {
    void sendMessage(String message, User whoSend);
}

interface User {
    void sendMessage(String message);
    void getMessage(String message);
}

abstract class UserImpl implements User {
    private String name;
    private final Chat chat;
    @Getter
    private final List<String> messages = new ArrayList<>();

    public UserImpl(Chat chat, String name) {
        this.chat = chat;
        this.name = name;
    }

    public String messageWrapper(String message) {
        return name + ": " + message;
    }

    @Override
    public void sendMessage(String message) {
        chat.sendMessage(messageWrapper(message), this);
    }

    @Override
    public void getMessage(String message) {
        messages.add(message);
    }
}

class Admin extends UserImpl {

    public Admin(Chat chat, String name) {
        super(chat, name);
    }

    @Override
    public String messageWrapper(String message) {
        return "[Admin] " + super.messageWrapper(message);
    }
}

class SimpleUser extends UserImpl {
    public SimpleUser(Chat chat, String name) {
        super(chat, name);
    }
}



class TextChat implements Chat {
    @Setter
    Admin admin;
    List<User> users = new ArrayList<>();

    public void addUser(User user) {
        users.add(user);
    }

    @Override
    public void sendMessage(String message, User whoSend) {
        for (User user: users) {
            if (!user.equals(whoSend)) {
                user.getMessage(message);
            }
        }
        admin.getMessage(message);
    }
}