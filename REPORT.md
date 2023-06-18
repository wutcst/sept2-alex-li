# 软件工程实训任务二REPORT

#### 游戏网址：**http://1.13.173.161/main**

| 小组成员        | 任务              |
| --------------- | ----------------- |
| 软件2002 李烨   | 代码开发与测试    |
| 软件2002 邱允   | 架构设计与ppt设计 |
| 软件2002 徐怡凡 | 文档撰写与集成    |

- **项目介绍**

  **巨洞探险游戏（Colossal Cave Adventure）在游戏中，用户是探险家身份，在充满野兽和其他怪物的地牢里搜索，通过洞穴里的食物来补充能量才补充体能，拾起掉落的宝剑等武器来增强自身能量值，只有打败所有的怪物才能顺利通关成功，一起去冒险吧**！

- **功能扩充需求点**

  1.实现房间内存放任意数量的物品，房间内存在怪兽，物品和怪兽有对应的属性值

  2.增加player类，玩家具有背包、属性值

  3.实现连续返回多层房间

  4.玩家可以查看房间内的物品信息和怪兽信息，捡起物品或丢弃物品

  5.玩家需要打败怪兽完成通关

- **开发工具**

  后端：springboot+mybatisPlus

  前端：vue+elementUI

  编辑器：IDEA+VScode

- **整体架构图 **

![image-20230618172240150](http://qiniuyun.zhihuiguliao.com/myBlogImages_Mac/image-20230618172240150.png)

- **数据库设计**

  ![image-20230618172339558](http://qiniuyun.zhihuiguliao.com/myBlogImages_Mac/image-20230618172339558.png)

- **功能架构图**

  ![image-20230618172506110](http://qiniuyun.zhihuiguliao.com/myBlogImages_Mac/image-20230618172506110.png)

- **部分代码**

  ![image-20230618173204637](http://qiniuyun.zhihuiguliao.com/myBlogImages_Mac/image-20230618173204637.png)

  ![image-20230618173342841](http://qiniuyun.zhihuiguliao.com/myBlogImages_Mac/image-20230618173342841.png)

- **游戏界面**

  ![image-20230618172513733](http://qiniuyun.zhihuiguliao.com/myBlogImages_Mac/image-20230618172513733.png)

  ![image-20230618172522362](http://qiniuyun.zhihuiguliao.com/myBlogImages_Mac/image-20230618172522362.png)

  ![image-20230618172534560](http://qiniuyun.zhihuiguliao.com/myBlogImages_Mac/image-20230618172534560.png)

  ![image-20230618172547362](http://qiniuyun.zhihuiguliao.com/myBlogImages_Mac/image-20230618172547362.png)

  ![image-20230618172555775](http://qiniuyun.zhihuiguliao.com/myBlogImages_Mac/image-20230618172555775.png)

  ![image-20230618172603463](http://qiniuyun.zhihuiguliao.com/myBlogImages_Mac/image-20230618172603463.png)

- **项目部署**

  前端vue 使用 npm run build 指令打包生成dist目录
  
  后端springboot 使用maven package 打包生成jar包
  
  数据库导出sql
  
  部署至云服务器
  
  ![image-20230618172734885](http://qiniuyun.zhihuiguliao.com/myBlogImages_Mac/image-20230618172734885.png)

![image-20230618172753717](http://qiniuyun.zhihuiguliao.com/myBlogImages_Mac/image-20230618172753717.png)

最终实现公网访问！

- **实验体会**

​       通过本次实验，我们以小组形式完成了巨洞冒险游戏开发，前端使用vue+elementUI，后端使用springboot+mybatisPlus+mysql。我们小组分工明确，协同开发，通过使用git借助github最终一起完成了实践任务，每位成员都基本掌握了maven的软件项目管理机制、github的小组协同开发工具和平台，明白了协作开发的重要性，通过前后端分离实现了项目的开发及部署，完成了对实践一的扩展，是一次很好的项目实践。
