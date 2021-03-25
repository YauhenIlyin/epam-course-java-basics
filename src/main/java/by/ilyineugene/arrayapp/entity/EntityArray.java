package by.ilyineugene.arrayapp.entity;

import java.util.Arrays;

public class EntityArray <DATA_TYPE extends Number> {

    private DATA_TYPE [] array = null;

    public EntityArray() {
    }

    public EntityArray(DATA_TYPE [] array) {
        this.array = array;
    }

    public DATA_TYPE[] getArray() {
        return array;
    }

    public void setArray(DATA_TYPE[] array) {
        this.array = array;
    }
}
