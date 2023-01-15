package array00;

import java.lang.reflect.Array;

public class Main {

    public static void main(String[] args) {
        int[] oneDimensionArray = {1, 2};
        double[][] twoDimensionsArray = {{1.5, 1.2, 1.3}, {2.5, 3.5}};

        inspectArrayObject(oneDimensionArray);
        inspectArrayObject(twoDimensionsArray);

        inspectArrayValue(oneDimensionArray);
        inspectArrayValue(twoDimensionsArray);
    }

    public static void inspectArrayValue(Object arrayObject) {
        int arrayLength = Array.getLength(arrayObject);

        System.out.print("[");

        for (int i = 0; i < arrayLength; i++) {
            Object element = Array.get(arrayObject, i);

            if (element.getClass().isArray()) {
                inspectArrayValue(element);
            } else {
                System.out.print(element);
            }

            if (i != arrayLength - 1) {
                System.out.print(", ");
            }
        }
        System.out.print("]");
    }

    public static void inspectArrayObject(Object arrayObject) {
        Class<?> clas = arrayObject.getClass();

        System.out.println("Is Array : " + clas.isArray());

        Class<?> arrayComponentType = clas.getComponentType();

        System.out.println("This is an array type : " + arrayComponentType.getTypeName());
    }
}
