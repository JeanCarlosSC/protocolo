package app.recursos;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Resource {

//----------------------------------------COLOUR PALETTES---------------------------------------------------------------
    //basic
    public final static Color WHITE = new Color(255, 255, 255);
    public final static Color lightGray = new Color(248, 248, 248);

    //Dark Theme based on Intellij Idea
    public final static Color DTII7 = new Color(124, 123, 119); //comment font

// -----------------------------------------FONT------------------------------------------------------------------------
    //Windows standard
    public final static Font fontTitleMini = new Font("Arial", Font.BOLD, 14); //used in title of mainBar, buttons

    public final static Font fontText = new Font("Arial", Font.PLAIN, 12);
    public final static Font fontTextBold = new Font("Arial", Font.BOLD, 12);
    public final static Font fontTextMini1 = new Font("Arial", Font.PLAIN, 10);


//-----------------------------------------BORDER-----------------------------------------------------------------------
    //Dark Theme based on Intellij Idea
    public final static Border grayBorder = BorderFactory.createLineBorder(DTII7, 2, false);

}
