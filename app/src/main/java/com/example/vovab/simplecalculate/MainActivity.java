package com.example.vovab.simplecalculate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button SUM, DELENTE, MULTI, BINARY, MOD, XOR, RESULT, MIN , C;
    EditText ED1, ED2;
    TextView tv, fieldview;
    String ACT;
    int middle ;
    String result;
    String binary = null;
    String strCatName="";
    String strCatName2="";
    String TextViewField = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SUM = (Button) findViewById(R.id.Sum);
        DELENTE = (Button) findViewById(R.id.del);
        MULTI = (Button) findViewById(R.id.multi);
        MIN = (Button) findViewById(R.id.min);
        RESULT = (Button) findViewById(R.id.result);
        BINARY = (Button) findViewById(R.id.binary);
        MOD = (Button) findViewById(R.id.mod);
        XOR = (Button) findViewById(R.id.xor);
        C = (Button) findViewById(R.id.cbutton);
        ED1 = (EditText) findViewById(R.id.editText6);
        ED2 = (EditText) findViewById(R.id.editText7);
        tv = (TextView) findViewById(R.id.textView666);
        fieldview = (TextView) findViewById(R.id.textView2);
        View.OnKeyListener MyClick = new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if(keyEvent.getAction() == KeyEvent.ACTION_DOWN &&
                        (i == KeyEvent.KEYCODE_ENTER))
                {

                    strCatName = ED1.getText().toString();
                    TextViewField +=strCatName;
                    fieldview.setText(TextViewField);
                    return true;
                }
                return false;

            }
        };
        View.OnKeyListener MyClick2 = new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if(keyEvent.getAction() == KeyEvent.ACTION_DOWN &&
                        (i == KeyEvent.KEYCODE_ENTER))
                {

                    strCatName2 = ED2.getText().toString();
                    TextViewField +=strCatName2;
                    fieldview.setText(TextViewField);
                    return true;
                }
                return false;

            }
        };
        ED1.setOnKeyListener(MyClick);
        ED2.setOnKeyListener(MyClick2);
        SUM.setOnClickListener(this);
        DELENTE.setOnClickListener(this);
        MULTI.setOnClickListener(this);
        MIN.setOnClickListener(this);
        RESULT.setOnClickListener(this);
        BINARY.setOnClickListener(this);
        MOD.setOnClickListener(this);
        XOR.setOnClickListener(this);
        C.setOnClickListener(this);
    }
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.Sum:
            {
                    TextViewField += "+";
                    fieldview.setText(TextViewField);
                    ACT = "+";
            }
            break;
            case  R.id.min:
            {
                    TextViewField+="-";
                    fieldview.setText(TextViewField);
                    ACT = "-";

            }
            break;
            case R.id.multi:
            {

                    TextViewField+="*";
                    fieldview.setText(TextViewField);
                    ACT = "*";
            }
            break;
            case R.id.del: {
                    TextViewField += "/";
                    fieldview.setText(TextViewField);
                     ACT = "/";

            }
            break;
            case R.id.binary:
            {
                binary = Integer.toBinaryString(Integer.parseInt(ED1.getText().toString()));

            }
            break;
            case R.id.mod: {
                    TextViewField+="mod";
                    fieldview.setText(TextViewField);
                    ACT = "%";
            }
            break;
            case R.id.xor:
            {
                    TextViewField+="xor";
                    fieldview.setText(TextViewField);
                    ACT = "^";
            }
            break;
            case R.id.cbutton:
            {
                TextViewField="";
                fieldview.setText("");
                binary = null;
            }
            break;
            case  R.id.result:
            {
                if(ACT == "+")
                {
                    middle =Integer.parseInt(strCatName) + Integer.parseInt(strCatName2);
                }
                if(ACT == "-")
                {
                    middle =Integer.parseInt(strCatName) - Integer.parseInt(strCatName2);
                }
                if(ACT=="*")
                {
                    middle =Integer.parseInt(strCatName) * Integer.parseInt(strCatName2);
                }
                if (ACT == "/")
                {
                    middle =Integer.parseInt(strCatName) / Integer.parseInt(strCatName2);
                }
                if(ACT=="%")
                {
                    middle =Integer.parseInt(strCatName) % Integer.parseInt(strCatName2);
                }
                if(ACT=="^") {
                    middle = Integer.parseInt(strCatName) ^ Integer.parseInt(strCatName2);
                }
                    tv.setText(Integer.toString(middle));
                if(binary!=null)
                {
                    tv.setText(binary);

                }

            }
            break;
        }
    }

}