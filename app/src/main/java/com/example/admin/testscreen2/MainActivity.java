package com.example.admin.testscreen2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    EditText new_lead_Name, new_lead_phoneno, new_lead_Email, new_lead_Projects;
    String phoneValid = "[987]";
    Pattern pattern_Email = Pattern.compile("^.+@.+\\..+$");
    ImageView newLead_buttonNxt, emoji_happy, emoji_very_happy, emoji_sad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
        newLead_buttonNxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                newLead_Validate();
            }
        });
        emoji_happy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                emoji_happy.setImageResource(R.drawable.hover_emoji_happy);
            }
        });
        emoji_very_happy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                emoji_very_happy.setImageResource(R.drawable.hover_emoji_veryhappy);
            }
        });
        emoji_sad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                emoji_sad.setImageResource(R.drawable.hover_emoji_sad);
            }
        });
    }

    private void initialize() {
        new_lead_Name = (EditText) findViewById(R.id.new_lead_Name);
        new_lead_phoneno = (EditText) findViewById(R.id.new_lead_phoneno);
        new_lead_Email = (EditText) findViewById(R.id.new_lead_Email);
        new_lead_Projects = (EditText) findViewById(R.id.new_lead_Projects);
        emoji_happy = (ImageView) findViewById(R.id.emojihappy);
        emoji_sad = (ImageView) findViewById(R.id.emojisad);
        emoji_very_happy = (ImageView) findViewById(R.id.emojiveryhappy);
        newLead_buttonNxt = (ImageView) findViewById(R.id.newLead_buttonNxt);
    }

    private void newLead_Validate() {
        String phoneno = new_lead_phoneno.getText().toString();
        Matcher matcher_Email = pattern_Email.matcher(new_lead_Email.getText().toString());
        boolean f1, f2, f3, f4;
        f1 = f2 = f3 = f4 = true;
        if (new_lead_Name.length() == 0 || new_lead_Name.length() >= 15) {
            new_lead_Name.setError("Enter the name less than 15 char");
            f1 = false;
        }

        if (new_lead_phoneno.length() == 0 || new_lead_phoneno.length() != 10 || (!String.valueOf(phoneno.charAt(0)).matches(phoneValid))) {
            new_lead_phoneno.setError(" Enter the valid 10 digit mob.no");
            f2 = false;
        }
        if (new_lead_Email.length() == 0 || (!matcher_Email.matches())) {
            new_lead_Email.setError(" Enter the valid Email-id");
            f3 = false;
        }
        if (new_lead_Projects.length() == 0) {
            new_lead_Projects.setError("Enter the Projects");
            f4 = false;
        }
        if (f1 && f2 && f3 && f4) {
            Toast.makeText(getApplicationContext(), "correct", Toast.LENGTH_SHORT).show();
        }


    }


}