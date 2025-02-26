package io.github.trashoflevillage.trashlib.tformat.tags;

import io.github.trashoflevillage.trashlib.tformat.TFormatTag;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.text.TextColor;
import net.minecraft.util.Colors;

import java.util.HashMap;
import java.util.List;

public class SimpleColorTag implements TFormatTag {
    private final TextColor color;

    public SimpleColorTag(TextColor color) {
        this.color = color;
    }

    public SimpleColorTag(int color) {
        this.color = TextColor.fromRgb(color);
    }

    @Override
    public List<String> getArgs() {
        return List.of();
    }

    @Override
    public MutableText parse(MutableText original, HashMap<String, String> args) {
        return original.getWithStyle(original.getStyle().withColor(color)).getFirst();
    }
}
