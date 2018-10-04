package edu.fullerton.ecs.cpsc411.miniapp1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class FileTransferSpeed extends AppCompatActivity {

    EditText sizeEdit;
    EditText speedEdit;
    TextView transferTimeView;
    Double transferTime = 0.0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_transfer_speed);

        transferTimeView = findViewById(R.id.transferSpeedValue);
        sizeEdit = findViewById(R.id.fileValue);
        speedEdit = findViewById(R.id.speedValue);

        sizeEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                transferTime = calcTransferSpeed();
                // souece http://www.java67.com/2014/06/how-to-format-float-or-double-number-java-example.html
                DecimalFormat oneDecPlace = new DecimalFormat("#.#");
                String formatted = oneDecPlace.format(transferTime);
                transferTimeView.setText(formatted);
            }
        });

        speedEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                transferTime = calcTransferSpeed();
                // source: http://www.java67.com/2014/06/how-to-format-float-or-double-number-java-example.html
                DecimalFormat oneDecPlace = new DecimalFormat("#.#");
                String formatted = oneDecPlace.format(transferTime);
                transferTimeView.setText(formatted);
            }
        });


    }


    public Double calcTransferSpeed() {
        String sizeString = String.valueOf(sizeEdit.getText());
        String speedString = String.valueOf(speedEdit.getText());

        if ((speedString.trim().length() <= 0) || (sizeString.trim().length() <= 0) ||
                (speedString.equals(".")) || sizeString.equals(".")) {
            return 0.0;
        }
        else {

            Double sizeDouble = Double.valueOf(sizeString);
            Double speedDouble = Double.valueOf(speedString);

            // Size in bits
            sizeDouble = (sizeDouble * Math.pow(2, 20) * 8);

            // Speed in bits per sec
            speedDouble = (speedDouble * Math.pow(10, 6));


            return sizeDouble / speedDouble;
        }
    }
}
