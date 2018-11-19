package com.example.szewy.shoppinglist;

import android.content.Context;
import android.content.res.Resources;

import java.util.ArrayList;

public class FileReader {
    private static ArrayList<Item> list = null;

    public static ArrayList<Item> read(Context context) {

        if(list == null) {
            list = new ArrayList<Item>();

            Resources res = context.getResources();

            String[] titles = res.getStringArray(R.array.titles);
            String[] descriptions = res.getStringArray(R.array.descriptions);
            String[] images = res.getStringArray(R.array.images);

            for (int i = 0; i < titles.length; i++) {
                list.add(new Item(titles[i], descriptions[i], images[i]));
            }
        }

        return list;
    }

    public static void remove(int id) {
        list.remove(id);
    }
}
