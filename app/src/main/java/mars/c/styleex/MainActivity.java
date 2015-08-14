package mars.c.styleex;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends FragmentActivity {

    boolean b;

    @Bind(R.id.t) TextView t;
    @OnClick(R.id.t) void t(){
//        dynamic "manual" switching
        b=!b;
        t.setTextAppearance(this, b ? android.R.style.TextAppearance_Holo_Large_Inverse : android.R.style.TextAppearance_Medium_Inverse);
        if(b)t.setTextColor(getResources().getColor(android.R.color.black));
        t.setBackground(b ? ResourcesCompat.getDrawable(getResources(), R.drawable.bg, null) : null);
    }

    private static boolean _theme;
    @Bind(R.id.u)
    Button u;
    @OnClick(R.id.u) void u(){
        _theme=!_theme;
        finish();
        startActivity(new Intent(this, this.getClass()));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTheme(_theme ? R.style.AppTheme_Green : R.style.AppTheme_Orange);

        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }
}
