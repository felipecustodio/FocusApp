package br.com.whatsappandroid.cursoandroid.focar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.ArrayList;
import java.util.List;

public class StatActivity extends AppCompatActivity {

    private LineChart chart;
    private int[] data; // for further creation and integration with database
    List<Entry> entries;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stat);

        chart = (LineChart) findViewById(R.id.chart);
        entries = new ArrayList<Entry>();

        // TODO
//        for(int d: data) {
            // turn your data into Entry objects
//            entries.add(new Entry(d.getValueX(), d.getValueY()));
//        }



    }
}
