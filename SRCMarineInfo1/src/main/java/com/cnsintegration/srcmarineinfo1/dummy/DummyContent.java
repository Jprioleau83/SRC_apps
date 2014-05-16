package com.cnsintegration.srcmarineinfo1.dummy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class DummyContent {

    /**
     * An array of sample (dummy) items.
     */
    public static List<DummyItem> ITEMS = new ArrayList<DummyItem>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static Map<String, DummyItem> ITEM_MAP = new HashMap<String, DummyItem>();

    static {
        // Add 3 sample items.

        addItem(new DummyItem("1", "1 Wun"));
        addItem(new DummyItem("2", "2 Too"));
        addItem(new DummyItem("3", "3 Tree"));
        addItem(new DummyItem("4", "4 Fow-er"));
        addItem(new DummyItem("5", "5 Fife"));
        addItem(new DummyItem("6", "6 Six"));
        addItem(new DummyItem("7", "7 Sev-en"));
        addItem(new DummyItem("8", "8 Ait"));
        addItem(new DummyItem("9", "9 Niner"));
        addItem(new DummyItem("0", "0 Zeero"));
        addItem(new DummyItem("A", "A-Alpha"));
        addItem(new DummyItem("B", "B-Bravo"));
        addItem(new DummyItem("C", "C-Charlie"));
        addItem(new DummyItem("D", "D-Delta"));
        addItem(new DummyItem("E", "E-Echo"));
        addItem(new DummyItem("F", "F-Foxtrot"));
        addItem(new DummyItem("G", "G-Golf"));
        addItem(new DummyItem("H", "H-Hotel"));
        addItem(new DummyItem("I", "I-Indigo"));
        addItem(new DummyItem("J", "J-Juliet"));
        addItem(new DummyItem("K", "K-Kilo"));
        addItem(new DummyItem("L", "L-Lima"));
        addItem(new DummyItem("M", "M-Mike"));
        addItem(new DummyItem("N", "N-November"));
        addItem(new DummyItem("O", "O-Oscar"));
        addItem(new DummyItem("P", "P-Papa"));
        addItem(new DummyItem("Q", "Q-Quebec"));
        addItem(new DummyItem("R", "R-Romeo"));
        addItem(new DummyItem("S", "S-Sierra"));
        addItem(new DummyItem("T", "T-Tango"));
        addItem(new DummyItem("U", "U-Uniform"));
        addItem(new DummyItem("V", "V-Victor"));
        addItem(new DummyItem("W", "W-Whiskey"));
        addItem(new DummyItem("X", "X-XRay"));
        addItem(new DummyItem("Y", "Y-Yankee"));
        addItem(new DummyItem("Z", "Z-Zulu"));



    }

    private static void addItem(DummyItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class DummyItem {
        public String id;
        public String content;

        public DummyItem(String id, String content) {
            this.id = id;
            this.content = content;
        }

        @Override
        public String toString() {
            return content;
        }
    }
}
