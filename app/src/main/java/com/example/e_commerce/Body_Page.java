package com.example.e_commerce;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.e_commerce.adapter.ProductCategoryAdapter;
import com.example.e_commerce.model.ProductAdapter;
import com.example.e_commerce.model.ProductCategory;
import com.example.e_commerce.model.Products;

import java.util.ArrayList;
import java.util.List;

public class Body_Page extends AppCompatActivity {

    ProductCategoryAdapter productCategoryAdapter;
    RecyclerView productCatRecycler, productItemRecycler;
    ProductAdapter productAdapter;

    Intent incomeIntent;
    TextView Name;
    public static final String TEXT = "text";

    TextView Skin;
    Intent SkinPage;

    TextView Face;
    Intent FacePage;

    TextView Hair;
    Intent HairPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_body_page);

        incomeIntent = getIntent();
        Name = (TextView) findViewById(R.id.Nametxt);
        Name.setText(incomeIntent.getStringExtra(MainActivity.NAME));


        SkinPage = new Intent(this, Skin_Page.class);
        FacePage = new Intent(this, Face_Page.class);
        HairPage = new Intent(this, Hair_Page.class);

        Skin = findViewById(R.id.Skin);
        Skin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(SkinPage);
            }
        });

        Face = findViewById(R.id.Face);
        Face.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(FacePage);
            }
        });

        Hair = findViewById(R.id.Hair);
        Hair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(HairPage);
            }
        });

        List<ProductCategory> productCategoryList= new ArrayList<>();
        productCategoryList.add(new ProductCategory(1,"Most Popular"));
        productCategoryList.add(new ProductCategory(2,"All Body Product"));
        productCategoryList.add(new ProductCategory(3,"Skin Care"));
        productCategoryList.add(new ProductCategory(4,"Hair"));

        setProductRecycler(productCategoryList);

        List<Products> productsList= new ArrayList<>();
        productsList.add(new Products(1,"Japanese Cherry Blossom","250 ml","$ 17.00", R.drawable.prod2));
        productsList.add(new Products(2,"African Mango Shower Gel","250 ml","$ 25.00", R.drawable.prod1));
        productsList.add(new Products(3,"Japanese Cherry Blossom","250 ml","$ 17.00", R.drawable.prod2));
        productsList.add(new Products(4,"African Mango Shower Gel","250 ml","$ 25.00", R.drawable.prod1));
        productsList.add(new Products(5,"Japanese Cherry Blossom","250 ml","$ 17.00", R.drawable.prod2));
        productsList.add(new Products(6,"African Mango Shower Gel","250 ml","$ 25.00", R.drawable.prod1));

        setProductItemRecycler(productsList);
    }

    private void setProductRecycler(List<ProductCategory> productCategoryList)
    {
        productCatRecycler = findViewById(R.id.cat_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        productCatRecycler.setLayoutManager(layoutManager);
        productCategoryAdapter = new ProductCategoryAdapter(this, productCategoryList);
        productCatRecycler.setAdapter(productCategoryAdapter);
    }

    private void setProductItemRecycler(List<Products> productsList)
    {
        productItemRecycler = findViewById(R.id.product_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        productItemRecycler.setLayoutManager(layoutManager);
        productAdapter = new ProductAdapter(this, productsList);
        productItemRecycler.setAdapter(productAdapter);
    }
}