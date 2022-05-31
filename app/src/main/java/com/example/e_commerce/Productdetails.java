package com.example.e_commerce;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.os.Build;
import android.app.ActionBar;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class Productdetails extends AppCompatActivity {

    ImageView backBtn;
    ImageView Share;
    Intent Back;
    Button AddCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productdetails);
        backBtn =(ImageView) findViewById(R.id.backBtn);
        Back = new Intent();

        Share = (ImageView) findViewById(R.id.Share);
        ActionBar actionBar = getActionBar();

        AddCart= (Button) findViewById(R.id.AddToCart);

        AddCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Productdetails.this,"Added to Cart",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Productdetails.this, Notifications.class);
                PendingIntent pendingIntent= PendingIntent.getBroadcast(Productdetails.this, 0, intent,0);
                AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
                long timeAtButtonClick = System.currentTimeMillis();
                long tenSeconds = 1000 * 10;
                alarmManager.set(AlarmManager.RTC_WAKEUP, timeAtButtonClick + tenSeconds,pendingIntent);
            }
        });

    }

    public void back(View view)
    {
        finish();
    }

    public void Share(View view) {
        Share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("text/plain");
                String body = "Hey, Look what I found on The Body Shop Applications\nThey have a lot of great products";
                i.putExtra(Intent.EXTRA_TEXT,body);
                startActivity(Intent.createChooser(i,"Share Using"));
            }
        });
    }

    private void createNotificationChannel()
    {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
        {
            CharSequence name = "NotificationChannel";
            String description = "Channel for Add to Cart";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel("Cart Notification", name, importance);
            channel.setDescription(description);

            NotificationManager manager = getSystemService(NotificationManager.class);

            manager.createNotificationChannel(channel);

        }
    }
}