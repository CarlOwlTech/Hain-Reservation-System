/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package User;

//import DateChooserComponent.SelectedDate;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import java.sql.*;
//import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import raven.cell.TableActionCellEditor;
import raven.cell.TableActionCellRender;
import raven.cell.TableActionEvent;
//import RoundedComponents.PanelRound;
//import RoundedComponents.RoundLabel;
//import com.raven.swing.TimePicker;
import java.awt.event.MouseEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import scrollbar.*;

import javax.swing.BorderFactory;
import javax.swing.JPasswordField;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

/**
 *
 * @author Carlo
 */
public class Dashboard extends javax.swing.JFrame {

    /** Creates new form LandingPage */
    public Dashboard(AccountInfo accounts) {
        initComponents();
        usernameHolder.setText(accounts.getUsername());
        passHolder.setText(accounts.getPassword());
        secuHolder.setText(accounts.getSecurityQuestion());
        ansHolder.setText(accounts.getSecurityAnswer());
        passOpen.setVisible(false);
        ansOpen.setVisible(false);

        cartScroll.setVerticalScrollBar(new ScrollBarCustom());
        cartTable.setShowGrid(true);
        cartScroll.setBorder(BorderFactory.createEmptyBorder());
        cartTable.getTableHeader().setReorderingAllowed(false);

        reserveScroll.setVerticalScrollBar(new ScrollBarCustom());
        reserveTable.setShowGrid(true);
        reserveScroll.setBorder(BorderFactory.createEmptyBorder());
        reserveTable.getTableHeader().setReorderingAllowed(false);

        TableActionEvent event = new TableActionEvent() {
            @Override
            public void increment(int row) {
                DefaultTableModel model = (DefaultTableModel) cartTable.getModel();
                int quantity = (Integer) model.getValueAt(row, 3);

                int selectedRow = cartTable.getSelectedRow();
                if (selectedRow != -1) {  // Ensure there is a selected row
                    incrementTable(selectedRow);
                }

            }

            @Override
            public void onDelete(int row) {
                if (cartTable.isEditing()) {
                    cartTable.getCellEditor().stopCellEditing();
                }
                DefaultTableModel model = (DefaultTableModel) cartTable.getModel();
                model.removeRow(row);
            }

            @Override
            public void decrement(int row) {
                DefaultTableModel model = (DefaultTableModel) cartTable.getModel();
                int quantity = (Integer) model.getValueAt(row, 3);

                if (quantity < 1) {
                    model.removeRow(row);
                }
                int selectedRow = cartTable.getSelectedRow();
                if (selectedRow != -1) {
                    decrementTable(selectedRow);
                } else {
                    JOptionPane.showMessageDialog(null, "Successfully Removed", "No Selection", JOptionPane.ERROR_MESSAGE);
                }

            }

        };
        cartTable.getColumnModel()
                .getColumn(5).setCellRenderer(new TableActionCellRender());
        cartTable.getColumnModel()
                .getColumn(5).setCellEditor(new TableActionCellEditor(event));
        cartTable.getColumnModel()
                .getColumn(0).setCellRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable jtable, Object o,
                    boolean bln, boolean bln1, int i, int i1
            ) {
                setHorizontalAlignment(SwingConstants.CENTER);
                return super.getTableCellRendererComponent(jtable, o, bln, bln1, i, i1);
            }
        }
        );

        cartTable.getColumnModel()
                .getColumn(0).setPreferredWidth(50);
        cartTable.getColumnModel()
                .getColumn(2).setPreferredWidth(200);
        reserveTable.getColumnModel()
                .getColumn(2).setPreferredWidth(50);
        reserveTable.getColumnModel()
                .getColumn(3).setPreferredWidth(200);

        initializeTableRenderer();

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dateEvent = new DateChooserComponent.DateChooser();
        tableDate = new DateChooserComponent.DateChooser();
        packDate = new DateChooserComponent.DateChooser();
        timeTable = new com.raven.swing.TimePicker();
        timeEvents = new com.raven.swing.TimePicker();
        timePacks = new com.raven.swing.TimePicker();
        settings = new javax.swing.JPopupMenu();
        Settings = new javax.swing.JMenuItem();
        Logout = new javax.swing.JMenuItem();
        Header = new javax.swing.JPanel();
        Exit = new javax.swing.JLabel();
        settingsIcon = new javax.swing.JLabel();
        Headerpng = new javax.swing.JLabel();
        Sidebar = new javax.swing.JPanel();
        Table = new javax.swing.JPanel();
        TableLabel = new javax.swing.JLabel();
        tableSep = new javax.swing.JSeparator();
        Food = new javax.swing.JPanel();
        FoodLbl = new javax.swing.JLabel();
        foodSep = new javax.swing.JSeparator();
        Events = new javax.swing.JPanel();
        EventLabel = new javax.swing.JLabel();
        eventSep = new javax.swing.JSeparator();
        Package = new javax.swing.JPanel();
        PackLabel = new javax.swing.JLabel();
        packSep = new javax.swing.JSeparator();
        cartSep = new javax.swing.JSeparator();
        Cart = new javax.swing.JPanel();
        CartLabel = new javax.swing.JLabel();
        Reservation = new javax.swing.JPanel();
        ReservationLabel = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        Base = new javax.swing.JPanel();
        TablePnl = new javax.swing.JPanel();
        jSeparator6 = new javax.swing.JSeparator();
        nextBtn = new button.Button();
        firstHolder = new RoundedComponents.PanelRound();
        onePax = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        onePaxQuantity = new javax.swing.JSpinner();
        onePaxImg = new RoundedComponents.RoundLabel();
        thirdHolder = new RoundedComponents.PanelRound();
        threePax = new javax.swing.JLabel();
        threePaxQuantity = new javax.swing.JSpinner();
        jLabel18 = new javax.swing.JLabel();
        threePaxImg = new RoundedComponents.RoundLabel();
        sixHolder = new RoundedComponents.PanelRound();
        sixPax = new javax.swing.JLabel();
        sixPaxQuantity = new javax.swing.JSpinner();
        jLabel23 = new javax.swing.JLabel();
        sixPaxImg = new RoundedComponents.RoundLabel();
        tenHolder = new RoundedComponents.PanelRound();
        tenPax = new javax.swing.JLabel();
        tenPaxQuantity = new javax.swing.JSpinner();
        jLabel24 = new javax.swing.JLabel();
        tenPaxImg = new RoundedComponents.RoundLabel();
        tableShow = new DateChooserComponent.Button();
        searchIcon2 = new javax.swing.JLabel();
        cartIcon15 = new javax.swing.JLabel();
        onePaxReserve = new button.Button();
        cartIcon16 = new javax.swing.JLabel();
        threePaxdupe = new button.Button();
        cartIcon17 = new javax.swing.JLabel();
        sixPaxReserve = new button.Button();
        cartIcon18 = new javax.swing.JLabel();
        tenPaxReserve = new button.Button();
        timeHolderTable = new TextFieldUI.TextField();
        dateShow = new TextFieldUI.TextField();
        tableShow1 = new DateChooserComponent.Button();
        onePaxdupe = new button.Button();
        threePaxReserve1 = new button.Button();
        sixPaxdupe = new button.Button();
        tenPaxdupe = new button.Button();
        testUser = new javax.swing.JLabel();
        Background = new javax.swing.JLabel();
        FoodPnl = new javax.swing.JPanel();
        cartIcon2 = new javax.swing.JLabel();
        pancitOrder = new button.Button();
        cartIcon1 = new javax.swing.JLabel();
        empOrder = new button.Button();
        cartIcon = new javax.swing.JLabel();
        crabOrder = new button.Button();
        apeBtn = new button.Button();
        Entree = new button.Button();
        Rice = new button.Button();
        Desert = new button.Button();
        Beverage = new button.Button();
        pancitHolder = new RoundedComponents.PanelRound();
        pancitTitle = new javax.swing.JLabel();
        pancitPrice = new javax.swing.JLabel();
        Description7 = new javax.swing.JLabel();
        Description8 = new javax.swing.JLabel();
        Description9 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        pancitQuantity = new javax.swing.JSpinner();
        roundLabel2 = new RoundedComponents.RoundLabel();
        empHolder = new RoundedComponents.PanelRound();
        empTitle = new javax.swing.JLabel();
        empPrice = new javax.swing.JLabel();
        Description4 = new javax.swing.JLabel();
        Description5 = new javax.swing.JLabel();
        Description6 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        empQuantity = new javax.swing.JSpinner();
        roundLabel3 = new RoundedComponents.RoundLabel();
        crabHolder = new RoundedComponents.PanelRound();
        crabTitle = new javax.swing.JLabel();
        crabPrice = new javax.swing.JLabel();
        Description1 = new javax.swing.JLabel();
        Description2 = new javax.swing.JLabel();
        Description3 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        crabQuantity = new javax.swing.JSpinner();
        roundLabel1 = new RoundedComponents.RoundLabel();
        jLabel1 = new javax.swing.JLabel();
        EntreePnl = new javax.swing.JPanel();
        apeBtn1 = new button.Button();
        Entree1 = new button.Button();
        Rice1 = new button.Button();
        Desert1 = new button.Button();
        Beverage1 = new button.Button();
        cartIcon3 = new javax.swing.JLabel();
        bicolOrder = new button.Button();
        bicolHolder = new RoundedComponents.PanelRound();
        bicolTitle = new javax.swing.JLabel();
        Price3 = new javax.swing.JLabel();
        Description10 = new javax.swing.JLabel();
        Description11 = new javax.swing.JLabel();
        Description12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        bicolQuantity = new javax.swing.JSpinner();
        bicolmg = new RoundedComponents.RoundLabel();
        lechonHolder = new RoundedComponents.PanelRound();
        lechonTitle = new javax.swing.JLabel();
        Price4 = new javax.swing.JLabel();
        Description13 = new javax.swing.JLabel();
        Description14 = new javax.swing.JLabel();
        Description15 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        lechonQuantity = new javax.swing.JSpinner();
        lechonImg = new RoundedComponents.RoundLabel();
        fishHolder = new RoundedComponents.PanelRound();
        fishTitle = new javax.swing.JLabel();
        Price5 = new javax.swing.JLabel();
        Description16 = new javax.swing.JLabel();
        Description17 = new javax.swing.JLabel();
        Description18 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        fishQuantity = new javax.swing.JSpinner();
        fishImg = new RoundedComponents.RoundLabel();
        cartIcon4 = new javax.swing.JLabel();
        lechonOrder = new button.Button();
        cartIcon5 = new javax.swing.JLabel();
        fishOrder = new button.Button();
        jLabel2 = new javax.swing.JLabel();
        RicePnl = new javax.swing.JPanel();
        apeBtn2 = new button.Button();
        Entree2 = new button.Button();
        Rice2 = new button.Button();
        Desert2 = new button.Button();
        Beverage2 = new button.Button();
        JasmineHolder = new RoundedComponents.PanelRound();
        jasTitle = new javax.swing.JLabel();
        Price6 = new javax.swing.JLabel();
        Description19 = new javax.swing.JLabel();
        Description20 = new javax.swing.JLabel();
        Description21 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jasQuantity = new javax.swing.JSpinner();
        bicolmg2 = new RoundedComponents.RoundLabel();
        cartIcon6 = new javax.swing.JLabel();
        jasOrder = new button.Button();
        cartIcon7 = new javax.swing.JLabel();
        adoboOrder = new button.Button();
        pancitHolder2 = new RoundedComponents.PanelRound();
        javaTitle = new javax.swing.JLabel();
        Price8 = new javax.swing.JLabel();
        Description25 = new javax.swing.JLabel();
        Description26 = new javax.swing.JLabel();
        javaQuantity = new javax.swing.JLabel();
        javaQty = new javax.swing.JSpinner();
        bicolmg1 = new RoundedComponents.RoundLabel();
        cartIcon8 = new javax.swing.JLabel();
        javaOrder = new button.Button();
        adoboHolder = new RoundedComponents.PanelRound();
        adoboTitle = new javax.swing.JLabel();
        Price15 = new javax.swing.JLabel();
        Description46 = new javax.swing.JLabel();
        Description47 = new javax.swing.JLabel();
        Description48 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        adoboQuantity = new javax.swing.JSpinner();
        bicolmg3 = new RoundedComponents.RoundLabel();
        jLabel3 = new javax.swing.JLabel();
        DesertPnl = new javax.swing.JPanel();
        apeBtn3 = new button.Button();
        Entree3 = new button.Button();
        Rice3 = new button.Button();
        Desert3 = new button.Button();
        Beverage3 = new button.Button();
        cartIcon9 = new javax.swing.JLabel();
        halohaloOrder = new button.Button();
        halohaloHolder = new RoundedComponents.PanelRound();
        halohaloTitle = new javax.swing.JLabel();
        Price9 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        haloQuantity = new javax.swing.JSpinner();
        Description37 = new javax.swing.JLabel();
        Description34 = new javax.swing.JLabel();
        Description39 = new javax.swing.JLabel();
        bicolmg5 = new RoundedComponents.RoundLabel();
        pandanHolder = new RoundedComponents.PanelRound();
        pandanTitle = new javax.swing.JLabel();
        Price10 = new javax.swing.JLabel();
        Description31 = new javax.swing.JLabel();
        Description32 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        pandanQuantity = new javax.swing.JSpinner();
        Description40 = new javax.swing.JLabel();
        bicolmg6 = new RoundedComponents.RoundLabel();
        bicolmg7 = new RoundedComponents.RoundLabel();
        cartIcon10 = new javax.swing.JLabel();
        gulamanOrder = new button.Button();
        cartIcon11 = new javax.swing.JLabel();
        majaOrder = new button.Button();
        majaHolder = new RoundedComponents.PanelRound();
        majaTitle = new javax.swing.JLabel();
        Price11 = new javax.swing.JLabel();
        Description35 = new javax.swing.JLabel();
        Description36 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        majaQuantity = new javax.swing.JSpinner();
        Description38 = new javax.swing.JLabel();
        bicolmg4 = new RoundedComponents.RoundLabel();
        jLabel4 = new javax.swing.JLabel();
        BeveragePnl = new javax.swing.JPanel();
        apeBtn4 = new button.Button();
        Entree4 = new button.Button();
        Rice4 = new button.Button();
        Desert4 = new button.Button();
        Beverage4 = new button.Button();
        cartIcon12 = new javax.swing.JLabel();
        iceteaOrder = new button.Button();
        cartIcon13 = new javax.swing.JLabel();
        sofdrinkOrder = new button.Button();
        cartIcon14 = new javax.swing.JLabel();
        fruitOrder = new button.Button();
        iceteaHolder = new RoundedComponents.PanelRound();
        teaTitle = new javax.swing.JLabel();
        Price16 = new javax.swing.JLabel();
        Description30 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        teaQuantity = new javax.swing.JSpinner();
        Description50 = new javax.swing.JLabel();
        bicolmg9 = new RoundedComponents.RoundLabel();
        softdrinkHolder = new RoundedComponents.PanelRound();
        softdrinkTitle = new javax.swing.JLabel();
        Price17 = new javax.swing.JLabel();
        Description33 = new javax.swing.JLabel();
        Description51 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        softDrinksQuantity = new javax.swing.JSpinner();
        bicolmg10 = new RoundedComponents.RoundLabel();
        fruitHolder = new RoundedComponents.PanelRound();
        fruitTitle = new javax.swing.JLabel();
        Price18 = new javax.swing.JLabel();
        Description52 = new javax.swing.JLabel();
        Description53 = new javax.swing.JLabel();
        Description54 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        fruitQuantity = new javax.swing.JSpinner();
        bicolmg8 = new RoundedComponents.RoundLabel();
        jLabel5 = new javax.swing.JLabel();
        EventPnl = new javax.swing.JPanel();
        holidayHolder = new RoundedComponents.PanelRound();
        holidayTitle = new javax.swing.JLabel();
        holidayPrice = new javax.swing.JLabel();
        holidayImg = new RoundedComponents.RoundLabel();
        weddingHolder = new RoundedComponents.PanelRound();
        weddingTitle = new javax.swing.JLabel();
        weddingPrice = new javax.swing.JLabel();
        weddingImg = new RoundedComponents.RoundLabel();
        valentinesHolder = new RoundedComponents.PanelRound();
        valentineTitle = new javax.swing.JLabel();
        valentinePrice = new javax.swing.JLabel();
        valentineImg = new RoundedComponents.RoundLabel();
        birthdayHolder = new RoundedComponents.PanelRound();
        bdayTitle = new javax.swing.JLabel();
        bdayPrice = new javax.swing.JLabel();
        bdayImg = new RoundedComponents.RoundLabel();
        jSeparator7 = new javax.swing.JSeparator();
        dateHolderEvent = new TextFieldUI.TextField();
        nextBtn1 = new button.Button();
        showEvent = new DateChooserComponent.Button();
        searchIcon1 = new javax.swing.JLabel();
        cartIcon19 = new javax.swing.JLabel();
        holidayReserve = new button.Button();
        cartIcon20 = new javax.swing.JLabel();
        weddingReserve = new button.Button();
        cartIcon21 = new javax.swing.JLabel();
        valentineReserve = new button.Button();
        cartIcon22 = new javax.swing.JLabel();
        bdayReserve = new button.Button();
        timeHolderEvents = new TextFieldUI.TextField();
        showEventPacks = new DateChooserComponent.Button();
        EventBg = new javax.swing.JLabel();
        PackPnl = new javax.swing.JPanel();
        xmasHolder = new RoundedComponents.PanelRound();
        xmasTitle = new javax.swing.JLabel();
        Description41 = new javax.swing.JLabel();
        Description43 = new javax.swing.JLabel();
        Description44 = new javax.swing.JLabel();
        Description56 = new javax.swing.JLabel();
        xmasPrice = new javax.swing.JLabel();
        xmasImg = new RoundedComponents.RoundLabel();
        valenHolder = new RoundedComponents.PanelRound();
        vdateTitle = new javax.swing.JLabel();
        Description45 = new javax.swing.JLabel();
        Description55 = new javax.swing.JLabel();
        Description49 = new javax.swing.JLabel();
        Description60 = new javax.swing.JLabel();
        valenPrice = new javax.swing.JLabel();
        valenImg = new RoundedComponents.RoundLabel();
        trioHolder = new RoundedComponents.PanelRound();
        trioTitle = new javax.swing.JLabel();
        Description57 = new javax.swing.JLabel();
        Description59 = new javax.swing.JLabel();
        Description58 = new javax.swing.JLabel();
        Description64 = new javax.swing.JLabel();
        trioPrice = new javax.swing.JLabel();
        trioImg = new RoundedComponents.RoundLabel();
        familyHolder = new RoundedComponents.PanelRound();
        familyTitle = new javax.swing.JLabel();
        Description62 = new javax.swing.JLabel();
        Description61 = new javax.swing.JLabel();
        Description63 = new javax.swing.JLabel();
        Description42 = new javax.swing.JLabel();
        familyPrice = new javax.swing.JLabel();
        familyImg = new RoundedComponents.RoundLabel();
        dateHolderPack = new TextFieldUI.TextField();
        showPack = new DateChooserComponent.Button();
        searchIcon = new javax.swing.JLabel();
        cartIcon23 = new javax.swing.JLabel();
        xmasReserve = new button.Button();
        cartIcon24 = new javax.swing.JLabel();
        vdateReserve = new button.Button();
        cartIcon25 = new javax.swing.JLabel();
        trioReserve = new button.Button();
        cartIcon26 = new javax.swing.JLabel();
        familyReserve = new button.Button();
        timeHolderPack = new TextFieldUI.TextField();
        showTimePacks = new DateChooserComponent.Button();
        jLabel6 = new javax.swing.JLabel();
        CartPnl = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        totalAmount = new javax.swing.JLabel();
        compute = new button.Button();
        reserveNow = new button.Button();
        jLabel9 = new javax.swing.JLabel();
        reserveDupe3 = new button.Button();
        reserveDupe2 = new button.Button();
        reserveDupe1 = new button.Button();
        computeDupe4 = new button.Button();
        computeDupe3 = new button.Button();
        computeDupe2 = new button.Button();
        computeDupe1 = new button.Button();
        reserveDupe = new button.Button();
        cartScroll = new javax.swing.JScrollPane();
        cartTable = new javax.swing.JTable();
        ReservationPnl = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        Cancel = new button.Button();
        Check = new button.Button();
        Check1 = new button.Button();
        Check2 = new button.Button();
        Check3 = new button.Button();
        Check4 = new button.Button();
        Cancel1 = new button.Button();
        Cancel2 = new button.Button();
        Cancel3 = new button.Button();
        Cancel4 = new button.Button();
        reserveScroll = new javax.swing.JScrollPane();
        reserveTable = new javax.swing.JTable();
        SettingsPnl = new javax.swing.JPanel();
        ansTitle = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        userTitle = new javax.swing.JLabel();
        passTitle = new javax.swing.JLabel();
        secuTitle = new javax.swing.JLabel();
        usernameHolder = new textfield.TextField();
        updateInfo = new button.Button();
        button2 = new button.Button();
        button3 = new button.Button();
        secuHolder = new textfield.TextField();
        ansHolder = new textfield.PasswordField();
        passHolder = new textfield.PasswordField();
        passHide = new javax.swing.JLabel();
        passOpen = new javax.swing.JLabel();
        userLock = new javax.swing.JLabel();
        passLock = new javax.swing.JLabel();
        ansLock = new javax.swing.JLabel();
        ansHide = new javax.swing.JLabel();
        ansOpen = new javax.swing.JLabel();
        bg = new javax.swing.JLabel();

        dateEvent.setForeground(new java.awt.Color(255, 204, 102));
        dateEvent.setDateFormat("YYYY-MM-dd");
        dateEvent.setTextRefernce(dateHolderEvent);

        tableDate.setForeground(new java.awt.Color(255, 204, 102));
        tableDate.setDateFormat("YYYY-MM-dd");
        tableDate.setTextRefernce(dateShow);

        packDate.setForeground(new java.awt.Color(255, 204, 102));
        packDate.setDateFormat("YYYY-MM-dd");
        packDate.setTextRefernce(dateHolderPack);

        timeTable.setForeground(new java.awt.Color(0, 0, 0));
        timeTable.setDisplayText(timeHolderTable);

        timeEvents.setForeground(new java.awt.Color(0, 0, 0));
        timeEvents.setDisplayText(timeHolderEvents);

        timePacks.setForeground(new java.awt.Color(0, 0, 0));
        timePacks.setDisplayText(timeHolderPack);

        Settings.setText("Settings");
        Settings.setPreferredSize(new java.awt.Dimension(100, 50));
        Settings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SettingsActionPerformed(evt);
            }
        });
        settings.add(Settings);

        Logout.setText("Logout");
        Logout.setPreferredSize(new java.awt.Dimension(100, 50));
        Logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutActionPerformed(evt);
            }
        });
        settings.add(Logout);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setMinimumSize(new java.awt.Dimension(100, 100));
        setUndecorated(true);
        setResizable(false);

        Header.setBackground(new java.awt.Color(255, 102, 102));
        Header.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LP_images/windows close.png"))); // NOI18N
        Exit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ExitMouseClicked(evt);
            }
        });
        Header.add(Exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 5, 40, 40));

        settingsIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LP_images/try.png"))); // NOI18N
        settingsIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                settingsIconMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                settingsIconMouseReleased(evt);
            }
        });
        Header.add(settingsIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 30, 80, 70));

        Headerpng.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LP_images/Header.png"))); // NOI18N
        Headerpng.setText("jLabel1");
        Header.add(Headerpng, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1240, 120));

        Sidebar.setBackground(new java.awt.Color(200, 200, 200));
        Sidebar.setAlignmentX(0.0F);
        Sidebar.setAlignmentY(0.0F);

        Table.setBackground(new java.awt.Color(200, 200, 200));
        Table.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TableLabel.setFont(new java.awt.Font("Sitka Text", 1, 24)); // NOI18N
        TableLabel.setText("     TABLE & PACKS");
        TableLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        TableLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableLabelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                TableLabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                TableLabelMouseExited(evt);
            }
        });
        Table.add(TableLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 260, 48));

        tableSep.setForeground(new java.awt.Color(51, 51, 51));

        Food.setBackground(new java.awt.Color(200, 200, 200));
        Food.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        FoodLbl.setFont(new java.awt.Font("Sitka Text", 1, 24)); // NOI18N
        FoodLbl.setText("             FOOD");
        FoodLbl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        FoodLbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                FoodLblMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                FoodLblMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                FoodLblMouseExited(evt);
            }
        });
        Food.add(FoodLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 6, 260, 48));

        foodSep.setForeground(new java.awt.Color(0, 0, 0));

        Events.setBackground(new java.awt.Color(200, 200, 200));
        Events.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        EventLabel.setFont(new java.awt.Font("Sitka Text", 1, 24)); // NOI18N
        EventLabel.setText("           EVENTS");
        EventLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        EventLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EventLabelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                EventLabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                EventLabelMouseExited(evt);
            }
        });
        Events.add(EventLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 6, 260, 48));

        eventSep.setForeground(new java.awt.Color(0, 0, 0));

        Package.setBackground(new java.awt.Color(200, 200, 200));
        Package.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PackLabel.setFont(new java.awt.Font("Sitka Text", 1, 24)); // NOI18N
        PackLabel.setText("         PACKAGES");
        PackLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        PackLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PackLabelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PackLabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                PackLabelMouseExited(evt);
            }
        });
        Package.add(PackLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 7, 260, 48));

        packSep.setForeground(new java.awt.Color(0, 0, 0));

        cartSep.setForeground(new java.awt.Color(51, 51, 51));

        Cart.setBackground(new java.awt.Color(200, 200, 200));
        Cart.setPreferredSize(new java.awt.Dimension(260, 55));

        CartLabel.setFont(new java.awt.Font("Sitka Text", 1, 24)); // NOI18N
        CartLabel.setText("             CART");
        CartLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CartLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CartLabelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CartLabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                CartLabelMouseExited(evt);
            }
        });

        javax.swing.GroupLayout CartLayout = new javax.swing.GroupLayout(Cart);
        Cart.setLayout(CartLayout);
        CartLayout.setHorizontalGroup(
            CartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 260, Short.MAX_VALUE)
            .addGroup(CartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(CartLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(CartLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        CartLayout.setVerticalGroup(
            CartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 55, Short.MAX_VALUE)
            .addGroup(CartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(CartLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(CartLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        Reservation.setBackground(new java.awt.Color(200, 200, 200));
        Reservation.setPreferredSize(new java.awt.Dimension(260, 55));

        ReservationLabel.setFont(new java.awt.Font("Sitka Text", 1, 24)); // NOI18N
        ReservationLabel.setText("      RESERVATION");
        ReservationLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ReservationLabel.setPreferredSize(new java.awt.Dimension(37, 48));
        ReservationLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ReservationLabelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ReservationLabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ReservationLabelMouseExited(evt);
            }
        });

        javax.swing.GroupLayout ReservationLayout = new javax.swing.GroupLayout(Reservation);
        Reservation.setLayout(ReservationLayout);
        ReservationLayout.setHorizontalGroup(
            ReservationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ReservationLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        ReservationLayout.setVerticalGroup(
            ReservationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ReservationLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ReservationLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jSeparator1.setForeground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout SidebarLayout = new javax.swing.GroupLayout(Sidebar);
        Sidebar.setLayout(SidebarLayout);
        SidebarLayout.setHorizontalGroup(
            SidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cartSep)
            .addComponent(Reservation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(SidebarLayout.createSequentialGroup()
                .addGroup(SidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Table, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tableSep, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Food, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(foodSep, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Events, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eventSep, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Package, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(packSep, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Cart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jSeparator1)
        );
        SidebarLayout.setVerticalGroup(
            SidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SidebarLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(Table, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(tableSep, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(Food, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(foodSep, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(Events, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(SidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(eventSep, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(SidebarLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(Package, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(11, 11, 11)
                .addComponent(packSep, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Cart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cartSep, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(Reservation, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(182, 182, 182))
        );

        Base.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TablePnl.setPreferredSize(new java.awt.Dimension(980, 676));
        TablePnl.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparator6.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator6.setForeground(new java.awt.Color(0, 0, 0));
        TablePnl.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 640, 60, -1));

        nextBtn.setBackground(new java.awt.Color(249, 249, 249));
        nextBtn.setText("NEXT");
        nextBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        nextBtn.setFont(new java.awt.Font("SimSun", 1, 24)); // NOI18N
        nextBtn.setPreferredSize(new java.awt.Dimension(79, 41));
        nextBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nextBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                nextBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                nextBtnMouseExited(evt);
            }
        });
        TablePnl.add(nextBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 600, 140, 60));

        firstHolder.setRoundBottomLeft(100);
        firstHolder.setRoundBottomRight(100);
        firstHolder.setRoundTopLeft(100);
        firstHolder.setRoundTopRight(100);
        firstHolder.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        onePax.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        onePax.setText("      1 - 2 PAX");
        firstHolder.add(onePax, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 200, 50));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 3, 15)); // NOI18N
        jLabel11.setText(" Quantity: ");
        jLabel11.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        firstHolder.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 110, 20));

        onePaxQuantity.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        onePaxQuantity.setModel(new javax.swing.SpinnerNumberModel(0, 0, 10, 1));
        onePaxQuantity.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                onePaxQuantityPropertyChange(evt);
            }
        });
        firstHolder.add(onePaxQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 220, 70, -1));

        onePaxImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LP_images/TableImg.png"))); // NOI18N
        firstHolder.add(onePaxImg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, -1, -1));

        TablePnl.add(firstHolder, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 200, 260));

        thirdHolder.setRoundBottomLeft(100);
        thirdHolder.setRoundBottomRight(100);
        thirdHolder.setRoundTopLeft(100);
        thirdHolder.setRoundTopRight(100);
        thirdHolder.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        threePax.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        threePax.setText("      3 - 5 PAX");
        thirdHolder.add(threePax, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 200, 50));

        threePaxQuantity.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        threePaxQuantity.setModel(new javax.swing.SpinnerNumberModel(0, 0, 8, 1));
        threePaxQuantity.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                threePaxQuantityPropertyChange(evt);
            }
        });
        thirdHolder.add(threePaxQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 220, 70, -1));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 3, 15)); // NOI18N
        jLabel18.setText(" Quantity: ");
        jLabel18.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        thirdHolder.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 110, 20));

        threePaxImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LP_images/TableImg.png"))); // NOI18N
        thirdHolder.add(threePaxImg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, -1, -1));

        TablePnl.add(thirdHolder, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 180, 200, 260));

        sixHolder.setRoundBottomLeft(100);
        sixHolder.setRoundBottomRight(100);
        sixHolder.setRoundTopLeft(100);
        sixHolder.setRoundTopRight(100);
        sixHolder.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        sixPax.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        sixPax.setText("      6 - 10 PAX");
        sixHolder.add(sixPax, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 200, 50));

        sixPaxQuantity.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        sixPaxQuantity.setModel(new javax.swing.SpinnerNumberModel(0, 0, 5, 1));
        sixPaxQuantity.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                sixPaxQuantityPropertyChange(evt);
            }
        });
        sixHolder.add(sixPaxQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 220, 70, -1));

        jLabel23.setFont(new java.awt.Font("Segoe UI", 3, 15)); // NOI18N
        jLabel23.setText(" Quantity: ");
        jLabel23.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        sixHolder.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 110, 20));

        sixPaxImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LP_images/TableImg.png"))); // NOI18N
        sixHolder.add(sixPaxImg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, -1, -1));

        TablePnl.add(sixHolder, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 180, 200, 260));

        tenHolder.setRoundBottomLeft(100);
        tenHolder.setRoundBottomRight(100);
        tenHolder.setRoundTopLeft(100);
        tenHolder.setRoundTopRight(100);
        tenHolder.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tenPax.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        tenPax.setText("     10 - 15 PAX");
        tenHolder.add(tenPax, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 200, 50));

        tenPaxQuantity.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        tenPaxQuantity.setModel(new javax.swing.SpinnerNumberModel(0, 0, 5, 1));
        tenPaxQuantity.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tenPaxQuantityPropertyChange(evt);
            }
        });
        tenHolder.add(tenPaxQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 220, 70, -1));

        jLabel24.setFont(new java.awt.Font("Segoe UI", 3, 15)); // NOI18N
        jLabel24.setText(" Quantity: ");
        jLabel24.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        tenHolder.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 110, 20));

        tenPaxImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LP_images/TableImg.png"))); // NOI18N
        tenHolder.add(tenPaxImg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, -1, -1));

        TablePnl.add(tenHolder, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 180, 200, 260));

        tableShow.setText("...");
        tableShow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tableShowActionPerformed(evt);
            }
        });
        TablePnl.add(tableShow, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 53, 40, 30));

        searchIcon2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LP_images/Search.png"))); // NOI18N
        searchIcon2.setText(" ");
        searchIcon2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchIcon2MouseClicked(evt);
            }
        });
        TablePnl.add(searchIcon2, new org.netbeans.lib.awtextra.AbsoluteConstraints(928, 53, -1, -1));

        cartIcon15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LP_images/Cart.png"))); // NOI18N
        TablePnl.add(cartIcon15, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 450, 40, 40));

        onePaxReserve.setBackground(new java.awt.Color(245, 245, 245));
        onePaxReserve.setText("  RESERVE");
        onePaxReserve.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        onePaxReserve.setFont(new java.awt.Font("SimSun", 1, 24)); // NOI18N
        onePaxReserve.setPreferredSize(new java.awt.Dimension(79, 41));
        onePaxReserve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onePaxReserveActionPerformed(evt);
            }
        });
        TablePnl.add(onePaxReserve, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 450, 180, 50));

        cartIcon16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LP_images/Cart.png"))); // NOI18N
        TablePnl.add(cartIcon16, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 450, 40, 40));

        threePaxdupe.setBackground(new java.awt.Color(245, 245, 245));
        threePaxdupe.setText("  RESERVE");
        threePaxdupe.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        threePaxdupe.setFont(new java.awt.Font("SimSun", 1, 24)); // NOI18N
        threePaxdupe.setPreferredSize(new java.awt.Dimension(79, 41));
        threePaxdupe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                threePaxdupeActionPerformed(evt);
            }
        });
        TablePnl.add(threePaxdupe, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 450, 180, 50));

        cartIcon17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LP_images/Cart.png"))); // NOI18N
        TablePnl.add(cartIcon17, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 450, 40, 40));

        sixPaxReserve.setBackground(new java.awt.Color(245, 245, 245));
        sixPaxReserve.setText("  RESERVE");
        sixPaxReserve.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        sixPaxReserve.setFont(new java.awt.Font("SimSun", 1, 24)); // NOI18N
        sixPaxReserve.setPreferredSize(new java.awt.Dimension(79, 41));
        sixPaxReserve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sixPaxReserveActionPerformed(evt);
            }
        });
        TablePnl.add(sixPaxReserve, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 450, 180, 50));

        cartIcon18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LP_images/Cart.png"))); // NOI18N
        TablePnl.add(cartIcon18, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 450, 40, 40));

        tenPaxReserve.setBackground(new java.awt.Color(245, 245, 245));
        tenPaxReserve.setText("  RESERVE");
        tenPaxReserve.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tenPaxReserve.setFont(new java.awt.Font("SimSun", 1, 24)); // NOI18N
        tenPaxReserve.setPreferredSize(new java.awt.Dimension(79, 41));
        tenPaxReserve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tenPaxReserveActionPerformed(evt);
            }
        });
        TablePnl.add(tenPaxReserve, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 450, 180, 50));

        timeHolderTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                timeHolderTableActionPerformed(evt);
            }
        });
        TablePnl.add(timeHolderTable, new org.netbeans.lib.awtextra.AbsoluteConstraints(815, 50, 80, -1));
        TablePnl.add(dateShow, new org.netbeans.lib.awtextra.AbsoluteConstraints(715, 50, 100, -1));

        tableShow1.setText("...");
        tableShow1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tableShow1ActionPerformed(evt);
            }
        });
        TablePnl.add(tableShow1, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 53, 40, 30));

        onePaxdupe.setBackground(new java.awt.Color(245, 245, 245));
        onePaxdupe.setText("  RESERVE");
        onePaxdupe.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        onePaxdupe.setFont(new java.awt.Font("SimSun", 1, 24)); // NOI18N
        onePaxdupe.setPreferredSize(new java.awt.Dimension(79, 41));
        TablePnl.add(onePaxdupe, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 450, 180, 50));

        threePaxReserve1.setBackground(new java.awt.Color(245, 245, 245));
        threePaxReserve1.setText("  RESERVE");
        threePaxReserve1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        threePaxReserve1.setFont(new java.awt.Font("SimSun", 1, 24)); // NOI18N
        threePaxReserve1.setPreferredSize(new java.awt.Dimension(79, 41));
        TablePnl.add(threePaxReserve1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 450, 180, 50));

        sixPaxdupe.setBackground(new java.awt.Color(245, 245, 245));
        sixPaxdupe.setText("  RESERVE");
        sixPaxdupe.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        sixPaxdupe.setFont(new java.awt.Font("SimSun", 1, 24)); // NOI18N
        sixPaxdupe.setPreferredSize(new java.awt.Dimension(79, 41));
        TablePnl.add(sixPaxdupe, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 450, 180, 50));

        tenPaxdupe.setBackground(new java.awt.Color(245, 245, 245));
        tenPaxdupe.setText("  RESERVE");
        tenPaxdupe.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tenPaxdupe.setFont(new java.awt.Font("SimSun", 1, 24)); // NOI18N
        tenPaxdupe.setPreferredSize(new java.awt.Dimension(79, 41));
        TablePnl.add(tenPaxdupe, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 450, 180, 50));
        TablePnl.add(testUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 560, 130, 60));

        Background.setBackground(new java.awt.Color(204, 255, 255));
        Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LP_images/packs.png"))); // NOI18N
        Background.setRequestFocusEnabled(false);
        TablePnl.add(Background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        Base.add(TablePnl, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 980, 676));

        FoodPnl.setPreferredSize(new java.awt.Dimension(980, 676));
        FoodPnl.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cartIcon2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LP_images/Cart.png"))); // NOI18N
        FoodPnl.add(cartIcon2, new org.netbeans.lib.awtextra.AbsoluteConstraints(733, 591, 40, 40));

        pancitOrder.setBackground(new java.awt.Color(245, 245, 245));
        pancitOrder.setText("  ADD TO CART");
        pancitOrder.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pancitOrder.setFont(new java.awt.Font("SimSun", 1, 24)); // NOI18N
        pancitOrder.setPreferredSize(new java.awt.Dimension(79, 41));
        pancitOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pancitOrderActionPerformed(evt);
            }
        });
        FoodPnl.add(pancitOrder, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 590, 210, 50));

        cartIcon1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LP_images/Cart.png"))); // NOI18N
        FoodPnl.add(cartIcon1, new org.netbeans.lib.awtextra.AbsoluteConstraints(395, 591, 40, 40));

        empOrder.setBackground(new java.awt.Color(245, 245, 245));
        empOrder.setText("  ADD TO CART");
        empOrder.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        empOrder.setFont(new java.awt.Font("SimSun", 1, 24)); // NOI18N
        empOrder.setPreferredSize(new java.awt.Dimension(79, 41));
        empOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                empOrderActionPerformed(evt);
            }
        });
        FoodPnl.add(empOrder, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 590, 210, 50));

        cartIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LP_images/Cart.png"))); // NOI18N
        FoodPnl.add(cartIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 591, 40, 40));

        crabOrder.setBackground(new java.awt.Color(245, 245, 245));
        crabOrder.setText("  ADD TO CART");
        crabOrder.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        crabOrder.setFont(new java.awt.Font("SimSun", 1, 24)); // NOI18N
        crabOrder.setPreferredSize(new java.awt.Dimension(79, 41));
        crabOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crabOrderActionPerformed(evt);
            }
        });
        FoodPnl.add(crabOrder, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 590, 210, 50));

        apeBtn.setBackground(new java.awt.Color(245, 245, 245));
        apeBtn.setText("Appetizer");
        apeBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        apeBtn.setFont(new java.awt.Font("SimSun", 1, 24)); // NOI18N
        apeBtn.setPreferredSize(new java.awt.Dimension(79, 41));
        apeBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                apeBtnMouseClicked(evt);
            }
        });
        FoodPnl.add(apeBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 160, 50));

        Entree.setBackground(new java.awt.Color(245, 245, 245));
        Entree.setText("Entree");
        Entree.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Entree.setFont(new java.awt.Font("SimSun", 1, 24)); // NOI18N
        Entree.setPreferredSize(new java.awt.Dimension(79, 41));
        Entree.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EntreeMouseClicked(evt);
            }
        });
        FoodPnl.add(Entree, new org.netbeans.lib.awtextra.AbsoluteConstraints(205, 130, 160, 50));

        Rice.setBackground(new java.awt.Color(249, 249, 249));
        Rice.setText("Rice");
        Rice.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Rice.setFont(new java.awt.Font("SimSun", 1, 24)); // NOI18N
        Rice.setPreferredSize(new java.awt.Dimension(79, 41));
        Rice.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RiceMouseClicked(evt);
            }
        });
        FoodPnl.add(Rice, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 130, 160, 50));

        Desert.setBackground(new java.awt.Color(249, 249, 249));
        Desert.setText("Desert");
        Desert.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Desert.setFont(new java.awt.Font("SimSun", 1, 24)); // NOI18N
        Desert.setPreferredSize(new java.awt.Dimension(79, 41));
        Desert.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DesertMouseClicked(evt);
            }
        });
        FoodPnl.add(Desert, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 130, 160, 50));

        Beverage.setBackground(new java.awt.Color(249, 249, 249));
        Beverage.setText("Beverage");
        Beverage.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Beverage.setFont(new java.awt.Font("SimSun", 1, 24)); // NOI18N
        Beverage.setPreferredSize(new java.awt.Dimension(79, 41));
        Beverage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BeverageMouseClicked(evt);
            }
        });
        FoodPnl.add(Beverage, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 130, 160, 50));

        pancitHolder.setRoundBottomLeft(100);
        pancitHolder.setRoundBottomRight(100);
        pancitHolder.setRoundTopLeft(100);
        pancitHolder.setRoundTopRight(100);
        pancitHolder.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pancitTitle.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        pancitTitle.setText("        SPECIAL PANCIT");
        pancitHolder.add(pancitTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 225, 50));

        pancitPrice.setFont(new java.awt.Font("Rockwell", 1, 24)); // NOI18N
        pancitPrice.setText("       200.00 PHP");
        pancitPrice.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        pancitHolder.add(pancitPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 225, 30));

        Description7.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        Description7.setText("      vegetables, shrimp, and pork");
        Description7.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        pancitHolder.add(Description7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 225, 30));

        Description8.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        Description8.setText("      Stir-fried noodles tossed with ");
        Description8.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        pancitHolder.add(Description8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 225, 30));

        Description9.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        Description9.setText("         seasoned with soy sauce.");
        Description9.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        pancitHolder.add(Description9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 225, 30));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 3, 15)); // NOI18N
        jLabel13.setText(" Quantity: ");
        jLabel13.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        pancitHolder.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, 110, 20));

        pancitQuantity.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        pancitQuantity.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        pancitQuantity.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                pancitQuantityPropertyChange(evt);
            }
        });
        pancitHolder.add(pancitQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(114, 340, 70, -1));

        roundLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LP_images/PancitImg.png"))); // NOI18N
        pancitHolder.add(roundLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        FoodPnl.add(pancitHolder, new org.netbeans.lib.awtextra.AbsoluteConstraints(713, 200, -1, 380));

        empHolder.setRoundBottomLeft(100);
        empHolder.setRoundBottomRight(100);
        empHolder.setRoundTopLeft(100);
        empHolder.setRoundTopRight(100);
        empHolder.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        empTitle.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        empTitle.setText("     SPECIAL EMAPANDA");
        empHolder.add(empTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 225, 50));

        empPrice.setFont(new java.awt.Font("Rockwell", 1, 24)); // NOI18N
        empPrice.setText("       100.00 PHP");
        empPrice.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        empHolder.add(empPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 225, 30));

        Description4.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        Description4.setText("        encased in a buttery and ");
        Description4.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        empHolder.add(Description4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 225, 30));

        Description5.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        Description5.setText("        Meaty, savory beef filling");
        Description5.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        empHolder.add(Description5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 225, 30));

        Description6.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        Description6.setText("              and flaky crust.");
        Description6.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        empHolder.add(Description6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 225, 30));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 3, 15)); // NOI18N
        jLabel12.setText(" Quantity: ");
        jLabel12.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        empHolder.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, 110, 20));

        empQuantity.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        empQuantity.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        empQuantity.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                empQuantityPropertyChange(evt);
            }
        });
        empHolder.add(empQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(114, 340, 70, -1));

        roundLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LP_images/EmpandaImg.png"))); // NOI18N
        empHolder.add(roundLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        FoodPnl.add(empHolder, new org.netbeans.lib.awtextra.AbsoluteConstraints(376, 200, -1, 380));

        crabHolder.setRoundBottomLeft(100);
        crabHolder.setRoundBottomRight(100);
        crabHolder.setRoundTopLeft(100);
        crabHolder.setRoundTopRight(100);
        crabHolder.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        crabTitle.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        crabTitle.setText("  CRAB AND CORN SOUP");
        crabHolder.add(crabTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 225, 50));

        crabPrice.setFont(new java.awt.Font("Rockwell", 1, 24)); // NOI18N
        crabPrice.setText("        150.00 PHP");
        crabPrice.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        crabHolder.add(crabPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 225, 30));

        Description1.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        Description1.setText("   kernels in a rich broth seasoned");
        Description1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        crabHolder.add(Description1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 225, 30));

        Description2.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        Description2.setText("   Tender crab meat and sweetcorn");
        Description2.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        crabHolder.add(Description2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 225, 30));

        Description3.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        Description3.setText("     with onions, garlic, and spices.");
        Description3.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        crabHolder.add(Description3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 225, 30));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 3, 15)); // NOI18N
        jLabel10.setText(" Quantity: ");
        jLabel10.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        crabHolder.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, 110, 20));

        crabQuantity.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        crabQuantity.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        crabQuantity.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                crabQuantityPropertyChange(evt);
            }
        });
        crabHolder.add(crabQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(114, 340, 70, -1));

        roundLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LP_images/CrabImg.png"))); // NOI18N
        crabHolder.add(roundLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        FoodPnl.add(crabHolder, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, -1, 380));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LP_images/AppetizerBg.png"))); // NOI18N
        FoodPnl.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        Base.add(FoodPnl, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 980, 676));

        EntreePnl.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        apeBtn1.setBackground(new java.awt.Color(245, 245, 245));
        apeBtn1.setText("Appetizer");
        apeBtn1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        apeBtn1.setFont(new java.awt.Font("SimSun", 1, 24)); // NOI18N
        apeBtn1.setPreferredSize(new java.awt.Dimension(79, 41));
        apeBtn1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                apeBtn1MouseClicked(evt);
            }
        });
        EntreePnl.add(apeBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 160, 50));

        Entree1.setBackground(new java.awt.Color(245, 245, 245));
        Entree1.setText("Entree");
        Entree1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Entree1.setFont(new java.awt.Font("SimSun", 1, 24)); // NOI18N
        Entree1.setPreferredSize(new java.awt.Dimension(79, 41));
        EntreePnl.add(Entree1, new org.netbeans.lib.awtextra.AbsoluteConstraints(205, 130, 160, 50));

        Rice1.setBackground(new java.awt.Color(249, 249, 249));
        Rice1.setText("Rice");
        Rice1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Rice1.setFont(new java.awt.Font("SimSun", 1, 24)); // NOI18N
        Rice1.setPreferredSize(new java.awt.Dimension(79, 41));
        Rice1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Rice1MouseClicked(evt);
            }
        });
        EntreePnl.add(Rice1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 130, 160, 50));

        Desert1.setBackground(new java.awt.Color(249, 249, 249));
        Desert1.setText("Desert");
        Desert1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Desert1.setFont(new java.awt.Font("SimSun", 1, 24)); // NOI18N
        Desert1.setPreferredSize(new java.awt.Dimension(79, 41));
        Desert1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Desert1MouseClicked(evt);
            }
        });
        EntreePnl.add(Desert1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 130, 160, 50));

        Beverage1.setBackground(new java.awt.Color(249, 249, 249));
        Beverage1.setText("Beverage");
        Beverage1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Beverage1.setFont(new java.awt.Font("SimSun", 1, 24)); // NOI18N
        Beverage1.setPreferredSize(new java.awt.Dimension(79, 41));
        Beverage1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Beverage1MouseClicked(evt);
            }
        });
        EntreePnl.add(Beverage1, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 130, 160, 50));

        cartIcon3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LP_images/Cart.png"))); // NOI18N
        EntreePnl.add(cartIcon3, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 591, 40, 40));

        bicolOrder.setBackground(new java.awt.Color(245, 245, 245));
        bicolOrder.setText("  ADD TO CART");
        bicolOrder.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bicolOrder.setFont(new java.awt.Font("SimSun", 1, 24)); // NOI18N
        bicolOrder.setPreferredSize(new java.awt.Dimension(79, 41));
        bicolOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bicolOrderActionPerformed(evt);
            }
        });
        EntreePnl.add(bicolOrder, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 590, 210, 50));

        bicolHolder.setRoundBottomLeft(100);
        bicolHolder.setRoundBottomRight(100);
        bicolHolder.setRoundTopLeft(100);
        bicolHolder.setRoundTopRight(100);
        bicolHolder.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bicolTitle.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        bicolTitle.setText("         BICOL EXPRESS");
        bicolHolder.add(bicolTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 225, 50));

        Price3.setFont(new java.awt.Font("Rockwell", 1, 24)); // NOI18N
        Price3.setText("       300.00 PHP");
        Price3.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        bicolHolder.add(Price3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 225, 30));

        Description10.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        Description10.setText("        with shrimp paste, garlic");
        Description10.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        bicolHolder.add(Description10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 225, 30));

        Description11.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        Description11.setText("      Pork cooked in Coconut milk");
        Description11.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        bicolHolder.add(Description11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 225, 30));

        Description12.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        Description12.setText("              onions and chilies.");
        Description12.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        bicolHolder.add(Description12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 225, 30));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 3, 15)); // NOI18N
        jLabel14.setText(" Quantity: ");
        jLabel14.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        bicolHolder.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, 110, 20));

        bicolQuantity.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        bicolQuantity.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        bicolQuantity.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                bicolQuantityPropertyChange(evt);
            }
        });
        bicolHolder.add(bicolQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(114, 340, 70, -1));

        bicolmg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LP_images/BicolExpressImg.png"))); // NOI18N
        bicolHolder.add(bicolmg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        EntreePnl.add(bicolHolder, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, -1, 380));

        lechonHolder.setRoundBottomLeft(100);
        lechonHolder.setRoundBottomRight(100);
        lechonHolder.setRoundTopLeft(100);
        lechonHolder.setRoundTopRight(100);
        lechonHolder.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lechonTitle.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        lechonTitle.setText("       LECHON KAWALI");
        lechonHolder.add(lechonTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 225, 50));

        Price4.setFont(new java.awt.Font("Rockwell", 1, 24)); // NOI18N
        Price4.setText("       350.00 PHP");
        Price4.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        lechonHolder.add(Price4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 225, 30));

        Description13.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        Description13.setText("            served with a side of");
        Description13.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        lechonHolder.add(Description13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 225, 30));

        Description14.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        Description14.setText("           Crispy fried pork belly");
        Description14.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        lechonHolder.add(Description14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 225, 30));

        Description15.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        Description15.setText("                   liver sauce.");
        Description15.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        lechonHolder.add(Description15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 225, 30));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 3, 15)); // NOI18N
        jLabel15.setText(" Quantity: ");
        jLabel15.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        lechonHolder.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, 110, 20));

        lechonQuantity.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lechonQuantity.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        lechonQuantity.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                lechonQuantityPropertyChange(evt);
            }
        });
        lechonHolder.add(lechonQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(114, 340, 70, -1));

        lechonImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LP_images/LechonImg.png"))); // NOI18N
        lechonHolder.add(lechonImg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        EntreePnl.add(lechonHolder, new org.netbeans.lib.awtextra.AbsoluteConstraints(376, 200, -1, 380));

        fishHolder.setRoundBottomLeft(100);
        fishHolder.setRoundBottomRight(100);
        fishHolder.setRoundTopLeft(100);
        fishHolder.setRoundTopRight(100);
        fishHolder.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        fishTitle.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        fishTitle.setText("        FISH ESCABECHE");
        fishHolder.add(fishTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 225, 50));

        Price5.setFont(new java.awt.Font("Rockwell", 1, 24)); // NOI18N
        Price5.setText("       250.00 PHP");
        Price5.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        fishHolder.add(Price5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 225, 30));

        Description16.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        Description16.setText("       medley of bell peppers, and");
        Description16.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        fishHolder.add(Description16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 225, 30));

        Description17.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        Description17.setText(" Crispy fried fish fillets topped with");
        Description17.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        fishHolder.add(Description17, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 225, 30));

        Description18.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        Description18.setText("    carrots in a sweet n’ sour sauce");
        Description18.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        fishHolder.add(Description18, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 225, 30));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 3, 15)); // NOI18N
        jLabel16.setText(" Quantity: ");
        jLabel16.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        fishHolder.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, 110, 20));

        fishQuantity.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        fishQuantity.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        fishQuantity.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                fishQuantityPropertyChange(evt);
            }
        });
        fishHolder.add(fishQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(114, 340, 70, -1));

        fishImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LP_images/FishImg.png"))); // NOI18N
        fishHolder.add(fishImg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -8, -1, -1));

        EntreePnl.add(fishHolder, new org.netbeans.lib.awtextra.AbsoluteConstraints(713, 200, -1, 380));

        cartIcon4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LP_images/Cart.png"))); // NOI18N
        EntreePnl.add(cartIcon4, new org.netbeans.lib.awtextra.AbsoluteConstraints(395, 591, 40, 40));

        lechonOrder.setBackground(new java.awt.Color(245, 245, 245));
        lechonOrder.setText("  ADD TO CART");
        lechonOrder.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lechonOrder.setFont(new java.awt.Font("SimSun", 1, 24)); // NOI18N
        lechonOrder.setPreferredSize(new java.awt.Dimension(79, 41));
        lechonOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lechonOrderActionPerformed(evt);
            }
        });
        EntreePnl.add(lechonOrder, new org.netbeans.lib.awtextra.AbsoluteConstraints(382, 590, 210, 50));

        cartIcon5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LP_images/Cart.png"))); // NOI18N
        EntreePnl.add(cartIcon5, new org.netbeans.lib.awtextra.AbsoluteConstraints(733, 591, 40, 40));

        fishOrder.setBackground(new java.awt.Color(245, 245, 245));
        fishOrder.setText("  ADD TO CART");
        fishOrder.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        fishOrder.setFont(new java.awt.Font("SimSun", 1, 24)); // NOI18N
        fishOrder.setPreferredSize(new java.awt.Dimension(79, 41));
        fishOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fishOrderActionPerformed(evt);
            }
        });
        EntreePnl.add(fishOrder, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 590, 210, 50));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LP_images/EntreeBg.png"))); // NOI18N
        EntreePnl.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        Base.add(EntreePnl, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 980, 676));

        RicePnl.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        apeBtn2.setBackground(new java.awt.Color(245, 245, 245));
        apeBtn2.setText("Appetizer");
        apeBtn2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        apeBtn2.setFont(new java.awt.Font("SimSun", 1, 24)); // NOI18N
        apeBtn2.setPreferredSize(new java.awt.Dimension(79, 41));
        apeBtn2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                apeBtn2MouseClicked(evt);
            }
        });
        RicePnl.add(apeBtn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 160, 50));

        Entree2.setBackground(new java.awt.Color(245, 245, 245));
        Entree2.setText("Entree");
        Entree2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Entree2.setFont(new java.awt.Font("SimSun", 1, 24)); // NOI18N
        Entree2.setPreferredSize(new java.awt.Dimension(79, 41));
        Entree2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Entree2MouseClicked(evt);
            }
        });
        RicePnl.add(Entree2, new org.netbeans.lib.awtextra.AbsoluteConstraints(205, 130, 160, 50));

        Rice2.setBackground(new java.awt.Color(249, 249, 249));
        Rice2.setText("Rice");
        Rice2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Rice2.setFont(new java.awt.Font("SimSun", 1, 24)); // NOI18N
        Rice2.setPreferredSize(new java.awt.Dimension(79, 41));
        RicePnl.add(Rice2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 130, 160, 50));

        Desert2.setBackground(new java.awt.Color(249, 249, 249));
        Desert2.setText("Desert");
        Desert2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Desert2.setFont(new java.awt.Font("SimSun", 1, 24)); // NOI18N
        Desert2.setPreferredSize(new java.awt.Dimension(79, 41));
        Desert2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Desert2MouseClicked(evt);
            }
        });
        RicePnl.add(Desert2, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 130, 160, 50));

        Beverage2.setBackground(new java.awt.Color(249, 249, 249));
        Beverage2.setText("Beverage");
        Beverage2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Beverage2.setFont(new java.awt.Font("SimSun", 1, 24)); // NOI18N
        Beverage2.setPreferredSize(new java.awt.Dimension(79, 41));
        Beverage2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Beverage2MouseClicked(evt);
            }
        });
        RicePnl.add(Beverage2, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 130, 160, 50));

        JasmineHolder.setRoundBottomLeft(100);
        JasmineHolder.setRoundBottomRight(100);
        JasmineHolder.setRoundTopLeft(100);
        JasmineHolder.setRoundTopRight(100);
        JasmineHolder.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jasTitle.setFont(new java.awt.Font("Serif", 1, 17)); // NOI18N
        jasTitle.setText("   STEAMED JASMINE RICE");
        JasmineHolder.add(jasTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 225, 50));

        Price6.setFont(new java.awt.Font("Rockwell", 1, 24)); // NOI18N
        Price6.setText("         30.00 PHP");
        Price6.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        JasmineHolder.add(Price6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 225, 30));

        Description19.setFont(new java.awt.Font("Segoe UI", 2, 15)); // NOI18N
        Description19.setText("                 jasmine rice.");
        Description19.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        JasmineHolder.add(Description19, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 225, 30));

        Description20.setFont(new java.awt.Font("Segoe UI", 2, 15)); // NOI18N
        Description20.setText("             Fragrant and fluffy ");
        Description20.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        JasmineHolder.add(Description20, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 225, 30));

        Description21.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        Description21.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        JasmineHolder.add(Description21, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 225, 30));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 3, 15)); // NOI18N
        jLabel17.setText(" Quantity: ");
        jLabel17.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        JasmineHolder.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, 110, 20));

        jasQuantity.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jasQuantity.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        jasQuantity.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jasQuantityPropertyChange(evt);
            }
        });
        JasmineHolder.add(jasQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(114, 340, 70, -1));

        bicolmg2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LP_images/SteamJasmineImg.png"))); // NOI18N
        JasmineHolder.add(bicolmg2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -15, -1, -1));

        RicePnl.add(JasmineHolder, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, -1, 380));

        cartIcon6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LP_images/Cart.png"))); // NOI18N
        RicePnl.add(cartIcon6, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 591, 40, 40));

        jasOrder.setBackground(new java.awt.Color(245, 245, 245));
        jasOrder.setText("  ADD TO CART");
        jasOrder.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jasOrder.setFont(new java.awt.Font("SimSun", 1, 24)); // NOI18N
        jasOrder.setPreferredSize(new java.awt.Dimension(79, 41));
        jasOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jasOrderActionPerformed(evt);
            }
        });
        RicePnl.add(jasOrder, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 590, 210, 50));

        cartIcon7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LP_images/Cart.png"))); // NOI18N
        RicePnl.add(cartIcon7, new org.netbeans.lib.awtextra.AbsoluteConstraints(395, 591, 40, 40));

        adoboOrder.setBackground(new java.awt.Color(245, 245, 245));
        adoboOrder.setText("  ADD TO CART");
        adoboOrder.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        adoboOrder.setFont(new java.awt.Font("SimSun", 1, 24)); // NOI18N
        adoboOrder.setPreferredSize(new java.awt.Dimension(79, 41));
        adoboOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adoboOrderActionPerformed(evt);
            }
        });
        RicePnl.add(adoboOrder, new org.netbeans.lib.awtextra.AbsoluteConstraints(382, 590, 210, 50));

        pancitHolder2.setRoundBottomLeft(100);
        pancitHolder2.setRoundBottomRight(100);
        pancitHolder2.setRoundTopLeft(100);
        pancitHolder2.setRoundTopRight(100);
        pancitHolder2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javaTitle.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        javaTitle.setText("            JAVA RICE");
        pancitHolder2.add(javaTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 225, 50));

        Price8.setFont(new java.awt.Font("Rockwell", 1, 24)); // NOI18N
        Price8.setText("         45.00 PHP");
        Price8.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        pancitHolder2.add(Price8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 225, 30));

        Description25.setFont(new java.awt.Font("Segoe UI", 2, 15)); // NOI18N
        Description25.setText("               aromatic rice");
        Description25.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        pancitHolder2.add(Description25, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 225, 30));

        Description26.setFont(new java.awt.Font("Segoe UI", 2, 15)); // NOI18N
        Description26.setText("              Turmeric-infused");
        Description26.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        pancitHolder2.add(Description26, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 225, 30));

        javaQuantity.setFont(new java.awt.Font("Segoe UI", 3, 15)); // NOI18N
        javaQuantity.setText(" Quantity: ");
        javaQuantity.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        pancitHolder2.add(javaQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, 110, 20));

        javaQty.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        javaQty.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        javaQty.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                javaQtyPropertyChange(evt);
            }
        });
        pancitHolder2.add(javaQty, new org.netbeans.lib.awtextra.AbsoluteConstraints(114, 340, 70, -1));

        bicolmg1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LP_images/JavaImg.png"))); // NOI18N
        pancitHolder2.add(bicolmg1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        RicePnl.add(pancitHolder2, new org.netbeans.lib.awtextra.AbsoluteConstraints(713, 200, -1, 380));

        cartIcon8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LP_images/Cart.png"))); // NOI18N
        RicePnl.add(cartIcon8, new org.netbeans.lib.awtextra.AbsoluteConstraints(733, 591, 40, 40));

        javaOrder.setBackground(new java.awt.Color(245, 245, 245));
        javaOrder.setText("  ADD TO CART");
        javaOrder.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        javaOrder.setFont(new java.awt.Font("SimSun", 1, 24)); // NOI18N
        javaOrder.setPreferredSize(new java.awt.Dimension(79, 41));
        javaOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                javaOrderActionPerformed(evt);
            }
        });
        RicePnl.add(javaOrder, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 590, 210, 50));

        adoboHolder.setRoundBottomLeft(100);
        adoboHolder.setRoundBottomRight(100);
        adoboHolder.setRoundTopLeft(100);
        adoboHolder.setRoundTopRight(100);
        adoboHolder.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        adoboTitle.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        adoboTitle.setText("           ADOBO RICE");
        adoboHolder.add(adoboTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 225, 50));

        Price15.setFont(new java.awt.Font("Rockwell", 1, 24)); // NOI18N
        Price15.setText("          45.00 PHP");
        Price15.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        adoboHolder.add(Price15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 225, 30));

        Description46.setFont(new java.awt.Font("Segoe UI", 2, 15)); // NOI18N
        Description46.setText("                 adobo flavors");
        Description46.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        adoboHolder.add(Description46, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 225, 30));

        Description47.setFont(new java.awt.Font("Segoe UI", 2, 15)); // NOI18N
        Description47.setText("               Rice infused with");
        Description47.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        adoboHolder.add(Description47, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 225, 30));

        Description48.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        Description48.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        adoboHolder.add(Description48, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 225, 30));

        jLabel26.setFont(new java.awt.Font("Segoe UI", 3, 15)); // NOI18N
        jLabel26.setText(" Quantity: ");
        jLabel26.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        adoboHolder.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, 110, 20));

        adoboQuantity.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        adoboQuantity.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        adoboQuantity.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                adoboQuantityPropertyChange(evt);
            }
        });
        adoboHolder.add(adoboQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(114, 340, 70, -1));

        bicolmg3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LP_images/AdoboImg.png"))); // NOI18N
        adoboHolder.add(bicolmg3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        RicePnl.add(adoboHolder, new org.netbeans.lib.awtextra.AbsoluteConstraints(376, 200, -1, 380));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LP_images/RiceBg.png"))); // NOI18N
        RicePnl.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        Base.add(RicePnl, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 980, 676));

        DesertPnl.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        apeBtn3.setBackground(new java.awt.Color(245, 245, 245));
        apeBtn3.setText("Appetizer");
        apeBtn3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        apeBtn3.setFont(new java.awt.Font("SimSun", 1, 24)); // NOI18N
        apeBtn3.setPreferredSize(new java.awt.Dimension(79, 41));
        apeBtn3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                apeBtn3MouseClicked(evt);
            }
        });
        DesertPnl.add(apeBtn3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 160, 50));

        Entree3.setBackground(new java.awt.Color(245, 245, 245));
        Entree3.setText("Entree");
        Entree3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Entree3.setFont(new java.awt.Font("SimSun", 1, 24)); // NOI18N
        Entree3.setPreferredSize(new java.awt.Dimension(79, 41));
        Entree3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Entree3MouseClicked(evt);
            }
        });
        DesertPnl.add(Entree3, new org.netbeans.lib.awtextra.AbsoluteConstraints(205, 130, 160, 50));

        Rice3.setBackground(new java.awt.Color(249, 249, 249));
        Rice3.setText("Rice");
        Rice3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Rice3.setFont(new java.awt.Font("SimSun", 1, 24)); // NOI18N
        Rice3.setPreferredSize(new java.awt.Dimension(79, 41));
        Rice3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Rice3MouseClicked(evt);
            }
        });
        DesertPnl.add(Rice3, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 130, 160, 50));

        Desert3.setBackground(new java.awt.Color(249, 249, 249));
        Desert3.setText("Desert");
        Desert3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Desert3.setFont(new java.awt.Font("SimSun", 1, 24)); // NOI18N
        Desert3.setPreferredSize(new java.awt.Dimension(79, 41));
        DesertPnl.add(Desert3, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 130, 160, 50));

        Beverage3.setBackground(new java.awt.Color(249, 249, 249));
        Beverage3.setText("Beverage");
        Beverage3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Beverage3.setFont(new java.awt.Font("SimSun", 1, 24)); // NOI18N
        Beverage3.setPreferredSize(new java.awt.Dimension(79, 41));
        Beverage3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Beverage3MouseClicked(evt);
            }
        });
        DesertPnl.add(Beverage3, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 130, 160, 50));

        cartIcon9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LP_images/Cart.png"))); // NOI18N
        DesertPnl.add(cartIcon9, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 591, 40, 40));

        halohaloOrder.setBackground(new java.awt.Color(245, 245, 245));
        halohaloOrder.setText("  ADD TO CART");
        halohaloOrder.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        halohaloOrder.setFont(new java.awt.Font("SimSun", 1, 24)); // NOI18N
        halohaloOrder.setPreferredSize(new java.awt.Dimension(79, 41));
        halohaloOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                halohaloOrderActionPerformed(evt);
            }
        });
        DesertPnl.add(halohaloOrder, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 590, 210, 50));

        halohaloHolder.setRoundBottomLeft(100);
        halohaloHolder.setRoundBottomRight(100);
        halohaloHolder.setRoundTopLeft(100);
        halohaloHolder.setRoundTopRight(100);
        halohaloHolder.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        halohaloTitle.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        halohaloTitle.setText("           HALO - HALO");
        halohaloHolder.add(halohaloTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 225, 50));

        Price9.setFont(new java.awt.Font("Rockwell", 1, 24)); // NOI18N
        Price9.setText("        150.00 PHP");
        Price9.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        halohaloHolder.add(Price9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 225, 30));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 3, 15)); // NOI18N
        jLabel20.setText(" Quantity: ");
        jLabel20.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        halohaloHolder.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, 110, 20));

        haloQuantity.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        haloQuantity.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        haloQuantity.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                haloQuantityPropertyChange(evt);
            }
        });
        halohaloHolder.add(haloQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(114, 340, 70, -1));

        Description37.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        Description37.setText("     A classic Filipino dessert made ");
        Description37.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        halohaloHolder.add(Description37, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 225, 30));

        Description34.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        Description34.setText("     with a mix of shaved ice, fruits");
        Description34.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        halohaloHolder.add(Description34, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 225, 30));

        Description39.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        Description39.setText("     and ube with ice cream on top.");
        Description39.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        halohaloHolder.add(Description39, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 225, 30));

        bicolmg5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LP_images/haloImg.png"))); // NOI18N
        halohaloHolder.add(bicolmg5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        DesertPnl.add(halohaloHolder, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, -1, 380));

        pandanHolder.setRoundBottomLeft(100);
        pandanHolder.setRoundBottomRight(100);
        pandanHolder.setRoundTopLeft(100);
        pandanHolder.setRoundTopRight(100);
        pandanHolder.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pandanTitle.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        pandanTitle.setText("     PANDAN GULAMAN");
        pandanHolder.add(pandanTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 225, 50));

        Price10.setFont(new java.awt.Font("Rockwell", 1, 24)); // NOI18N
        Price10.setText("         100.00 PHP");
        Price10.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        pandanHolder.add(Price10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 225, 30));

        Description31.setFont(new java.awt.Font("Segoe UI", 2, 16)); // NOI18N
        Description31.setText("                      milk.");
        Description31.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        pandanHolder.add(Description31, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 225, 30));

        Description32.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        Description32.setText("         Pandan-flavored gelatin");
        Description32.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        pandanHolder.add(Description32, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 225, 30));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 3, 15)); // NOI18N
        jLabel21.setText(" Quantity: ");
        jLabel21.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        pandanHolder.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, 110, 20));

        pandanQuantity.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        pandanQuantity.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        pandanQuantity.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                pandanQuantityPropertyChange(evt);
            }
        });
        pandanHolder.add(pandanQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(114, 340, 70, -1));

        Description40.setFont(new java.awt.Font("Segoe UI", 2, 16)); // NOI18N
        Description40.setText("           with sweet coconut");
        Description40.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        pandanHolder.add(Description40, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 225, 30));

        bicolmg6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LP_images/PandanImg.png"))); // NOI18N
        pandanHolder.add(bicolmg6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -13, -1, -1));

        bicolmg7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LP_images/PandanImg.png"))); // NOI18N
        pandanHolder.add(bicolmg7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -13, -1, -1));

        DesertPnl.add(pandanHolder, new org.netbeans.lib.awtextra.AbsoluteConstraints(376, 200, -1, 380));

        cartIcon10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LP_images/Cart.png"))); // NOI18N
        DesertPnl.add(cartIcon10, new org.netbeans.lib.awtextra.AbsoluteConstraints(395, 591, 40, 40));

        gulamanOrder.setBackground(new java.awt.Color(245, 245, 245));
        gulamanOrder.setText("  ADD TO CART");
        gulamanOrder.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        gulamanOrder.setFont(new java.awt.Font("SimSun", 1, 24)); // NOI18N
        gulamanOrder.setPreferredSize(new java.awt.Dimension(79, 41));
        gulamanOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gulamanOrderActionPerformed(evt);
            }
        });
        DesertPnl.add(gulamanOrder, new org.netbeans.lib.awtextra.AbsoluteConstraints(382, 590, 210, 50));

        cartIcon11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LP_images/Cart.png"))); // NOI18N
        DesertPnl.add(cartIcon11, new org.netbeans.lib.awtextra.AbsoluteConstraints(733, 591, 40, 40));

        majaOrder.setBackground(new java.awt.Color(245, 245, 245));
        majaOrder.setText("  ADD TO CART");
        majaOrder.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        majaOrder.setFont(new java.awt.Font("SimSun", 1, 24)); // NOI18N
        majaOrder.setPreferredSize(new java.awt.Dimension(79, 41));
        majaOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                majaOrderActionPerformed(evt);
            }
        });
        DesertPnl.add(majaOrder, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 590, 210, 50));

        majaHolder.setRoundBottomLeft(100);
        majaHolder.setRoundBottomRight(100);
        majaHolder.setRoundTopLeft(100);
        majaHolder.setRoundTopRight(100);
        majaHolder.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        majaTitle.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        majaTitle.setText("         MAJA BLANCA");
        majaHolder.add(majaTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 225, 50));

        Price11.setFont(new java.awt.Font("Rockwell", 1, 24)); // NOI18N
        Price11.setText("       120.00 PHP");
        Price11.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        majaHolder.add(Price11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 225, 30));

        Description35.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        Description35.setText("    creamy coconut pudding made");
        Description35.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        majaHolder.add(Description35, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 225, 30));

        Description36.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        Description36.setText("          sugar, and latik on top.");
        Description36.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        majaHolder.add(Description36, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 225, 30));

        jLabel22.setFont(new java.awt.Font("Segoe UI", 3, 15)); // NOI18N
        jLabel22.setText(" Quantity: ");
        jLabel22.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        majaHolder.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, 110, 20));

        majaQuantity.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        majaQuantity.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        majaQuantity.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                majaQuantityPropertyChange(evt);
            }
        });
        majaHolder.add(majaQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(114, 340, 70, -1));

        Description38.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        Description38.setText("     with coconut milk, cornstarch ");
        Description38.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        majaHolder.add(Description38, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 225, 30));

        bicolmg4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LP_images/MajaImg.png"))); // NOI18N
        majaHolder.add(bicolmg4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -15, -1, -1));

        DesertPnl.add(majaHolder, new org.netbeans.lib.awtextra.AbsoluteConstraints(713, 200, -1, 380));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LP_images/DesertBg.png"))); // NOI18N
        DesertPnl.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        Base.add(DesertPnl, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 980, 676));

        BeveragePnl.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        apeBtn4.setBackground(new java.awt.Color(245, 245, 245));
        apeBtn4.setText("Appetizer");
        apeBtn4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        apeBtn4.setFont(new java.awt.Font("SimSun", 1, 24)); // NOI18N
        apeBtn4.setPreferredSize(new java.awt.Dimension(79, 41));
        apeBtn4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                apeBtn4MouseClicked(evt);
            }
        });
        BeveragePnl.add(apeBtn4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 160, 50));

        Entree4.setBackground(new java.awt.Color(245, 245, 245));
        Entree4.setText("Entree");
        Entree4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Entree4.setFont(new java.awt.Font("SimSun", 1, 24)); // NOI18N
        Entree4.setPreferredSize(new java.awt.Dimension(79, 41));
        Entree4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Entree4MouseClicked(evt);
            }
        });
        BeveragePnl.add(Entree4, new org.netbeans.lib.awtextra.AbsoluteConstraints(205, 130, 160, 50));

        Rice4.setBackground(new java.awt.Color(249, 249, 249));
        Rice4.setText("Rice");
        Rice4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Rice4.setFont(new java.awt.Font("SimSun", 1, 24)); // NOI18N
        Rice4.setPreferredSize(new java.awt.Dimension(79, 41));
        Rice4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Rice4MouseClicked(evt);
            }
        });
        BeveragePnl.add(Rice4, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 130, 160, 50));

        Desert4.setBackground(new java.awt.Color(249, 249, 249));
        Desert4.setText("Desert");
        Desert4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Desert4.setFont(new java.awt.Font("SimSun", 1, 24)); // NOI18N
        Desert4.setPreferredSize(new java.awt.Dimension(79, 41));
        Desert4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Desert4MouseClicked(evt);
            }
        });
        BeveragePnl.add(Desert4, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 130, 160, 50));

        Beverage4.setBackground(new java.awt.Color(249, 249, 249));
        Beverage4.setText("Beverage");
        Beverage4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Beverage4.setFont(new java.awt.Font("SimSun", 1, 24)); // NOI18N
        Beverage4.setPreferredSize(new java.awt.Dimension(79, 41));
        BeveragePnl.add(Beverage4, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 130, 160, 50));

        cartIcon12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LP_images/Cart.png"))); // NOI18N
        BeveragePnl.add(cartIcon12, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 591, 40, 40));

        iceteaOrder.setBackground(new java.awt.Color(245, 245, 245));
        iceteaOrder.setText("  ADD TO CART");
        iceteaOrder.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        iceteaOrder.setFont(new java.awt.Font("SimSun", 1, 24)); // NOI18N
        iceteaOrder.setPreferredSize(new java.awt.Dimension(79, 41));
        iceteaOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iceteaOrderActionPerformed(evt);
            }
        });
        BeveragePnl.add(iceteaOrder, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 590, 210, 50));

        cartIcon13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LP_images/Cart.png"))); // NOI18N
        BeveragePnl.add(cartIcon13, new org.netbeans.lib.awtextra.AbsoluteConstraints(395, 591, 40, 40));

        sofdrinkOrder.setBackground(new java.awt.Color(245, 245, 245));
        sofdrinkOrder.setText("  ADD TO CART");
        sofdrinkOrder.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        sofdrinkOrder.setFont(new java.awt.Font("SimSun", 1, 24)); // NOI18N
        sofdrinkOrder.setPreferredSize(new java.awt.Dimension(79, 41));
        sofdrinkOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sofdrinkOrderActionPerformed(evt);
            }
        });
        BeveragePnl.add(sofdrinkOrder, new org.netbeans.lib.awtextra.AbsoluteConstraints(382, 590, 210, 50));

        cartIcon14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LP_images/Cart.png"))); // NOI18N
        BeveragePnl.add(cartIcon14, new org.netbeans.lib.awtextra.AbsoluteConstraints(733, 591, 40, 40));

        fruitOrder.setBackground(new java.awt.Color(245, 245, 245));
        fruitOrder.setText("  ADD TO CART");
        fruitOrder.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        fruitOrder.setFont(new java.awt.Font("SimSun", 1, 24)); // NOI18N
        fruitOrder.setPreferredSize(new java.awt.Dimension(79, 41));
        fruitOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fruitOrderActionPerformed(evt);
            }
        });
        BeveragePnl.add(fruitOrder, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 590, 210, 50));

        iceteaHolder.setRoundBottomLeft(100);
        iceteaHolder.setRoundBottomRight(100);
        iceteaHolder.setRoundTopLeft(100);
        iceteaHolder.setRoundTopRight(100);
        iceteaHolder.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        teaTitle.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        teaTitle.setText(" HOUSE BLEND ICED TEA");
        iceteaHolder.add(teaTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 225, 50));

        Price16.setFont(new java.awt.Font("Rockwell", 1, 24)); // NOI18N
        Price16.setText("         70.00 PHP");
        Price16.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        iceteaHolder.add(Price16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 225, 30));

        Description30.setFont(new java.awt.Font("Segoe UI", 2, 16)); // NOI18N
        Description30.setText("        Refreshing and crafted");
        Description30.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        iceteaHolder.add(Description30, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 225, 30));

        jLabel27.setFont(new java.awt.Font("Segoe UI", 3, 15)); // NOI18N
        jLabel27.setText(" Quantity: ");
        jLabel27.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        iceteaHolder.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, 110, 20));

        teaQuantity.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        teaQuantity.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        teaQuantity.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                teaQuantityPropertyChange(evt);
            }
        });
        iceteaHolder.add(teaQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(114, 340, 70, -1));

        Description50.setFont(new java.awt.Font("Segoe UI", 2, 16)); // NOI18N
        Description50.setText("                   in-house.");
        Description50.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        iceteaHolder.add(Description50, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 265, 225, 30));

        bicolmg9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LP_images/IceteaImg.png"))); // NOI18N
        iceteaHolder.add(bicolmg9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -7, -1, -1));

        BeveragePnl.add(iceteaHolder, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, -1, 380));

        softdrinkHolder.setRoundBottomLeft(100);
        softdrinkHolder.setRoundBottomRight(100);
        softdrinkHolder.setRoundTopLeft(100);
        softdrinkHolder.setRoundTopRight(100);
        softdrinkHolder.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        softdrinkTitle.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        softdrinkTitle.setText("          SOFT DRINKS");
        softdrinkHolder.add(softdrinkTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 225, 50));

        Price17.setFont(new java.awt.Font("Rockwell", 1, 24)); // NOI18N
        Price17.setText("          70.00 PHP");
        Price17.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        softdrinkHolder.add(Price17, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 225, 30));

        Description33.setFont(new java.awt.Font("Segoe UI", 2, 16)); // NOI18N
        Description33.setText("          carbonated beverages");
        Description33.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        softdrinkHolder.add(Description33, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 225, 30));

        Description51.setFont(new java.awt.Font("Segoe UI", 2, 16)); // NOI18N
        Description51.setText("                  A variety of ");
        Description51.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        softdrinkHolder.add(Description51, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 235, 225, 30));

        jLabel28.setFont(new java.awt.Font("Segoe UI", 3, 15)); // NOI18N
        jLabel28.setText(" Quantity: ");
        jLabel28.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        softdrinkHolder.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, 110, 20));

        softDrinksQuantity.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        softDrinksQuantity.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        softDrinksQuantity.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                softDrinksQuantityPropertyChange(evt);
            }
        });
        softdrinkHolder.add(softDrinksQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(114, 340, 70, -1));

        bicolmg10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LP_images/SoftdrinksImg.png"))); // NOI18N
        softdrinkHolder.add(bicolmg10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        BeveragePnl.add(softdrinkHolder, new org.netbeans.lib.awtextra.AbsoluteConstraints(376, 200, -1, 380));

        fruitHolder.setRoundBottomLeft(100);
        fruitHolder.setRoundBottomRight(100);
        fruitHolder.setRoundTopLeft(100);
        fruitHolder.setRoundTopRight(100);
        fruitHolder.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        fruitTitle.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        fruitTitle.setText("           FRUIT JUICE");
        fruitHolder.add(fruitTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 225, 50));

        Price18.setFont(new java.awt.Font("Rockwell", 1, 24)); // NOI18N
        Price18.setText("       100.00 PHP");
        Price18.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        fruitHolder.add(Price18, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 225, 30));

        Description52.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        Description52.setText("           bursting with natural");
        Description52.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        fruitHolder.add(Description52, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 225, 30));

        Description53.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        Description53.setText("            Freshly squeezed and");
        Description53.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        fruitHolder.add(Description53, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 225, 30));

        Description54.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        Description54.setText("                    flavors.");
        Description54.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        fruitHolder.add(Description54, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 225, 30));

        jLabel29.setFont(new java.awt.Font("Segoe UI", 3, 15)); // NOI18N
        jLabel29.setText(" Quantity: ");
        jLabel29.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        fruitHolder.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, 110, 20));

        fruitQuantity.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        fruitQuantity.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        fruitQuantity.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                fruitQuantityPropertyChange(evt);
            }
        });
        fruitHolder.add(fruitQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(114, 340, 70, -1));

        bicolmg8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LP_images/FruitJuiceImg.png"))); // NOI18N
        fruitHolder.add(bicolmg8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, -1, -1));

        BeveragePnl.add(fruitHolder, new org.netbeans.lib.awtextra.AbsoluteConstraints(713, 200, -1, 380));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LP_images/BeverageBg.png"))); // NOI18N
        BeveragePnl.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        Base.add(BeveragePnl, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 980, 676));

        EventPnl.setPreferredSize(new java.awt.Dimension(980, 676));
        EventPnl.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        holidayHolder.setRoundBottomLeft(100);
        holidayHolder.setRoundBottomRight(100);
        holidayHolder.setRoundTopLeft(100);
        holidayHolder.setRoundTopRight(100);
        holidayHolder.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        holidayTitle.setFont(new java.awt.Font("Serif", 1, 20)); // NOI18N
        holidayTitle.setText("   HOLIDAY PARTY");
        holidayHolder.add(holidayTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 200, 50));

        holidayPrice.setFont(new java.awt.Font("Rockwell", 1, 24)); // NOI18N
        holidayPrice.setText("     2500.00 PHP");
        holidayPrice.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        holidayHolder.add(holidayPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 200, 30));

        holidayImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LP_images/ChristmasImg.png"))); // NOI18N
        holidayHolder.add(holidayImg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, -1, -1));

        EventPnl.add(holidayHolder, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 190, 200, 270));

        weddingHolder.setRoundBottomLeft(100);
        weddingHolder.setRoundBottomRight(100);
        weddingHolder.setRoundTopLeft(100);
        weddingHolder.setRoundTopRight(100);
        weddingHolder.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        weddingTitle.setFont(new java.awt.Font("Serif", 1, 17)); // NOI18N
        weddingTitle.setText(" WEDDING  RECEPTION");
        weddingHolder.add(weddingTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 200, 50));

        weddingPrice.setFont(new java.awt.Font("Rockwell", 1, 24)); // NOI18N
        weddingPrice.setText("    10000.00 PHP");
        weddingPrice.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        weddingHolder.add(weddingPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 200, 30));

        weddingImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LP_images/WeedingImg.png"))); // NOI18N
        weddingHolder.add(weddingImg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, -1, -1));

        EventPnl.add(weddingHolder, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 190, 200, 270));

        valentinesHolder.setRoundBottomLeft(100);
        valentinesHolder.setRoundBottomRight(100);
        valentinesHolder.setRoundTopLeft(100);
        valentinesHolder.setRoundTopRight(100);
        valentinesHolder.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        valentineTitle.setFont(new java.awt.Font("Serif", 1, 20)); // NOI18N
        valentineTitle.setText("  VALENTINES DAY");
        valentinesHolder.add(valentineTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 200, 50));

        valentinePrice.setFont(new java.awt.Font("Rockwell", 1, 24)); // NOI18N
        valentinePrice.setText("     2000.00 PHP");
        valentinePrice.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        valentinesHolder.add(valentinePrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 200, 30));

        valentineImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LP_images/dateImg.png"))); // NOI18N
        valentinesHolder.add(valentineImg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -22, -1, -1));

        EventPnl.add(valentinesHolder, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 190, 200, 270));

        birthdayHolder.setRoundBottomLeft(100);
        birthdayHolder.setRoundBottomRight(100);
        birthdayHolder.setRoundTopLeft(100);
        birthdayHolder.setRoundTopRight(100);
        birthdayHolder.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bdayTitle.setFont(new java.awt.Font("Serif", 1, 20)); // NOI18N
        bdayTitle.setText("   BIRTHDAY PARTY");
        birthdayHolder.add(bdayTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 200, 50));

        bdayPrice.setFont(new java.awt.Font("Rockwell", 1, 24)); // NOI18N
        bdayPrice.setText("     4500.00 PHP");
        bdayPrice.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        birthdayHolder.add(bdayPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 200, 30));

        bdayImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LP_images/BirthdayImg.png"))); // NOI18N
        birthdayHolder.add(bdayImg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -15, -1, -1));

        EventPnl.add(birthdayHolder, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 200, 270));

        jSeparator7.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator7.setForeground(new java.awt.Color(0, 0, 0));
        EventPnl.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 640, 60, -1));
        EventPnl.add(dateHolderEvent, new org.netbeans.lib.awtextra.AbsoluteConstraints(715, 50, 100, -1));

        nextBtn1.setBackground(new java.awt.Color(249, 249, 249));
        nextBtn1.setText("NEXT");
        nextBtn1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        nextBtn1.setFont(new java.awt.Font("SimSun", 1, 24)); // NOI18N
        nextBtn1.setPreferredSize(new java.awt.Dimension(79, 41));
        nextBtn1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nextBtn1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                nextBtn1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                nextBtn1MouseExited(evt);
            }
        });
        EventPnl.add(nextBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 600, 140, 60));

        showEvent.setText("...");
        showEvent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showEventActionPerformed(evt);
            }
        });
        EventPnl.add(showEvent, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 53, 40, 30));

        searchIcon1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LP_images/Search.png"))); // NOI18N
        searchIcon1.setText(" ");
        searchIcon1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchIcon1MouseClicked(evt);
            }
        });
        EventPnl.add(searchIcon1, new org.netbeans.lib.awtextra.AbsoluteConstraints(928, 52, -1, -1));

        cartIcon19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LP_images/Cart.png"))); // NOI18N
        EventPnl.add(cartIcon19, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 470, 40, 40));

        holidayReserve.setBackground(new java.awt.Color(245, 245, 245));
        holidayReserve.setText("  RESERVE");
        holidayReserve.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        holidayReserve.setFont(new java.awt.Font("SimSun", 1, 24)); // NOI18N
        holidayReserve.setPreferredSize(new java.awt.Dimension(79, 41));
        holidayReserve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                holidayReserveActionPerformed(evt);
            }
        });
        EventPnl.add(holidayReserve, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 470, 180, 50));

        cartIcon20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LP_images/Cart.png"))); // NOI18N
        EventPnl.add(cartIcon20, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 470, 40, 40));

        weddingReserve.setBackground(new java.awt.Color(245, 245, 245));
        weddingReserve.setText("  RESERVE");
        weddingReserve.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        weddingReserve.setFont(new java.awt.Font("SimSun", 1, 24)); // NOI18N
        weddingReserve.setPreferredSize(new java.awt.Dimension(79, 41));
        weddingReserve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                weddingReserveActionPerformed(evt);
            }
        });
        EventPnl.add(weddingReserve, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 470, 180, 50));

        cartIcon21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LP_images/Cart.png"))); // NOI18N
        EventPnl.add(cartIcon21, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 470, 40, 40));

        valentineReserve.setBackground(new java.awt.Color(245, 245, 245));
        valentineReserve.setText("  RESERVE");
        valentineReserve.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        valentineReserve.setFont(new java.awt.Font("SimSun", 1, 24)); // NOI18N
        valentineReserve.setPreferredSize(new java.awt.Dimension(79, 41));
        valentineReserve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                valentineReserveActionPerformed(evt);
            }
        });
        EventPnl.add(valentineReserve, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 470, 180, 50));

        cartIcon22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LP_images/Cart.png"))); // NOI18N
        EventPnl.add(cartIcon22, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 470, 40, 40));

        bdayReserve.setBackground(new java.awt.Color(245, 245, 245));
        bdayReserve.setText("  RESERVE");
        bdayReserve.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bdayReserve.setFont(new java.awt.Font("SimSun", 1, 24)); // NOI18N
        bdayReserve.setPreferredSize(new java.awt.Dimension(79, 41));
        bdayReserve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bdayReserveActionPerformed(evt);
            }
        });
        EventPnl.add(bdayReserve, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 470, 180, 50));
        EventPnl.add(timeHolderEvents, new org.netbeans.lib.awtextra.AbsoluteConstraints(815, 50, 80, -1));

        showEventPacks.setText("...");
        showEventPacks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showEventPacksActionPerformed(evt);
            }
        });
        EventPnl.add(showEventPacks, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 53, 40, 30));

        EventBg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LP_images/EventsBg.png"))); // NOI18N
        EventPnl.add(EventBg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        Base.add(EventPnl, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 980, 676));

        PackPnl.setPreferredSize(new java.awt.Dimension(980, 676));
        PackPnl.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        xmasHolder.setRoundBottomLeft(100);
        xmasHolder.setRoundBottomRight(100);
        xmasHolder.setRoundTopLeft(100);
        xmasHolder.setRoundTopRight(100);
        xmasHolder.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        xmasTitle.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        xmasTitle.setText(" CHRISTMAS BUNDLE");
        xmasHolder.add(xmasTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 200, 50));

        Description41.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        Description41.setText("   keso de bola, lechon kawali");
        Description41.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        xmasHolder.add(Description41, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 200, 30));

        Description43.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        Description43.setText(" Beef Empanada, Chicken, Ham");
        Description43.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        xmasHolder.add(Description43, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 200, 30));

        Description44.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        Description44.setText("       spaghetti, buko pandan ");
        Description44.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        xmasHolder.add(Description44, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 200, 30));

        Description56.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        Description56.setText("  [FAMILY SIZE]");
        Description56.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        xmasHolder.add(Description56, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, 120, 30));

        xmasPrice.setFont(new java.awt.Font("Rockwell", 1, 24)); // NOI18N
        xmasPrice.setText("     1200.00 PHP");
        xmasPrice.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        xmasHolder.add(xmasPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, 200, 30));

        xmasImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LP_images/xmasbundleImg.png"))); // NOI18N
        xmasHolder.add(xmasImg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -13, -1, -1));

        PackPnl.add(xmasHolder, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 200, 330));

        valenHolder.setRoundBottomLeft(100);
        valenHolder.setRoundBottomRight(100);
        valenHolder.setRoundTopLeft(100);
        valenHolder.setRoundTopRight(100);
        valenHolder.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        vdateTitle.setFont(new java.awt.Font("Serif", 1, 20)); // NOI18N
        vdateTitle.setText(" VALENTINES DATE");
        valenHolder.add(vdateTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 200, 50));

        Description45.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        Description45.setText("      Lumpiang Togue, Caesar,");
        Description45.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        valenHolder.add(Description45, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 200, 30));

        Description55.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        Description55.setText("    House Blend Tea of Choice");
        Description55.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        valenHolder.add(Description55, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 200, 30));

        Description49.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        Description49.setText("   Chicken Alfredo Pasta, Maja");
        Description49.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        valenHolder.add(Description49, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 200, 30));

        Description60.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        Description60.setText("  [2 PAX ONLY]");
        Description60.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        valenHolder.add(Description60, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, 120, 30));

        valenPrice.setFont(new java.awt.Font("Rockwell", 1, 24)); // NOI18N
        valenPrice.setText("     1500.00 PHP");
        valenPrice.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        valenHolder.add(valenPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, 200, 30));

        valenImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LP_images/dateImg_1.png"))); // NOI18N
        valenHolder.add(valenImg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -20, -1, -1));

        PackPnl.add(valenHolder, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 190, 200, 330));

        trioHolder.setRoundBottomLeft(100);
        trioHolder.setRoundBottomRight(100);
        trioHolder.setRoundTopLeft(100);
        trioHolder.setRoundTopRight(100);
        trioHolder.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        trioTitle.setFont(new java.awt.Font("Serif", 1, 20)); // NOI18N
        trioTitle.setText("       TRIO BUNDLE");
        trioHolder.add(trioTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 200, 50));

        Description57.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        Description57.setText("        Crab and Corn Soup.");
        Description57.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        trioHolder.add(Description57, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 200, 30));

        Description59.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        Description59.setText("Halo-Halo, and Maja Blanca");
        Description59.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        trioHolder.add(Description59, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 200, 30));

        Description58.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        Description58.setText("       Pako Salad, Kare-Kare,");
        Description58.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        trioHolder.add(Description58, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 200, 30));

        Description64.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        Description64.setText("   [3 PAX ONLY]");
        Description64.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        trioHolder.add(Description64, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, 120, 30));

        trioPrice.setFont(new java.awt.Font("Rockwell", 1, 24)); // NOI18N
        trioPrice.setText("      520.00 PHP");
        trioPrice.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        trioHolder.add(trioPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, 200, 30));

        trioImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LP_images/trioImg.png"))); // NOI18N
        trioHolder.add(trioImg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, -1, -1));

        PackPnl.add(trioHolder, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 190, 200, 330));

        familyHolder.setRoundBottomLeft(100);
        familyHolder.setRoundBottomRight(100);
        familyHolder.setRoundTopLeft(100);
        familyHolder.setRoundTopRight(100);
        familyHolder.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        familyTitle.setFont(new java.awt.Font("Serif", 1, 20)); // NOI18N
        familyTitle.setText("   FAMILY BUNDLE");
        familyHolder.add(familyTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 200, 50));

        Description62.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        Description62.setText("   Fish Escabeche, Ube Halaya ");
        Description62.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        familyHolder.add(Description62, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 200, 30));

        Description61.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        Description61.setText("   Pancit Canton, Caesar Salad");
        Description61.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        familyHolder.add(Description61, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 200, 30));

        Description63.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        Description63.setText("    Fruit Juice, and Halo-Halo.");
        Description63.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        familyHolder.add(Description63, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 200, 30));

        Description42.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        Description42.setText("   [6 PAX ONLY]");
        Description42.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        familyHolder.add(Description42, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, 120, 30));

        familyPrice.setFont(new java.awt.Font("Rockwell", 1, 24)); // NOI18N
        familyPrice.setText("      1350.00 PHP");
        familyPrice.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        familyHolder.add(familyPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, 200, 30));

        familyImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LP_images/familyBundImg.png"))); // NOI18N
        familyHolder.add(familyImg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -12, -1, -1));

        PackPnl.add(familyHolder, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 190, 200, 330));
        PackPnl.add(dateHolderPack, new org.netbeans.lib.awtextra.AbsoluteConstraints(715, 50, 100, -1));

        showPack.setText("...");
        showPack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showPackActionPerformed(evt);
            }
        });
        PackPnl.add(showPack, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 53, 40, 30));

        searchIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LP_images/Search.png"))); // NOI18N
        searchIcon.setText("\n");
        searchIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchIconMouseClicked(evt);
            }
        });
        PackPnl.add(searchIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(928, 51, -1, -1));

        cartIcon23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LP_images/Cart.png"))); // NOI18N
        PackPnl.add(cartIcon23, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 530, 40, 40));

        xmasReserve.setBackground(new java.awt.Color(245, 245, 245));
        xmasReserve.setText("  RESERVE");
        xmasReserve.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        xmasReserve.setFont(new java.awt.Font("SimSun", 1, 24)); // NOI18N
        xmasReserve.setPreferredSize(new java.awt.Dimension(79, 41));
        xmasReserve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xmasReserveActionPerformed(evt);
            }
        });
        PackPnl.add(xmasReserve, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 530, 180, 50));

        cartIcon24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LP_images/Cart.png"))); // NOI18N
        PackPnl.add(cartIcon24, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 530, 40, 40));

        vdateReserve.setBackground(new java.awt.Color(245, 245, 245));
        vdateReserve.setText("  RESERVE");
        vdateReserve.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        vdateReserve.setFont(new java.awt.Font("SimSun", 1, 24)); // NOI18N
        vdateReserve.setPreferredSize(new java.awt.Dimension(79, 41));
        vdateReserve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vdateReserveActionPerformed(evt);
            }
        });
        PackPnl.add(vdateReserve, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 530, 180, 50));

        cartIcon25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LP_images/Cart.png"))); // NOI18N
        PackPnl.add(cartIcon25, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 530, 40, 40));

        trioReserve.setBackground(new java.awt.Color(245, 245, 245));
        trioReserve.setText("  RESERVE");
        trioReserve.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        trioReserve.setFont(new java.awt.Font("SimSun", 1, 24)); // NOI18N
        trioReserve.setPreferredSize(new java.awt.Dimension(79, 41));
        trioReserve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                trioReserveActionPerformed(evt);
            }
        });
        PackPnl.add(trioReserve, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 530, 180, 50));

        cartIcon26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LP_images/Cart.png"))); // NOI18N
        PackPnl.add(cartIcon26, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 530, 40, 40));

        familyReserve.setBackground(new java.awt.Color(245, 245, 245));
        familyReserve.setText("  RESERVE");
        familyReserve.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        familyReserve.setFont(new java.awt.Font("SimSun", 1, 24)); // NOI18N
        familyReserve.setPreferredSize(new java.awt.Dimension(79, 41));
        familyReserve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                familyReserveActionPerformed(evt);
            }
        });
        PackPnl.add(familyReserve, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 530, 180, 50));
        PackPnl.add(timeHolderPack, new org.netbeans.lib.awtextra.AbsoluteConstraints(815, 50, 80, -1));

        showTimePacks.setText("...");
        showTimePacks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showTimePacksActionPerformed(evt);
            }
        });
        PackPnl.add(showTimePacks, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 53, 40, 30));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LP_images/PackagesBg.png"))); // NOI18N
        PackPnl.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        Base.add(PackPnl, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 980, 676));

        CartPnl.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        totalAmount.setBackground(new java.awt.Color(255, 204, 102));
        totalAmount.setFont(new java.awt.Font("Segoe UI Black", 1, 40)); // NOI18N
        totalAmount.setText("0");
        jPanel1.add(totalAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 20, 180, 100));

        compute.setBackground(new java.awt.Color(255, 222, 176));
        compute.setForeground(new java.awt.Color(255, 255, 255));
        compute.setText("COMPUTE");
        compute.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        compute.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                computeActionPerformed(evt);
            }
        });
        jPanel1.add(compute, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 30, 220, 70));

        reserveNow.setBackground(new java.awt.Color(255, 222, 176));
        reserveNow.setForeground(new java.awt.Color(255, 255, 255));
        reserveNow.setText("RESERVE NOW");
        reserveNow.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        reserveNow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reserveNowActionPerformed(evt);
            }
        });
        jPanel1.add(reserveNow, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 30, 330, 70));

        jLabel9.setBackground(new java.awt.Color(255, 204, 102));
        jLabel9.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        jLabel9.setText(" TOTAL :");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 180, 140));

        reserveDupe3.setBackground(new java.awt.Color(255, 222, 176));
        reserveDupe3.setForeground(new java.awt.Color(255, 255, 255));
        reserveDupe3.setText("RESERVE NOW");
        reserveDupe3.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        jPanel1.add(reserveDupe3, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 30, 330, 70));

        reserveDupe2.setBackground(new java.awt.Color(255, 222, 176));
        reserveDupe2.setForeground(new java.awt.Color(255, 255, 255));
        reserveDupe2.setText("RESERVE NOW");
        reserveDupe2.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        jPanel1.add(reserveDupe2, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 30, 330, 70));

        reserveDupe1.setBackground(new java.awt.Color(255, 222, 176));
        reserveDupe1.setForeground(new java.awt.Color(255, 255, 255));
        reserveDupe1.setText("RESERVE NOW");
        reserveDupe1.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        jPanel1.add(reserveDupe1, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 30, 330, 70));

        computeDupe4.setBackground(new java.awt.Color(255, 222, 176));
        computeDupe4.setForeground(new java.awt.Color(255, 255, 255));
        computeDupe4.setText("COMPUTE");
        computeDupe4.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        jPanel1.add(computeDupe4, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 30, 220, 70));

        computeDupe3.setBackground(new java.awt.Color(255, 222, 176));
        computeDupe3.setForeground(new java.awt.Color(255, 255, 255));
        computeDupe3.setText("COMPUTE");
        computeDupe3.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        jPanel1.add(computeDupe3, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 30, 220, 70));

        computeDupe2.setBackground(new java.awt.Color(255, 222, 176));
        computeDupe2.setForeground(new java.awt.Color(255, 255, 255));
        computeDupe2.setText("COMPUTE");
        computeDupe2.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        jPanel1.add(computeDupe2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 30, 220, 70));

        computeDupe1.setBackground(new java.awt.Color(255, 222, 176));
        computeDupe1.setForeground(new java.awt.Color(255, 255, 255));
        computeDupe1.setText("COMPUTE");
        computeDupe1.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        jPanel1.add(computeDupe1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 30, 220, 70));

        reserveDupe.setBackground(new java.awt.Color(255, 222, 176));
        reserveDupe.setForeground(new java.awt.Color(255, 255, 255));
        reserveDupe.setText("RESERVE NOW");
        reserveDupe.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        jPanel1.add(reserveDupe, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 30, 330, 70));

        CartPnl.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 540, 980, 140));

        cartScroll.setBackground(new java.awt.Color(204, 204, 204));

        cartTable.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cartTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Date", "Time", "Order", "Quantity", "Price", "Action"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        cartTable.setRowHeight(40);
        cartScroll.setViewportView(cartTable);

        CartPnl.add(cartScroll, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 980, 550));

        Base.add(CartPnl, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 980, 676));

        ReservationPnl.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Cancel.setBackground(new java.awt.Color(255, 222, 176));
        Cancel.setForeground(new java.awt.Color(255, 255, 255));
        Cancel.setText("CANCEL ");
        Cancel.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        Cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelActionPerformed(evt);
            }
        });
        jPanel2.add(Cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 40, 190, 70));

        Check.setBackground(new java.awt.Color(255, 222, 176));
        Check.setForeground(new java.awt.Color(255, 255, 255));
        Check.setText("VIEW RESERVATION");
        Check.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        Check.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckActionPerformed(evt);
            }
        });
        jPanel2.add(Check, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 460, 70));

        Check1.setBackground(new java.awt.Color(255, 222, 176));
        Check1.setForeground(new java.awt.Color(255, 255, 255));
        Check1.setText("CHECK RESERVATION");
        Check1.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        jPanel2.add(Check1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 460, 70));

        Check2.setBackground(new java.awt.Color(255, 222, 176));
        Check2.setForeground(new java.awt.Color(255, 255, 255));
        Check2.setText("CHECK RESERVATION");
        Check2.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        jPanel2.add(Check2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 460, 70));

        Check3.setBackground(new java.awt.Color(255, 222, 176));
        Check3.setForeground(new java.awt.Color(255, 255, 255));
        Check3.setText("CHECK RESERVATION");
        Check3.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        jPanel2.add(Check3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 460, 70));

        Check4.setBackground(new java.awt.Color(255, 222, 176));
        Check4.setForeground(new java.awt.Color(255, 255, 255));
        Check4.setText("CHECK RESERVATION");
        Check4.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        jPanel2.add(Check4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 460, 70));

        Cancel1.setBackground(new java.awt.Color(255, 222, 176));
        Cancel1.setForeground(new java.awt.Color(255, 255, 255));
        Cancel1.setText("CANCEL RESERVATION");
        Cancel1.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        jPanel2.add(Cancel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 40, 190, 70));

        Cancel2.setBackground(new java.awt.Color(255, 222, 176));
        Cancel2.setForeground(new java.awt.Color(255, 255, 255));
        Cancel2.setText("CANCEL RESERVATION");
        Cancel2.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        jPanel2.add(Cancel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 40, 190, 70));

        Cancel3.setBackground(new java.awt.Color(255, 222, 176));
        Cancel3.setForeground(new java.awt.Color(255, 255, 255));
        Cancel3.setText("CANCEL RESERVATION");
        Cancel3.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        jPanel2.add(Cancel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 40, 190, 70));

        Cancel4.setBackground(new java.awt.Color(255, 222, 176));
        Cancel4.setForeground(new java.awt.Color(255, 255, 255));
        Cancel4.setText("CANCEL RESERVATION");
        Cancel4.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        jPanel2.add(Cancel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 40, 190, 70));

        ReservationPnl.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 540, 980, 140));

        reserveScroll.setBackground(new java.awt.Color(204, 204, 204));

        reserveTable.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        reserveTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Reservation Number", "Date", "Time", "Order", "Quantity", "Price", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        reserveTable.setRowHeight(40);
        reserveScroll.setViewportView(reserveTable);

        ReservationPnl.add(reserveScroll, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 980, 550));

        Base.add(ReservationPnl, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 980, 676));

        SettingsPnl.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ansTitle.setFont(new java.awt.Font("Sitka Banner", 1, 20)); // NOI18N
        ansTitle.setForeground(new java.awt.Color(102, 102, 102));
        ansTitle.setText("Answer:");
        SettingsPnl.add(ansTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 410, 160, 50));

        jLabel8.setBackground(new java.awt.Color(102, 102, 102));
        jLabel8.setFont(new java.awt.Font("Sitka Banner", 1, 30)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setText("Account Information");
        SettingsPnl.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 130, 310, 50));

        userTitle.setFont(new java.awt.Font("Sitka Banner", 1, 20)); // NOI18N
        userTitle.setForeground(new java.awt.Color(102, 102, 102));
        userTitle.setText("Username:");
        SettingsPnl.add(userTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 200, 100, 50));

        passTitle.setFont(new java.awt.Font("Sitka Banner", 1, 20)); // NOI18N
        passTitle.setForeground(new java.awt.Color(102, 102, 102));
        passTitle.setText("Password:");
        SettingsPnl.add(passTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 270, 100, 50));

        secuTitle.setFont(new java.awt.Font("Sitka Banner", 1, 20)); // NOI18N
        secuTitle.setForeground(new java.awt.Color(102, 102, 102));
        secuTitle.setText("Security Question:");
        SettingsPnl.add(secuTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 340, 160, 50));

        usernameHolder.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        usernameHolder.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        usernameHolder.setLabelText("");
        usernameHolder.setLineColor(new java.awt.Color(0, 0, 0));
        SettingsPnl.add(usernameHolder, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 180, 150, -1));

        updateInfo.setText("Update Info");
        updateInfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                updateInfoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                updateInfoMouseExited(evt);
            }
        });
        updateInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateInfoActionPerformed(evt);
            }
        });
        SettingsPnl.add(updateInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 560, 260, 70));

        button2.setText("Change");
        SettingsPnl.add(button2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 560, 260, 70));

        button3.setText("Change");
        SettingsPnl.add(button3, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 560, 260, 70));

        secuHolder.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        secuHolder.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        secuHolder.setLabelText("");
        secuHolder.setLineColor(new java.awt.Color(0, 0, 0));
        SettingsPnl.add(secuHolder, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 333, 240, -1));

        ansHolder.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        ansHolder.setEchoChar('*');
        ansHolder.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        ansHolder.setLabelText("");
        SettingsPnl.add(ansHolder, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 390, 220, -1));

        passHolder.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        passHolder.setEchoChar('*');
        passHolder.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        passHolder.setLabelText("");
        SettingsPnl.add(passHolder, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 255, 170, -1));

        passHide.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LP_images/passHide.png"))); // NOI18N
        passHide.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        passHide.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                passHideMouseClicked(evt);
            }
        });
        SettingsPnl.add(passHide, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 290, -1, -1));

        passOpen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LP_images/passOpen.png"))); // NOI18N
        passOpen.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        passOpen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                passOpenMouseClicked(evt);
            }
        });
        SettingsPnl.add(passOpen, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 290, -1, -1));

        userLock.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LP_images/PencilChange.png"))); // NOI18N
        userLock.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        userLock.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                userLockMouseClicked(evt);
            }
        });
        SettingsPnl.add(userLock, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 215, -1, -1));

        passLock.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LP_images/PencilChange.png"))); // NOI18N
        passLock.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        passLock.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                passLockMouseClicked(evt);
            }
        });
        SettingsPnl.add(passLock, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 290, -1, -1));

        ansLock.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LP_images/PencilChange.png"))); // NOI18N
        ansLock.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ansLock.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ansLockMouseClicked(evt);
            }
        });
        SettingsPnl.add(ansLock, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 425, -1, -1));

        ansHide.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LP_images/passHide.png"))); // NOI18N
        ansHide.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ansHide.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ansHideMouseClicked(evt);
            }
        });
        SettingsPnl.add(ansHide, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 425, -1, -1));

        ansOpen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LP_images/passOpen.png"))); // NOI18N
        ansOpen.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ansOpen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ansOpenMouseClicked(evt);
            }
        });
        SettingsPnl.add(ansOpen, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 425, -1, -1));

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LP_images/SettingsBg.png"))); // NOI18N
        SettingsPnl.add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 980, 676));

        Base.add(SettingsPnl, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 980, 676));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(Header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Sidebar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(Base, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Header, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Sidebar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Base, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void disabledInfo() {
        usernameHolder.setEnabled(false);
        passHolder.setEnabled(false);
        secuHolder.setEnabled(false);
        ansHolder.setEnabled(false);
    }

    private boolean isDatePopupVisible = false;

    /*public void incrementTable(int row) {
        DefaultTableModel model = (DefaultTableModel) cartTable.getModel();
        int quantity = (Integer) model.getValueAt(row, 2); // Get current quantity from the table
        System.out.println("Current quantity before increment: " + quantity); // Debug output

        quantity += 1;  // Increment quantity by 1
        model.setValueAt(quantity, row, 2);  // Update the table model with new quantity
        
        
        int crabFinalPrice = 150;
        int empPrice = 100;
        
        int finalComputation = quantity * crabFinalPrice;  // Compute new total cost
        model.setValueAt(finalComputation, row, 3);  // Set new total cost in the table
        
        int empComputation = quantity * empPrice;
        model.setValueAt(empComputation, row, 3); 

        System.out.println("New quantity after increment: " + quantity + ", New computation: " + finalComputation); // Debug output
    }

    public void decrementTable(int row) {
        DefaultTableModel model = (DefaultTableModel) cartTable.getModel();
        int quantity = (Integer) model.getValueAt(row, 2);  // Get current quantity from the table
        System.out.println("Current quantity before decrement: " + quantity); // Debug output

        int crabFinalPrice = 150;
        int empFinalPrice = 100;
        
        if (quantity > 1) {
            quantity -= 1;  // Decrement quantity by 1
            model.setValueAt(quantity, row, 2);  // Update the table model with new quantity

            int finalComputation = quantity * crabFinalPrice;  // Compute new total cost
            model.setValueAt(finalComputation, row, 3);  // Update the total cost in the table
            
            int empComputation = quantity * empFinalPrice;
            model.setValueAt(empComputation, row, 3); 

            
        } else {
            JOptionPane.showMessageDialog(null, "Cannot reduce quantity below 1", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
     */
    private void showPopUp(MouseEvent e) {
        settings.show(this, 1175, 80);
    }

    public void incrementTable(int row) {
        DefaultTableModel model = (DefaultTableModel) cartTable.getModel();
        int quantity = (Integer) model.getValueAt(row, 3); // Get current quantity from the table
        String productName = model.getValueAt(row, 2).toString().trim().toUpperCase(); // Get product name and standardize it
        int productPrice;

        switch (productName) {
            case "CRAB AND CORN SOUP" ->
                productPrice = 150;
            case "SPECIAL EMAPANDA" ->
                productPrice = 100;
            case "SPECIAL PANCIT" ->
                productPrice = 200;
            case "BICOL EXPRESS" ->
                productPrice = 300;
            case "LECHON KAWALI" ->
                productPrice = 350;
            case "FISH ESCABECHE" ->
                productPrice = 2500;
            case "STEAMED JASMINE RICE" ->
                productPrice = 30;
            case "ADOBO RICE" ->
                productPrice = 45;
            case "JAVA RICE" ->
                productPrice = 45;
            case "HALO - HALO" ->
                productPrice = 150;
            case "PANDAN GULAMAN" ->
                productPrice = 100;
            case "MAJA BLANCA" ->
                productPrice = 120;
            case "HOUSE BLEND ICED TEA" ->
                productPrice = 70;
            case "SOFT DRINKS" ->
                productPrice = 70;
            case "FRUIT JUICE" ->
                productPrice = 100;
            case "1 - 2 PAX" ->
                productPrice = 0;
            case "3 - 5 PAX" ->
                productPrice = 0;
            case "6 - 10 PAX" ->
                productPrice = 0;
            case "10 - 15 PAX" ->
                productPrice = 0;
            default -> {
                JOptionPane.showMessageDialog(null, "Only 1 to Reserve", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        quantity++;
        int finalComputation = quantity * productPrice;
        model.setValueAt(quantity, row, 3);
        model.setValueAt(finalComputation, row, 4);
    }

    public void decrementTable(int row) {
        DefaultTableModel model = (DefaultTableModel) cartTable.getModel();
        int quantity = (Integer) model.getValueAt(row, 3);
        String productName = model.getValueAt(row, 2).toString().trim().toUpperCase(); // Get product name and standardize it
        int productPrice;

        switch (productName) {
            case "CRAB AND CORN SOUP" ->
                productPrice = 150;
            case "SPECIAL EMAPANDA" ->
                productPrice = 100;
            case "SPECIAL PANCIT" ->
                productPrice = 200;
            case "BICOL EXPRESS" ->
                productPrice = 300;
            case "LECHON KAWALI" ->
                productPrice = 350;
            case "FISH ESCABECHE" ->
                productPrice = 250;
            case "STEAMED JASMINE RICE" ->
                productPrice = 30;
            case "ADOBO RICE" ->
                productPrice = 45;
            case "JAVA RICE" ->
                productPrice = 45;
            case "HALO - HALO" ->
                productPrice = 150;
            case "PANDAN GULAMAN" ->
                productPrice = 100;
            case "MAJA BLANCA" ->
                productPrice = 120;
            case "HOUSE BLEND ICED TEA" ->
                productPrice = 70;
            case "SOFT DRINKS" ->
                productPrice = 70;
            case "FRUIT JUICE" ->
                productPrice = 100;
            case "1 - 2 PAX" ->
                productPrice = 0;
            case "3 - 5 PAX" ->
                productPrice = 0;
            case "6 - 10 PAX" ->
                productPrice = 0;
            case "10 - 15 PAX" ->
                productPrice = 0;
            case "BIRTHDAY PARTY" ->
                productPrice = 4500;
            case "VALENTINES DAY" ->
                productPrice = 2000;
            case "WEDDING RECEPTION" ->
                productPrice = 10000;
            case "HOLIDAY PARTY" ->
                productPrice = 2500;
            case "CHRISTMAS BUNDLE" ->
                productPrice = 1200;
            case "VALENTINES DATE" ->
                productPrice = 1500;
            case "TRIO BUNDLE" ->
                productPrice = 520;
            case "FAMILY BUNDLE" ->
                productPrice = 350;

            default -> {
                JOptionPane.showMessageDialog(null, "No valid product selected or product price is not set.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        quantity--;
        int finalComputation = quantity * productPrice;
        model.setValueAt(quantity, row, 3);
        model.setValueAt(finalComputation, row, 4);
    }


    private void ExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExitMouseClicked
        ImageIcon smile = new ImageIcon(getClass().getResource("/LP_images/Smile.png"));
        ImageIcon exit = new ImageIcon(getClass().getResource("/LP_images/ExitIcon.png"));
        Object[] options = {"Yes", "No"};

        int response = JOptionPane.showOptionDialog(
                null,
                "Do you want to exit?",
                "Hain Reservation System",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                exit,
                options,
                options[0]
        );

        if (response == 0) {
            System.exit(0);
        } else {
            JOptionPane.showMessageDialog(null, "Enjoy Using the Application!", "Hain Reservation System", JOptionPane.INFORMATION_MESSAGE, smile);
        }
    }//GEN-LAST:event_ExitMouseClicked

    public void showPanel(String panelName) {
        TablePnl.setVisible(false);
        FoodPnl.setVisible(false);
        EventPnl.setVisible(false);
        PackPnl.setVisible(false);
        EntreePnl.setVisible(false);
        RicePnl.setVisible(false);
        DesertPnl.setVisible(false);
        BeveragePnl.setVisible(false);
        CartPnl.setVisible(false);
        SettingsPnl.setVisible(false);
        ReservationPnl.setVisible(false);

        switch (panelName) {
            case "Table":
                TablePnl.setVisible(true);

                break;
            case "Food":
                FoodPnl.setVisible(true);
                break;
            case "Event":
                EventPnl.setVisible(true);
                break;
            case "Pack":
                PackPnl.setVisible(true);
                break;

        }
    }
    private void PackLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PackLabelMouseExited
        Package.setBackground(new Color(200, 200, 200));
    }//GEN-LAST:event_PackLabelMouseExited

    private void PackLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PackLabelMouseEntered
        Package.setBackground(new Color(242, 242, 242));
    }//GEN-LAST:event_PackLabelMouseEntered

    private void PackLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PackLabelMouseClicked
        TablePnl.setVisible(false);
        FoodPnl.setVisible(false);
        EventPnl.setVisible(false);
        PackPnl.setVisible(true);
        EntreePnl.setVisible(false);
        RicePnl.setVisible(false);
        DesertPnl.setVisible(false);
        BeveragePnl.setVisible(false);
        CartPnl.setVisible(false);
        SettingsPnl.setVisible(false);
        ReservationPnl.setVisible(false);
    }//GEN-LAST:event_PackLabelMouseClicked

    private void EventLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EventLabelMouseExited
        Events.setBackground(new Color(200, 200, 200));
    }//GEN-LAST:event_EventLabelMouseExited

    private void EventLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EventLabelMouseEntered
        Events.setBackground(new Color(242, 242, 242));
    }//GEN-LAST:event_EventLabelMouseEntered

    private void EventLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EventLabelMouseClicked
        TablePnl.setVisible(false);
        FoodPnl.setVisible(false);
        EventPnl.setVisible(true);
        PackPnl.setVisible(false);
        EntreePnl.setVisible(false);
        RicePnl.setVisible(false);
        DesertPnl.setVisible(false);
        BeveragePnl.setVisible(false);
        CartPnl.setVisible(false);
        SettingsPnl.setVisible(false);
        ReservationPnl.setVisible(false);


    }//GEN-LAST:event_EventLabelMouseClicked

    private void FoodLblMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FoodLblMouseExited
        Food.setBackground(new Color(200, 200, 200));
    }//GEN-LAST:event_FoodLblMouseExited

    private void FoodLblMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FoodLblMouseEntered
        Food.setBackground(new Color(242, 242, 242));
    }//GEN-LAST:event_FoodLblMouseEntered

    private void FoodLblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FoodLblMouseClicked
        TablePnl.setVisible(false);
        FoodPnl.setVisible(true);
        EventPnl.setVisible(false);
        PackPnl.setVisible(false);
        EntreePnl.setVisible(false);
        RicePnl.setVisible(false);
        DesertPnl.setVisible(false);
        BeveragePnl.setVisible(false);
        CartPnl.setVisible(false);
        ReservationPnl.setVisible(false);
    }//GEN-LAST:event_FoodLblMouseClicked

    private void TableLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableLabelMouseExited
        Table.setBackground(new Color(200, 200, 200));
    }//GEN-LAST:event_TableLabelMouseExited

    private void TableLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableLabelMouseEntered
        Table.setBackground(new Color(242, 242, 242));
    }//GEN-LAST:event_TableLabelMouseEntered

    private void TableLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableLabelMouseClicked

        TablePnl.setVisible(true);
        FoodPnl.setVisible(false);
        EventPnl.setVisible(false);
        PackPnl.setVisible(false);
        EntreePnl.setVisible(false);
        RicePnl.setVisible(false);
        DesertPnl.setVisible(false);
        BeveragePnl.setVisible(false);
        CartPnl.setVisible(false);
        ReservationPnl.setVisible(false);

    }//GEN-LAST:event_TableLabelMouseClicked

    private void nextBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nextBtnMouseEntered
        nextBtn.setBackground(new Color(240, 240, 240));
    }//GEN-LAST:event_nextBtnMouseEntered

    private void nextBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nextBtnMouseExited
        nextBtn.setBackground(new Color(249, 249, 249));
    }//GEN-LAST:event_nextBtnMouseExited

    private void nextBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nextBtnMouseClicked
        FoodPnl.setVisible(true);
        TablePnl.setVisible(false);
        EventPnl.setVisible(false);
        PackPnl.setVisible(false);
        CartPnl.setVisible(false);
        SettingsPnl.setVisible(false);
        ReservationPnl.setVisible(false);

        apeBtn.setBackground(new Color(201, 201, 201));

    }//GEN-LAST:event_nextBtnMouseClicked

    private void apeBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_apeBtnMouseClicked
        RicePnl.setVisible(false);
        EntreePnl.setVisible(false);
        FoodPnl.setVisible(true);
        TablePnl.setVisible(false);
        EventPnl.setVisible(false);
        PackPnl.setVisible(false);
        CartPnl.setVisible(false);
        SettingsPnl.setVisible(false);
        ReservationPnl.setVisible(false);
        apeBtn.setBackground(new Color(201, 201, 201));
        apeBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    }//GEN-LAST:event_apeBtnMouseClicked

    private void EntreeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EntreeMouseClicked
        RicePnl.setVisible(false);
        EntreePnl.setVisible(true);
        FoodPnl.setVisible(false);
        TablePnl.setVisible(false);
        EventPnl.setVisible(false);
        PackPnl.setVisible(false);
        CartPnl.setVisible(false);
        SettingsPnl.setVisible(false);
        ReservationPnl.setVisible(false);

        Entree1.setBackground(new Color(201, 201, 201));
        Entree1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

    }//GEN-LAST:event_EntreeMouseClicked

    private void RiceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RiceMouseClicked
        RicePnl.setVisible(true);
        EntreePnl.setVisible(false);
        FoodPnl.setVisible(false);
        TablePnl.setVisible(false);
        EventPnl.setVisible(false);
        PackPnl.setVisible(false);
        CartPnl.setVisible(false);
        SettingsPnl.setVisible(false);
        ReservationPnl.setVisible(false);

        Rice2.setBackground(new Color(201, 201, 201));
        Rice2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    }//GEN-LAST:event_RiceMouseClicked

    private void DesertMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DesertMouseClicked
        DesertPnl.setVisible(true);
        RicePnl.setVisible(false);
        EntreePnl.setVisible(false);
        FoodPnl.setVisible(false);
        TablePnl.setVisible(false);
        EventPnl.setVisible(false);
        PackPnl.setVisible(false);
        CartPnl.setVisible(false);
        SettingsPnl.setVisible(false);
        ReservationPnl.setVisible(false);

        Desert3.setBackground(new Color(201, 201, 201));
        Desert3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    }//GEN-LAST:event_DesertMouseClicked

    private void BeverageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BeverageMouseClicked
        BeveragePnl.setVisible(true);
        DesertPnl.setVisible(false);
        RicePnl.setVisible(false);
        EntreePnl.setVisible(false);
        FoodPnl.setVisible(false);
        TablePnl.setVisible(false);
        EventPnl.setVisible(false);
        PackPnl.setVisible(false);
        CartPnl.setVisible(false);
        SettingsPnl.setVisible(false);
        ReservationPnl.setVisible(false);

        Beverage4.setBackground(new Color(201, 201, 201));
        Beverage4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    }//GEN-LAST:event_BeverageMouseClicked

    private void apeBtn1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_apeBtn1MouseClicked
        EntreePnl.setVisible(false);
        FoodPnl.setVisible(true);
        TablePnl.setVisible(false);
        EventPnl.setVisible(false);
        PackPnl.setVisible(false);
        CartPnl.setVisible(false);
        SettingsPnl.setVisible(false);
        ReservationPnl.setVisible(false);
        apeBtn.setBackground(new Color(201, 201, 201));
        apeBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    }//GEN-LAST:event_apeBtn1MouseClicked

    private void Desert1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Desert1MouseClicked
        DesertPnl.setVisible(true);
        RicePnl.setVisible(false);
        EntreePnl.setVisible(false);
        FoodPnl.setVisible(false);
        TablePnl.setVisible(false);
        EventPnl.setVisible(false);
        PackPnl.setVisible(false);
        CartPnl.setVisible(false);
        SettingsPnl.setVisible(false);
        ReservationPnl.setVisible(false);

        Desert3.setBackground(new Color(201, 201, 201));
        Desert3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    }//GEN-LAST:event_Desert1MouseClicked

    private void Beverage1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Beverage1MouseClicked
        BeveragePnl.setVisible(true);
        DesertPnl.setVisible(false);
        RicePnl.setVisible(false);
        EntreePnl.setVisible(false);
        FoodPnl.setVisible(false);
        TablePnl.setVisible(false);
        EventPnl.setVisible(false);
        PackPnl.setVisible(false);
        CartPnl.setVisible(false);
        SettingsPnl.setVisible(false);
        ReservationPnl.setVisible(false);

        Beverage4.setBackground(new Color(201, 201, 201));
        Beverage4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    }//GEN-LAST:event_Beverage1MouseClicked

    private void Rice1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Rice1MouseClicked

        RicePnl.setVisible(true);
        EntreePnl.setVisible(false);
        FoodPnl.setVisible(false);
        TablePnl.setVisible(false);
        EventPnl.setVisible(false);
        PackPnl.setVisible(false);
        CartPnl.setVisible(false);
        SettingsPnl.setVisible(false);
        ReservationPnl.setVisible(false);

        Rice2.setBackground(new Color(201, 201, 201));
        Rice2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    }//GEN-LAST:event_Rice1MouseClicked

    private void apeBtn2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_apeBtn2MouseClicked

        RicePnl.setVisible(false);
        EntreePnl.setVisible(false);
        FoodPnl.setVisible(true);
        TablePnl.setVisible(false);
        EventPnl.setVisible(false);
        PackPnl.setVisible(false);
        CartPnl.setVisible(false);
        SettingsPnl.setVisible(false);
        ReservationPnl.setVisible(false);
        apeBtn.setBackground(new Color(201, 201, 201));
        apeBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    }//GEN-LAST:event_apeBtn2MouseClicked

    private void Entree2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Entree2MouseClicked
        RicePnl.setVisible(false);
        EntreePnl.setVisible(true);
        FoodPnl.setVisible(false);
        TablePnl.setVisible(false);
        EventPnl.setVisible(false);
        PackPnl.setVisible(false);
        CartPnl.setVisible(false);
        SettingsPnl.setVisible(false);
        ReservationPnl.setVisible(false);


    }//GEN-LAST:event_Entree2MouseClicked

    private void Desert2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Desert2MouseClicked
        DesertPnl.setVisible(true);
        RicePnl.setVisible(false);
        EntreePnl.setVisible(false);
        FoodPnl.setVisible(false);
        TablePnl.setVisible(false);
        EventPnl.setVisible(false);
        PackPnl.setVisible(false);
        CartPnl.setVisible(false);
        SettingsPnl.setVisible(false);
        ReservationPnl.setVisible(false);

        Desert3.setBackground(new Color(201, 201, 201));
        Desert3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    }//GEN-LAST:event_Desert2MouseClicked

    private void Beverage2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Beverage2MouseClicked
        BeveragePnl.setVisible(true);
        DesertPnl.setVisible(false);
        RicePnl.setVisible(false);
        EntreePnl.setVisible(false);
        FoodPnl.setVisible(false);
        TablePnl.setVisible(false);
        EventPnl.setVisible(false);
        PackPnl.setVisible(false);
        CartPnl.setVisible(false);
        SettingsPnl.setVisible(false);
        ReservationPnl.setVisible(false);

        Beverage4.setBackground(new Color(201, 201, 201));
        Beverage4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    }//GEN-LAST:event_Beverage2MouseClicked

    private void Rice3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Rice3MouseClicked
        DesertPnl.setVisible(false);
        RicePnl.setVisible(true);
        EntreePnl.setVisible(false);
        FoodPnl.setVisible(false);
        TablePnl.setVisible(false);
        EventPnl.setVisible(false);
        PackPnl.setVisible(false);
        CartPnl.setVisible(false);
        SettingsPnl.setVisible(false);
        ReservationPnl.setVisible(false);

        Rice2.setBackground(new Color(201, 201, 201));
        Rice2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    }//GEN-LAST:event_Rice3MouseClicked

    private void Beverage3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Beverage3MouseClicked
        BeveragePnl.setVisible(true);
        DesertPnl.setVisible(false);
        RicePnl.setVisible(false);
        EntreePnl.setVisible(false);
        FoodPnl.setVisible(false);
        TablePnl.setVisible(false);
        EventPnl.setVisible(false);
        PackPnl.setVisible(false);
        CartPnl.setVisible(false);
        SettingsPnl.setVisible(false);
        ReservationPnl.setVisible(false);

        Beverage4.setBackground(new Color(201, 201, 201));
        Beverage4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    }//GEN-LAST:event_Beverage3MouseClicked

    private void apeBtn4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_apeBtn4MouseClicked
        BeveragePnl.setVisible(false);
        DesertPnl.setVisible(false);
        RicePnl.setVisible(false);
        EntreePnl.setVisible(false);
        FoodPnl.setVisible(true);
        TablePnl.setVisible(false);
        EventPnl.setVisible(false);
        PackPnl.setVisible(false);
        CartPnl.setVisible(false);
        SettingsPnl.setVisible(false);
        ReservationPnl.setVisible(false);

        apeBtn.setBackground(new Color(201, 201, 201));
        apeBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    }//GEN-LAST:event_apeBtn4MouseClicked

    private void Entree4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Entree4MouseClicked
        BeveragePnl.setVisible(false);
        DesertPnl.setVisible(false);
        RicePnl.setVisible(false);
        EntreePnl.setVisible(true);
        FoodPnl.setVisible(false);
        TablePnl.setVisible(false);
        EventPnl.setVisible(false);
        PackPnl.setVisible(false);
        CartPnl.setVisible(false);
        SettingsPnl.setVisible(false);
        ReservationPnl.setVisible(false);

        Entree1.setBackground(new Color(201, 201, 201));
        Entree1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    }//GEN-LAST:event_Entree4MouseClicked

    private void Rice4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Rice4MouseClicked
        BeveragePnl.setVisible(false);
        DesertPnl.setVisible(false);
        RicePnl.setVisible(true);
        EntreePnl.setVisible(false);
        FoodPnl.setVisible(false);
        TablePnl.setVisible(false);
        EventPnl.setVisible(false);
        PackPnl.setVisible(false);
        CartPnl.setVisible(false);
        SettingsPnl.setVisible(false);
        ReservationPnl.setVisible(false);

        Rice2.setBackground(new Color(201, 201, 201));
        Rice2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    }//GEN-LAST:event_Rice4MouseClicked

    private void Desert4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Desert4MouseClicked
        BeveragePnl.setVisible(false);
        DesertPnl.setVisible(true);
        RicePnl.setVisible(false);
        EntreePnl.setVisible(false);
        FoodPnl.setVisible(false);
        TablePnl.setVisible(false);
        EventPnl.setVisible(false);
        PackPnl.setVisible(false);
        CartPnl.setVisible(false);
        SettingsPnl.setVisible(false);
        ReservationPnl.setVisible(false);

        Desert3.setBackground(new Color(201, 201, 201));
        Desert3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    }//GEN-LAST:event_Desert4MouseClicked

    private void crabQuantityPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_crabQuantityPropertyChange
        JFormattedTextField quantity = ((JSpinner.DefaultEditor) crabQuantity.getEditor()).getTextField();
        quantity.setEditable(false);
    }//GEN-LAST:event_crabQuantityPropertyChange

    private void empQuantityPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_empQuantityPropertyChange
        JFormattedTextField quantity = ((JSpinner.DefaultEditor) empQuantity.getEditor()).getTextField();
        quantity.setEditable(false);
    }//GEN-LAST:event_empQuantityPropertyChange

    private void pancitQuantityPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_pancitQuantityPropertyChange
        JFormattedTextField quantity = ((JSpinner.DefaultEditor) pancitQuantity.getEditor()).getTextField();
        quantity.setEditable(false);
    }//GEN-LAST:event_pancitQuantityPropertyChange

    private void crabOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crabOrderActionPerformed
        int quantity = (Integer) crabQuantity.getValue();

        if (quantity == 0) {

            JOptionPane.showMessageDialog(null,
                    "Invalid",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        int crabPresyo = 150;
        int computation = quantity * crabPresyo;

        addTable(dateShow.getText(), timeHolderTable.getText(), crabTitle.getText(), quantity, computation);

    }//GEN-LAST:event_crabOrderActionPerformed

    private void bicolQuantityPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_bicolQuantityPropertyChange
        JFormattedTextField quantity = ((JSpinner.DefaultEditor) bicolQuantity.getEditor()).getTextField();
        quantity.setEditable(false);
    }//GEN-LAST:event_bicolQuantityPropertyChange

    private void lechonQuantityPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_lechonQuantityPropertyChange
        JFormattedTextField quantity = ((JSpinner.DefaultEditor) lechonQuantity.getEditor()).getTextField();
        quantity.setEditable(false);
    }//GEN-LAST:event_lechonQuantityPropertyChange

    private void fishQuantityPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_fishQuantityPropertyChange
        JFormattedTextField quantity = ((JSpinner.DefaultEditor) fishQuantity.getEditor()).getTextField();
        quantity.setEditable(false);
    }//GEN-LAST:event_fishQuantityPropertyChange

    private void jasQuantityPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jasQuantityPropertyChange
        JFormattedTextField quantity = ((JSpinner.DefaultEditor) jasQuantity.getEditor()).getTextField();
        quantity.setEditable(false);
    }//GEN-LAST:event_jasQuantityPropertyChange

    private void javaQtyPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_javaQtyPropertyChange
        JFormattedTextField quantity = ((JSpinner.DefaultEditor) javaQty.getEditor()).getTextField();
        quantity.setEditable(false);
    }//GEN-LAST:event_javaQtyPropertyChange

    private void haloQuantityPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_haloQuantityPropertyChange
        JFormattedTextField quantity = ((JSpinner.DefaultEditor) haloQuantity.getEditor()).getTextField();
        quantity.setEditable(false);
    }//GEN-LAST:event_haloQuantityPropertyChange

    private void pandanQuantityPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_pandanQuantityPropertyChange
        JFormattedTextField quantity = ((JSpinner.DefaultEditor) pandanQuantity.getEditor()).getTextField();
        quantity.setEditable(false);
    }//GEN-LAST:event_pandanQuantityPropertyChange

    private void majaQuantityPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_majaQuantityPropertyChange
        JFormattedTextField quantity = ((JSpinner.DefaultEditor) majaQuantity.getEditor()).getTextField();
        quantity.setEditable(false);
    }//GEN-LAST:event_majaQuantityPropertyChange

    private void adoboQuantityPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_adoboQuantityPropertyChange
        JFormattedTextField quantity = ((JSpinner.DefaultEditor) adoboQuantity.getEditor()).getTextField();
        quantity.setEditable(false);
    }//GEN-LAST:event_adoboQuantityPropertyChange

    private void teaQuantityPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_teaQuantityPropertyChange
        JFormattedTextField quantity = ((JSpinner.DefaultEditor) teaQuantity.getEditor()).getTextField();
        quantity.setEditable(false);
    }//GEN-LAST:event_teaQuantityPropertyChange

    private void softDrinksQuantityPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_softDrinksQuantityPropertyChange
        JFormattedTextField quantity = ((JSpinner.DefaultEditor) softDrinksQuantity.getEditor()).getTextField();
        quantity.setEditable(false);
    }//GEN-LAST:event_softDrinksQuantityPropertyChange

    private void fruitQuantityPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_fruitQuantityPropertyChange
        JFormattedTextField quantity = ((JSpinner.DefaultEditor) fruitQuantity.getEditor()).getTextField();
        quantity.setEditable(false);
    }//GEN-LAST:event_fruitQuantityPropertyChange


    private void showEventActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showEventActionPerformed

        if (!isDatePopupVisible) {
            dateEvent.showPopup();
            isDatePopupVisible = true;
        } else {
            dateEvent.hidePopup();
            isDatePopupVisible = false;
        }
    }//GEN-LAST:event_showEventActionPerformed

    private void nextBtn1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nextBtn1MouseClicked
        BeveragePnl.setVisible(false);
        DesertPnl.setVisible(false);
        RicePnl.setVisible(false);
        EntreePnl.setVisible(false);
        FoodPnl.setVisible(false);
        TablePnl.setVisible(false);
        EventPnl.setVisible(false);
        PackPnl.setVisible(true);
        CartPnl.setVisible(false);
        SettingsPnl.setVisible(false);
        ReservationPnl.setVisible(false);


    }//GEN-LAST:event_nextBtn1MouseClicked

    private void nextBtn1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nextBtn1MouseEntered
        nextBtn1.setBackground(new Color(240, 240, 240));
    }//GEN-LAST:event_nextBtn1MouseEntered

    private void nextBtn1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nextBtn1MouseExited
        nextBtn1.setBackground(new Color(249, 249, 249));
    }//GEN-LAST:event_nextBtn1MouseExited

    private void searchIcon1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchIcon1MouseClicked
        System.out.print("CLICKED!");

        String selectedDate = dateHolderEvent.getText();
        //System.out.println("Selected Date: " + selectedDate);

        List<String> eventNames = Arrays.asList(bdayTitle.getText(), valentineTitle.getText(), weddingTitle.getText(), holidayTitle.getText());

        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/haindatabase", "root", "carlo123")) {

            for (String eventName : eventNames) {
                String query = "SELECT * FROM reservations WHERE Date = ? AND Orders = ?";
                try (PreparedStatement pst = con.prepareStatement(query)) {
                    //System.out.println("Query executed for event: " + eventName);
                    pst.setString(1, selectedDate);
                    pst.setString(2, eventName);
                    try (ResultSet rs = pst.executeQuery()) {

                        if (rs.next()) {
                            switch (eventName) {
                                case "   BIRTHDAY PARTY":
                                    bdayReserve.setEnabled(false);
                                    cartIcon22.setEnabled(false);
                                    birthdayHolder.setEnabled(false);
                                    bdayImg.setEnabled(false);
                                    bdayTitle.setEnabled(false);
                                    bdayPrice.setEnabled(false);
                                    break;
                                case "  VALENTINES DAY":
                                    valentineReserve.setEnabled(false);
                                    cartIcon21.setEnabled(false);
                                    valentinesHolder.setEnabled(false);
                                    valentineImg.setEnabled(false);
                                    valentineTitle.setEnabled(false);
                                    valentinePrice.setEnabled(false);
                                    break;
                                case " WEDDING  RECEPTION":
                                    weddingReserve.setEnabled(false);
                                    cartIcon20.setEnabled(false);
                                    weddingHolder.setEnabled(false);
                                    weddingImg.setEnabled(false);
                                    weddingTitle.setEnabled(false);
                                    weddingPrice.setEnabled(false);
                                    break;
                                case "   HOLIDAY PARTY":
                                    holidayReserve.setEnabled(false);
                                    cartIcon19.setEnabled(false);
                                    holidayHolder.setEnabled(false);
                                    holidayImg.setEnabled(false);
                                    holidayTitle.setEnabled(false);
                                    holidayPrice.setEnabled(false);
                                    break;
                            }
                        } else {
                            switch (eventName) {
                                case "   BIRTHDAY PARTY":
                                    bdayReserve.setEnabled(true);
                                    cartIcon22.setEnabled(true);
                                    birthdayHolder.setEnabled(true);
                                    bdayImg.setEnabled(true);
                                    bdayTitle.setEnabled(true);
                                    bdayPrice.setEnabled(true);
                                    break;
                                case "  VALENTINES DAY":
                                    valentineReserve.setEnabled(true);
                                    cartIcon21.setEnabled(true);
                                    valentinesHolder.setEnabled(true);
                                    valentineImg.setEnabled(true);
                                    valentineTitle.setEnabled(true);
                                    valentinePrice.setEnabled(true);
                                    break;
                                case " WEDDING  RECEPTION":
                                    weddingReserve.setEnabled(true);
                                    cartIcon20.setEnabled(true);
                                    weddingHolder.setEnabled(true);
                                    weddingImg.setEnabled(true);
                                    weddingTitle.setEnabled(true);
                                    weddingPrice.setEnabled(true);
                                    break;
                                case "   HOLIDAY PARTY":
                                    holidayReserve.setEnabled(true);
                                    cartIcon19.setEnabled(true);
                                    holidayHolder.setEnabled(true);
                                    holidayImg.setEnabled(true);
                                    holidayTitle.setEnabled(true);
                                    holidayPrice.setEnabled(true);
                                    break;
                                }
                            }
                        }
                    }
                }
            }catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Failed to check reservations: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_searchIcon1MouseClicked

    private void showPackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showPackActionPerformed
        if (!isDatePopupVisible) {
            packDate.showPopup();
            isDatePopupVisible = true;
        } else {
            packDate.hidePopup();
            isDatePopupVisible = false;
        }
    }//GEN-LAST:event_showPackActionPerformed

    private void searchIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchIconMouseClicked
        String selectedDate = dateHolderPack.getText();
        //System.out.println("Selected Date: " + selectedDate);

        List<String> eventNames = Arrays.asList(xmasTitle.getText(), vdateTitle.getText(), trioTitle.getText(), familyTitle.getText());

        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/haindatabase", "root", "carlo123")) {

            for (String eventName : eventNames) {
                String query = "SELECT * FROM reservations WHERE Date = ? AND Orders = ?";
                try (PreparedStatement pst = con.prepareStatement(query)) {
                    //System.out.println("Query executed for event: " + eventName);
                    pst.setString(1, selectedDate);
                    pst.setString(2, eventName);
                    try (ResultSet rs = pst.executeQuery()) {

                        if (rs.next()) {
                            switch (eventName) {
                                case " CHRISTMAS BUNDLE":
                                    xmasReserve.setEnabled(false);
                                    cartIcon23.setEnabled(false);
                                    xmasHolder.setEnabled(false);
                                    xmasImg.setEnabled(false);
                                    xmasTitle.setEnabled(false);
                                    xmasPrice.setEnabled(false);
                                    break;
                                case " VALENTINES DATE":
                                    vdateReserve.setEnabled(false);
                                    cartIcon24.setEnabled(false);
                                    valenHolder.setEnabled(false);
                                    valenImg.setEnabled(false);
                                    vdateTitle.setEnabled(false);
                                    valenPrice.setEnabled(false);
                                    break;
                                case "       TRIO BUNDLE":
                                    trioReserve.setEnabled(false);
                                    cartIcon25.setEnabled(false);
                                    trioHolder.setEnabled(false);
                                    trioImg.setEnabled(false);
                                    trioTitle.setEnabled(false);
                                    trioPrice.setEnabled(false);
                                    break;
                                case "   FAMILY BUNDLE":
                                    familyReserve.setEnabled(false);
                                    cartIcon26.setEnabled(false);
                                    familyHolder.setEnabled(false);
                                    familyImg.setEnabled(false);
                                    familyTitle.setEnabled(false);
                                    familyPrice.setEnabled(false);
                                    break;
                            }
                        } else {
                            switch (eventName) {
                                case " CHRISTMAS BUNDLE":
                                    xmasReserve.setEnabled(true);
                                    cartIcon23.setEnabled(true);
                                    xmasHolder.setEnabled(true);
                                    xmasImg.setEnabled(true);
                                    xmasTitle.setEnabled(true);
                                    xmasPrice.setEnabled(true);
                                    break;
                                case " VALENTINES DATE":
                                    vdateReserve.setEnabled(true);
                                    cartIcon24.setEnabled(true);
                                    valenHolder.setEnabled(true);
                                    valenImg.setEnabled(true);
                                    vdateTitle.setEnabled(true);
                                    valenPrice.setEnabled(true);
                                    break;
                                case "       TRIO BUNDLE":
                                    trioReserve.setEnabled(true);
                                    cartIcon25.setEnabled(true);
                                    trioHolder.setEnabled(true);
                                    trioImg.setEnabled(true);
                                    trioTitle.setEnabled(true);
                                    trioPrice.setEnabled(true);
                                    break;
                                case "   FAMILY BUNDLE":
                                    familyReserve.setEnabled(true);
                                    cartIcon26.setEnabled(true);
                                    familyHolder.setEnabled(true);
                                    familyImg.setEnabled(true);
                                    familyTitle.setEnabled(true);
                                    familyPrice.setEnabled(true);
                                    break;
                            }
                        }

                    }
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Failed to check reservations: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_searchIconMouseClicked

    private void tableShowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tableShowActionPerformed
        if (!isDatePopupVisible) {
            tableDate.showPopup();
            isDatePopupVisible = true;
        } else {
            tableDate.hidePopup();
            isDatePopupVisible = false;
        }
    }//GEN-LAST:event_tableShowActionPerformed

    private void CartLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CartLabelMouseClicked
        CartPnl.setVisible(true);
        TablePnl.setVisible(false);
        FoodPnl.setVisible(false);
        EventPnl.setVisible(false);
        PackPnl.setVisible(false);
        EntreePnl.setVisible(false);
        RicePnl.setVisible(false);
        DesertPnl.setVisible(false);
        BeveragePnl.setVisible(false);
        CartPnl.setVisible(true);
        SettingsPnl.setVisible(false);
        ReservationPnl.setVisible(false);
    }//GEN-LAST:event_CartLabelMouseClicked

    private void CartLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CartLabelMouseEntered
        Cart.setBackground(new Color(242, 242, 242));
    }//GEN-LAST:event_CartLabelMouseEntered

    private void CartLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CartLabelMouseExited
        Cart.setBackground(new Color(200, 200, 200));
    }//GEN-LAST:event_CartLabelMouseExited

    private void initializeTableRenderer() {
        cartTable.setDefaultRenderer(Object.class,
                new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                    boolean isSelected, boolean hasFocus,
                    int row, int column) {
                super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                setHorizontalAlignment(JLabel.CENTER);
                return this;
            }
        }
        );
    }


    private void onePaxReserveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onePaxReserveActionPerformed
        ImageIcon error = new ImageIcon(getClass().getResource("/LP_images/Error_1.png"));
        int quantity = (Integer) onePaxQuantity.getValue();

        if (quantity == 0) {

            JOptionPane.showMessageDialog(null,
                    "Invalid",
                    "Error",
                    JOptionPane.ERROR_MESSAGE,
                    error);
            return;
        }

        addTable(dateShow.getText(), timeHolderTable.getText(), onePax.getText(), quantity, 0);

    }//GEN-LAST:event_onePaxReserveActionPerformed

    private void onePaxQuantityPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_onePaxQuantityPropertyChange
        JFormattedTextField quantity = ((JSpinner.DefaultEditor) onePaxQuantity.getEditor()).getTextField();
        quantity.setEditable(false);
    }//GEN-LAST:event_onePaxQuantityPropertyChange

    private void threePaxQuantityPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_threePaxQuantityPropertyChange
        JFormattedTextField quantity = ((JSpinner.DefaultEditor) threePaxQuantity.getEditor()).getTextField();
        quantity.setEditable(false);
    }//GEN-LAST:event_threePaxQuantityPropertyChange

    private void sixPaxQuantityPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_sixPaxQuantityPropertyChange
        JFormattedTextField quantity = ((JSpinner.DefaultEditor) sixPaxQuantity.getEditor()).getTextField();
        quantity.setEditable(false);
    }//GEN-LAST:event_sixPaxQuantityPropertyChange

    private void tenPaxQuantityPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tenPaxQuantityPropertyChange
        JFormattedTextField quantity = ((JSpinner.DefaultEditor) tenPaxQuantity.getEditor()).getTextField();
        quantity.setEditable(false);
    }//GEN-LAST:event_tenPaxQuantityPropertyChange

    private void threePaxdupeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_threePaxdupeActionPerformed
        ImageIcon error = new ImageIcon(getClass().getResource("/LP_images/Error_1.png"));
        int quantity = (Integer) threePaxQuantity.getValue();

        if (quantity == 0) {

            JOptionPane.showMessageDialog(null,
                    "Invalid",
                    "Error",
                    JOptionPane.ERROR_MESSAGE,
                    error);
            return;
        }

        addTable(dateShow.getText(), timeHolderTable.getText(), onePax.getText(), quantity, 0);

    }//GEN-LAST:event_threePaxdupeActionPerformed

    private void sixPaxReserveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sixPaxReserveActionPerformed
        ImageIcon error = new ImageIcon(getClass().getResource("/LP_images/Error_1.png"));
        int quantity = (Integer) sixPaxQuantity.getValue();

        if (quantity == 0) {

            JOptionPane.showMessageDialog(null,
                    "Invalid",
                    "Error",
                    JOptionPane.ERROR_MESSAGE,
                    error);
            return;
        }

        addTable(dateShow.getText(), timeHolderTable.getText(), sixPax.getText(), quantity, 0);

    }//GEN-LAST:event_sixPaxReserveActionPerformed

    private void tenPaxReserveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tenPaxReserveActionPerformed
        ImageIcon error = new ImageIcon(getClass().getResource("/LP_images/Error_1.png"));
        int quantity = (Integer) tenPaxQuantity.getValue();

        if (quantity == 0) {

            JOptionPane.showMessageDialog(null,
                    "Invalid",
                    "Error",
                    JOptionPane.ERROR_MESSAGE,
                    error);
            return;
        }

        addTable(dateShow.getText(), timeHolderTable.getText(), threePax.getText(), quantity, 0);

    }//GEN-LAST:event_tenPaxReserveActionPerformed

    private void empOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_empOrderActionPerformed
        ImageIcon error = new ImageIcon(getClass().getResource("/LP_images/Error_1.png"));
        int quantity = (Integer) empQuantity.getValue();

        if (quantity == 0) {

            JOptionPane.showMessageDialog(null,
                    "Invalid",
                    "Error",
                    JOptionPane.ERROR_MESSAGE,
                    error);
            return;
        }
        int empPrice = 100;

        int computation = quantity * empPrice;

        addTable(dateShow.getText(), timeHolderTable.getText(), empTitle.getText(), quantity, computation);

    }//GEN-LAST:event_empOrderActionPerformed

    private void pancitOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pancitOrderActionPerformed
        ImageIcon error = new ImageIcon(getClass().getResource("/LP_images/Error_1.png"));
        int quantity = (Integer) pancitQuantity.getValue();

        if (quantity == 0) {

            JOptionPane.showMessageDialog(null,
                    "Invalid",
                    "Error",
                    JOptionPane.ERROR_MESSAGE,
                    error);
            return;
        }
        int pancitPrice = 200;

        int computation = quantity * pancitPrice;

        addTable(dateShow.getText(), timeHolderTable.getText(), pancitTitle.getText(), quantity, computation);

    }//GEN-LAST:event_pancitOrderActionPerformed

    private void bicolOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bicolOrderActionPerformed
        ImageIcon error = new ImageIcon(getClass().getResource("/LP_images/Error_1.png"));
        int quantity = (Integer) bicolQuantity.getValue();

        if (quantity == 0) {

            JOptionPane.showMessageDialog(null,
                    "Invalid",
                    "Error",
                    JOptionPane.ERROR_MESSAGE,
                    error);
            return;
        }
        int bicolPrice = 300;

        int computation = quantity * bicolPrice;

        addTable(dateShow.getText(), timeHolderTable.getText(), bicolTitle.getText(), quantity, computation);

    }//GEN-LAST:event_bicolOrderActionPerformed

    private void lechonOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lechonOrderActionPerformed
        int quantity = (Integer) lechonQuantity.getValue();
        ImageIcon error = new ImageIcon(getClass().getResource("/LP_images/Error_1.png"));
        if (quantity == 0) {

            JOptionPane.showMessageDialog(null,
                    "Invalid",
                    "Error",
                    JOptionPane.ERROR_MESSAGE,
                    error);
            return;
        }
        int lechonPrice = 350;

        int computation = quantity * lechonPrice;

        addTable(dateShow.getText(), timeHolderTable.getText(), lechonTitle.getText(), quantity, computation);

    }//GEN-LAST:event_lechonOrderActionPerformed

    private void fishOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fishOrderActionPerformed
        int quantity = (Integer) fishQuantity.getValue();
        ImageIcon error = new ImageIcon(getClass().getResource("/LP_images/Error_1.png"));
        if (quantity == 0) {

            JOptionPane.showMessageDialog(null,
                    "Invalid",
                    "Error",
                    JOptionPane.ERROR_MESSAGE,
                    error);
            return;
        }
        int fishPrice = 250;

        int computation = quantity * fishPrice;

        addTable(dateShow.getText(), timeHolderTable.getText(), fishTitle.getText(), quantity, computation);

    }//GEN-LAST:event_fishOrderActionPerformed

    private void jasOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jasOrderActionPerformed
        int quantity = (Integer) jasQuantity.getValue();
        ImageIcon error = new ImageIcon(getClass().getResource("/LP_images/Error_1.png"));
        if (quantity == 0) {

            JOptionPane.showMessageDialog(null,
                    "Invalid",
                    "Error",
                    JOptionPane.ERROR_MESSAGE,
                    error);
            return;
        }
        int jasminePrice = 30;

        int computation = quantity * jasminePrice;

        addTable(dateShow.getText(), timeHolderTable.getText(), jasTitle.getText(), quantity, computation);

    }//GEN-LAST:event_jasOrderActionPerformed

    private void adoboOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adoboOrderActionPerformed
        int quantity = (Integer) adoboQuantity.getValue();
        ImageIcon error = new ImageIcon(getClass().getResource("/LP_images/Error_1.png"));
        if (quantity == 0) {

            JOptionPane.showMessageDialog(null,
                    "Invalid",
                    "Error",
                    JOptionPane.ERROR_MESSAGE,
                    error);
            return;
        }
        int adoboPrice = 45;

        int computation = quantity * adoboPrice;

        addTable(dateShow.getText(), timeHolderTable.getText(), adoboTitle.getText(), quantity, computation);

    }//GEN-LAST:event_adoboOrderActionPerformed

    private void javaOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_javaOrderActionPerformed
        int quantity = (Integer) javaQty.getValue();
        ImageIcon error = new ImageIcon(getClass().getResource("/LP_images/Error_1.png"));
        if (quantity == 0) {

            JOptionPane.showMessageDialog(null,
                    "Invalid",
                    "Error",
                    JOptionPane.ERROR_MESSAGE,
                    error);
            return;
        }
        int adoboPrice = 45;

        int computation = quantity * adoboPrice;

        addTable(dateShow.getText(), timeHolderTable.getText(), javaTitle.getText(), quantity, computation);

    }//GEN-LAST:event_javaOrderActionPerformed

    private void majaOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_majaOrderActionPerformed
        int quantity = (Integer) majaQuantity.getValue();
        ImageIcon error = new ImageIcon(getClass().getResource("/LP_images/Error_1.png"));
        if (quantity == 0) {

            JOptionPane.showMessageDialog(null,
                    "Invalid",
                    "Error",
                    JOptionPane.ERROR_MESSAGE,
                    error);
            return;
        }
        int majaPrice = 120;

        int computation = quantity * majaPrice;

        addTable(dateShow.getText(), timeHolderTable.getText(), majaTitle.getText(), quantity, computation);

    }//GEN-LAST:event_majaOrderActionPerformed

    private void halohaloOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_halohaloOrderActionPerformed
        int quantity = (Integer) haloQuantity.getValue();
        ImageIcon error = new ImageIcon(getClass().getResource("/LP_images/Error_1.png"));
        if (quantity == 0) {

            JOptionPane.showMessageDialog(null,
                    "Invalid",
                    "Error",
                    JOptionPane.ERROR_MESSAGE,
                    error);
            return;
        }
        int halohaloPrice = 120;

        int computation = quantity * halohaloPrice;

        addTable(dateShow.getText(), timeHolderTable.getText(), halohaloTitle.getText(), quantity, computation);

    }//GEN-LAST:event_halohaloOrderActionPerformed

    private void gulamanOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gulamanOrderActionPerformed
        int quantity = (Integer) pandanQuantity.getValue();
        ImageIcon error = new ImageIcon(getClass().getResource("/LP_images/Error_1.png"));
        if (quantity == 0) {

            JOptionPane.showMessageDialog(null,
                    "Invalid",
                    "Error",
                    JOptionPane.ERROR_MESSAGE,
                    error);
            return;
        }
        int pandanPrice = 120;

        int computation = quantity * pandanPrice;

        addTable(dateShow.getText(), timeHolderTable.getText(), pandanTitle.getText(), quantity, computation);

    }//GEN-LAST:event_gulamanOrderActionPerformed

    private void iceteaOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iceteaOrderActionPerformed
        int quantity = (Integer) teaQuantity.getValue();
        ImageIcon error = new ImageIcon(getClass().getResource("/LP_images/Error_1.png"));
        if (quantity == 0) {

            JOptionPane.showMessageDialog(null,
                    "Invalid",
                    "Error",
                    JOptionPane.ERROR_MESSAGE,
                    error);
            return;
        }
        int iceTeaPrice = 70;

        int computation = quantity * iceTeaPrice;

        addTable(dateShow.getText(), timeHolderTable.getText(), teaTitle.getText(), quantity, computation);

    }//GEN-LAST:event_iceteaOrderActionPerformed

    private void sofdrinkOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sofdrinkOrderActionPerformed
        int quantity = (Integer) softDrinksQuantity.getValue();
        ImageIcon error = new ImageIcon(getClass().getResource("/LP_images/Error_1.png"));
        if (quantity == 0) {

            JOptionPane.showMessageDialog(null,
                    "Invalid",
                    "Error",
                    JOptionPane.ERROR_MESSAGE,
                    error);
            return;
        }
        int softdrinkPrice = 70;

        int computation = quantity * softdrinkPrice;

        addTable(dateShow.getText(), timeHolderTable.getText(), softdrinkTitle.getText(), quantity, computation);

    }//GEN-LAST:event_sofdrinkOrderActionPerformed

    private void fruitOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fruitOrderActionPerformed
        int quantity = (Integer) fruitQuantity.getValue();
        ImageIcon error = new ImageIcon(getClass().getResource("/LP_images/Error_1.png"));
        if (quantity == 0) {

            JOptionPane.showMessageDialog(null,
                    "Invalid",
                    "Error",
                    JOptionPane.ERROR_MESSAGE,
                    error);
            return;
        }
        int fruitkPrice = 100;

        int computation = quantity * fruitkPrice;

        addTable(dateShow.getText(), timeHolderTable.getText(), fruitTitle.getText(), quantity, computation);

    }//GEN-LAST:event_fruitOrderActionPerformed

    private void bdayReserveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bdayReserveActionPerformed

        addTable(dateHolderEvent.getText(), timeHolderEvents.getText(), bdayTitle.getText(), 1, 4500);

    }//GEN-LAST:event_bdayReserveActionPerformed

    private void valentineReserveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_valentineReserveActionPerformed
        addTable(dateHolderEvent.getText(), timeHolderEvents.getText(), valentineTitle.getText(), 1, 2000);

    }//GEN-LAST:event_valentineReserveActionPerformed

    private void weddingReserveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_weddingReserveActionPerformed
        addTable(dateHolderEvent.getText(), timeHolderEvents.getText(), weddingTitle.getText(), 1, 10000);

    }//GEN-LAST:event_weddingReserveActionPerformed

    private void holidayReserveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_holidayReserveActionPerformed
        addTable(dateHolderEvent.getText(), timeHolderEvents.getText(), holidayTitle.getText(), 1, 2500);

    }//GEN-LAST:event_holidayReserveActionPerformed

    private void xmasReserveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xmasReserveActionPerformed
        addTable(dateHolderPack.getText(), timeHolderEvents.getText(), xmasTitle.getText(), 1, 1200);

    }//GEN-LAST:event_xmasReserveActionPerformed

    private void vdateReserveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vdateReserveActionPerformed
        addTable(dateHolderPack.getText(), timeHolderPack.getText(), vdateTitle.getText(), 1, 1500);

    }//GEN-LAST:event_vdateReserveActionPerformed

    private void trioReserveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_trioReserveActionPerformed
        addTable(dateHolderPack.getText(), timeHolderPack.getText(), trioTitle.getText(), 1, 1500);

    }//GEN-LAST:event_trioReserveActionPerformed

    private void familyReserveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_familyReserveActionPerformed
        addTable(dateHolderPack.getText(), timeHolderPack.getText(), familyTitle.getText(), 1, 1350);

    }//GEN-LAST:event_familyReserveActionPerformed

    private void tableShow1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tableShow1ActionPerformed
        timeTable.showPopup(null, 1280, 340);


    }//GEN-LAST:event_tableShow1ActionPerformed

    private void showEventPacksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showEventPacksActionPerformed
        timeEvents.showPopup(this, 935, 208);
    }//GEN-LAST:event_showEventPacksActionPerformed

    private void showTimePacksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showTimePacksActionPerformed
        timePacks.showPopup(this, 935, 208);
    }//GEN-LAST:event_showTimePacksActionPerformed


    private void reserveNowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reserveNowActionPerformed
        System.out.print("CLICKED!");
        ImageIcon error = new ImageIcon(getClass().getResource("/LP_images/Error_1.png"));
        ImageIcon success = new ImageIcon(getClass().getResource("/LP_images/Success.png"));

        DefaultTableModel dt = (DefaultTableModel) cartTable.getModel();
        int tableRow = dt.getRowCount();
        if (dt.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "Table is empty");
            return;
        }

        for (int i = 0; i < tableRow; i++) {
            int value = Integer.valueOf(dt.getValueAt(i, 3).toString());
            if (value < 0) {
                JOptionPane.showMessageDialog(null, "Invalid value in row " + (i + 1), "Reservation", JOptionPane.PLAIN_MESSAGE, error);
                return;
            }
        }

        AccountInfo accounts = new AccountInfo();
        accounts.setUsername(usernameHolder.getText());
        String user = accounts.getUsername();
        int randomNum = new Random().nextInt(1000);
        String orderNumber = String.valueOf(randomNum);

        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/haindatabase", "root", "carlo123")) {
            String query = "INSERT INTO reservations(AccountName, Orders, Quantity, Price, Date, Time, ReservationNumber, Status) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement pst = con.prepareStatement(query)) {
                for (int i = 0; i < tableRow; i++) {
                    String order = dt.getValueAt(i, 2).toString();
                    int quantity = Integer.parseInt(dt.getValueAt(i, 3).toString());
                    int price = Integer.parseInt(dt.getValueAt(i, 4).toString());
                    String date = dt.getValueAt(i, 0).toString();
                    String time = dt.getValueAt(i, 1).toString();

                    pst.setString(1, user);
                    pst.setString(2, order);
                    pst.setInt(3, quantity);
                    pst.setInt(4, price);
                    pst.setString(5, date);
                    pst.setString(6, time);
                    pst.setString(7, orderNumber);
                    pst.setString(8, "Active");
                    pst.executeUpdate();
                }
                JOptionPane.showMessageDialog(null, "Successfully Reserved!", "Hain Reservation System", JOptionPane.PLAIN_MESSAGE, success);
                dt.setRowCount(0);
                totalAmount.setText("0");
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Database operation failed: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE, error);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_reserveNowActionPerformed

    private void computeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_computeActionPerformed
        int numrow = cartTable.getRowCount();

        int total = 0;

        for (int i = 0; i < numrow; i++) {
            int value = Integer.valueOf(cartTable.getValueAt(i, 4).toString());
            total += value;
        }
        totalAmount.setText(Integer.toString(total));
    }//GEN-LAST:event_computeActionPerformed

    private void timeHolderTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timeHolderTableActionPerformed

        timeHolderTable.setEnabled(false);
    }//GEN-LAST:event_timeHolderTableActionPerformed

    private void settingsIconMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_settingsIconMousePressed
        if (evt.isPopupTrigger()) {
            showPopUp(evt);
        }

    }//GEN-LAST:event_settingsIconMousePressed

    private void settingsIconMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_settingsIconMouseReleased
        if (evt.isPopupTrigger()) {
            showPopUp(evt);
        }
    }//GEN-LAST:event_settingsIconMouseReleased

    private void SettingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SettingsActionPerformed
        TablePnl.setVisible(false);
        FoodPnl.setVisible(false);
        EventPnl.setVisible(false);
        PackPnl.setVisible(false);
        EntreePnl.setVisible(false);
        RicePnl.setVisible(false);
        DesertPnl.setVisible(false);
        BeveragePnl.setVisible(false);
        CartPnl.setVisible(false);
        SettingsPnl.setVisible(true);
        ReservationPnl.setVisible(false);

        disabledInfo();
    }//GEN-LAST:event_SettingsActionPerformed

    private void updateInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateInfoActionPerformed
        ImageIcon error = new ImageIcon(getClass().getResource("/LP_images/Error_1.png"));
        ImageIcon success = new ImageIcon(getClass().getResource("/LP_images/Success.png"));
        if (usernameHolder.getText().trim().isEmpty() || passHolder.getPassword().length == 0 || ansHolder.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE, error);
            return;
        }
        if (passHolder.getText().length() < 6) {
            JOptionPane.showMessageDialog(null, "Password must contain a minimum of 6 characters.", "Error", JOptionPane.ERROR_MESSAGE, error);
            return;
        }
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/haindatabase", "root", "carlo123")) {

                String user = usernameHolder.getText();
                String pass = String.valueOf(passHolder.getPassword());
                String ans = ansHolder.getText();

                String query = "UPDATE useraccounts SET Password = ?, Answers = ? WHERE Username = ?";
                PreparedStatement ps = con.prepareStatement(query);
                ps.setString(1, pass);
                ps.setString(2, ans);
                ps.setString(3, user);

                int rowsUpdated = ps.executeUpdate();

                usernameHolder.setEnabled(false);
                passHolder.setEnabled(false);
                ansHolder.setEnabled(false);
                passOpen.setVisible(false);
                ansOpen.setVisible(false);
                passHolder.setEchoChar('*');
                ansHolder.setEchoChar('*');

                if (rowsUpdated > 0) {
                    JOptionPane.showMessageDialog(null, "Account Information updated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE, success);
                } else {
                    JOptionPane.showMessageDialog(null, "Failed to update account information!", "Error", JOptionPane.ERROR_MESSAGE, error);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "An error occurred: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_updateInfoActionPerformed

    private void LogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutActionPerformed
        Login lg = new Login();
        lg.setVisible(true);
        dispose();
    }//GEN-LAST:event_LogoutActionPerformed

    private void userLockMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userLockMouseClicked
        ImageIcon error = new ImageIcon(getClass().getResource("/LP_images/Error_1.png"));
        String username = usernameHolder.getText();
        if (verifyPassword(username)) {
            usernameHolder.setEnabled(true);
        } else {
            JOptionPane.showMessageDialog(null, "Incorrect password!", "Error", JOptionPane.ERROR_MESSAGE, error);
        }
    }//GEN-LAST:event_userLockMouseClicked

    private void passLockMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_passLockMouseClicked
        ImageIcon error = new ImageIcon(getClass().getResource("/LP_images/Error_1.png"));
        String username = usernameHolder.getText();
        if (verifyPassword(username)) {
            passHolder.setEnabled(true);
        } else {
            JOptionPane.showMessageDialog(null, "Incorrect password!", "Error", JOptionPane.ERROR_MESSAGE, error);
        }
    }//GEN-LAST:event_passLockMouseClicked

    private void passHideMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_passHideMouseClicked
        ImageIcon error = new ImageIcon(getClass().getResource("/LP_images/Error_1.png"));
        String username = usernameHolder.getText();
        if (verifyPassword(username)) {
            passHide.setVisible(false);
            passOpen.setVisible(true);
            passHolder.setEchoChar((char) 0);
        } else {
            JOptionPane.showMessageDialog(null, "Incorrect password!", "Error", JOptionPane.ERROR_MESSAGE, error);
        }
    }//GEN-LAST:event_passHideMouseClicked

    private void passOpenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_passOpenMouseClicked

        passHide.setVisible(true);
        passOpen.setVisible(false);
        passHolder.setEchoChar('*');

    }//GEN-LAST:event_passOpenMouseClicked

    private void ansHideMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ansHideMouseClicked
        ImageIcon error = new ImageIcon(getClass().getResource("/LP_images/Error_1.png"));
        String username = usernameHolder.getText();
        if (verifyPassword(username)) {
            ansHide.setVisible(false);
            ansOpen.setVisible(true);
            ansHolder.setEchoChar((char) 0);
        } else {
            JOptionPane.showMessageDialog(null, "Incorrect password!", "Error", JOptionPane.ERROR_MESSAGE, error);
        }

    }//GEN-LAST:event_ansHideMouseClicked

    private void ansOpenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ansOpenMouseClicked

        ansHide.setVisible(true);
        ansOpen.setVisible(false);
        ansHolder.setEchoChar('*');

    }//GEN-LAST:event_ansOpenMouseClicked

    private void ansLockMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ansLockMouseClicked
        ImageIcon error = new ImageIcon(getClass().getResource("/LP_images/Error_1.png"));
        String username = usernameHolder.getText();
        if (verifyPassword(username)) {
            ansHolder.setEnabled(true);
        } else {
            JOptionPane.showMessageDialog(null, "Incorrect password!", "Error", JOptionPane.ERROR_MESSAGE, error);
        }
    }//GEN-LAST:event_ansLockMouseClicked

    private void updateInfoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateInfoMouseEntered
        updateInfo.setBackground(new Color(240, 240, 240));
        updateInfo.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_updateInfoMouseEntered

    private void updateInfoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateInfoMouseExited
        updateInfo.setBackground(new Color(250, 250, 250));
    }//GEN-LAST:event_updateInfoMouseExited

    private void Entree3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Entree3MouseClicked
        DesertPnl.setVisible(false);
        RicePnl.setVisible(false);
        EntreePnl.setVisible(true);
        FoodPnl.setVisible(false);
        TablePnl.setVisible(false);
        EventPnl.setVisible(false);
        PackPnl.setVisible(false);
        CartPnl.setVisible(false);
        SettingsPnl.setVisible(false);
        ReservationPnl.setVisible(false);

        Entree1.setBackground(new Color(201, 201, 201));
        Entree1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    }//GEN-LAST:event_Entree3MouseClicked

    private void apeBtn3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_apeBtn3MouseClicked
        DesertPnl.setVisible(false);
        RicePnl.setVisible(false);
        EntreePnl.setVisible(false);
        FoodPnl.setVisible(true);
        TablePnl.setVisible(false);
        EventPnl.setVisible(false);
        PackPnl.setVisible(false);
        CartPnl.setVisible(false);
        SettingsPnl.setVisible(false);
        ReservationPnl.setVisible(false);

        apeBtn.setBackground(new Color(201, 201, 201));
        apeBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    }//GEN-LAST:event_apeBtn3MouseClicked

    private void ReservationLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ReservationLabelMouseClicked
        CartPnl.setVisible(false);
        TablePnl.setVisible(false);
        FoodPnl.setVisible(false);
        EventPnl.setVisible(false);
        PackPnl.setVisible(false);
        EntreePnl.setVisible(false);
        RicePnl.setVisible(false);
        DesertPnl.setVisible(false);
        BeveragePnl.setVisible(false);
        SettingsPnl.setVisible(false);
        ReservationPnl.setVisible(true);
    }//GEN-LAST:event_ReservationLabelMouseClicked

    private void ReservationLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ReservationLabelMouseEntered
        Reservation.setBackground(new Color(242, 242, 242));
    }//GEN-LAST:event_ReservationLabelMouseEntered

    private void ReservationLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ReservationLabelMouseExited
        Reservation.setBackground(new Color(200, 200, 200));
    }//GEN-LAST:event_ReservationLabelMouseExited

    private void CancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelActionPerformed
        ImageIcon error = new ImageIcon(getClass().getResource("/LP_images/Error_1.png"));
        ImageIcon success = new ImageIcon(getClass().getResource("/LP_images/Success.png"));
        int selectedRow = reserveTable.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "Please select a reservation to cancel.", "Error", JOptionPane.ERROR_MESSAGE, error);
            return;
        }

        String reservationNumber = reserveTable.getValueAt(selectedRow, 0).toString();

        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/haindatabase", "root", "carlo123")) {

            String query = "UPDATE reservations SET Status = ? WHERE ReservationNumber = ?";
            try (PreparedStatement pst = con.prepareStatement(query)) {
                pst.setString(1, "Cancelled");
                pst.setString(2, reservationNumber);
                int rowsAffected = pst.executeUpdate();

                if (rowsAffected > 0) {

                    reserveTable.setValueAt("Cancelled", selectedRow, 6);
                    JOptionPane.showMessageDialog(null, "Reservation Cancelled.", "Success", JOptionPane.INFORMATION_MESSAGE, success);
                } else {
                    JOptionPane.showMessageDialog(null, "Failed to cancel the reservation. Please try again.", "Error", JOptionPane.ERROR_MESSAGE, error);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Database operation failed: " + ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_CancelActionPerformed


    private void CheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckActionPerformed
        ImageIcon error = new ImageIcon(getClass().getResource("/LP_images/Error_1.png"));
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Reservation No#");
        model.addColumn("Date");
        model.addColumn("Time");
        model.addColumn("Orders");
        model.addColumn("Quantity");
        model.addColumn("Price");
        model.addColumn("Status");

        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/haindatabase", "root", "carlo123")) {
            String query = "SELECT ReservationNumber, Date, Time, Orders, Quantity, Price, Status FROM reservations WHERE AccountName = ?";
            try (PreparedStatement pst = con.prepareStatement(query)) {

                pst.setString(1, usernameHolder.getText());
                try (ResultSet rs = pst.executeQuery()) {
                    while (rs.next()) {
                        Object[] row = new Object[7];
                        row[0] = rs.getString("ReservationNumber");
                        row[1] = rs.getString("Date");
                        row[2] = rs.getString("Time");
                        row[3] = rs.getString("Orders");
                        row[4] = rs.getInt("Quantity");
                        row[5] = rs.getInt("Price");
                        row[6] = rs.getString("Status");
                        model.addRow(row);
                    }
                }
            }

            reserveTable.setModel(model);

            for (int column = 0; column < reserveTable.getColumnCount(); column++) {
                TableColumn tableColumn = reserveTable.getColumnModel().getColumn(column);
                int maxWidth = 0;
                for (int row = 0; row < reserveTable.getRowCount(); row++) {
                    TableCellRenderer cellRenderer = reserveTable.getCellRenderer(row, column);
                    Component comp = reserveTable.prepareRenderer(cellRenderer, row, column);
                    maxWidth = Math.max(comp.getPreferredSize().width, maxWidth);
                }
                tableColumn.setPreferredWidth(maxWidth + 10);
                DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
                renderer.setHorizontalAlignment(SwingConstants.CENTER);
                tableColumn.setCellRenderer(renderer);

                reserveTable.getColumnModel().getColumn(6).setCellRenderer(new DefaultTableCellRenderer() {
                    @Override
                    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                        Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                        if ("Cancelled".equals(value)) {
                            cell.setForeground(Color.RED);
                        } else if ("Active".equals(value)) {
                            cell.setForeground(Color.GREEN);
                        } else {
                            cell.setForeground(Color.BLACK);
                        }
                        setHorizontalAlignment(SwingConstants.CENTER);
                        return cell;
                    }
                });
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Failed to fetch data: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE, error);
        }
    }//GEN-LAST:event_CheckActionPerformed

    private void searchIcon2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchIcon2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_searchIcon2MouseClicked
    private boolean verifyPassword(String username) {
        ImageIcon error = new ImageIcon(getClass().getResource("/LP_images/Error_1.png"));
        JPasswordField pwd = new JPasswordField(5);
        int action = JOptionPane.showConfirmDialog(null, pwd, "Enter Your Password", JOptionPane.OK_CANCEL_OPTION);

        if (action == JOptionPane.OK_OPTION) {
            String enteredPassword = new String(pwd.getPassword());

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/haindatabase", "root", "carlo123");
                String query = "SELECT Password FROM useraccounts WHERE Username = ?";
                PreparedStatement pst = con.prepareStatement(query);
                pst.setString(1, username);
                ResultSet rs = pst.executeQuery();

                if (rs.next()) {
                    String storedPassword = rs.getString("Password");
                    return enteredPassword.equals(storedPassword);
                } else {
                    JOptionPane.showMessageDialog(null, "Username not found!", "Error", JOptionPane.ERROR_MESSAGE, error);
                }
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, " Error occurred: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE, error);
            }
        }

        return false;
    }

    public void addTable(String date, String time, String name, int qty, int price) {

        DefaultTableModel dt = (DefaultTableModel) cartTable.getModel();

        for (int row = 0; row < cartTable.getRowCount(); row++) {
            if (name == cartTable.getValueAt(row, 1)) {
                dt.removeRow(cartTable.convertRowIndexToModel(row));
            }
        }

        Vector v = new Vector();

        v.add(date);
        v.add(time);
        v.add(name);
        v.add(qty);
        v.add(price);

        dt.addRow(v);

    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Background;
    private javax.swing.JPanel Base;
    private button.Button Beverage;
    private button.Button Beverage1;
    private button.Button Beverage2;
    private button.Button Beverage3;
    private button.Button Beverage4;
    private javax.swing.JPanel BeveragePnl;
    private button.Button Cancel;
    private button.Button Cancel1;
    private button.Button Cancel2;
    private button.Button Cancel3;
    private button.Button Cancel4;
    private javax.swing.JPanel Cart;
    private javax.swing.JLabel CartLabel;
    private javax.swing.JPanel CartPnl;
    private button.Button Check;
    private button.Button Check1;
    private button.Button Check2;
    private button.Button Check3;
    private button.Button Check4;
    private javax.swing.JLabel Description1;
    private javax.swing.JLabel Description10;
    private javax.swing.JLabel Description11;
    private javax.swing.JLabel Description12;
    private javax.swing.JLabel Description13;
    private javax.swing.JLabel Description14;
    private javax.swing.JLabel Description15;
    private javax.swing.JLabel Description16;
    private javax.swing.JLabel Description17;
    private javax.swing.JLabel Description18;
    private javax.swing.JLabel Description19;
    private javax.swing.JLabel Description2;
    private javax.swing.JLabel Description20;
    private javax.swing.JLabel Description21;
    private javax.swing.JLabel Description25;
    private javax.swing.JLabel Description26;
    private javax.swing.JLabel Description3;
    private javax.swing.JLabel Description30;
    private javax.swing.JLabel Description31;
    private javax.swing.JLabel Description32;
    private javax.swing.JLabel Description33;
    private javax.swing.JLabel Description34;
    private javax.swing.JLabel Description35;
    private javax.swing.JLabel Description36;
    private javax.swing.JLabel Description37;
    private javax.swing.JLabel Description38;
    private javax.swing.JLabel Description39;
    private javax.swing.JLabel Description4;
    private javax.swing.JLabel Description40;
    private javax.swing.JLabel Description41;
    private javax.swing.JLabel Description42;
    private javax.swing.JLabel Description43;
    private javax.swing.JLabel Description44;
    private javax.swing.JLabel Description45;
    private javax.swing.JLabel Description46;
    private javax.swing.JLabel Description47;
    private javax.swing.JLabel Description48;
    private javax.swing.JLabel Description49;
    private javax.swing.JLabel Description5;
    private javax.swing.JLabel Description50;
    private javax.swing.JLabel Description51;
    private javax.swing.JLabel Description52;
    private javax.swing.JLabel Description53;
    private javax.swing.JLabel Description54;
    private javax.swing.JLabel Description55;
    private javax.swing.JLabel Description56;
    private javax.swing.JLabel Description57;
    private javax.swing.JLabel Description58;
    private javax.swing.JLabel Description59;
    private javax.swing.JLabel Description6;
    private javax.swing.JLabel Description60;
    private javax.swing.JLabel Description61;
    private javax.swing.JLabel Description62;
    private javax.swing.JLabel Description63;
    private javax.swing.JLabel Description64;
    private javax.swing.JLabel Description7;
    private javax.swing.JLabel Description8;
    private javax.swing.JLabel Description9;
    private button.Button Desert;
    private button.Button Desert1;
    private button.Button Desert2;
    private button.Button Desert3;
    private button.Button Desert4;
    private javax.swing.JPanel DesertPnl;
    private button.Button Entree;
    private button.Button Entree1;
    private button.Button Entree2;
    private button.Button Entree3;
    private button.Button Entree4;
    private javax.swing.JPanel EntreePnl;
    private javax.swing.JLabel EventBg;
    private javax.swing.JLabel EventLabel;
    private javax.swing.JPanel EventPnl;
    private javax.swing.JPanel Events;
    private javax.swing.JLabel Exit;
    private javax.swing.JPanel Food;
    private javax.swing.JLabel FoodLbl;
    private javax.swing.JPanel FoodPnl;
    private javax.swing.JPanel Header;
    private javax.swing.JLabel Headerpng;
    private RoundedComponents.PanelRound JasmineHolder;
    private javax.swing.JMenuItem Logout;
    private javax.swing.JLabel PackLabel;
    private javax.swing.JPanel PackPnl;
    private javax.swing.JPanel Package;
    private javax.swing.JLabel Price10;
    private javax.swing.JLabel Price11;
    private javax.swing.JLabel Price15;
    private javax.swing.JLabel Price16;
    private javax.swing.JLabel Price17;
    private javax.swing.JLabel Price18;
    private javax.swing.JLabel Price3;
    private javax.swing.JLabel Price4;
    private javax.swing.JLabel Price5;
    private javax.swing.JLabel Price6;
    private javax.swing.JLabel Price8;
    private javax.swing.JLabel Price9;
    private javax.swing.JPanel Reservation;
    private javax.swing.JLabel ReservationLabel;
    private javax.swing.JPanel ReservationPnl;
    private button.Button Rice;
    private button.Button Rice1;
    private button.Button Rice2;
    private button.Button Rice3;
    private button.Button Rice4;
    private javax.swing.JPanel RicePnl;
    private javax.swing.JMenuItem Settings;
    private javax.swing.JPanel SettingsPnl;
    private javax.swing.JPanel Sidebar;
    private javax.swing.JPanel Table;
    private javax.swing.JLabel TableLabel;
    private javax.swing.JPanel TablePnl;
    private RoundedComponents.PanelRound adoboHolder;
    private button.Button adoboOrder;
    private javax.swing.JSpinner adoboQuantity;
    private javax.swing.JLabel adoboTitle;
    private javax.swing.JLabel ansHide;
    private textfield.PasswordField ansHolder;
    private javax.swing.JLabel ansLock;
    private javax.swing.JLabel ansOpen;
    private javax.swing.JLabel ansTitle;
    private button.Button apeBtn;
    private button.Button apeBtn1;
    private button.Button apeBtn2;
    private button.Button apeBtn3;
    private button.Button apeBtn4;
    private RoundedComponents.RoundLabel bdayImg;
    private javax.swing.JLabel bdayPrice;
    private button.Button bdayReserve;
    private javax.swing.JLabel bdayTitle;
    private javax.swing.JLabel bg;
    private RoundedComponents.PanelRound bicolHolder;
    private button.Button bicolOrder;
    private javax.swing.JSpinner bicolQuantity;
    private javax.swing.JLabel bicolTitle;
    private RoundedComponents.RoundLabel bicolmg;
    private RoundedComponents.RoundLabel bicolmg1;
    private RoundedComponents.RoundLabel bicolmg10;
    private RoundedComponents.RoundLabel bicolmg2;
    private RoundedComponents.RoundLabel bicolmg3;
    private RoundedComponents.RoundLabel bicolmg4;
    private RoundedComponents.RoundLabel bicolmg5;
    private RoundedComponents.RoundLabel bicolmg6;
    private RoundedComponents.RoundLabel bicolmg7;
    private RoundedComponents.RoundLabel bicolmg8;
    private RoundedComponents.RoundLabel bicolmg9;
    private RoundedComponents.PanelRound birthdayHolder;
    private button.Button button2;
    private button.Button button3;
    private javax.swing.JLabel cartIcon;
    private javax.swing.JLabel cartIcon1;
    private javax.swing.JLabel cartIcon10;
    private javax.swing.JLabel cartIcon11;
    private javax.swing.JLabel cartIcon12;
    private javax.swing.JLabel cartIcon13;
    private javax.swing.JLabel cartIcon14;
    private javax.swing.JLabel cartIcon15;
    private javax.swing.JLabel cartIcon16;
    private javax.swing.JLabel cartIcon17;
    private javax.swing.JLabel cartIcon18;
    private javax.swing.JLabel cartIcon19;
    private javax.swing.JLabel cartIcon2;
    private javax.swing.JLabel cartIcon20;
    private javax.swing.JLabel cartIcon21;
    private javax.swing.JLabel cartIcon22;
    private javax.swing.JLabel cartIcon23;
    private javax.swing.JLabel cartIcon24;
    private javax.swing.JLabel cartIcon25;
    private javax.swing.JLabel cartIcon26;
    private javax.swing.JLabel cartIcon3;
    private javax.swing.JLabel cartIcon4;
    private javax.swing.JLabel cartIcon5;
    private javax.swing.JLabel cartIcon6;
    private javax.swing.JLabel cartIcon7;
    private javax.swing.JLabel cartIcon8;
    private javax.swing.JLabel cartIcon9;
    private javax.swing.JScrollPane cartScroll;
    private javax.swing.JSeparator cartSep;
    private javax.swing.JTable cartTable;
    private button.Button compute;
    private button.Button computeDupe1;
    private button.Button computeDupe2;
    private button.Button computeDupe3;
    private button.Button computeDupe4;
    private RoundedComponents.PanelRound crabHolder;
    private button.Button crabOrder;
    private javax.swing.JLabel crabPrice;
    private javax.swing.JSpinner crabQuantity;
    private javax.swing.JLabel crabTitle;
    private DateChooserComponent.DateChooser dateEvent;
    private TextFieldUI.TextField dateHolderEvent;
    private TextFieldUI.TextField dateHolderPack;
    private TextFieldUI.TextField dateShow;
    private RoundedComponents.PanelRound empHolder;
    private button.Button empOrder;
    private javax.swing.JLabel empPrice;
    private javax.swing.JSpinner empQuantity;
    private javax.swing.JLabel empTitle;
    private javax.swing.JSeparator eventSep;
    private RoundedComponents.PanelRound familyHolder;
    private RoundedComponents.RoundLabel familyImg;
    private javax.swing.JLabel familyPrice;
    private button.Button familyReserve;
    private javax.swing.JLabel familyTitle;
    private RoundedComponents.PanelRound firstHolder;
    private RoundedComponents.PanelRound fishHolder;
    private RoundedComponents.RoundLabel fishImg;
    private button.Button fishOrder;
    private javax.swing.JSpinner fishQuantity;
    private javax.swing.JLabel fishTitle;
    private javax.swing.JSeparator foodSep;
    private RoundedComponents.PanelRound fruitHolder;
    private button.Button fruitOrder;
    private javax.swing.JSpinner fruitQuantity;
    private javax.swing.JLabel fruitTitle;
    private button.Button gulamanOrder;
    private javax.swing.JSpinner haloQuantity;
    private RoundedComponents.PanelRound halohaloHolder;
    private button.Button halohaloOrder;
    private javax.swing.JLabel halohaloTitle;
    private RoundedComponents.PanelRound holidayHolder;
    private RoundedComponents.RoundLabel holidayImg;
    private javax.swing.JLabel holidayPrice;
    private button.Button holidayReserve;
    private javax.swing.JLabel holidayTitle;
    private RoundedComponents.PanelRound iceteaHolder;
    private button.Button iceteaOrder;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private button.Button jasOrder;
    private javax.swing.JSpinner jasQuantity;
    private javax.swing.JLabel jasTitle;
    private button.Button javaOrder;
    private javax.swing.JSpinner javaQty;
    private javax.swing.JLabel javaQuantity;
    private javax.swing.JLabel javaTitle;
    private RoundedComponents.PanelRound lechonHolder;
    private RoundedComponents.RoundLabel lechonImg;
    private button.Button lechonOrder;
    private javax.swing.JSpinner lechonQuantity;
    private javax.swing.JLabel lechonTitle;
    private RoundedComponents.PanelRound majaHolder;
    private button.Button majaOrder;
    private javax.swing.JSpinner majaQuantity;
    private javax.swing.JLabel majaTitle;
    private button.Button nextBtn;
    private button.Button nextBtn1;
    private javax.swing.JLabel onePax;
    private RoundedComponents.RoundLabel onePaxImg;
    private javax.swing.JSpinner onePaxQuantity;
    private button.Button onePaxReserve;
    private button.Button onePaxdupe;
    private DateChooserComponent.DateChooser packDate;
    private javax.swing.JSeparator packSep;
    private RoundedComponents.PanelRound pancitHolder;
    private RoundedComponents.PanelRound pancitHolder2;
    private button.Button pancitOrder;
    private javax.swing.JLabel pancitPrice;
    private javax.swing.JSpinner pancitQuantity;
    private javax.swing.JLabel pancitTitle;
    private RoundedComponents.PanelRound pandanHolder;
    private javax.swing.JSpinner pandanQuantity;
    private javax.swing.JLabel pandanTitle;
    private javax.swing.JLabel passHide;
    private textfield.PasswordField passHolder;
    private javax.swing.JLabel passLock;
    private javax.swing.JLabel passOpen;
    private javax.swing.JLabel passTitle;
    private button.Button reserveDupe;
    private button.Button reserveDupe1;
    private button.Button reserveDupe2;
    private button.Button reserveDupe3;
    private button.Button reserveNow;
    private javax.swing.JScrollPane reserveScroll;
    private javax.swing.JTable reserveTable;
    private RoundedComponents.RoundLabel roundLabel1;
    private RoundedComponents.RoundLabel roundLabel2;
    private RoundedComponents.RoundLabel roundLabel3;
    private javax.swing.JLabel searchIcon;
    private javax.swing.JLabel searchIcon1;
    private javax.swing.JLabel searchIcon2;
    private textfield.TextField secuHolder;
    private javax.swing.JLabel secuTitle;
    private javax.swing.JPopupMenu settings;
    private javax.swing.JLabel settingsIcon;
    private DateChooserComponent.Button showEvent;
    private DateChooserComponent.Button showEventPacks;
    private DateChooserComponent.Button showPack;
    private DateChooserComponent.Button showTimePacks;
    private RoundedComponents.PanelRound sixHolder;
    private javax.swing.JLabel sixPax;
    private RoundedComponents.RoundLabel sixPaxImg;
    private javax.swing.JSpinner sixPaxQuantity;
    private button.Button sixPaxReserve;
    private button.Button sixPaxdupe;
    private button.Button sofdrinkOrder;
    private javax.swing.JSpinner softDrinksQuantity;
    private RoundedComponents.PanelRound softdrinkHolder;
    private javax.swing.JLabel softdrinkTitle;
    private DateChooserComponent.DateChooser tableDate;
    private javax.swing.JSeparator tableSep;
    private DateChooserComponent.Button tableShow;
    private DateChooserComponent.Button tableShow1;
    private javax.swing.JSpinner teaQuantity;
    private javax.swing.JLabel teaTitle;
    private RoundedComponents.PanelRound tenHolder;
    private javax.swing.JLabel tenPax;
    private RoundedComponents.RoundLabel tenPaxImg;
    private javax.swing.JSpinner tenPaxQuantity;
    private button.Button tenPaxReserve;
    private button.Button tenPaxdupe;
    private javax.swing.JLabel testUser;
    private RoundedComponents.PanelRound thirdHolder;
    private javax.swing.JLabel threePax;
    private RoundedComponents.RoundLabel threePaxImg;
    private javax.swing.JSpinner threePaxQuantity;
    private button.Button threePaxReserve1;
    private button.Button threePaxdupe;
    private com.raven.swing.TimePicker timeEvents;
    private TextFieldUI.TextField timeHolderEvents;
    private TextFieldUI.TextField timeHolderPack;
    private TextFieldUI.TextField timeHolderTable;
    private com.raven.swing.TimePicker timePacks;
    private com.raven.swing.TimePicker timeTable;
    private javax.swing.JLabel totalAmount;
    private RoundedComponents.PanelRound trioHolder;
    private RoundedComponents.RoundLabel trioImg;
    private javax.swing.JLabel trioPrice;
    private button.Button trioReserve;
    private javax.swing.JLabel trioTitle;
    private button.Button updateInfo;
    private javax.swing.JLabel userLock;
    private javax.swing.JLabel userTitle;
    private textfield.TextField usernameHolder;
    private RoundedComponents.PanelRound valenHolder;
    private RoundedComponents.RoundLabel valenImg;
    private javax.swing.JLabel valenPrice;
    private RoundedComponents.RoundLabel valentineImg;
    private javax.swing.JLabel valentinePrice;
    private button.Button valentineReserve;
    private javax.swing.JLabel valentineTitle;
    private RoundedComponents.PanelRound valentinesHolder;
    private button.Button vdateReserve;
    private javax.swing.JLabel vdateTitle;
    private RoundedComponents.PanelRound weddingHolder;
    private RoundedComponents.RoundLabel weddingImg;
    private javax.swing.JLabel weddingPrice;
    private button.Button weddingReserve;
    private javax.swing.JLabel weddingTitle;
    private RoundedComponents.PanelRound xmasHolder;
    private RoundedComponents.RoundLabel xmasImg;
    private javax.swing.JLabel xmasPrice;
    private button.Button xmasReserve;
    private javax.swing.JLabel xmasTitle;
    // End of variables declaration//GEN-END:variables
}
