package css.com.applab.activitys;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import css.com.applab.R;
import css.com.applab.server.Server;
import css.com.applab.utils.PingUtil;
import css.com.applab.utils.WifiUtils;

public class ServerAndClientActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_server_and_client);

        findViewById(R.id.serverBtn).setOnClickListener(v -> {
                    String currentIp = WifiUtils.getCurrentIpAddressConnected(this);
                    System.out.println("currentIp:" + currentIp);
                    new Thread(Server::run).start();
                }

        );
        findViewById(R.id.clientBtn).setOnClickListener(v ->{
            System.out.println(PingUtil.ping("192.168.0.113"));

//            new Thread(Client::run).start();
        });
    }
}
