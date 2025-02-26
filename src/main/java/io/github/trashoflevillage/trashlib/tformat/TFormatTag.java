package io.github.trashoflevillage.trashlib.tformat;

import net.minecraft.text.MutableText;
import net.minecraft.text.Text;

import java.util.HashMap;
import java.util.List;

public interface TFormatTag {
    List<String> getArgs();
    MutableText parse(MutableText original, HashMap<String, String> args);
}
