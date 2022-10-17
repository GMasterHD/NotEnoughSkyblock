package de.dragonsroar.nes.commands;

import de.dragonsroar.nes.NotEnoughSkyblock;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.BlockPos;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class CommandNES implements ICommand {
    private static final List<String> ALIASES = new ArrayList<>();

    static {
        ALIASES.add("nes");
    }

    @Override
    public String getCommandName() {
        return "notenoughskyblock";
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "/" + getCommandName();
    }

    @Override
    public List<String> getCommandAliases() {
        return ALIASES;
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) throws CommandException {
        NotEnoughSkyblock.setDisplay(NotEnoughSkyblock.getConfig().gui());
    }

    @Override
    public boolean canCommandSenderUseCommand(ICommandSender sender) {
        return true;
    }

    @Override
    public List<String> addTabCompletionOptions(ICommandSender sender, String[] args, BlockPos pos) {
        return new ArrayList<>();
    }

    @Override
    public boolean isUsernameIndex(String[] args, int index) {
        return false;
    }

    @Override
    public int compareTo(@NotNull ICommand o) {
        return 0;
    }
}
