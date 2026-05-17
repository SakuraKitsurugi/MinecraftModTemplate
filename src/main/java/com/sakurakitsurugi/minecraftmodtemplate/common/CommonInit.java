package com.sakurakitsurugi.minecraftmodtemplate.common;

import com.sakurakitsurugi.minecraftmodtemplate.MMTCore;
import com.sakurakitsurugi.minecraftmodtemplate.data.MMTCreativeTab;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
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
}
