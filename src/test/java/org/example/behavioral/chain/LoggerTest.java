package org.example.behavioral.chain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoggerTest {

    @Test
    public void test() {
        Logger logger = new SmsLogger();
        logger.setNext(new EmailLogger())
                .setNext(new ConsoleLogger());

        String input = "Test message";
        String testMessage = logger.log(input, Priority.INFO);
        String testMessage2 = logger.log(input, Priority.WARN);
        String testMessage3 = logger.log(input, Priority.ERROR);

        assertThat(testMessage).contains("Console: [INFO] " + input);
        assertThat(testMessage).doesNotContain("Email");
        assertThat(testMessage).doesNotContain("Sms");

        assertThat(testMessage2).contains("Console: [WARN] " + input);
        assertThat(testMessage2).contains("Email: [WARN] " + input);
        assertThat(testMessage2).doesNotContain("Sms");

        assertThat(testMessage3).contains("Console: [ERROR] " + input);
        assertThat(testMessage3).contains("Email: [ERROR] " + input);
        assertThat(testMessage3).contains("SMS: [ERROR] " + input);

    }
}
