/**
 * 该类是“World-of-Zuul”应用程序的一部分。
 * 《World of Zuul》是一款简单的文本冒险游戏。用户可以在一些房间组成的迷宫中探险。
 * 你们可以通过扩展该游戏的功能使它更有趣!
 *
 * 此类获取有关用户发出的Command对象的信息。
 *
 * @author  Michael Kölling and David J. Barnes
 * @version 2.0
 */
package cn.edu.whut.sept.zuul;

public abstract class Command
{
    private String secondWord;
    /**
     * 创建一个Command对象
     */
    public Command()
    {
        secondWord = null;
    }
    /**
     * 获取Command对象的第二个单词
     * @return 返回Command对象的第二个单词
     */
    public String getSecondWord()
    {
        return secondWord;
    }
    /**
     * @return Command对象有第二个单词。返回true
     */
    public boolean hasSecondWord()
    {
        return secondWord != null;
    }
    /**
     * @param secondWord 对象的第二个单词
     */
    public void setSecondWord(String secondWord)
    {
        this.secondWord = secondWord;
    }

    public abstract boolean execute(Game game);
}
