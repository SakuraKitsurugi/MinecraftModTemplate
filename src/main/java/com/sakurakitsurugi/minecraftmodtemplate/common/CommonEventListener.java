package com.sakurakitsurugi.minecraftmodtemplate.common;

import com.sakurakitsurugi.minecraftmodtemplate.MMTCore;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

@EventBusSubscriber(modid = MMTCore.MOD_ID)
public class CommonEventListener {
    @SubscribeEvent
    public static void onServerStarting(ServerStartingEvent event) {

    }
}
