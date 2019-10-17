import java.util.Arrays;

public class HanoiTowerGame {

    private HanoiColumn[] HanoiColumns = null; //柱子
    private String[] ColumnContentTemplate = {"甲", "乙", "丙", "丁", "戊", "己", "庚", "辛", "壬", "癸"};
    private int stepCount = 0;


    public HanoiTowerGame() {
        //初始化柱子(容器)
        HanoiColumns = new HanoiColumn[3]; //柱子
        for (int i = 0; i < 3; i++) {
            HanoiColumns[i] = new HanoiColumn();
        }
    }

    public void Play(int level, int fromId, int toId) {
        if (level > ColumnContentTemplate.length) {
            System.out.println("T^T 內容物無法命名 T^T ");
            return; //強制離開,不給玩
        }

        String[] content = Arrays.copyOfRange(ColumnContentTemplate, 0, level); //取得子陣列
        SetupColumnById(fromId, content);//初始化資料

        int aux = GetAuxiliaryColumnId(fromId, toId); //計算輔助 柱子的ID
        Hanoi(level, fromId, toId, aux);  //遞迴求解

    }

    //河內塔演算法 (遞迴)
    private void Hanoi(int Disk, int Src, int Dest, int Aux) {

        if (Disk == 1) {
            stepCount++; //紀錄步數
            //實際抽換資料(對柱子暫存資料進行移動)
            String temp = HanoiColumns[Src - 1].content.pop();
            HanoiColumns[Dest - 1].content.push(temp);

            //呈現資料
            System.out.println("第" + stepCount + "步 將" + temp + "移動到第" + Dest + "根柱子");
        } else {
            Hanoi(Disk - 1, Src, Aux, Dest);
            Hanoi(1, Src, Dest, Aux);  //實際操作 移動 物件
            Hanoi(Disk - 1, Aux, Dest, Src);
        }
    }

    //取得輔助柱子的編號
    private int GetAuxiliaryColumnId(int fromId, int toId) {
        int result = 0;
        int[] ColumnIdTemplate = {1, 2, 3};
        for (int id : ColumnIdTemplate) {  //陷阱:三選一 才可以這樣寫
            if (id != fromId && id != toId) {  //既不是 from 又不是 to , 則為 輔助支柱(Aux)
                result = id;
                break;
            }
        }
        return result;
    }

    //設定柱子的內容
    private void SetupColumnById(int Id, String[] content) {
        //倒序放進Stack
        //例如輸入 "甲","乙","丙" 則存在 資料結構上會 是
        // ------
        //  甲
        //  乙
        //  丙
        // ------
        for (int i = content.length - 1; i >= 0; i--) {
            HanoiColumns[Id - 1].content.push(content[i]);
        }
    }

}

