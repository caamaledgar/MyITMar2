package com.example.myitmar2;

import static android.content.ContentValues.TAG;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myitmar2.Model.Usuarios;
import com.example.myitmar2.databinding.FragmentLoginBinding;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link loginFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class loginFragment extends Fragment {
    // bindig
    FragmentLoginBinding binding;

    // Write a message to the database
    final FirebaseDatabase database = FirebaseDatabase.getInstance();
    // Estructura de arbol para segmentar nuestra aplicacion
    final String DB_FB_NODE = "ItChina/AppMovil/Hidroponia";
    DatabaseReference dbRef = database.getReference(DB_FB_NODE);

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public loginFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment loginFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static loginFragment newInstance(String param1, String param2) {
        loginFragment fragment = new loginFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // bindig
        binding = FragmentLoginBinding.inflate(inflater, container, false);
        //binding.getName().setText(viewModel.getName());

        View view = binding.getRoot();
        return view;

        /*
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false);
         */
    }

    // bindig
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // Create a Cloud Storage reference from the app

        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertarUsuario(view);
            }
        });
    }

    public void insertarUsuario(View view){
        DatabaseReference userRef = dbRef.child("Usuarios");
        String rowUsuarios = binding.inputUsuario.getEditText().getText().toString();
        String rowPassword = binding.inputPassword.getEditText().getText().toString();
        String rowNombre   = binding.inputNombre.getEditText().getText().toString();
        String rowCorreo   = binding.inputCorreo.getEditText().getText().toString();
        String rowTelefono = binding.inputTelefono.getEditText().getText().toString();
        // Test
        //userRef.push().setValue(rowUsuarios);
        //userRef.push().setValue(rowPassword);
        // Real Objeto
        Usuarios usuarios = new
                Usuarios(dbRef.push().getKey(),
                    rowUsuarios, rowPassword, rowNombre, rowCorreo, rowTelefono);
        userRef.child(usuarios.getUid()).setValue(usuarios);
        Toast.makeText(view.getContext(),  "Registro de Usuario Exitoso", Toast.LENGTH_SHORT).show();
        binding.inputUsuario.getEditText().setText("");
        binding.inputPassword.getEditText().setText("");
        binding.inputNombre.getEditText().setText("");
        binding.inputCorreo.getEditText().setText("");
        binding.inputTelefono.getEditText().setText("");
        binding.inputUsuario.requestFocus();

    }

}