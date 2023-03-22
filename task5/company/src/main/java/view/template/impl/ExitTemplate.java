package view.template.impl;

import view.template.Template;

public class ExitTemplate implements Template {
    @Override
    public void output() {
        System.out.println("\nExit done");
    }
}
