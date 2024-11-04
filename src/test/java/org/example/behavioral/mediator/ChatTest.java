package org.example.behavioral.mediator;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ChatTest {

    @Test
    public void test() {
        TextChat chat = new TextChat();
        Admin admin = new Admin(chat, "Ivan Vasilievich");
        SimpleUser user1 = new SimpleUser(chat, "Oleg");
        SimpleUser user2 = new SimpleUser(chat, "Pasha");

        chat.setAdmin(admin);
        chat.addUser(user1);
        chat.addUser(user2);

        user1.sendMessage("Hello!");
        user2.sendMessage("Hi!");
        user1.sendMessage("You $@$$@!");
        admin.sendMessage("Be polite");

        assertEquals(Arrays.asList("Pasha: Hi!", "[Admin] Ivan Vasilievich: Be polite"), user1.getMessages());
        assertEquals(Arrays.asList("Oleg: Hello!", "Oleg: You $@$$@!", "[Admin] Ivan Vasilievich: Be polite"), user2.getMessages());
        assertEquals(Arrays.asList("Oleg: Hello!", "Pasha: Hi!", "Oleg: You $@$$@!", "[Admin] Ivan Vasilievich: Be polite"), admin.getMessages());
    }
}
