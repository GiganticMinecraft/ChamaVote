package click.seichi.chamavote.commands

import click.seichi.chamavote.Config
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

        voters.getValues(false).values.groupingBy { it }.eachCount()
            .toList().sortedByDescending { it.second }
            .mapIndexed { idx, value ->
                "${selectChatColor(idx)}${value.first.toString().uppercase()} -> ${value.second}票"
            }.forEach { sender.sendMessage(it) }

        return true
    }

    private fun selectChatColor(index: Int): ChatColor = when(index) {
        0 -> ChatColor.LIGHT_PURPLE
        1 -> ChatColor.BLUE
        2 -> ChatColor.AQUA
        else -> ChatColor.WHITE
    }
}