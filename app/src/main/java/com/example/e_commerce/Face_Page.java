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

public class Face_Page extends AppCompatActivity {

    ProductCategoryAdapter productCategoryAdapter;
    RecyclerView productCatRecycler ,  productItemRecycler;
    ProductAdapter productAdapter;


    TextView Skin;
    Intent SkinPage;

    TextView Body;
    Intent BodyPage;

    TextView Hair;
    Intent HairPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_face_page);

        SkinPage = new Intent(this, Skin_Page.class);
        BodyPage = new Intent(this, Body_Page.class);
        HairPage = new Intent(this, Hair_Page.class);

        Skin = findViewById(R.id.Skin);
        Skin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(SkinPage);
            }
        });

        Body = findViewById(R.id.Body);
        Body.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(BodyPage);
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
        productCategoryList.add(new ProductCategory(2,"All Face Product"));
        productCategoryList.add(new ProductCategory(3,"Fragrance For Her"));
        productCategoryList.add(new ProductCategory(4,"Fragrance For Him"));

        setProductRecycler(productCategoryList);

        List<Products> productsList= new ArrayList<>();
        productsList.add(new Products(1,"Vanilla Eau De Toilette","1 fl oz","$ 14.00", R.drawable.vanilla));
        productsList.add(new Products(2,"White Musk® Eau De Parfum","1 fl oz","$ 35.00", R.drawable.body));
        productsList.add(new Products(3,"Pink Pepper & Lychee Hair & Body Mist","5 fl oz","$ 15.00", R.drawable.prod19));
        productsList.add(new Products(4,"White Musk® Sport Eau De Toilette","3.4 fl oz","$ 28.00", R.drawable.prod21));
        productsList.add(new Products(5,"Black Musk Eau De Parfum\n","1.7 fl oz","$ 37.00", R.drawable.prod11));
        productsList.add(new Products(6,"Activist™ Eau De Toilette","3.3 fl oz","$ 28.00", R.drawable.prod18));

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