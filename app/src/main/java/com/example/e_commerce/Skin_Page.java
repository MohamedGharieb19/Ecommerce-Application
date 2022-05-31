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

public class Skin_Page extends AppCompatActivity {

    ProductCategoryAdapter productCategoryAdapter;
    RecyclerView productCatRecycler ,  productItemRecycler;
    ProductAdapter productAdapter;


    TextView Body;
    Intent BodyPage;

    TextView Face;
    Intent FacePage;

    TextView Hair;
    Intent HairPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skin_page);

        BodyPage = new Intent(this, Body_Page.class);
        FacePage = new Intent(this, Face_Page.class);
        HairPage = new Intent(this, Hair_Page.class);

        Body = findViewById(R.id.Body);
        Body.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(BodyPage);
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
        productCategoryList.add(new ProductCategory(2,"Skin Care"));
        productCategoryList.add(new ProductCategory(3,"Moisturising"));
        productCategoryList.add(new ProductCategory(4,"Sun Screen"));

        setProductRecycler(productCategoryList);

        List<Products> productsList= new ArrayList<>();
        productsList.add(new Products(1,"Tea Tree Skin Clearing Facial Wash","8.4 oz","$ 14.00", R.drawable.tea_tree));
        productsList.add(new Products(2,"Aloe Calming Cream Cleanser","8.4 oz","$ 18.00", R.drawable.prod1));
        productsList.add(new Products(3,"Vitamin E Cream Cleanser","8.4 oz","$ 17.00", R.drawable.prod2));
        productsList.add(new Products(4,"Himalayan Charcoal Purifying Glow Mask","0.5 oz","$ 6.00", R.drawable.prod1));
        productsList.add(new Products(5,"Drops of Youth™ Youth Bouncy Sleeping Mask","2.5 oz","$ 32.00", R.drawable.prod2));
        productsList.add(new Products(6,"British Rose Fresh Plumping Mask","0.5 oz","$ 6.00", R.drawable.prod1));

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