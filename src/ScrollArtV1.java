import java.util.Random;

public class ScrollArtV1 {
static final int WIDTH = getTerminalWidth() ;
static final int GIRAFEE_WIDTH = 54;
static final int GIRAFEE_HEIGHT = 33;
static final Random rand = new Random();

    public static void main(String[] args) throws InterruptedException {
        char[][] nextRows = new char[GIRAFEE_HEIGHT][WIDTH];
        long startTime = System.currentTimeMillis();
        int iterations = 0;
    
        for (int i = 0; i < nextRows.length; i++) {
            nextRows[i] = emptyRow();
           
        }
    
      
    
    
        while (true) {
            // At each column on the top row, 1% chance to add a new image
            for (int x = 0; x <= WIDTH - GIRAFEE_WIDTH; x++) {
                if (rand.nextDouble() < 0.001 && canPlaceImage(nextRows, x)) {
                    loadNextRowsWithImage(nextRows, x);
                }
            }
            // Print and remove the top row
            System.out.println(new String(nextRows[0]));
            // Shift all rows uP
            shiftRowsUp(nextRows);
            Thread.sleep(40); // Delay in ms
            long time = System.currentTimeMillis() - startTime;
            iterations++;
        }
    }
        
        private static void loadNextRowsWithImage(char[][] nextRows, int x) {
            char[][] img;
            if (rand.nextBoolean()) {
                img = getGiraffe();
            } else {
                img = getElephant();
            }
            for (int iy = 0; iy < GIRAFEE_HEIGHT; iy++) {
                for (int ix = 0; ix < GIRAFEE_WIDTH; ix++) {
                    if (x + ix < WIDTH && img[iy][ix] != ' ') {
                        nextRows[iy][x + ix] = img[iy][ix];
                    }
                }
            }
            }
        
    

    

        
     

    static void shiftRowsUp(char[][] nextRows) {
        for (int i = 1; i < nextRows.length; i++) {
            nextRows[i - 1] = nextRows[i];
        }
        nextRows[nextRows.length - 1] = emptyRow();
    }

