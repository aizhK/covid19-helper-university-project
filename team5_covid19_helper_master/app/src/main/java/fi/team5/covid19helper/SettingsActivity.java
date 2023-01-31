package fi.team5.covid19helper;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceFragmentCompat;

/**
 * Settings menu methods
 */
public class SettingsActivity extends AppCompatActivity {

    /**
     *
     * ACTION_SEND will help to share the feedback
     * i.putExtra will fill the email address, subject and text in the app like gmail or another you choose
     * try defines code in exception can occur
     * catch defines the block of code in which the exception is handled
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        setTitle("Feedback");

        final EditText edit1 = (EditText) findViewById(R.id.edit1);
        final EditText edit2 = (EditText) findViewById(R.id.edit2);
        Button btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("message/html");
                i.putExtra(Intent.EXTRA_EMAIL, new String("damire@metropolia.fi"));
                i.putExtra(Intent.EXTRA_SUBJECT, "Feedback from app");
                i.putExtra(Intent.EXTRA_TEXT, "Name:" + edit1.getText() + "\n Message:" + edit2.getText());
                try {
                    startActivity(getIntent().createChooser(i, "Please select email"));
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(SettingsActivity.this, "There are no Email Clients ", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
