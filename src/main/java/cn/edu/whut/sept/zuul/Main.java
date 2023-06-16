/**
 * 该类是“World-of-Zuul”应用程序的启动类。
 * 《World of Zuul》是一款简单的文本冒险游戏。用户可以在一些房间组成的迷宫中探险。
 *
 * @author
 * @version 2.0
 */
package cn.edu.whut.sept.zuul;

public class Main {

    public static void main(String[] args) {
        Game game = new Game();
        game.play();
    }
}
