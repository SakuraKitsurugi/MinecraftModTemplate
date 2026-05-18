package com.sakurakitsurugi.minecraftmodtemplate.data;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Supplier;

import net.minecraft.world.level.block.Block;

import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;

public class MMTBlockEntities {
    public static final Map<Supplier<?>, Set<Block>> BE_MODIFICATION = new Object2ObjectOpenHashMap<>();

    public static void init() {
    }

    public static void addValidBEBlock(Supplier<?> type, Block block) {
        BE_MODIFICATION.computeIfAbsent(type, t -> new HashSet<>());
        BE_MODIFICATION.get(type).add(block);
    }
}
