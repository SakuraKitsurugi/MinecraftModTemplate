package com.sakurakitsurugi.minecraftmodtemplate.gametest.example;

import static net.minecraft.world.item.Items.STONE;

import com.sakurakitsurugi.minecraftmodtemplate.MMTCore;

import net.minecraft.core.BlockPos;
import net.minecraft.gametest.framework.GameTest;
import net.minecraft.gametest.framework.GameTestHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.HopperBlockEntity;
import net.neoforged.neoforge.gametest.GameTestHolder;
import net.neoforged.neoforge.gametest.PrefixGameTestTemplate;

@PrefixGameTestTemplate(false)
@GameTestHolder(MMTCore.MOD_ID)
public class ExampleTest {

    @GameTest(template = "empty")
    public static void myTest(GameTestHelper helper) {
        helper.assertTrue(true, "true is false");
        helper.succeed();
    }

    @GameTest(template = "empty_5x5")
    public static void myTestInWorld(GameTestHelper helper) {
        var topHopperPos = new BlockPos(0, 1, 0);
        var bottomHopperPos = new BlockPos(0, 0, 0);

        helper.setBlock(topHopperPos, Blocks.HOPPER.defaultBlockState());
        helper.setBlock(bottomHopperPos, Blocks.HOPPER.defaultBlockState());

        var topHopper = (HopperBlockEntity) helper.getBlockEntity(topHopperPos);
        var bottomHopper = (HopperBlockEntity) helper.getBlockEntity(bottomHopperPos);

        helper.assertTrue(topHopper != null, "Top hopper in example test was not placed correctly");
        helper.assertTrue(bottomHopper != null, "Bottom hopper in example test was not placed correctly");

        for (int i = 0; i < topHopper.getContainerSize(); i++) {
            helper.assertTrue(topHopper.getItem(i).isEmpty(), "Item in slot " + i + " in top hopper was not empty before inserting");
            helper.assertTrue(bottomHopper.getItem(i).isEmpty(), "Item in slot " + i + " in bottom hopper was not empty before inserting");
        }

        topHopper.setItem(1, new ItemStack(STONE, 1));

        helper.runAfterDelay(10, () -> {
            for (int i = 0; i < topHopper.getContainerSize(); i++) {
                helper.assertTrue(topHopper.getItem(i).isEmpty(), "Item in slot " + i + " in top hopper was not empty");
            }
            helper.assertTrue(bottomHopper.getItem(0).is(STONE), "Item did not transfer to bottom hopper after 10 ticks");
            helper.succeed();
        });
    }

}
