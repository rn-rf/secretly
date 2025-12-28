package com.example.afinal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Random;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.util.Locale;

import android.app.AlertDialog;
import android.content.DialogInterface;


import android.graphics.BitmapFactory;
import java.io.ByteArrayOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.FileHandler;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class FileHandler2 {

    public static void writeToFile(Context context, String fileName, String data) {
        try (FileOutputStream fos = context.openFileOutput(fileName, Context.MODE_PRIVATE);
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fos))) {

            writer.write(data);

        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    public static String readFromFile(Context context, String fileName) {
        StringBuilder content = new StringBuilder();
        try (FileInputStream fis = context.openFileInput(fileName);
             InputStreamReader isr = new InputStreamReader(fis);
             BufferedReader br = new BufferedReader(isr)) {

            String line;
            while ((line = br.readLine()) != null) {
                content.append(line).append("\n");
            }


        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error reading from file: " + e.getMessage());
        }

        return content.toString().trim();
    }
}
public class SecondActivity extends AppCompatActivity {


    DrawerLayout DL2;
    Toolbar TB;
    NavigationView NV2;
    ImageView AT;
    EditText PT;
    ImageView Siv;
    int password_sec;
    boolean ooo = false;
    ImageView img2;
    String hack;


    class Code {
        char[] numbers = {'1', 'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p', 'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'z', 'x', 'c', 'v', 'b', 'n', 'm', '2', '3', '4', 'Q', '5', 'W', '6', '7', '8', 'P', 'O', 'I', 'U', 'Y', 'T', 'R', 'E', '9', '!', '@', '#', 'M', 'N', 'B', 'C', 'X', 'Z', '$', '%', 'K', 'J', 'H', 'G', 'F', 'S', '^', '&', '*', '(', ')', '0', '`', '~', '-', '_', '=', '+', '[', '{', '|', ':', ';', ',', '.', '/', '<', '>', '?', 'Ü', 'ß', 'à', 'á', 'â', 'ä', 'å', 'æ', 'ç', 'è', 'é', 'ê', 'ë', 'ì', 'í', 'î', 'ï', 'ð', 'ñ', 'ò', 'ó', 'ô', 'ö', '÷', 'ù', 'ú', 'û', 'ü', 'ÿ'};

        public StringBuilder numberToText(int rgbValues) {
            boolean flag = true;
            if (rgbValues < 0) {
                rgbValues = Math.abs(rgbValues);
                flag = false;
            }
            StringBuilder text = new StringBuilder();
            int rem;
            int num = rgbValues;
            if (num == 0) {
                text.insert(0, numbers[0]);
            }
            while (num != 0) {
                rem = num % numbers.length;
                text.insert(0, numberToChar(rem));
                num = num / numbers.length;
            }
            if (flag) {
                text.insert(0, '!');
            }
            return text;
        }

        public int textToNumber(StringBuilder code) {
            boolean flag = true;
            if (code.charAt(0) == '!') {
                code.deleteCharAt(0);
                flag = false;
            }
            int num = 0;
            for (int i = 0; i < code.length(); i++) {
                int temp = charToNumber(code.charAt(i));
                num = (aryan(i, numbers.length) * num) + temp;
            }
            if (flag) {
                num = num - num - num;
            }
            return num;
        }

        public char numberToChar(int num) {
            return numbers[num];
        }

        public int charToNumber(char sym) {
            return indexOf(sym);
        }

        public int indexOf(char sym) {
            for (int i = 0; i < numbers.length; i++) {
                if (numbers[i] == sym) {
                    return i;
                }
            }
            return 0;
        }

        int aryan(int i, int num) { // this function return num only if i is not 0
            if (i == 0)
                return 0;
            return num;
        }
    }

    class Press {
        char[] specialNum = {'L', 'A', 'V', 'D', '}'};

        String shrink(String code) {
            String list[] = code.split(" ");
            StringBuilder output = new StringBuilder();
            int count = 0;
            for (int i = 0; i < list.length - 1; i++) {
                if (list[i].equals(list[i + 1])) {
                    count++;
                } else {
                    if (count != 0) {
                        Random rand = new Random();
                        Code c = new Code();
                        int r = rand.nextInt(specialNum.length);
                        output.append(list[i] + specialNum[r] + c.numberToText(count) + " ");
                        count = 0;
                    } else {
                        output.append(list[i] + " ");
                    }
                }
            }
            output.append(list[list.length - 1] + " " + list[list.length - 2]);
            return output.toString();
        }

