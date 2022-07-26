package com.lux.ex031viewpager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //뷰페이저가 보여줄 페이지의 이미지 리소스 id 데이터를 가진 리스트
    ArrayList<Integer> imgIDs= new ArrayList<>();
    ViewPager2 pager2;
    MyAdapter adapter;
    Button btn_prev, btn_next;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //대량의 데이터를 추가(페이지별로 보여줄 이미지들)
        imgIDs.add(R.drawable.img01);
        imgIDs.add(R.drawable.img02);
        imgIDs.add(R.drawable.img03);
        imgIDs.add(R.drawable.img04);
        imgIDs.add(R.drawable.img05);
        imgIDs.add(R.drawable.img06);
        imgIDs.add(R.drawable.img07);
        imgIDs.add(R.drawable.img08);
        imgIDs.add(R.drawable.img09);

        pager2 =findViewById(R.id.pager);
        adapter=new MyAdapter(this,imgIDs);
        pager2.setAdapter(adapter);

        //페이지 이동 버튼
        btn_prev=findViewById(R.id.btn_prev);
        btn_prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //현재 페이지의 1페이지 전
                int index=pager2.getCurrentItem()-1;

                //특정페이지로 이동
                pager2.setCurrentItem(index,true);
            }
        });

        btn_next=findViewById(R.id.btn_next);
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int index = pager2.getCurrentItem()+1;
                pager2.setCurrentItem(index,false);
            }
        });
    }
}