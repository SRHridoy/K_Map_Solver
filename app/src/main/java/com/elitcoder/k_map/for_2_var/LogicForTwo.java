package com.elitcoder.k_map.for_2_var;

public class LogicForTwo {
    private int[] kmapValues;
    public LogicForTwo(int[] kmapValues) {
        this.kmapValues = kmapValues;
    }

    public LogicForTwo() {
    }

    //Simplify Logic:
    public String simplifyKmap() {
        boolean[] isGrouped = new boolean[4];
        StringBuilder sop = new StringBuilder();

        // Check for groups of four:
        if (kmapValues[0] == 1 && kmapValues[1] == 1 && kmapValues[2] == 1 && kmapValues[3] == 1) {
            sop.append("1 + ");
            isGrouped[0] = isGrouped[1] = isGrouped[2] = isGrouped[3] = true;
        }


        // Check for groups of two
        //1st row:
        if (kmapValues[0] == 1 && kmapValues[1] == 1 && ((!isGrouped[0] && !isGrouped[1]) || (!isGrouped[0] && isGrouped[1]) || (isGrouped[0] && !isGrouped[1]))) {
            sop.append("A' + ");
            isGrouped[0] = isGrouped[1] = true;
        }
        //2nd Row:
        if (kmapValues[2] == 1 && kmapValues[3] == 1 && ((!isGrouped[2] && !isGrouped[3]) || (!isGrouped[2] && isGrouped[3]) || (isGrouped[2] && !isGrouped[3]))) {
            sop.append("A + ");
            isGrouped[2] = isGrouped[3] = true;
        }

        //1st col:
        if (kmapValues[0] == 1 && kmapValues[2] == 1 && ((!isGrouped[0] && !isGrouped[2]) || (!isGrouped[0] && isGrouped[2]) || (isGrouped[0] && !isGrouped[2]))) {
            sop.append("B' + ");
            isGrouped[0] = isGrouped[2] = true;
        }
        //2nd col:
        if (kmapValues[1] == 1 && kmapValues[3] == 1 && ((!isGrouped[1] && !isGrouped[3]) || (!isGrouped[1] && isGrouped[3]) || (isGrouped[1] && !isGrouped[3]))) {
            sop.append("B + ");
            isGrouped[1] = isGrouped[3] = true;
        }


        // Check for single cells
        if (kmapValues[0] == 1 && !isGrouped[0]) {
            sop.append("A'B' + ");
        }
        if (kmapValues[1] == 1 && !isGrouped[1]) {
            sop.append("A'B + ");
        }
        if (kmapValues[2] == 1 && !isGrouped[2]) {
            sop.append("AB' + ");
        }
        if (kmapValues[3] == 1 && !isGrouped[3]) {
            sop.append("AB + ");
        }

        // Remove trailing " + "
        if (sop.length() > 0) {
            sop.setLength(sop.length() - 3);
        }

        return sop.toString();
    }
}
