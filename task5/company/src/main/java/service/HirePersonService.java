package service;

import model.HirePerson;
import model.Person;

import java.util.Optional;

public interface HirePersonService {
    int addHireOperation(HirePerson hirePerson);
    Optional<HirePerson> findLastHireOperationByPersonId(int id);
}
