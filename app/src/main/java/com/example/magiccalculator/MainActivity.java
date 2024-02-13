package com.example.magiccalculator;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tv1, tv2, tv3, tv4, tv5, tv6;
    EditText et1, et2, et3;
    ImageView iv1, iv2, iv3;
    Button btn1, btn2, btn3, newBtn;
    Random rand;
    int num1, num2, num3, num4;
    TextView[] tvArr;
    EditText[] etArr;
    ImageView[] ivArr;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1 = findViewById(R.id.textView);
        tv2 = findViewById(R.id.textView6);
        tv3 = findViewById(R.id.textView3);
        tv4 = findViewById(R.id.textView2);
        tv5 = findViewById(R.id.textView4);
        tv6 = findViewById(R.id.textView5);
        et1 = findViewById(R.id.editTextNumber);
        et2 = findViewById(R.id.editTextNumber2);
        et3 = findViewById(R.id.editTextNumber3);
        iv1 = findViewById(R.id.imageView10);
        iv2 = findViewById(R.id.imageView8);
        iv3 = findViewById(R.id.imageView9);
        btn1 = findViewById(R.id.button);
        btn2 = findViewById(R.id.button2);
        btn3 = findViewById(R.id.button3);
        newBtn = findViewById(R.id.button4);
        startGame();

    }
    public void startGame(){
        rand = new Random();
        num1 = rand.nextInt((99 - 10) + 1) + 10;
        num2 = rand.nextInt((99 - 10) + 1) + 10;
        tv1.setText(String.valueOf(num1));
        tv2.setText(String.valueOf(num2));
    }
    public int checkSum(TextView t1, TextView t2, EditText userAnswer, ImageView iv){
        int n1 = Integer.parseInt((String) t1.getText());
        int n2 = Integer.parseInt((String) t2.getText());
        int sum = n1 + n2;
        int res = Integer.parseInt(userAnswer.getText().toString());
        if(sum == res)
            iv.setImageResource(R.drawable.tick1);
        else
            iv.setImageResource(R.drawable.x);
        return sum;
    }
    public void clear(TextView[] textViews){
        for(TextView tv: textViews)
            tv.setText("0");
    }
    public void clear(EditText[] editTexts){
        for(EditText et: editTexts)
            et.getText().clear();
    }
    public void clear(ImageView[] imageViews){
        for(ImageView iv: imageViews)
            iv.setImageResource(android.R.drawable.checkbox_off_background);
    }

    public void check1(View view) {
        tv3.setText(String.valueOf(checkSum(tv1, tv2, et1, iv1)));
        num3 = rand.nextInt((99 - 10) + 1) + 10;
        tv4.setText(String.valueOf(num3));
    }

    public void check2(View view) {
        tv5.setText(String.valueOf(checkSum(tv3, tv4, et2, iv2)));
        num4 = rand.nextInt((99 - 10) + 1) + 10;
        tv6.setText(String.valueOf(num4));
    }

    public void check3(View view) {
        checkSum(tv5, tv6, et3, iv3);
    }

    public void newGame(View view) {
        tvArr = new TextView[]{tv1, tv2, tv3, tv4, tv5, tv6};
        etArr = new EditText[]{et1, et2, et3};
        ivArr = new ImageView[]{iv1, iv2, iv3};
        clear(tvArr);
        clear(etArr);
        clear(ivArr);
        startGame();
    }
}