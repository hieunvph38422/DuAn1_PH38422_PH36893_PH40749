package com.example.duan1_ph38422_ph36893_ph40749.Helper;

import android.content.Context;
import android.widget.Toast;

import com.example.duan1_ph38422_ph36893_ph40749.Domain.DrinkDomain;

import java.util.ArrayList;

public class ManagenentCart {
    private Context context;
    private TinyDB tinyDB;

    public ManagenentCart(Context context){
        this.context = context;
        this.tinyDB = new TinyDB(context);
    }
    public void insertDrink(DrinkDomain item){
        ArrayList<DrinkDomain> listDrink = getListCart();
                boolean exitsAlready=false;
                int n =0;
                for (int i = 0; i< listDrink.size();i++){
                    if (listDrink.get(i).getTitle().equals(item.getTitle())){
                        exitsAlready = true;
                        n = i;
                        break;
                    }
                }

                if (exitsAlready){
                    listDrink.get(n).setNumberInCart(item.getNumberInCart());
                }else {
                    listDrink.add(item);
                }
                tinyDB.putListObject("CartList",listDrink);
        Toast.makeText(context, "Added To Your Cart", Toast.LENGTH_SHORT).show();
    }
    public ArrayList<DrinkDomain> getListCart(){
        return tinyDB.getListObject("CartList");
    }
}
