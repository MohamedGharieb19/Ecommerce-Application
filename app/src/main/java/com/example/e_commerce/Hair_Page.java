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

public class Hair_Page extends AppCompatActivity {

    ProductCategoryAdapter productCategoryAdapter;
    RecyclerView productCatRecycler, productItemRecycler;
    ProductAdapter productAdapter;

    TextView Skin;
    Intent SkinPage;

    TextView Face;
    Intent FacePage;

    TextView Body;
    Intent BodyPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hair_page);

        SkinPage = new Intent(this, Skin_Page.class);
        FacePage = new Intent(this, Face_Page.class);
        BodyPage = new Intent(this, Body_Page.class);

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

        Body = findViewById(R.id.Body);
        Body.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(BodyPage);
            }
        });

        List<ProductCategory> productCategoryList= new ArrayList<>();
        productCategoryList.add(new ProductCategory(1,"Most Popular"));
        productCategoryList.add(new ProductCategory(2,"All Hair Product"));
        productCategoryList.add(new ProductCategory(3,"Conditioners"));
        productCategoryList.add(new ProductCategory(4,"Hair Mask"));

        setProductRecycler(productCategoryList);

        List<Products> productsList= new ArrayList<>();
        productsList.add(new Products(1,"Shea Intense Repair Shampoo","8.4 fl oz","$ 12.00", R.drawable.shampoo));
        productsList.add(new Products(2,"Tea Tree Purifying & Balancing Shampoo","8.4 fl oz","$ 2.00", R.drawable.prod3));
        productsList.add(new Products(3,"Fuji Green Tea™ Refreshingly Hydrating Conditioner\n","8.4 fl oz","$ 17.00", R.drawable.prod14));
        productsList.add(new Products(4,"Ginger Scalp Care Conditioner\n","8.4 fl oz","$ 25.00", R.drawable.prod15));
        productsList.add(new Products(5,"Grapeseed Glossing Serum","8.4 fl oz","$ 17.00", R.drawable.prod16));
        productsList.add(new Products(6,"Moringa Shine & Protection Hair Mist","8.4 fl oz","$ 25.00", R.drawable.prod10));

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