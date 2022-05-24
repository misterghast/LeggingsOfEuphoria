package org.hypbase.owo.capabilities;

import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;

public class DefaultEuphoriaCapability implements EuphoriaCapability {


    private int level;

    @Override
    public int getLevel() {
        return this.level;
    }

    @Override
    public void setLevel(int amount) {
        this.level = amount;
    }

    @Override
    public void incrementLevel() {
        this.level += 1;
    }
}
