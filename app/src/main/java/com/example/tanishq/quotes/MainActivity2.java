package com.example.tanishq.quotes;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity2 extends AppCompatActivity {

    private TextView quoteTextView;
    private Button newQuoteButton;
    private Button previousButton;
    private Button shareButton;
    private List<String> quotes;
    private Button aboutmeButton;
    private int currentQuoteIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        quoteTextView = findViewById(R.id.quote_textview);
        newQuoteButton = findViewById(R.id.new_quote_button);
        previousButton = findViewById(R.id.previous_button);
        shareButton = findViewById(R.id.share_button);
        aboutmeButton = findViewById(R.id.me);

        quotes = new ArrayList<>();
        quotes.add("Believe you can and you're halfway there. - Theodore Roosevelt");
        quotes.add("The only way to do great work is to love what you do. - Steve Jobs");
        quotes.add("Be the change that you wish to see in the world. - Mahatma Gandhi");
        quotes.add("Success is not final, failure is not fatal: It is the courage to continue that counts. - Winston Churchill");
        quotes.add("Don't watch the clock; do what it does. Keep going. - Sam Levenson");
        quotes.add("Genius is one percent inspiration and ninety-nine percent perspiration-Thomas Edison");
        quotes.add("A house divided against itself cannot stand - Abraham Lincoln");
        quotes.add("Today is the tomorrow we worried about yesterday.-");
        quotes.add("You'll see it when you believe it.-Wayne Dyer");
        quotes.add("Life is change. Growth is optional. Choose wisely.-Karen Clark");
        quotes.add("We can only learn to love by loving.-Iris Murdoch");
        quotes.add("What you give is what you get-Byron Pulsifer");
        quotes.add("Peace comes from within. Do not seek it without.-Buddha");
        quotes.add("Self-complacency is fatal to progress.-Margaret Sangster");
        quotes.add("ife is a learning experience, only if you learn-Yogi Berra");
        quotes.add("Well begun is half done-Aristotle");
        quotes.add("Nothing happens unless first we dream-Carl Sandburg");
        quotes.add("Be the chief but never the lord-Lao Tzu");
        quotes.add("Fate is in your hands and no one else-Byron Pulsifer");
        quotes.add("Difficulties increase the nearer we get to the goal-Johann Wolfgang von Goethe");

        // Add more quotes here

        currentQuoteIndex = 0;
        quoteTextView.setText(quotes.get(currentQuoteIndex));

        newQuoteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generateNewQuote();
            }
        });

        previousButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generatePreviousQuote();
            }
        });

        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareQuote();
            }
        });
        aboutmeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this,tanishq.class);
                startActivity(intent);
            }
        });

    }

    private void generateNewQuote() {
        currentQuoteIndex = (currentQuoteIndex + 1) % quotes.size();
        quoteTextView.setText(quotes.get(currentQuoteIndex));
        Toast.makeText(MainActivity2.this,"Next Quote",Toast.LENGTH_SHORT).show();
    }

    private void generatePreviousQuote() {
        currentQuoteIndex = (currentQuoteIndex - 1 + quotes.size()) % quotes.size();
        quoteTextView.setText(quotes.get(currentQuoteIndex));
        Toast.makeText(MainActivity2.this,"Previous Quote",Toast.LENGTH_SHORT).show();
    }

    private void shareQuote() {
        String quote = quotes.get(currentQuoteIndex);
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, quote);
        Toast.makeText(MainActivity2.this,"Sharing",Toast.LENGTH_SHORT).show();
        startActivity(Intent.createChooser(intent, "Share Quote"));
    }


}