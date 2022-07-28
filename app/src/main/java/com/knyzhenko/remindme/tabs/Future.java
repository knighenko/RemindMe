package com.knyzhenko.remindme.tabs;

import static android.view.View.VISIBLE;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.knyzhenko.remindme.CreateTermin;
import com.knyzhenko.remindme.R;
import com.knyzhenko.remindme.adapters.RecyclerViewAdapter;
import com.knyzhenko.remindme.model.Termin;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Future#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Future extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private RecyclerView recyclerView;
    private ArrayList<Termin> termins;
    private TextView textViewFututre;

    public Future() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment2.
     */
    // TODO: Rename and change types and number of parameters
    public static Future newInstance(String param1, String param2) {
        Future fragment = new Future();
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
        // Inflate the layout for this fragment


        View view = inflater.inflate(R.layout.fragment_future, container, false);
        final FloatingActionButton addButton =(FloatingActionButton) view.findViewById(R.id.floatingActionButton3);
        addButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                Intent createTermin = new Intent(view.getContext(), CreateTermin.class);
                startActivity(createTermin);
            }
        });
        textViewFututre=view.findViewById(R.id.text_view_future);

        recyclerView = view.findViewById(R.id.recycler_view_future);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        termins = new ArrayList<>();
        Termin termin1 = new Termin(1, 2, 152154545, 2, "Title1", "Description1");
        termins.add(termin1);
        Termin termin2 = new Termin(2, 3, 312154545, 2, "Title2", "Description2");
        termins.add(termin2);
        Termin termin3 = new Termin(3, 2, 35154545, 2, "Title3", "Description3");
        termins.add(termin3);
        Termin termin4 = new Termin(4, 1, 72154545, 2, "Title4", "Description4");
        termins.add(termin4);
        Termin termin6 = new Termin(5, 2, 572154545, 2, "Title5", "Description5");
        termins.add(termin6);
        Termin termin7 = new Termin(6, 2, 152154545, 2, "Title6", "Description1");
        termins.add(termin7);
        Termin termin8 = new Termin(7, 1, 232154545, 2, "Title7", "Description1");
        termins.add(termin8);
        Termin termin9 = new Termin(8, 3, 88854545, 2, "Title8", "Description1");
        termins.add(termin9);
        if (termins !=null) textViewFututre.setVisibility(VISIBLE);
        recyclerView.setAdapter(new RecyclerViewAdapter(termins));
        return view;
    }

}