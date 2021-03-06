package com.eldgammel.ww;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class AddFoodActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_food);
    }

    public void addClicked(View v) {
        EditText etName = (EditText)findViewById(R.id.etName);
        EditText etCal = (EditText)findViewById(R.id.etCal);
        EditText etAmount = (EditText)findViewById(R.id.etAmount);

        String sName = etName.getText().toString();
        String sCal = etCal.getText().toString();
        String sAmount = etAmount.getText().toString();

        if (sName.trim().length() == 0 || sCal.trim().length() == 0) {
            Toast t = Toast.makeText(this.getApplicationContext(),
                    "All fields are required to be filled.",
                    Toast.LENGTH_SHORT);
            t.show();
        }
        else {
            Intent result = new Intent();
            result.putExtra("fName", sName);
            result.putExtra("cal", Integer.valueOf(sCal));
            result.putExtra("amount", Integer.valueOf(sAmount));


            this.setResult(RESULT_OK, result);
            this.finish();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add_course, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
