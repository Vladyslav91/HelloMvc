package com.course;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Controller {

    private static final String ENTER_TEXT = "Enter please: ";
    private static final String HELLO = "Hello";
    private static final String WORLD = "world!";
    private static final String ERROR_MESSAGE = "Please enter: 'Hello' or 'world!'";

    private Model model;
    private View view;

    private Scanner sc = new Scanner(System.in);

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void run() {
        view.printMessage(ENTER_TEXT + HELLO);
        appendStringIfMatchesPattern(HELLO);
        view.printMessage(ENTER_TEXT + WORLD);
        appendStringIfMatchesPattern(WORLD);
        view.printMessage(model.getBuilder().toString());
    }

    private void appendStringIfMatchesPattern(final String pattern) {
        while (!checkCorrectMessageEntered(pattern)){
            view.printMessage(ERROR_MESSAGE);
            sc.nextLine();
        }
        if (model.getBuilder().length() == 0) {
            model.setBuilder(sc.nextLine());
            model.setBuilder(" ");
        } else {
            model.setBuilder(sc.nextLine());
        }
    }

    private boolean checkCorrectMessageEntered(final String messagePattern) {
        return sc.hasNext(Pattern.compile(messagePattern));
    }
}
