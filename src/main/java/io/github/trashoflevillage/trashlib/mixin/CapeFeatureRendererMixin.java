package io.github.trashoflevillage.trashlib.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import io.github.trashoflevillage.trashlib.Trashlib;
import net.minecraft.client.render.entity.feature.CapeFeatureRenderer;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(CapeFeatureRenderer.class)
public class CapeFeatureRendererMixin {
    @ModifyExpressionValue(
            method = "render(Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;ILnet/minecraft/client/render/entity/state/PlayerEntityRenderState;FF)V",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/client/util/SkinTextures;capeTexture()Lnet/minecraft/util/Identifier;")
    )
    public Identifier getCapeTexture(Identifier original) {
        return Identifier.of(Trashlib.MOD_ID, "textures/capes/moobloom.png");
    }
}
