/**
 * 该类是“World-of-Zuul”应用程序的一部分。
 * 《World of Zuul》是一款简单的文本冒险游戏。用户可以在一些房间组成的迷宫中探险。
 * 你们可以通过扩展该游戏的功能使它更有趣!
 *
 * 此解析器读取用户输入并尝试将其解释为“冒险”命令。每次调用它时，它都会从终端读取一条线路
 * 尝试将该行解释为双字命令。它返回命令作为Command类的对象。
 *
 * 解析器有一组已知的命令字。它检查用户输入已知命令，如果输入不是已知命令之一，则
 * 返回标记为未知命令的命令对象。
 *
 * @author  Michael Kölling and David J. Barnes
 * @version 2.0
 */
package cn.edu.whut.sept.zuul;

import java.util.Scanner;

public class Parser
{
    private CommandWords commands;  // holds all valid command words
    private Scanner reader;         // source of command input
    /**
     * 创建要从终端窗口读取的解析器。
     */
    public Parser()
    {
        commands = new CommandWords();
        reader = new Scanner(System.in);
    }
    /**
     * 得到下一个命令
     * @return 用户的下一个命令。
     */
    public Command getCommand()
    {
        String inputLine;   // will hold the full input line
        String word1 = null;
        String word2 = null;

        System.out.print("> ");     // print prompt

        inputLine = reader.nextLine();

        Scanner tokenizer = new Scanner(inputLine);
        if(tokenizer.hasNext()) {
            word1 = tokenizer.next();      // get first word
            if(tokenizer.hasNext()) {
                word2 = tokenizer.next();      // get second word
            }
        }

        Command command = commands.get(word1);
        if(command != null) {
            command.setSecondWord(word2);
        }
        return command;
    }
    /**
     * 显示所有命令
     */
    public void showCommands()
    {
        commands.showAll();
    }
}

