package com.sakurakitsurugi.minecraftmodtemplate.data;

import org.jetbrains.annotations.NotNull;

import com.sakurakitsurugi.minecraftmodtemplate.MMTCore;
import com.sakurakitsurugi.minecraftmodtemplate.MMTRegistrate;
import com.tterrag.registrate.util.entry.RegistryEntry;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class MMTCreativeTab {
    public static RegistryEntry<CreativeModeTab, CreativeModeTab> MMT = MMTCore.REGISTRATE
            .defaultCreativeTab("tfm",
                    builder -> builder.displayItems(new RegistrateDisplayItemsGenerator("mmt", MMTCore.REGISTRATE))
                            .icon(() -> new ItemStack(Items.POTATO))
                            .title(Component.translatable("mmt.creative_tab.mmt"))
                            .build())
            .register();

    public static void init() {
    }

    public record RegistrateDisplayItemsGenerator(String name, MMTRegistrate registrate) implements CreativeModeTab.DisplayItemsGenerator {

        @Override
        public void accept(@NotNull CreativeModeTab.ItemDisplayParameters itemDisplayParameters,
                @NotNull CreativeModeTab.Output output) {
            var tab = registrate.get(name, Registries.CREATIVE_MODE_TAB);
            for (var entry : registrate.getAll(Registries.ITEM)) {
                if (!registrate.isInCreativeTab(entry, tab))
                    continue;
                Item item = entry.get();
                output.accept(item);
            }
        }
    }
}
