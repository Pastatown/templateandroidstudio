package com.example.appseriecorrige;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class JSONHelper {
    private String mFile;
    private Context mContext;

    private ArrayList<Serie> lesSeries = new ArrayList<Serie>();

    public JSONHelper(Context context,String file){
        mFile = file;
        mContext = context;
        /***********************************************/
        /******** lecture d'un fichier json           **/
        /***********************************************/
        try {
            JSONObject obj = new JSONObject(loadJSONFromAsset(context));
            JSONArray userArray = obj.getJSONArray("data");
            for (int i = 0; i < userArray.length(); i++) {
                JSONObject userDetail = userArray.getJSONObject(i);
                Serie a = new Serie(userDetail.getLong("id"),
                        userDetail.getString("titre"),
                        userDetail.getString("resume"),
                        userDetail.getString("duree"),
                        userDetail.getString("premiereDiffusion"),
                        userDetail.getString("image"));
                //SerieSqlHelper dbHelper = new SerieSqlHelper(context);
                //dbHelper.addSerie(a);
                lesSeries.add(a);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    /************************************************/
    /******** apres le onCreate de la vue listView **/
    /************************************************/
    public String loadJSONFromAsset(Context context) {
        String json = null;
        try {
            context.getAssets();
            InputStream is = context.getAssets().open(mFile);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
    /************************************************/
    /******** retourne la liste des series         **/
    /************************************************/
    public ArrayList<Serie> getLesSerie(){
        return lesSeries;
    }

    public Serie getSerie(int position){
        return lesSeries.get(position);
    }





}