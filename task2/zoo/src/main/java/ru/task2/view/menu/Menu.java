package ru.task2.view.menu;

import ru.task2.view.ViewUtils;

import java.util.ArrayList;
import java.util.Optional;

public record Menu(String menuHeader, ArrayList<MenuItem> menuItemList){
    public void print(){
        System.out.println(this.menuHeader);
        this.menuItemList.forEach(menuItem -> System.out.println(menuItem.description()));
    }

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
