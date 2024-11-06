package com.example.practic5;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class FirstFragment extends Fragment {

    private TextView textView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        textView = view.findViewById(R.id.textView);
        Button button = view.findViewById(R.id.colorButton);
        button.setOnClickListener(v -> getActivity().openContextMenu(v));
        registerForContextMenu(button);
        return view;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getActivity().getMenuInflater();
        inflater.inflate(R.menu.context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.color_red) {
            textView.setTextColor(getResources().getColor(android.R.color.holo_red_dark));
        } else if (id == R.id.color_blue) {
            textView.setTextColor(getResources().getColor(android.R.color.holo_blue_dark));
        } else if (id == R.id.color_green) {
            textView.setTextColor(getResources().getColor(android.R.color.holo_green_dark));
        }
        return true;
    }
}
