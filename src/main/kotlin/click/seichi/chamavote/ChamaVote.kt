package click.seichi.chamavote

import click.seichi.chamavote.commands.DeleteVotesCommand
import click.seichi.chamavote.commands.TotalVotesCommand
import click.seichi.chamavote.commands.VoteCommand
import org.bukkit.command.CommandExecutor
import org.bukkit.plugin.java.JavaPlugin

class ChamaVote : JavaPlugin() {
    companion object {
        lateinit var plugin: ChamaVote
            private set
    }

    override fun onEnable() {
        plugin = this
        registerCommands(
            "cvote" to VoteCommand,
            "cdeletevotes" to DeleteVotesCommand,
            "ctotalvotes" to TotalVotesCommand
        )
        Config.load()
        WorldGuard.setInstance()
    }

    override fun onDisable() {
        // Plugin shutdown logic
    }

    private fun registerCommands(vararg commands: Pair<String, CommandExecutor>) =
        commands.forEach { this.getCommand(it.first).executor = it.second }
}