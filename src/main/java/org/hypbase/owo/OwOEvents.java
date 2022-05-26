package org.hypbase.owo;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.ISpecialArmor;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.player.PlayerContainerEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import org.hypbase.owo.armor.OwOArmorItem;
import org.hypbase.owo.armor.OwOItems;
import org.hypbase.owo.capabilities.DefaultEuphoriaCapability;
import org.hypbase.owo.capabilities.EuphoriaProvider;

import java.util.Map;

@Mod.EventBusSubscriber
public class OwOEvents {
    @GameRegistry.ObjectHolder("owo:owolegs")
    public static final OwOArmorItem owolegs = null;

    @GameRegistry.ObjectHolder("owo:owolegsbw")
    public static final OwOArmorItem owolegsbw = null;

    @SubscribeEvent
    public void registerItems(RegistryEvent.Register<Item> event) {
        OwOArmorItem owolegs = new OwOArmorItem(OwOItems.Tier1OwO, EntityEquipmentSlot.LEGS, "trans");
        owolegs.setRegistryName(new ResourceLocation(OwO.MOD_ID, "owolegs"));
        owolegs.setTranslationKey(OwO.MOD_ID + "." + "owolegs");

        OwOArmorItem owolegsbw = new OwOArmorItem(OwOItems.Tier1OwO, EntityEquipmentSlot.LEGS, "bw");
        owolegsbw.setRegistryName(new ResourceLocation(OwO.MOD_ID, "owolegsbw"));
        owolegsbw.setTranslationKey(OwO.MOD_ID + "." + "owolegs");



        event.getRegistry().register(owolegs);
        event.getRegistry().register(owolegsbw);
        for(Map.Entry<ResourceLocation, Item> entry : event.getRegistry().getEntries()) {
            System.out.println(entry.getKey().toString());
        }
    }

    @SubscribeEvent
    public void modelRegistry(ModelRegistryEvent event) {
        ModelLoader.setCustomModelResourceLocation(owolegs, 0, new ModelResourceLocation("owo:owolegs", "inventory"));
        ModelLoader.setCustomModelResourceLocation(owolegsbw, 0, new ModelResourceLocation("owo:owolegsbw", "inventory"));
    }



    //For testing.
    /*@SubscribeEvent
    public void blockBroken(BlockEvent.BreakEvent event) {
        if(!event.getWorld().isRemote) {
            if(event.getPlayer().getHeldItem(EnumHand.MAIN_HAND).isItemEqual(new ItemStack(owolegs))) {
                ItemStack st = event.getPlayer().getHeldItem(EnumHand.MAIN_HAND);
                OwOArmorItem item = (OwOArmorItem)st.getItem();
                if(st.hasCapability(EuphoriaProvider.EUPHORIA_CAPABILITY, null)) {
                    System.out.println("balls");
                    item.upgrade(EntityEquipmentSlot.MAINHAND, st, (EntityPlayerMP)event.getPlayer());
                    event.getPlayer().inventory.markDirty();
                }
            }
        }

    }*/

    /*@SubscribeEvent
    public void attachCapabilitiesEvent(AttachCapabilitiesEvent<ItemStack> event) {
        if(event.getObject().getItem() instanceof OwOArmorItem) {
            event.addCapability(new ResourceLocation(OwO.MOD_ID, "euphoriacapability"), new EuphoriaProvider());
        }
    }*/
}
