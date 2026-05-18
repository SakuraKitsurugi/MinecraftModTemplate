package com.sakurakitsurugi.minecraftmodtemplate.common;

import java.util.Set;

import com.sakurakitsurugi.minecraftmodtemplate.MMTCore;
import com.sakurakitsurugi.minecraftmodtemplate.data.MMTBlockEntities;
import com.sakurakitsurugi.minecraftmodtemplate.data.MMTCreativeTab;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.event.BlockEntityTypeAddBlocksEvent;
import net.neoforged.neoforge.registries.RegisterEvent;

public class CommonInit {
    private static IEventBus modBus;

    static {
        MMTCore.REGISTRATE.creativeModeTab(() -> MMTCreativeTab.MMT);
    }

    public static void init(final IEventBus modBus) {
        CommonInit.modBus = modBus;
        modBus.register(CommonInit.class);
        MMTCore.REGISTRATE.registerEventListeners(modBus);

        MMTCreativeTab.init();
    }

    private static boolean didRunRegistration = false;

    @SubscribeEvent
    public static void onRegister(RegisterEvent event) {
        if (didRunRegistration) {
            return;
        }
        didRunRegistration = true;

        // Registry inits here
    }

    @SubscribeEvent
    public static void onCommonSetup(final FMLCommonSetupEvent event) {

    }

    @SubscribeEvent
    public static void addValidBlocksToBETypes(BlockEntityTypeAddBlocksEvent event) {
        for (var key : MMTBlockEntities.BE_MODIFICATION.keySet()) {
            var beType = (BlockEntityType<?>) key.get();
            Set<Block> blocks = MMTBlockEntities.BE_MODIFICATION.get(key);

            event.modify(beType, blocks.toArray(Block[]::new));
        }
    }
}
