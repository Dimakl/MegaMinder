package com.example.lera.megaminder;

import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.Switch;

public class LogicActivity extends AppCompatActivity {

    FloatingActionButton fab;
    Button ok;
    ImageView firstOper, secondOper, thirdOper, ans;
    Switch switch1, switch2, switch3, switch4;
    Chronometer chrono;
    static Bitmap first, second, third, answer;

    public static int firstOp = RandomizerResult(), secondOp = RandomizerResult(), thirdOp = RandomizerResult(), firstOtr = RandomizerResult(), secondOtr = RandomizerResult(), thirdOtr = RandomizerResult();
    public static int ANSWER = FirstChecker();
    public static int switch1cost, switch2cost, switch3cost, switch4cost;
    public static int goodAns, fOpAns, sOpAns;
    public static int powerOfMind = 0;

    public static int RandomizerResult() {
        return (int) Math.round(Math.random());
    }

    public static int FirstChecker() {
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_logic);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        firstOper = (ImageView) findViewById(R.id.first);
        secondOper = (ImageView) findViewById(R.id.second);
        thirdOper = (ImageView) findViewById(R.id.third);
        ans = (ImageView) findViewById(R.id.ans);
        ok = (Button) findViewById(R.id.ok);
        switch1 = (Switch) findViewById(R.id.switch1);
        switch2 = (Switch) findViewById(R.id.switch2);
        switch3 = (Switch) findViewById(R.id.switch3);
        switch4 = (Switch) findViewById(R.id.switch4);
        chrono = (Chronometer) findViewById(R.id.chrono);


        switch (firstOp) {
            case 0: {
                switch (firstOtr) {
                    case 0: {
                        firstOper.setImageResource(R.drawable.nicefirstand);
                        break;
                    }
                    case 1: {
                        firstOper.setImageResource(R.drawable.firstnotand);
                        break;
                    }
                }
                break;
            }
            case 1: {
                switch (firstOtr) {
                    case 0: {
                        firstOper.setImageResource(R.drawable.firstdo);
                        break;
                    }
                    case 1: {
                        firstOper.setImageResource(R.drawable.firstdonot);
                        break;
                    }
                }
                break;
            }

        }
        switch (secondOp) {
            case 0: {
                switch (secondOtr) {
                    case 0: {
                        secondOper.setImageResource(R.drawable.nicethirdand);
                        break;
                    }
                    case 1: {
                        secondOper.setImageResource(R.drawable.thirdnotand);
                        break;
                    }
                }
                break;
            }

            case 1: {
                switch (secondOtr) {
                    case 0: {
                        secondOper.setImageResource(R.drawable.thirddo);
                        break;
                    }
                    case 1: {
                        secondOper.setImageResource(R.drawable.thirddonot);
                        break;
                    }
                }
                break;
            }
        }
        switch (thirdOp) {
            case 0: {
                switch (thirdOtr) {
                    case 0: {
                        thirdOper.setImageResource(R.drawable.lastand);
                        break;
                    }
                    case 1: {
                        thirdOper.setImageResource(R.drawable.lastnotand);
                        break;
                    }
                }
                break;
            }
            case 1: {
                switch (thirdOtr) {
                    case 0: {
                        thirdOper.setImageResource(R.drawable.lastdo);
                        break;
                    }
                    case 1: {
                        thirdOper.setImageResource(R.drawable.lastdonot);
                        break;
                    }
                }
                break;
            }
        }
        if (ANSWER == 0) {
            ans.setImageResource(R.drawable.anszero);
        } else if (ANSWER == 1) {
            ans.setImageResource(R.drawable.ansone);
        }
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ANSWER = FirstChecker();
                if (switch1.isChecked()) switch1cost = 1;
                else switch1cost = 0;

                if (switch2.isChecked()) switch2cost = 1;
                else switch2cost = 0;

                if (switch3.isChecked()) switch3cost = 1;
                else switch3cost = 0;

                if (switch4.isChecked()) switch4cost = 1;
                else switch4cost = 0;

