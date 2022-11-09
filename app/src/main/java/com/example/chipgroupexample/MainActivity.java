package com.example.chipgroupexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.example.chipgroupexample.databinding.ActivityMainBinding;
import com.example.chipgroupexample.databinding.ChipAdapterLayoutBinding;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    ArrayList<String> list;
    ChipRecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


    }

    public void add(View view) {
        if (!binding.etText.getText().toString().isEmpty()) {

            try {
                LayoutInflater inflater = LayoutInflater.from(this);

//            Create A chip From Layout
                Chip chip = (Chip) inflater.inflate(R.layout.chip_layout, this.binding.group, false);

                chip.setText(binding.etText.getText().toString());

//add Chip view to Chip Group
                this.binding.group.addView(chip);

                chip.setOnCloseIconClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        cloceIconClicked(view);
                    }
                });



                binding.etText.setText("");
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {
            Toast.makeText(MainActivity.this, " PLease Enter Somthing ", Toast.LENGTH_SHORT).show();
        }
    }

    public void showAllItems(View v){

        list=new ArrayList<>();
        int count=binding.group.getChildCount();

        for (int i=0;i<count;i++){
            Chip child= (Chip) binding.group.getChildAt(i);
            if (child.isChecked()){
                list.add(child.getText().toString());

            }
        }

        adapter=new ChipRecyclerAdapter(MainActivity.this,list);
        binding.recycler.setAdapter(adapter);

    }

    private void cloceIconClicked(View view) {
        ChipGroup parent= (ChipGroup) view.getParent();
        parent.removeView(view);

    }
}