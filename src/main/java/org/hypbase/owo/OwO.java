package org.hypbase.owo;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import org.hypbase.owo.capabilities.DefaultEuphoriaCapability;
import org.hypbase.owo.capabilities.EuphoriaCapability;
import org.hypbase.owo.capabilities.EuphoriaStorage;
import org.hypbase.owo.network.OwOPacketHandler;
import org.hypbase.owo.network.SyncEuphoriaHandler;
import org.hypbase.owo.network.SyncEuphoriaMessage;

import java.util.concurrent.Callable;

@Mod(modid="owo", name="Leggings of Euphoria")
public class OwO {

    //@SidedProxy(modId="owo", clientSide="OwOEvents",serverSide="OwOServerEvents")
    //public static OwOServerEvents proxy;
    @Config(modid="owo", name="Leggings of Euphoria Config", type= Config.Type.INSTANCE, category="general")
    public static class OwOConfig {
        public static int ARMOR_VALUE = 0;
        public static float ARMOR_TOUGHNESS = 0.0f;

        public static boolean UNBREAKABLE = true;
    }
    public static final String MOD_ID = "owo";
    public static final OwOEvents events = new OwOEvents();
    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {

        MinecraftForge.EVENT_BUS.register(events);
        //MinecraftForge.EVENT_BUS.register(proxy);
        CapabilityManager.INSTANCE.register(EuphoriaCapability.class, new EuphoriaStorage(), new EuphoriaFactory());
        OwOPacketHandler.INSTANCE.registerMessage(SyncEuphoriaHandler.class, SyncEuphoriaMessage.class, 0, Side.CLIENT);



    }
}

class EuphoriaFactory implements Callable<EuphoriaCapability> {
    @Override
    public EuphoriaCapability call() throws Exception {
        return new DefaultEuphoriaCapability();
    }
}