        String enlarge(String code) {
            StringBuilder output = new StringBuilder();
            String[] list = code.split(" ");

            for (int i = 0; i < list.length - 2; i++) {
                int num = 0;
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < list[i].length(); j++) {
                    if (list[i].charAt(j) == 'L' || list[i].charAt(j) == 'A' || list[i].charAt(j) == 'V' || list[i].charAt(j) == 'D' || list[i].charAt(j) == '}') {
                        for (int l = 0; l < j; l++) {
                            sb.append(list[i].charAt(l));
                        }
                        StringBuilder temp = new StringBuilder();
                        for (int k = j + 1; k < list[i].length(); k++) {
                            temp.append(list[i].charAt(k));
                        }
                        Code cc = new Code();
                        num = cc.textToNumber(temp);
                    }
                }
                for (int j = 0; j <= num; j++) {
                    output.append(sb.toString() + " ");
                }
                if (num == 0) {
                    output.append(list[i] + " ");
                }
                num = 0;
            }
            output.append(list[list.length - 1] + " " + list[list.length - 2]);
            String ot = output.toString();
            return ot.replaceAll("\\s+", " ");
        }
    }


    ImageView MI;
    byte[] byteArray;
    Code cdd = new Code();
    Press p = new Press();
    String receivedString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE);

//        Intent intent = getIntent();
//        byte[] byteArray2 = intent.getByteArrayExtra("imageBytes1");
//
//        if (byteArray != null) {
//            Bitmap receivedBitmap1 = BitmapFactory.decodeByteArray(byteArray2, 0, byteArray2.length);
//            img2.setImageBitmap(receivedBitmap1);
//
//        }

//        Intent intent = getIntent();
//        receivedString = intent.getStringExtra("keyString");
//
//        TextView textView = findViewById(R.id.SUserName);
//        textView.setText(receivedString);
        String readData = FileHandler2.readFromFile(this, "user.txt");

        TextView vt = findViewById(R.id.SUserName);

