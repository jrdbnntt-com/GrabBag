package com.jrdbnntt.cop4656.grabbag;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import java.util.Random;
import java.lang.StringBuilder;

public class CreateGroupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_group);
    }

    public void clickCreateGroup(View view)
    {
        Bundle bundle = new Bundle();
        Intent intent = new Intent(this, GroupScreenActivity.class);
        String genID = generateID();
        bundle.putString("ID", genID);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public String generateID()
    {
        StringBuilder temp = new StringBuilder();
        String alphabet = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        final int nums = alphabet.length();
        Random rand = new Random();
        for(int i = 0; i < 10; i++)
        {
            temp.append(alphabet.charAt(rand.nextInt(nums)));
        }
        String generatedID = temp.toString();

        return generatedID;
    }
}
