package info.androidhive.mybudget.ui.group;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import java.util.ArrayList;

import info.androidhive.mybudget.MainActivity;
import info.androidhive.mybudget.R;

public class GroupFragment extends Fragment {

    EditText name;
    View root;
    TextView textView;
    ListView listView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        root = inflater.inflate(R.layout.fragment_group, container, false);
        textView = root.findViewById(R.id.text_home);

        name = (EditText) root.findViewById(R.id.name);
        listView=(ListView)root.findViewById(R.id.listView);
        Button addParticipant = (Button)root.findViewById(R.id.addParticipant);

        final ArrayList<String> list = new ArrayList<>();

        addParticipant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String text = name.getText().toString();

                if(list.contains(text)){
                    Toast.makeText(root.getContext(),"Item already exists ",Toast.LENGTH_LONG).show();
                }

                else if(text == null || text.trim().equals("")){
                    Toast.makeText(root.getContext(),"Input empty ",Toast.LENGTH_LONG).show();
                }

                else{
                    list.add(text);
                    ArrayAdapter<String> ArrayAdapter =new ArrayAdapter<String>(root.getContext(),android.R.layout.simple_list_item_1,list);
                    listView.setAdapter(ArrayAdapter);
                    ((EditText) root.findViewById(R.id.name)).setText("");
                }

            }
        });




        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


            }
        });



        return root;
    }
}