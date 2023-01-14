/*
 *  MIT License
 *
 *  Copyright (c) 2020 Michael Pogrebinsky - Java Reflection - Master Class
 *
 *  Permission is hereby granted, free of charge, to any person obtaining a copy
 *  of this software and associated documentation files (the "Software"), to deal
 *  in the Software without restriction, including without limitation the rights
 *  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *  copies of the Software, and to permit persons to whom the Software is
 *  furnished to do so, subject to the following conditions:
 *
 *  The above copyright notice and this permission notice shall be included in all
 *  copies or substantial portions of the Software.
 *
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 *  SOFTWARE.
 */

package constructors02.init;

import constructors02.game.Game;
import constructors02.game.internal.TicTacToeGame;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * Tic Tac Toe
 * https://www.udemy.com/course/java-reflection-master-class
 */

public class Main {

    public static void main(String[] args) throws InvocationTargetException, InstantiationException, IllegalAccessException {
        Game game = createObjectRecursively(TicTacToeGame.class);
        game.startGame();
    }

    public static <T> T createObjectRecursively(Class<T> clas) throws InvocationTargetException,
            InstantiationException, IllegalAccessException {
        Constructor<?> constructor = getFirstConstructor(clas);

        List<Object> constructorArgument = new ArrayList<>();

        for (Class<?> argumentType : constructor.getParameterTypes()) {
            Object argumentValue = createObjectRecursively(argumentType);
            constructorArgument.add(argumentValue);
        }

        constructor.setAccessible(true);

        return (T) constructor.newInstance(constructorArgument.toArray());
    }

    private static Constructor<?> getFirstConstructor(Class<?> clas) {
        Constructor<?>[] constructors = clas.getDeclaredConstructors();
        if (constructors.length == 0) {
            throw new IllegalStateException(String.format("No constructor has been found for class %s", clas.getName()));
        }
        return constructors[0];
    }
}
