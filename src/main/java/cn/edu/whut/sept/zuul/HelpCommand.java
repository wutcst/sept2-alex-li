/**
 * 该类是“World-of-Zuul”应用程序的一部分。
 * 《World of Zuul》是一款简单的文本冒险游戏。用户可以在一些房间组成的迷宫中探险。
 * 你们可以通过扩展该游戏的功能使它更有趣!
 *
 * 此类可执行help指令
 *
 * @author  Michael Kölling and David J. Barnes
 * @version 2.0
 */
package cn.edu.whut.sept.zuul;

public class HelpCommand extends Command
{
    private CommandWords commandWords;

    public HelpCommand(CommandWords words)
    {
        commandWords = words;
    }

    /**
     * @param game
     * 执行help指令，在终端打印游戏帮助信息.
     * 此处会输出游戏中用户可以输入的命令列表
     */
    public boolean execute(Game game)
    {

        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the university.");
        System.out.println();
        System.out.println("Your command words are:");
        commandWords.showAll();
        return false;
    }
}
