package com.sakurakitsurugi.minecraftmodtemplate.config;

import org.jetbrains.annotations.ApiStatus;

import com.sakurakitsurugi.minecraftmodtemplate.MMTCore;

import dev.toma.configuration.Configuration;
import dev.toma.configuration.config.Config;
import dev.toma.configuration.config.Configurable;
import dev.toma.configuration.config.format.ConfigFormats;

@Config(id = MMTCore.MOD_ID)
public class ConfigHolder {
    public static ConfigHolder INSTANCE;
    private static final Object LOCK = new Object();

    @ApiStatus.Internal
    public static dev.toma.configuration.config.ConfigHolder<ConfigHolder> INTERNAL_INSTANCE;

    public static void init() {
        synchronized (LOCK) {
            if (INSTANCE == null || INTERNAL_INSTANCE == null) {
                INTERNAL_INSTANCE = Configuration.registerConfig(ConfigHolder.class, ConfigFormats.YAML);
                INSTANCE = INTERNAL_INSTANCE.getConfigInstance();
            }
        }
    }

    @Configurable
    public ServerConfigs server = new ServerConfigs();

    @Configurable
    public ClientConfigs client = new ClientConfigs();

    public static class ServerConfigs {

    }

    public static class ClientConfigs {

    }
}
