package org.hypbase.owo.network;

import io.netty.buffer.ByteBuf;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public class SyncEuphoriaMessage implements IMessage {

    public SyncEuphoriaMessage() {

    }

    public int stackSlot;
    public int level;
    public SyncEuphoriaMessage(int stackSlot, int level) {
        this.stackSlot = stackSlot;
        this.level = level;
    }

    @Override
    public void toBytes(ByteBuf buf) {
        buf.writeInt(stackSlot);
        buf.writeInt(level);
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        stackSlot = buf.readInt();
        level = buf.readInt();
    }
}
