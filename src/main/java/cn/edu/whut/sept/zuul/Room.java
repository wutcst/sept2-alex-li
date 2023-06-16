/**
 * 该类是“World-of-Zuul”应用程序的一部分。
 * 《World of Zuul》是一款简单的文本冒险游戏。用户可以在一些房间组成的迷宫中探险。
 * 你们可以通过扩展该游戏的功能使它更有趣!
 *
 * 该类可创建房间
 *
 * @author  Michael Kölling and David J. Barnes
 * @version 2.0
 */
package cn.edu.whut.sept.zuul;

import java.util.Set;
import java.util.HashMap;

public class Room
{
    private String description;
    private HashMap<String, Room> exits;        // stores exits of this room.
    /**
     * 创建一个房间
     *  @param description 房间的描述
     */
    public Room(String description)
    {
        this.description = description;
        exits = new HashMap<>();
    }
    /**
     * 设置出口
     */
    public void setExit(String direction, Room neighbor)
    {
        exits.put(direction, neighbor);
    }
    /**
     * 获取短描述
     * @return 返回短描述
     */
    public String getShortDescription()
    {
        return description;
    }
    /**
     * 获取长描述
     * @return 返回长描述
     */
    public String getLongDescription()
    {
        return "You are " + description + ".\n" + getExitString();
    }
    /**
     * 当前房间的出口
     * @return 返回当前房间的出口
     */
    private String getExitString()
    {
        String returnString = "Exits:";
        Set<String> keys = exits.keySet();
        for(String exit : keys) {
            returnString += " " + exit;
        }
        return returnString;
    }
    /**
     * 获取出口
     * @param direction
     * @return 返回出口
     */
    public Room getExit(String direction)
    {
        return exits.get(direction);
    }
}


