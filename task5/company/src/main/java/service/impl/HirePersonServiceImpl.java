package service.impl;

import model.HirePerson;
import repository.HirePersons;
import repository.impl.HirePersonsImpl;
import service.HirePersonService;

import java.util.Optional;

public class HirePersonServiceImpl implements HirePersonService {
    private static HirePersons hirePersons = HirePersonsImpl.getInstance();

    @Override
    public int addHireOperation(HirePerson hirePerson) {
        return this.hirePersons.add(hirePerson);
    }

    @Override
    public Optional<HirePerson> findLastHireOperationByPersonId(int id) {
        return hirePersons.findByPersonId(id).stream()
                .max((hirePeople1, hirePerson2) -> hirePeople1.hireDate().compareTo(hirePerson2.hireDate()));
    }
}
