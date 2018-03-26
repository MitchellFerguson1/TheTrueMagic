package com.example.mitchell.newprojectthree;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import org.w3c.dom.Text;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {
    private char[] alphabet = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
                                    'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S',
                                    'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    private int[] alphabetNumbers = {23, 14, 19, 7, 10, 5, 26, 1, 16, 3, 22, 8,
                                        15, 21, 12, 6, 2, 13, 20, 11, 25, 4, 9,
                                        24, 18, 17};
    private ArrayList<String> nounsOne = new ArrayList<>();
    private ArrayList<String> nounsTwo = new ArrayList<>();
    private ArrayList<String> verbs = new ArrayList<>();
    private ArrayList<String> adjectives = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Ad stuff
        MobileAds.initialize(this, "ca-app-pub-5506113922585843~5706663344");
        AdView mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        try {
            initializer();
        } catch (IOException ignored) {

        }

    }

    private void initializer() throws IOException {
        //NounsOne
        Scanner s = new Scanner(new DataInputStream(getAssets().open("Noun1")));
        while(s.hasNextLine())
            nounsOne.add(s.nextLine());
        s.close();

        //NounsTwo
        s = new Scanner(new DataInputStream(getAssets().open("Noun2")));
        while(s.hasNextLine())
            nounsTwo.add(s.nextLine());
        s.close();

        //verbs
        s = new Scanner(new DataInputStream(getAssets().open("Verbs")));
        while(s.hasNextLine())
            verbs.add(s.nextLine());
        s.close();

        //adjectives
        s = new Scanner(new DataInputStream(getAssets().open("Adjectives")));
        while(s.hasNextLine())
            adjectives.add(s.nextLine());
        s.close();
    }

    public void buttonClickTest(View v){
        EditText nameText = findViewById(R.id.nameInput); //Make the user input a variable
        int nameAsNumber = nameTotalNumber(nameText.getText().toString()); //Grab the user input, convert it to a string, and convert it to a number

        //Logic to find the other numbers here.
        //Logic made by Logan, implemented by Mitchell
        String nounOneString = nounsOne.get(nounNumberCalculatorFirst(nameAsNumber));
        String nounTwoString = nounsTwo.get(nounNumberCalculatorSecond(nameAsNumber));
        String verbString = verbs.get(verbNumberCalculator(nameAsNumber));
        String adjectiveString = adjectives.get(adjectiveNumberCalculations(nameAsNumber));

        // Reads the files and initializes the strings depending on which line the words are at in their text files
        TextView displayThoseThings = findViewById(R.id.nounNumberDisplay);
        displayThoseThings.setText(String.format("%s %s %s %s", adjectiveString, nounOneString, verbString, nounTwoString));

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
        int hold = -1;
        switch (nameValueString.length()){
            case 1:
                hold = nameValue + nameValue;
                break;
            case 2:
                hold = nameValue / 2;
                break;
            case 3:
                hold = nameValue / 54;
                break;
        }
        return hold;
    }

    private int verbNumberCalculator(int nameValue){
        String nameValueString = Integer.toString(nameValue);
        int hold = -1;
        switch (nameValueString.length()){
            case 1:
                hold = nameValue * nameValue + nameValue;
                break;
            case 2:
                hold = nameValue - 1;
                break;
            case 3:
                hold = nameValue / 23;
                break;
        }
        return hold;
    }

    private int nounNumberCalculatorFirst(int nameValue){
        String nameValueString = Integer.toString(nameValue);
        int hold;
        switch (nameValueString.length()){
            case 1:
                hold = nameValue * 200;
                break;
            case 2:
                hold = nameValue * 19;
                break;
            case 3:
                hold = nameValue * 2;
                break;
            default:
                hold = -1;
                break;
        }
        return hold;
    }

    private int nounNumberCalculatorSecond(int nameValue){
        String nameValueString = Integer.toString(nameValue);
        int hold = -1;
        switch (nameValueString.length()){
            case 1:
                hold = nameValue * 201;
                break;
            case 2:
                hold = nameValue * 26;
                break;
            case 3:
                hold = nameValue * 3;
                break;
        }
        return hold;
    }
}