    static char[] emptyRow() {
        char[] row = new char[WIDTH];
        for (int i = 0; i < WIDTH; i++) {
            row[i] = ' ';
        }
        return row;
    }
    private static boolean canPlaceImage(char[][] nextRows, int x) {
        for (int y = 0; y < GIRAFEE_HEIGHT; y++) {
            for (int ix = 0; ix < GIRAFEE_WIDTH; ix++) {
                if (x + ix < WIDTH && nextRows[y][x + ix] != ' ') {
                    return false;
                }
            }
        }
        return true;
    }

   
    static char[][] getGiraffe() {
        char[][] img = new char[GIRAFEE_HEIGHT][GIRAFEE_WIDTH];
        // fill with empty space
        for (int y = 0; y < GIRAFEE_HEIGHT; y++) {
            for (int x = 0; x < GIRAFEE_WIDTH; x++) {
                img[y][x] = ' ';
            }
        }
        // then fill individual characters
        img[1][12] = 'o';
        img[2][10] = 'o';
        img[2][11] = 'o';
        img[2][13] = 'o';
        img[2][14] = 'o';
        img[2][15] = 'o';
        img[3][10] = 'o';
        img[3][16] = 'o';
        img[4][10] = 'o';
        img[4][14] = '0';
        img[4][16] = 'o';
        img[4][17] = 'o';
        img[5][18] = 'o';
        img[5][10] = 'o';
        img[5][11] = 'x';
        img[5][12] = 'x';
        img[5][17] = 'o';
        img[5][18] = 'o';
        img[5][19] = 'o';
        img[6][10] = 'o';
        img[6][11] = 'x';
        img[6][12] = 'x';
        img[6][14] = 'x';
        img[6][15] = 'x';
        img[6][16] = 'x';
        img[6][17] = 'x';
        img[6][20] = 'o';
        img[6][21] = 'o';
        img[6][22] = 'o';
        img[7][10] = 'o';
        img[7][11] = 'x';
        img[7][12] = 'x';
        img[7][15] = 'x';
        img[7][16] = 'x';
        img[7][19] = 'x';
        img[7][20] = 'x';
        img[7][21] = 'x';
        img[7][22] = 'o';
        img[7][23] = 'o';
        img[8][10] = 'o';
        img[8][19] = 'x';
        img[8][20] = 'x';
        img[8][21] = 'x';
        img[8][22] = 'o';
        img[8][10] = 'o';
        img[9][10] = 'o';
        img[9][14] = 'o';
        img[9][15] = 'o';
        img[9][16] = 'o';
        img[9][17] = 'o';
        img[9][18] = 'o';
        img[9][19] = 'o';
        img[9][20] = 'o';
        img[10][10] = 'o';
        img[10][12] = 'x';
        img[10][13] = 'o';
        img[10][14] = 'o';
        img[10][15] = 'o';
        img[11][10] = 'o';
        img[11][11] = 'x';
        img[11][13] = 'o';
        img[12][10] = 'o';
        img[12][11] = 'x';
        img[12][13] = 'o';
        img[13][10] = 'o';
        img[13][12] = 'x';
        img[13][13] = 'o';
        img[14][10] = 'o';
        img[14][12] = 'x';
        img[14][11] = 'x';
        img[14][13] = 'o';
        img[15][10] = 'o';
        img[15][12] = 'x';
        img[15][13] = 'o';
        img[16][10] = 'o';
        img[16][13] = 'o';
        img[17][10] = 'o';
        img[17][12] = 'x';
        img[17][11] = 'x';
        img[17][13] = 'o';
        img[18][10] = 'o';
        img[18][12] = 'x';
        img[18][11] = 'x';
        img[18][13] = 'o';
        img[19][10] = 'o';
        img[19][12] = 'x';
        img[19][14] = 'o';
        img[19][13] = 'o';
        img[20][4] = 'o';
        img[20][5] = 'o';
        img[20][6] = 'o';
        img[20][7] = 'o';
        img[20][8] = 'o';
        img[20][9] = 'o';
        img[20][10] = 'o';
        img[20][13] = 'o';
        img[20][14] = 'o';
        img[20][15] = 'o';
        img[21][2] = 'o';
        img[21][3] = 'o';
        img[21][4] = 'x';
        img[21][5] = 'x';
        img[21][6] = 'x';
        img[21][11] = 'o';
        img[21][12] = 'o';
        img[21][13] = 'o';
        img[21][14] = 'o';
        img[21][15] = 'o';
        img[22][1] = 'o';
        img[22][2] = 'x';
        img[22][3] = 'x';
        img[22][5] = 'x';
        img[22][6] = 'x';
        img[22][12] = 'x';
        img[22][13] = 'x';
        img[22][14] = 'x';
        img[22][15] = 'o';
        img[22][16] = 'o';
        img[23][0] = 'o';
        img[23][2] = 'x';
        img[23][6] = 'x';
        img[23][7] = 'x';
        img[23][17] = 'o';
        img[24][0] = 'o';
        img[24][1] = 'x';
        img[24][2] = 'x';
        img[24][6] = 'x';
        img[24][7] = 'x';
        img[24][8] = 'x';
        img[24][9] = 'x';
        img[24][12] = 'x';
        img[24][13] = 'x';
        img[24][14] = 'x';
        img[24][15] = 'x';
        img[24][16] = 'x';
        img[24][17] = 'o';
        img[25][0] = 'o';
        img[25][7] = 'x';
        img[25][8] = 'x';
        img[25][13] = 'x';
        img[25][14] = 'x';
        img[25][15] = 'x';
        img[25][16] = 'o';
        img[26][1] = 'o';
        img[26][2] = 'o';
        img[26][3] = 'o';
        img[26][4] = 'o';
        img[26][5] = 'o';
        img[26][6] = 'o';
        img[26][7] = 'o';
        img[26][8] = 'o';
        img[26][9] = 'o';
        img[26][10] = 'o';
        img[26][11] = 'o';
        img[26][12] = 'o';
        img[26][13] = 'o';
        img[26][14] = 'o';
        img[26][15] = 'o';
        img[27][1] = 'o';
        img[27][2] = 'o';
        img[27][4] = 'o';
        img[27][5] = 'o';
        img[27][10] = 'o';
        img[27][11] = 'o';
        img[27][14] = 'o';
        img[27][15] = 'o';
        img[28][1] = 'o';
        img[28][2] = 'o';
        img[28][4] = 'o';
        img[28][5] = 'o';
        img[28][10] = 'o';
        img[28][11] = 'o';
        img[28][14] = 'o';
        img[28][15] = 'o';
        img[29][1] = 'o';
        img[29][2] = 'o';
        img[29][4] = 'o';
        img[29][5] = 'o';
        img[29][10] = 'o';
        img[29][11] = 'o';
        img[29][14] = 'o';
        img[29][15] = 'o';
        img[30][1] = 'o';
        img[30][2] = 'o';
        img[30][4] = 'o';
        img[30][5] = 'o';
        img[30][10] = 'o';
        img[30][11] = 'o';
        img[30][14] = 'o';
        img[30][15] = 'o';
        img[31][1] = 'o';
        img[31][2] = 'o';
        img[31][4] = 'o';
        img[31][5] = 'o';
        img[31][10] = 'o';
        img[31][11] = 'o';
        img[31][14] = 'o';
        img[31][15] = 'o';
        img[32][1] = 'o';
        img[32][2] = 'o';
        img[32][4] = 'o';
        img[32][5] = 'o';
        img[32][10] = 'o';
        img[32][11] = 'o';
        img[32][14] = 'o';
        img[32][15] = 'o';
    
      
      



    

        
        
    

        return img;
    }


