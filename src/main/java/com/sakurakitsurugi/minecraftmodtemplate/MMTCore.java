package com.sakurakitsurugi.minecraftmodtemplate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.ApiStatus;

import com.sakurakitsurugi.minecraftmodtemplate.client.ClientInit;
import com.sakurakitsurugi.minecraftmodtemplate.common.CommonInit;
import com.sakurakitsurugi.minecraftmodtemplate.config.ConfigHolder;

import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.loading.FMLEnvironment;

@Mod(MMTCore.MOD_ID)
public class MMTCore {
    public static final String MOD_ID = "mmt";
    public static final String NAME = "MinecraftModTemplate";
    public static final Logger LOGGER = LogManager.getLogger(NAME);

    public static final MMTRegistrate REGISTRATE = MMTRegistrate.create(MOD_ID);

    static {
        REGISTRATE.defaultCreativeTab((ResourceKey<CreativeModeTab>) null);
    }

    public static ResourceLocation id(String name) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, name);
    }

    @ApiStatus.Internal
    public static IEventBus mmtModBus;

    public MMTCore(IEventBus modBus, ModContainer container) {
        MMTCore.mmtModBus = modBus;
        ConfigHolder.init();

        CommonInit.init(modBus);

        if (FMLEnvironment.dist.isClient()) {
            ClientInit.init(modBus);
        }
    }
}
