package org.hypbase.owo.armor;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.util.EnumHelper;
import org.hypbase.owo.OwO;

public class OwOItems {
    public static ItemArmor.ArmorMaterial Tier1OwO = EnumHelper.addArmorMaterial("owo", "owo", 80, new int[]{5, OwO.OwOConfig.ARMOR_VALUE, 5, 5}, 28, null, OwO.OwOConfig.ARMOR_TOUGHNESS);

}
