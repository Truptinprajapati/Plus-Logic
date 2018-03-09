package demo.mypluslogic;

import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    TableLayout mTableLayout;
    int mycountdata = 0;
    Button submit;


    private ArrayList<TextView> text1_arrylist = new ArrayList<TextView>();
    private ArrayList<TextView> Edittext1_arrylist = new ArrayList<TextView>();
    private ArrayList<TextView> addbutton_arraylist = new ArrayList<TextView>();
    private ArrayList<TextView> removebutton_arraylist = new ArrayList<TextView>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTableLayout = (TableLayout) findViewById(R.id.test_tbl);
        submit = (Button) findViewById(R.id.submit);

        mTableLayout.addView(tableRow(mycountdata));
        mycountdata++;

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {

                for (int i=0;i<Edittext1_arrylist.size();i++)
                {
                    Toast.makeText(MainActivity.this, ""+"ID="+i+"--"+Edittext1_arrylist.get(i).getText().toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

    private TableRow tableRow(int _intID) {
        TableRow editname = new TableRow(this);
        editname.setId(_intID);
        editname.addView(InkID(_intID));
        editname.addView(edittext(_intID));
        editname.addView(Plus_icon(_intID));
        editname.addView(btnremove(_intID));
        editname.setGravity(Gravity.CENTER);
        TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
        lp.setMargins(16, 16, 16, 16);
        editname.setLayoutParams(lp);
        return editname;
    }

    private TextView InkID(int _inkId) {
        final TextView editname = new TextView(this);
        editname.setId(_inkId);
        TableRow.LayoutParams lp = new TableRow.LayoutParams(100, TableRow.LayoutParams.MATCH_PARENT);
        editname.setLayoutParams(lp);
        editname.setGravity(Gravity.CENTER);
        editname.setText("" + _inkId);
        text1_arrylist.add(editname);
        return editname;
    }


    private EditText edittext(int _intID) {
        final EditText editname = new EditText(this);
        editname.setId(_intID);
        TableRow.LayoutParams lp = new TableRow.LayoutParams(100, TableRow.LayoutParams.MATCH_PARENT);
        editname.setLayoutParams(lp);
        editname.setGravity(Gravity.CENTER);
        editname.setText("");
        editname.setHint("Enter Name");
        Edittext1_arrylist.add(editname);
        return editname;
    }

    private TextView Plus_icon(final int _intID) {
        final TextView edittotal = new TextView(this);
        edittotal.setId(_intID);
        TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.MATCH_PARENT);
        edittotal.setGravity(Gravity.CENTER);
        edittotal.setLayoutParams(lp);
        edittotal.setTypeface(null, Typeface.NORMAL);
        edittotal.setText("Add");
        edittotal.setTextSize(24f);
        edittotal.setTextColor(Color.BLUE);
        addbutton_arraylist.add(edittotal);
        for (int i = 0; i < addbutton_arraylist.size(); i++) {


        }
        edittotal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    mTableLayout.addView(tableRow(mycountdata));
                    mycountdata++;

                } catch (NullPointerException e) {
                    e.printStackTrace();

                }
            }
        });

        return edittotal;
    }

    private TextView btnremove(final int _intID) {
        final TextView edittotal = new TextView(this);
        edittotal.setId(_intID);
        TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT);
        edittotal.setGravity(Gravity.CENTER);
        edittotal.setLayoutParams(lp);
        edittotal.setTypeface(null, Typeface.NORMAL);
        edittotal.setTextSize(24f);
        edittotal.setText("Remove");
        edittotal.setTextColor(Color.BLUE);
        removebutton_arraylist.add(edittotal);

        for (int i = 0; i < removebutton_arraylist.size(); i++) {

            if (i == 0) {
                edittotal.setVisibility(View.GONE);
            } else {
                edittotal.setVisibility(View.VISIBLE);
            }
        }
        edittotal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mTableLayout.removeView((View) view.getParent());
                mycountdata--;
                Edittext1_arrylist.remove(_intID);

            }
        });

        return edittotal;
    }
}


