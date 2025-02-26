package io.github.trashoflevillage.trashlib.mixin;

import io.github.trashoflevillage.trashlib.tformat.TFormatText;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.util.Colors;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;
import java.util.Objects;

@Mixin(Item.class)
public class ItemMixin {
    @Inject(method = "appendTooltip", at = @At("TAIL"))
    public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType type, CallbackInfo ci) {
        int lineNum = 0;
        try {
            while (true) {
                String translationKey = stack.getItem().getTranslationKey() + ".description." + lineNum;
                Text line = Text.translatable(translationKey);

                if (!line.asTruncatedString(translationKey.length()).equals(translationKey)) {
                    tooltip.add(new TFormatText(line.getString()).parse());
                    lineNum++;
                } else break;
            }
        } catch (NullPointerException ignored) {

        }
    }
}
