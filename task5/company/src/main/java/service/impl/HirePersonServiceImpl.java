package service.impl;

import model.HirePerson;
import repository.HirePersons;
import repository.impl.HirePersonsImpl;
import service.HirePersonService;

public class HirePersonServiceImpl implements HirePersonService {
    private static HirePersons hirePersons = HirePersonsImpl.getInstance();
    @Override
    public int addHireOperation(HirePerson hirePerson) {
        return this.hirePersons.add(hirePerson);
    }
}
