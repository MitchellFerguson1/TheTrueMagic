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
        newNameDisplay.setText(String.format(String.valueOf(nameAsNumber)));
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
}




///* If 1 digit
// Add that number (ex. 4) to itself (8)
// Take that number times itself (16)
// Take that number times itself times plus itself (20)
// Take that number times itself minus itself (12)
// Max (9) (18 + 81 + 90 + 72)
//
// If two digits
// Divide the number by 2 (ex. 20) (10)
// Divide the number by 3 (6)
// Subtract 1 from the number (19)
// Subtract 4 from the number (16)
// Max (99) (49 + 33 + 98 + 95)
//
// If three digits
// Divide the number by 54 (ex. 199) (3)
// Divide the number by 31 (6)
// Divide the number by 23 (8)
// Divide the number by 12 (16)
// Max (780) (14 + 25 + 33 + 65)
// */
//
//
//import java.util.Scanner;
//public class Testing {
//    public static void main(String[] args) {
//
//        Scanner in = new Scanner(System.in); // Scanner shit
//
//        String yourName = in.next();
//
//        int nameValue = 9; // A test for one, two, and three digit numbers (4 digits should never occur)
//
//        String nameValueString = Integer.toString(nameValue);
//
//        System.out.println(adjective(nameValueString, nameValue));
//        System.out.println(noun1(nameValueString, nameValue));
//        System.out.println(verb(nameValueString, nameValue));
//        System.out.println(noun2(nameValueString, nameValue)); // These are just to test the values and are temporary
//
//
//    }
//
//
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
//
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
//
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
//
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