package model;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class HirePerson {
    private int personId;
    private int positionId;
    private Status hireType;
    private Calendar hireDate;

    public HirePerson(int personId, int positionId, Status hireType, Calendar hireDate) {
        this.personId = personId;
        this.positionId = positionId;
        this.hireType = hireType;
        this.hireDate = hireDate;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public int getPositionId() {
        return positionId;
    }

    public void setPositionId(int positionId) {
        this.positionId = positionId;
    }

    public Status getHireType() {
        return hireType;
    }

    public void setHireType(Status hireType) {
        this.hireType = hireType;
    }

    public Calendar getHireDate() {
        return hireDate;
    }

    public void setHireDate(Calendar hireDate) {
        this.hireDate = hireDate;
    }

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
