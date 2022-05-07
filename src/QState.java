public class QState {
    public String state = "NORMAL";
    public String state1 = "TIME";
    public int m = 0, h = 0, D = 1, M = 1, Y = 2000;

    public String[] input(char x) {
        if (state == "NORMAL") {
            if (x == 'C') {
                state = "UPDATE";
                state1 = "min";
            }
            if (x == 'B') {
                state = "ALARM";
                state1 = "Alarm";
            }
            if (x == 'A') {
                if (state1 == "TIME") {
                    state1 = "DATE";
                } else {
                    state1 = "TIME";
                }
            }
        }
        if (state == "UPDATE") {
            if (x == 'd') {
                state = "NORMAL";
                state1 = "TIME";
            }
            if (x == 'a') {
                if (state1 == "year") {
                    state = "NORMAL";
                    state1 = "TIME";
                }
                if (state1 == "month") {
                    state1 = "year";
                }
                if (state1 == "day") {
                    state1 = "month";
                }
                if (state1 == "hour") {
                    state1 = "day";
                }
                if (state1 == "min") {
                    state1 = "hour";
                }
            }
            if (x == 'b') {
                if (state1.equals("min")) {
                    m++;
                    if (m >= 60) {
                        m = 0;
                    }
                }
                if (state1 == "hour") {
                    h++;
                    if (h >= 24) {
                        h = 0;
                    }
                }
                if (state1 == "day") {
                    D++;
                    if (D > 31) {
                        D = 1;
                    }
                }
                if (state1 == "month") {
                    M++;
                    if (M > 12) {
                        M = 1;
                    }
                }
                if (state1 == "year") {
                    Y++;
                    if (Y > 2100) {
                        Y = 2000;
                    }
                }
            }
        }
        if (state == "ALARM") {
            if (x == 'd') {
                state = "NORMAL";
            }
            state1 = "TIME";
        if (x == 'a') {
            state1 = "Chime";
            }
        }
        return new String[]{ state, state1, String.valueOf(Y) + "-" +
                String.valueOf(M) + "-" + String.valueOf(D), String.valueOf(h) + ":" + String.valueOf(m)};
    }
}
