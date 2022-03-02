import javafx.scene.control.Label;

public class LIS {
int[] LEDS;
int[] LCS;
int size;
int[] subArray;
boolean[] ON;
int max, maxindex;
int subsequence[];
public LIS (int[]LEDS, int size) {
    this.LEDS = LEDS;
    this.size = size;
    findlis(LEDS,size);
    }
public void findlis(int[] LEDS, int size) {
    ON = new boolean[size];
     subArray = new int[size];
    LCS = new int[size];
    for (int i = 0; i < size; i++) {
        LCS[i] = 1; // initial value
        subArray[i] = -1;
    }
    for (int i = 1; i < LCS.length; i++) {
        for (int j = 0; j < i; j++) {
            if (LEDS[i] >= LEDS[j] && LCS[i] <= LCS[j] + 1) {
                LCS[i] = LCS[j] + 1;
                subArray[i] = j;
            }
        }
    }
    maxindex = max_index(LCS);
    ON[maxindex] = true;

    int maxindex2 = subArray[maxindex];
    while (true) {
        if (maxindex2 == -1)
            break;
        ON[maxindex2] = true;
        maxindex2 = subArray[maxindex2];

    }




}


    public int max (int[] LCS) {
         max = LCS[0];
        for (int i = 1; i < LCS.length; i++)
            if (max<LCS[i])
                max = LCS[i];
        return max;
    }
    public  int max_index(int []LiS) {
         max = LiS[0];
        int index = 0;
        for (int i = 1; i < LiS.length; i++)
            if (max<LiS[i]) {
                max = LiS[i];
                index = i;
            }
        return index;
    }

    public String subsequnceString() {
    String text = "";
    subsequence = new int[max];
    int[] s = new int[subArray.length];
        for (int i = 0; i < subArray.length; i++) {
            s[i] = subArray[i];
        }
    int c = 0;
        for (int i = 0; i < ON.length; i++) {
            if(ON[i]==true)
            {
                s[c] = LEDS[i];
                text+=LEDS[i]+" ";
                c++;
            }
        }
        return text;
    }

}