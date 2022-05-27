package org.hypbase.owo.armor;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.common.ISpecialArmor;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.hypbase.owo.OwO;
import org.hypbase.owo.OwOClientEvents;
import org.hypbase.owo.capabilities.DefaultEuphoriaCapability;
import org.hypbase.owo.capabilities.EuphoriaCapability;
import org.hypbase.owo.capabilities.EuphoriaProvider;
import org.hypbase.owo.models.LeggingsThin;
import org.hypbase.owo.network.OwOPacketHandler;
import org.hypbase.owo.network.SyncEuphoriaMessage;
import scala.tools.nsc.doc.model.Def;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.management.Attribute;
import java.util.Collection;
import java.util.HashMap;
import java.util.UUID;

public class OwOArmorItem extends ItemArmor {

    private static final UUID[] ARMOR_MODIFIERS = new UUID[] {UUID.fromString("845DB27C-C624-495F-8C9F-6020A9A58B6B"), UUID.fromString("D8499B04-0E66-4726-AB29-64469D734E0D"), UUID.fromString("9F3D476D-C118-4544-8365-64846904B48E"), UUID.fromString("2AD3F246-FEE1-4E67-B886-69FD380BB150")};
    private String variant;



    public OwOArmorItem(ArmorMaterial materialIn, EntityEquipmentSlot equipmentSlotIn, String variant) {
        super(materialIn, 0, equipmentSlotIn);
        this.variant = variant;
    }

    @Override
    public String getArmorTexture(ItemStack itemstack, Entity entity, EntityEquipmentSlot slot, String layer) {
        if (slot == EntityEquipmentSlot.LEGS) {
            return OwO.MOD_ID + ":textures/armor/" + "owo_2" + "_" + this.variant + ".png";
        } else {
            return OwO.MOD_ID + ":textures/armor/" + "owo_1" + ".png";
        }
    }
    @Override
    public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, EntityEquipmentSlot armorSlot, ModelBiped _default) {
        return OwO.proxy.getArmorModel(entityLiving, itemStack, armorSlot, _default);
    }

    @Override
    public String getItemStackDisplayName(ItemStack stack) {
        return I18n.format(this.getTranslationKey(), TextFormatting.AQUA, TextFormatting.RESET);
    }

    @Override
    public Multimap<String, AttributeModifier> getItemAttributeModifiers(EntityEquipmentSlot slot) {
        if(OwO.OwOConfig.ARMOR_VALUE > 0 || OwO.OwOConfig.ARMOR_TOUGHNESS > 0) {
            return super.getItemAttributeModifiers(slot);
        } else {
            return HashMultimap.<String, AttributeModifier>create();
        }
    }
    /*@Override
    public Multimap<String, AttributeModifier> getAttributeModifiers(EntityEquipmentSlot slot, ItemStack stack) {
        int upgradeAmount = 0;
        if(stack.hasCapability(EuphoriaProvider.EUPHORIA_CAPABILITY, null)) {
            upgradeAmount = stack.getCapability(EuphoriaProvider.EUPHORIA_CAPABILITY, null).getLevel();
        }

        Multimap<String, AttributeModifier> multimap = HashMultimap.<String, AttributeModifier>create();
        if(slot == this.armorType) {
            multimap.put(SharedMonsterAttributes.ARMOR.getName(), new AttributeModifier(ARMOR_MODIFIERS[slot.getIndex()], "Armor modifier", (double)this.damageReduceAmount + 2 * upgradeAmount, 0));
            multimap.put(SharedMonsterAttributes.ARMOR_TOUGHNESS.getName(), new AttributeModifier(ARMOR_MODIFIERS[slot.getIndex()], "Armor toughness", (double)this.toughness + 1 * upgradeAmount, 0));
        }


        return multimap;
    }*/

    @Override
    public boolean isDamageable() {
        return(!OwO.OwOConfig.UNBREAKABLE);
    }

    public void upgrade(EntityEquipmentSlot slot, ItemStack stack, EntityPlayerMP player) {
        if(stack.hasCapability(EuphoriaProvider.EUPHORIA_CAPABILITY, null)) {
            EuphoriaCapability e = stack.getCapability(EuphoriaProvider.EUPHORIA_CAPABILITY, null);
            e.incrementLevel();
            OwOPacketHandler.INSTANCE.sendTo(new SyncEuphoriaMessage(slot.getIndex(), e.getLevel()), player);
        }
    }



}
