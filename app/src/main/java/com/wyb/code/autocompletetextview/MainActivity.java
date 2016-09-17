package com.wyb.code.autocompletetextview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private AutoCompleteTextView mActv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mActv = (AutoCompleteTextView) findViewById(R.id.actv);

        List<String> datas = new ArrayList<>();
        datas.add(getResources().getString(R.string.big));
        datas.add(getResources().getString(R.string.middle));
        datas.add(getResources().getString(R.string.small));
        datas.add(getResources().getString(R.string.boom));

        String[] strings = getResources().getStringArray(R.array.grilarray);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, datas);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, R.layout.list_item, R.id.tv_info, strings);
        mActv.setAdapter(adapter1);

        //点击事件...
        mActv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Toast.makeText(MainActivity.this, adapterView.getAdapter().getItem(position).toString(), Toast.LENGTH_SHORT).show();
            }
        });

        // 当输入框里的文本发生改变的时候调用
        mActv.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
                Log.i("TAG", "s=" + charSequence.toString() + ",start=" + start + ",before=" + before + ",count=" + count);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    public void autoCompleteTextViewWithJson(View view) {
        startActivity(new Intent(this,AutoCompleteTextViewWithJsonActivity.class));
    }
}
