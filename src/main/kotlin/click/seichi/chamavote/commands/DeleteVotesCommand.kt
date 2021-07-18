package click.seichi.chamavote.commands

import click.seichi.chamavote.Config
import org.bukkit.ChatColor
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.command.ConsoleCommandSender

object DeleteVotesCommand: CommandExecutor {
    override fun onCommand(
        sender: CommandSender,
        command: Command,
        label: String,
        args: Array<out String>
    ): Boolean {
        if (sender !is ConsoleCommandSender) {
            sender.sendMessage("${ChatColor.RED}このコマンドはコンソールから実行してください。")
            return true
        }

        Config.setData("voter", null)

        sender.sendMessage("${ChatColor.GREEN}投票データを削除しました。")

        return true
    }
}