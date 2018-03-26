package com.example.mitchell.newprojectthree;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private char[] alphabet = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
                                    'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S',
                                    'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    private int[] alphabetNumbers = {23, 14, 19, 7, 10, 5, 26, 1, 16, 3, 22, 8,
                                        15, 21, 12, 6, 2, 13, 20, 11, 25, 4, 9,
                                        24, 18, 17};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void buttonClickTest(View v){
        TextView newNameDisplay = findViewById(R.id.newNameDisplay); //Make the new name display a usable variable
        EditText nameText = findViewById(R.id.nameInput); //Make the user input a variable
        int nameAsNumber = nameTotalNumber(nameText.getText().toString()); //Grab the user input, convert it to a string, and convert it to a number
        newNameDisplay.setText(String.valueOf(nameAsNumber)); //Display the number

        //Logic to find the other numbers here.
        //Logic made by Logan, implemented by Mitchell
    }

    private int nameTotalNumber(String name){
        int finalNum = 0;
        for(char letter : name.toUpperCase().toCharArray()){ //Create a for each loop to find the proper letter
            for(int i = 0; i < alphabet.length - 1; i++){
                if (alphabet[i] == letter) { //Make sure the letters match
                    finalNum += alphabetNumbers[i]; //Use that index to get a number from alphabetNumbers and add it to final num
                    break;
                }
            }
        }
        return finalNum; //Return finalNum
    }

    //Logic for conversions
    private int adjectiveNumberCalculations(int nameValue){
        String nameValueString = Integer.toString(nameValue);
        switch (nameValueString.length()){
            case 1:
                return nameValue + nameValue;
            case 2:
                return nameValue / 2;
            case 3:
                return nameValue / 54;
            default:
                return -1;
        }
    }

    //    public static int adjective(String nameValueString, int nameValue) {
//        if (nameValueString.length() == 1) {
//            int Value = nameValue + nameValue;
//            return Value;
//        } if (nameValueString.length() == 2) {
//            int Value = nameValue / 2;
//            return Value;
//        } if (nameValueString.length() == 3) {
//            int Value = nameValue / 54;
//            return Value;
//        } else {
//            System.out.print("you goofed up you bafoon");
//            return 0;
//        }
//    }

    private int verbNumberCalculator(int nameValue){
        String nameValueString = Integer.toString(nameValue);
        switch (nameValueString.length()){
            case 1:
                return nameValue * nameValue + nameValue;
            case 2:
                return nameValue - 1;
            case 3:
                return nameValue / 23;
            default:
                return -1;
        }
    }

    //    public static int verb(String nameValueString, int nameValue) {
//        if (nameValueString.length() == 1) {
//            int Value = nameValue * nameValue + nameValue;
//            return Value;
//        } if (nameValueString.length() == 2) {
//            int Value = nameValue - 1;
//            return Value;
//        } if (nameValueString.length() == 3) {
//            int Value = nameValue / 23;
//            return Value;
//        } else {
//            System.out.print("you goofed up you bafoon");
//            return 0;
//        }
//    }

    private int nounNumberCalculator(int nameValue)
}



//    public static int noun1(String nameValueString, int nameValue) {
//        if (nameValueString.length() == 1) {
//            int Value = nameValue * 200;
//            return Value;
//        } if (nameValueString.length() == 2) {
//            int Value = nameValue * 19;
//            return Value;
//        } if (nameValueString.length() == 3) {
//            int Value = nameValue * 2;
//            return Value;
//        } else {
//            System.out.print("you goofed up you bafoon");
//            return 0;
//        }
//    }

//    public static int noun2(String nameValueString, int nameValue) {
//        if (nameValueString.length() == 1) {
//            int Value = nameValue * 200;
//            return Value;
//        } if (nameValueString.length() == 2) {
//            int Value = nameValue * 26;
//            return Value;
//        } if (nameValueString.length() == 3) {
//            int Value = nameValue * 3;
//            return Value;
//        } else {
//            System.out.print("you goofed up you bafoon");
//            return 0;
//        }
//    }
//
//}