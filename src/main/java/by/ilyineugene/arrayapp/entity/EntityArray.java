package by.ilyineugene.arrayapp.entity;

import by.ilyineugene.arrayapp.exception.OperationArrayException;

import java.util.Arrays;

public class EntityArray <T extends Number> {

    private T[] array;

    public EntityArray() {
    }

    public EntityArray(T[] array) {
        if(array != null){
            this.array = Arrays.copyOf(array, array.length);
        }
    }
    public T[] getArray() {
        return array;
    }

    public void setArray(T[] array) {
        this.array = Arrays.copyOf(array,array.length);
    }
}
