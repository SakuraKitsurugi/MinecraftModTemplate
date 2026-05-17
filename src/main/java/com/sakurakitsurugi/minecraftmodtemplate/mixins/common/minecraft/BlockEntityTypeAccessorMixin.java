package com.sakurakitsurugi.minecraftmodtemplate.mixins.common.minecraft;

import java.util.Set;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;

@Mixin({ BlockEntityType.class })
public interface BlockEntityTypeAccessorMixin {
    @Accessor("validBlocks")
    Set<Block> mmt$getValidBlocks();

    @Accessor("validBlocks")
    @Mutable
    void mmt$setValidBlocks(Set<Block> var1);
}
