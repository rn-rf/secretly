package com.example.afinal;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Random;


import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.MenuItem;
import androidx.annotation.NonNull;

import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.card.MaterialCardView;
import com.google.android.material.navigation.NavigationView;




import android.content.SharedPreferences;
import android.content.res.Configuration;

import android.app.AlertDialog;
import android.content.DialogInterface;

import java.util.Locale;


import android.preference.PreferenceManager;
import java.io.ByteArrayOutputStream;
import android.graphics.BitmapFactory;

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
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

 class FileHandler1 {

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


class FileOperations {

    public static void writeToFile(String data) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("user.txt"))) {
            writer.write(data);
        } catch (IOException e) {
            System.err.println("Error writing to user.txt: " + e.getMessage());
        }
    }

    public static String readFromFile() {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader("user.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
            return content.toString().trim();
        } catch (IOException e) {
            System.err.println("Error reading from user.txt: " + e.getMessage());
            return null;}
}

}







public class MainActivity extends AppCompatActivity {

    DrawerLayout DL;
    Toolbar TB;
    NavigationView NV;

    ImageView iv;
    String arpal;
    private  final int gall_code = 1;
    ImageView II;
    TextView DH;
    Bitmap bmp;
    ImageView OG;
    ImageView CT2;

    int password;
    boolean fillpass= false;
    boolean lock =false;

    boolean lock2 =false;




    class Code {
        char[] numbers = {'1','q','w','e','r','t','y','u','i','o','p','a','s','d','f','g','h','j','k','l','z','x','c','v','b','n','m','2','3','4','Q','5','W','6','7','8','P','O','I','U','Y','T','R','E','9','!','@','#','M','N','B','C','X','Z','$','%','K','J','H','G','F','S','^','&','*','(',')','0','`','~','-','_','=','+','[','{','|',':',';',',','.','/','<','>','?','Ü','ß','à','á','â','ä','å','æ','ç','è','é','ê','ë','ì','í','î','ï','ð','ñ','ò','ó','ô','ö','÷','ù','ú','û','ü','ÿ'};

        public StringBuilder numberToText (int rgbValues) {

            boolean flag = true;
            if(rgbValues < 0){
                rgbValues = Math.abs(rgbValues);
                flag = false;
            }
            StringBuilder text = new StringBuilder();
            int rem;
            int num = rgbValues;
            if(num == 0) {
                text.insert(0,numbers[0]);
            }
            while(num != 0) {
                rem = num%numbers.length;
                text.insert(0, numberToChar(rem));
                num = num/numbers.length;
            }
            if(flag) {
                text.insert(0,'!');
            }
            return text;
        }

        public int textToNumber(StringBuilder code) {
            boolean flag = true;
            if(code.charAt(0)=='!'){
                code.deleteCharAt(0);
                flag = false;
            }
            int num = 0;
            for(int i = 0; i<code.length(); i++) {
                int temp = charToNumber(code.charAt(i));
                num = (aryan(i, numbers.length) * num) + temp;
            }
            if(flag){
                num= num-num-num;
            }
            return num;
        }

        public char numberToChar (int num) {
            return numbers[num];
        }

        public int charToNumber(char sym) {
            return indexOf (sym);
        }

        public int indexOf (char sym) {
            for(int i=0; i<numbers.length; i++) {
                if(numbers[i] == sym) {
                    return i;
                }
            }
            return 0;
        }

