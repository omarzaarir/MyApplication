package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    FloatingActionButton floatingActionButton;
    BottomSheetDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        dialog=new BottomSheetDialog(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<itemClass> listItems=new ArrayList<itemClass>();
        listItems.add(new itemClass("omar","basem ahmad ",false));
        listItems.add(new itemClass("mohammad","basem ahmad qasem zaarir",true));
        listItems.add(new itemClass("sohaib","basem ahmad zaarir",false));
        listItems.add(new itemClass("bilal","basem  zaarir",true));
        listItems.add(new itemClass("islam"," ahmad zaarir",false));
        MyCustomAdabter myCustomAdabter=new MyCustomAdabter(listItems);
        ListView listView=(ListView) findViewById(R.id.mylist);
        listView.setAdapter(myCustomAdabter);
        floatingActionButton=findViewById(R.id.add_toList);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
dialog.show();

            }
        });
        View view1=getLayoutInflater().inflate(R.layout.bottom_dialog,null);
        Button addnew=view1.findViewById(R.id.addnew);
        EditText name=view1.findViewById(R.id.name);
        EditText desc=view1.findViewById(R.id.desc);
        Switch aSwitch=view1.findViewById(R.id.isdone);
        addnew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listItems.add(new itemClass(name.getText()+"",desc.getText()+"",aSwitch.isActivated()));
                myCustomAdabter.notifyDataSetChanged();
                dialog.dismiss();
            }
        });
        dialog.setContentView(view1);

    }

    class MyCustomAdabter extends BaseAdapter {
        ArrayList<itemClass> listItems=new ArrayList<itemClass>();
        MyCustomAdabter( ArrayList<itemClass> listItems){
            this.listItems=listItems;
        }

        @Override
        public int getCount() {
            return listItems.size();
        }

        @Override
        public Object getItem(int position) {
            return listItems.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater=getLayoutInflater();
            View view1=inflater.inflate(R.layout.activity_item,null);
            TextView name=(TextView) view1.findViewById(R.id.name);
            name.setText(listItems.get(position).nam);
            TextView desc=(TextView) view1.findViewById(R.id.descr);
            desc.setText(listItems.get(position).dscr);
            Switch aSwitch=(Switch) view1.findViewById(R.id.switch3);
            aSwitch.setChecked(listItems.get(position).due);
//            return getLayoutInflater().inflate(R.layout.activity_item,null);
            return view1;
        }
    }
}