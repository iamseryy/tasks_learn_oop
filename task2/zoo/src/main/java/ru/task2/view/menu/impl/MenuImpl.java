package ru.task2.view.menu.impl;

import ru.task2.view.ViewUtils;
import ru.task2.view.menu.Menu;

import java.util.ArrayList;
import java.util.Optional;

public record MenuImpl(String menuHeader, ArrayList<MenuItem> menuItemList) implements Menu {
    @Override
    public void print(){
        System.out.println(this.menuHeader);
        this.menuItemList.forEach(menuItem -> System.out.println(menuItem.description()));
    }

    @Override
    public void processing(){
        while (true){
            this.print();

            Optional<Integer> itemOptional = ViewUtils.inputMenuItem("\nChoose your option: ");

            if(itemOptional.isEmpty()){
                System.out.println("\nInvalid! Try Again");
                ViewUtils.pressEnterToContinue();
                continue;
            }

            if(itemOptional.get() > this.menuItemList().size() || itemOptional.get() < 1){
                System.out.println("\nInvalid! Try Again");
                ViewUtils.pressEnterToContinue();
            }

            this.menuItemList().get(itemOptional.get() - 1).executable().menuItemExecute();
            if(itemOptional.get() == this.menuItemList().size()) break;
        }
    }

}
