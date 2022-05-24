package org.hypbase.owo.network;

import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import org.hypbase.owo.capabilities.EuphoriaCapability;
import org.hypbase.owo.capabilities.EuphoriaProvider;

public class SyncEuphoriaHandler implements IMessageHandler<SyncEuphoriaMessage, IMessage> {
    @Override
    public IMessage onMessage(SyncEuphoriaMessage message, MessageContext ctx) {
        Minecraft.getMinecraft().addScheduledTask(() -> setItemLevel(message.stackSlot, message.level));
        return null;
    }

    public void setItemLevel(int slot, int level) {
       ItemStack i = Minecraft.getMinecraft().player.inventory.getStackInSlot(slot);
       if(i.hasCapability(EuphoriaProvider.EUPHORIA_CAPABILITY, null)) {
           EuphoriaCapability e = i.getCapability(EuphoriaProvider.EUPHORIA_CAPABILITY, null);
           e.setLevel(level);
       }
    }
}
