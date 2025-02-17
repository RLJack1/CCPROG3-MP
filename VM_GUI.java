import java.awt.Image;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;

/** 
  * Gets feedback from and provides feedback to the user through visual elements
  */
public class VM_GUI extends javax.swing.JFrame {
    public ArrayList<JLabel> labelList = new ArrayList<>();
    public ArrayList<JLabel> priceList = new ArrayList<>();
    public ArrayList<JLabel> moneyList = new ArrayList<>();
    public ArrayList<JSpinner> mhSpinnerList = new ArrayList<>();
    public ArrayList<JSpinner> itemSpinnerList = new ArrayList<>();
    public ArrayList<JRadioButton> restockRadioList = new ArrayList<>();
    public ArrayList<JRadioButton> repriceRadioList = new ArrayList<>();
    public ArrayList<JButton> itemButtonList = new ArrayList<>();
    public ArrayList<JButton> moneyInputList = new ArrayList<>();
    public ArrayList<JButton> recipeButtonList = new ArrayList<>();
   
   /**
     * Instantiates new VM_GUI
     */
    public VM_GUI() {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VM_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VM_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VM_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VM_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        initComponents();
        initStockLabels();
        initMHSpinnerList();
        initRadioList();
        initItemList();
        initRecipeButtonList();
        initPriceList();
        initMoneyList();
        initMoneyInputList();
        this.setVisible(true);
    }

    /**
      * This method is called from within the constructor to initialize the form.
      */
    //@SuppressWarnings("unchecked")                         
    private void initComponents() {

        buttonGroup = new javax.swing.ButtonGroup();
        buttonGroupItems = new javax.swing.ButtonGroup();
        jToggleButton1 = new javax.swing.JToggleButton();
        TestVendingMachinePanel = new javax.swing.JPanel();
        jTextAreaPane = new javax.swing.JScrollPane();
        jTextAreaConsole = new javax.swing.JTextArea();
        jVMName = new javax.swing.JLabel();
        jRegOrSpeLabel = new javax.swing.JLabel();
        jButtonBill1 = new javax.swing.JButton();
        jButtonBill5 = new javax.swing.JButton();
        jButtonBill10 = new javax.swing.JButton();
        jButtonBill20 = new javax.swing.JButton();
        jButtonBill50 = new javax.swing.JButton();
        jButtonBill100 = new javax.swing.JButton();
        jButtonBill500 = new javax.swing.JButton();
        jButtonBill1000 = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jTabbedPaneItem = new javax.swing.JTabbedPane();
        ItemRack = new javax.swing.JScrollPane();
        ItemPanel = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jButtonCancelItem = new javax.swing.JButton();
        jButtonConfirmItem = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        BriocheSpinner = new javax.swing.JSpinner();
        ItemStock21 = new javax.swing.JLabel();
        jButton16JackBeef = new javax.swing.JButton();
        ItemPrice6 = new javax.swing.JLabel();
        CaviarSpinner = new javax.swing.JSpinner();
        WagyuSpinner = new javax.swing.JSpinner();
        jButton28Barbecue = new javax.swing.JButton();
        jButton9Tapa = new javax.swing.JButton();
        jButton15Beyond = new javax.swing.JButton();
        ItemPic18 = new javax.swing.JLabel();
        ItemStock11 = new javax.swing.JLabel();
        ItemStock29 = new javax.swing.JLabel();
        jButton24Beefsteak = new javax.swing.JButton();
        ItemPic3 = new javax.swing.JLabel();
        ItemStock25 = new javax.swing.JLabel();
        ItemStock9 = new javax.swing.JLabel();
        ItemPic30 = new javax.swing.JLabel();
        ItemStock23 = new javax.swing.JLabel();
        JSauceSpinner = new javax.swing.JSpinner();
        ItemStock1 = new javax.swing.JLabel();
        BeefsteakSpinner = new javax.swing.JSpinner();
        jButton29Caviar = new javax.swing.JButton();
        ItemPic20 = new javax.swing.JLabel();
        TrappistSpinner = new javax.swing.JSpinner();
        ItemPic19 = new javax.swing.JLabel();
        ItemPrice2 = new javax.swing.JLabel();
        jButton22American = new javax.swing.JButton();
        jButton3Rye = new javax.swing.JButton();
        jButton10Cheesed = new javax.swing.JButton();
        ItemStock13 = new javax.swing.JLabel();
        ItemPic11 = new javax.swing.JLabel();
        ItemPrice4 = new javax.swing.JLabel();
        ItemStock2 = new javax.swing.JLabel();
        jButton23Melted = new javax.swing.JButton();
        AmericanSpinner = new javax.swing.JSpinner();
        JBeefSpinner = new javax.swing.JSpinner();
        jButton4Wholewheat = new javax.swing.JButton();
        jButton27Hot = new javax.swing.JButton();
        ItemPic1 = new javax.swing.JLabel();
        jButton20Mozzarella = new javax.swing.JButton();
        ItemPic25 = new javax.swing.JLabel();
        ItemStock18 = new javax.swing.JLabel();
        ItemPic23 = new javax.swing.JLabel();
        jButton5Potato = new javax.swing.JButton();
        WeinerSpinner = new javax.swing.JSpinner();
        CheesedSpinner = new javax.swing.JSpinner();
        jButton6Jack = new javax.swing.JButton();
        jButton1Brioche = new javax.swing.JButton();
        TapaSpinner = new javax.swing.JSpinner();
        ItemPic21 = new javax.swing.JLabel();
        ItemStock12 = new javax.swing.JLabel();
        jButton14Bronze = new javax.swing.JButton();
        ItemPic22 = new javax.swing.JLabel();
        CanadianSpinner = new javax.swing.JSpinner();
        ItemStock24 = new javax.swing.JLabel();
        ItemPrice5 = new javax.swing.JLabel();
        DillSpinner = new javax.swing.JSpinner();
        BeyondSpinner = new javax.swing.JSpinner();
        jButton19Trappist = new javax.swing.JButton();
        ItemPic16 = new javax.swing.JLabel();
        ItemStock7 = new javax.swing.JLabel();
        JBreadSpinner = new javax.swing.JSpinner();
        IcebergSpinner = new javax.swing.JSpinner();
        jButton17White = new javax.swing.JButton();
        jButton8Wagyu = new javax.swing.JButton();
        WholewheatSpinner = new javax.swing.JSpinner();
        ItemStock17 = new javax.swing.JLabel();
        ItemStock19 = new javax.swing.JLabel();
        ItemPic28 = new javax.swing.JLabel();
        AngusSpinner = new javax.swing.JSpinner();
        jButton13Grilled = new javax.swing.JButton();
        ItemPic24 = new javax.swing.JLabel();
        ItemPic4 = new javax.swing.JLabel();
        jButton11Canadian = new javax.swing.JButton();
        ItemPic13 = new javax.swing.JLabel();
        MeltedSpinner = new javax.swing.JSpinner();
        ItemStock10 = new javax.swing.JLabel();
        ItemPrice3 = new javax.swing.JLabel();
        ItemStock27 = new javax.swing.JLabel();
        RyeSpinner = new javax.swing.JSpinner();
        ItemStock14 = new javax.swing.JLabel();
        ItemStock15 = new javax.swing.JLabel();
        ItemStock6 = new javax.swing.JLabel();
        ItemStock5 = new javax.swing.JLabel();
        ItemPic17 = new javax.swing.JLabel();
        jButton12Weiner = new javax.swing.JButton();
        ItemPic8 = new javax.swing.JLabel();
        jButton25Iceberg = new javax.swing.JButton();
        BronzeSpinner = new javax.swing.JSpinner();
        ItemPic7 = new javax.swing.JLabel();
        PotatoSpinner = new javax.swing.JSpinner();
        jButton18Onion = new javax.swing.JButton();
        ItemPic26 = new javax.swing.JLabel();
        ItemStock3 = new javax.swing.JLabel();
        jButton30JackSauce = new javax.swing.JButton();
        jButton21Blue = new javax.swing.JButton();
        ItemPic12 = new javax.swing.JLabel();
        WhiteSpinner = new javax.swing.JSpinner();
        BarbecueSpinner = new javax.swing.JSpinner();
        ItemStock22 = new javax.swing.JLabel();
        jButton26Dill = new javax.swing.JButton();
        ItemPic10 = new javax.swing.JLabel();
        ItemPic14 = new javax.swing.JLabel();
        ItemStock16 = new javax.swing.JLabel();
        OnionSpinner = new javax.swing.JSpinner();
        jButton2Sesame = new javax.swing.JButton();
        ItemStock28 = new javax.swing.JLabel();
        jButton7Angus = new javax.swing.JButton();
        HotSpinner = new javax.swing.JSpinner();
        ItemPic15 = new javax.swing.JLabel();
        ItemPic5 = new javax.swing.JLabel();
        MozzarellaSpinner = new javax.swing.JSpinner();
        GrilledSpinner = new javax.swing.JSpinner();
        ItemStock4 = new javax.swing.JLabel();
        ItemStock26 = new javax.swing.JLabel();
        ItemPic6 = new javax.swing.JLabel();
        SesameSpinner = new javax.swing.JSpinner();
        ItemPic27 = new javax.swing.JLabel();
        ItemPic29 = new javax.swing.JLabel();
        ItemPic2 = new javax.swing.JLabel();
        ItemStock20 = new javax.swing.JLabel();
        ItemStock30 = new javax.swing.JLabel();
        ItemStock8 = new javax.swing.JLabel();
        BlueSpinner = new javax.swing.JSpinner();
        ItemPic9 = new javax.swing.JLabel();
        ItemPrice1 = new javax.swing.JLabel();
        ItemPrice7 = new javax.swing.JLabel();
        ItemPrice8 = new javax.swing.JLabel();
        ItemPrice9 = new javax.swing.JLabel();
        ItemPrice10 = new javax.swing.JLabel();
        ItemPrice11 = new javax.swing.JLabel();
        ItemPrice12 = new javax.swing.JLabel();
        ItemPrice13 = new javax.swing.JLabel();
        ItemPrice14 = new javax.swing.JLabel();
        ItemPrice15 = new javax.swing.JLabel();
        ItemPrice16 = new javax.swing.JLabel();
        ItemPrice17 = new javax.swing.JLabel();
        ItemPrice18 = new javax.swing.JLabel();
        ItemPrice19 = new javax.swing.JLabel();
        ItemPrice20 = new javax.swing.JLabel();
        ItemPrice21 = new javax.swing.JLabel();
        ItemPrice22 = new javax.swing.JLabel();
        ItemPrice23 = new javax.swing.JLabel();
        ItemPrice24 = new javax.swing.JLabel();
        ItemPrice25 = new javax.swing.JLabel();
        ItemPrice26 = new javax.swing.JLabel();
        ItemPrice27 = new javax.swing.JLabel();
        ItemPrice28 = new javax.swing.JLabel();
        ItemPrice29 = new javax.swing.JLabel();
        ItemPrice30 = new javax.swing.JLabel();
        jPanelRecipe = new javax.swing.JPanel();
        RecipePic2 = new javax.swing.JLabel();
        RecipePic1 = new javax.swing.JLabel();
        RecipePic3 = new javax.swing.JLabel();
        RecipePic4 = new javax.swing.JLabel();
        ItemName33 = new javax.swing.JLabel();
        RecipePic5 = new javax.swing.JLabel();
        RecipePic9 = new javax.swing.JLabel();
        RecipePic10 = new javax.swing.JLabel();
        RecipePic7 = new javax.swing.JLabel();
        RecipePic6 = new javax.swing.JLabel();
        RecipePic8 = new javax.swing.JLabel();
        jButton1Classic = new javax.swing.JButton();
        jButton2Cheesy = new javax.swing.JButton();
        jButton3Beyond = new javax.swing.JButton();
        jButton4Gourmet = new javax.swing.JButton();
        jButton5Jack = new javax.swing.JButton();
        jButton6Meat = new javax.swing.JButton();
        jButton7Spicy = new javax.swing.JButton();
        jButton8Salmon = new javax.swing.JButton();
        jButton9Turkey = new javax.swing.JButton();
        jCustomButton10 = new javax.swing.JButton();
        jButtonCancelBurger = new javax.swing.JButton();
        jButtonConfirmBurger1 = new javax.swing.JButton();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        CreateVendingMachinePanel = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        RegRadioButton = new javax.swing.JRadioButton();
        VMNameText = new javax.swing.JTextField();
        CreateVMTitle1 = new javax.swing.JLabel();
        SpeRadioButton = new javax.swing.JRadioButton();
        ConfirmVMButton = new javax.swing.JButton();
        jTabbedPaneRestock = new javax.swing.JTabbedPane();
        jRestockItemsPanel = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jRadioSesame = new javax.swing.JRadioButton();
        jRadioBrioche = new javax.swing.JRadioButton();
        jRadioRye = new javax.swing.JRadioButton();
        jRadioPotato = new javax.swing.JRadioButton();
        jRadioWholewheat = new javax.swing.JRadioButton();
        jRadioGrilled = new javax.swing.JRadioButton();
        jRadioBeyond = new javax.swing.JRadioButton();
        jRadioBronze = new javax.swing.JRadioButton();
        jRadioWeiner = new javax.swing.JRadioButton();
        jRadioCanadian = new javax.swing.JRadioButton();
        jRadioOnion = new javax.swing.JRadioButton();
        jRadioMozzarella = new javax.swing.JRadioButton();
        jRadioTrappist = new javax.swing.JRadioButton();
        jRadioMelted = new javax.swing.JRadioButton();
        jRadioIceberg = new javax.swing.JRadioButton();
        jRadioBeefsteak = new javax.swing.JRadioButton();
        jRadioAmerican = new javax.swing.JRadioButton();
        jRadioBlue = new javax.swing.JRadioButton();
        jRadioWhite = new javax.swing.JRadioButton();
        jRadioJackBf = new javax.swing.JRadioButton();
        jRadioWagyu = new javax.swing.JRadioButton();
        jRadioCheesed = new javax.swing.JRadioButton();
        jRadioTapa = new javax.swing.JRadioButton();
        jRadioAngus = new javax.swing.JRadioButton();
        jRadioJackB = new javax.swing.JRadioButton();
        jRadioBarbecue = new javax.swing.JRadioButton();
        jRadioJackS = new javax.swing.JRadioButton();
        jRadioCaviar = new javax.swing.JRadioButton();
        jRadioHot = new javax.swing.JRadioButton();
        jRadioDill = new javax.swing.JRadioButton();
        jPanel10 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jButtonConfirmRestock = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jRadioSesame1 = new javax.swing.JRadioButton();
        jRadioBrioche1 = new javax.swing.JRadioButton();
        jRadioRye1 = new javax.swing.JRadioButton();
        jRadioPotato1 = new javax.swing.JRadioButton();
        jRadioWholewheat1 = new javax.swing.JRadioButton();
        jRadioGrilled1 = new javax.swing.JRadioButton();
        jRadioBeyond1 = new javax.swing.JRadioButton();
        jRadioBronze1 = new javax.swing.JRadioButton();
        jRadioWeiner1 = new javax.swing.JRadioButton();
        jRadioCanadian1 = new javax.swing.JRadioButton();
        jRadioOnion1 = new javax.swing.JRadioButton();
        jRadioMozzarella1 = new javax.swing.JRadioButton();
        jRadioTrappist1 = new javax.swing.JRadioButton();
        jRadioMelted1 = new javax.swing.JRadioButton();
        jRadioIceberg1 = new javax.swing.JRadioButton();
        jRadioBeefsteak1 = new javax.swing.JRadioButton();
        jRadioAmerican1 = new javax.swing.JRadioButton();
        jRadioBlue1 = new javax.swing.JRadioButton();
        jRadioWhite1 = new javax.swing.JRadioButton();
        jRadioJackBf1 = new javax.swing.JRadioButton();
        jRadioWagyu1 = new javax.swing.JRadioButton();
        jRadioCheesed1 = new javax.swing.JRadioButton();
        jRadioTapa1 = new javax.swing.JRadioButton();
        jRadioAngus1 = new javax.swing.JRadioButton();
        jRadioJackB1 = new javax.swing.JRadioButton();
        jRadioBarbecue1 = new javax.swing.JRadioButton();
        jRadioJackS1 = new javax.swing.JRadioButton();
        jRadioCaviar1 = new javax.swing.JRadioButton();
        jRadioHot1 = new javax.swing.JRadioButton();
        jRadioDill1 = new javax.swing.JRadioButton();
        jPanel11 = new javax.swing.JPanel();
        jINewPriceTextField = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButtonConfirmReprice = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButtonClear = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton0 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jDisplayCashBox = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jBillLabel8 = new javax.swing.JLabel();
        jBillLabel2 = new javax.swing.JLabel();
        jBillLabel6 = new javax.swing.JLabel();
        jBillLabel1 = new javax.swing.JLabel();
        TwentyPesoSpinner = new javax.swing.JSpinner();
        jButtonDeposit = new javax.swing.JButton();
        FiftyPesoSpinner = new javax.swing.JSpinner();
        jBillLabel10 = new javax.swing.JLabel();
        jBillLabel7 = new javax.swing.JLabel();
        jBill1 = new javax.swing.JLabel();
        jBill100 = new javax.swing.JLabel();
        jBill20 = new javax.swing.JLabel();
        jButtonWithdraw = new javax.swing.JButton();
        ThousandPesoSpinner = new javax.swing.JSpinner();
        jBill10 = new javax.swing.JLabel();
        jBillLabel5 = new javax.swing.JLabel();
        jBill5 = new javax.swing.JLabel();
        FiveHundredPesoSpinner = new javax.swing.JSpinner();
        OneHundredPesoSpinner = new javax.swing.JSpinner();
        jBill50 = new javax.swing.JLabel();
        jBill500 = new javax.swing.JLabel();
        jBill1000 = new javax.swing.JLabel();
        jBillLabel9 = new javax.swing.JLabel();
        OnePesoSpinner = new javax.swing.JSpinner();
        TenPesoSpinner = new javax.swing.JSpinner();
        FivePesoSpinner = new javax.swing.JSpinner();
        jButtonWithdrawAll = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jButtonPrintTransaction = new javax.swing.JButton();
        jButtonPrintRestock = new javax.swing.JButton();
        jTextAreaPane1 = new javax.swing.JScrollPane();
        jTextAreaReceipt = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();

        jToggleButton1.setText("jToggleButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 204, 204));

        TestVendingMachinePanel.setBackground(new java.awt.Color(204, 204, 204));
        TestVendingMachinePanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTextAreaConsole.setBackground(new java.awt.Color(0, 0, 0));
        jTextAreaConsole.setColumns(20);
        jTextAreaConsole.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        jTextAreaConsole.setForeground(new java.awt.Color(255, 255, 255));
        jTextAreaConsole.setLineWrap(true);
        jTextAreaConsole.setRows(5);
        jTextAreaConsole.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(102, 102, 102), new java.awt.Color(102, 102, 102), new java.awt.Color(102, 102, 102), new java.awt.Color(102, 102, 102)));
        jTextAreaPane.setViewportView(jTextAreaConsole);

        jVMName.setText("The Classic Vending Machine");
        jVMName.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jVMName.setOpaque(true);

        jRegOrSpeLabel.setText("Regular Vending Machine");
        jRegOrSpeLabel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jRegOrSpeLabel.setOpaque(true);

