package com.sakurakitsurugi.minecraftmodtemplate.data;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Supplier;

import com.sakurakitsurugi.minecraftmodtemplate.mixins.common.minecraft.BlockEntityTypeAccessorMixin;

import net.minecraft.world.level.block.Block;

import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;

public class MMTBlockEntities {
    public static void init() {
    }

    private static final Map<Supplier<?>, Set<Block>> beModification = new Object2ObjectOpenHashMap<>();

    public static void addValidBEBlock(Supplier<?> type, Block block) {
        beModification.computeIfAbsent(type, t -> new HashSet<>());
        beModification.get(type).add(block);
    }

    public static void finaliseBEModification() {
        for (var key : beModification.keySet()) {
            var beType = (BlockEntityTypeAccessorMixin) key.get();
            Set<Block> blocks = new HashSet<>();
            blocks.addAll(beType.mmt$getValidBlocks());
            blocks.addAll(beModification.get(key));
            beType.mmt$setValidBlocks(blocks);
        }
    }
}