        int aryan(int i, int num) { // this function return num only if i is not 0
            if(i==0)
                return 0;
            return num;
        }
    }
    class Press {
        char[] specialNum = {'L', 'A', 'V', 'D', '}'};
        String shrink (String code) {
            String list[] = code.split(" ");
            StringBuilder output = new StringBuilder();
            int count = 0;
            for(int i=0; i<list.length-1; i++){
                if(list[i].equals(list[i+1])){
                    count++;
                }
                else {
                    if(count!=0){
                        Random rand = new Random();
                        Code c = new Code();
                        int r = rand.nextInt(specialNum.length);
                        output.append(list[i] + specialNum[r] + c.numberToText(count) + " ");
                        count=0;
                    }
                    else{
                        output.append(list[i] + " ");
                    }
                }
            }
            output.append(list[list.length-1]+" "+list[list.length-2]);
            return output.toString();
        }
        String enlarge(String code) {
            StringBuilder output = new StringBuilder();
            String[] list = code.split(" ");

            for(int i=0; i<list.length-2; i++) {
                int num = 0;
                StringBuilder sb = new StringBuilder();
                for(int j=0; j<list[i].length(); j++) {
                    if(list[i].charAt(j)=='L' || list[i].charAt(j)=='A' || list[i].charAt(j)=='V' || list[i].charAt(j)=='D' || list[i].charAt(j)=='}'){
                        for(int l=0; l<j; l++) {
                            sb.append(list[i].charAt(l));
                        }
                        StringBuilder temp = new StringBuilder();
                        for(int k=j+1; k<list[i].length(); k++) {
                            temp.append(list[i].charAt(k));
                        }
                        Code cc = new Code();
                        num = cc.textToNumber(temp);
                    }
                }
                for(int j=0; j<=num; j++) {
                    output.append(sb.toString() + " ");
                }
                if(num==0){
                    output.append(list[i] + " ");
                }
                num=0;
            }
            output.append(list[list.length-1]+" "+list[list.length-2]);
            String ot = output.toString();
            return ot.replaceAll("\\s+", " ");
        }
    }
    class LittleCode {
        char[] numbers = {' ', '3','F', 'G', 'H', '1', '2',  '4', '5', '6', '7', '8', '9', '0', '!', '@', '#', '$', '%', '^', '&', '*', '_', '-', '+', 'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p', 'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'z', 'x', 'c', 'v', 'b', 'n', 'm', '.', ',', 'Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O', 'P', 'A', 'S', 'D', 'J', 'K', 'L', 'Z', 'X', 'C', 'V', 'B', 'N', 'M'};
        public StringBuilder numberToText (int rgbValues) {
            StringBuilder text = new StringBuilder();
            int rem;
            int num = rgbValues;
            if(num == 0) {
                text.insert(0,numbers[0]);
            }
            while(num != 0) {
                rem = num%numbers.length;
                text.insert(0, numberToChar(rem));
                num = num/numbers.length;
            }
            return text;
        }

        public int textToNumber(StringBuilder code) {
            int num = 0;
            for(int i = 0; i<code.length(); i++) {
                int temp = charToNumber(code.charAt(i));
                num = aryan(i, num) * numbers.length + temp;
            }
            return num;
        }

        public char numberToChar (int num) {
            return numbers[num];
        }

        public int charToNumber(char sym) {
            return indexOf (sym);
        }

        public int indexOf (char sym) {
            for(int i=0; i<numbers.length; i++) {
                if(numbers[i] == sym) {
                    return i;
                }
            }
            return 0;
        }

        int aryan(int i, int num) { // this function return num only if i is not 0
            if(i==0)
                return 0;
            return num;
        }
    }




    TextView OP;
    ImageView OP2;
    boolean [] Selected_Option;
    ArrayList<Integer> list_option = new ArrayList<>();
    String [] Option_array = {"Add Password","Who Can Access"};
    TextView UN;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String readData = FileHandler1.readFromFile(this, "user.txt");

        TextView vt = findViewById(R.id.UserName);

// Set the text of the TextView with the data read from the file
        vt.setText(readData);
//        FileOperations of = new FileOperations();
        UN= findViewById(R.id.UserName);
        UN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OTP();
            }
        });


