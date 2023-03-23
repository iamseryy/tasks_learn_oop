package repository;

import model.HirePerson;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public interface HirePersons extends DataBase{
    Set<HirePerson> findByPersonId(int id);
}
