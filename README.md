＃走迷宫
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

寿锡麟：Point类，Mazemaker接口，SetRoad类，AppWindow类
吴柏杨：MazeByRandom类
王力学：MazeByFile类，SetChargeOnRoad类，ChargeOnRoad类，AppTest类
戴佳森：PersonInMaze类，MazeView类，RandomMazzeView类
顾书财：FixedMazeView类，IntegrationView类，HandleMove类

第一、二天：完成程序设计文档（UML图、需求、数据库、界面、功能）
第三、四天：搞定程序（源代码、编程打包）并测试（代码、文档）
