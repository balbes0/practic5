package com.example.practic5;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;

public class SecondFragment extends Fragment {
    private TextView textView;
    private int counter = 0;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_second, container, false);
        textView = view.findViewById(R.id.textView);
        Button button = view.findViewById(R.id.button);
        button.setOnClickListener(v -> {
            PopupMenu popupMenu = new PopupMenu(getActivity(), v);
            MenuInflater inflaterMenu = getActivity().getMenuInflater();
            inflaterMenu.inflate(R.menu.popup_men, popupMenu.getMenu());
            popupMenu.setOnMenuItemClickListener(item -> {
                if (item.getItemId() == R.id.increase_counter_5) {
                    counter = counter + 5;
                    textView.setText(String.valueOf(counter));
                } else if (item.getItemId() == R.id.decrease_counter_5){
                    counter = counter - 5;
                    textView.setText(String.valueOf(counter));
                }

                return true;
            });
            popupMenu.show();
        });

        return view;
    }
}