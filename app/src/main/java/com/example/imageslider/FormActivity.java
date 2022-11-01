package com.example.imageslider;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class FormActivity extends AppCompatActivity {

    //Declaring variables of View Types for View Components/Controls
    Button btnSubmit;

    EditText FirstName,LastName;

    EditText StreetAddress,City,Region,ZipCode,Country;

    EditText Email,PhoneNo;

    EditText Nationality,Age;

    AutoCompleteTextView Gender;
    //Array of String type for Gender selection
    String[] genderData={"Male","Female"};
    EditText Cast;

    EditText AadharCardNumber;

    EditText CountryOfBirth;

    EditText DateOfBirth;

    EditText RecentCollege;
    EditText Percentage;


    AutoCompleteTextView LevelOfProgramme, FacultyName, DepartmentName, CourseName;

    //Array of String type for "Level of Programme"
    String[] LevelOfProgrammeData={"Undergraduate Programmes","Postgraduate Programmes"};

    //Array of String type for "Faculty Name"
    String[] FacultyNameUndergraduate={"Faculty of Science","Faculty of Social Science","Faculty of Arts"};
    String[] FacultyNamePostgraduate={"Faculty of Commerce","Faculty of Management Studies","Faculty of Education","Faculty of Law","Faculty of Science","Faculty of Journalism & Mass Communication","Faculty of Social Sciences","Faculty of Vedic"};

    //Array of String type for "Department Name"
    //Undergraduate
    String[] fnUgScience={"Department of Computer Science","Department of Environment Science","Department of Food Science and Nutrition"};
    String[] fnUgSocialScience={"Department of Yogic Science and Human Consciousness"};
    String[] fnUgArts={"Department of Fine Arts"};

    //Postgraduate
    String[] fnPgCommerce={"Department of Commerce"};
    String[] fnPgManagementStudies={"Department of Management Studies","Department of Small Business Management"};
    String[] fnPgEducation={"Department of Library and Information Science"};
    String[] fnPgLaw={"Department of Law"};
    String[] fnPgScience={"Department of Computer Science","Department of Environment Science","Department of Botany","Department of Food Science and Nutrition","Department of Microbiology","Department of Zoology","Department of Mathematics","Department of Pure and Applied Chemistry","Department of Geoinformatics and Remote sensing"};
    String[] fnPgJournalism={"Department of Multimedia Technique"};
    String[] fnPgArts={"Department of Hindi","Department of Fine Arts"};
    String[] fnPgSocialScience={"Department of Geography","Department of Economics","Department of History","Department of Political Science","Department of Population Studies","Department of Yogic Science"};
    String[] fnPgVedic={"Department of Vedic Yangmaya"};



    CheckBox CheckBoxConfirmation;


    //making instance of AlertDialog.Builder Class
    AlertDialog.Builder builder;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        //Showing AlertDialog on current activity
        builder=new AlertDialog.Builder(this);

        //Binding the Submit Form Button
        btnSubmit=(Button) findViewById(R.id.btnSubmitForm);

        //Navigating page to SubmittedActivity Page
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //setting builder properties
                builder.setMessage("Do you want to Submit this Form ?");
                builder.setCancelable(true);

                //'Yes' Button Logic
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                        Intent in=new Intent(FormActivity.this,SubmittedActivity.class);
                        startActivity(in);
                        finish();
                    }
                });

                //'No' Button Logic
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                //Now Creating the Dialog Box and setting it's Title manually
                AlertDialog alert=builder.create();
                alert.setTitle("Submit Form");
                alert.show();


            }
        });





        //Binding all the View Components/Controls
        FirstName=findViewById(R.id.fName);
        LastName=findViewById(R.id.lName);

        StreetAddress=findViewById(R.id.streetAddress);
        City=findViewById(R.id.cityName);
        Region=findViewById(R.id.regionName);
        ZipCode=findViewById(R.id.zcName);
        Country=findViewById(R.id.countryName);

        Email=findViewById(R.id.emailName);
        PhoneNo=findViewById(R.id.phoneNumber);

        Nationality=findViewById(R.id.nationalityName);
        Age=findViewById(R.id.ageName);

        Gender=findViewById(R.id.GenderView);
        Cast=findViewById(R.id.castName);

        AadharCardNumber=findViewById(R.id.aadharNumber);

        CountryOfBirth=findViewById(R.id.countryBirthName);

        DateOfBirth=findViewById(R.id.dateOfBirth);

        RecentCollege=findViewById(R.id.recentCollegeName);
        Percentage=findViewById(R.id.estimatedGPApercentage);

        LevelOfProgramme=findViewById(R.id.levelOfProgramme);
        FacultyName=findViewById(R.id.facultyName);
        DepartmentName=findViewById(R.id.departmentName);
        CourseName=findViewById(R.id.courseName);



        //Calling genderList() Method to show genderData
        genderList();

        //Calling levelOfProgramme() Method here to populate LevelofProgrammeData
        LevelOfProgramme.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                    levelOfProgramme(LevelOfProgrammeData);
                return false;
            }
        });


        //Calling facultyName() Method here to populate FacultyName according to the selected LevelOfProgramme
        FacultyName.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(LevelOfProgramme.getText().toString().equals("")){
                    //Leave Empty
                }else if(LevelOfProgramme.getText().toString().equals("Undergraduate Programmes")){
                    facultyName(FacultyNameUndergraduate);
                }else if(LevelOfProgramme.getText().toString().equals("Postgraduate Programmes")){
                    facultyName(FacultyNamePostgraduate);
                }


                return false;
            }
        });

    }

    private void facultyName(String[] FacultyData) {
        //Setting Data
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.select_dialog_item, FacultyData);

        FacultyName.setAdapter(adapter);
        FacultyName.setThreshold(1);
        FacultyName.setTextColor(Color.BLACK);
        //Showing Full List on Touch Event
        FacultyName.showDropDown();
    }

    @SuppressLint("ClickableViewAccessibility")
    private void levelOfProgramme(String[] LevelOfProgrammeData) {
        //Setting Data
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.select_dialog_item, LevelOfProgrammeData);

        LevelOfProgramme.setAdapter(adapter);
        LevelOfProgramme.setThreshold(1);
        LevelOfProgramme.setTextColor(Color.BLACK);
        //Showing Full List on Touch Event
        LevelOfProgramme.showDropDown();


    }



    @SuppressLint("ClickableViewAccessibility")
    private void genderList() {
        //Setting GenderData
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.select_dialog_item, genderData);

        Gender.setAdapter(adapter);
        Gender.setThreshold(1);
        Gender.setTextColor(Color.BLACK);

        //Showing Full List on Touch Event
        Gender.setOnTouchListener((v, event) -> {
            Gender.showDropDown();
            return false;
        });
    }
}