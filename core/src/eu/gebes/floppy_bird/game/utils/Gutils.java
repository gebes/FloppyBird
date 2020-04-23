package eu.gebes.floppy_bird.game.utils;

import java.util.List;

public class Gutils {


    public static float randomNumber(float min, float max) {
        return (float)(Math.random() * ((max - min) + 1)) + min;
    }

    public static Object randomEntryFromList(List<?> list) {
        return list.get((int)randomNumber(0, list.size() - 1));
    }


    public static int[] reverseArray(int[] array) {
        int[] result = new int[array.length];
        for (int i = 0; i < array.length; i++)
            result[i] = array[array.length - 1 - i];
        return result;
    }


}
