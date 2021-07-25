package click.seichi.chamavote.commands

import click.seichi.chamavote.Config
import org.bukkit.ChatColor
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

object ConfirmVoteCommand : CommandExecutor {
    override fun onCommand(
        sender: CommandSender,
        command: Command,
        label: String,
        args: Array<out String>
    ): Boolean {
        if (sender !is Player) {
            sender.sendMessage("${ChatColor.RED}このコマンドはゲーム内から実行してください。")
            return true
        }

        val message = Config.getSection("voter")?.get(sender.uniqueId.toString())?.let {
            "${ChatColor.GREEN}あなたは「${it}」に投票しています。"
        } ?: "${ChatColor.RED}あなたはどの保護にも投票していません。"

        sender.sendMessage(message)

        return true
    }
}