package com.course;

import java.util.Scanner;
import java.util.regex.Pattern;

import static com.course.View.ENTER_TEXT;
import static com.course.View.ERROR_MESSAGE;
import static com.course.View.HELLO;
import static com.course.View.WORLD;

public class Controller {

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
