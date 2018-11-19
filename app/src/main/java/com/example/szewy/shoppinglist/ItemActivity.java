package com.example.szewy.shoppinglist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class ItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);

        Button returnButton = (Button)findViewById(R.id.button_return);
        Button deleteButton = (Button)findViewById(R.id.button_delete);

        TextView item_title = (TextView)findViewById(R.id.item_title);
        TextView item_description = (TextView)findViewById(R.id.item_description);
        CircleImageView item_image = (CircleImageView)findViewById(R.id.item_image);

        Item item = (Item)getIntent().getSerializableExtra("item");

        item_title.setText(item.title);
        item_description.setText(item.description);

        int id = getResources().getIdentifier(item.image, "drawable", getPackageName());
        item_image.setImageResource(id);

        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ItemActivity.this, MainActivity.class);

                startActivity(intent);
            }
        });

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FileReader.remove(getIntent().getIntExtra("id", -1));

                Intent intent = new Intent(ItemActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
