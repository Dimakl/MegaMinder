package com.example.lera.megaminder;

public class Builder {


    public static int RandomizerResult() {
        return (int) Math.round(Math.random());
    }


    public static int FirstChecker(int firstOp, int secondOp, int thirdOp, int firstOtr, int secondOtr, int thirdOtr) {
        byte[] bytes = new byte[4];
        int firstAns = 0, secondAns = 0, thirdAns = 0, using0 = 0, using1 = 0, result = 0;
        for (int i = 0; i < 4; i++) {
            bytes[i] = 0;
        }

        for (int j = 0; j < 3; j++) {
            if (j != 0) {
                bytes[j - 1] = 1;
            }

            for (int z = 2; z < 5; z++) {
                if (z != 2) bytes[z - 1] = 1;
                switch (firstOp) {
                    case 1: {
                        firstAns = bytes[0] & bytes[1];
                        break;
                    }
                    case 0: {
                        firstAns = bytes[0] | bytes[1];
                        break;
                    }
                }
                if (firstOtr == 1) {
                    firstAns = ~firstAns;
                }
                switch (secondOp) {
                    case 1: {
                        secondAns = bytes[2] & bytes[3];
                        break;
                    }
                    case 0: {
                        secondAns = bytes[2] | bytes[3];
                        break;
                    }
                }
                if (secondOtr == 1) {
                    secondAns = ~secondAns;
                }
                switch (thirdOp) {
                    case 1: {
                        thirdAns = secondAns & firstAns;
                        break;
                    }
                    case 0: {
                        thirdAns = secondAns | firstAns;
                        break;
                    }
                }
                if (thirdAns == 1) {
                    secondAns = ~thirdAns;
                }
                if (thirdAns == 1) using1++;
                else if (thirdAns == 0) using0++;
            }
            bytes[2] = 0;
            bytes[3] = 0;
        }
        if (using0 <= using1) {
            return 0;
        } else return 1;

    }

}
