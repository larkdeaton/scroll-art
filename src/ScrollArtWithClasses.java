import java.util.Random;

public class ScrollArtWithClasses {
    static final int WIDTH = getTerminalWidth() ;
    static final int BUNNY_WIDTH = 8;
    static final int BUNNY_HEIGHT = 6;
    static final Random rand = new Random();

    public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis();
        int iterations = 0;
        char[][] nextRows = new char[70][WIDTH]; // store upcoming rows
        for (int i = 0; i < nextRows.length; i++) {
            nextRows[i] = emptyRow();
        }

        char[] prevRow = nextRows[0];
        while (true) {
            // At each column on the top row, 1% chance to add a new image
            for (int x = 0; x < WIDTH - 34; x += 34) {
                if (isBlank(prevRow, x) && rand.nextDouble() < 0.08) {
                    loadNextRowsWithImage(nextRows, x);
                }
            }
            // Print and remove the top row
            System.out.println(new String(nextRows[0]));
            prevRow = nextRows[0];
            // Shift all rows up
            shiftRowsUp(nextRows);
            Thread.sleep(100); // Delay in ms
            long time = System.currentTimeMillis() - startTime;
            iterations++;
            // System.err.println("average time per frame: " + (time / iterations) + " ms");
        }
    }

    private static boolean isBlank(char[] prevRow, int x) {
        for (int i = x; i < x + 34; i++) {
            if (prevRow[i] != ' ') {
                return false;
            }
        }
        return true;
    }

    private static void loadNextRowsWithImage(char[][] nextRows, int x) {
        // char[][][] images;
    

        AsciiArt[] images = { new AsciiArt(getGiraffe()), new AsciiArt(getBigFish()),
                new AsciiArt(getElephant()), new AsciiArt(getPenguin()), new AsciiArt(getCat()) };
       
        AsciiArt art = images[rand.nextInt(images.length)];
        AsciiArt widestArt = AsciiArt.getWidestArt(images);
        art.resize(widestArt.width);

        for (int iy = 0; iy < art.height; iy++) { // height
            for (int ix = 0; ix < art.width; ix++) { // widrth
                nextRows[iy][x + ix] = art.img[iy][ix];
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

    public static char[][] getGiraffe() {
        char[][] img = new char[35][54];
        // fill with empty space
        for (int y = 0; y < 35; y++) {
            for (int x = 0; x < 54; x++) {
                img[y][x] = ' ';
            }
        }
        // then fill individual characters
        img[1][12] = 'o'; //added all this to code for the giraffe
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
        img[33][0] = 'L';
        img[33][1] = 'E';
        img[33][2] = 'D';

    
      
      



    

        
        
    

        return img;
    }
    
    static char [][] getCat() {
        char[][] img = new char[26][58];
        for (int y = 0; y < 26; y++){
            for (int x = 0; x < 58; x++) {
                img[y][x] = ' ';
            }
        }
        //individual character
        img[0][2]  =',';
        img[0][3]  ='-';
        img[0][4]  ='\'';
        img[0][5]  ='-';
        img[0][6]  ='_';
        img[0][7]  ='_';
        img[0][29] = '_';
        img[0][30] = '-';
        img[0][31] = '\'';
        img[0][32] = '-';
        img[0][33] = ',';
        img[1][2] = '|';
        img[1][8] = '\'';
        img[1][9] = '-';
        img[1][10] = ',';
        img[1][11] = '_';
        img[1][12] = ';';
        img[1][13] = '-';
        img[1][14] = '^';
        img[1][15] = '-';
        img[1][16] = '-';
        img[1][17] = '^';
        img[1][18] = '-';
        img[1][19] = '-';
        img[1][20] = '^';
        img[1][21] = '-';
        img[1][22] = '-';
        img[1][23] = '^';
        img[1][24] = '-';
        img[1][25] = '-';
        img[1][26] = ';';
        img[1][27] = '-';
        img[1][28] = '\'';
        img[1][33] = '|';
        img[2][2] = '\'';
        img[2][9] = ';';
        img[2][27] = '\\';
        img[2][33] = '/';
        img[3][3] = '\'';
        img[3][4] = '_';
        img[3][8] = ';';
        img[3][28] = '\'';
        img[3][32] = '/';
        img[4][5]= '\'';
        img[4][6]= '_';
        img[4][7]= ';';
        img[4][29]= '\'';
        img[4][30]= '-';
        img[4][31]= '\'';
        img[5][7]= '|';
        img[5][11] = '-';
        img[5][12] = '-';
        img[5][13] = '-';
        img[5][23] = '-';
        img[5][24] = '-';
        img[5][31] = '\\';
        img[6][6] = '>';
        img[6][7] = '{';
        img[6][18] = '/';
        img[6][19] = '\\';
        img[6][31] = '}';
        img[6][32] = '<';
        img[7][8] = '\'';
        img[7][9] = '_';
        img[7][30] = '/';
        img[8][9] = '\'';
        img[8][10] = '_';
        img[8][29] = '/';
        img[9][11] = '\'';
        img[9][12] = '-';
        img[9][29] = '-';
        img[9][30] = '-';
        img[9][31] = '_';
        img[10][2] = '_';
        img[10][3] = '_';
        img[10][4] = '_';
        img[10][5] = '_';
        img[10][11] = '.';
        img[10][12] = '\'';   
        img[10][32] = '\\';
        img[10][51] = ',';
        img[10][52] = '_';
        img[10][53] = '_';
        img[10][54] = '_';
        img[10][55] = ',';
        img[11][1] = '/';
        img[11][6] = '\\';
        img[11][10] = '/';
        img[11][33] = '|';
        img[11][50] = '/';
        img[11][56] = '\\';
        img[12][1] = '\'';
        img[12][2] = '-';
        img[12][3] = '.';
        img[12][4] = '_';
        img[12][7] = '\'';
        img[12][8] = '-';
        img[12][9] = '-';
        img[12][10] = '|';
        img[12][26] = '_';
        img[12][27] = '_';
        img[12][28] = '_';
        img[12][29] = '_';
        img[12][34] = '\\';
        img[12][49] = ';';
        img[12][56] = '|';
        img[13][5] = '\\';
        img[13][11] = '\\';
        img[13][24] = '.';
        img[13][25] = '\'';
        img[13][35] = '|';
        img[13][48] = '/';
        img[13][54] = ',';
        img[13][55] = '_';
        img[13][56] = '/';
        img[14][6] = '\'';
        img[14][7] = '-';
        img[14][8] = '-';
        img[14][9] = '.';
        img[14][10] = '_';
        img[14][11] = '_';
        img[14][12] = '\\';
        img[14][24] = '|';
        img[14][29] = '_';
        img[14][35] = '|';
        img[14][47] = '/';
        img[14][53] = '/';
        img[15][13] = '|';
        img[15][24] = '|';
        img[15][28] = '|';
        img[15][36] = '\\';
        img[15][46] = '/';
        img[15][52] = '/';
        img[16][14] = '\\';
        img[16][24] = '\\';
        img[16][28] = '\\';
        img[16][37] = '|';
        img[16][45] = '/';
        img[16][51] = '/';
        img[17][14] = '|';
        img[17][25] = '\'';
        img[17][26] = '-';
        img[17][27] = '-';
        img[17][28] = '\'';
        img[17][37] = '|';
        img[17][44] = '/';
        img[17][50] = '/';
        img[18][15] = '|';
        img[18][37] = '|';
        img[18][42] = '_';
        img[18][43] = '/';
        img[18][49] = '/';
        img[19][15] = '|';
        img[19][38] = '\\';
        img[19][40] = '.';
        img[19][41] = '\'';
        img[19][48] = '/';
        img[20][14] = '_';
        img[20][15] = '|';
        img[20][38] = '|';
        img[20][39] = '/';
        img[20][46] = '_';
        img[20][47] = '/';
        img[21][12] = '_';
        img[21][13] = '/';
        img[21][44] = '.';
        img[21][45] = '\'';
        img[22][11] = '/';
        img[22][40] = '_';
        img[22][41] = '_';
        img[22][42] = '_';
        img[22][43] = '/';
        img[23][5] = ',';
        img[23][6] = '_';
        img[23][7] = '_';
        img[23][8] = '_';
        img[23][9] = '/';
        img[23][27] = ',';
        img[23][28] = '_';
        img[23][29] = '_';
        img[23][30] = '_';
        img[23][31] = '_';
        img[23][32] = '_';
        img[23][39] = '/';
        img[23][49] = 'C';
        img[23][50] = 'K';
        img[24][4] = '/';
        img[24][26] = '/';
        img[24][38] = '/';
        img[25][4] = '\\';
        img[25][5] = '_';
        img[25][6] = '_';
        img[25][7] = '_';
        img[25][8] = '_';
        img[25][9] = '_';
        img[25][10] = '_';
        img[25][11] = '_';
        img[25][12] = '_';
        img[25][13] = '_';
        img[25][14] = '_';
        img[25][15] = ',';
        img[25][16] = '-';
        img[25][17] = '-';
        img[25][18] = '-';
        img[25][19] = '-';
        img[25][20] = '-';
        img[25][21] = ';';
        img[25][22] = '_';
        img[25][23] = '_';
        img[25][24] = '_';
        img[25][25] = '_';
        img[25][26] = '\\';
        img[25][27] = '_';
        img[25][28] = '_';
        img[25][29] = '_';
        img[25][30] = '_';
        img[25][31] = '_';
        img[25][32] = '_';
        img[25][33] = '_';
        img[25][34] = '_';
        img[25][35] = '_';
        img[25][36] = '_';
        img[25][37] = '/';
        return img;
    }

    static char[][] getElephant() {
        char[][] img = new char[35][54];
        // fill with empty space
        for (int y = 0; y < 35; y++) {
            for (int x = 0; x < 54; x++) {
          img[y][x] = ' ';
            }
        }
        // then fill individual characters
       img[0][38] = '_'; //added for elephant, its shifted over to prevent overlaps when i wasn't looping it
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

    // rename your function here

            static char[][] getPenguin() {
            char[][]img=new char [40][45];
            for(int y=0; y<40; y++ ){
                for(int x=0; x<45; x++){
                    img[y][x]=' ';
                }
            }
            // outer body
            
            for(int i = 14; i <= 24; i++){
                img[1][i] = '_';
            }
    
            
    
            img[2][13] = '/';
            img[3][12] = '/';
            img[3][11] = '_';
            img[4][10] = '/';
            img[5][9] = '/';
            img[6][8] = '/';
            img[7][7] = '/';
            img[8][6] = '/';
            img[9][6] = '|';
            img[10][6] = '|';
            img[11][6] = '|';
            img[12][7] = '\\';
            img[13][8] = '\\';
            img[14][8] = '/';
            img[15][7] = '/';
            img[16][6] = '/';
            img[17][5] = '/';
            img[18][4] = '/';
            img[19][3] = '/';
    
            for(int i = 20; i <= 26; i++){
                img[i][2] = '|';
            }
    
            img[27][2] = '\\';
            img[28][3] = '\\';
            img[28][4] = '/';
            img[27][5] = '/';
            img[26][5] = '|';
            img[25][6] = '/';
            img[24][6] = '|';
            img[23][6] = '|';
            img[22][7] = '/';
    
            for(int i = 23; i <= 30; i++){
                img[i][7] = '|';
            }
    
            img[31][8] = '\\';
            img[32][9] = '\\';
            img[33][10] = '\\';
            img[34][11] = '\\';
    
            img[2][25] = '\\';
            img[3][26] = '\\';
            img[3][27] = '_';
            img[4][28] = '\\';
            img[5][29] = '\\';
            img[5][30] = '_';
            img[6][31] = '\\';
    
            for(int i = 32; i <= 36; i++){
                img[6][i] = '_';
            }
    
            img[7][37] = '\\';
            img[7][38] = '_';
            img[7][39] = '_';
            img[7][40] = '_';
            img[7][41] = '_';
            img[8][41] = '/';
            img[9][40] = '/';
        
            for(int i = 39; i >= 35; i--){
                img[9][i] = '_';
            }
    
            img[10][33] = '/';
            img[11][32] = '/';
            img[12][31] = '/';
    
            for(int i = 31; i <= 40; i++){
                img[i - 18][i] = '\\';
            }
    
            for(int i = 23; i <= 29; i++){
                img[i][41] = '|';
            }
    
            img[29][40] = '\\';
            img[28][39] = '\\';
            img[27][38] = '\\';
            img[26][37] = '\\';
            img[25][37] = '|';
            img[24][37] = '|';
            img[23][36] = '\\';
            
            for(int i = 23; i <= 30; i++){
                img[i][35] = '|';
            }
    
            img[31][34] = '/';
            img[32][33] = '/';
            img[33][32] = '/';
            img[34][31] = '/';
    
            for(int i = 12; i <= 30; i++){
                img[34][i] = '_';
            }
            // feet
    
            img[35][15] = '|';
            img[36][15] = '|';
            img[35][19] = '|';
            img[36][20] = '\\';
            img[37][16] = '\\';
            img[37][17] = '/';
            img[37][18] = '\\';
            img[37][19] = '/';
            img[37][20] = '\\';
            img[37][21] = '\\';
    
            img[35][24] = '|';
            img[36][24] = '|';
            img[35][28] = '|';
            img[36][29] = '\\';
            img[37][25] = '\\';
            img[37][26] = '/';
            img[37][27] = '\\';
            img[37][28] = '/';
            img[37][29] = '\\';
            img[37][30] = '\\';
    
            // inner body
    
            for(int i = 16; i <= 24; i++){
                img[4][i] = '_';
            }
    
            img[5][25] = '\\';
            img[5][26] = '_';
            img[6][27] = '\\';
            img[6][28] = '_';
            img[7][29] = '\\';
            img[8][30] = '\\';
            img[9][30] = '/';
            img[10][29] = '/';
            img[10][28] = '_';
            img[11][27] = '/';
            img[12][26] = '/';
            img[13][26] = '|';
            img[14][27] = '\\';
            img[15][28] = '\\';
            img[16][29] = '\\';
            img[17][30] = '\\';
    
            for(int i = 17; i <= 28; i++){
                img[i][30] = '|';
            }
    
            img[29][30] = '/';
            img[30][29] = '/';
            img[31][28] = '/';
    
            img[5][15] = '/';
            img[6][14] = '/';
            img[7][13] = '/';
            img[8][12] = '/';
            img[9][12] = '|';
            img[10][13] = '\\';
            img[11][14] = '\\';
            img[12][14] = '|';
            img[13][13] = '/';
    
            for(int i = 14; i <= 28; i++){
                img[i][12] = '|';
            }
    
            img[29][13] = '\\';
            img[30][14] = '\\';
            img[31][15] = '\\';
    
            for(int i = 16; i <= 27; i++){
                img[31][i] = '_';
            }
    
            // eye
    
            img[7][23] = '@';
    
            // signature
            img[39][4] = 'E';
            img[39][5] = 'Y';
            return img;
        }
 
    

    static char[][] getBigFish() {
        char[][] img = new char[8][20];
        // fill with empty space
        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 20; x++) {
                img[y][x] = ' ';
            }
        }
        // then fill individual characters
        //big fish
        //top 
         
        img[2][7] = '_';
        img[2][8] = '_'; 
        img[2][9] = '_';
        img[2][10] = '_';    
        img[1][11] = '|';   
        img[2][12] = '_';   
        img[2][13] = '_'; 
        img[2][14] = '_';   
        img[2][15] = '_';   
        img[2][16] = '_';   
        img[2][17] = '_';   

        img[3][4] = '\\';     
        img[3][6] = '/';  
        //eye
        img[3][17] = 'o';  

        img[3][18] = '\\';  

        img[4][5] = '>';  
        img[4][19] = '>';  
        img[5][4] = '/';  

        img[5][18] = '/';  
        img[4][18] = '0';  
        img[5][18] = '/';  
//bottem
        img[6][6] = '\\'; 
        img[6][7] = '_';
        img[6][8] = '_'; 
        img[6][9] = '_';
        img[6][10] = '_';    
        img[7][11] = '|';   
        img[6][12] = '_';   
        img[6][13] = '_'; 
        img[6][14] = '_';   
        img[6][15] = '_';   
        img[6][16] = '_';   
        img[6][17] = '_'; 

        img[7][5] = 'S'; 
        img[7][6] = 'F'; 
 








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