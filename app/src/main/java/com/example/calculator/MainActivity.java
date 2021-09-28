package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.media.VolumeShaper;
import android.os.Bundle;
import android.widget.Toast;

import com.example.calculator.databinding.ActivityMainBinding;

import java.text.DecimalFormat;


public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.buttonEnter.setOnClickListener(v -> calculate());

        binding.buttonAdd.setOnClickListener(v ->{
            binding.operator.setText("+");
        });
        binding.buttonSubtract.setOnClickListener(v ->{
            binding.operator.setText("-");
        });
        binding.buttonMultiply.setOnClickListener(v ->{
            binding.operator.setText("*");
        });
        binding.buttonDivide.setOnClickListener(v ->{
            binding.operator.setText("/");
        });
    }

    private void calculate() {
        String leftValue = binding.editLeft.getText().toString();
        String rightValue = binding.editLeft.getText().toString();

        if (leftValue.isEmpty() || rightValue.isEmpty()) {
            Toast.makeText(this, "숫자를 입력해주세요", Toast.LENGTH_SHORT).show();
            return;
        }

        float left = Float.parseFloat(leftValue);
        float right = Float.parseFloat(rightValue);

        float result = 0;

        if (binding.operator.getText() == "+"){
            result=left+right;
        }else if (binding.operator.getText() == "-"){
            result=left-right;
        }else if (binding.operator.getText() == "*"){
            result=left*right;
        }else if (binding.operator.getText() == "/"){
            if (right==0){
                binding.last.setText("error");
                return;
            }
            result=left/right;
        }

        /*
        switch (selectedOp) {
            case ADD:
                result = left + right;
                break;
            case SUBTRACT:
                result = left - right;
            case MULTIPLY:
                result = left * right;
            case DIVIDE:
                if (right == 0) {
                    binding.result.setText("error");
                    return;
                }
                result = left / right;
                break;
        } */


        DecimalFormat formatter = new DecimalFormat("#.##");
        binding.last.setText(formatter.format(result));
        ;
    }
}