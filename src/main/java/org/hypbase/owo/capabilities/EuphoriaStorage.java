package org.hypbase.owo.capabilities;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagInt;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.common.util.INBTSerializable;

import javax.annotation.Nullable;

public class EuphoriaStorage implements Capability.IStorage<EuphoriaCapability> {
    @Nullable
    @Override
    public NBTBase writeNBT(Capability<EuphoriaCapability> capability, EuphoriaCapability instance, EnumFacing side) {
        return new NBTTagInt(instance.getLevel());
    }

    @Override
    public void readNBT(Capability<EuphoriaCapability> capability, EuphoriaCapability instance, EnumFacing side, NBTBase nbt) {
        NBTTagInt i = (NBTTagInt) nbt;
        instance.setLevel(i.getInt());
    }
}
