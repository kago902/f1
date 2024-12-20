package com.example.baicanhanlck;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Xử lý padding cho hệ thống thanh trạng thái
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Xử lý sự kiện nhấn nút OK
        Button okButton = findViewById(R.id.btnOK); // Đảm bảo nút OK có id là "btnOK"
        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Chuyển sang màn hình FeaturedActivity
                Intent intent = new Intent(MainActivity.this, FeaturedActivity.class);
                startActivity(intent);
            }
        } );

        // Tìm các nút Buy và Sell
        Button buttonBuy = findViewById(R.id.buttonBuy);
        Button buttonSell = findViewById(R.id.buttonSell);

        // Xử lý sự kiện nhấn nút Buy
        buttonBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Đổi màu nền nút Buy sang màu xanh
                buttonBuy.setBackgroundColor(Color.parseColor("#4CAF50")); // Màu xanh lá
                buttonBuy.setTextColor(Color.WHITE);

                // Khôi phục màu của nút Sell (nếu cần)
                buttonSell.setBackgroundColor(Color.parseColor("#E0E0E0")); // Màu xám nhạt
                buttonSell.setTextColor(Color.BLACK);
            }
        });

        // Xử lý sự kiện nhấn nút Sell
        buttonSell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Đổi màu nền nút Sell sang màu xanh
                buttonSell.setBackgroundColor(Color.parseColor("#4CAF50")); // Màu xanh lá
                buttonSell.setTextColor(Color.WHITE);

                // Khôi phục màu của nút Buy (nếu cần)
                buttonBuy.setBackgroundColor(Color.parseColor("#E0E0E0")); // Màu xám nhạt
                buttonBuy.setTextColor(Color.BLACK);
            }
        });
    }
}
