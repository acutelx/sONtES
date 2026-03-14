import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_LOCATION_PERMISSIONS = 1;
    private static final int REQUEST_IMAGE_CAPTURE = 2;
    private Button captureButton, shareButton;
    private EditText inputField;
    private Location currentLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputField = findViewById(R.id.inputField);
        captureButton = findViewById(R.id.captureButton);
        shareButton = findViewById(R.id.shareButton);

        captureButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.CAMERA}, REQUEST_IMAGE_CAPTURE);
                } else {
                    captureImage();
                }
            }
        });

        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generateAndSharePDF();
            }
        });

        getLocation();
    }

    private void captureImage() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    private void generateAndSharePDF() {
        File pdfFile = new File(getExternalFilesDir(null), "form_data.pdf");
        try (OutputStream outputStream = new FileOutputStream(pdfFile)) {
            String data = "Input: " + inputField.getText().toString() + "\nLocation: " + currentLocation.toString();
            outputStream.write(data.getBytes());
            outputStream.flush();
            shareFile(pdfFile);
        } catch (IOException e) {
            Log.e("PDF Generation", "Failed to generate PDF", e);
            Toast.makeText(this, "Error generating PDF", Toast.LENGTH_SHORT).show();
        }
    }

    private void shareFile(File file) {
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("application/pdf");
        Uri uri = Uri.fromFile(file);
        shareIntent.putExtra(Intent.EXTRA_STREAM, uri);
        shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Form Data PDF");
        startActivity(Intent.createChooser(shareIntent, "Share PDF via..."));
    }

    private void getLocation() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_LOCATION_PERMISSIONS);
        } else {
            // Get the current location logic here
            currentLocation = new Location("dummyprovider"); // Dummy location for illustration
            currentLocation.setLatitude(0); // Example latitude
            currentLocation.setLongitude(0); // Example longitude
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_LOCATION_PERMISSIONS) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                getLocation();
            } else {
                Toast.makeText(this, "Location permission required", Toast.LENGTH_SHORT).show();
            }
        }
    }
}