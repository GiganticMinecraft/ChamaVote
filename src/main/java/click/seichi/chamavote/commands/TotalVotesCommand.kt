package click.seichi.chamavote.commands

import click.seichi.chamavote.Config
import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender

object TotalVotesCommand: CommandExecutor {
    override fun onCommand(
        sender: CommandSender,
        command: Command,
        label: String,
        args: Array<out String>
    ): Boolean {
        val voters = Config.getSection("voter") ?: run {
            sender.sendMessage("${ChatColor.RED}投票データが見つかりません。")
            return true
        }

        val result =
            voters.getValues(false).values.toList().groupingBy { it }.eachCount().filter { it.value > 0 }
            .toList().sortedByDescending { it.second }
        sender.sendMessage(result.toString())
        return true
    }
}