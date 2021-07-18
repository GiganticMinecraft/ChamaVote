package click.seichi.chamavote.commands

import click.seichi.chamavote.Config
import click.seichi.chamavote.WorldGuard
import org.bukkit.ChatColor
import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.command.TabExecutor
import org.bukkit.entity.Player

object VoteCommand : TabExecutor {
    override fun onTabComplete(
        sender: CommandSender?,
        command: Command?,
        alias: String?,
        args: Array<out String>?
    ): List<String> =
        if (sender !is Player || args?.size != 1) listOf()
        else WorldGuard.getRegions(sender.world, sender.location).map { it.id }.toList()

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

        val regions = WorldGuard.getRegions(sender.world, sender.location)
        if (regions.size != 1) {
            sender.sendMessage("${ChatColor.RED}現在立っている座標に1つも保護がないか、複数の保護が重なっているようです。保護が1つだけある場所で実行して下さい。")
            return true
        }
        val regionName = regions.first().id

        Config.setData("voter.${sender.uniqueId}", regionName)

        sender.sendMessage("${ChatColor.GREEN}${regionName}に投票しました。再度コマンドを実行すると投票先をいつでも変更できます。")

        return true
    }
}