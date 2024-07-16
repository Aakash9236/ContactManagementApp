package com.example.contactmgmtsystem;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        RecyclerView recyclerView=findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ArrayList<ContactList> arrContent = new ArrayList<>();
        arrContent.add(new ContactList(R.drawable.professor , "Aakash Gupta" ,"9236556807"));
        arrContent.add(new ContactList(R.drawable.angry , "Ritika Darling " ,"9554929098"));
        arrContent.add(new ContactList(R.drawable.girl , "Miss. Smith " ,"9236556807"));
        arrContent.add(new ContactList(R.drawable.men ,   "Jhon " ,"9236556807"));
        arrContent.add(new ContactList(R.drawable.professor , "prof. Albert " ,"9236556807"));
        arrContent.add(new ContactList(R.drawable.men2 , "Mr. Gupta " ,"9236556807"));
        arrContent.add(new ContactList(R.drawable.doctor , "shally" ,"9236556807"));
        arrContent.add(new ContactList(R.drawable.angry , "Alica " ,"9236556807"));
        arrContent.add(new ContactList(R.drawable.girl , "Miss. Smith " ,"9236556807"));
        arrContent.add(new ContactList(R.drawable.men ,   "Jhon " ,"9236556807"));
        arrContent.add(new ContactList(R.drawable.professor , "prof. Albert " ,"9236556807"));
        arrContent.add(new ContactList(R.drawable.men2 , "Mr. Gupta " ,"9236556807"));
        arrContent.add(new ContactList(R.drawable.professor , "Aakash Gupta" ,"9236556807"));
        arrContent.add(new ContactList(R.drawable.angry , "Alica " ,"9236556807"));
        arrContent.add(new ContactList(R.drawable.girl , "Miss. Smith " ,"9236556807"));
        arrContent.add(new ContactList(R.drawable.men ,   "Jhon " ,"9236556807"));
        arrContent.add(new ContactList(R.drawable.professor , "prof. Albert " ,"9236556807"));
        arrContent.add(new ContactList(R.drawable.men2 , "Mr. Gupta " ,"9236556807"));
        arrContent.add(new ContactList(R.drawable.professor , "Aakash Gupta" ,"9236556807"));
        arrContent.add(new ContactList(R.drawable.angry , "Alica " ,"9236556807"));
        arrContent.add(new ContactList(R.drawable.girl , "Miss. Smith " ,"9236556807"));
        arrContent.add(new ContactList(R.drawable.men ,   "Jhon " ,"9236556807"));
        arrContent.add(new ContactList(R.drawable.professor , "prof. Albert " ,"9236556807"));
        arrContent.add(new ContactList(R.drawable.men2 , "Mr. Gupta " ,"9236556807"));
        arrContent.add(new ContactList(R.drawable.doctor , "Shailly" ,"9236556807"));
        arrContent.add(new ContactList(R.drawable.angry , "Alica " ,"9236556807"));
        arrContent.add(new ContactList(R.drawable.girl , "Miss. Smith " ,"9236556807"));
        arrContent.add(new ContactList(R.drawable.men ,   "Jhon " ,"9236556807"));
        arrContent.add(new ContactList(R.drawable.professor , "prof. Albert " ,"9236556807"));
        arrContent.add(new ContactList(R.drawable.men2 , "Mr. Gupta " ,"9236556807"));

        RecycleContactAdapter adapter = new RecycleContactAdapter(this , arrContent);
        recyclerView.setAdapter(adapter);
        FloatingActionButton floatingBtn = findViewById(R.id.floatingBtn);
        floatingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.update_conntact);
                EditText edtName = dialog.findViewById(R.id.name);
                EditText edtNumber = dialog.findViewById(R.id.number);
                Button btnSave = dialog.findViewById(R.id.btnSave);
                btnSave.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String name="",number="";
                        if(!edtName.getText().toString().equals("")) {
                            name = edtName.getText().toString();
                        }
                        else{
                            Toast.makeText(MainActivity.this, "Please Enter Contact Name", Toast.LENGTH_SHORT).show();
                        }
                        if(!edtNumber.getText().toString().equals("")) {
                            number = edtNumber.getText().toString();
                        }
                        else{
                            Toast.makeText(MainActivity.this, "Please Enter Contact Number", Toast.LENGTH_SHORT).show();
                        }
                        arrContent.add(new ContactList(R.drawable.doctor ,name , number));
                        adapter.notifyItemInserted(arrContent.size()-1);
                        recyclerView.scrollToPosition(arrContent.size()-1);
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });
    }
}