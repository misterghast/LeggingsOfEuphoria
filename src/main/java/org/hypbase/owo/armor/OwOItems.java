package org.hypbase.owo.armor;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.util.EnumHelper;
import org.hypbase.owo.OwO;

public class OwOItems {
    public static ItemArmor.ArmorMaterial Tier1OwO = EnumHelper.addArmorMaterial("owo", "owo", 80, new int[]{5, OwO.OwOConfig.ARMOR_VALUE, 5, 5}, 28, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, OwO.OwOConfig.ARMOR_TOUGHNESS);
    public static ItemArmor.ArmorMaterial Tier2OwO = EnumHelper.addArmorMaterial("owo1", "owo", 160, new int[]{5, 8, 5, 5}, 28, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.3F);

}
