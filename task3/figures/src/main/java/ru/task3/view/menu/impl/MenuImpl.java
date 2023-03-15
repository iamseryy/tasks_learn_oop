package ru.task3.view.menu.impl;

import ru.task3.view.menu.Menu;
import ru.task3.view.ViewUtils;

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

            Optional<Integer> itemOptional = new ViewUtils<Integer>().input("\nChoose your option: ", Integer::parseInt);

            if(itemOptional.isEmpty()){
                System.out.println("\nInvalid! Try Again");
                ViewUtils.pressEnterToContinue();
                continue;
            }

            if(itemOptional.get() > this.menuItemList().size() || itemOptional.get() < 1){
                System.out.println("\nInvalid! Try Again");
                ViewUtils.pressEnterToContinue();
            }
            try{
                this.menuItemList().get(itemOptional.get() - 1).executable().menuItemExecute();
            }catch (Exception e){
                System.out.println("Cancelled");
            }

            if(itemOptional.get() == this.menuItemList().size()) break;
        }
    }

}
