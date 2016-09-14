package org.intermountainhealthcare.mycalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText number1;
    private EditText number2;

    private Button plusBtn;
    private  Button minusBtn;
    private Button multiBtn;
    private Button divideBtn;
    private Button clearBtn;

    private TextView resultHolder;

    public enum Operation {
        ADD, SUBSTRACT, MULTIPLY, DIVISION

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        number1 = (EditText) findViewById(R.id.number1);
        number2 = (EditText) findViewById(R.id.number2);

        plusBtn = (Button) findViewById(R.id.addBtn);
        minusBtn = (Button) findViewById(R.id.minusBtn);
        multiBtn = (Button) findViewById(R.id.multiBtn);
        divideBtn = (Button) findViewById(R.id.divideBtn);
        clearBtn = (Button) findViewById(R.id.clearBtn);

        resultHolder = (TextView) findViewById(R.id.resultHolder);


        plusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultHolder.setText(doOperateByValue(Operation.ADD));
            }
        });
        minusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultHolder.setText(doOperateByValue(Operation.SUBSTRACT));
            }
        });
        multiBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultHolder.setText(doOperateByValue(Operation.MULTIPLY));
            }
        });
        divideBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultHolder.setText(doOperateByValue(Operation.DIVISION));
            }
        });

        clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number1.setText("");
                number2.setText("");
                resultHolder.setText("0.00");
                number1.requestFocus();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    private String doOperateByValue(Operation operation) {
        Double returnResult = 0.0;
        if(number1.getText().length()>0 && number2.getText().length()> 0) {
            switch (operation) {
                case ADD:
                    returnResult =  Double.parseDouble(number1.getText().toString())+Double.parseDouble(number2.getText().toString());
                    break;
                case SUBSTRACT:
                    returnResult =  Double.parseDouble(number1.getText().toString())-Double.parseDouble(number2.getText().toString());
                    break;
                case MULTIPLY:
                    returnResult =  Double.parseDouble(number1.getText().toString())*Double.parseDouble(number2.getText().toString());
                    break;
                case DIVISION:
                    returnResult =  Double.parseDouble(number1.getText().toString())/Double.parseDouble(number2.getText().toString());
                    break;
            }
        }else {
            Toast.makeText(this, "Please enter numbers in both fields", Toast.LENGTH_LONG).show();
        }
        return returnResult.toString();
    }
}
