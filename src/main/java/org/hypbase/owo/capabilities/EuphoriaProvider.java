package org.hypbase.owo.capabilities;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.items.CapabilityItemHandler;
import scala.tools.nsc.doc.model.Def;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class EuphoriaProvider implements ICapabilitySerializable<NBTBase> {
    @CapabilityInject(EuphoriaCapability.class)
    public static Capability<EuphoriaCapability> EUPHORIA_CAPABILITY = null;
    private EuphoriaCapability cap;

    public EuphoriaProvider() {
        cap = EUPHORIA_CAPABILITY.getDefaultInstance();
    }

    @Override
    public boolean hasCapability(@Nonnull Capability<?> capability, @Nullable EnumFacing facing) {
        if(capability == EUPHORIA_CAPABILITY) {
            return true;
        }
        return false;
    }

    @Nullable
    @Override
    public <T> T getCapability(@Nonnull Capability<T> capability, @Nullable EnumFacing facing) {
        if(capability == EUPHORIA_CAPABILITY) {
            return (T)cap;
        }
        return null;
    }

    @Override
    public NBTBase serializeNBT() {
        return EUPHORIA_CAPABILITY.getStorage().writeNBT(EUPHORIA_CAPABILITY, this.cap, null);
    }

    @Override
    public void deserializeNBT(NBTBase nbt) {
        EUPHORIA_CAPABILITY.getStorage().readNBT(EUPHORIA_CAPABILITY, this.cap, null, nbt);
    }
}
