package nyc.c4q.ac21.signboard;

import java.util.Random;

public class Main {
    /**
     * Draws a scene with a scrolling multicolor zig-zag ribbon.
     * @param board
     *   The board on which to draw.
     * @param numCycles
     *   The number of cycles to draw for.
     */




    public static void ribbonScene(SignBoard board, int numCycles) {
        int width = board.getWidth();
        int height = board.getHeight();
        
        for (int i = 0; i < numCycles; ++i) {
            SignBoard.Frame frame = board.newFrame();

            for (int x = -2; x < width; ++x) {

                int y = (2 * height - 2 + x + i) % (2 * height - 2);

                if (y >= height-i)
                    y = y-y;

                if (0 < x) {
                    frame.setYellow();
                    frame.write(x, y, "*");
                }
                if (0 < x + 1 && x + 1 < width) {
                    frame.setGreen();
                    frame.write(x + 1, y, "*");
                }
                if (x + 2 < width) {
                    frame.setRed();
                    frame.write(x + 2, y, "*");
                }
            }

            frame.finish(0.03);
        }
    }

    /**
     * Draws a scene with text scrolling across the screen..
     * @param board
     *   The board on which to draw.
     * @param text
     *   The text to scroll.
     */




    public static void scrollTextScene(SignBoard board, String text) {

        int width = board.getWidth();
        int y = board.getHeight() / 2;

        for (int x = -text.length(); x <= width; ++x) {
            SignBoard.Frame frame = board.newFrame();

            if (x >= width)
                break;

            if (x < 0)
                // Scrolling on to the left side.
                frame.write(0, y, text.substring(-x));

            else if (x + text.length() <= width)
                // Fully on the board.
                frame.write(x, y, text);
            else
                // Scrolling off the board.
                frame.write(x, y, text.substring(0, width - x));

            frame.finish(0.01);
        }
    }

    /**
     * Draws a scene which flashes the words "FRESH" and "HOT".
     * @param board
     *   The board on which to draw.
     * @param cycles
     *   The number of cycles to draw for.
     */



    public static void writeLine(SignBoard board, int cycles){

        int length = board.getWidth();
        int height = board.getHeight()-2;

        String line="";
        Random flip = new Random();

        for (int l=0; l<length; l++){
            line+=" ";
        }

        for (int i=1; i<length; i++){
            int y = height/2;
            int x = 0;
            SignBoard.Frame frame = board.newFrame();
            int newHeight = flip.nextInt(height);
            int newPoint = flip.nextInt(length);
            line = line.substring(0,newPoint)+"#"+line.substring(newPoint+1);
            frame.write(x, newHeight, line);
            frame.finish(.2);
        }
    }

    public static void seafoodSign(SignBoard board, int cycles) {

        Random random = new Random();
        int width = board.getWidth();
        int leftPosition = width / 4 - 10 ;
        int y = board.getHeight() / 2;

        for (int i = 0; i < cycles * 2; ++i) {
            SignBoard.Frame frame = board.newFrame();

            // Choose a color at random.
            int color = random.nextInt(4);
            if (color == 0)
                frame.setGreen();
            else if (color == 1)
                frame.setRed();
            else if (color == 2)
                frame.setWhite();
            else
                frame.setYellow();
            // Write a word.
            if (i % 2 == 0) {
                frame.write(leftPosition, y - 2, " ▓▓▓▓  ▓▓▓▓▓   ▓▓   ▓▓▓▓▓  ▓▓▓▓   ▓▓▓▓  ▓▓▓▓▓ ");
                frame.write(leftPosition, y - 1, "▓      ▓▓     ▓  ▓  ▓▓    ▓▓  ▓▓ ▓▓  ▓▓ ▓▓   ▓");
                frame.write(leftPosition, y    , " ▓▓▓▓  ▓▓▓▓   ▓▓▓▓  ▓▓▓▓  ▓▓  ▓▓ ▓▓  ▓▓ ▓▓   ▓");
                frame.write(leftPosition, y + 1, "     ▓ ▓▓     ▓  ▓  ▓▓    ▓▓  ▓▓ ▓▓  ▓▓ ▓▓   ▓");
                frame.write(leftPosition, y + 2, " ▓▓▓▓  ▓▓▓▓▓ ▓▓  ▓▓ ▓▓     ▓▓▓▓   ▓▓▓▓  ▓▓▓▓▓ ");
            }
            else {
                frame.write(leftPosition, y - 2, " ▓▓▓▓  ▓▓▓▓▓   ▓▓   ▓▓▓▓▓  ▓▓▓▓   ▓▓▓▓  ▓▓▓▓▓ ");
                frame.write(leftPosition, y - 1, "▓      ▓▓     ▓  ▓  ▓▓    ▓▓  ▓▓ ▓▓  ▓▓ ▓▓   ▓");
                frame.write(leftPosition, y    , " ▓▓▓▓  ▓▓▓▓   ▓▓▓▓  ▓▓▓▓  ▓▓  ▓▓ ▓▓  ▓▓ ▓▓   ▓");
                frame.write(leftPosition, y + 1, "     ▓ ▓▓     ▓  ▓  ▓▓    ▓▓  ▓▓ ▓▓  ▓▓ ▓▓   ▓");
                frame.write(leftPosition, y + 2, " ▓▓▓▓  ▓▓▓▓▓ ▓▓  ▓▓ ▓▓     ▓▓▓▓   ▓▓▓▓  ▓▓▓▓▓ ");
            }

            frame.finish(0.1);
        }
    }

