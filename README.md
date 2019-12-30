# 走迷宫

## 设计要求
设计 GUI 界面的走迷宫，游戏结果是让走迷宫者从迷宫入口走到迷宫出口。具体要求如下：
1、程序可以给出随机生成的迷宫，也可以给出一个固定的迷宫。
2、用户用鼠标单击走迷宫者，然后按方向键让走迷宫者在迷宫的路上走动。当走迷宫者开始走动后程序启动计时器。
3、 在迷宫的某些路点可以设置一个数字（模拟收费），走迷宫者路过有数字的路点（包括重复路过）将把数字累加到自己的某个变量中，即这个变量的值代表走迷宫者最后需要缴纳的路费。
4、 当走迷宫者到达出口时，用户必须输入走迷宫者需要缴纳的路费才能使得走迷宫者离开出口，然后程序停止计时。
5、对于随机迷宫，用户单击按钮，程序将再随机给出一个迷宫。 
6、对于固定的迷宫，用户单击按钮，允许用户再走一次当前迷宫。

## 数据模型
CreateDatabaseAndTable类：负责创建数据库和表。
Point类：封装了迷宫中点的属性和行为，比如一个点是否为路、是否为收费点等。
MazeMaker接口：封装得到迷宫的方法。
MazeByRandom类：负责给出随机迷宫。
MazeByFile 类：负责给出一个固定的迷宫。
SetRoad 类：负责设置哪些点是路。
SetChargeOnRoad抽象类：封装设置收费点的方法。
ChargeOnRoad 类：SetChargeOnRoad 类的子类，负责给出具体的收费点。
PersonInMaze类：其实例是迷宫中走动者的视图。
MazeView类：其实例为迷宫提供视图。
RandomMazeView类：MazeView类的子类，其实例为随机迷宫提供视图。
FixedMazeView类：MazeView 类的子类，其实例为一个迷宫提供视图。
HandleMove 类：其实例是一个监视器，该监视器负责MazeView视图上的界面事件。

## 任务分配
寿锡麟：Point类，Mazemaker接口，SetRoad类，AppWindow类
吴柏杨：MazeByRandom类
王力学：MazeByFile类，SetChargeOnRoad类，ChargeOnRoad类，AppTest类
戴佳森：PersonInMaze类，MazeView类，RandomMazzeView类
顾书财：FixedMazeView类，IntegrationView类，HandleMove类

第一、二天：完成程序设计文档（UML图、需求、数据库、界面、功能）
第三、四天：搞定程序（源代码、编程打包）并测试（代码、文档）
