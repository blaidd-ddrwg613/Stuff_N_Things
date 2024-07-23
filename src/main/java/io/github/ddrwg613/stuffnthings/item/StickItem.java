package io.github.ddrwg613.stuffnthings.item;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.levelgen.Column;
import net.minecraft.world.phys.Vec3;

// Summons Lightning on right click
public class StickItem extends Item {

    public StickItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        if (!pContext.getLevel().isClientSide()) {
            BlockPos blockPos = pContext.getClickedPos();
            Level level = pContext.getLevel();

            LightningBolt lightningBolt = EntityType.LIGHTNING_BOLT.create(level);

            if (lightningBolt !=null) {
                lightningBolt.setDeltaMovement(0, -blockPos.getY(), 0);
                lightningBolt.moveTo(blockPos.getCenter());
                level.addFreshEntity(lightningBolt);
                pContext.getItemInHand().hurtAndBreak(1, pContext.getPlayer(), (event) -> {
                    event.broadcastBreakEvent(EquipmentSlot.MAINHAND);
                });
            }
        }
        return InteractionResult.SUCCESS;
    }
}