    public static void crabWalk(SignBoard board, int cycles) {
        int width = board.getWidth();
        int leftPosition = width / 5- 12;
        int middleleftPosition =2 * width / 5 -10;
        //int middlePosition = width / 2- 10;
        int middlerightPosition =3 * width / 5 - 10;
        int rightPosition = 4 * width / 5;
        int y = board.getHeight() / 2;

        for (int i = 0; i < cycles * 2; ++i) {
            SignBoard.Frame frame = board.newFrame();
            if (i==0) {
                frame.setRed();
                frame.write(leftPosition, y + 1, " (V)｡ ｡(V) ");
                frame.write(leftPosition, y + 2, "ミ〈 ∀ 〉彡");
                frame.write(middlerightPosition, y, "CRAB!");
                frame.write(rightPosition, y - 3, " (V)｡ ｡(V) ");
                frame.write(rightPosition, y - 2, "ミ〈 ∀ 〉彡");
            }

            else if (i==1) {
                frame.setRed();
                frame.write(middleleftPosition, y + 1, " (V)｡ ｡(V) ");
                frame.write(middleleftPosition, y + 2, "ミ〈 ∀ 〉彡");
                frame.write(middleleftPosition, y, "CRAB!");
                frame.write(middlerightPosition, y -3, " (V)｡ ｡(V) ");
                frame.write(middlerightPosition, y -2, "ミ〈 ∀ 〉彡");
            }

            else if (i==2) {
                frame.setRed();
                frame.write(middlerightPosition, y + 1, " (V)｡ ｡(V) ");
                frame.write(middlerightPosition, y + 2, "ミ〈 ∀ 〉彡");
                frame.write(middlerightPosition, y, "CRAB!");
                frame.write(middleleftPosition, y -3, " (V)｡ ｡(V) ");
                frame.write(middleleftPosition, y -2, "ミ〈 ∀ 〉彡");
            }

            else if (i==3) {
                frame.setRed();
                frame.write(rightPosition, y + 1, " (V)｡ ｡(V) ");
                frame.write(rightPosition, y + 2, "ミ〈 ∀ 〉彡");
                frame.write(middleleftPosition, y, "CRAB!");
                frame.write(leftPosition, y -3, " (V)｡ ｡(V) ");
                frame.write(leftPosition, y -2, "ミ〈 ∀ 〉彡");
            }
            frame.finish(0.35);
        }
    }

    public static void fishfishfish(SignBoard board, int cycles) {
        Random random = new Random();
        int width = board.getWidth();
        int leftPosition = width /4-15;
        int middlePosition = width/2-10;
        int rightPosition = 3 * width / 4-5;
        int y = board.getHeight() / 2;

        for (int i = 0; i < cycles * 2; ++i) {
            SignBoard.Frame frame = board.newFrame();


            if (i == 0) {
                frame.write(leftPosition, y - 3, "　　　　　　　＿");
                frame.write(leftPosition, y - 2, "　　　|＼　_ﾉ―'‐ヽ ");
                frame.write(leftPosition, y - 1 , "( (　|三ﾐ~ﾒﾒﾒﾒ（( ･） ");
                frame.write(leftPosition, y     , " 　  |／ ｀>r=＝u' ");
                frame.write(leftPosition, y + 2, "       **FISH!** ");
            }
            else if (i ==1) {
                frame.write(middlePosition, y - 3, "　　　　　　　＿");
                frame.write(middlePosition, y - 2, "　　　|＼　_ﾉ―'‐ヽ ");
                frame.write(middlePosition, y - 1, "( (　|三ﾐ~ﾒﾒﾒﾒ（( ･） ");
                frame.write(middlePosition, y    , " 　  |／ ｀>r=＝u' ");
                frame.write(middlePosition, y + 2, "       **FISH!** ");;
            }
            else if (i==2) {
                frame.write(rightPosition, y - 3, "　　　　　　　＿");
                frame.write(rightPosition, y - 2, "　　　|＼　_ﾉ―'‐ヽ ");
                frame.write(rightPosition, y - 1, "( (　|三ﾐ~ﾒﾒﾒﾒ（( ･） ");
                frame.write(rightPosition, y    , " 　  |／ ｀>r=＝u' ");
                frame.write(rightPosition, y + 2, "       **FISH!** ");
            }

            frame.finish(0.35);
        }




    }