// Set the text of the TextView with the data read from the file
        vt.setText(readData);
        AT = findViewById(R.id.SATI);
        AT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                if (clipboard.hasPrimaryClip()) {
                    AT.setVisibility(View.GONE);
                    TextView ATM = findViewById(R.id.Smesg);
                    ATM.setVisibility(View.GONE);
                    ClipData.Item item = clipboard.getPrimaryClip().getItemAt(0);
                    PT = findViewById(R.id.SpasteText);
                    String textToPaste = item.getText().toString();
                    PT.setText(textToPaste);
                    PT.setVisibility(View.VISIBLE);

                    showToast("Text pasted from clipboard.");
                }
            }
        });
        DL2 = findViewById(R.id.drawerLayout2);
        NV2 = findViewById(R.id.nav_view2);
        TB = findViewById(R.id.toolBar2);
        NV2.setNavigationItemSelectedListener(this::onNavigationItemSelected);

        setSupportActionBar(TB);

        ActionBarDrawerToggle t = new ActionBarDrawerToggle(this, DL2, TB, R.string.Open_drawer, R.string.close_drawer);
        DL2.addDrawerListener(t);
        t.syncState();

        MI = findViewById(R.id.Max);
        MI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (bit != null) {
                    ByteArrayOutputStream stream = new ByteArrayOutputStream();
                    bit.compress(Bitmap.CompressFormat.PNG, 100, stream);
                    byteArray = stream.toByteArray();

                    Intent intent = new Intent(SecondActivity.this, Maximize.class);
                    intent.putExtra("imageBytes", byteArray);
                    startActivity(intent);
                } else {

                    showToast("First UnConvert the image");
                }

            }
        });

        editText=findViewById(R.id.SpasteText);
    }


    public void onBackPressed() {
        if (DL2.isDrawerOpen(GravityCompat.START)) {
            DL2.closeDrawer(GravityCompat.START);
        } else if (isTaskRoot()) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        } else {
            super.onBackPressed();
        }
    }


    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    Bitmap bit;
    EditText editText;

    public void OG_decon(String str){
        str = p.enlarge(str);
        String s1[] = str.split(" ");

        int a = 0, b = 0;
        try {
            StringBuilder sb1 = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            sb1.append(s1[s1.length - 2]);
            sb2.append(s1[s1.length - 1]);
            a = cdd.textToNumber(sb1);
            b = cdd.textToNumber(sb2);
        } catch (NumberFormatException nfe) {
            System.out.println("Could not parse " + nfe);
        }
        int[][] rgbValues = new int[a][b];
        for (int i = 0, k = 0; i < a; i++) {
            for (int j = 0; j < b; j++, k++) {
                int z = 0;
                try {
                    StringBuilder sb = new StringBuilder();
                    sb.append(s1[k]);
                    z = cdd.textToNumber(sb);
                } catch (NumberFormatException nfe) {
                    System.out.println("Typecasting Error " + nfe);
                }
                rgbValues[i][j] = z;
            }
        }

        bit = Bitmap.createBitmap(a, b, Bitmap.Config.ARGB_8888);
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                bit.setPixel(i, j, rgbValues[i][j]);
            }
        }
        img2 = findViewById(R.id.SdeconvertedImage);
        img2.setImageBitmap(bit);
        showToast("Image unconverted from text.");
    }


    public void jugad(String s) {


//        String s = editText.getText().toString();
//        if (s.isEmpty()) {
//            showToast("Please add text before unconvert.");
//            return;
//        }
        password_sec=password_sec*204753;
        String spass = String.valueOf(password_sec);
        if(s.endsWith(" locked")){
            hack=" locked";
            s = s.substring(0, s.length()-hack.length());
            String pass_check;
            pass_check=s.substring(s.length()-spass.length());
            if(spass.contentEquals(pass_check)){
                s=s.substring(0,s.length()-spass.length());
                OG_decon(s);
            }
            else{
                showToast("Incorrect Password");
                View v = new View(SecondActivity.this);
                unconvert(v);
            }
        }
        else{
            String pass_check;
            pass_check=s.substring(s.length()-spass.length());
            if(spass.contentEquals(pass_check)){
                s=s.substring(0,s.length()-spass.length());
                OG_decon(s);
            }
            else{
                showToast("Incorrect Password");
                View v = new View(SecondActivity.this);
                unconvert(v);
            }
        }

//        showToast(spass);
//        StringBuilder sbp = new StringBuilder();
//        StringBuilder sbp2 = new StringBuilder();
//        sbp.append(spass);
//        sbp2.append(cdd.textToNumber(sbp));
//        String ss = sbp2.toString();

//        System.out.println(spass);
//        if (s.startsWith(spass)) {
//        String hack = " locked";

//            s = s.substring(0, s.length()-hack.length());
//            String pass_check;
//            pass_check=s.substring(s.length()-spass.length());

//            int check_pass =Integer.parseInt(pass_check);
//        showToast(String.valueOf(check_pass));
//            check_pass=(check_pass/20);
//        showToast(String.valueOf(check_pass));

//        pass_check=String.valueOf(check_pass);


//            if(spass.contentEquals(pass_check)){
//            s=s.substring(0,s.length()-spass.length());
//            OG_decon(s);
//        }
//            else{
//                showToast("Incorrect Password");
//                View v = new View(SecondActivity.this);
//                unconvert(v);
//            }

    }
    TextView SUN;
    public void wca2(String s){
        SUN= findViewById(R.id.SUserName);
        String suser= SUN.getText().toString();
        s = s.substring(0, s.length()-hack.length());
        if(s.endsWith(suser)){
            String pass_check;
            pass_check=s.substring(s.length()-suser.length());
            s=s.substring(0,s.length()-suser.length());
            OG_decon(s);
        }
        else{
            showToast("you don't have access to this image");
        }

    }



    public void pass2(String s) {
        View view = LayoutInflater.from(SecondActivity.this).inflate(R.layout.password2, null);
        EditText PW2 = view.findViewById(R.id.pass2);
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(SecondActivity.this);
        alertDialogBuilder.setView(view);
        alertDialogBuilder.setCancelable(false);
        alertDialogBuilder.setTitle("Enter Password To Unlock");
        alertDialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                try {
                    String userInput = PW2.getText().toString();
//                    Toast.makeText(MainActivity.this,userInput,Toast.LENGTH_SHORT).show();

                    password_sec = Integer.parseInt(userInput);

                    jugad(s);
//                    System.out.println(password_sec);

                    dialog.dismiss();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        alertDialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
    EditText Swho;

    public void wca1(){
        View view = LayoutInflater.from(SecondActivity.this).inflate(R.layout.wca1, null);
        Swho= view.findViewById(R.id.Swhocan);
        AlertDialog.Builder alertDialogBuilder1 = new AlertDialog.Builder(SecondActivity.this);
        alertDialogBuilder1.setView(view);
        alertDialogBuilder1.setCancelable(false);
        alertDialogBuilder1.setTitle("Enter Name");
        alertDialogBuilder1.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                try {
                    String userInput = Swho.getText().toString();
//                    Toast.makeText(SecondActivity.this,userInput,Toast.LENGTH_SHORT).show();
                    showToast("tari "+userInput);
                    dialog.dismiss();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
        alertDialogBuilder1.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        AlertDialog alertDialog = alertDialogBuilder1.create();
        alertDialog.show();
    }

    public void both(String s){
        SUN= findViewById(R.id.SUserName);
        String suser= SUN.getText().toString();
        s = s.substring(0, s.length()-hack.length());
        if(s.endsWith(suser)){
            String pass_check2;
            pass_check2=s.substring(s.length()-suser.length());
            s=s.substring(0,s.length()-suser.length());
            pass2(s);
        }
        else{
            showToast("you don't have access to this image");
        }
    }

    public static boolean check(String str) {
        return str.endsWith("locked");
    }

    public void unconvert(View view) {
//        String hack2="1";


        String s = editText.getText().toString();
        if (s.isEmpty()) {
            showToast("Please add text before unconvert.");
            return;
        }
        if (check(s)) {
            if(s.endsWith(" 3locked")) {
                hack=" 3locked";
                both(s);

            } else if (s.endsWith(" 2locked")) {
                hack=" 2locked";
                wca2(s);
            } else if (s.endsWith(" locked")) {
                hack=" locked";
                pass2(s);
            }
        }
        else {
//            System.out.println(s);
//            showToast(String.valueOf(s));
//            s = p.enlarge(s);
//            System.out.println(s);
//            showToast(String.valueOf(s));
            OG_decon(s);
        }
//        TextView t =(TextView) findViewById(R.id.textView);
//        t.setText(String.valueOf(s1.length));
}

    protected void attachBaseContext(Context newBase) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(newBase);
        String selectedLanguage = prefs.getString("selected_language", "en");

        Locale locale = new Locale(selectedLanguage);
        Configuration config = new Configuration();
        config.setLocale(locale);

        Context updatedContext = newBase.createConfigurationContext(config);
        super.attachBaseContext(updatedContext);
    }

    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem){
        int itemId = menuItem.getItemId();
        if (itemId == R.id.nav_home) {
        } else if (itemId == R.id.nav_help) {
            Intent intent = new Intent(this, help.class);
            startActivity(intent);
        } else if (itemId == R.id.nav_about) {
            Intent intent = new Intent(this, about.class);
            startActivity(intent);}
        else if (itemId == R.id.nav_language){
            showLanguageSelectionDialog();
        }
        else if (itemId == R.id.nav_sign) {
            String urlToVisit = "https://secretly-ltd.github.io/web/";

            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(urlToVisit));

            startActivity(intent);

        }
        DL2.closeDrawer(GravityCompat.START);
        return true;
    }

    private void showLanguageSelectionDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Select Language")
                .setItems(new CharSequence[]{"English", "हिंदी"}, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which) {
                            case 0:
                                changeAppLanguage("en"); // Change language to English
                                recreate(); // Restart the activity to apply changes
                                break;
                            case 1:
                                changeAppLanguage("hi"); // Change language to Hindi
                                recreate(); // Restart the activity to apply changes
                                break;
                        }
                    }
                });
        builder.create().show();
    }

    private void changeAppLanguage(String languageCode) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("selected_language", languageCode);
        editor.apply();
    }
    public void change(View view){
        Siv=findViewById(R.id.SimageView5);
        Intent inext ;
        inext= new Intent(SecondActivity.this, MainActivity.class);

        startActivity(inext);

    }

}