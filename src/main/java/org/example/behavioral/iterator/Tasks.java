package org.example.behavioral.iterator;

interface Iterator {
    boolean hasNext();
    Object next();
}

interface Collection {
    Iterator getIterator();
}

public class Tasks implements Collection {

    String[] tasks = new String[]{"Task1", "Task2", "Task3"};

    @Override
    public Iterator getIterator() {
        return new TaskIterator();
    }

    private class TaskIterator implements Iterator {

        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < tasks.length;
        }

        @Override
        public Object next() {
            return tasks[index++];
        }
    }
}
