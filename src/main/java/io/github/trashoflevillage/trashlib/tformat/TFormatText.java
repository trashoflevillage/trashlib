package io.github.trashoflevillage.trashlib.tformat;

import net.minecraft.text.MutableText;
import net.minecraft.text.Text;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class TFormatText {
    private static final HashMap<String, TFormatTag> formattingTags = new HashMap<>();
    private String string;

    public TFormatText(String str) {
        string = str;
    }

    public static void registerTag(TFormatTag tag, String... names) {
        for (String name : names)
            formattingTags.put(name, tag);
    }

    public MutableText parse() {
        try {
            String withoutTags = "";
            HashMap<Integer, List<TagData>> tagsAtIndices = new HashMap<>();
            int i = 0;
            while (i != string.length()) {
                char c = string.charAt(i);
                if (c == '\\' && string.charAt(i + 1) == '<') {
                    withoutTags += "<";
                    i += 2;
                    continue;
                } else if (c == '<') {
                    // Detecting tag
                    int a = i;
                    while (true) {
                        if (a >= string.length()) throw new IndexOutOfBoundsException("Unfinished TFormat tag.");
                        if (string.charAt(a) == '>') break;
                        a++;
                    }
                    String tagStr = string.substring(i, a + 1);
                    TagData tagData = getTag(tagStr);
                    if (!tagsAtIndices.containsKey(withoutTags.length() - 1)) {
                        tagsAtIndices.put(withoutTags.length() - 1, List.of(tagData));
                    } else {
                        List<TagData> newList = tagsAtIndices.get(withoutTags.length() - 1);
                        newList.add(tagData);
                        tagsAtIndices.put(withoutTags.length() - 1, newList);
                    }
                    i = a;
                } else {
                    withoutTags += c;
                }
                i++;
            }

        } catch (Exception e) {
            return Text.literal(string);
        }
    }

    public TagData getTag(String str) {
        if (str.startsWith("<") && str.endsWith(">")) {
            String tagWithoutBrackets = str.substring(1, str.length() - 1);
            String[] splitTag = tagWithoutBrackets.split(";");
            String tagName = splitTag[0];
            List<String> args = new ArrayList<>(List.of());
            args.addAll(Arrays.asList(splitTag));
            args.removeFirst();
            if (formattingTags.containsKey(tagName)) {
                return new TagData(
                        tagName,
                        args
                );
            } else return null;
        }
        return null;
    }

    public static class TagData {
        final String name;
        final List<String> args;
        final TFormatTag tag;
        TagData(String name, List<String> args) {
            this.name = name;
            this.args = args;
            if (formattingTags.containsKey(name))
                tag = formattingTags.get(name);
            else throw new NullPointerException(name + " is not a registered TFormat Tag.");
        }

        MutableText parse(MutableText original) {
            HashMap<String, String> argsHashmap = new HashMap<>();
            for (int i = 0; i < tag.getArgs().size(); i++) {
                argsHashmap.put(tag.getArgs().get(i), args.get(i));
            }
            return tag.parse(original, argsHashmap);
        }
    }
}
