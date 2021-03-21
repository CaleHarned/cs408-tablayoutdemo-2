package edu.jsu.mcis.cs408.tablayoutdemo2;

import java.math.BigDecimal;

public class Calculator {
    private final FragmentOne parent;
    private BigDecimal leftValue;
    private BigDecimal rightValue;
    private double leftDouble;
    private BigDecimal result;
    private String op;
    private Boolean secondOp;
    private StringBuilder inputBuffer = new StringBuilder();
    private StringBuilder displayBuffer = new StringBuilder();

    public Calculator(FragmentOne parent){
        this.parent = parent;

    }
    public void process(String button) {
        if (button.equals(parent.getResources().getString(R.string.Clear))) {
            leftValue = null;
            rightValue = null;
            inputBuffer = new StringBuilder();
            displayBuffer = new StringBuilder();
        }

        if (button.equals(parent.getResources().getString(R.string._1))) {

            inputBuffer.append("1");
            displayBuffer.append("1");



        }

        if (button.equals(parent.getResources().getString(R.string._2))) {
            inputBuffer.append("2");
            displayBuffer.append("2");

        }

        if (button.equals(parent.getResources().getString(R.string._3))) {
            inputBuffer.append("3");
            displayBuffer.append("3");

        }

        if (button.equals(parent.getResources().getString(R.string._4))) {
            inputBuffer.append("4");
            displayBuffer.append("4");

        }

        if (button.equals(parent.getResources().getString(R.string._5))) {
            inputBuffer.append("5");
            displayBuffer.append("5");


        }

        if (button.equals(parent.getResources().getString(R.string._6))) {
            inputBuffer.append("6");
            displayBuffer.append("6");


        }

        if (button.equals(parent.getResources().getString(R.string._7))) {
            inputBuffer.append("7");
            displayBuffer.append("7");


        }

        if (button.equals(parent.getResources().getString(R.string._8))) {
            inputBuffer.append("8");
            displayBuffer.append("8");


        }

        if (button.equals(parent.getResources().getString(R.string._9))) {
            inputBuffer.append("9");
            displayBuffer.append("9");


        }

        if (button.equals(parent.getResources().getString(R.string._0))) {
            inputBuffer.append("0");
            displayBuffer.append("0");


        }

        if (button.equals(parent.getResources().getString(R.string.Decimal))) {
            if (!inputBuffer.toString().contains(".")) {
                inputBuffer.append(".");
                displayBuffer.append(".");


            }
        }
        if (button.equals(parent.getResources().getString(R.string.Addition))) {
            displayBuffer = new StringBuilder();
            if (leftValue == null && !inputBuffer.toString().isEmpty()) {
                op=button;
                leftValue = new BigDecimal(inputBuffer.toString());
                secondOp=true;
                inputBuffer = new StringBuilder();
            }
            else if (secondOp == true) {
                rightValue = new BigDecimal(inputBuffer.toString());
                result=this.solution();
                inputBuffer = new StringBuilder();
                leftValue=result;
                rightValue = new BigDecimal("0");
                op=button;
                displayBuffer= new StringBuilder();


            }
        }
        if (button.equals(parent.getResources().getString(R.string.Subtraction))) {
            displayBuffer = new StringBuilder();
            if (leftValue == null && !inputBuffer.toString().isEmpty()) {
                op=button;
                leftValue = new BigDecimal(inputBuffer.toString());
                secondOp=true;
                inputBuffer = new StringBuilder();
            }
            else if (secondOp == true) {
                rightValue = new BigDecimal(inputBuffer.toString());
                result=this.solution();
                inputBuffer = new StringBuilder();
                leftValue=result;
                rightValue = new BigDecimal("0");
                op=button;
                displayBuffer= new StringBuilder();


            }
        }
        if (button.equals(parent.getResources().getString(R.string.multiplication))) {
            displayBuffer = new StringBuilder();
            if (leftValue == null && !inputBuffer.toString().isEmpty()) {
                op=button;
                leftValue = new BigDecimal(inputBuffer.toString());
                secondOp=true;
                inputBuffer = new StringBuilder();
            }
            else if (secondOp == true) {
                rightValue = new BigDecimal(inputBuffer.toString());
                result=this.solution();
                inputBuffer = new StringBuilder();
                leftValue=result;
                rightValue = new BigDecimal("0");
                displayBuffer= new StringBuilder();
                op=button;


            }
        }
        if (button.equals(parent.getResources().getString(R.string.division))) {
            displayBuffer = new StringBuilder();
            if (leftValue == null && !inputBuffer.toString().isEmpty()) {
                op=button;
                leftValue = new BigDecimal(inputBuffer.toString());
                secondOp=true;
                inputBuffer = new StringBuilder();
            }
            else if (secondOp == true) {
                rightValue = new BigDecimal(inputBuffer.toString());
                result=this.solution();
                inputBuffer = new StringBuilder();
                leftValue=result;
                rightValue = new BigDecimal("0");
                op=button;
                displayBuffer= new StringBuilder();


            }
        }
        if (button.equals(parent.getResources().getString(R.string.Modulus))) {
            displayBuffer = new StringBuilder();
            if (leftValue == null && !inputBuffer.toString().isEmpty()) {
                op=button;
                leftValue = new BigDecimal(inputBuffer.toString());
                secondOp=true;
                inputBuffer = new StringBuilder();
            }
            else if (secondOp == true || (leftValue != null && !inputBuffer.toString().isEmpty())) {
                rightValue = new BigDecimal(inputBuffer.toString());
                result=this.solution();
                inputBuffer = new StringBuilder();
                leftValue=result;
                rightValue = new BigDecimal("0");
                op=button;
                displayBuffer.append(leftValue);

            }
        }
        if (button.equals(parent.getResources().getString(R.string.Sqrt))) {
            displayBuffer = new StringBuilder();
            if (leftValue == null && !inputBuffer.toString().isEmpty()) {
                leftValue = new BigDecimal(inputBuffer.toString());
                leftDouble = leftValue.doubleValue();
                leftDouble = Math.pow(leftDouble,.5);
                leftValue = BigDecimal.valueOf(leftDouble);
                displayBuffer.append(leftValue);
                inputBuffer = new StringBuilder();
            }
        }
        if (button.equals(parent.getResources().getString(R.string.plusminus))){
                if (!inputBuffer.toString().contains("-")) {
                    inputBuffer.replace(0, inputBuffer.length(), "-" + inputBuffer.toString());
                    displayBuffer = new StringBuilder(inputBuffer);
                } else {
                    inputBuffer.replace(0, inputBuffer.length(), inputBuffer.toString().replace("-", ""));
                    displayBuffer = new StringBuilder(inputBuffer);

                }
            }



        if (button.equals(parent.getResources().getString(R.string.Equals))) {
            rightValue = new BigDecimal(inputBuffer.toString());
            result = this.solution();
            displayBuffer = new StringBuilder(result.toString());
            inputBuffer = new StringBuilder();
            rightValue = new BigDecimal(0);
            secondOp = false;

        }
    }

    public BigDecimal solution(){
        if (op.equals(parent.getResources().getString(R.string.division))) {
            return leftValue.divide(rightValue);
        }
        else if (op.equals(parent.getResources().getString(R.string.Modulus))) {
            return leftValue.remainder(rightValue);
        }
        else if (op.equals(parent.getResources().getString(R.string.multiplication))) {
            return leftValue.multiply(rightValue);
        }
        else if (op.equals(parent.getResources().getString(R.string.Subtraction))) {
            return leftValue.subtract(rightValue);
        }
        else if (op.equals(parent.getResources().getString(R.string.Addition))){
            return leftValue.add(rightValue);
        }

        return null;
    }

    public String getDisplay() {
        return displayBuffer.toString();
    }
}
