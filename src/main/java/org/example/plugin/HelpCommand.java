package org.example.plugin;

import java.sql.Ref;

import javax.annotation.Nonnull;

import com.hypixel.hytale.protocol.GameMode;
import com.hypixel.hytale.server.core.Message;
import com.hypixel.hytale.server.core.command.system.basecommands.AbstractPlayerCommand;
/**
 * This is an Help command that will simply print the name of the plugin in chat when used.
 */
public class HelpCommand extends AbstractPlayerCommand {

    private final String pluginName;
    private final String pluginVersion;

    public HelpCommand(@Nonnull String pluginName, @Nonnull String pluginVersion, boolean requiresConfirmation) {
        super("help", "Prints a help message from the " + pluginName + " plugin.", requiresConfirmation);
        this.setPermissionGroup(GameMode.Adventure); // Allows the command to be used by anyone, not just OP
        this.pluginName = pluginName;
        this.pluginVersion = pluginVersion;
    }

    @Override
    protected void execute(@Nonnull CommandContext ctx, @Nonnull Store<EntityStore> store, @Nonnull Ref<EntityStore> ref, @Nonnull PlayerRef playerRef, @Nonnull World world) {
        EventTitleUtil.showEventTitleToPlayer(playerRef, Message.raw("Fumonomicon v"+pluginVersion), Message.raw("Use /help for more info!"),true);
    }
}