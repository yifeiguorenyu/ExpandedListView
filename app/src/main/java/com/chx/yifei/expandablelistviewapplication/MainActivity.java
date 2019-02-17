package com.chx.yifei.expandablelistviewapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;

import com.chx.yifei.expandablelistviewapplication.adapter.ChapterAdapter;
import com.chx.yifei.expandablelistviewapplication.bean.Chapter;
import com.chx.yifei.expandablelistviewapplication.bean.ChapterLab;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
 private ExpandableListView expandableListView;
 private BaseExpandableListAdapter mAdapter;
 private List<Chapter> mDatas = new ArrayList<Chapter>();
    private static final String Tag ="imooc-ex";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       initViews();

       initEvents();
    }

    private void initEvents() {
        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                Log.d(Tag,"onChildClick groupPosition"+groupPosition+"childPosition"+childPosition);
                return false;
            }
        });
        expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                Log.d(Tag,"onGroupClick groupPosition"+groupPosition);
                return false;
            }
        });
        expandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int groupPosition) {
                Log.d(Tag,"OnGroupCollapse groupPosition"+groupPosition);
            }
        });
        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
                Log.d(Tag,"OnGroupExpand groupPosition"+groupPosition);
            }
        });
    }

    private void initViews() {
        expandableListView = findViewById(R.id.id_expandableListView);
        mDatas = ChapterLab.geneneraMockDatas();
       final ChapterAdapter chapterAdapter =new ChapterAdapter(this,mDatas);
        expandableListView.setAdapter(chapterAdapter);
        //控制他只能打开一个组
        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
                int count =chapterAdapter.getGroupCount();
                for(int i = 0;i < count;i++){
                    if (i!=groupPosition){
                        expandableListView.collapseGroup(i);
                    }
                }
            }
        });


    }
}
