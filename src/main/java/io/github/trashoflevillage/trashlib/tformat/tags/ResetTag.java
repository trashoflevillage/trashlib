package io.github.trashoflevillage.trashlib.tformat.tags;

import io.github.trashoflevillage.trashlib.tformat.TFormatTag;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;

import java.util.HashMap;
import java.util.List;

public class ResetTag implements TFormatTag {
    @Override
    public List<String> getArgs() {
        return List.of();
    }

    @Override
    public MutableText parse(MutableText original, HashMap<String, String> args) {
        return original.withoutStyle().getFirst();
    }
}
