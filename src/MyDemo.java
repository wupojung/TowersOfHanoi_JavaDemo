import java.util.Scanner;

public class MyDemo {

    public static void main(String[] args) {
        int level = 0;

        //取得輸入訊息
        do {
            System.out.print("請依序輸入河內塔 層數 (1-10):");  //單純受到 甲乙丙丁 中文字的限制，否則可以更多
            Scanner sc = new Scanner(System.in);
            level = sc.nextInt();
        } while (level < 1 || level > 10);

        //進行遊戲
        HanoiTowerGame game = new HanoiTowerGame();
        game.Play(level, 3, 1);  //重 第3柱 移動到第1柱
    }

}