        jButtonBill1.setText("1");
        jButtonBill1.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), null));
        jButtonBill1.setPreferredSize(new java.awt.Dimension(37, 20));
        jButtonBill1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBill1ActionPerformed(evt);
            }
        });

        jButtonBill5.setText("5");
        jButtonBill5.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), null));
        jButtonBill5.setPreferredSize(new java.awt.Dimension(37, 20));
        jButtonBill5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBill5ActionPerformed(evt);
            }
        });

        jButtonBill10.setText("10");
        jButtonBill10.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), null));
        jButtonBill10.setPreferredSize(new java.awt.Dimension(37, 20));
        jButtonBill10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBill10ActionPerformed(evt);
            }
        });

        jButtonBill20.setText("20");
        jButtonBill20.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), null));
        jButtonBill20.setPreferredSize(new java.awt.Dimension(37, 20));
        jButtonBill20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBill20ActionPerformed(evt);
            }
        });

        jButtonBill50.setText("50");
        jButtonBill50.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), null));
        jButtonBill50.setPreferredSize(new java.awt.Dimension(37, 20));
        jButtonBill50.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBill50ActionPerformed(evt);
            }
        });

        jButtonBill100.setText("100");
        jButtonBill100.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), null));
        jButtonBill100.setPreferredSize(new java.awt.Dimension(37, 20));
        jButtonBill100.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBill100ActionPerformed(evt);
            }
        });

        jButtonBill500.setText("500");
        jButtonBill500.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), null));
        jButtonBill500.setPreferredSize(new java.awt.Dimension(37, 20));
        jButtonBill500.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBill500ActionPerformed(evt);
            }
        });

        jButtonBill1000.setText("1000");
        jButtonBill1000.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), null));
        jButtonBill1000.setPreferredSize(new java.awt.Dimension(37, 20));
        jButtonBill1000.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBill1000ActionPerformed(evt);
            }
        });

        jTabbedPane1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        ItemRack.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        ItemRack.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        ItemRack.setViewportBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ItemRack.setHorizontalScrollBar(null);

        ItemPanel.setBackground(new java.awt.Color(102, 102, 102));

        jPanel9.setBackground(new java.awt.Color(102, 102, 102));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 56, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jButtonCancelItem.setBackground(new java.awt.Color(153, 0, 0));
        jButtonCancelItem.setForeground(new java.awt.Color(255, 255, 255));
        jButtonCancelItem.setText("Cancel Item");
        jButtonCancelItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelItemActionPerformed(evt);
            }
        });

        jButtonConfirmItem.setBackground(new java.awt.Color(51, 51, 51));
        jButtonConfirmItem.setForeground(new java.awt.Color(255, 255, 255));
        jButtonConfirmItem.setText("Buy Item/s");
        jButtonConfirmItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConfirmItemActionPerformed(evt);
            }
        });

        jPanel12.setBackground(new java.awt.Color(204, 204, 204));
        jPanel12.setOpaque(false);
        jPanel12.setPreferredSize(new java.awt.Dimension(976, 850));

        BriocheSpinner.setOpaque(true);

        ItemPic1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        javax.swing.ImageIcon originalIcon1 = new javax.swing.ImageIcon(getClass().getResource("/imagepackage/1 Brioche Bread.png"));       
        Image scaledImage1 = originalIcon1.getImage().getScaledInstance(75, 75, Image.SCALE_SMOOTH);
        javax.swing.ImageIcon scaledIcon1 = new javax.swing.ImageIcon(scaledImage1);
        ItemPic1.setIcon(scaledIcon1);
        ItemPic1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ItemPic1.setFocusable(false);
	ItemPic1.setOpaque(true);

	ItemPic2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        javax.swing.ImageIcon originalIcon2 = new javax.swing.ImageIcon(getClass().getResource("/imagepackage/2 Sesame Bread.png"));       
        Image scaledImage2 = originalIcon2.getImage().getScaledInstance(75, 75, Image.SCALE_SMOOTH);
        javax.swing.ImageIcon scaledIcon2 = new javax.swing.ImageIcon(scaledImage2);
        ItemPic2.setIcon(scaledIcon2);
        ItemPic2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ItemPic2.setFocusable(false);
	ItemPic2.setOpaque(true);

	ItemPic3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        javax.swing.ImageIcon originalIcon3 = new javax.swing.ImageIcon(getClass().getResource("/imagepackage/3 Rye Bread.png"));
        Image scaledImage3 = originalIcon3.getImage().getScaledInstance(75, 75, Image.SCALE_SMOOTH);
        javax.swing.ImageIcon scaledIcon3 = new javax.swing.ImageIcon(scaledImage3);
        ItemPic3.setIcon(scaledIcon3);
        ItemPic3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ItemPic3.setFocusable(false);
	ItemPic3.setOpaque(true);

	ItemPic4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        javax.swing.ImageIcon originalIcon4 = new javax.swing.ImageIcon(getClass().getResource("/imagepackage/4 Wholewheat Bread.png"));
        Image scaledImage4 = originalIcon4.getImage().getScaledInstance(75, 75, Image.SCALE_SMOOTH);
        javax.swing.ImageIcon scaledIcon4 = new javax.swing.ImageIcon(scaledImage4);
        ItemPic4.setIcon(scaledIcon4);
        ItemPic4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ItemPic4.setFocusable(false);
	ItemPic4.setOpaque(true);

	ItemPic5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        javax.swing.ImageIcon originalIcon5 = new javax.swing.ImageIcon(getClass().getResource("/imagepackage/5 Potato Bread.png"));
        Image scaledImage5 = originalIcon5.getImage().getScaledInstance(75, 75, Image.SCALE_SMOOTH);
        javax.swing.ImageIcon scaledIcon5 = new javax.swing.ImageIcon(scaledImage5);
        ItemPic5.setIcon(scaledIcon5);
        ItemPic5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ItemPic5.setFocusable(false);
	ItemPic5.setOpaque(true);

	ItemPic6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        javax.swing.ImageIcon originalIcon6 = new javax.swing.ImageIcon(getClass().getResource("/imagepackage/6 Jack Bread.png"));
        Image scaledImage6 = originalIcon6.getImage().getScaledInstance(75, 75, Image.SCALE_SMOOTH);
        javax.swing.ImageIcon scaledIcon6 = new javax.swing.ImageIcon(scaledImage6);
        ItemPic6.setIcon(scaledIcon6);
        ItemPic6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ItemPic6.setFocusable(false);
	ItemPic6.setOpaque(true);

	ItemPic7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        javax.swing.ImageIcon originalIcon7 = new javax.swing.ImageIcon(getClass().getResource("/imagepackage/7 Angus Beef.png"));
        Image scaledImage7 = originalIcon7.getImage().getScaledInstance(75, 75, Image.SCALE_SMOOTH);
        javax.swing.ImageIcon scaledIcon7 = new javax.swing.ImageIcon(scaledImage7);
        ItemPic7.setIcon(scaledIcon7);
        ItemPic7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ItemPic7.setFocusable(false);
	ItemPic7.setOpaque(true);

	ItemPic8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        javax.swing.ImageIcon originalIcon8 = new javax.swing.ImageIcon(getClass().getResource("/imagepackage/8 Wagyu Beef.png"));
        Image scaledImage8 = originalIcon8.getImage().getScaledInstance(75, 75, Image.SCALE_SMOOTH);
        javax.swing.ImageIcon scaledIcon8 = new javax.swing.ImageIcon(scaledImage8);
        ItemPic8.setIcon(scaledIcon8);
        ItemPic8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ItemPic8.setFocusable(false);
	ItemPic8.setOpaque(true);

	ItemPic9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        javax.swing.ImageIcon originalIcon9 = new javax.swing.ImageIcon(getClass().getResource("/imagepackage/9 Tapa Beef.png"));
        Image scaledImage9 = originalIcon9.getImage().getScaledInstance(75, 75, Image.SCALE_SMOOTH);
        javax.swing.ImageIcon scaledIcon9 = new javax.swing.ImageIcon(scaledImage9);
        ItemPic9.setIcon(scaledIcon9);
        ItemPic9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ItemPic9.setFocusable(false);
	ItemPic9.setOpaque(true);

	ItemPic10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        javax.swing.ImageIcon originalIcon10 = new javax.swing.ImageIcon(getClass().getResource("/imagepackage/10 Cheesed Beef.png"));
        Image scaledImage10 = originalIcon10.getImage().getScaledInstance(75, 75, Image.SCALE_SMOOTH);
        javax.swing.ImageIcon scaledIcon10 = new javax.swing.ImageIcon(scaledImage10);
        ItemPic10.setIcon(scaledIcon10);
        ItemPic10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ItemPic10.setFocusable(false);
	ItemPic10.setOpaque(true);

	ItemPic11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        javax.swing.ImageIcon originalIcon11 = new javax.swing.ImageIcon(getClass().getResource("/imagepackage/11 Canadian Bacon.png"));
        Image scaledImage11 = originalIcon11.getImage().getScaledInstance(75, 75, Image.SCALE_SMOOTH);
        javax.swing.ImageIcon scaledIcon11 = new javax.swing.ImageIcon(scaledImage11);
        ItemPic11.setIcon(scaledIcon11);
        ItemPic11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ItemPic11.setFocusable(false);
	ItemPic11.setOpaque(true);

	ItemPic12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        javax.swing.ImageIcon originalIcon12 = new javax.swing.ImageIcon(getClass().getResource("/imagepackage/12 Weiner Schnitzel.png"));
        Image scaledImage12 = originalIcon12.getImage().getScaledInstance(75, 75, Image.SCALE_SMOOTH);
        javax.swing.ImageIcon scaledIcon12 = new javax.swing.ImageIcon(scaledImage12);
        ItemPic12.setIcon(scaledIcon12);
        ItemPic12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ItemPic12.setFocusable(false);
	ItemPic12.setOpaque(true);

	ItemPic13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        javax.swing.ImageIcon originalIcon13 = new javax.swing.ImageIcon(getClass().getResource("/imagepackage/13 Grilled Salmon_.png"));
        Image scaledImage13 = originalIcon13.getImage().getScaledInstance(75, 75, Image.SCALE_SMOOTH);
        javax.swing.ImageIcon scaledIcon13 = new javax.swing.ImageIcon(scaledImage13);
        ItemPic13.setIcon(scaledIcon13);
        ItemPic13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ItemPic13.setFocusable(false);
	ItemPic13.setOpaque(true);

	ItemPic14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        javax.swing.ImageIcon originalIcon14 = new javax.swing.ImageIcon(getClass().getResource("/imagepackage/14 Bronze Turkey.png"));
        Image scaledImage14 = originalIcon14.getImage().getScaledInstance(75, 75, Image.SCALE_SMOOTH);
        javax.swing.ImageIcon scaledIcon14 = new javax.swing.ImageIcon(scaledImage14);
        ItemPic14.setIcon(scaledIcon14);
        ItemPic14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ItemPic14.setFocusable(false);
	ItemPic14.setOpaque(true);

	ItemPic15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        javax.swing.ImageIcon originalIcon15 = new javax.swing.ImageIcon(getClass().getResource("/imagepackage/15 Beyond Beef.png"));
        Image scaledImage15 = originalIcon15.getImage().getScaledInstance(75, 75, Image.SCALE_SMOOTH);
        javax.swing.ImageIcon scaledIcon15 = new javax.swing.ImageIcon(scaledImage15);
        ItemPic15.setIcon(scaledIcon15);
        ItemPic15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ItemPic15.setFocusable(false);
	ItemPic15.setOpaque(true);

	ItemPic16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        javax.swing.ImageIcon originalIcon16 = new javax.swing.ImageIcon(getClass().getResource("/imagepackage/16 Jack Beef.png"));
        Image scaledImage16 = originalIcon16.getImage().getScaledInstance(75, 75, Image.SCALE_SMOOTH);
        javax.swing.ImageIcon scaledIcon16 = new javax.swing.ImageIcon(scaledImage16);
        ItemPic16.setIcon(scaledIcon16);
        ItemPic16.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ItemPic16.setFocusable(false);
	ItemPic16.setOpaque(true);

	ItemPic17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        javax.swing.ImageIcon originalIcon17 = new javax.swing.ImageIcon(getClass().getResource("/imagepackage/17 White Onions.png"));
        Image scaledImage17 = originalIcon17.getImage().getScaledInstance(75, 75, Image.SCALE_SMOOTH);
        javax.swing.ImageIcon scaledIcon17 = new javax.swing.ImageIcon(scaledImage17);
        ItemPic17.setIcon(scaledIcon17);
        ItemPic17.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ItemPic17.setFocusable(false);
	ItemPic17.setOpaque(true);

	ItemPic18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        javax.swing.ImageIcon originalIcon18 = new javax.swing.ImageIcon(getClass().getResource("/imagepackage/18 Onion Rings.png"));
        Image scaledImage18 = originalIcon18.getImage().getScaledInstance(75, 75, Image.SCALE_SMOOTH);
        javax.swing.ImageIcon scaledIcon18 = new javax.swing.ImageIcon(scaledImage18);
        ItemPic18.setIcon(scaledIcon18);
        ItemPic18.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ItemPic18.setFocusable(false);
	ItemPic18.setOpaque(true);

	ItemPic19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        javax.swing.ImageIcon originalIcon19 = new javax.swing.ImageIcon(getClass().getResource("/imagepackage/19 Trappist Cheese.png"));
        Image scaledImage19 = originalIcon19.getImage().getScaledInstance(75, 75, Image.SCALE_SMOOTH);
        javax.swing.ImageIcon scaledIcon19 = new javax.swing.ImageIcon(scaledImage19);
        ItemPic19.setIcon(scaledIcon19);
        ItemPic19.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ItemPic19.setFocusable(false);
	ItemPic19.setOpaque(true);

	ItemPic20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        javax.swing.ImageIcon originalIcon20 = new javax.swing.ImageIcon(getClass().getResource("/imagepackage/20 Mozzarella Cheese.png"));
        Image scaledImage20 = originalIcon20.getImage().getScaledInstance(75, 75, Image.SCALE_SMOOTH);
        javax.swing.ImageIcon scaledIcon20 = new javax.swing.ImageIcon(scaledImage20);
        ItemPic20.setIcon(scaledIcon20);
        ItemPic20.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ItemPic20.setFocusable(false);
	ItemPic20.setOpaque(true);

	ItemPic21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        javax.swing.ImageIcon originalIcon21 = new javax.swing.ImageIcon(getClass().getResource("/imagepackage/21 Blue Cheese.png"));
        Image scaledImage21 = originalIcon21.getImage().getScaledInstance(75, 75, Image.SCALE_SMOOTH);
        javax.swing.ImageIcon scaledIcon21 = new javax.swing.ImageIcon(scaledImage21);
        ItemPic21.setIcon(scaledIcon21);
        ItemPic21.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ItemPic21.setFocusable(false);
	ItemPic21.setOpaque(true);

	ItemPic22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        javax.swing.ImageIcon originalIcon22 = new javax.swing.ImageIcon(getClass().getResource("/imagepackage/22 American Cheese.png"));
        Image scaledImage22 = originalIcon22.getImage().getScaledInstance(75, 75, Image.SCALE_SMOOTH);
        javax.swing.ImageIcon scaledIcon22 = new javax.swing.ImageIcon(scaledImage22);
        ItemPic22.setIcon(scaledIcon22);
        ItemPic22.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ItemPic22.setFocusable(false);
	ItemPic22.setOpaque(true);

	ItemPic23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        javax.swing.ImageIcon originalIcon23 = new javax.swing.ImageIcon(getClass().getResource("/imagepackage/23 Melted Butter.png"));
        Image scaledImage23 = originalIcon23.getImage().getScaledInstance(75, 75, Image.SCALE_SMOOTH);
        javax.swing.ImageIcon scaledIcon23 = new javax.swing.ImageIcon(scaledImage23);
        ItemPic23.setIcon(scaledIcon23);
        ItemPic23.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ItemPic23.setFocusable(false);
	ItemPic23.setOpaque(true);

	ItemPic24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        javax.swing.ImageIcon originalIcon24 = new javax.swing.ImageIcon(getClass().getResource("/imagepackage/24 Beefsteak Tomato.png"));
        Image scaledImage24 = originalIcon24.getImage().getScaledInstance(75, 75, Image.SCALE_SMOOTH);
        javax.swing.ImageIcon scaledIcon24 = new javax.swing.ImageIcon(scaledImage24);
        ItemPic24.setIcon(scaledIcon24);
        ItemPic24.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ItemPic24.setFocusable(false);
	ItemPic24.setOpaque(true);

	ItemPic25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        javax.swing.ImageIcon originalIcon25 = new javax.swing.ImageIcon(getClass().getResource("/imagepackage/25 Iceberg Lettuce.png"));
        Image scaledImage25 = originalIcon25.getImage().getScaledInstance(75, 75, Image.SCALE_SMOOTH);
        javax.swing.ImageIcon scaledIcon25 = new javax.swing.ImageIcon(scaledImage25);
        ItemPic25.setIcon(scaledIcon25);
        ItemPic25.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ItemPic25.setFocusable(false);
	ItemPic25.setOpaque(true);

	ItemPic26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        javax.swing.ImageIcon originalIcon26 = new javax.swing.ImageIcon(getClass().getResource("/imagepackage/26 Dill Pickles.png"));
        Image scaledImage26 = originalIcon26.getImage().getScaledInstance(75, 75, Image.SCALE_SMOOTH);
        javax.swing.ImageIcon scaledIcon26 = new javax.swing.ImageIcon(scaledImage26);
        ItemPic26.setIcon(scaledIcon26);
        ItemPic26.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ItemPic26.setFocusable(false);
	ItemPic26.setOpaque(true);

	ItemPic27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        javax.swing.ImageIcon originalIcon27 = new javax.swing.ImageIcon(getClass().getResource("/imagepackage/27 Hot Sauce.png"));
        Image scaledImage27 = originalIcon27.getImage().getScaledInstance(75, 75, Image.SCALE_SMOOTH);
        javax.swing.ImageIcon scaledIcon27 = new javax.swing.ImageIcon(scaledImage27);
        ItemPic27.setIcon(scaledIcon27);
        ItemPic27.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ItemPic27.setFocusable(false);
	ItemPic27.setOpaque(true);

	ItemPic28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        javax.swing.ImageIcon originalIcon28 = new javax.swing.ImageIcon(getClass().getResource("/imagepackage/28 Barbecue Sauce.png"));
        Image scaledImage28 = originalIcon28.getImage().getScaledInstance(75, 75, Image.SCALE_SMOOTH);
        javax.swing.ImageIcon scaledIcon28 = new javax.swing.ImageIcon(scaledImage28);
        ItemPic28.setIcon(scaledIcon28);
        ItemPic28.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ItemPic28.setFocusable(false);
	ItemPic28.setOpaque(true);

	ItemPic29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        javax.swing.ImageIcon originalIcon29 = new javax.swing.ImageIcon(getClass().getResource("/imagepackage/29 Caviar Sauce.png"));
        Image scaledImage29 = originalIcon29.getImage().getScaledInstance(75, 75, Image.SCALE_SMOOTH);
        javax.swing.ImageIcon scaledIcon29 = new javax.swing.ImageIcon(scaledImage29);
        ItemPic29.setIcon(scaledIcon29);
        ItemPic29.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ItemPic29.setFocusable(false);
	    ItemPic29.setOpaque(true);

	    ItemPic30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        javax.swing.ImageIcon originalIcon30 = new javax.swing.ImageIcon(getClass().getResource("/imagepackage/30 Jack Sauce.png"));
        Image scaledImage30 = originalIcon30.getImage().getScaledInstance(75, 75, Image.SCALE_SMOOTH);
        javax.swing.ImageIcon scaledIcon30 = new javax.swing.ImageIcon(scaledImage30);
        ItemPic30.setIcon(scaledIcon30);
        ItemPic30.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ItemPic30.setFocusable(false);
	    ItemPic30.setOpaque(true);

	    RecipePic1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        javax.swing.ImageIcon originalIcon31 = new javax.swing.ImageIcon(getClass().getResource("/imagepackage/burger/1 Classic Burger.png"));
        Image scaledImage31 = originalIcon31.getImage().getScaledInstance(75, 75, Image.SCALE_SMOOTH);
        javax.swing.ImageIcon scaledIcon31 = new javax.swing.ImageIcon(scaledImage31);
        RecipePic1.setIcon(scaledIcon31);
        RecipePic1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        RecipePic1.setFocusable(false);
	    RecipePic1.setOpaque(true);

	    RecipePic2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        javax.swing.ImageIcon originalIcon32 = new javax.swing.ImageIcon(getClass().getResource("/imagepackage/burger/2 Cheesy Cheeseburger.png"));
        Image scaledImage32 = originalIcon32.getImage().getScaledInstance(75, 75, Image.SCALE_SMOOTH);
        javax.swing.ImageIcon scaledImage32i = new javax.swing.ImageIcon(scaledImage32);
        RecipePic2.setIcon(scaledImage32i);
        RecipePic2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        RecipePic2.setFocusable(false);
	    RecipePic2.setOpaque(true);

	RecipePic3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
	javax.swing.ImageIcon originalIcon33 = new javax.swing.ImageIcon(getClass().getResource("/imagepackage/burger/3 Beyond Burger.png"));
	Image scaledImage33 = originalIcon33.getImage().getScaledInstance(75, 75, Image.SCALE_SMOOTH);
	javax.swing.ImageIcon scaledIcon33 = new javax.swing.ImageIcon(scaledImage33);
	RecipePic3.setIcon(scaledIcon33);
	RecipePic3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
	RecipePic3.setFocusable(false);
	RecipePic3.setOpaque(true);

	RecipePic4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
	javax.swing.ImageIcon originalIcon34 = new javax.swing.ImageIcon(getClass().getResource("/imagepackage/burger/4 Gourmet Burger.png"));
	Image scaledImage34 = originalIcon34.getImage().getScaledInstance(75, 75, Image.SCALE_SMOOTH);
	javax.swing.ImageIcon scaledIcon34 = new javax.swing.ImageIcon(scaledImage34);
	RecipePic4.setIcon(scaledIcon34);
	RecipePic4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
	RecipePic4.setFocusable(false);
	RecipePic4.setOpaque(true);

	RecipePic5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
	javax.swing.ImageIcon originalIcon35 = new javax.swing.ImageIcon(getClass().getResource("/imagepackage/burger/5 Jack Burger.png"));
	Image scaledImage35 = originalIcon35.getImage().getScaledInstance(75, 75, Image.SCALE_SMOOTH);
	javax.swing.ImageIcon scaledIcon35 = new javax.swing.ImageIcon(scaledImage35);
	RecipePic5.setIcon(scaledIcon35);
	RecipePic5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
	RecipePic5.setFocusable(false);
	RecipePic5.setOpaque(true);

    RecipePic6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    javax.swing.ImageIcon originalIcon36 = new javax.swing.ImageIcon(getClass().getResource("/imagepackage/burger/6 Meat Overload Burger.png"));
    Image scaledImage36 = originalIcon36.getImage().getScaledInstance(75, 75, Image.SCALE_SMOOTH);
    javax.swing.ImageIcon scaledIcon36 = new javax.swing.ImageIcon(scaledImage36);
    RecipePic6.setIcon(scaledIcon36);
    RecipePic6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    RecipePic6.setFocusable(false);
    RecipePic6.setOpaque(true);

    RecipePic7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    javax.swing.ImageIcon originalIcon37 = new javax.swing.ImageIcon(getClass().getResource("/imagepackage/burger/7 Spicy Tapa Burger.png"));
    Image scaledImage37 = originalIcon37.getImage().getScaledInstance(75, 75, Image.SCALE_SMOOTH);
    javax.swing.ImageIcon scaledIcon37 = new javax.swing.ImageIcon(scaledImage37);
    RecipePic7.setIcon(scaledIcon37);
    RecipePic7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    RecipePic7.setFocusable(false);
    RecipePic7.setOpaque(true);

    RecipePic8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    javax.swing.ImageIcon originalIcon38 = new javax.swing.ImageIcon(getClass().getResource("/imagepackage/burger/8 Salmon Burger.png"));
    Image scaledImage38 = originalIcon38.getImage().getScaledInstance(75, 75, Image.SCALE_SMOOTH);
    javax.swing.ImageIcon scaledIcon38 = new javax.swing.ImageIcon(scaledImage38);
    RecipePic8.setIcon(scaledIcon38);
    RecipePic8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    RecipePic8.setFocusable(false);
    RecipePic8.setOpaque(true);

    RecipePic9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    javax.swing.ImageIcon originalIcon39 = new javax.swing.ImageIcon(getClass().getResource("/imagepackage/burger/9 Turkey Burger.png"));
    Image scaledImage39 = originalIcon39.getImage().getScaledInstance(75, 75, Image.SCALE_SMOOTH);
    javax.swing.ImageIcon scaledIcon39 = new javax.swing.ImageIcon(scaledImage39);
    RecipePic9.setIcon(scaledIcon39);
    RecipePic9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    RecipePic9.setFocusable(false);
    RecipePic9.setOpaque(true);

        ItemStock21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ItemStock21.setText("0");
        ItemStock21.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ItemStock21.setMaximumSize(new java.awt.Dimension(30, 30));
        ItemStock21.setMinimumSize(new java.awt.Dimension(30, 30));
        ItemStock21.setOpaque(true);
        ItemStock21.setPreferredSize(new java.awt.Dimension(30, 20));

        jButton16JackBeef.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        jButton16JackBeef.setText("16-Jack Beef");
        jButton16JackBeef.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton16JackBeef.setOpaque(true);

        ItemPrice6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ItemPrice6.setText("0");
        ItemPrice6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ItemPrice6.setMaximumSize(new java.awt.Dimension(30, 30));
        ItemPrice6.setMinimumSize(new java.awt.Dimension(30, 30));
        ItemPrice6.setOpaque(true);
        ItemPrice6.setPreferredSize(new java.awt.Dimension(30, 20));

        CaviarSpinner.setOpaque(true);

        WagyuSpinner.setOpaque(true);

        jButton28Barbecue.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        jButton28Barbecue.setText("28-Barbecue Sauce");
        jButton28Barbecue.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton28Barbecue.setOpaque(true);

        jButton9Tapa.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        jButton9Tapa.setText("9-Tapa Beef");
        jButton9Tapa.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton9Tapa.setOpaque(true);

        jButton15Beyond.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        jButton15Beyond.setText("15-Beyond Beef");
        jButton15Beyond.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton15Beyond.setOpaque(true);

        ItemStock11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ItemStock11.setText("0");
        ItemStock11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ItemStock11.setMaximumSize(new java.awt.Dimension(30, 30));
        ItemStock11.setMinimumSize(new java.awt.Dimension(30, 30));
        ItemStock11.setOpaque(true);
        ItemStock11.setPreferredSize(new java.awt.Dimension(30, 20));

        ItemStock29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ItemStock29.setText("0");
        ItemStock29.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ItemStock29.setMaximumSize(new java.awt.Dimension(30, 30));
        ItemStock29.setMinimumSize(new java.awt.Dimension(30, 30));
        ItemStock29.setOpaque(true);
        ItemStock29.setPreferredSize(new java.awt.Dimension(30, 20));

        jButton24Beefsteak.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        jButton24Beefsteak.setText("24-Beefsteak Tomato");
        jButton24Beefsteak.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton24Beefsteak.setOpaque(true);

        ItemStock25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ItemStock25.setText("0");
        ItemStock25.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ItemStock25.setMaximumSize(new java.awt.Dimension(30, 30));
        ItemStock25.setMinimumSize(new java.awt.Dimension(30, 30));
        ItemStock25.setOpaque(true);
        ItemStock25.setPreferredSize(new java.awt.Dimension(30, 20));

        ItemStock9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ItemStock9.setText("0");
        ItemStock9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ItemStock9.setMaximumSize(new java.awt.Dimension(30, 30));
        ItemStock9.setMinimumSize(new java.awt.Dimension(30, 30));
        ItemStock9.setOpaque(true);
        ItemStock9.setPreferredSize(new java.awt.Dimension(30, 20));

        ItemStock23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ItemStock23.setText("0");
        ItemStock23.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ItemStock23.setMaximumSize(new java.awt.Dimension(30, 30));
        ItemStock23.setMinimumSize(new java.awt.Dimension(30, 30));
        ItemStock23.setOpaque(true);
        ItemStock23.setPreferredSize(new java.awt.Dimension(30, 20));

        JSauceSpinner.setOpaque(true);

        ItemStock1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ItemStock1.setText("0");
        ItemStock1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ItemStock1.setMaximumSize(new java.awt.Dimension(30, 30));
        ItemStock1.setMinimumSize(new java.awt.Dimension(30, 30));
        ItemStock1.setOpaque(true);
        ItemStock1.setPreferredSize(new java.awt.Dimension(30, 20));

        BeefsteakSpinner.setOpaque(true);

        jButton29Caviar.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        jButton29Caviar.setText("29-Caviar Sauce");
        jButton29Caviar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton29Caviar.setOpaque(true);

        TrappistSpinner.setOpaque(true);

        ItemPrice2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ItemPrice2.setText("0");
        ItemPrice2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ItemPrice2.setMaximumSize(new java.awt.Dimension(30, 30));
        ItemPrice2.setMinimumSize(new java.awt.Dimension(30, 30));
        ItemPrice2.setOpaque(true);
        ItemPrice2.setPreferredSize(new java.awt.Dimension(30, 20));

        jButton22American.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        jButton22American.setText("22-American Cheese");
        jButton22American.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton22American.setOpaque(true);

        jButton3Rye.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        jButton3Rye.setText("3-Rye Bread");
        jButton3Rye.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton3Rye.setOpaque(true);
        jButton3Rye.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3RyeActionPerformed(evt);
            }
        });

        jButton10Cheesed.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        jButton10Cheesed.setText("10-Cheesed Beef");
        jButton10Cheesed.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton10Cheesed.setOpaque(true);

        ItemStock13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ItemStock13.setText("0");
        ItemStock13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ItemStock13.setMaximumSize(new java.awt.Dimension(30, 30));
        ItemStock13.setMinimumSize(new java.awt.Dimension(30, 30));
        ItemStock13.setOpaque(true);
        ItemStock13.setPreferredSize(new java.awt.Dimension(30, 20));

        ItemStock2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ItemStock2.setText("0");
        ItemStock2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ItemStock2.setMaximumSize(new java.awt.Dimension(30, 30));
        ItemStock2.setMinimumSize(new java.awt.Dimension(30, 30));
        ItemStock2.setOpaque(true);
        ItemStock2.setPreferredSize(new java.awt.Dimension(30, 20));

        jButton23Melted.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        jButton23Melted.setText("23-Melted Butter");
        jButton23Melted.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton23Melted.setOpaque(true);

        AmericanSpinner.setOpaque(true);

        JBeefSpinner.setOpaque(true);

        jButton4Wholewheat.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        jButton4Wholewheat.setText("4-Wholewheat Bread");
        jButton4Wholewheat.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton4Wholewheat.setOpaque(true);
        jButton4Wholewheat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4WholewheatActionPerformed(evt);
            }
        });

        jButton27Hot.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        jButton27Hot.setText("27-Hot Sauce");
        jButton27Hot.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton27Hot.setOpaque(true);

        jButton20Mozzarella.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        jButton20Mozzarella.setText("20-Mozzarella Cheese");
        jButton20Mozzarella.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton20Mozzarella.setOpaque(true);

        ItemStock18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ItemStock18.setText("0");
        ItemStock18.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ItemStock18.setMaximumSize(new java.awt.Dimension(30, 30));
        ItemStock18.setMinimumSize(new java.awt.Dimension(30, 30));
        ItemStock18.setOpaque(true);
        ItemStock18.setPreferredSize(new java.awt.Dimension(30, 20));

        jButton5Potato.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        jButton5Potato.setText("5-Potato Bread");
        jButton5Potato.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton5Potato.setOpaque(true);
        jButton5Potato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5PotatoActionPerformed(evt);
            }
        });

        WeinerSpinner.setOpaque(true);

        CheesedSpinner.setOpaque(true);

        jButton6Jack.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        jButton6Jack.setText("6-Jack Bread");
        jButton6Jack.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton6Jack.setOpaque(true);

        jButton1Brioche.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        jButton1Brioche.setText("1-Brioche Bread");
        jButton1Brioche.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1Brioche.setOpaque(true);
        jButton1Brioche.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1BriocheActionPerformed(evt);
            }
        });

        TapaSpinner.setOpaque(true);

        ItemStock12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ItemStock12.setText("0");
        ItemStock12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ItemStock12.setMaximumSize(new java.awt.Dimension(30, 30));
        ItemStock12.setMinimumSize(new java.awt.Dimension(30, 30));
        ItemStock12.setOpaque(true);
        ItemStock12.setPreferredSize(new java.awt.Dimension(30, 20));

        jButton14Bronze.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        jButton14Bronze.setText("14-Bronze Turkey");
        jButton14Bronze.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton14Bronze.setOpaque(true);

        CanadianSpinner.setOpaque(true);

        ItemStock24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ItemStock24.setText("0");
        ItemStock24.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ItemStock24.setMaximumSize(new java.awt.Dimension(30, 30));
        ItemStock24.setMinimumSize(new java.awt.Dimension(30, 30));
        ItemStock24.setOpaque(true);
        ItemStock24.setPreferredSize(new java.awt.Dimension(30, 20));

        ItemPrice4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ItemPrice4.setText("0");
        ItemPrice4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ItemPrice4.setMaximumSize(new java.awt.Dimension(30, 30));
        ItemPrice4.setMinimumSize(new java.awt.Dimension(30, 30));
        ItemPrice4.setOpaque(true);
        ItemPrice4.setPreferredSize(new java.awt.Dimension(30, 20));

        ItemPrice5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ItemPrice5.setText("0");
        ItemPrice5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ItemPrice5.setMaximumSize(new java.awt.Dimension(30, 30));
        ItemPrice5.setMinimumSize(new java.awt.Dimension(30, 30));
        ItemPrice5.setOpaque(true);
        ItemPrice5.setPreferredSize(new java.awt.Dimension(30, 20));

        DillSpinner.setOpaque(true);

        BeyondSpinner.setOpaque(true);

        jButton19Trappist.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        jButton19Trappist.setText("19-Trappist Cheese");
        jButton19Trappist.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton19Trappist.setOpaque(true);

        ItemStock7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ItemStock7.setText("0");
        ItemStock7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ItemStock7.setMaximumSize(new java.awt.Dimension(30, 30));
        ItemStock7.setMinimumSize(new java.awt.Dimension(30, 30));
        ItemStock7.setOpaque(true);
        ItemStock7.setPreferredSize(new java.awt.Dimension(30, 20));

        JBreadSpinner.setOpaque(true);

        IcebergSpinner.setOpaque(true);

        jButton17White.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        jButton17White.setText("17-White Onions");
        jButton17White.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton17White.setOpaque(true);

        jButton8Wagyu.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        jButton8Wagyu.setText("8-Wagyu Beef");
        jButton8Wagyu.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton8Wagyu.setOpaque(true);

        WholewheatSpinner.setOpaque(true);

        ItemStock17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ItemStock17.setText("0");
        ItemStock17.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ItemStock17.setMaximumSize(new java.awt.Dimension(30, 30));
        ItemStock17.setMinimumSize(new java.awt.Dimension(30, 30));
        ItemStock17.setOpaque(true);
        ItemStock17.setPreferredSize(new java.awt.Dimension(30, 20));

        ItemStock19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ItemStock19.setText("0");
        ItemStock19.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ItemStock19.setMaximumSize(new java.awt.Dimension(30, 30));
        ItemStock19.setMinimumSize(new java.awt.Dimension(30, 30));
        ItemStock19.setOpaque(true);
        ItemStock19.setPreferredSize(new java.awt.Dimension(30, 20));

        AngusSpinner.setOpaque(true);

        jButton13Grilled.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        jButton13Grilled.setText("13-Grilled Salmon");
        jButton13Grilled.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton13Grilled.setOpaque(true);

        jButton11Canadian.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        jButton11Canadian.setText("11-Canadian Bacon");
        jButton11Canadian.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton11Canadian.setOpaque(true);

        MeltedSpinner.setOpaque(true);

        ItemStock10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ItemStock10.setText("0");
        ItemStock10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ItemStock10.setMaximumSize(new java.awt.Dimension(30, 30));
        ItemStock10.setMinimumSize(new java.awt.Dimension(30, 30));
        ItemStock10.setOpaque(true);
        ItemStock10.setPreferredSize(new java.awt.Dimension(30, 20));

        ItemPrice3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ItemPrice3.setText("0");
        ItemPrice3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ItemPrice3.setMaximumSize(new java.awt.Dimension(30, 30));
        ItemPrice3.setMinimumSize(new java.awt.Dimension(30, 30));
        ItemPrice3.setOpaque(true);
        ItemPrice3.setPreferredSize(new java.awt.Dimension(30, 20));

        ItemStock27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ItemStock27.setText("0");
        ItemStock27.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ItemStock27.setMaximumSize(new java.awt.Dimension(30, 30));
        ItemStock27.setMinimumSize(new java.awt.Dimension(30, 30));
        ItemStock27.setOpaque(true);
        ItemStock27.setPreferredSize(new java.awt.Dimension(30, 20));

        RyeSpinner.setOpaque(true);

        ItemStock14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ItemStock14.setText("0");
        ItemStock14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ItemStock14.setMaximumSize(new java.awt.Dimension(30, 30));
        ItemStock14.setMinimumSize(new java.awt.Dimension(30, 30));
        ItemStock14.setOpaque(true);
        ItemStock14.setPreferredSize(new java.awt.Dimension(30, 20));

        ItemStock15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ItemStock15.setText("0");
        ItemStock15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ItemStock15.setMaximumSize(new java.awt.Dimension(30, 30));
        ItemStock15.setMinimumSize(new java.awt.Dimension(30, 30));
        ItemStock15.setOpaque(true);
        ItemStock15.setPreferredSize(new java.awt.Dimension(30, 20));

        ItemStock6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ItemStock6.setText("0");
        ItemStock6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ItemStock6.setMaximumSize(new java.awt.Dimension(30, 30));
        ItemStock6.setMinimumSize(new java.awt.Dimension(30, 30));
        ItemStock6.setOpaque(true);
        ItemStock6.setPreferredSize(new java.awt.Dimension(30, 20));

        ItemStock5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ItemStock5.setText("0");
        ItemStock5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ItemStock5.setMaximumSize(new java.awt.Dimension(30, 30));
        ItemStock5.setMinimumSize(new java.awt.Dimension(30, 30));
        ItemStock5.setOpaque(true);
        ItemStock5.setPreferredSize(new java.awt.Dimension(30, 20));

        jButton12Weiner.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        jButton12Weiner.setText("12-Weiner Schnitzel");
        jButton12Weiner.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton12Weiner.setOpaque(true);

        jButton25Iceberg.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        jButton25Iceberg.setText("25-Iceberg Lettuce");
        jButton25Iceberg.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton25Iceberg.setOpaque(true);

        BronzeSpinner.setOpaque(true);


        PotatoSpinner.setOpaque(true);

        jButton18Onion.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        jButton18Onion.setText("18-Onion Rings");
        jButton18Onion.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton18Onion.setOpaque(true);

        ItemStock3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ItemStock3.setText("0");
        ItemStock3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ItemStock3.setMaximumSize(new java.awt.Dimension(30, 30));
        ItemStock3.setMinimumSize(new java.awt.Dimension(30, 30));
        ItemStock3.setOpaque(true);
        ItemStock3.setPreferredSize(new java.awt.Dimension(30, 20));

        jButton30JackSauce.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        jButton30JackSauce.setText("30-Jack Sauce");
        jButton30JackSauce.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton30JackSauce.setOpaque(true);

        jButton21Blue.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        jButton21Blue.setText("21-Blue Cheese");
        jButton21Blue.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton21Blue.setOpaque(true);

        WhiteSpinner.setOpaque(true);

        BarbecueSpinner.setOpaque(true);

        ItemStock22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ItemStock22.setText("0");
        ItemStock22.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ItemStock22.setMaximumSize(new java.awt.Dimension(30, 30));
        ItemStock22.setMinimumSize(new java.awt.Dimension(30, 30));
        ItemStock22.setOpaque(true);
        ItemStock22.setPreferredSize(new java.awt.Dimension(30, 20));

        jButton26Dill.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        jButton26Dill.setText("26-Dill Pickles");
        jButton26Dill.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton26Dill.setOpaque(true);

        ItemStock16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ItemStock16.setText("0");
        ItemStock16.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ItemStock16.setMaximumSize(new java.awt.Dimension(30, 30));
        ItemStock16.setMinimumSize(new java.awt.Dimension(30, 30));
        ItemStock16.setOpaque(true);
        ItemStock16.setPreferredSize(new java.awt.Dimension(30, 20));

        OnionSpinner.setOpaque(true);

        jButton2Sesame.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        jButton2Sesame.setText("2-Sesame Bread");
        jButton2Sesame.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton2Sesame.setOpaque(true);
        jButton2Sesame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2SesameActionPerformed(evt);
            }
        });

        ItemStock28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ItemStock28.setText("0");
        ItemStock28.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ItemStock28.setMaximumSize(new java.awt.Dimension(30, 30));
        ItemStock28.setMinimumSize(new java.awt.Dimension(30, 30));
        ItemStock28.setOpaque(true);
        ItemStock28.setPreferredSize(new java.awt.Dimension(30, 20));

        jButton7Angus.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        jButton7Angus.setText("7-Angus Beef");
        jButton7Angus.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton7Angus.setOpaque(true);

        HotSpinner.setOpaque(true);

        MozzarellaSpinner.setOpaque(true);

        GrilledSpinner.setOpaque(true);

        ItemStock4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ItemStock4.setText("0");
        ItemStock4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ItemStock4.setMaximumSize(new java.awt.Dimension(30, 30));
        ItemStock4.setMinimumSize(new java.awt.Dimension(30, 30));
        ItemStock4.setOpaque(true);
        ItemStock4.setPreferredSize(new java.awt.Dimension(30, 20));

        ItemStock26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ItemStock26.setText("0");
        ItemStock26.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ItemStock26.setMaximumSize(new java.awt.Dimension(30, 30));
        ItemStock26.setMinimumSize(new java.awt.Dimension(30, 30));
        ItemStock26.setOpaque(true);
        ItemStock26.setPreferredSize(new java.awt.Dimension(30, 20));

        SesameSpinner.setOpaque(true);
        ItemStock20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ItemStock20.setText("0");
        ItemStock20.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ItemStock20.setMaximumSize(new java.awt.Dimension(30, 30));
        ItemStock20.setMinimumSize(new java.awt.Dimension(30, 30));
        ItemStock20.setOpaque(true);
        ItemStock20.setPreferredSize(new java.awt.Dimension(30, 20));

        ItemStock30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ItemStock30.setText("0");
        ItemStock30.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ItemStock30.setMaximumSize(new java.awt.Dimension(30, 30));
        ItemStock30.setMinimumSize(new java.awt.Dimension(30, 30));
        ItemStock30.setOpaque(true);
        ItemStock30.setPreferredSize(new java.awt.Dimension(30, 20));

        ItemStock8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ItemStock8.setText("0");
        ItemStock8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ItemStock8.setMaximumSize(new java.awt.Dimension(30, 30));
        ItemStock8.setMinimumSize(new java.awt.Dimension(30, 30));
        ItemStock8.setOpaque(true);
        ItemStock8.setPreferredSize(new java.awt.Dimension(30, 20));

        BlueSpinner.setOpaque(true);

        ItemPrice1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ItemPrice1.setText("0");
        ItemPrice1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ItemPrice1.setMaximumSize(new java.awt.Dimension(30, 30));
        ItemPrice1.setMinimumSize(new java.awt.Dimension(30, 30));
        ItemPrice1.setOpaque(true);
        ItemPrice1.setPreferredSize(new java.awt.Dimension(30, 20));

        ItemPrice7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ItemPrice7.setText("0");
        ItemPrice7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ItemPrice7.setMaximumSize(new java.awt.Dimension(30, 30));
        ItemPrice7.setMinimumSize(new java.awt.Dimension(30, 30));
        ItemPrice7.setOpaque(true);
        ItemPrice7.setPreferredSize(new java.awt.Dimension(30, 20));

        ItemPrice8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ItemPrice8.setText("0");
        ItemPrice8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ItemPrice8.setMaximumSize(new java.awt.Dimension(30, 30));
        ItemPrice8.setMinimumSize(new java.awt.Dimension(30, 30));
        ItemPrice8.setOpaque(true);
        ItemPrice8.setPreferredSize(new java.awt.Dimension(30, 20));

        ItemPrice9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ItemPrice9.setText("0");
        ItemPrice9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ItemPrice9.setMaximumSize(new java.awt.Dimension(30, 30));
        ItemPrice9.setMinimumSize(new java.awt.Dimension(30, 30));
        ItemPrice9.setOpaque(true);
        ItemPrice9.setPreferredSize(new java.awt.Dimension(30, 20));

        ItemPrice10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ItemPrice10.setText("0");
        ItemPrice10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ItemPrice10.setMaximumSize(new java.awt.Dimension(30, 30));
        ItemPrice10.setMinimumSize(new java.awt.Dimension(30, 30));
        ItemPrice10.setOpaque(true);
        ItemPrice10.setPreferredSize(new java.awt.Dimension(30, 20));

        ItemPrice11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ItemPrice11.setText("0");
        ItemPrice11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ItemPrice11.setMaximumSize(new java.awt.Dimension(30, 30));
        ItemPrice11.setMinimumSize(new java.awt.Dimension(30, 30));
        ItemPrice11.setOpaque(true);
        ItemPrice11.setPreferredSize(new java.awt.Dimension(30, 20));

        ItemPrice12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ItemPrice12.setText("0");
        ItemPrice12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ItemPrice12.setMaximumSize(new java.awt.Dimension(30, 30));
        ItemPrice12.setMinimumSize(new java.awt.Dimension(30, 30));
        ItemPrice12.setOpaque(true);
        ItemPrice12.setPreferredSize(new java.awt.Dimension(30, 20));

        ItemPrice13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ItemPrice13.setText("0");
        ItemPrice13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ItemPrice13.setMaximumSize(new java.awt.Dimension(30, 30));
        ItemPrice13.setMinimumSize(new java.awt.Dimension(30, 30));
        ItemPrice13.setOpaque(true);
        ItemPrice13.setPreferredSize(new java.awt.Dimension(30, 20));

        ItemPrice14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ItemPrice14.setText("0");
        ItemPrice14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ItemPrice14.setMaximumSize(new java.awt.Dimension(30, 30));
        ItemPrice14.setMinimumSize(new java.awt.Dimension(30, 30));
        ItemPrice14.setOpaque(true);
        ItemPrice14.setPreferredSize(new java.awt.Dimension(30, 20));

        ItemPrice15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ItemPrice15.setText("0");
        ItemPrice15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ItemPrice15.setMaximumSize(new java.awt.Dimension(30, 30));
        ItemPrice15.setMinimumSize(new java.awt.Dimension(30, 30));
        ItemPrice15.setOpaque(true);
        ItemPrice15.setPreferredSize(new java.awt.Dimension(30, 20));

        ItemPrice16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ItemPrice16.setText("0");
        ItemPrice16.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ItemPrice16.setMaximumSize(new java.awt.Dimension(30, 30));
        ItemPrice16.setMinimumSize(new java.awt.Dimension(30, 30));
        ItemPrice16.setOpaque(true);
        ItemPrice16.setPreferredSize(new java.awt.Dimension(30, 20));

        ItemPrice17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ItemPrice17.setText("0");
        ItemPrice17.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ItemPrice17.setMaximumSize(new java.awt.Dimension(30, 30));
        ItemPrice17.setMinimumSize(new java.awt.Dimension(30, 30));
        ItemPrice17.setOpaque(true);
        ItemPrice17.setPreferredSize(new java.awt.Dimension(30, 20));

        ItemPrice18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ItemPrice18.setText("0");
        ItemPrice18.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ItemPrice18.setMaximumSize(new java.awt.Dimension(30, 30));
        ItemPrice18.setMinimumSize(new java.awt.Dimension(30, 30));
        ItemPrice18.setOpaque(true);
        ItemPrice18.setPreferredSize(new java.awt.Dimension(30, 20));

        ItemPrice19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ItemPrice19.setText("0");
        ItemPrice19.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ItemPrice19.setMaximumSize(new java.awt.Dimension(30, 30));
        ItemPrice19.setMinimumSize(new java.awt.Dimension(30, 30));
        ItemPrice19.setOpaque(true);
        ItemPrice19.setPreferredSize(new java.awt.Dimension(30, 20));

        ItemPrice20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ItemPrice20.setText("0");
        ItemPrice20.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ItemPrice20.setMaximumSize(new java.awt.Dimension(30, 30));
        ItemPrice20.setMinimumSize(new java.awt.Dimension(30, 30));
        ItemPrice20.setOpaque(true);
        ItemPrice20.setPreferredSize(new java.awt.Dimension(30, 20));

        ItemPrice21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ItemPrice21.setText("0");
        ItemPrice21.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ItemPrice21.setMaximumSize(new java.awt.Dimension(30, 30));
        ItemPrice21.setMinimumSize(new java.awt.Dimension(30, 30));
        ItemPrice21.setOpaque(true);
        ItemPrice21.setPreferredSize(new java.awt.Dimension(30, 20));

        ItemPrice22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ItemPrice22.setText("0");
        ItemPrice22.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ItemPrice22.setMaximumSize(new java.awt.Dimension(30, 30));
        ItemPrice22.setMinimumSize(new java.awt.Dimension(30, 30));
        ItemPrice22.setOpaque(true);
        ItemPrice22.setPreferredSize(new java.awt.Dimension(30, 20));

        ItemPrice23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ItemPrice23.setText("0");
        ItemPrice23.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ItemPrice23.setMaximumSize(new java.awt.Dimension(30, 30));
        ItemPrice23.setMinimumSize(new java.awt.Dimension(30, 30));
        ItemPrice23.setOpaque(true);
        ItemPrice23.setPreferredSize(new java.awt.Dimension(30, 20));

        ItemPrice24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ItemPrice24.setText("0");
        ItemPrice24.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ItemPrice24.setMaximumSize(new java.awt.Dimension(30, 30));
        ItemPrice24.setMinimumSize(new java.awt.Dimension(30, 30));
        ItemPrice24.setOpaque(true);
        ItemPrice24.setPreferredSize(new java.awt.Dimension(30, 20));

        ItemPrice25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ItemPrice25.setText("0");
        ItemPrice25.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ItemPrice25.setMaximumSize(new java.awt.Dimension(30, 30));
        ItemPrice25.setMinimumSize(new java.awt.Dimension(30, 30));
        ItemPrice25.setOpaque(true);
        ItemPrice25.setPreferredSize(new java.awt.Dimension(30, 20));

        ItemPrice26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ItemPrice26.setText("0");
        ItemPrice26.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ItemPrice26.setMaximumSize(new java.awt.Dimension(30, 30));
        ItemPrice26.setMinimumSize(new java.awt.Dimension(30, 30));
        ItemPrice26.setOpaque(true);
        ItemPrice26.setPreferredSize(new java.awt.Dimension(30, 20));

        ItemPrice27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ItemPrice27.setText("0");
        ItemPrice27.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ItemPrice27.setMaximumSize(new java.awt.Dimension(30, 30));
        ItemPrice27.setMinimumSize(new java.awt.Dimension(30, 30));
        ItemPrice27.setOpaque(true);
        ItemPrice27.setPreferredSize(new java.awt.Dimension(30, 20));

        ItemPrice28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ItemPrice28.setText("0");
        ItemPrice28.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ItemPrice28.setMaximumSize(new java.awt.Dimension(30, 30));
        ItemPrice28.setMinimumSize(new java.awt.Dimension(30, 30));
        ItemPrice28.setOpaque(true);
        ItemPrice28.setPreferredSize(new java.awt.Dimension(30, 20));

        ItemPrice29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ItemPrice29.setText("0");
        ItemPrice29.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ItemPrice29.setMaximumSize(new java.awt.Dimension(30, 30));
        ItemPrice29.setMinimumSize(new java.awt.Dimension(30, 30));
        ItemPrice29.setOpaque(true);
        ItemPrice29.setPreferredSize(new java.awt.Dimension(30, 20));

        ItemPrice30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ItemPrice30.setText("0");
        ItemPrice30.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ItemPrice30.setMaximumSize(new java.awt.Dimension(30, 30));
        ItemPrice30.setMinimumSize(new java.awt.Dimension(30, 30));
        ItemPrice30.setOpaque(true);
        ItemPrice30.setPreferredSize(new java.awt.Dimension(30, 20));

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                .addComponent(ItemPic11, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton16JackBeef, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(ItemPic16, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton26Dill)
                                .addComponent(ItemPic26, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(ItemPic1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton6Jack, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton11Canadian, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(ItemPic6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                .addComponent(jButton21Blue, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(ItemPic21, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(JBreadSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CanadianSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JBeefSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DillSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BlueSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ItemPrice6, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ItemStock1, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ItemPrice1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ItemPrice11, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ItemStock6, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ItemStock11, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ItemPrice16, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ItemPrice21, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ItemStock17, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ItemStock21, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ItemPrice26, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ItemStock27, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BriocheSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jButton1Brioche, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jButton12Weiner, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton17White, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ItemPic2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ItemPic7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ItemPic12, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ItemPic17, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ItemPic22, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ItemPic27, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton22American, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton27Hot, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2Sesame, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7Angus, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(SesameSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(AngusSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(WeinerSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(HotSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(WhiteSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(AmericanSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ItemPrice2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ItemPrice7, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ItemStock2, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ItemStock7, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ItemPrice12, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ItemPrice17, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ItemStock12, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ItemStock16, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ItemPrice22, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ItemPrice27, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ItemStock22, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ItemStock26, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(ItemPic13, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton18Onion, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton23Melted, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ItemPic23, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton28Barbecue, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ItemPic28, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ItemPic3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton8Wagyu, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton13Grilled, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ItemPic8, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ItemPic18, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                    .addComponent(RyeSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(WagyuSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(GrilledSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(OnionSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(BarbecueSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(MeltedSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ItemPrice3, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ItemPrice8, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ItemStock3, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ItemPrice13, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ItemPrice18, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ItemPrice23, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ItemPrice28, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ItemStock23, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ItemStock8, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ItemStock13, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ItemStock18, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ItemStock28, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(ItemPic4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26))
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                    .addComponent(ItemPic14, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton19Trappist, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton24Beefsteak)
                                    .addComponent(ItemPic19, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ItemPic24, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton29Caviar, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ItemPic29, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton9Tapa, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton14Bronze, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ItemPic9, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(WholewheatSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TapaSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BronzeSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TrappistSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BeefsteakSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CaviarSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ItemPrice4, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ItemPrice9, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ItemStock4, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ItemStock9, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ItemPrice14, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ItemPrice19, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ItemStock14, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ItemStock19, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ItemPrice24, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ItemPrice29, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ItemStock24, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ItemStock29, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jButton10Cheesed, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton15Beyond, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton20Mozzarella, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ItemPic5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ItemPic10, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ItemPic15, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ItemPic20, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ItemPic25, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ItemPic30, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton25Iceberg)
                            .addComponent(jButton30JackSauce)
                            .addComponent(jButton5Potato, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(PotatoSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CheesedSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BeyondSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(MozzarellaSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(IcebergSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JSauceSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ItemPrice5, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ItemPrice10, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ItemStock5, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ItemStock10, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ItemPrice15, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ItemPrice20, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ItemStock15, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ItemStock20, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ItemPrice25, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ItemPrice30, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ItemStock25, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ItemStock30, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(jButton3Rye, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(75, 75, 75)
                        .addComponent(jButton4Wholewheat)
                        .addGap(267, 267, 267))))
        );

        jPanel12Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {ItemPic13, ItemPic18, ItemPic23, ItemPic28, ItemPic3, ItemPic8});

        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(ItemStock1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ItemStock2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ItemStock3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ItemStock4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ItemStock5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(ItemPrice1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ItemPrice2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ItemPrice3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ItemPrice4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ItemPrice5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(BriocheSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SesameSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(RyeSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(WholewheatSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PotatoSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1Brioche)
                            .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jButton3Rye)
                                .addComponent(jButton4Wholewheat)
                                .addComponent(jButton5Potato)))
                        .addGap(8, 8, 8))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(ItemPic2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(ItemPic3, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(ItemPic5, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(ItemPic4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ItemPic1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addComponent(jButton2Sesame)
                        .addGap(9, 9, 9)))
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(ItemStock7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(ItemPrice7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(AngusSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel12Layout.createSequentialGroup()
                                        .addComponent(ItemStock6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                    .addGroup(jPanel12Layout.createSequentialGroup()
                                        .addComponent(ItemStock8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(14, 14, 14))
                                    .addGroup(jPanel12Layout.createSequentialGroup()
                                        .addComponent(ItemStock9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                    .addGroup(jPanel12Layout.createSequentialGroup()
                                        .addComponent(ItemStock10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                                        .addComponent(ItemPrice6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(JBreadSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                                        .addComponent(ItemPrice8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(WagyuSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                                        .addComponent(ItemPrice9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(TapaSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                                        .addComponent(ItemPrice10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(CheesedSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(3, 3, 3)))))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton6Jack)
                            .addComponent(jButton7Angus)
                            .addComponent(jButton8Wagyu)
                            .addComponent(jButton9Tapa)
                            .addComponent(jButton10Cheesed))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(ItemStock11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(13, 13, 13)
                                .addComponent(ItemPrice11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(7, 7, 7)
                                .addComponent(CanadianSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(ItemStock12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(ItemPrice12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4)
                                .addComponent(WeinerSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(ItemStock13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(13, 13, 13)
                                .addComponent(ItemPrice13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4)
                                .addComponent(GrilledSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(ItemStock14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(ItemPrice14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)
                                .addComponent(BronzeSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(ItemPic11, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ItemPic12, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ItemPic13, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(ItemStock15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(ItemPrice15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4)
                                .addComponent(BeyondSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(ItemPic14, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ItemPic15, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jButton11Canadian)
                            .addComponent(jButton12Weiner)
                            .addComponent(jButton13Grilled)
                            .addComponent(jButton14Bronze)
                            .addComponent(jButton15Beyond))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.CENTER, jPanel12Layout.createSequentialGroup()
                                .addComponent(ItemStock17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ItemPrice16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JBeefSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.CENTER, jPanel12Layout.createSequentialGroup()
                                .addComponent(ItemStock16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ItemPrice17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(WhiteSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.CENTER, jPanel12Layout.createSequentialGroup()
                                .addComponent(ItemStock18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(ItemPrice18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(OnionSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.CENTER, jPanel12Layout.createSequentialGroup()
                                .addComponent(ItemStock19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ItemPrice19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TrappistSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.CENTER, jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(ItemPic16, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(ItemPic17, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(ItemPic19, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(ItemPic20, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(ItemPic18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.CENTER, jPanel12Layout.createSequentialGroup()
                                .addComponent(ItemStock20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ItemPrice20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(MozzarellaSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jButton16JackBeef)
                            .addComponent(jButton17White)
                            .addComponent(jButton18Onion)
                            .addComponent(jButton19Trappist)
                            .addComponent(jButton20Mozzarella))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel12Layout.createSequentialGroup()
                                        .addComponent(ItemStock21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(11, 11, 11)
                                        .addComponent(ItemPrice21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(4, 4, 4)
                                        .addComponent(BlueSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(ItemPic21, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton21Blue))
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                                        .addComponent(ItemStock22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(62, 62, 62))
                                    .addGroup(jPanel12Layout.createSequentialGroup()
                                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel12Layout.createSequentialGroup()
                                                .addComponent(ItemPrice23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(3, 3, 3)
                                                .addComponent(MeltedSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(ItemPic23, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(12, 12, 12)))
                                .addComponent(jButton23Melted))
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel12Layout.createSequentialGroup()
                                        .addComponent(ItemPic24, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(12, 12, 12))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                                        .addComponent(ItemStock23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(64, 64, 64))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                                        .addComponent(ItemStock24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(ItemPrice24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(38, 38, 38)))
                                .addComponent(jButton24Beefsteak))
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel12Layout.createSequentialGroup()
                                        .addComponent(ItemStock25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(ItemPrice25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(4, 4, 4)
                                        .addComponent(IcebergSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(ItemPic25, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(BeefsteakSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(12, 12, 12)
                                .addComponent(jButton25Iceberg))
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel12Layout.createSequentialGroup()
                                        .addComponent(ItemPrice22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(3, 3, 3)
                                        .addComponent(AmericanSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(ItemPic22, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(12, 12, 12)
                                .addComponent(jButton22American)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(ItemStock28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(13, 13, 13)
                                .addComponent(ItemPrice28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BarbecueSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(ItemStock26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(16, 16, 16)
                                .addComponent(ItemPrice27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4)
                                .addComponent(HotSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(ItemStock30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(17, 17, 17)
                                .addComponent(ItemPrice30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(3, 3, 3)
                                .addComponent(JSauceSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(ItemStock29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(16, 16, 16)
                                .addComponent(ItemPrice29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(CaviarSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(ItemPic30, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ItemPic29, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ItemPic28, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ItemPic27, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ItemPic26, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(ItemStock27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(11, 11, 11)
                                .addComponent(ItemPrice26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4)
                                .addComponent(DillSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jButton26Dill)
                            .addComponent(jButton27Hot)
                            .addComponent(jButton28Barbecue)
                            .addComponent(jButton29Caviar)
                            .addComponent(jButton30JackSauce)))
                    .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(ItemPic10, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ItemPic9, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ItemPic8, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ItemPic7, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ItemPic6, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(49, 49, 49))
        );

        jPanel12Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {ItemPic13, ItemPic18, ItemPic23, ItemPic28, ItemPic3, ItemPic8});

        javax.swing.GroupLayout ItemPanelLayout = new javax.swing.GroupLayout(ItemPanel);
        ItemPanel.setLayout(ItemPanelLayout);
        ItemPanelLayout.setHorizontalGroup(
            ItemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ItemPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(4, 4, 4)
                .addComponent(jButtonConfirmItem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonCancelItem, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        ItemPanelLayout.setVerticalGroup(
            ItemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(ItemPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ItemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, 878, Short.MAX_VALUE)
                    .addComponent(jButtonConfirmItem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonCancelItem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        ItemRack.setViewportView(ItemPanel);

        jTabbedPaneItem.addTab("Items", ItemRack);

        jPanelRecipe.setBackground(new java.awt.Color(102, 102, 102));

        RecipePic2.setBackground(new java.awt.Color(204, 204, 204));
        RecipePic2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        RecipePic2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        RecipePic2.setFocusable(false);
        RecipePic2.setOpaque(true);

        RecipePic1.setBackground(new java.awt.Color(204, 204, 204));
        RecipePic1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        RecipePic1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        RecipePic1.setFocusable(false);
        RecipePic1.setOpaque(true);

        RecipePic3.setBackground(new java.awt.Color(204, 204, 204));
        RecipePic3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        RecipePic3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        RecipePic3.setFocusable(false);
        RecipePic3.setOpaque(true);

        RecipePic4.setBackground(new java.awt.Color(204, 204, 204));
        RecipePic4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        RecipePic4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        RecipePic4.setFocusable(false);
        RecipePic4.setOpaque(true);

        ItemName33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ItemName33.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ItemName33.setOpaque(true);

        RecipePic5.setBackground(new java.awt.Color(204, 204, 204));
        RecipePic5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        RecipePic5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        RecipePic5.setFocusable(false);
        RecipePic5.setOpaque(true);

        RecipePic9.setBackground(new java.awt.Color(204, 204, 204));
        RecipePic9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        RecipePic9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        RecipePic9.setFocusable(false);
        RecipePic9.setOpaque(true);

        RecipePic10.setBackground(new java.awt.Color(204, 204, 204));
        RecipePic10.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        RecipePic10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        RecipePic10.setText("+");
        RecipePic10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        RecipePic10.setFocusable(false);
        RecipePic10.setOpaque(true);

        RecipePic7.setBackground(new java.awt.Color(204, 204, 204));
        RecipePic7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        RecipePic7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        RecipePic7.setFocusable(false);
        RecipePic7.setOpaque(true);

        RecipePic6.setBackground(new java.awt.Color(204, 204, 204));
        RecipePic6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        RecipePic6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        RecipePic6.setFocusable(false);
        RecipePic6.setOpaque(true);

        RecipePic8.setBackground(new java.awt.Color(204, 204, 204));
        RecipePic8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        RecipePic8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        RecipePic8.setFocusable(false);
        RecipePic8.setOpaque(true);

        jButton1Classic.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        jButton1Classic.setText("1-Classic Burger");
        jButton1Classic.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jButton2Cheesy.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        jButton2Cheesy.setText("2-Cheesy Cheeseburger");
        jButton2Cheesy.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jButton3Beyond.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        jButton3Beyond.setText("3-Beyond Burger");
        jButton3Beyond.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jButton4Gourmet.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        jButton4Gourmet.setText("4-Gourmet Burger");
        jButton4Gourmet.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jButton5Jack.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        jButton5Jack.setText("5-Jack Burger");
        jButton5Jack.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jButton6Meat.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        jButton6Meat.setText("6-Meat Overload Burger");
        jButton6Meat.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jButton7Spicy.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        jButton7Spicy.setText("7-Spicy Tapa Burger");
        jButton7Spicy.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jButton8Salmon.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        jButton8Salmon.setText("8-Salmon Burger");
        jButton8Salmon.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jButton9Turkey.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        jButton9Turkey.setText("9-Turkey Burger");
        jButton9Turkey.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jCustomButton10.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        jCustomButton10.setText("10-Custom Burger");
        jCustomButton10.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jCustomButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCustomButton10ActionPerformed(evt);
            }
        });

        jButtonCancelBurger.setBackground(new java.awt.Color(153, 0, 0));
        jButtonCancelBurger.setForeground(new java.awt.Color(255, 255, 255));
        jButtonCancelBurger.setText("Cancel Burger");

        jButtonConfirmBurger1.setBackground(new java.awt.Color(51, 51, 51));
        jButtonConfirmBurger1.setForeground(new java.awt.Color(255, 255, 255));
        jButtonConfirmBurger1.setText("Buy Burger");

        javax.swing.GroupLayout jPanelRecipeLayout = new javax.swing.GroupLayout(jPanelRecipe);
        jPanelRecipe.setLayout(jPanelRecipeLayout);
        jPanelRecipeLayout.setHorizontalGroup(
            jPanelRecipeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRecipeLayout.createSequentialGroup()
                .addGroup(jPanelRecipeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelRecipeLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(jPanelRecipeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton1Classic)
                            .addComponent(RecipePic1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(RecipePic6, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanelRecipeLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jButton6Meat)))
                .addGroup(jPanelRecipeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelRecipeLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanelRecipeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelRecipeLayout.createSequentialGroup()
                                .addComponent(RecipePic7, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18))
                            .addComponent(jButton2Cheesy, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelRecipeLayout.createSequentialGroup()
                                .addComponent(jButton7Spicy)
                                .addGap(8, 8, 8)))
                        .addGap(31, 31, 31))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelRecipeLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(RecipePic2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(48, 48, 48)))
                .addGroup(jPanelRecipeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(RecipePic8, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(RecipePic3, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3Beyond)
                    .addComponent(jButton8Salmon))
                .addGap(34, 34, 34)
                .addGroup(jPanelRecipeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelRecipeLayout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addComponent(ItemName33))
                    .addComponent(RecipePic9, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                    .addComponent(RecipePic4, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4Gourmet)
                    .addComponent(jButton9Turkey))
                .addGap(24, 24, 24)
                .addGroup(jPanelRecipeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCustomButton10)
                    .addGroup(jPanelRecipeLayout.createSequentialGroup()
                        .addGroup(jPanelRecipeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(RecipePic5, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton5Jack, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(RecipePic10, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 139, Short.MAX_VALUE)
                        .addComponent(jButtonConfirmBurger1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonCancelBurger, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(89, 89, 89))
        );

        jPanelRecipeLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {RecipePic1, RecipePic10, RecipePic2, RecipePic3, RecipePic4, RecipePic5, RecipePic6, RecipePic7, RecipePic8, RecipePic9});

        jPanelRecipeLayout.setVerticalGroup(
            jPanelRecipeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRecipeLayout.createSequentialGroup()
                .addGroup(jPanelRecipeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelRecipeLayout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addComponent(ItemName33)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelRecipeLayout.createSequentialGroup()
                        .addGroup(jPanelRecipeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelRecipeLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanelRecipeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanelRecipeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanelRecipeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanelRecipeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(RecipePic1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(RecipePic2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(RecipePic3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(RecipePic4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(RecipePic5, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanelRecipeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                    .addComponent(jButton1Classic)
                                    .addComponent(jButton2Cheesy)
                                    .addComponent(jButton3Beyond)
                                    .addComponent(jButton4Gourmet)
                                    .addComponent(jButton5Jack))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanelRecipeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                    .addComponent(RecipePic9, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(RecipePic10, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(RecipePic7, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(RecipePic6, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(RecipePic8, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(12, 12, 12))
                            .addGroup(jPanelRecipeLayout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addGroup(jPanelRecipeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButtonConfirmBurger1, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButtonCancelBurger, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanelRecipeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jButton6Meat)
                            .addComponent(jButton7Spicy)
                            .addComponent(jButton8Salmon)
                            .addComponent(jButton9Turkey)
                            .addComponent(jCustomButton10))))
                .addGap(49, 49, 49))
        );

        jPanelRecipeLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {RecipePic1, RecipePic2, RecipePic3, RecipePic4, RecipePic5});

        jPanelRecipeLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {RecipePic10, RecipePic6, RecipePic7, RecipePic8, RecipePic9});

        jTabbedPaneItem.addTab("Recipes", jPanelRecipe);

        jTabbedPane1.addTab("Test", jTabbedPaneItem);
        jTabbedPaneItem.getAccessibleContext().setAccessibleName("ItemsTabPane");

        CreateVendingMachinePanel.setMaximumSize(new java.awt.Dimension(300, 300));
        CreateVendingMachinePanel.setMinimumSize(new java.awt.Dimension(300, 300));

        jPanel5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        buttonGroup.add(RegRadioButton);
        RegRadioButton.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        RegRadioButton.setSelected(true);
        RegRadioButton.setText("Regular Vending Machine");
        RegRadioButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        VMNameText.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        VMNameText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        VMNameText.setText("New Vending Machine");
        VMNameText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VMNameTextActionPerformed(evt);
            }
        });

        CreateVMTitle1.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        CreateVMTitle1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CreateVMTitle1.setText("Create Your Vending Machine");
        CreateVMTitle1.setBorder(new javax.swing.border.MatteBorder(null));

        buttonGroup.add(SpeRadioButton);
        SpeRadioButton.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        SpeRadioButton.setText("Special Vending Machine");

        ConfirmVMButton.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        ConfirmVMButton.setText("Confirm");
        ConfirmVMButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConfirmVMButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CreateVMTitle1, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(RegRadioButton, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                                    .addComponent(SpeRadioButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(67, 67, 67)
                                .addComponent(ConfirmVMButton))
                            .addComponent(VMNameText, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(CreateVMTitle1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(RegRadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SpeRadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(VMNameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ConfirmVMButton, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout CreateVendingMachinePanelLayout = new javax.swing.GroupLayout(CreateVendingMachinePanel);
        CreateVendingMachinePanel.setLayout(CreateVendingMachinePanelLayout);
        CreateVendingMachinePanelLayout.setHorizontalGroup(
            CreateVendingMachinePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CreateVendingMachinePanelLayout.createSequentialGroup()
                .addGap(318, 318, 318)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(563, Short.MAX_VALUE))
        );
        CreateVendingMachinePanelLayout.setVerticalGroup(
            CreateVendingMachinePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CreateVendingMachinePanelLayout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        jTabbedPane2.addTab("Welcome To Da Factory", CreateVendingMachinePanel);

        jTabbedPane1.addTab("Create", jTabbedPane2);

        jTabbedPaneRestock.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jRestockItemsPanel.setBackground(new java.awt.Color(153, 153, 153));

        jPanel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jRadioSesame.setText("2-Sesame Bread");
        jRadioSesame.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jRadioSesame.setBorderPainted(true);
        jRadioSesame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioSesameActionPerformed(evt);
            }
        });

        jRadioBrioche.setText("1-Brioche Bread");
        jRadioBrioche.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jRadioBrioche.setBorderPainted(true);

        jRadioRye.setText("3-Rye Bread");
        jRadioRye.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jRadioRye.setBorderPainted(true);
        jRadioRye.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioRyeActionPerformed(evt);
            }
        });

        jRadioPotato.setText("5-Potato Bread");
        jRadioPotato.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jRadioPotato.setBorderPainted(true);
        jRadioPotato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioPotatoActionPerformed(evt);
            }
        });

        jRadioWholewheat.setText("4-Wholewheat Bread");
        jRadioWholewheat.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jRadioWholewheat.setBorderPainted(true);
        jRadioWholewheat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioWholewheatActionPerformed(evt);
            }
        });

        jRadioGrilled.setText("13-Grilled Salmon");
        jRadioGrilled.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jRadioGrilled.setBorderPainted(true);
        jRadioGrilled.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioGrilledActionPerformed(evt);
            }
        });

        jRadioBeyond.setText("15-Beyond Beef");
        jRadioBeyond.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jRadioBeyond.setBorderPainted(true);
        jRadioBeyond.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioBeyondActionPerformed(evt);
            }
        });

        jRadioBronze.setText("14-Bronze Turkey");
        jRadioBronze.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jRadioBronze.setBorderPainted(true);
        jRadioBronze.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioBronzeActionPerformed(evt);
            }
        });

        jRadioWeiner.setText("12-Weiner Schnitzel");
        jRadioWeiner.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jRadioWeiner.setBorderPainted(true);
        jRadioWeiner.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioWeinerActionPerformed(evt);
            }
        });

        jRadioCanadian.setText("11-Canadian Bacon");
        jRadioCanadian.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jRadioCanadian.setBorderPainted(true);

        jRadioOnion.setText("18-Onion Rings");
        jRadioOnion.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jRadioOnion.setBorderPainted(true);
        jRadioOnion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioOnionActionPerformed(evt);
            }
        });

        jRadioMozzarella.setText("20-Mozzarella Cheese");
        jRadioMozzarella.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jRadioMozzarella.setBorderPainted(true);
        jRadioMozzarella.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioMozzarellaActionPerformed(evt);
            }
        });

        jRadioTrappist.setText("19-Trappist Cheese");
        jRadioTrappist.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jRadioTrappist.setBorderPainted(true);
        jRadioTrappist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioTrappistActionPerformed(evt);
            }
        });

        jRadioMelted.setText("23-Melted Butter");
        jRadioMelted.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jRadioMelted.setBorderPainted(true);
        jRadioMelted.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioMeltedActionPerformed(evt);
            }
        });

        jRadioIceberg.setText("25-Iceberg Lettuce");
        jRadioIceberg.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jRadioIceberg.setBorderPainted(true);
        jRadioIceberg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioIcebergActionPerformed(evt);
            }
        });

        jRadioBeefsteak.setText("24-Beefsteak Tomato");
        jRadioBeefsteak.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jRadioBeefsteak.setBorderPainted(true);
        jRadioBeefsteak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioBeefsteakActionPerformed(evt);
            }
        });

        jRadioAmerican.setText("22-American Cheese");
        jRadioAmerican.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jRadioAmerican.setBorderPainted(true);
        jRadioAmerican.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioAmericanActionPerformed(evt);
            }
        });

        jRadioBlue.setText("21-Blue Cheese");
        jRadioBlue.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jRadioBlue.setBorderPainted(true);

        jRadioWhite.setText("17-White Onions");
        jRadioWhite.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jRadioWhite.setBorderPainted(true);
        jRadioWhite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioWhiteActionPerformed(evt);
            }
        });

        jRadioJackBf.setText("16-Jack Beef");
        jRadioJackBf.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jRadioJackBf.setBorderPainted(true);

        jRadioWagyu.setText("8-Wagyu Beef");
        jRadioWagyu.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jRadioWagyu.setBorderPainted(true);
        jRadioWagyu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioWagyuActionPerformed(evt);
            }
        });

        jRadioCheesed.setText("10-Cheesed Beef");
        jRadioCheesed.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jRadioCheesed.setBorderPainted(true);
        jRadioCheesed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioCheesedActionPerformed(evt);
            }
        });

        jRadioTapa.setText("9-Tapa Beef");
        jRadioTapa.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jRadioTapa.setBorderPainted(true);
        jRadioTapa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioTapaActionPerformed(evt);
            }
        });

        jRadioAngus.setText("7-Angus Beef");
        jRadioAngus.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jRadioAngus.setBorderPainted(true);
        jRadioAngus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioAngusActionPerformed(evt);
            }
        });

        jRadioJackB.setText("6-Jack Bread");
        jRadioJackB.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jRadioJackB.setBorderPainted(true);

        jRadioBarbecue.setText("28-Barbecue Sauce");
        jRadioBarbecue.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jRadioBarbecue.setBorderPainted(true);
        jRadioBarbecue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioBarbecueActionPerformed(evt);
            }
        });

        jRadioJackS.setText("30-Jack Sauce");
        jRadioJackS.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jRadioJackS.setBorderPainted(true);
        jRadioJackS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioJackSActionPerformed(evt);
            }
        });

        jRadioCaviar.setText("29-Caviar Sauce");
        jRadioCaviar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jRadioCaviar.setBorderPainted(true);
        jRadioCaviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioCaviarActionPerformed(evt);
            }
        });

        jRadioHot.setText("27-Hot Sauce");
        jRadioHot.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jRadioHot.setBorderPainted(true);
        jRadioHot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioHotActionPerformed(evt);
            }
        });

        jRadioDill.setText("26-Dill Pickles");
        jRadioDill.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jRadioDill.setBorderPainted(true);

        jPanel10.setBackground(new java.awt.Color(204, 204, 204));
        jPanel10.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel3.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Restock Yo Self");
        jLabel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(255, 102, 0), null, null));
        jLabel3.setOpaque(true);

        jButtonConfirmRestock.setText("Confirm Restock");
        jButtonConfirmRestock.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), null));
        jButtonConfirmRestock.setPreferredSize(new java.awt.Dimension(37, 20));
        jButtonConfirmRestock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConfirmRestockActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Comic Sans MS", 0, 10)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Select one or multiple items");
        jLabel7.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(255, 102, 0), null, null));
        jLabel7.setOpaque(true);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonConfirmRestock, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(35, 35, 35))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addGap(60, 60, 60)
                .addComponent(jButtonConfirmRestock, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(73, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioBrioche)
                    .addComponent(jRadioSesame)
                    .addComponent(jRadioRye)
                    .addComponent(jRadioPotato)
                    .addComponent(jRadioJackB)
                    .addComponent(jRadioAngus)
                    .addComponent(jRadioWagyu)
                    .addComponent(jRadioTapa)
                    .addComponent(jRadioCheesed)
                    .addComponent(jRadioWholewheat))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioJackBf)
                    .addComponent(jRadioWhite)
                    .addComponent(jRadioOnion)
                    .addComponent(jRadioTrappist)
                    .addComponent(jRadioMozzarella)
                    .addComponent(jRadioCanadian)
                    .addComponent(jRadioWeiner)
                    .addComponent(jRadioGrilled)
                    .addComponent(jRadioBronze)
                    .addComponent(jRadioBeyond))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioMelted)
                    .addComponent(jRadioHot)
                    .addComponent(jRadioBlue)
                    .addComponent(jRadioJackS)
                    .addComponent(jRadioCaviar)
                    .addComponent(jRadioBarbecue)
                    .addComponent(jRadioAmerican)
                    .addComponent(jRadioIceberg)
                    .addComponent(jRadioDill)
                    .addComponent(jRadioBeefsteak))
                .addGap(25, 25, 25)
                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jRadioBlue)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioAmerican))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(jRadioCanadian)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jRadioWeiner)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jRadioGrilled)
                                        .addComponent(jRadioMelted))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jRadioBronze)
                                        .addComponent(jRadioBeefsteak))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jRadioBeyond)
                                        .addComponent(jRadioIceberg)))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(jRadioBrioche)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jRadioSesame)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jRadioRye)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jRadioWholewheat)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jRadioPotato)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                .addComponent(jRadioJackBf)
                                .addComponent(jRadioJackB)
                                .addComponent(jRadioDill))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jRadioAngus)
                                .addComponent(jRadioWhite)
                                .addComponent(jRadioHot))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                .addComponent(jRadioWagyu)
                                .addComponent(jRadioOnion)
                                .addComponent(jRadioBarbecue))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(jRadioTapa)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jRadioCheesed))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(jRadioTrappist)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jRadioMozzarella))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(jRadioCaviar)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jRadioJackS))))))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jRestockItemsPanelLayout = new javax.swing.GroupLayout(jRestockItemsPanel);
        jRestockItemsPanel.setLayout(jRestockItemsPanelLayout);
        jRestockItemsPanelLayout.setHorizontalGroup(
            jRestockItemsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jRestockItemsPanelLayout.createSequentialGroup()
                .addGap(133, 133, 133)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(325, Short.MAX_VALUE))
        );
        jRestockItemsPanelLayout.setVerticalGroup(
            jRestockItemsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPaneRestock.addTab("Restock ", jRestockItemsPanel);

        jPanel7.setBackground(new java.awt.Color(153, 153, 153));

        jPanel8.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        buttonGroupItems.add(jRadioSesame1);
        jRadioSesame1.setText("2-Sesame Bread");
        jRadioSesame1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jRadioSesame1.setBorderPainted(true);
        jRadioSesame1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioSesame1ActionPerformed(evt);
            }
        });

        buttonGroupItems.add(jRadioBrioche1);
        jRadioBrioche1.setText("1-Brioche Bread");
        jRadioBrioche1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jRadioBrioche1.setBorderPainted(true);

        buttonGroupItems.add(jRadioRye1);
        jRadioRye1.setText("3-Rye Bread");
        jRadioRye1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jRadioRye1.setBorderPainted(true);
        jRadioRye1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioRye1ActionPerformed(evt);
            }
        });

        buttonGroupItems.add(jRadioPotato1);
        jRadioPotato1.setText("5-Potato Bread");
        jRadioPotato1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jRadioPotato1.setBorderPainted(true);
        jRadioPotato1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioPotato1ActionPerformed(evt);
            }
        });

        buttonGroupItems.add(jRadioWholewheat1);
        jRadioWholewheat1.setText("4-Wholewheat Bread");
        jRadioWholewheat1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jRadioWholewheat1.setBorderPainted(true);
        jRadioWholewheat1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioWholewheat1ActionPerformed(evt);
            }
        });

        buttonGroupItems.add(jRadioGrilled1);
        jRadioGrilled1.setText("13-Grilled Salmon");
        jRadioGrilled1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jRadioGrilled1.setBorderPainted(true);
        jRadioGrilled1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioGrilled1ActionPerformed(evt);
            }
        });

        buttonGroupItems.add(jRadioBeyond1);
        jRadioBeyond1.setText("15-Beyond Beef");
        jRadioBeyond1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jRadioBeyond1.setBorderPainted(true);
        jRadioBeyond1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioBeyond1ActionPerformed(evt);
            }
        });

        buttonGroupItems.add(jRadioBronze1);
        jRadioBronze1.setText("14-Bronze Turkey");
        jRadioBronze1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jRadioBronze1.setBorderPainted(true);
        jRadioBronze1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioBronze1ActionPerformed(evt);
            }
        });

        buttonGroupItems.add(jRadioWeiner1);
        jRadioWeiner1.setText("12-Weiner Schnitzel");
        jRadioWeiner1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jRadioWeiner1.setBorderPainted(true);
        jRadioWeiner1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioWeiner1ActionPerformed(evt);
            }
        });

        buttonGroupItems.add(jRadioCanadian1);
        jRadioCanadian1.setText("11-Canadian Bacon");
        jRadioCanadian1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jRadioCanadian1.setBorderPainted(true);

        buttonGroupItems.add(jRadioOnion1);
        jRadioOnion1.setText("18-Onion Rings");
        jRadioOnion1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jRadioOnion1.setBorderPainted(true);
        jRadioOnion1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioOnion1ActionPerformed(evt);
            }
        });

        buttonGroupItems.add(jRadioMozzarella1);
        jRadioMozzarella1.setText("20-Mozzarella Cheese");
        jRadioMozzarella1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jRadioMozzarella1.setBorderPainted(true);
        jRadioMozzarella1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioMozzarella1ActionPerformed(evt);
            }
        });

        buttonGroupItems.add(jRadioTrappist1);
        jRadioTrappist1.setText("19-Trappist Cheese");
        jRadioTrappist1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jRadioTrappist1.setBorderPainted(true);
        jRadioTrappist1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioTrappist1ActionPerformed(evt);
            }
        });

        buttonGroupItems.add(jRadioMelted1);
        jRadioMelted1.setText("23-Melted Butter");
        jRadioMelted1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jRadioMelted1.setBorderPainted(true);
        jRadioMelted1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioMelted1ActionPerformed(evt);
            }
        });

        buttonGroupItems.add(jRadioIceberg1);
        jRadioIceberg1.setText("25-Iceberg Lettuce");
        jRadioIceberg1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jRadioIceberg1.setBorderPainted(true);
        jRadioIceberg1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioIceberg1ActionPerformed(evt);
            }
        });

        buttonGroupItems.add(jRadioBeefsteak1);
        jRadioBeefsteak1.setText("24-Beefsteak Tomato");
        jRadioBeefsteak1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jRadioBeefsteak1.setBorderPainted(true);
        jRadioBeefsteak1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioBeefsteak1ActionPerformed(evt);
            }
        });

        buttonGroupItems.add(jRadioAmerican1);
        jRadioAmerican1.setText("22-American Cheese");
        jRadioAmerican1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jRadioAmerican1.setBorderPainted(true);
        jRadioAmerican1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioAmerican1ActionPerformed(evt);
            }
        });

        buttonGroupItems.add(jRadioBlue1);
        jRadioBlue1.setText("21-Blue Cheese");
        jRadioBlue1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jRadioBlue1.setBorderPainted(true);

        buttonGroupItems.add(jRadioWhite1);
        jRadioWhite1.setText("17-White Onions");
        jRadioWhite1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jRadioWhite1.setBorderPainted(true);
        jRadioWhite1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioWhite1ActionPerformed(evt);
            }
        });

        buttonGroupItems.add(jRadioJackBf1);
        jRadioJackBf1.setText("16-Jack Beef");
        jRadioJackBf1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jRadioJackBf1.setBorderPainted(true);

        buttonGroupItems.add(jRadioWagyu1);
        jRadioWagyu1.setText("8-Wagyu Beef");
        jRadioWagyu1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jRadioWagyu1.setBorderPainted(true);
        jRadioWagyu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioWagyu1ActionPerformed(evt);
            }
        });

        buttonGroupItems.add(jRadioCheesed1);
        jRadioCheesed1.setText("10-Cheesed Beef");
        jRadioCheesed1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jRadioCheesed1.setBorderPainted(true);
        jRadioCheesed1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioCheesed1ActionPerformed(evt);
            }
        });

        buttonGroupItems.add(jRadioTapa1);
        jRadioTapa1.setText("9-Tapa Beef");
        jRadioTapa1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jRadioTapa1.setBorderPainted(true);
        jRadioTapa1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioTapa1ActionPerformed(evt);
            }
        });

        buttonGroupItems.add(jRadioAngus1);
        jRadioAngus1.setText("7-Angus Beef");
        jRadioAngus1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jRadioAngus1.setBorderPainted(true);
        jRadioAngus1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioAngus1ActionPerformed(evt);
            }
        });

        buttonGroupItems.add(jRadioJackB1);
        jRadioJackB1.setText("6-Jack Bread");
        jRadioJackB1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jRadioJackB1.setBorderPainted(true);

        buttonGroupItems.add(jRadioBarbecue1);
        jRadioBarbecue1.setText("28-Barbecue Sauce");
        jRadioBarbecue1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jRadioBarbecue1.setBorderPainted(true);
        jRadioBarbecue1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioBarbecue1ActionPerformed(evt);
            }
        });

        buttonGroupItems.add(jRadioJackS1);
        jRadioJackS1.setText("30-Jack Sauce");
        jRadioJackS1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jRadioJackS1.setBorderPainted(true);
        jRadioJackS1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioJackS1ActionPerformed(evt);
            }
        });

        buttonGroupItems.add(jRadioCaviar1);
        jRadioCaviar1.setText("29-Caviar Sauce");
        jRadioCaviar1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jRadioCaviar1.setBorderPainted(true);
        jRadioCaviar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioCaviar1ActionPerformed(evt);
            }
        });

        buttonGroupItems.add(jRadioHot1);
        jRadioHot1.setText("27-Hot Sauce");
        jRadioHot1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jRadioHot1.setBorderPainted(true);
        jRadioHot1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioHot1ActionPerformed(evt);
            }
        });

        buttonGroupItems.add(jRadioDill1);
        jRadioDill1.setText("26-Dill Pickles");
        jRadioDill1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jRadioDill1.setBorderPainted(true);

        jPanel11.setBackground(new java.awt.Color(204, 204, 204));
        jPanel11.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel11.setPreferredSize(new java.awt.Dimension(221, 267));

        jINewPriceTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jINewPriceTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jINewPriceTextFieldActionPerformed(evt);
            }
        });

        jButton4.setText("4");
        jButton4.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), null));
        jButton4.setPreferredSize(new java.awt.Dimension(37, 20));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton2.setText("2");
        jButton2.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), null));
        jButton2.setPreferredSize(new java.awt.Dimension(37, 20));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButtonConfirmReprice.setText("Confirm");
        jButtonConfirmReprice.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), null));
        jButtonConfirmReprice.setPreferredSize(new java.awt.Dimension(37, 20));
        jButtonConfirmReprice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConfirmRepriceActionPerformed(evt);
            }
        });

        jButton7.setText("7");
        jButton7.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), null));
        jButton7.setPreferredSize(new java.awt.Dimension(37, 20));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButtonClear.setText("C");
        jButtonClear.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), null));
        jButtonClear.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButtonClear.setPreferredSize(new java.awt.Dimension(37, 20));
        jButtonClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonClearActionPerformed(evt);
            }
        });

        jButton1.setText("1");
        jButton1.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), null));
        jButton1.setPreferredSize(new java.awt.Dimension(37, 20));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton0.setText("0");
        jButton0.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), null));
        jButton0.setPreferredSize(new java.awt.Dimension(37, 20));
        jButton0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton0ActionPerformed(evt);
            }
        });

        jButton5.setText("5");
        jButton5.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), null));
        jButton5.setPreferredSize(new java.awt.Dimension(37, 20));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton3.setText("3");
        jButton3.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), null));
        jButton3.setPreferredSize(new java.awt.Dimension(37, 20));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton6.setText("6");
        jButton6.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), null));
        jButton6.setIconTextGap(6);
        jButton6.setPreferredSize(new java.awt.Dimension(37, 20));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton8.setText("8");
        jButton8.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), null));
        jButton8.setPreferredSize(new java.awt.Dimension(37, 20));
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setText("9");
        jButton9.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), null));
        jButton9.setPreferredSize(new java.awt.Dimension(37, 20));
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Reprice Yo Self");
        jLabel5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(255, 102, 0), null, null));
        jLabel5.setOpaque(true);

        jLabel6.setFont(new java.awt.Font("Comic Sans MS", 0, 10)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Select an item and input new price.");
        jLabel6.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(255, 102, 0), null, null));
        jLabel6.setOpaque(true);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addComponent(jButton0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonConfirmReprice, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(jButtonClear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jINewPriceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 8, Short.MAX_VALUE))
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(jINewPriceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonClear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonConfirmReprice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioBrioche1)
                    .addComponent(jRadioSesame1)
                    .addComponent(jRadioRye1)
                    .addComponent(jRadioPotato1)
                    .addComponent(jRadioJackB1)
                    .addComponent(jRadioAngus1)
                    .addComponent(jRadioWagyu1)
                    .addComponent(jRadioTapa1)
                    .addComponent(jRadioCheesed1)
                    .addComponent(jRadioWholewheat1))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioJackBf1)
                    .addComponent(jRadioWhite1)
                    .addComponent(jRadioOnion1)
                    .addComponent(jRadioTrappist1)
                    .addComponent(jRadioMozzarella1)
                    .addComponent(jRadioCanadian1)
                    .addComponent(jRadioWeiner1)
                    .addComponent(jRadioGrilled1)
                    .addComponent(jRadioBronze1)
                    .addComponent(jRadioBeyond1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioBlue1)
                    .addComponent(jRadioMelted1)
                    .addComponent(jRadioJackS1)
                    .addComponent(jRadioAmerican1)
                    .addComponent(jRadioCaviar1)
                    .addComponent(jRadioBeefsteak1)
                    .addComponent(jRadioIceberg1)
                    .addComponent(jRadioDill1)
                    .addComponent(jRadioHot1)
                    .addComponent(jRadioBarbecue1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jRadioBlue1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioAmerican1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioMelted1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioBeefsteak1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioIceberg1))
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel8Layout.createSequentialGroup()
                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel8Layout.createSequentialGroup()
                                    .addComponent(jRadioCanadian1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jRadioWeiner1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jRadioGrilled1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jRadioBronze1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jRadioBeyond1))
                                .addGroup(jPanel8Layout.createSequentialGroup()
                                    .addComponent(jRadioBrioche1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jRadioSesame1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jRadioRye1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jRadioWholewheat1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jRadioPotato1)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addComponent(jRadioJackB1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jRadioAngus1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jRadioWagyu1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jRadioTapa1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jRadioCheesed1))
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addComponent(jRadioJackBf1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jRadioWhite1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jRadioOnion1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jRadioTrappist1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jRadioMozzarella1)))
                                .addGroup(jPanel8Layout.createSequentialGroup()
                                    .addComponent(jRadioDill1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jRadioHot1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jRadioBarbecue1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jRadioCaviar1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jRadioJackS1))))))
                .addGap(28, 28, 28))
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(132, 132, 132)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(329, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPaneRestock.addTab("Reprice", jPanel7);

        jDisplayCashBox.setBackground(new java.awt.Color(153, 153, 153));

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jBillLabel8.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        jBillLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jBillLabel8.setText("P100 Bills:");
        jBillLabel8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jBillLabel8.setOpaque(true);

        jBillLabel2.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        jBillLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jBillLabel2.setText("P50 Bills:");
        jBillLabel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jBillLabel2.setOpaque(true);

        jBillLabel6.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        jBillLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jBillLabel6.setText("P10 Bills:");
        jBillLabel6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jBillLabel6.setOpaque(true);

        jBillLabel1.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        jBillLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jBillLabel1.setText("P1 Bills:");
        jBillLabel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jBillLabel1.setOpaque(true);

        TwentyPesoSpinner.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N

        jButtonDeposit.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        jButtonDeposit.setText("Deposit");
        jButtonDeposit.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), null));
        jButtonDeposit.setPreferredSize(new java.awt.Dimension(37, 20));
        jButtonDeposit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDepositActionPerformed(evt);
            }
        });

        FiftyPesoSpinner.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N

        jBillLabel10.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        jBillLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jBillLabel10.setText("P1000 Bills:");
        jBillLabel10.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jBillLabel10.setOpaque(true);

        jBillLabel7.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        jBillLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jBillLabel7.setText("P20 Bills:");
        jBillLabel7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jBillLabel7.setOpaque(true);

        jBill1.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        jBill1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jBill1.setText("0");
        jBill1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jBill1.setOpaque(true);

        jBill100.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        jBill100.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jBill100.setText("0");
        jBill100.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jBill100.setOpaque(true);

        jBill20.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        jBill20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jBill20.setText("0");
        jBill20.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jBill20.setOpaque(true);

        jButtonWithdraw.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        jButtonWithdraw.setText("Withdraw");
        jButtonWithdraw.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), null));
        jButtonWithdraw.setPreferredSize(new java.awt.Dimension(37, 20));
        jButtonWithdraw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonWithdrawActionPerformed(evt);
            }
        });

        ThousandPesoSpinner.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N

        jBill10.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        jBill10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jBill10.setText("0");
        jBill10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jBill10.setOpaque(true);

        jBillLabel5.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        jBillLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jBillLabel5.setText("P5 Bills:");
        jBillLabel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jBillLabel5.setOpaque(true);

        jBill5.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        jBill5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jBill5.setText("0");
        jBill5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jBill5.setOpaque(true);

        FiveHundredPesoSpinner.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N

        OneHundredPesoSpinner.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N

        jBill50.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        jBill50.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jBill50.setText("0");
        jBill50.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jBill50.setOpaque(true);

        jBill500.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        jBill500.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jBill500.setText("0");
        jBill500.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jBill500.setOpaque(true);

        jBill1000.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        jBill1000.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jBill1000.setText("0");
        jBill1000.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jBill1000.setOpaque(true);

        jBillLabel9.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        jBillLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jBillLabel9.setText("P500 Bills:");
        jBillLabel9.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jBillLabel9.setOpaque(true);

        OnePesoSpinner.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N

        TenPesoSpinner.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N

        FivePesoSpinner.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N

        jButtonWithdrawAll.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        jButtonWithdrawAll.setText("Withdraw All $$$");
        jButtonWithdrawAll.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), null));
        jButtonWithdrawAll.setPreferredSize(new java.awt.Dimension(37, 20));
        jButtonWithdrawAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonWithdrawAllActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jBillLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jBillLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jBillLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jBillLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jBill1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBill5, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBill10, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBill20, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jButtonDeposit, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(OnePesoSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(FivePesoSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(TenPesoSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(TwentyPesoSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jBillLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jBillLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jBillLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jBillLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jBill50, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(FiftyPesoSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jBill100, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(OneHundredPesoSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jBill500, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(FiveHundredPesoSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jBill1000, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ThousandPesoSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(31, 31, 31))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jButtonWithdraw, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonWithdrawAll, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(28, 28, 28))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jBill50)
                        .addComponent(FiftyPesoSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jBillLabel1)
                            .addComponent(jBill1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(OnePesoSpinner)
                            .addComponent(jBillLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jBillLabel5)
                            .addComponent(jBill5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(FivePesoSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBillLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jBill100)
                            .addComponent(OneHundredPesoSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jBillLabel6)
                            .addComponent(jBill10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(TenPesoSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBillLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jBill500)
                            .addComponent(FiveHundredPesoSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jBill20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jBillLabel7)
                            .addComponent(TwentyPesoSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBillLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jBill1000)
                            .addComponent(ThousandPesoSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonDeposit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonWithdraw, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonWithdrawAll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Money Handler: Handle Money Handily");
        jLabel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(255, 102, 0), null, null));
        jLabel1.setOpaque(true);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 514, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jDisplayCashBoxLayout = new javax.swing.GroupLayout(jDisplayCashBox);
        jDisplayCashBox.setLayout(jDisplayCashBoxLayout);
        jDisplayCashBoxLayout.setHorizontalGroup(
            jDisplayCashBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDisplayCashBoxLayout.createSequentialGroup()
                .addGap(241, 241, 241)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(425, Short.MAX_VALUE))
        );
        jDisplayCashBoxLayout.setVerticalGroup(
            jDisplayCashBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPaneRestock.addTab("Display Cashbox", jDisplayCashBox);

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));

        jPanel6.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jButtonPrintTransaction.setText("Print Transaction History");
        jButtonPrintTransaction.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), null));
        jButtonPrintTransaction.setPreferredSize(new java.awt.Dimension(37, 20));
        jButtonPrintTransaction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPrintTransactionActionPerformed(evt);
            }
        });

        jButtonPrintRestock.setText("Print Restock History");
        jButtonPrintRestock.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), null));
        jButtonPrintRestock.setPreferredSize(new java.awt.Dimension(37, 20));
        jButtonPrintRestock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPrintRestockActionPerformed(evt);
            }
        });

        jTextAreaReceipt.setBackground(new java.awt.Color(0, 0, 0));
        jTextAreaReceipt.setColumns(20);
        jTextAreaReceipt.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        jTextAreaReceipt.setForeground(new java.awt.Color(255, 255, 255));
        jTextAreaReceipt.setLineWrap(true);
        jTextAreaReceipt.setRows(5);
        jTextAreaReceipt.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(102, 102, 102), new java.awt.Color(102, 102, 102), new java.awt.Color(102, 102, 102), new java.awt.Color(102, 102, 102)));
        jTextAreaPane1.setViewportView(jTextAreaReceipt);

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Swiftly Stacked Sales Receipts Showwer");
        jLabel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(255, 102, 0), null, null));
        jLabel2.setOpaque(true);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jButtonPrintTransaction, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonPrintRestock, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTextAreaPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 479, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 514, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(jTextAreaPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonPrintTransaction, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonPrintRestock, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(241, 241, 241)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(402, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPaneRestock.addTab("Print Histories", jPanel2);

        jTabbedPane1.addTab("Maintain Yo Self B4 U Vend Yo Self", jTabbedPaneRestock);

        javax.swing.GroupLayout TestVendingMachinePanelLayout = new javax.swing.GroupLayout(TestVendingMachinePanel);
        TestVendingMachinePanel.setLayout(TestVendingMachinePanelLayout);
        TestVendingMachinePanelLayout.setHorizontalGroup(
            TestVendingMachinePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TestVendingMachinePanelLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(TestVendingMachinePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(TestVendingMachinePanelLayout.createSequentialGroup()
                        .addGroup(TestVendingMachinePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(TestVendingMachinePanelLayout.createSequentialGroup()
                                .addComponent(jTextAreaPane, javax.swing.GroupLayout.PREFERRED_SIZE, 479, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(239, 239, 239)
                                .addGroup(TestVendingMachinePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(TestVendingMachinePanelLayout.createSequentialGroup()
                                        .addComponent(jButtonBill10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButtonBill20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TestVendingMachinePanelLayout.createSequentialGroup()
                                        .addComponent(jButtonBill50, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButtonBill100, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TestVendingMachinePanelLayout.createSequentialGroup()
                                        .addComponent(jButtonBill500, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButtonBill1000, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TestVendingMachinePanelLayout.createSequentialGroup()
                                        .addComponent(jButtonBill1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButtonBill5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(TestVendingMachinePanelLayout.createSequentialGroup()
                                .addComponent(jVMName, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRegOrSpeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 404, Short.MAX_VALUE)))
                .addContainerGap())
        );
        TestVendingMachinePanelLayout.setVerticalGroup(
            TestVendingMachinePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TestVendingMachinePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(TestVendingMachinePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jVMName, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRegOrSpeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(TestVendingMachinePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TestVendingMachinePanelLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(TestVendingMachinePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonBill1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonBill5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(TestVendingMachinePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonBill10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonBill20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(TestVendingMachinePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonBill50, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonBill100, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(TestVendingMachinePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonBill500, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonBill1000, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jTextAreaPane, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(63, Short.MAX_VALUE))
        );

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TestVendingMachinePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TestVendingMachinePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }                       

	 /**
       * Initialize basic actions performed for each visual interactive element
       */
    private void jINewPriceTextFieldActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        // TODO add your handling code here:
    }                                                   

    private void jButton0ActionPerformed(java.awt.event.ActionEvent evt) {                                         
         jButtonActionPerformed(evt, "0");
    }                                        

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        jButtonActionPerformed(evt, "1");
    }                                        

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        jButtonActionPerformed(evt, "2");
    }                                        

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        jButtonActionPerformed(evt, "3");
    }                                        

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        jButtonActionPerformed(evt, "4");
    }                                        

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        jButtonActionPerformed(evt, "5");
    }                                        

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        jButtonActionPerformed(evt, "6");
    }                                        

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        jButtonActionPerformed(evt, "7");
    }                                        

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        jButtonActionPerformed(evt, "8");
    }                                        

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        jButtonActionPerformed(evt, "9");
    }                                        

    private void jButtonClearActionPerformed(java.awt.event.ActionEvent evt) {                                             
        jINewPriceTextField.setText("");
    }                                            

    private void jButtonConfirmRepriceActionPerformed(java.awt.event.ActionEvent evt) {  
        jINewPriceTextField.setText("");
        for (JRadioButton radios: repriceRadioList){
            if (radios.isSelected()){
                radios.setSelected(false);
            }
        }
    }                                                     

    private void jButtonBill1ActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:
    }                                            

    private void jButtonBill5ActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:
    }                                            

    private void jButtonBill10ActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // TODO add your handling code here:
    }                                             

    private void jButtonBill20ActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // TODO add your handling code here:
    }                                             

    private void jButtonBill50ActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // TODO add your handling code here:
    }                                             

    private void jButtonBill100ActionPerformed(java.awt.event.ActionEvent evt) {                                               
        // TODO add your handling code here:
    }                                              

    private void jButtonBill500ActionPerformed(java.awt.event.ActionEvent evt) {                                               
        // TODO add your handling code here:
    }                                              

    private void jButtonBill1000ActionPerformed(java.awt.event.ActionEvent evt) {                                                
        // TODO add your handling code here:
    }                                               

    private void ConfirmVMButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                
        jVMName.setText(VMNameText.getText());
        if (SpeRadioButton.isSelected())
            jRegOrSpeLabel.setText("Special Vending Machine");
        else
            jRegOrSpeLabel.setText("Regular Vending Machine");
    }                                               

    private void VMNameTextActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
    }                                          

    private void jButtonWithdrawActionPerformed(java.awt.event.ActionEvent evt) {                                                
        for (JSpinner spinner : mhSpinnerList) {
            spinner.setValue(0);
        }
    }                                               

    private void jButtonDepositActionPerformed(java.awt.event.ActionEvent evt) {                                               
        for (JSpinner spinner : mhSpinnerList) {
            spinner.setValue(0);
        }
    }                                              

    private void jButtonPrintTransactionActionPerformed(java.awt.event.ActionEvent evt) {                              
        // TODO add your handling code here:
    }                                                       

    private void jButtonPrintRestockActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }                                                   

    private void jRadioHotActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
    }                                         

    private void jRadioCaviarActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:
    }                                            

    private void jRadioJackSActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
    }                                           

    private void jRadioBarbecueActionPerformed(java.awt.event.ActionEvent evt) {                                               
        // TODO add your handling code here:
    }                                              

    private void jRadioAngusActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
    }                                           

    private void jRadioTapaActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
    }                                          

    private void jRadioCheesedActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // TODO add your handling code here:
    }                                             

    private void jRadioWagyuActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
    }                                           

    private void jRadioWhiteActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
    }                                           

    private void jRadioAmericanActionPerformed(java.awt.event.ActionEvent evt) {                                               
        // TODO add your handling code here:
    }                                              

    private void jRadioBeefsteakActionPerformed(java.awt.event.ActionEvent evt) {                                                
        // TODO add your handling code here:
    }                                               

    private void jRadioIcebergActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // TODO add your handling code here:
    }                                             

    private void jRadioMeltedActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:
    }                                            

    private void jRadioTrappistActionPerformed(java.awt.event.ActionEvent evt) {                                               
        // TODO add your handling code here:
    }                                              

    private void jRadioMozzarellaActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        // TODO add your handling code here:
    }                                                

    private void jRadioOnionActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
    }                                           

    private void jRadioWeinerActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:
    }                                            

    private void jRadioBronzeActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:
    }                                            

    private void jRadioBeyondActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:
    }                                            

    private void jRadioGrilledActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // TODO add your handling code here:
    }                                             

    private void jRadioWholewheatActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        // TODO add your handling code here:
    }                                                

    private void jRadioPotatoActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:
    }                                            

    private void jRadioRyeActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
    }                                         

    private void jRadioSesameActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:
    }                                            

    private void jCustomButton10ActionPerformed(java.awt.event.ActionEvent evt) {                                                
         jTabbedPaneItem.setSelectedIndex(0);
    }                                               

    private void jRadioSesame1ActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // TODO add your handling code here:
    }                                             

    private void jRadioRye1ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
    }                                          

    private void jRadioPotato1ActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // TODO add your handling code here:
    }                                             

    private void jRadioWholewheat1ActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        // TODO add your handling code here:
    }                                                 

    private void jRadioGrilled1ActionPerformed(java.awt.event.ActionEvent evt) {                                               
        // TODO add your handling code here:
    }                                              

    private void jRadioBeyond1ActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // TODO add your handling code here:
    }                                             

    private void jRadioBronze1ActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // TODO add your handling code here:
    }                                             

    private void jRadioWeiner1ActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // TODO add your handling code here:
    }                                             

    private void jRadioOnion1ActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:
    }                                            

    private void jRadioMozzarella1ActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        // TODO add your handling code here:
    }                                                 

    private void jRadioTrappist1ActionPerformed(java.awt.event.ActionEvent evt) {                                                
        // TODO add your handling code here:
    }                                               

    private void jRadioMelted1ActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // TODO add your handling code here:
    }                                             

    private void jRadioIceberg1ActionPerformed(java.awt.event.ActionEvent evt) {                                               
        // TODO add your handling code here:
    }                                              

    private void jRadioBeefsteak1ActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        // TODO add your handling code here:
    }                                                

    private void jRadioAmerican1ActionPerformed(java.awt.event.ActionEvent evt) {                                                
        // TODO add your handling code here:
    }                                               

    private void jRadioWhite1ActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:
    }                                            

    private void jRadioWagyu1ActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:
    }                                            

    private void jRadioCheesed1ActionPerformed(java.awt.event.ActionEvent evt) {                                               
        // TODO add your handling code here:
    }                                              

    private void jRadioTapa1ActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
    }                                           

    private void jRadioAngus1ActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:
    }                                            

    private void jRadioBarbecue1ActionPerformed(java.awt.event.ActionEvent evt) {                                                
        // TODO add your handling code here:
    }                                               

    private void jRadioJackS1ActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:
    }                                            

    private void jRadioCaviar1ActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // TODO add your handling code here:
    }                                             

    private void jRadioHot1ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
    }                                          

    private void jButtonConfirmRestockActionPerformed(java.awt.event.ActionEvent evt) {
        for (JRadioButton radio: restockRadioList){
            radio.setSelected(false);
        }
    }                                                     

    private void jButtonWithdrawAllActionPerformed(java.awt.event.ActionEvent evt) {                                                   
        for (JSpinner spinner : mhSpinnerList) {
            spinner.setValue(0);
        }
    }                                                  

    private void jButtonConfirmItemActionPerformed(java.awt.event.ActionEvent evt) {                                                   
        for (JSpinner spinner : itemSpinnerList) {
            spinner.setValue(0);
        }
    }                                                  

    private void jButtonCancelItemActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        for (JSpinner spinner : itemSpinnerList) {
            spinner.setValue(0);
        }
    }                                                 

    private void jButton5PotatoActionPerformed(java.awt.event.ActionEvent evt) {                                               
        // TODO add your handling code here:
    }                                              

    private void jButton4WholewheatActionPerformed(java.awt.event.ActionEvent evt) {                                                   
        // TODO add your handling code here:
    }                                                  

    private void jButton3RyeActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
    }                                           

    private void jButton2SesameActionPerformed(java.awt.event.ActionEvent evt) {                                               
        // TODO add your handling code here:
    }                                              

    private void jButton1BriocheActionPerformed(java.awt.event.ActionEvent evt) {                                                
        // TODO add your handling code here:
    }                                               

    private void jButtonActionPerformed(java.awt.event.ActionEvent evt, String number) {
        String currentText = jINewPriceTextField.getText();
        jINewPriceTextField.setText(currentText + number);
    }
    
	 /**
       * Initialize ItemStock labels into ArrayList
       */
    private void initStockLabels(){
        labelList.add(ItemStock1);
        labelList.add(ItemStock2);
        labelList.add(ItemStock3);
        labelList.add(ItemStock4);
        labelList.add(ItemStock5);
        labelList.add(ItemStock6);
        labelList.add(ItemStock7);
        labelList.add(ItemStock8);
        labelList.add(ItemStock9);
        labelList.add(ItemStock10);
        labelList.add(ItemStock11);
        labelList.add(ItemStock12);
        labelList.add(ItemStock13);
        labelList.add(ItemStock14);
        labelList.add(ItemStock15);
        labelList.add(ItemStock16);
        labelList.add(ItemStock17);
        labelList.add(ItemStock18);
        labelList.add(ItemStock19);
        labelList.add(ItemStock20);
        labelList.add(ItemStock21);
        labelList.add(ItemStock22);
        labelList.add(ItemStock23);
        labelList.add(ItemStock24);
        labelList.add(ItemStock25);
        labelList.add(ItemStock26);
        labelList.add(ItemStock27);
        labelList.add(ItemStock28);
        labelList.add(ItemStock29);
        labelList.add(ItemStock30);
    }
    
	/**
      * Initialize MH spinners into ArrayList
      */
    private void initMHSpinnerList(){
        mhSpinnerList.add(OnePesoSpinner);
        mhSpinnerList.add(FivePesoSpinner);
        mhSpinnerList.add(TenPesoSpinner);
        mhSpinnerList.add(TwentyPesoSpinner);
        mhSpinnerList.add(FiftyPesoSpinner);
        mhSpinnerList.add(OneHundredPesoSpinner);
        mhSpinnerList.add(FiveHundredPesoSpinner);
        mhSpinnerList.add(ThousandPesoSpinner);
        
        itemSpinnerList.add(BriocheSpinner);
        itemSpinnerList.add(SesameSpinner);
        itemSpinnerList.add(RyeSpinner);
        itemSpinnerList.add(WholewheatSpinner);
        itemSpinnerList.add(PotatoSpinner);

        itemSpinnerList.add(JBreadSpinner);
        itemSpinnerList.add(AngusSpinner);
        itemSpinnerList.add(WagyuSpinner);
        itemSpinnerList.add(TapaSpinner);
        itemSpinnerList.add(CheesedSpinner);

        itemSpinnerList.add(CanadianSpinner);
        itemSpinnerList.add(WeinerSpinner);
        itemSpinnerList.add(GrilledSpinner);
        itemSpinnerList.add(BronzeSpinner);
        itemSpinnerList.add(BeyondSpinner);

        itemSpinnerList.add(JBeefSpinner);
        itemSpinnerList.add(WhiteSpinner);
        itemSpinnerList.add(OnionSpinner);
        itemSpinnerList.add(TrappistSpinner);
        itemSpinnerList.add(MozzarellaSpinner);

        itemSpinnerList.add(BlueSpinner);
        itemSpinnerList.add(AmericanSpinner);
        itemSpinnerList.add(MeltedSpinner);
        itemSpinnerList.add(BeefsteakSpinner);
        itemSpinnerList.add(IcebergSpinner);

        itemSpinnerList.add(DillSpinner);
        itemSpinnerList.add(HotSpinner);
        itemSpinnerList.add(BarbecueSpinner);
        itemSpinnerList.add(CaviarSpinner);
        itemSpinnerList.add(JSauceSpinner);
    }
    
	/**
      * Initialize item buttons into ArrayList
      */
    private void initItemList(){
        itemButtonList.add(jButton1Brioche);
        itemButtonList.add(jButton2Sesame);
        itemButtonList.add(jButton3Rye);
        itemButtonList.add(jButton4Wholewheat);
        itemButtonList.add(jButton5Potato);
        itemButtonList.add(jButton6Jack);
        itemButtonList.add(jButton7Angus);
        itemButtonList.add(jButton8Wagyu);
        itemButtonList.add(jButton9Tapa);
        itemButtonList.add(jButton10Cheesed);
        itemButtonList.add(jButton11Canadian);
        itemButtonList.add(jButton12Weiner);
        itemButtonList.add(jButton13Grilled);
        itemButtonList.add(jButton14Bronze);
        itemButtonList.add(jButton15Beyond);
        itemButtonList.add(jButton16JackBeef);
        itemButtonList.add(jButton17White);
        itemButtonList.add(jButton18Onion);
        itemButtonList.add(jButton19Trappist);
        itemButtonList.add(jButton20Mozzarella);
        itemButtonList.add(jButton21Blue);
        itemButtonList.add(jButton22American);
        itemButtonList.add(jButton23Melted);
        itemButtonList.add(jButton24Beefsteak);
        itemButtonList.add(jButton25Iceberg);
        itemButtonList.add(jButton26Dill);
        itemButtonList.add(jButton27Hot);
        itemButtonList.add(jButton28Barbecue);
        itemButtonList.add(jButton29Caviar);
        itemButtonList.add(jButton30JackSauce);
    }
    
	/**
      * Initialize money buttons into ArrayList
      */
    private void initMoneyList(){
        moneyList.add(jBill1);
        moneyList.add(jBill5);
        moneyList.add(jBill10);
        moneyList.add(jBill20);
        moneyList.add(jBill50);
        moneyList.add(jBill100);
        moneyList.add(jBill500);
        moneyList.add(jBill1000);
    }
    
	/**
      * Initialize price displays into ArrayList
      */
    private void initPriceList(){
        priceList.add(ItemPrice1);
        priceList.add(ItemPrice2);
        priceList.add(ItemPrice3);
        priceList.add(ItemPrice4);
        priceList.add(ItemPrice5);
        priceList.add(ItemPrice6);
        priceList.add(ItemPrice7);
        priceList.add(ItemPrice8);
        priceList.add(ItemPrice9);
        priceList.add(ItemPrice10);
        priceList.add(ItemPrice11);
        priceList.add(ItemPrice12);
        priceList.add(ItemPrice13);
        priceList.add(ItemPrice14);
        priceList.add(ItemPrice15);
        priceList.add(ItemPrice16);
        priceList.add(ItemPrice17);
        priceList.add(ItemPrice18);
        priceList.add(ItemPrice19);
        priceList.add(ItemPrice20);
        priceList.add(ItemPrice21);
        priceList.add(ItemPrice22);
        priceList.add(ItemPrice23);
        priceList.add(ItemPrice24);
        priceList.add(ItemPrice25);
        priceList.add(ItemPrice26);
        priceList.add(ItemPrice27);
        priceList.add(ItemPrice28);
        priceList.add(ItemPrice29);
        priceList.add(ItemPrice30);
    }
    
	/**
      * Initialize item radio buttons into ArrayList
      */
    private void initRadioList(){
        restockRadioList.add(jRadioBrioche);
        restockRadioList.add(jRadioSesame);
        restockRadioList.add(jRadioRye);
        restockRadioList.add(jRadioWholewheat);
        restockRadioList.add(jRadioPotato);        
        restockRadioList.add(jRadioJackB);
        restockRadioList.add(jRadioAngus);
        restockRadioList.add(jRadioWagyu);
        restockRadioList.add(jRadioTapa);
        restockRadioList.add(jRadioCheesed);
        restockRadioList.add(jRadioCanadian);
        restockRadioList.add(jRadioWeiner);
        restockRadioList.add(jRadioGrilled);
        restockRadioList.add(jRadioBronze);
        restockRadioList.add(jRadioBeyond);    
        restockRadioList.add(jRadioJackBf);
        restockRadioList.add(jRadioWhite);
        restockRadioList.add(jRadioOnion);
        restockRadioList.add(jRadioTrappist);
        restockRadioList.add(jRadioMozzarella);        
        restockRadioList.add(jRadioBlue);
        restockRadioList.add(jRadioAmerican);
        restockRadioList.add(jRadioMelted);
        restockRadioList.add(jRadioBeefsteak);
        restockRadioList.add(jRadioIceberg);       
        restockRadioList.add(jRadioDill);
        restockRadioList.add(jRadioHot);
        restockRadioList.add(jRadioBarbecue);
        restockRadioList.add(jRadioCaviar);
        restockRadioList.add(jRadioJackS);         
        
        repriceRadioList.add(jRadioBrioche1);
        repriceRadioList.add(jRadioSesame1);
        repriceRadioList.add(jRadioRye1);
        repriceRadioList.add(jRadioWholewheat1);
        repriceRadioList.add(jRadioPotato1);        
        repriceRadioList.add(jRadioJackB1);
        repriceRadioList.add(jRadioAngus1);
        repriceRadioList.add(jRadioWagyu1);
        repriceRadioList.add(jRadioTapa1);
        repriceRadioList.add(jRadioCheesed1);
        repriceRadioList.add(jRadioCanadian1);
        repriceRadioList.add(jRadioWeiner1);
        repriceRadioList.add(jRadioGrilled1);
        repriceRadioList.add(jRadioBronze1);
        repriceRadioList.add(jRadioBeyond1);    
        repriceRadioList.add(jRadioJackBf1);
        repriceRadioList.add(jRadioWhite1);
        repriceRadioList.add(jRadioOnion1);
        repriceRadioList.add(jRadioTrappist1);
        repriceRadioList.add(jRadioMozzarella1);        
        repriceRadioList.add(jRadioBlue1);
        repriceRadioList.add(jRadioAmerican1);
        repriceRadioList.add(jRadioMelted1);
        repriceRadioList.add(jRadioBeefsteak1);
        repriceRadioList.add(jRadioIceberg1);       
        repriceRadioList.add(jRadioDill1);
        repriceRadioList.add(jRadioHot1);
        repriceRadioList.add(jRadioBarbecue1);
        repriceRadioList.add(jRadioCaviar1);
        repriceRadioList.add(jRadioJackS1);
    }

	/**
      * Initialize money radio buttons into ArrayList
      */
    private void initMoneyInputList(){
        moneyInputList.add(jButtonBill1);
        moneyInputList.add(jButtonBill5);
        moneyInputList.add(jButtonBill10);
        moneyInputList.add(jButtonBill20);
        moneyInputList.add(jButtonBill50);
        moneyInputList.add(jButtonBill100);
        moneyInputList.add(jButtonBill500);
        moneyInputList.add(jButtonBill1000);
    }
    
	/**
      * Initialize recipe buttons into ArrayList
      */
    private void initRecipeButtonList(){
        recipeButtonList.add(jButton1Classic);
        recipeButtonList.add(jButton2Cheesy);
        recipeButtonList.add(jButton3Beyond);
        recipeButtonList.add(jButton4Gourmet);
        recipeButtonList.add(jButton5Jack);
        recipeButtonList.add(jButton6Meat);
        recipeButtonList.add(jButton7Spicy);
        recipeButtonList.add(jButton8Salmon);
        recipeButtonList.add(jButton9Turkey);
    }

   public JButton getCreateButton() {
		return this.ConfirmVMButton;
	}
	
	public JButton getItemButton() {
		return this.jButtonConfirmItem;
	}
	
	public JButton getItemCancelButton() {
		return this.jButtonCancelItem;
	}
	
	public JButton getRecipeCancelButton() {
		return this.jButtonCancelBurger;
	}
	
	public JButton getRecipeButton() {
		return this.jButtonConfirmBurger1;
	}
	
	public JButton getRestockButton() {
		return this.jButtonConfirmRestock;
	}
	
	public JButton getRepriceButton() {
		return this.jButtonConfirmReprice;
	}
	
	public JButton getDepositButton() {
		return this.jButtonDeposit;
	}
	
	public JButton getWithdrawButton() {
		return this.jButtonWithdraw;
	}
	
	public JButton getWithdrawAllButton() {
		return this.jButtonWithdrawAll;
	}
	
	public JButton getPrintTransacButton() {
		return this.jButtonPrintTransaction;
	}
	
	public JButton getPrintRestockButton() {
		return this.jButtonPrintRestock;
	}
	
	public JRadioButton getSpeRadioButton() {
		return this.SpeRadioButton;
	}
	
	public JTextField getVMNameText() {
		return this.VMNameText;
	}
	
	public JTextArea getTextAreaReceipt() {
		return this.jTextAreaReceipt;
	}
	
	public ArrayList<JLabel> getLabels() {
		return this.labelList;
	}
	
	public ArrayList<JSpinner> getItemSpinners() {
		return this.itemSpinnerList;
	}
	
	public ArrayList<JSpinner> getMHSpinners() {
		return this.mhSpinnerList;
	}
	
	public ArrayList<JButton> getItemButtons() {
		return this.itemButtonList;
	} 
	
	public ArrayList<JButton> getRecipeButtons() {
		return this.recipeButtonList;
	}
	
	public ArrayList<JButton> getMoneyButtons() {
		return this.moneyInputList;
	}
	
	public ArrayList<JRadioButton> getRestockButtons() {
		return this.restockRadioList;
	}
	
	public ArrayList<JRadioButton> getRepriceButtons() {
		return this.repriceRadioList;
	}
	
	public JTextField getNewPrice() {
		return this.jINewPriceTextField;
	}
	
	/**
      * Prints text onto the display text area console
	  * @param text The text to be displayed
      */
	public void displayText(String text) {
        this.jTextAreaConsole.append(text + "\n");
    }

	/**
      * Prints text onto the print text area console
	  * @param text The text to be displayed
      */
    public void displayPrint(String text) {  
	    this.jTextAreaReceipt.append(text + "\n");
	}
	
	/**
      * Clears the print text area console
      */
    public void clearPrint() {  
	    this.jTextAreaReceipt.setText(""); 
	}		 
	
	/**
      * Updates item stock displays according to stored data in model
	  * @param itemStock The 2D ArrayList of items and their stocks
      */
	public void updateItemStock(ArrayList<ArrayList<Object>> itemStock) {
		int stock = 0;
		int i = 0;
		
        for (JLabel l : this.labelList) {
            if (i < itemStock.size()) {
                stock = (int) itemStock.get(i).get(1);
                l.setText(String.valueOf(stock));
                i++;
            } 
			
			else 
                l.setText("...");
        }
	}

	/**
      * Updates item cash displays according to stored data in model
	  * @param cashStock The 2D int array of bills and their stocks
      */
    public void updateCashStock(int[][] cashStock) {
		int value = 0;
		
		for (int i = 0; i < cashStock.length; i++) {
            value = cashStock[i][1];
            this.moneyList.get(7 - i).setText("" + value);
        }
	}
	
	/**
      * Updates item price displays according to stored data in model
	  * @param itemPrices The 2D ArrayList of items and their prices
      */
    public void updatePrices(ArrayList<ArrayList<Object>> itemPrices) {
        int price = 0;
		int i = 0;
		
        for (JLabel l : this.priceList) {
            if (i < itemPrices.size()) {
                price = (int) itemPrices.get(i).get(1);
                l.setText(String.valueOf(price));
                i++;
            } 
			
			else 
                l.setText("...");
        }
	}

    // Variables declaration - do not modify                     
    private javax.swing.JSpinner AmericanSpinner;
    private javax.swing.JSpinner AngusSpinner;
    private javax.swing.JSpinner BarbecueSpinner;
    private javax.swing.JSpinner BeefsteakSpinner;
    private javax.swing.JSpinner BeyondSpinner;
    private javax.swing.JSpinner BlueSpinner;
    private javax.swing.JSpinner BriocheSpinner;
    private javax.swing.JSpinner BronzeSpinner;
    private javax.swing.JSpinner CanadianSpinner;
    private javax.swing.JSpinner CaviarSpinner;
    private javax.swing.JSpinner CheesedSpinner;
    private javax.swing.JButton ConfirmVMButton;
    private javax.swing.JLabel CreateVMTitle1;
    private javax.swing.JPanel CreateVendingMachinePanel;
    private javax.swing.JSpinner DillSpinner;
    private javax.swing.JSpinner FiftyPesoSpinner;
    private javax.swing.JSpinner FiveHundredPesoSpinner;
    private javax.swing.JSpinner FivePesoSpinner;
    private javax.swing.JSpinner GrilledSpinner;
    private javax.swing.JSpinner HotSpinner;
    private javax.swing.JSpinner IcebergSpinner;
    private javax.swing.JLabel ItemName33;
    private javax.swing.JPanel ItemPanel;
    private javax.swing.JLabel ItemPic1;
    private javax.swing.JLabel ItemPic10;
    private javax.swing.JLabel ItemPic11;
    private javax.swing.JLabel ItemPic12;
    private javax.swing.JLabel ItemPic13;
    private javax.swing.JLabel ItemPic14;
    private javax.swing.JLabel ItemPic15;
    private javax.swing.JLabel ItemPic16;
    private javax.swing.JLabel ItemPic17;
    private javax.swing.JLabel ItemPic18;
    private javax.swing.JLabel ItemPic19;
    private javax.swing.JLabel ItemPic2;
    private javax.swing.JLabel ItemPic20;
    private javax.swing.JLabel ItemPic21;
    private javax.swing.JLabel ItemPic22;
    private javax.swing.JLabel ItemPic23;
    private javax.swing.JLabel ItemPic24;
    private javax.swing.JLabel ItemPic25;
    private javax.swing.JLabel ItemPic26;
    private javax.swing.JLabel ItemPic27;
    private javax.swing.JLabel ItemPic28;
    private javax.swing.JLabel ItemPic29;
    private javax.swing.JLabel ItemPic3;
    private javax.swing.JLabel ItemPic30;
    private javax.swing.JLabel ItemPic4;
    private javax.swing.JLabel ItemPic5;
    private javax.swing.JLabel ItemPic6;
    private javax.swing.JLabel ItemPic7;
    private javax.swing.JLabel ItemPic8;
    private javax.swing.JLabel ItemPic9;
    private javax.swing.JLabel ItemPrice1;
    private javax.swing.JLabel ItemPrice10;
    private javax.swing.JLabel ItemPrice11;
    private javax.swing.JLabel ItemPrice12;
    private javax.swing.JLabel ItemPrice13;
    private javax.swing.JLabel ItemPrice14;
    private javax.swing.JLabel ItemPrice15;
    private javax.swing.JLabel ItemPrice16;
    private javax.swing.JLabel ItemPrice17;
    private javax.swing.JLabel ItemPrice18;
    private javax.swing.JLabel ItemPrice19;
    private javax.swing.JLabel ItemPrice2;
    private javax.swing.JLabel ItemPrice20;
    private javax.swing.JLabel ItemPrice21;
    private javax.swing.JLabel ItemPrice22;
    private javax.swing.JLabel ItemPrice23;
    private javax.swing.JLabel ItemPrice24;
    private javax.swing.JLabel ItemPrice25;
    private javax.swing.JLabel ItemPrice26;
    private javax.swing.JLabel ItemPrice27;
    private javax.swing.JLabel ItemPrice28;
    private javax.swing.JLabel ItemPrice29;
    private javax.swing.JLabel ItemPrice3;
    private javax.swing.JLabel ItemPrice30;
    private javax.swing.JLabel ItemPrice4;
    private javax.swing.JLabel ItemPrice5;
    private javax.swing.JLabel ItemPrice6;
    private javax.swing.JLabel ItemPrice7;
    private javax.swing.JLabel ItemPrice8;
    private javax.swing.JLabel ItemPrice9;
    private javax.swing.JScrollPane ItemRack;
    private javax.swing.JLabel ItemStock1;
    private javax.swing.JLabel ItemStock10;
    private javax.swing.JLabel ItemStock11;
    private javax.swing.JLabel ItemStock12;
    private javax.swing.JLabel ItemStock13;
    private javax.swing.JLabel ItemStock14;
    private javax.swing.JLabel ItemStock15;
    private javax.swing.JLabel ItemStock16;
    private javax.swing.JLabel ItemStock17;
    private javax.swing.JLabel ItemStock18;
    private javax.swing.JLabel ItemStock19;
    private javax.swing.JLabel ItemStock2;
    private javax.swing.JLabel ItemStock20;
    private javax.swing.JLabel ItemStock21;
    private javax.swing.JLabel ItemStock22;
    private javax.swing.JLabel ItemStock23;
    private javax.swing.JLabel ItemStock24;
    private javax.swing.JLabel ItemStock25;
    private javax.swing.JLabel ItemStock26;
    private javax.swing.JLabel ItemStock27;
    private javax.swing.JLabel ItemStock28;
    private javax.swing.JLabel ItemStock29;
    private javax.swing.JLabel ItemStock3;
    private javax.swing.JLabel ItemStock30;
    private javax.swing.JLabel ItemStock4;
    private javax.swing.JLabel ItemStock5;
    private javax.swing.JLabel ItemStock6;
    private javax.swing.JLabel ItemStock7;
    private javax.swing.JLabel ItemStock8;
    private javax.swing.JLabel ItemStock9;
    private javax.swing.JSpinner JBeefSpinner;
    private javax.swing.JSpinner JBreadSpinner;
    private javax.swing.JSpinner JSauceSpinner;
    private javax.swing.JSpinner MeltedSpinner;
    private javax.swing.JSpinner MozzarellaSpinner;
    private javax.swing.JSpinner OneHundredPesoSpinner;
    private javax.swing.JSpinner OnePesoSpinner;
    private javax.swing.JSpinner OnionSpinner;
    private javax.swing.JSpinner PotatoSpinner;
    private javax.swing.JLabel RecipePic1;
    private javax.swing.JLabel RecipePic10;
    private javax.swing.JLabel RecipePic2;
    private javax.swing.JLabel RecipePic3;
    private javax.swing.JLabel RecipePic4;
    private javax.swing.JLabel RecipePic5;
    private javax.swing.JLabel RecipePic6;
    private javax.swing.JLabel RecipePic7;
    private javax.swing.JLabel RecipePic8;
    private javax.swing.JLabel RecipePic9;
    private javax.swing.JRadioButton RegRadioButton;
    private javax.swing.JSpinner RyeSpinner;
    private javax.swing.JSpinner SesameSpinner;
    private javax.swing.JRadioButton SpeRadioButton;
    private javax.swing.JSpinner TapaSpinner;
    private javax.swing.JSpinner TenPesoSpinner;
    private javax.swing.JPanel TestVendingMachinePanel;
    private javax.swing.JSpinner ThousandPesoSpinner;
    private javax.swing.JSpinner TrappistSpinner;
    private javax.swing.JSpinner TwentyPesoSpinner;
    private javax.swing.JTextField VMNameText;
    private javax.swing.JSpinner WagyuSpinner;
    private javax.swing.JSpinner WeinerSpinner;
    private javax.swing.JSpinner WhiteSpinner;
    private javax.swing.JSpinner WholewheatSpinner;
    private javax.swing.ButtonGroup buttonGroup;
    private javax.swing.ButtonGroup buttonGroupItems;
    private javax.swing.JLabel jBill1;
    private javax.swing.JLabel jBill10;
    private javax.swing.JLabel jBill100;
    private javax.swing.JLabel jBill1000;
    private javax.swing.JLabel jBill20;
    private javax.swing.JLabel jBill5;
    private javax.swing.JLabel jBill50;
    private javax.swing.JLabel jBill500;
    private javax.swing.JLabel jBillLabel1;
    private javax.swing.JLabel jBillLabel10;
    private javax.swing.JLabel jBillLabel2;
    private javax.swing.JLabel jBillLabel5;
    private javax.swing.JLabel jBillLabel6;
    private javax.swing.JLabel jBillLabel7;
    private javax.swing.JLabel jBillLabel8;
    private javax.swing.JLabel jBillLabel9;
    private javax.swing.JButton jButton0;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10Cheesed;
    private javax.swing.JButton jButton11Canadian;
    private javax.swing.JButton jButton12Weiner;
    private javax.swing.JButton jButton13Grilled;
    private javax.swing.JButton jButton14Bronze;
    private javax.swing.JButton jButton15Beyond;
    private javax.swing.JButton jButton16JackBeef;
    private javax.swing.JButton jButton17White;
    private javax.swing.JButton jButton18Onion;
    private javax.swing.JButton jButton19Trappist;
    private javax.swing.JButton jButton1Brioche;
    private javax.swing.JButton jButton1Classic;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20Mozzarella;
    private javax.swing.JButton jButton21Blue;
    private javax.swing.JButton jButton22American;
    private javax.swing.JButton jButton23Melted;
    private javax.swing.JButton jButton24Beefsteak;
    private javax.swing.JButton jButton25Iceberg;
    private javax.swing.JButton jButton26Dill;
    private javax.swing.JButton jButton27Hot;
    private javax.swing.JButton jButton28Barbecue;
    private javax.swing.JButton jButton29Caviar;
    private javax.swing.JButton jButton2Cheesy;
    private javax.swing.JButton jButton2Sesame;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton30JackSauce;
    private javax.swing.JButton jButton3Beyond;
    private javax.swing.JButton jButton3Rye;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton4Gourmet;
    private javax.swing.JButton jButton4Wholewheat;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton5Jack;
    private javax.swing.JButton jButton5Potato;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton6Jack;
    private javax.swing.JButton jButton6Meat;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton7Angus;
    private javax.swing.JButton jButton7Spicy;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton8Salmon;
    private javax.swing.JButton jButton8Wagyu;
    private javax.swing.JButton jButton9;
    private javax.swing.JButton jButton9Tapa;
    private javax.swing.JButton jButton9Turkey;
    private javax.swing.JButton jButtonBill1;
    private javax.swing.JButton jButtonBill10;
    private javax.swing.JButton jButtonBill100;
    private javax.swing.JButton jButtonBill1000;
    private javax.swing.JButton jButtonBill20;
    private javax.swing.JButton jButtonBill5;
    private javax.swing.JButton jButtonBill50;
    private javax.swing.JButton jButtonBill500;
    private javax.swing.JButton jButtonCancelBurger;
    private javax.swing.JButton jButtonCancelItem;
    private javax.swing.JButton jButtonClear;
    private javax.swing.JButton jButtonConfirmBurger1;
    private javax.swing.JButton jButtonConfirmItem;
    private javax.swing.JButton jButtonConfirmReprice;
    private javax.swing.JButton jButtonConfirmRestock;
    private javax.swing.JButton jButtonDeposit;
    private javax.swing.JButton jButtonPrintRestock;
    private javax.swing.JButton jButtonPrintTransaction;
    private javax.swing.JButton jButtonWithdraw;
    private javax.swing.JButton jButtonWithdrawAll;
    private javax.swing.JButton jCustomButton10;
    private javax.swing.JPanel jDisplayCashBox;
    private javax.swing.JTextField jINewPriceTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPanel jPanelRecipe;
    private javax.swing.JRadioButton jRadioAmerican;
    private javax.swing.JRadioButton jRadioAmerican1;
    private javax.swing.JRadioButton jRadioAngus;
    private javax.swing.JRadioButton jRadioAngus1;
    private javax.swing.JRadioButton jRadioBarbecue;
    private javax.swing.JRadioButton jRadioBarbecue1;
    private javax.swing.JRadioButton jRadioBeefsteak;
    private javax.swing.JRadioButton jRadioBeefsteak1;
    private javax.swing.JRadioButton jRadioBeyond;
    private javax.swing.JRadioButton jRadioBeyond1;
    private javax.swing.JRadioButton jRadioBlue;
    private javax.swing.JRadioButton jRadioBlue1;
    private javax.swing.JRadioButton jRadioBrioche;
    private javax.swing.JRadioButton jRadioBrioche1;
    private javax.swing.JRadioButton jRadioBronze;
    private javax.swing.JRadioButton jRadioBronze1;
    private javax.swing.JRadioButton jRadioCanadian;
    private javax.swing.JRadioButton jRadioCanadian1;
    private javax.swing.JRadioButton jRadioCaviar;
    private javax.swing.JRadioButton jRadioCaviar1;
    private javax.swing.JRadioButton jRadioCheesed;
    private javax.swing.JRadioButton jRadioCheesed1;
    private javax.swing.JRadioButton jRadioDill;
    private javax.swing.JRadioButton jRadioDill1;
    private javax.swing.JRadioButton jRadioGrilled;
    private javax.swing.JRadioButton jRadioGrilled1;
    private javax.swing.JRadioButton jRadioHot;
    private javax.swing.JRadioButton jRadioHot1;
    private javax.swing.JRadioButton jRadioIceberg;
    private javax.swing.JRadioButton jRadioIceberg1;
    private javax.swing.JRadioButton jRadioJackB;
    private javax.swing.JRadioButton jRadioJackB1;
    private javax.swing.JRadioButton jRadioJackBf;
    private javax.swing.JRadioButton jRadioJackBf1;
    private javax.swing.JRadioButton jRadioJackS;
    private javax.swing.JRadioButton jRadioJackS1;
    private javax.swing.JRadioButton jRadioMelted;
    private javax.swing.JRadioButton jRadioMelted1;
    private javax.swing.JRadioButton jRadioMozzarella;
    private javax.swing.JRadioButton jRadioMozzarella1;
    private javax.swing.JRadioButton jRadioOnion;
    private javax.swing.JRadioButton jRadioOnion1;
    private javax.swing.JRadioButton jRadioPotato;
    private javax.swing.JRadioButton jRadioPotato1;
    private javax.swing.JRadioButton jRadioRye;
    private javax.swing.JRadioButton jRadioRye1;
    private javax.swing.JRadioButton jRadioSesame;
    private javax.swing.JRadioButton jRadioSesame1;
    private javax.swing.JRadioButton jRadioTapa;
    private javax.swing.JRadioButton jRadioTapa1;
    private javax.swing.JRadioButton jRadioTrappist;
    private javax.swing.JRadioButton jRadioTrappist1;
    private javax.swing.JRadioButton jRadioWagyu;
    private javax.swing.JRadioButton jRadioWagyu1;
    private javax.swing.JRadioButton jRadioWeiner;
    private javax.swing.JRadioButton jRadioWeiner1;
    private javax.swing.JRadioButton jRadioWhite;
    private javax.swing.JRadioButton jRadioWhite1;
    private javax.swing.JRadioButton jRadioWholewheat;
    private javax.swing.JRadioButton jRadioWholewheat1;
    private javax.swing.JLabel jRegOrSpeLabel;
    private javax.swing.JPanel jRestockItemsPanel;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPaneItem;
    private javax.swing.JTabbedPane jTabbedPaneRestock;
    private javax.swing.JTextArea jTextAreaConsole;
    private javax.swing.JScrollPane jTextAreaPane;
    private javax.swing.JScrollPane jTextAreaPane1;
    private javax.swing.JTextArea jTextAreaReceipt;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JLabel jVMName;
    // End of variables declaration                   
}