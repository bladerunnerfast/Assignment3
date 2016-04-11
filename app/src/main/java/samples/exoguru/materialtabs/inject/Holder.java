package samples.exoguru.materialtabs.inject;

import android.app.Activity;
import android.content.Context;

/**
 * Created by TAE on 11/04/2016.
 */
public class Holder extends Activity{
    private static Context context;

    public static Context getCont() {
        return context;
    }

    public static void setCont(Context context) {
        Holder.context = context;
    }
}
