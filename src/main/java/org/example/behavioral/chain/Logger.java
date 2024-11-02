package org.example.behavioral.chain;

enum Priority {
    ERROR(1),
    WARN(2),
    INFO(3);

    final int scale;

    Priority(int scale) {
        this.scale = scale;
    }

    public boolean isWorseOrEqualThan(Priority other) {
        return this.scale <= other.scale;
    }
}

public interface Logger {
    String log(String message, Priority priority);
    Logger setNext(Logger next);
}

class BaseLogger implements Logger {

    private Logger next;
    private Priority basePriority;
    private String prefix;

    public BaseLogger(String prefix, Priority basePriority) {
        this.prefix = prefix;
        this.basePriority = basePriority;
    }

    @Override
    public String log(String message, Priority priority) {
        String result = "";
        if (priority.isWorseOrEqualThan(basePriority)) {
            result = prefix + ": [" + priority + "] " + message;
        }
        if (next != null) {
            result += next.log(message, priority);
        }
        return result;
    }

    @Override
    public Logger setNext(Logger next) {
        this.next = next;
        return next;
    }
}

class SmsLogger extends BaseLogger {
    public SmsLogger() {
        super("SMS", Priority.ERROR);
    }
}

class EmailLogger extends BaseLogger {
    public EmailLogger() {
        super("Email", Priority.WARN);
    }
}

class ConsoleLogger extends BaseLogger {
    public ConsoleLogger() {
        super("Console", Priority.INFO);
    }
}