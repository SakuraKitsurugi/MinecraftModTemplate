package com.sakurakitsurugi.minecraftmodtemplate.client;

import com.sakurakitsurugi.minecraftmodtemplate.MMTCore;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.ClientTickEvent;

@EventBusSubscriber(modid = MMTCore.MOD_ID, value = Dist.CLIENT)
@OnlyIn(Dist.CLIENT)
public class ClientEventListener {
    @SubscribeEvent
    public static void onClientTickEvent(ClientTickEvent.Post event) {

    }
}
