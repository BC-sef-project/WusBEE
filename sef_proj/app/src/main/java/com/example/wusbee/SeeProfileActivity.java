package com.example.wusbee;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.Instrumentation;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import jp.wasabeef.picasso.transformations.CropCircleTransformation;

public class SeeProfileActivity extends AppCompatActivity {

    private static final int RESULT_LOAD_IMAGE = 1;
    Uri selectedImageUri;
    //activity objects
    Button joinTeam;
    Button createTeam;
    Button editProfile;

    //profile objects
    ImageView profileImage;
    TextView profileName;
    TextView profileSkills;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see_profile);

        joinTeam = findViewById(R.id.join_team);
        createTeam = findViewById(R.id.create_team);
        editProfile = findViewById(R.id.edit_profile);

        profileImage = findViewById(R.id.profile_img);
        profileName = findViewById(R.id.full_name);
        profileSkills = findViewById(R.id.show_hard_skills);

        editProfile.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("InflateParams")
            @Override
            public void onClick(View v) {

                final Dialog dialog = new Dialog(SeeProfileActivity.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setCancelable(true);
                dialog.setContentView(R.layout.edit_profile_dialog);

                final EditText setName = dialog.findViewById(R.id.get_name_to_show);
                final EditText setSkill = dialog.findViewById(R.id.get_new_skill_to_show);
                final Button setImage = dialog.findViewById(R.id.get_new_image);
                Button submit = dialog.findViewById(R.id.ok_dialog);
                Button cancel = dialog.findViewById(R.id.cancel_dialog);
                dialog.show();

                setImage.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                            Intent galleryIntent = new Intent(Intent.ACTION_PICK, MediaStore.
                                    Images.Media.EXTERNAL_CONTENT_URI);
                            startActivityForResult(galleryIntent, RESULT_LOAD_IMAGE);
                    }
                });

                submit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String newName = setName.getText().toString();
                        editName(newName);

                        String newSkill = setSkill.getText().toString();
                        editSkills(newSkill);

                        editProfileImage(selectedImageUri);

                        dialog.cancel();

                    }
                });

                cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.cancel();
                    }
                });


            }
        });
    }

    private void editProfileImage(Uri selectedImageUri) {
        Picasso.get().load(selectedImageUri).transform(new CropCircleTransformation()).into(profileImage);
    }

    public void editName(String newName){

        if(newName!=null){
            profileName.setVisibility(View.VISIBLE);
            profileName.setText(newName);
        }
    }

    @SuppressLint("SetTextI18n")
    public void editSkills(String newSkill) {

        if(newSkill != null){
            String oldSkills = profileSkills.getText().toString() + ", ";
            profileSkills.setText(oldSkills + newSkill);
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == RESULT_LOAD_IMAGE && data != null){
            // Get the url of the image from data
            selectedImageUri = data.getData();
        }
    }

}