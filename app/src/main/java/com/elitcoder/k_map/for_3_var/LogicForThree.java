package com.elitcoder.k_map.for_3_var;

public class LogicForThree {
    private int[][] kmapValues;

    public LogicForThree(int[][] kmapValues) {
        this.kmapValues = kmapValues;
    }

    public LogicForThree() {
    }

    public String simplifyKmap() {
        boolean[][] isGrouped = new boolean[2][4];
        StringBuilder sop = new StringBuilder();

        //Check for groups of all:
        if(kmapValues[0][0] == 1 && kmapValues[0][1] == 1 && kmapValues[0][2] == 1 && kmapValues[0][3] == 1 && kmapValues[1][0] == 1 && kmapValues[1][1] == 1 && kmapValues[1][2] == 1 && kmapValues[1][3] == 1){
            sop.append("1 + ");
            isGrouped[0][0] = isGrouped[0][1] = isGrouped[0][2] = isGrouped[0][3] = isGrouped[1][0] = isGrouped[1][1] = isGrouped[1][2] = isGrouped[1][3] = true;
        }

        // Check for groups of four:
        //First Var2,Hor2:
        if (kmapValues[0][0] == 1 && kmapValues[0][1] == 1 && kmapValues[1][0] == 1 && kmapValues[1][1] == 1 && (!isGrouped[0][0] && !isGrouped[0][1] && !isGrouped[1][0] && !isGrouped[1][1])) {
            sop.append("B' + ");
            isGrouped[0][0] = isGrouped[0][1] = isGrouped[1][0] = isGrouped[1][1] = true;
        }
        //Mid var2, hor2:
        if (kmapValues[0][1] == 1 && kmapValues[0][2] == 1 && kmapValues[1][1] == 1 && kmapValues[1][2] == 1  && (!isGrouped[0][1] && !isGrouped[0][2] && !isGrouped[1][1] && !isGrouped[1][2])) {
            sop.append("C + ");
            isGrouped[0][1] = isGrouped[0][2] = isGrouped[1][1] = isGrouped[1][2] = true;
        }
        //Last var2, hor2:
        if (kmapValues[0][2] == 1 && kmapValues[0][3] == 1 && kmapValues[1][2] == 1 && kmapValues[1][3] == 1 && (!isGrouped[0][2] && !isGrouped[0][3] && !isGrouped[1][2] && !isGrouped[1][3])) {
            sop.append("B + ");
            isGrouped[0][2] = isGrouped[0][3] = isGrouped[1][2] = isGrouped[1][3] = true;
        }

        //Upper Row:
        if (kmapValues[0][0] == 1 && kmapValues[0][1] == 1 && kmapValues[0][2] == 1 && kmapValues[0][3] == 1 && (!isGrouped[0][0] && !isGrouped[0][1] && !isGrouped[0][2] && !isGrouped[0][3])) {
            sop.append("A' + ");
            isGrouped[0][0] = isGrouped[0][1] = isGrouped[0][2] = isGrouped[0][3] = true;
        }
        //Lower Row:
        if (kmapValues[1][0] == 1 && kmapValues[1][1] == 1 && kmapValues[1][2] == 1 && kmapValues[1][3] == 1 && (!isGrouped[1][0] && !isGrouped[1][1] && !isGrouped[1][2] && !isGrouped[1][3])) {
            sop.append("A + ");
            isGrouped[1][0] = isGrouped[1][1] = isGrouped[1][2] = isGrouped[1][3] = true;
        }
        //Fold 1st and last:
        if (kmapValues[0][0] == 1 && kmapValues[1][0] == 1 && kmapValues[0][3] == 1 && kmapValues[1][3] == 1 && (!isGrouped[0][0] && !isGrouped[1][0] && !isGrouped[0][3] && !isGrouped[1][3])) {
            sop.append("C' + ");
            isGrouped[0][0] = isGrouped[1][0] = isGrouped[0][3] = isGrouped[1][3] = true;
        }

        // Check for groups of two
        //1st row:
        //1st 2:
        if (kmapValues[0][0] == 1 && kmapValues[0][1] == 1 && ((!isGrouped[0][0] && !isGrouped[0][1]) || (!isGrouped[0][0] && isGrouped[0][1]) || (isGrouped[0][0] && !isGrouped[0][1]))) {
            sop.append("A'B' + ");
            isGrouped[0][0] = isGrouped[0][1] = true;
        }
        //mid 2;
        if (kmapValues[0][1] == 1 && kmapValues[0][2] == 1 && ((!isGrouped[0][1] && !isGrouped[0][2]) || (!isGrouped[0][1] && isGrouped[0][2]) || (isGrouped[0][1] && !isGrouped[0][2]))) {
            sop.append("A'C + ");
            isGrouped[0][1] = isGrouped[0][2] = true;
        }
        //last 2:
        if (kmapValues[0][2] == 1 && kmapValues[0][3] == 1 && ((!isGrouped[0][2] && !isGrouped[0][3]) || (!isGrouped[0][2] && isGrouped[0][3]) || (isGrouped[0][2] && !isGrouped[0][3]))) {
            sop.append("A'B + ");
            isGrouped[0][2] = isGrouped[0][3] = true;
        }
        //1st and last:
        if (kmapValues[0][0] == 1 && kmapValues[0][3] == 1 && ((!isGrouped[0][0] && !isGrouped[0][3]) || (!isGrouped[0][0] && isGrouped[0][3]) || (isGrouped[0][0] && !isGrouped[0][3]))) {
            sop.append("A'C' + ");
            isGrouped[0][0] = isGrouped[0][3] = true;
        }
        //2nt row:
        //1st 2:
        if (kmapValues[1][0] == 1 && kmapValues[1][1] == 1 && ((!isGrouped[1][0] && !isGrouped[1][1]) || (!isGrouped[1][0] && isGrouped[1][1]) || (isGrouped[1][0] && !isGrouped[1][1]))) {
            sop.append("AB' + ");
            isGrouped[1][0] = isGrouped[1][1] = true;
        }
        //mid 2;
        if (kmapValues[1][1] == 1 && kmapValues[1][2] == 1 && ((!isGrouped[1][1] && !isGrouped[1][2]) || (!isGrouped[1][2] && isGrouped[1][2]) || (isGrouped[1][2] && !isGrouped[1][2]))) {
            sop.append("AC + ");
            isGrouped[1][1] = isGrouped[1][2] = true;
        }
        //last 2:
        if (kmapValues[1][2] == 1 && kmapValues[1][3] == 1 && ((!isGrouped[1][2] && !isGrouped[1][3]) || (!isGrouped[1][2] && isGrouped[1][3]) || (isGrouped[1][2] && !isGrouped[1][3]))) {
            sop.append("AB + ");
            isGrouped[1][2] = isGrouped[1][3] = true;
        }
        //1st and last:
        if (kmapValues[1][0] == 1 && kmapValues[1][3] == 1 && ((!isGrouped[1][0] && !isGrouped[1][3]) || (!isGrouped[1][0] && isGrouped[1][3]) || (isGrouped[1][0] && !isGrouped[1][3]))) {
            sop.append("AC' + ");
            isGrouped[1][0] = isGrouped[1][3] = true;
        }

        //1st 2 col:
        if (kmapValues[0][0] == 1 && kmapValues[1][0] == 1 && ((!isGrouped[0][0] && !isGrouped[1][0]) || (!isGrouped[0][0] && isGrouped[1][0]) || (isGrouped[0][0] && !isGrouped[1][0]))) {
            sop.append("B'C' + ");
            isGrouped[0][0] = isGrouped[1][0] = true;
        }
        //2nd col:
        if (kmapValues[0][1] == 1 && kmapValues[1][1] == 1 && ((!isGrouped[0][1] && !isGrouped[1][1]) || (!isGrouped[0][1] && isGrouped[1][1]) || (isGrouped[0][1] && !isGrouped[1][1]))) {
            sop.append("B'C + ");
            isGrouped[0][1] = isGrouped[1][1] = true;
        }
        //3rd Col:
        if (kmapValues[0][2] == 1 && kmapValues[1][2] == 1 && ((!isGrouped[0][2] && !isGrouped[1][2]) || (!isGrouped[0][2] && isGrouped[1][2]) || (isGrouped[0][2] && !isGrouped[1][2]))) {
            sop.append("BC + ");
            isGrouped[0][2] = isGrouped[1][2] = true;
        }
        //4th Col:
        if (kmapValues[0][3] == 1 && kmapValues[1][3] == 1 && ((!isGrouped[0][3] && !isGrouped[1][3]) || (!isGrouped[0][3] && isGrouped[1][3]) || (isGrouped[0][3] && !isGrouped[1][3]))) {
            sop.append("BC' + ");
            isGrouped[0][3] = isGrouped[1][3] = true;
        }


        // Check for single cells
        if (kmapValues[0][0] == 1 && !isGrouped[0][0]) {
            sop.append("A'B'C' + ");
        }

        if (kmapValues[0][1] == 1 && !isGrouped[0][1]) {
            sop.append("A'B'C + ");
        }

        if (kmapValues[0][2] == 1 && !isGrouped[0][2]) {
            sop.append("A'BC+ ");
        }

        if (kmapValues[0][3] == 1 && !isGrouped[0][3]) {
            sop.append("A'BC' + ");
        }
        if (kmapValues[1][0] == 1 && !isGrouped[1][0]) {
            sop.append("AB'C' + ");
        }

        if (kmapValues[1][1] == 1 && !isGrouped[1][1]) {
            sop.append("AB'C + ");
        }

        if (kmapValues[1][2] == 1 && !isGrouped[1][2]) {
            sop.append("ABC+ ");
        }

        if (kmapValues[1][3] == 1 && !isGrouped[1][3]) {
            sop.append("ABC' + ");
        }

        // Remove trailing " + "
        if (sop.length() > 0) {
            sop.setLength(sop.length() - 3);
        }

        return sop.toString();
    }
}
