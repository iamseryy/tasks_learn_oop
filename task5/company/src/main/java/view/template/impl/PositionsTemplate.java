package view.template.impl;

import model.Person;
import model.Position;
import service.PersonService;
import service.PositionService;
import service.impl.PersonServiceImpl;
import service.impl.PositionServiceImpl;
import view.template.Template;
import view.ui.UserInterface;
import view.ui.impl.UserInterfaceImpl;
import java.util.HashSet;
import java.util.Optional;

public class PositionsTemplate implements Template {
    private static PositionService positionService = new PositionServiceImpl();
    private static UserInterface ui = new UserInterfaceImpl();

    @Override
    public void output() {
        ui.output("\nPositions\n");
        Optional<HashSet<Position>> positions = positionService.findAllPosition();
        if(positions.isEmpty()){
            ui.output("\nThe company has no positions");
        }else {
            positions.get().stream()
                    .sorted((position1, position2) -> position1.id() - position2.id())
                    .forEach((position -> {
                        ui.output("\nID: " + position.id());
                        ui.output("Position: " + position.position());
                    }));
        }


        ui.pressEnterToContinue();
    }

}
