package view.ui;

import java.text.ParseException;

@FunctionalInterface
public interface Parserable <T> {
    T parse(String line) throws ParseException;
}
