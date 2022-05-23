package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button buttonone;
    Button buttontwo;
    Button buttonthree;
    Button buttonfour;
    Button buttonfive;
    Button buttonsix;
    Button buttonseven;
    Button buttoneight;
    Button buttonzero;
    Button buttonnine;
    Button buttondivide;
    Button buttonmultiply;
    Button buttonaddition;
    Button buttonsubtraction;
    Button buttonequals;
    Button buttonclear;
    TextView textscreen;
    double tempmath;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonone =findViewById(R.id.one);
        buttontwo = findViewById(R.id.two);
        buttonthree = findViewById(R.id.three);
        buttonfour =findViewById(R.id.four);
        buttonfive = findViewById(R.id.five);
        buttonsix = findViewById(R.id.six);
        buttonseven =findViewById(R.id.seven);
        buttoneight = findViewById(R.id.eight);
        buttonnine = findViewById(R.id.nine);
        buttondivide =findViewById(R.id.divide);
        buttonmultiply = findViewById(R.id.multiplication);
        buttonsubtraction = findViewById(R.id.minus);
        buttonaddition = findViewById(R.id.plus);
        buttonclear = findViewById(R.id.clear);
        buttonzero = findViewById(R.id.zero);
        buttonequals = findViewById(R.id.equals);
        textscreen = findViewById(R.id.numberview);
        buttonone.setOnClickListener(this);
        buttontwo.setOnClickListener(this);
        buttonthree.setOnClickListener(this);
        buttonfour.setOnClickListener(this);
        buttonfive.setOnClickListener(this);
        buttonsix.setOnClickListener(this);
        buttonseven.setOnClickListener(this);
        buttoneight.setOnClickListener(this);
        buttonnine.setOnClickListener(this);
        buttonzero.setOnClickListener(this);
        buttonmultiply.setOnClickListener(this);
        buttondivide.setOnClickListener(this);
        buttonsubtraction.setOnClickListener(this);
        buttonaddition.setOnClickListener(this);
        buttonclear.setOnClickListener(this);
        buttonequals.setOnClickListener(this);



    }


    @Override
    public void onClick(View view)
    {
        double one=0;
        double two=0;
        switch(view.getId()){
            case R.id.one:
                if(textscreen.getText().toString().equalsIgnoreCase("Error"))
                    textscreen.setText("1");
                else
                    textscreen.append("1");
                break;
            case R.id.two:
                if(textscreen.getText().toString().equalsIgnoreCase("Error"))
                    textscreen.setText("2");
                else
                    textscreen.append("2");
                break;
            case R.id.three:
                if(textscreen.getText().toString().equalsIgnoreCase("Error"))
                    textscreen.setText("3");
                else
                    textscreen.append("3");
                break;
            case R.id.four:
                if(textscreen.getText().toString().equalsIgnoreCase("Error"))
                    textscreen.setText("4");
                else
                    textscreen.append("4");
                break;
            case R.id.five:
                if(textscreen.getText().toString().equalsIgnoreCase("Error"))
                    textscreen.setText("5");
                else
                    textscreen.append("5");
                break;
            case R.id.six:
                if(textscreen.getText().toString().equalsIgnoreCase("Error"))
                    textscreen.setText("6");
                else
                    textscreen.append("6");
                break;
            case R.id.seven:
                if(textscreen.getText().toString().equalsIgnoreCase("Error"))
                    textscreen.setText("7");
                else
                    textscreen.append("7");
                break;
            case R.id.eight:
                if(textscreen.getText().toString().equalsIgnoreCase("Error"))
                    textscreen.setText("8");
                else
                    textscreen.append("8");
                break;
            case R.id.nine:
                if(textscreen.getText().toString().equalsIgnoreCase("Error"))
                    textscreen.setText("9");
                else
                    textscreen.append("9");
                break;
            case R.id.zero:
                if(textscreen.getText().toString().equalsIgnoreCase("Error"))
                    textscreen.setText("0");
                else
                    textscreen.append("0");
                break;
            case R.id.divide:
                if(textscreen.getText().toString().equals("Error"))
                    textscreen.setText("/");
                else
                    textscreen.append("/");
                break;
            case R.id.multiplication:
                if(textscreen.getText().toString().equals("Error"))
                    textscreen.setText("*");
                else
                    textscreen.append("*");
                break;
            case R.id.minus:
                if(textscreen.getText().toString().equals("Error"))
                    textscreen.setText("-");
                else
                    textscreen.append("-");
                break;
            case R.id.plus:
                if(textscreen.getText().toString().equals("Error"))
                    textscreen.setText("+");
                else
                    textscreen.append("+");
                break;
            case R.id.clear:
                textscreen.setText("");
                break;
            case R.id.equals:
                StringTokenizer basictoken = new StringTokenizer(textscreen.getText().toString(),"*/+-",true);
                StringTokenizer operatortoken = new StringTokenizer(textscreen.getText().toString(),"*/+-",false);
                ArrayList<String> myArray = new ArrayList<>();
                int indexofadd;
                int indexofsub;
                int indexofmulti;
                int indexofdiv;
                while(basictoken.hasMoreTokens())
                {
                    myArray.add(basictoken.nextToken());
                }
                //negative helper
                if (myArray.get(0).equals("-")) {
                    myArray.set(1, myArray.get(0)+myArray.get(1));
                    myArray.remove(0);
                }
                for(int i=0;i<operatortoken.countTokens()-1;i++)
                {
                     indexofadd=myArray.indexOf("+");
                     indexofsub=myArray.indexOf("-");
                     indexofmulti=myArray.indexOf("*");
                     indexofdiv=myArray.indexOf("/");


                    if(indexofmulti!=-1)
                    {
                        try {
                            one = Double.parseDouble(myArray.get(indexofmulti-1));
                            two = Double.parseDouble(myArray.get(indexofmulti+1));
                            tempmath = one*two;
                            myArray.set(indexofmulti, Double.toString(tempmath));
                            myArray.remove(indexofmulti+1);
                            myArray.remove(indexofmulti-1);
                            tempmath =0;
                        }catch(Exception e) {
                            textscreen.setText("Error");
                        }
                    }

                    else if(myArray.indexOf("/")!=-1)
                    {

                        try {
                            one = Double.parseDouble(myArray.get(indexofdiv-1));
                            two = Double.parseDouble(myArray.get(indexofdiv+1));
                            tempmath = one/two;
                            myArray.set(indexofdiv, Double.toString(tempmath));
                            myArray.remove(indexofdiv+1);
                            myArray.remove(indexofdiv-1);
                            tempmath =0;
                        }catch(Exception e) {
                            textscreen.setText("Error");
                        }
                    }




                    else if(myArray.indexOf("+")!=-1||myArray.indexOf("-")!=-1)
                    {
                        if(myArray.indexOf("+")>(myArray.indexOf("-")) && myArray.indexOf("-")!=-1|| myArray.indexOf("+")==-1 && myArray.indexOf("-")!=-1) {
                            try {
                                one = Double.parseDouble(myArray.get(indexofsub-1));
                                two = Double.parseDouble(myArray.get(indexofsub+1));
                                tempmath = one-two;
                                myArray.set(indexofsub, Double.toString(tempmath));
                                myArray.remove(indexofsub+1);
                                myArray.remove(indexofsub-1);
                                tempmath =0;
                            }catch(Exception e) {
                                textscreen.setText("Error");
                            }

                        }
                        else if(myArray.indexOf("-")> myArray.indexOf("+") && myArray.indexOf("+")!=-1|| myArray.indexOf("-")==-1 && myArray.indexOf("+")!=-1) {
                            try {
                                one = Double.parseDouble(myArray.get(indexofadd-1));
                                two = Double.parseDouble(myArray.get(indexofadd+1));
                                tempmath = one+two;
                                myArray.set(indexofadd, Double.toString(tempmath));
                                myArray.remove(indexofadd+1);
                                myArray.remove(indexofadd-1);
                                tempmath =0;
                            }catch(Exception e) {
                                textscreen.setText("Error");
                            }
                        }
                    }

                }
                if(myArray.size() == 1  && !myArray.get(0).equalsIgnoreCase("Infinity") && !myArray.get(0).equalsIgnoreCase("NaN") && !myArray.get(0).equalsIgnoreCase("-Infinity") && !textscreen.getText().toString().equals("Error")) {
                    textscreen.setText(myArray.get(0));
                }
                else {
                    textscreen.setText("Error");
                }
                break;


        }

    }



}






