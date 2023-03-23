package model;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public record HirePerson(int personId, int positionId, Status hireType, Calendar hireDate) {
    @Override
    public String toString() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

        return personId + ";" +
                positionId + ";" +
                hireType.getDescription() + ";" +
                dateFormat.format(this.hireDate.getTime());
    }
}
