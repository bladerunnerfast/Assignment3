package samples.exoguru.materialtabs;

import android.app.Activity;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

/**
 * Created by TAE on 11/04/2016.
 */
public class MainActivity extends Activity {
    private ProgressBar bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_layout);
        bar = (ProgressBar)findViewById(R.id.pb_loadbar);
        bar.setMax(1000);
        bar.setVisibility(View.VISIBLE);
        bar.setProgressTintList(ColorStateList.valueOf(Color.RED));

    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
