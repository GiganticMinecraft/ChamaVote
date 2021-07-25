# ChamaVote

このプラグインは、WorldGuardと連携し、保護に対してそれぞれ1MCIDごとに投票を行うことができ、また、その結果を集計して表示することができます。
Spigot 1.12.2用プラグインです。  
[ChamaVoteManager](https://github.com/GiganticMinecraft/ChamaVoteManager)を置き換えるために作成しました。

## コマンド

| コマンド | 説明 | 権限ノード | デフォルト | エイリアス |
| --- | --- | --- | --- | ---|
| cvote | 投票を行うコマンド。 | - | true（全員が実行可能） | - |
| cdeletevotes | 投票データを全て削除するコマンド。 | chamavote.cdeletevotes | op（OP権限保持者のみ実行可能） | - |
| ctotalvotes | 投票データを集計し、票数の多い順に保護名を表示するコマンド。 | chamavote.ctotalvotes  | op（OP権限保持者のみ実行可能） | - |
| cconfirmvote | 自分が投票した保護名を確認するコマンド。 | - | true（全員が実行可能） | ccvote |

## 前提プラグイン

* WorldGuard 6.2

## ビルド方法

IntelliJ IDEAでの説明を以下に記載します。

* Gradleタスクのうち、Jarを実行

## ライセンス

[GPL v3](LICENSE)
