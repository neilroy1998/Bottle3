package com.example.bottle2;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

public class tasks_overview extends AppCompatActivity {

    String tName = "", tDL = "", tProj = "", tTo = "";
    String tNotes;

    TextView tvName, tvDL, tvDesc, tvProj, tvTo;
    EditText etNotes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasks_overview);

        tName = getIntent().getExtras().getString("tName");
        tDL = getIntent().getExtras().getString("tDL");
        tProj = getIntent().getExtras().getString("tProj");
        tTo = getIntent().getExtras().getString("tTo");

        if (tTo == null) { tTo = "";}

        tvName = findViewById(R.id.tv_tasks);
        tvDL = findViewById(R.id.tv_task_deadline);
        tvDesc = findViewById(R.id.tv_task_desc);
        tvProj = findViewById(R.id.tv_task_proj);
        tvTo = findViewById(R.id.tv_task_to);
        etNotes = findViewById(R.id.et_tasks_notes_et);

        tvName.setText(tName);
        tvDL.setText(tDL);
        tvDesc.setText("A purple pig and a green donkey flew a kite in the middle of the night and ended up sunburnt. There were white out conditions in the town; subsequently, the roads were impassable. If you like tuna and tomato sauce- try combining the two. It’s really not as bad as it sounds.");
        tvProj.setText(tProj);
        if (tTo.equals("")) {
            tvTo.setText("");
        }
        else {
            tvTo.setText("To: " + tTo);
        }

        tNotes = etNotes.getText().toString();
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            View v = getCurrentFocus();
            if ( v instanceof EditText) {
                Rect outRect = new Rect();
                v.getGlobalVisibleRect(outRect);
                if (!outRect.contains((int)event.getRawX(), (int)event.getRawY())) {
                    v.clearFocus();
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                }
            }
        }
        return super.dispatchTouchEvent( event );
    }
}
