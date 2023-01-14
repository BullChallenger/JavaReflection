package practice00;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException {
        Class<String> stringClass = String.class;

        Map<String, Integer> mapObject = new HashMap<>();

        Class<?> hashMapClass = mapObject.getClass();

        Class<?> squareClass = Class.forName("practice00.Main$Square");

        var circleObject = new Drawable() {
            @Override
            public int getNumberOfCorners() {
                return 0;
            }
        };

//        printClassInfo(stringClass, hashMapClass, squareClass);
//        printClassInfo(Collections.class, boolean.class, int[][].class, Color.class, circleObject.getClass());
    }

    private static void printClassInfo(Class<?> ... classes) {

        for (Class<?> oneOfClasses : classes) {
            System.out.println(String.format("class name : %s, class package name : %s",
                    oneOfClasses.getSimpleName(),
                    oneOfClasses.getPackageName()));

            Class<?> [] implementedInterfaces = oneOfClasses.getInterfaces();

            for (Class<?> implementedInterface : implementedInterfaces) {
                System.out.println(String.format("class %s implements : %s",
                        oneOfClasses.getSimpleName(),
                        implementedInterface.getSimpleName()));
            }

            System.out.println("Is array : " + oneOfClasses.isArray());
            System.out.println("Is primitive : " + oneOfClasses.isPrimitive());
            System.out.println("Is enum : " + oneOfClasses.isEnum());
            System.out.println("Is interface : " + oneOfClasses.isInterface());
            System.out.println("Is anonymous : " + oneOfClasses.isAnonymousClass());

            System.out.println();
            System.out.println();
        }
    }

    private static class Square implements Drawable {
        @Override
        public int getNumberOfCorners() {
            return 4;
        }
    }

    private static interface Drawable {
        int getNumberOfCorners();
    }

    private enum Color {
        BLUE,
        RED,
        GREEN
    }
}
