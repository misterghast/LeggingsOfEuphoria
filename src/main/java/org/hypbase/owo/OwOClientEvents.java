package org.hypbase.owo;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.event.RenderTooltipEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.hypbase.owo.models.LeggingsThin;

@Mod.EventBusSubscriber
public class OwOClientEvents extends OwOEvents {
    public static final LeggingsThin model = new LeggingsThin();

    @Override
    public <A extends ModelBiped> A getArmorModel(Entity entity, ItemStack itemStack, EntityEquipmentSlot slot, A _default) {
        return (A) model;
    }

    @SubscribeEvent
    @Override
    public void modelRegistry(ModelRegistryEvent event) {
        ModelLoader.setCustomModelResourceLocation(owolegs, 0, new ModelResourceLocation("owo:owolegs", "inventory"));
        ModelLoader.setCustomModelResourceLocation(owolegsbw, 0, new ModelResourceLocation("owo:owolegsbw", "inventory"));
    }
}
