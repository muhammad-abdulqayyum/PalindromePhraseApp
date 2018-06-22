package com.example.hafiz.palindromes;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }


    public boolean isAlpha(String word) {
        return word.matches("[a-zA-Z]+");
    }// ^FUNCTION TO CHECK IF STRING HAS ONLY LETTERS


    boolean check_palindrome(String sentence) {


        Stack<String> S_LefttoRight = new Stack<String>(); //stack holds letters from left to right
        Queue<String> Q_RighttoLeft = new LinkedList<String>(); //queue holds letters from right to left
        String[] words_array = sentence.split("\\s+"); //SPLITS SENTENCE INTO SEPARATE WORDS AND STORES IN words_array
        String word; //CREATED TO HOLD A SINGLE WORD


        for (int i = 0; i < words_array.length; i++) //loop until index "i" reaches end of wordS_array
        {
            word = words_array[i]; //word WILL HOLD AN ELEMENT IN words_array.


            if (isAlpha(word)) //IF word is comprised of only letters
            {
                word.toLowerCase();  //CONVERTS WORD TO LOWER CASE. THIS IS DONE FOR COMPARISONS
                // Log.e("INSERTING ...", word);
                S_LefttoRight.push(word); //PUSH WORD ONTO STACK. HOLDS LEFT TO RIGHT VERSION OF SENTENCE
                Q_RighttoLeft.offer(word); //ENQUEUE WORD ONTO QUEUE. HOLDS RIGHT TO LEFT VERSION OF SENTENCE
            }

        }//^LOOP TO READ IN WORDS TO STRING ARRAY

        while (!S_LefttoRight.empty() && !Q_RighttoLeft.isEmpty()) {
            String x, y; //TEMPORARY VARIABLES USED FOR COMPARISON
            x = S_LefttoRight.pop(); //POP Word FROM STACK
            y = Q_RighttoLeft.poll(); //Remove Word LETTER FROM QUEUE

            if (!x.equals(y)) // IF removed elements are not equal to eachother
            {
                return false; //sentence is not a palindrome
            }

        }
        return true;
    }


    public void Main(View view) {

        EditText User_Input;
        final TextView TextView2;
        final String sentence;


        User_Input = (EditText) findViewById(R.id.editText1);
        User_Input.getText().toString();
        sentence = User_Input.getText().toString(); //create string variable sentence from User_Input


        TextView2 = (TextView) findViewById(R.id.textView2);


        check_palindrome(sentence);
        if (check_palindrome(sentence) == true) {
            TextView2.setText("You sentence IS a Palindrome Phrase!!!!");
        } else {
            TextView2.setText("You sentence IS NOT a Palindrome Phrase. Try Again!");
        }

    }
}


