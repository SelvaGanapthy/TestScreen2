package com.example.admin.testscreen2;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    RelativeLayout include1, include2, include3, include4;
    EditText new_lead_Name, new_lead_phoneno, new_lead_Email, new_lead_Projects, date;
    String phoneValid = "[987]";
    Pattern pattern_Email = Pattern.compile("^.+@.+\\..+$");
    ImageView newLead_feedbackReg_buttonNxt, newLead_conversDetail_bNxt, emoji_happy, emoji_very_happy, emoji_sad;

    DatePickerDialog datePickerDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
        newLead_feedbackReg_buttonNxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                newLead_Validate();
            }
        });
        newLead_conversDetail_bNxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                include1.setVisibility(View.GONE);
                include2.setVisibility(View.GONE);
                include3.setVisibility(View.VISIBLE);
                include4.setVisibility(View.GONE);
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
        newLead_feedbackReg_buttonNxt = (ImageView) findViewById(R.id.newLead_feedbackReg_buttonNxt);
        newLead_conversDetail_bNxt = (ImageView) findViewById(R.id.newLead_conversDetail_bNxt);
        include1 = (RelativeLayout) findViewById(R.id.include1);
        include2 = (RelativeLayout) findViewById(R.id.include2);
        include3 = (RelativeLayout) findViewById(R.id.include3);
        include4 = (RelativeLayout) findViewById(R.id.include4);
        emoji_happy.setImageResource(R.drawable.hover_emoji_happy);
        emoji_happy.setOnClickListener(this);
        emoji_very_happy.setOnClickListener(this);
        emoji_sad.setOnClickListener(this);
        date = (EditText) findViewById(R.id.selectDate);
        date.setOnClickListener(this);
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
            include1.setVisibility(View.GONE);
            include2.setVisibility(View.VISIBLE);
            include3.setVisibility(View.GONE);
            include4.setVisibility(View.GONE);
        }


    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.emojisad:
                emoji_sad.setImageResource(R.drawable.hover_emoji_sad);
                emoji_happy.setImageResource(R.drawable.emoji_happy);
                emoji_very_happy.setImageResource(R.drawable.emoji_veryhappy);
                break;
            case R.id.emojihappy:
                emoji_happy.setImageResource(R.drawable.hover_emoji_happy);
                emoji_sad.setImageResource(R.drawable.emoji_sad);
                emoji_very_happy.setImageResource(R.drawable.emoji_veryhappy);
                break;
            case R.id.emojiveryhappy:
                emoji_very_happy.setImageResource(R.drawable.hover_emoji_veryhappy);
                emoji_sad.setImageResource(R.drawable.emoji_sad);
                emoji_happy.setImageResource(R.drawable.emoji_happy);
                break;
            case R.id.selectDate:
                final Calendar c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR);
                int mMonth = c.get(Calendar.MONTH);
                int mDay = c.get(Calendar.DAY_OF_MONTH);
                datePickerDialog = new DatePickerDialog(MainActivity.this,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                // set day of month , month and year value in the edit text
                                date.setText(dayOfMonth + "/"
                                        + (monthOfYear + 1) + "/" + year);
                                include1.setVisibility(View.GONE);
                                include2.setVisibility(View.GONE);
                                include3.setVisibility(View.GONE);
                                include4.setVisibility(View.VISIBLE);

                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();

        }

    }
}