                switch (firstOp) {


                    case 0: {
                        switch (firstOtr) {
                            case 0: {
                                fOpAns = switch1cost & switch2cost;
                                break;
                            }
                            case 1: {
                                fOpAns = ~(switch1cost & switch2cost);
                                break;
                            }
                        }
                        break;
                    }

                    case 1: {
                        switch (firstOtr) {
                            case 0: {
                                fOpAns = switch1cost | switch2cost;
                                break;
                            }
                            case 1: {
                                fOpAns = ~(switch1cost | switch2cost);
                                break;
                            }
                        }
                        break;
                    }

                }

                switch (secondOp) {


                    case 0: {
                        switch (secondOtr) {
                            case 0: {
                                sOpAns = switch3cost & switch4cost;
                                break;
                            }
                            case 1: {
                                sOpAns = ~(switch3cost & switch4cost);
                                break;
                            }
                        }
                        break;
                    }

                    case 1: {
                        switch (secondOtr) {
                            case 0: {
                                sOpAns = switch3cost | switch4cost;
                                break;
                            }
                            case 1: {
                                sOpAns = ~(switch3cost | switch4cost);
                                break;
                            }
                        }
                        break;
                    }

                }

                switch (thirdOp) {


                    case 0: {
                        switch (thirdOtr) {
                            case 0: {
                                goodAns = fOpAns & sOpAns;
                                break;
                            }
                            case 1: {
                                goodAns = ~(fOpAns & sOpAns);
                                break;
                            }
                        }
                        break;
                    }

                    case 1: {
                        switch (thirdOtr) {
                            case 0: {
                                goodAns = fOpAns | sOpAns;
                                break;
                            }
                            case 1: {
                                goodAns = ~(fOpAns | sOpAns);
                                break;
                            }
                        }
                        break;
                    }

                }

                if (goodAns == ANSWER) {
                    powerOfMind++;
                    Snackbar.make(view, "Ура, правильный ответ, и уже  " + powerOfMind + " ответов правильно", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                } else {
                    powerOfMind = 0;
                    Snackbar.make(view, "Ой, неправильный ответ, теперь ваш счет -  " + powerOfMind, Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }

                firstOp = RandomizerResult();
                secondOp = RandomizerResult();
                thirdOp = RandomizerResult();
                firstOtr = RandomizerResult();
                secondOtr = RandomizerResult();
                thirdOtr = RandomizerResult();
                switch (firstOp) {


                    case 0: {
                        switch (firstOtr) {
                            case 0: {
                                firstOper.setImageResource(R.drawable.nicefirstand);
                                break;
                            }
                            case 1: {
                                firstOper.setImageResource(R.drawable.firstnotand);
                                break;
                            }
                        }
                        break;
                    }
                    case 1: {
                        switch (firstOtr) {
                            case 0: {
                                firstOper.setImageResource(R.drawable.firstdo);
                                break;
                            }
                            case 1: {
                                firstOper.setImageResource(R.drawable.firstdonot);
                                break;
                            }
                        }
                        break;
                    }

                }

                switch (secondOp) {
                    case 0: {
                        switch (secondOtr) {
                            case 0: {
                                secondOper.setImageResource(R.drawable.nicethirdand);
                                break;
                            }
                            case 1: {
                                secondOper.setImageResource(R.drawable.thirdnotand);
                                break;
                            }
                        }
                        break;
                    }

                    case 1: {
                        switch (secondOtr) {
                            case 0: {
                                secondOper.setImageResource(R.drawable.thirddo);
                                break;
                            }
                            case 1: {
                                secondOper.setImageResource(R.drawable.thirddonot);
                                break;
                            }
                        }
                        break;
                    }
                }
                switch (thirdOp) {
                    case 0: {
                        switch (thirdOtr) {
                            case 0: {
                                thirdOper.setImageResource(R.drawable.lastand);
                                break;
                            }
                            case 1: {
                                thirdOper.setImageResource(R.drawable.lastnotand);
                                break;
                            }
                        }
                        break;
                    }
                    case 1: {
                        switch (thirdOtr) {
                            case 0: {
                                thirdOper.setImageResource(R.drawable.lastdo);
                                break;
                            }
                            case 1: {
                                thirdOper.setImageResource(R.drawable.lastdonot);
                                break;
                            }
                        }
                        break;
                    }
                }
                if (ANSWER == 0) {
                    ans.setImageResource(R.drawable.anszero);
                } else if (ANSWER == 1) {
                    ans.setImageResource(R.drawable.ansone);
                }
            }
        });


        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setVisibility(View.INVISIBLE);
    }

}
