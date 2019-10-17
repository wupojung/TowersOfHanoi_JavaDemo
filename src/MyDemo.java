public class MyDemo {
    public static HanoiColumn[] HanoiColumns = new HanoiColumn[3]; //柱子
    public static int stepCount = 0;

    public static void main(String[] args) {
        HanoiColumns = new HanoiColumn[3];
        for (int i = 0; i < 3; i++) {
            HanoiColumns[i] = new HanoiColumn();
        }
        HanoiColumns[2].content.push("丙");
        HanoiColumns[2].content.push("乙");
        HanoiColumns[2].content.push("甲");
        // 3-->1 by 2
        Hanoi(3, 3, 1, 2);
    }

    public static void Hanoi(int Disk, int Src, int Dest, int Aux) {

        if (Disk == 1) {
            stepCount++; //紀錄步數
            //實際抽換資料(對柱子暫存資料進行移動)
            String temp = HanoiColumns[Src - 1].content.pop();
            HanoiColumns[Dest - 1].content.push(temp);
            //呈現資料
            System.out.println("第" + stepCount + "步 將" + temp + "移動到第" + Dest + "根柱子");
            //System.out.println("第"+stepCount+"步 "+temp+" "+ Src + "-->" + Dest  ); // for debug

        } else {
            Hanoi(Disk - 1, Src, Aux, Dest);
            Hanoi(1, Src, Dest, Aux);  //實際操作 移動 物件
            Hanoi(Disk - 1, Aux, Dest, Src);
        }
    }
}
