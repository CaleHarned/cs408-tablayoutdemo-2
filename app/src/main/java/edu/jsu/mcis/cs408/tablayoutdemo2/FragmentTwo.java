package edu.jsu.mcis.cs408.tablayoutdemo2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.text.DecimalFormat;

public class FragmentTwo extends Fragment implements TabFragment {

    private TextView output;
    private EditText textBill;
    private EditText textPercent;
    private EditText textNumPeople;

    private final String title = "Tip";
    private TextView outputField;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_two, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        outputField = (TextView) view.findViewById(R.id.outputField2);
        textBill = (EditText) view.findViewById(R.id.mealCost);
        textPercent = (EditText) view.findViewById(R.id.tipPercent);
        textNumPeople = (EditText) view.findViewById(R.id.numPeople);
        view.findViewById(R.id.findAmountButton).setOnClickListener(this::onClick);
    }

    public void onClick(View v) {

        double billTotal;
        double tipPercent;
        double numPeople;
        double costPerPerson;
        Toast toast = Toast.makeText(getActivity(), "Please ensure that no fields are empty and/or the values are numeric.", Toast.LENGTH_SHORT);
        DecimalFormat df = new DecimalFormat("#.00");



        try {

            billTotal = Double.parseDouble(textBill.getText().toString());
            tipPercent = Double.parseDouble(textPercent.getText().toString());
            numPeople = Double.parseDouble(textNumPeople.getText().toString());
            tipPercent  = tipPercent  * .01;
            costPerPerson = (billTotal + (billTotal * tipPercent )) / numPeople;
            costPerPerson = Double.parseDouble(df.format(costPerPerson));


            outputField.setText("$" + costPerPerson);
        }

        catch(Exception e){
            toast.show();
        }
    }

    public String getTabTitle() { return title; }

}