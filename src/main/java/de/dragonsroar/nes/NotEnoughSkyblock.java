package de.dragonsroar.nes;

import lombok.Getter;
import lombok.Setter;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(name = "NotEnoughSkyblock", modid = NotEnoughSkyblock.MODID, version = NotEnoughSkyblock.VERSION, clientSideOnly = true)
public class NotEnoughSkyblock {
    public static final String NAME = "NotEnoughSkyblock";
    public static final String VERSION = "0.0.0";
    public static final String MODID = "notenoughskyblock";

    @Getter @Setter private static GuiScreen display = null;
    @Getter @Setter private static Config config = Config.getInstance();

    public static final EnumChatFormatting ERROR_COLOR = EnumChatFormatting.RED;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent e) {
    }
    @Mod.EventHandler
    public void init(FMLInitializationEvent e) {
    }
    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent e) {
    }
}
