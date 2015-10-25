package edu.uco.jlim4.jlee8.dzhang.Project_DakeZ_JaeheeL_JungsunL;

import android.app.Activity;
import android.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;

import edu.uco.jlim4.jlee8.dzhang.Project_DakeZ_JaeheeL_JungsunL.database.DatabaseOperation;

import static edu.uco.jlim4.jlee8.dzhang.Project_DakeZ_JaeheeL_JungsunL.R.id.buttonClear;
import static edu.uco.jlim4.jlee8.dzhang.Project_DakeZ_JaeheeL_JungsunL.R.id.buttonSave;

public class AddAppointmentActivity extends Activity {

    private String[] stringDayOfWeek = new String[]{
            "Sun","Mon","Tue","Wed","Thur","Fri","Sat"
    };
    private EditText titleTextView;
    private EditText memoTextView;
    private Button saveButton;
    private Button clearButton;
    //add more for the future.
    private String title, memo, date, time, loc, address;

    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_appointment);

        titleTextView = (EditText)findViewById(R.id.setupTitle);
        memoTextView = (EditText) findViewById(R.id.setupMemo);

        // Suggestion: we could use SimpleDateFormat to format the date and time,
        // and store them into String, Date type. (will much more easier to manipulate later.)
        // Here is some example:
        // http://stackoverflow.com/questions/7363112/best-way-to-work-with-dates-in-android-sqlite
        final Calendar c;
        c = Calendar.getInstance();

        final int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);
        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);

        //We are going to use these two TextViews, It's better to get names for them.
        ((TextView)findViewById(R.id.startDate)).setText("  " +year + "." + month + "." + day + " (" +  stringDayOfWeek[dayOfWeek -1] + ")");
        ((TextView)findViewById(R.id.startTime)).setText("  " +String.format("%02d",hour) + ":" + String.format("%02d",minute) );

        //Saving data to database.
        saveButton = (Button)findViewById(buttonSave);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Need to add Non-Empty control here.
                title = titleTextView.getText().toString();
                memo = memoTextView.getText().toString();
                //Add date = dateFormatted;
                // Add more details in the future.

                // put into database
                DatabaseOperation db =  new DatabaseOperation(context);
                //Here will have problem when running since the date and time haven't set value yet.
                db.pushInformation(db,title,memo, date, time);
                finish();
            }
        });

        //clear the view.
        clearButton = (Button)findViewById(buttonClear);
        clearButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //Set all TextView as "".
                titleTextView.setText("");
                memoTextView.setText("");


            }
        });
    }

    public void onDateTimePickerClicked(View view)
    {
        DialogFragment fragment;
        Bundle args;
        switch(view.getId())
        {
            case R.id.startDate:
                fragment = new DatePickerFragment();
                args = new Bundle();
                args.putInt("R.id", R.id.startDate);
                fragment.setArguments(args);
                fragment.show(getFragmentManager(), "datepicker");
            break;
            case R.id.startTime:
                fragment = new TimePickerFragment();
                args = new Bundle();
                args.putInt("R.id", R.id.startTime);
                fragment.setArguments(args);
                fragment.show(getFragmentManager(), "timepicker");
                break;
            case R.id.endDate:
                fragment = new DatePickerFragment();
                args = new Bundle();
                args.putInt("R.id", R.id.endDate);
                fragment.setArguments(args);
                fragment.show(getFragmentManager(), "datepicker");
                break;
            case R.id.endTime:
                fragment = new TimePickerFragment();
                args = new Bundle();
                args.putInt("R.id", R.id.endTime);
                fragment.setArguments(args);
                fragment.show(getFragmentManager(), "timepicker");
                break;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