    public static void fishOne(SignBoard board, String text) {
        int width = board.getWidth();
        int y = board.getHeight() / 2;
        for (int x = -text.length(); x <= width; ++x) {
            SignBoard.Frame frame = board.newFrame();

            if (x >= width)
                break;

            if (x < 0)
                // Scrolling on to the left side.
                frame.write(0, y, text.substring(-x));
            else if (x + text.length() <= width)
                // Fully on the board.
                frame.write(x, y, text);
            else
                // Scrolling off the board.
                frame.write(x, y, text.substring(0, width - x));

            frame.finish(0.02);
        }
    }


    public static void fishTwo(SignBoard board, String text) {
        int width = board.getWidth();
        int y = board.getHeight() / 2;
        for (int x = -text.length(); x <= width; ++x) {
            SignBoard.Frame frame = board.newFrame();

            if (x >= width)
                break;

            if (x < 0)
                // Scrolling on to the left side.
                frame.write(0, y+1, text.substring(-x));
            else if (x + text.length() <= width)
                // Fully on the board.
                frame.write(x, y+1, text);
            else
                // Scrolling off the board.
                frame.write(x, y+1, text.substring(0, width - x));

            frame.finish(0.02);
        }
    }

    public static void octopusRandom(SignBoard board, int cycles) {
        Random random = new Random();
        int y = board.getHeight()/2 ;

        for (int i = 0; i < cycles * 2; ++i) {
            SignBoard.Frame frame = board.newFrame();

            // Choose a color at random.
            int color = random.nextInt(6);
            if (color == 0)
                frame.setGreen();
            else if (color == 1)
                frame.setRed();
            else if (color == 2)
                frame.setWhite();
            else if (color == 3)
                frame.setBlue();
            else if (color == 4)
                frame.setYellow();
            else
                frame.setCyan();

            int randomX = random.nextInt(board.getWidth() - 20);
            int randomX2 = random.nextInt(board.getWidth() - 20);
            int randomY2 = random.nextInt(board.getHeight()/2);
            int randomX3 = random.nextInt(board.getWidth()-20);
            int randomY3 = random.nextInt(board.getHeight()/2);



            //Bubbles, randomized coordinates for both X and Y
            frame.write(random.nextInt(board.getWidth()),random.nextInt(board.getHeight()), "O");
            frame.write(random.nextInt(board.getWidth()-20),random.nextInt(board.getHeight()/2), "o");
            frame.write(random.nextInt(board.getWidth()),random.nextInt(board.getHeight()), ".");
            frame.write(random.nextInt(board.getWidth()-20),random.nextInt(board.getHeight()/2), "O");
            frame.write(random.nextInt(board.getWidth()),random.nextInt(board.getHeight()), "o");
            frame.write(random.nextInt(board.getWidth()-20),random.nextInt(board.getHeight()/2), ".");

            //Mini octopus 1
            frame.write(randomX2,randomY2 , "(oo)");
            frame.write(randomX2,randomY2+1, "/||\\");

            //Mini octopus 2
            frame.write(randomX3,randomY3 , "(oo)");
            frame.write(randomX3,randomY3+1, "/||\\");

            //Big octopus
            frame.write(randomX, y - 3 ,   "   ''''`.");
            frame.write(randomX, y - 2 ,   "  / _  _ \\ ");
            frame.write(randomX, y - 1 , "  |(@)(@)|");
            frame.write(randomX, y     , "  )  __  (");
            frame.write(randomX, y + 1 , " /,'))((`.\\ ");
            frame.write(randomX, y + 2 , "(( ((  )) )) ");
            frame.write(randomX, y + 3 , " `\\ `)(' // ");


            frame.finish(0.25);

        }
    }






    public static void main(String[] args) {
        SignBoard signBoard = new SignBoard(8);
        // Run the sign board forever.
        while (true) {
            octopusRandom(signBoard, 10);
            //writeLine(signBoard,48);
            //ribbonScene(signBoard, 48);
            scrollTextScene(signBoard, "ooo---->");
            //ribbonScene(signBoard, 48);
            seafoodSign(signBoard, 8);


            fishOne(signBoard,"`·.¸¸.·´¯`·.¸¸.·´¯`·.¸¸.·´¯`·.¸¸.·´¯`·.¸¸.·´¯`·.¸><((((º>");
            fishTwo(signBoard,"`·.¸¸.·´¯`·.¸¸.·´¯`·.¸¸.·´¯`·.¸¸.·´¯`·.¸¸.·´¯`·.¸¸><((((º>");
            fishfishfish(signBoard, 3);
            crabWalk(signBoard, 3);

        }

    }
}
