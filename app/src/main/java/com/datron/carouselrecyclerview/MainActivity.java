package com.datron.carouselrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import com.datron.carouselrecyclerviewlibrary.CarouselRecyclerViewFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<String> data = new ArrayList<>();
        CarouselRecyclerViewFragment fragment = new CarouselRecyclerViewFragment();
        String[] headers = {"JavaScript","Java","C++","Python"};
        MyRecyclerAdapter adapter = new MyRecyclerAdapter(data);
        fragment.init(adapter,new LinearLayoutManager(this),headers,createList());
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.root,fragment).commit();
    }

    private List<ArrayList<String>> createList() {
        ArrayList<String> data1 = new ArrayList<>();
        ArrayList<String> data2 = new ArrayList<>();
        ArrayList<String> data3 = new ArrayList<>();
        ArrayList<String> data4 = new ArrayList<>();
        data1.add("121;10:30am;Javascript and the future of the Web; Dr Das");
        data1.add("221;11:00am;React JS workshop; Ram Shankar");
        data1.add("324;1:00pm;Angular 4 workshop; Penelope Harris");
        data2.add("742;10:30am;Java 11 - Whats new; Vishal P");
        data2.add("521;11:00am;Spring framework; Robert Downey Jr");
        data3.add("634;10:30am;C++ - Using the Standard Library; Master Chief");
        data3.add("871;11:00am;Know your pointers; Spiderman");
        data3.add("322;9:00am;Writing tests for C++ code; Vladmir Kolgromov");
        data3.add("424;1:00pm;C++ and the Blockchain; Napolean Bonaparte");
        data4.add("524;11:00am;Python and Data Science; Ravi G");
        data4.add("511;1:00pm;Testing and Python; Pablo Escobar");
        ArrayList<ArrayList<String>> data = new ArrayList<>();
        data.add(data1);
        data.add(data2);
        data.add(data3);
        data.add(data4);
        return data;
    }

}
