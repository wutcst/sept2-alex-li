/**
 * 该类是“World-of-Zuul”应用程序的一部分。
 * 《World of Zuul》是一款简单的文本冒险游戏。用户可以在一些房间组成的迷宫中探险。
 * 你们可以通过扩展该游戏的功能使它更有趣!
 *
 * 此类可执行go指令
 *
 * @author  Michael Kölling and David J. Barnes
 * @version 2.0
 */
package cn.edu.whut.sept.zuul;

public class GoCommand extends Command
{/**
 * @param game
 * 执行go指令，向房间的指定方向出口移动，如果该出口连接了另一个房间，则会进入该房间，
 * 否则打印输出错误提示信息.
 */
    public boolean execute(Game game)
    {
        if(!hasSecondWord()) {
            System.out.println("Go where?");
        }

        String direction = getSecondWord();
        Room currentRoom = game.getCurrentRoom();

        Room nextRoom = game.getCurrentRoom().getExit(direction);

        if (nextRoom == null) {
            System.out.println("There is no door!");
        }
        else {
            game.setCurrentRoom(nextRoom);
            System.out.println(nextRoom.getLongDescription());
        }

        return false;
    }
}