//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE);

        OG = findViewById(R.id.openGallery);
        II = findViewById(R.id.importedImage);

        OG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(Intent.ACTION_PICK);
                i.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

                DH = findViewById(R.id.DHMess);
                startActivityForResult(i,gall_code);
                DH.setVisibility(View.INVISIBLE);

            }
        });
        II.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(Intent.ACTION_PICK);
                i.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

                DH = findViewById(R.id.DHMess);
                startActivityForResult(i,gall_code);
                DH.setVisibility(View.INVISIBLE);

            }
        });

        CT2 = findViewById(R.id.copyText);
        CT2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                copyToClipboard();
            }
        });

        DL=findViewById(R.id.drawerLayout);
        NV=findViewById(R.id.nav_view);
        TB=findViewById(R.id.toolBar);

        setSupportActionBar(TB);

        ActionBarDrawerToggle t=new ActionBarDrawerToggle(this,DL,TB,R.string.Open_drawer,R.string.close_drawer);
        DL.addDrawerListener(t);
        t.syncState();
        NV.setNavigationItemSelectedListener(this::onNavigationItemSelected);


        OP = findViewById(R.id.options);
        OP2= findViewById(R.id.op);
        Selected_Option= new boolean[Option_array.length];
        OP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                options();
            }
        });
        OP2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                options();
            }
        });

    }
    String message;
    String lock_image;
    public void options(){
        AlertDialog.Builder builder = new AlertDialog.Builder( MainActivity.this);
        builder.setTitle("Option");
        builder.setCancelable(false);
        builder.setMultiChoiceItems(Option_array, Selected_Option, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int o, boolean isChecked) {
                if (isChecked){
                    list_option.add(o);
                }
                else {
                    list_option.remove(o);
                }
            }});
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                StringBuilder stringBuilder = new StringBuilder( );

                for(int j=0; j < list_option.size(); j++){
                    stringBuilder.append( Option_array[list_option.get(j)] ) ;
                    message = stringBuilder.toString();

                    if (j != list_option.size() -1 ){
                        stringBuilder.append(", " ) ;}
                }

                String[] parts = message.split(",");
                if(parts.length !=2){
                    if(message.equals(Option_array[0])){
                        lock=true;
                        lock_image=" locked";
                        pass();

                    }
                    if(message.equals(Option_array[1])){
                        lock2=true;
                        wca1();
                        lock_image=" 2locked";
                    }}

                if(parts.length==2){
                    lock=true;
                    lock2=true;
                    lock_image=" 3locked";
                    pass();
                    wca1();
                }
            }});
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.setNeutralButton("Clear All", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                for (int k = 0; k<Selected_Option.length; k++) {
                    Selected_Option[k] = false;
                    list_option.clear();
                }
                lock=false;
            }
        });
        builder.show();
    }

    public void pass(){
        View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.password1, null);
        EditText PW = view.findViewById(R.id.pass);
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
        alertDialogBuilder.setView(view);
        alertDialogBuilder.setCancelable(false);
        alertDialogBuilder.setTitle("Enter Password");
        alertDialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                try {
                    String userInput = PW.getText().toString();
//                    Toast.makeText(MainActivity.this,userInput,Toast.LENGTH_SHORT).show();

                    password = Integer.parseInt(userInput);
                    password= (password*204753);

                    dialog.dismiss();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
        alertDialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                showToast("Please insert Password");
                pass();
            }

        });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();



    }
    EditText who;
    String userInput_wca;
    public void wca1(){
        View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.wca, null);
        who= view.findViewById(R.id.whocan);
        AlertDialog.Builder alertDialogBuilder1 = new AlertDialog.Builder(MainActivity.this);
        alertDialogBuilder1.setView(view);
        alertDialogBuilder1.setCancelable(false);
        alertDialogBuilder1.setTitle("Enter Name");
        alertDialogBuilder1.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                try {
                    userInput_wca = who.getText().toString();
                    Toast.makeText(MainActivity.this,userInput_wca,Toast.LENGTH_SHORT).show();
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

    StringBuilder ns;
    public void OTP(){
        View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.code, null);
        EditText c = view.findViewById(R.id.cd);
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
        alertDialogBuilder.setView(view);
        alertDialogBuilder.setCancelable(false);
        alertDialogBuilder.setTitle("Enter Code");
        alertDialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                try {
                    String userInput = c.getText().toString();
                    String[] numberStrings = userInput.split("\\s+");
                    LittleCode kk = new LittleCode();
                    ns = new StringBuilder();
                    for(int i = 0; i< numberStrings.length; i++) {
                        ns.append(kk.numberToText(Integer.parseInt(numberStrings[i])));
                    }

                    TextView tk = (TextView) findViewById(R.id.UserName);
//                    TextView tk2 = (TextView) findViewById(R.id.SUserName);

                    tk.setText(ns.toString());
//                    FileOperations fo = new FileOperations();
//                    fo.writeToFile(ns.toString());
                    FileHandler1.writeToFile(MainActivity.this, "user.txt", ns.toString());
//                    tk2.setText(ns.toString());
                    Toast.makeText(MainActivity.this,"Logged in Successfully",Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                }catch (Exception e){
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


    TextView CT;


    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode==RESULT_OK){
            if(requestCode==gall_code){
                II.setVisibility(View.VISIBLE);
                OG.setVisibility(View.INVISIBLE);
                II.setImageURI(data.getData());
                Uri imageUri = data.getData();
                try {
                    bmp = MediaStore.Images.Media.getBitmap(this.getContentResolver(), imageUri);

                }
                catch (Exception e) {
                    showToast("Couldn't Import Image");
                }

            }
//            if ( lock==true){
//                pass();
//            }

//            if(bmp.getWidth() * bmp.getHeight() > (128*128))
//                bmp = compressBitmap(bmp, 5);
//            View a= new View(MainActivity.this);
//            convert(a);
        }
    }

    Button CB ;

    private void copyToClipboard() {
        String textToCopy = CT.getText().toString().trim();
        if (!textToCopy.isEmpty()) {
            ClipboardManager clipboardManager = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
            ClipData clipData = ClipData.newPlainText("Copied Text", textToCopy);
            clipboardManager.setPrimaryClip(clipData);
            showToast("Text copied to clipboard!");
        } else {
            showToast("Nothing to copy.");
        }
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
    public void onBackPressed() {
        if (DL.isDrawerOpen(GravityCompat.START)) {
            DL.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    public void change(View view){
        iv=findViewById(R.id.imageView5);
//        String mystring= ns.toString();
        Intent inext=new Intent(MainActivity.this, SecondActivity.class);
//        inext.putExtra("keyString", mystring);
            startActivity(inext);
            OG.setVisibility(View.VISIBLE);
            DH.setVisibility(View.VISIBLE);
            CT.setVisibility(View.GONE);
            II.setVisibility(View.GONE);

    }

    public void convert(View view) {



        if(bmp!= null) {
            int[][] rgbValues = new int[bmp.getWidth()][bmp.getHeight()];
            StringBuilder code = new StringBuilder();
            Code cdd = new Code();
            for (int i = 0; i < bmp.getWidth(); i++) {
                for (int j = 0; j < bmp.getHeight(); j++) {
                    rgbValues[i][j] = bmp.getPixel(i, j);
                    code.append(String.valueOf(cdd.numberToText(rgbValues[i][j])) + " ");
                }
            }

            code.append(String.valueOf(cdd.numberToText(bmp.getWidth())) + " " + String.valueOf(cdd.numberToText(bmp.getHeight())));


            Press p = new Press();
            Code osd = new Code();
            StringBuilder ab = new StringBuilder();
            CT = findViewById(R.id.convertedText);
            if (lock==true && lock2==true){

//            ab.append((osd.numberToText(password)));
//                String mpass= String.valueOf(osd.numberToText(password));

                String mpass= String.valueOf(password);
//                ab.append(password);
                code.insert(0, ab.toString());

                CT.setVisibility(View.VISIBLE);
                arpal = p.shrink(code.toString());
//            password = 0;
                CT.setText(arpal);
                CT.append(mpass);
                CT.append(userInput_wca);
                CT.append(lock_image);
                showToast("Image converted to text.");
            } else if (lock==true) {
                //            ab.append((osd.numberToText(password)));
//                String mpass= String.valueOf(osd.numberToText(password));

                String mpass= String.valueOf(password);
//                ab.append(password);
                code.insert(0, ab.toString());
                CT.setVisibility(View.VISIBLE);
                arpal = p.shrink(code.toString());
                CT.setText(arpal);
                CT.append(mpass);
                CT.append(lock_image);
                showToast("Image converted to text.");
            }
            else if (lock2==true) {
                CT.setVisibility(View.VISIBLE);
                arpal = p.shrink(code.toString());
                CT.setText(arpal);
                CT.append(userInput_wca);
                CT.append(lock_image);
                showToast("Image converted to text.");
            }
            else{
                CT.setVisibility(View.VISIBLE);
                arpal = p.shrink(code.toString());
                CT.setText(arpal);
                showToast("Image converted to text.");
            }
//            CT.setText();
//            showToast("Image converted to text.");

        }
        else {
            showToast("Please select an image first.");

        }
    }
//    public void aconvert(View view) {
//            CT.setText(arpal);
//            showToast("Image converted to text.");
//    }




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
        } else if (itemId == R.id.nav_sign) {
            String urlToVisit = "https://secretly-ltd.github.io/web/";

            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(urlToVisit));

                startActivity(intent);

        }

        DL.closeDrawer(GravityCompat.START);
        return true;
    }

    private void showLanguageSelectionDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Select Language")
                .setItems(new CharSequence[]{"English", "हिंदी"}, new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        switch (which) {
                            case 0:
                                changeAppLanguage("en");
                                recreate();
                                break;
                            case 1:
                                changeAppLanguage("hi");
                                recreate();
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

    protected void attachBaseContext(Context newBase) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(newBase);
        String selectedLanguage = prefs.getString("selected_language", "en");

        Locale locale = new Locale(selectedLanguage);
        Configuration config = new Configuration();
        config.setLocale(locale);

        Context updatedContext = newBase.createConfigurationContext(config);
        super.attachBaseContext(updatedContext);
    }
    private Bitmap compressBitmap(Bitmap original, int quality) {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        original.compress(Bitmap.CompressFormat.JPEG, quality, stream);
        byte[] byteArray = stream.toByteArray();
        return BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);}


}