      static char[][] getElephant() {
          char[][] img = new char[GIRAFEE_HEIGHT][GIRAFEE_WIDTH];
          // fill with empty space
          for (int y = 0; y < GIRAFEE_HEIGHT; y++) {
              for (int x = 0; x < GIRAFEE_WIDTH; x++) {
            img[y][x] = ' ';
              }
          }
          // then fill individual characters
         img[0][38] = '_';
         img[0][39] = '_';
         img[0][45] = '_';
         img[0][46] = '_';
         img[1][40] = '\\';
         img[1][41] = '~';
         img[1][42] = '~';
         img[1][43] = '~';
         img[1][44] = '/';
         img[1][47] = '\\';
         img[2][33] = '\'';
         img[2][34] = '-';
         img[2][35] = '-';
         img[2][36] = '-';
         img[2][37] = '-';
         img[2][38] = '(';
         img[2][42] = '.';
         img[2][43] = '.';
         img[2][48] = ')';
         img[3][32] = '/';
         img[3][49] = '\\';
         img[3][40] = '_';
         img[3][41] = '_';
         img[3][44] = '_';
         img[3][45] = '_';
         img[4][31] = '/';
         img[4][32] = '|';
         img[4][42] = '\\';
         img[4][44] = '|';
         img[4][45] = '(';
         img[5][30] = '/';
         img[5][32] = '\\';
         img[5][37] = '/';
         img[5][39] = '\\';
         img[5][42] = '/';
         img[5][43] = '\\';
         img[5][44] = '|';
         img[5][45] = '(';
         img[6][30] = '^';
         img[6][32] = '|';
         img[6][34] = '_';
         img[6][35] = '_';
         img[6][37] = '|';
         img[6][40] = '|';
         img[6][41] = '_';
         img[6][42] = '_';
         img[6][43] = '|';
         img[6][44] = '-';
         img[6][45] = '"';
         



      




         return img;
       }

    public static int getTerminalWidth() {
        String os = System.getProperty("os.name").toLowerCase();

        if (os.contains("nix") || os.contains("nux") || os.contains("mac")) {
            return getUnixTerminalWidth();
        } else {
            return 80; // fallback for unknown OS
        }
    }
    
    private static int getUnixTerminalWidth() {
        try {
            // Try to get terminal size from environment variables first
            String columns = System.getenv("COLUMNS");
            if (columns != null && !columns.isEmpty()) {
                return Integer.parseInt(columns);
            }

            // Fallback to stty command
            ProcessBuilder pb = new ProcessBuilder("/bin/sh", "-c", "stty size </dev/tty");
            pb.redirectErrorStream(true);
            Process process = pb.start();
            java.io.BufferedReader reader = new java.io.BufferedReader(
                    new java.io.InputStreamReader(process.getInputStream()));
            String output = reader.readLine();
            if (output != null && !output.isEmpty()) {
                String[] parts = output.trim().split(" ");
                return Integer.parseInt(parts[1]); // columns
            }
        } catch (Exception ignored) {
            // Silently ignore errors and fall back to default
        }
        return 80; // fallback
    }
    }
  