package id.sch.smktelkom_mlg.tugas01.xirpl3007.peminjamanbuku1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tvHasil, tvHasil2, tvhasil3;
    RadioGroup rg;
    CheckBox cb1, cb2, cb3;
    EditText etinput;
    Spinner spjudul;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvHasil = (TextView) findViewById(R.id.textViewHasil);
        tvHasil2 = (TextView) findViewById(R.id.textView2);
        tvhasil3 = (TextView) findViewById(R.id.textView3);
        rg = (RadioGroup) findViewById(R.id.rgpilihan);
        cb1 = (CheckBox) findViewById(R.id.checkBoxbk);
        cb2 = (CheckBox) findViewById(R.id.checkBoxkm);
        cb3 = (CheckBox) findViewById(R.id.checkBoxmj);
        etinput = (EditText) findViewById(R.id.editTextinput);
        spjudul = (Spinner) findViewById(R.id.spinnerJudul);

        findViewById(R.id.buttonOK).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doClick();
                etinput.setText("");
            }
        });
    }

    private void doClick() {
        String hasil = "Tidak ada Masukan";
        if (rg.getCheckedRadioButtonId() != -1) {
            RadioButton rB = (RadioButton)
                    findViewById(rg.getCheckedRadioButtonId());
            hasil = rB.getText().toString();
        }
        if (hasil == null) {
            tvHasil.setText("Belum memilih ");
        } else {
            tvHasil.setText("Masukkan pilihan Anda : " + hasil);
        }

        String hasil2 = " \n\nTambah Masa Pinjam selama : \n";
        int startlen = hasil2.length();
        if (cb1.isChecked()) hasil2 += cb1.getText() + "\n";
        if (cb2.isChecked()) hasil2 += cb2.getText() + "\n";
        if (cb3.isChecked()) hasil2 += cb3.getText() + "\n";

        if (hasil2.length() == startlen) hasil2 += " Tidak ada ";

        if (isValid()) ;
        String input = etinput.getText().toString();
        tvHasil.setText("Peminjaman Buku : " + hasil + " " + hasil2);
        tvHasil2.setText(("Judul Buku : " +
                spjudul.getSelectedItem().toString()));
        tvhasil3.setText("Nama Peminjam : " + input);
    }

    private boolean isValid() {
        boolean valid = true;

        String input = etinput.getText().toString();

        if (input.isEmpty()) {
            etinput.setError("Nama Belum diisi");
        } else {
            etinput.setError(null);
        }
        return valid;
    }
}

