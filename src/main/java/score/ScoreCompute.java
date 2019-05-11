package score;

/**
 * Created by zjm on 2019/3/30.
 */
public class ScoreCompute {

    public static void main(String[] args) {

        float da1sTotalScore = 0.5f + 2 + 6 + 3 + 1 + 2 + 1 + 1 + 3.5f;
        float da1sTotal = 0.5f * 89 + 2 * 72 + 6 * 84 + 3 * 78 + 82 + 2 * 76 + 87 + 94 + 3.5f * 92;
        System.out.println("大一上学期总学分：" + da1sTotalScore + "；大一上学期平均成绩：" + da1sTotal / da1sTotalScore);

        float da1xTotalScore = 2 + 5 + 3.5f + 2 + 1 + 2 + 4 + 0.5f + 4 + 2;
        float da1xTotal = 2 * 68 + 5 * 81 + 3.5f * 95 + 2 * 86 + 86 + 2 * 77 + 4 * 90 + 0.5f * 83 + 4 * 77 + 2 * 71;
        System.out.println("大一下学期总学分：" + da1xTotalScore + "；大一下学期平均成绩：" + da1xTotal / da1xTotalScore);

        float da2TotalScore = 3 + 1 + 3 + 3 + 2 + 3 + 1 + 2 + 0.5f + 4 + 1 + 4 + 2;
        float da2Total = 3 * 83 + 100 + 3 * 82 + 3 * 86 + 2 * 89 + 3 * 85 + 89 + 2 * 71 + 0.5f * 93 + 4 * 90 + 87 + 4 * 85 + 2 * 93;
        System.out.println("大二上学期总学分：" + da2TotalScore + "；大二上学期平均成绩：" + da2Total / da2TotalScore);

        System.out.println("三个学期总学分：" + (da1sTotalScore + da1xTotalScore + da2TotalScore) + "；三个学期平均成绩：" + (da1sTotal + da1xTotal + da2Total) / (da1sTotalScore + da1xTotalScore + da2TotalScore));
    }
}
